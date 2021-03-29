package com.rainbowland.portal.rpc.service;

import bgs.protocol.authentication.v1.AuthenticationServiceProto;
import bgs.protocol.challenge.v1.ChallengeServiceProto;
import bnet.protocol.EntityProto;
import bnet.protocol.RpcProto;
import com.google.protobuf.ByteString;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;
import com.rainbowland.common.RpcErrorCode;
import com.rainbowland.portal.boot.PortalProperties;
import com.rainbowland.portal.rpc.NettyRpcChannel;
import com.rainbowland.portal.rpc.NettyRpcController;
import com.rainbowland.portal.rpc.RpcSession;
import com.rainbowland.portal.utils.LocaleConstant;
import com.rainbowland.service.auth.AuthService;
import com.rainbowland.service.auth.domain.BattlenetAccount;
import com.rainbowland.utils.SecureUtils;
import com.rainbowland.utils.SysProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Optional;

@Slf4j
@Getter
@Setter
@RequiredArgsConstructor
public class AuthenticationService implements AuthenticationServiceProto.AuthenticationService.Interface {


    private AuthenticationServiceProto.AuthenticationListener.Interface authenticationListener = AuthenticationServiceProto.AuthenticationListener.newStub(new NettyRpcChannel());
    private ChallengeServiceProto.ChallengeListener.Interface challengeListener = ChallengeServiceProto.ChallengeListener.newStub(new NettyRpcChannel());


    private final PortalProperties portalProperties;


    private final AuthService service;

    @Override
    public void logon(RpcController controller, AuthenticationServiceProto.LogonRequest request, RpcCallback<RpcProto.NoData> done) {
        NettyRpcController statusController = (NettyRpcController) controller;
        if (!SysProperties.PORTAL_WOW_PROGRAM_NAME.equals(request.getProgram())) {
            log.info("Attempted to log in with game other than WoW (using {})!", request.getProgram());
            statusController.setFailed(RpcErrorCode.ERROR_BAD_PROGRAM);
            done.run(RpcProto.NoData.getDefaultInstance());
            return;
        }

        if (!LocaleConstant.isValidLocale(request.getLocale())) {
            log.info("Attempted to log in with unsupported locale (using {})!", request.getLocale());
            statusController.setFailed(RpcErrorCode.ERROR_BAD_LOCALE);
            done.run(RpcProto.NoData.getDefaultInstance());
            return;
        }

        if (!SysProperties.PORTAL_SUPPORTED_PLATFORM_LIST.contains(request.getPlatform())) {
            log.info("attempted to log in from an unsupported platform (using {})!", request.getPlatform());
            statusController.setFailed(RpcErrorCode.ERROR_BAD_PLATFORM);
            done.run(RpcProto.NoData.getDefaultInstance());
            return;
        }

        RpcSession rpcSession = statusController.getRpcSession();
        rpcSession.setLocale(request.getLocale());
        rpcSession.setPlatform(request.getPlatform());
        rpcSession.setBuild(request.getApplicationVersion());

        if (request.hasCachedWebCredentials()) {
            AuthenticationServiceProto.VerifyWebCredentialsRequest parameter = AuthenticationServiceProto.VerifyWebCredentialsRequest.newBuilder()
                    .setWebCredentials(request.getCachedWebCredentials()).build();
            this.verifyWebCredentials(controller, parameter, done);
        } else {
            ChallengeServiceProto.ChallengeExternalRequest challengeExternalRequest = ChallengeServiceProto.ChallengeExternalRequest.newBuilder()
                    .setPayloadType("web_auth_url")
                    .setPayload(ByteString.copyFromUtf8(getWebAuthUrl())).build();
            challengeListener.onExternalChallenge(statusController, challengeExternalRequest, null);
            done.run(RpcProto.NoData.getDefaultInstance());
        }
    }


    @Override
    public void moduleNotify(RpcController controller, AuthenticationServiceProto.ModuleNotification request, RpcCallback<RpcProto.NoData> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(RpcProto.NoData.getDefaultInstance());
    }

    @Override
    public void moduleMessage(RpcController controller, AuthenticationServiceProto.ModuleMessageRequest request, RpcCallback<RpcProto.NoData> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(RpcProto.NoData.getDefaultInstance());
    }

    @Override
    public void selectGameAccountDEPRECATED(RpcController controller, EntityProto.EntityId request, RpcCallback<RpcProto.NoData> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(RpcProto.NoData.getDefaultInstance());
    }

    @Override
    public void generateSSOToken(RpcController controller, AuthenticationServiceProto.GenerateSSOTokenRequest request, RpcCallback<AuthenticationServiceProto.GenerateSSOTokenResponse> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(AuthenticationServiceProto.GenerateSSOTokenResponse.getDefaultInstance());
    }

    @Override
    public void selectGameAccount(RpcController controller, AuthenticationServiceProto.SelectGameAccountRequest request, RpcCallback<RpcProto.NoData> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(RpcProto.NoData.getDefaultInstance());
    }

    @Override
    public void verifyWebCredentials(RpcController controller, AuthenticationServiceProto.VerifyWebCredentialsRequest request, RpcCallback<RpcProto.NoData> done) {
        NettyRpcController statusController = (NettyRpcController) controller;
        if (request.getWebCredentials().isEmpty()) {
            statusController.setFailed(RpcErrorCode.ERROR_DENIED);
            done.run(RpcProto.NoData.newBuilder().build());
            return;
        }
        String loginTicket = request.getWebCredentials().toStringUtf8();
        service.queryBattleNetAccountByLoginTicket(loginTicket)
                .switchIfEmpty(Mono.just(new BattlenetAccount()))
                .subscribe(battleNetAccount -> {
                    Long expiry = battleNetAccount.getLoginTicketExpiry();
                    boolean banded = battleNetAccount.getBanned() != null && battleNetAccount.getBanned();
                    boolean permanentBanned = battleNetAccount.getPermanentBanned() != null && battleNetAccount.getPermanentBanned();;
                    if (battleNetAccount.getId() == null) {
                        statusController.setFailed(RpcErrorCode.ERROR_DENIED);
                    } else if (Optional.ofNullable(expiry).map(e -> Instant.now().isAfter(Instant.ofEpochMilli(e))).orElse(false)) {
                        statusController.setFailed(RpcErrorCode.ERROR_TIMED_OUT);
                    } else if (banded) {
                        statusController.setFailed(RpcErrorCode.ERROR_GAME_ACCOUNT_SUSPENDED);
                    } else if (permanentBanned) {
                        statusController.setFailed(RpcErrorCode.ERROR_GAME_ACCOUNT_BANNED);

                    } else {
                        AuthenticationServiceProto.LogonResult.Builder resultBuilder = AuthenticationServiceProto.LogonResult.newBuilder()
                                .setErrorCode(RpcErrorCode.STATUS_OK)
                                .setAccountId(EntityProto.EntityId.newBuilder()
                                        .setLow(battleNetAccount.getId())
                                        .setHigh(0x100000000000000L).build())
                                .setSessionKey(ByteString.copyFrom(SecureUtils.generateRandomBytes(SysProperties.PORTAL_SESSION_KEY_LENGTH)));

                        battleNetAccount.getGameAccounts().forEach(account -> {
                            resultBuilder.addGameAccountId(EntityProto.EntityId.newBuilder()
                                    .setLow(account.getId())
                                    .setHigh(0x200000200576F57L).build());
                        });
                        if (StringUtils.hasText(battleNetAccount.getLockCountry())) {
                            resultBuilder.setGeoipCountry(battleNetAccount.getLockCountry());
                        }
                        authenticationListener.onLogonComplete(statusController, resultBuilder.build(), response -> {
                        });
                        statusController.getRpcSession().setAuthorized(true);
                        //Maybe remove to the cache service.
                        statusController.getRpcSession().setAttachment(RpcSession.AUTHORIZED_USER, battleNetAccount);
                        done.run(RpcProto.NoData.getDefaultInstance());
                    }

                }, throwable -> {
                    log.error("Call loginTicketForBattleNetAccount error", throwable);
                    statusController.setFailed(RpcErrorCode.ERROR_DENIED);
                    done.run(RpcProto.NoData.getDefaultInstance());
                });

    }


    @Override
    public void generateWebCredentials(RpcController controller, AuthenticationServiceProto.GenerateWebCredentialsRequest request, RpcCallback<AuthenticationServiceProto.GenerateWebCredentialsResponse> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(AuthenticationServiceProto.GenerateWebCredentialsResponse.getDefaultInstance());
    }

    private String getWebAuthUrl() {
        StringBuilder portalUrl = new StringBuilder(portalProperties.getPortalUrl());
        while (portalUrl.charAt(portalUrl.length() - 1) == '/') {
            portalUrl.deleteCharAt(portalUrl.length() - 1);
        }
        return portalUrl.append("/bnetserver/login/").toString();
    }


}


