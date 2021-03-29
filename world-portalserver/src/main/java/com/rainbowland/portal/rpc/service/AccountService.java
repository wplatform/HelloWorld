package com.rainbowland.portal.rpc.service;


import bgs.protocol.account.v1.AccountProto;
import bgs.protocol.account.v1.AccountServiceProto;
import bnet.protocol.RpcProto;
import com.google.protobuf.RpcCallback;
import com.google.protobuf.RpcController;
import com.rainbowland.common.RpcErrorCode;
import com.rainbowland.portal.rpc.NettyRpcController;
import com.rainbowland.portal.rpc.RpcSession;
import com.rainbowland.service.auth.domain.BattlenetAccount;

public class AccountService implements AccountServiceProto.AccountService.Interface {
    @Override
    public void resolveAccount(RpcController controller, AccountServiceProto.ResolveAccountRequest request, RpcCallback<AccountServiceProto.ResolveAccountResponse> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(AccountServiceProto.ResolveAccountResponse.getDefaultInstance());
    }

    @Override
    public void subscribe(RpcController controller, AccountServiceProto.SubscriptionUpdateRequest request, RpcCallback<AccountServiceProto.SubscriptionUpdateResponse> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(AccountServiceProto.SubscriptionUpdateResponse.getDefaultInstance());
    }

    @Override
    public void unsubscribe(RpcController controller, AccountServiceProto.SubscriptionUpdateRequest request, RpcCallback<RpcProto.NoData> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(RpcProto.NoData.getDefaultInstance());
    }

    @Override
    public void getAccountState(RpcController controller, AccountServiceProto.GetAccountStateRequest request, RpcCallback<AccountServiceProto.GetAccountStateResponse> done) {
        NettyRpcController rpcController = (NettyRpcController) controller;
        if (!rpcController.getRpcSession().isAuthorized()) {
            rpcController.setFailed(RpcErrorCode.ERROR_DENIED);
            done.run(AccountServiceProto.GetAccountStateResponse.getDefaultInstance());
            return;
        }
        AccountServiceProto.GetAccountStateResponse.Builder responseBuilder = AccountServiceProto.GetAccountStateResponse.newBuilder();
        if (request.getOptions().getFieldPrivacyInfo()) {
            AccountProto.PrivacyInfo privacyInfo = AccountProto.PrivacyInfo.newBuilder().setIsUsingRid(false)
                    .setIsHiddenFromFriendFinder(true)
                    .setIsVisibleForViewFriends(false).build();
            responseBuilder.setState(AccountProto.AccountState.newBuilder().setPrivacyInfo(privacyInfo))
                    .setTags(AccountProto.AccountFieldTags.newBuilder().setPrivacyInfoTag(0xD7CA834D).build());
        }
        done.run(responseBuilder.build());
    }

    @Override
    public void getGameAccountState(RpcController controller, AccountServiceProto.GetGameAccountStateRequest request, RpcCallback<AccountServiceProto.GetGameAccountStateResponse> done) {
        NettyRpcController rpcController = (NettyRpcController) controller;
        if (!rpcController.getRpcSession().isAuthorized()) {
            rpcController.setFailed(RpcErrorCode.ERROR_DENIED);
            done.run(AccountServiceProto.GetGameAccountStateResponse.getDefaultInstance());
            return;
        }
        BattlenetAccount battlenetAccount = rpcController.getRpcSession().getAttachment(RpcSession.AUTHORIZED_USER);

        AccountProto.GameAccountState.Builder stateBuilder = AccountProto.GameAccountState.newBuilder();
        AccountProto.GameAccountFieldTags.Builder tagBuilder = AccountProto.GameAccountFieldTags.newBuilder();
        if (request.getOptions().getFieldGameLevelInfo()) {
            battlenetAccount.getGameAccounts().stream().filter(e -> request.getGameAccountId().getLow() == e.getId()).findFirst().ifPresent(e -> {
                //String wowName = e.getUsername().replaceAll("^\\S*#", "WoW");
                stateBuilder.setGameLevelInfo(AccountProto.GameLevelInfo.newBuilder().setName(e.getUsername()).setProgram(5730135).build());
            });
            tagBuilder.setGameLevelInfoTag(0x5C46D483).build();
        }

        if (request.getOptions().getFieldGameStatus()) {
            AccountProto.GameStatus.Builder gameStatusBuilder = AccountProto.GameStatus.newBuilder().setProgram(5730135); // WoW
            battlenetAccount.getGameAccounts().stream().filter(e -> request.getGameAccountId().getLow() == e.getId()).findFirst().ifPresent(e -> {
                gameStatusBuilder.setIsSuspended(e.getBanned() != null && e.getBanned())
                        .setIsBanned(e.getPermanentBanned() != null && e.getPermanentBanned())
                        .setSuspensionExpires(0L);//uint64(itr->second.UnbanDate) * 1000000
            });
            stateBuilder.setGameStatus(gameStatusBuilder.build()).build();
            tagBuilder.setGameStatusTag(0x98B75F99).build();
        }
        done.run(AccountServiceProto.GetGameAccountStateResponse.newBuilder()
                .setState(stateBuilder.build())
                .setTags(tagBuilder.build()).build());
    }

    @Override
    public void getLicenses(RpcController controller, AccountServiceProto.GetLicensesRequest request, RpcCallback<AccountServiceProto.GetLicensesResponse> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(AccountServiceProto.GetLicensesResponse.getDefaultInstance());
    }

    @Override
    public void getGameTimeRemainingInfo(RpcController controller, AccountServiceProto.GetGameTimeRemainingInfoRequest request, RpcCallback<AccountServiceProto.GetGameTimeRemainingInfoResponse> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(AccountServiceProto.GetGameTimeRemainingInfoResponse.getDefaultInstance());
    }

    @Override
    public void getGameSessionInfo(RpcController controller, AccountServiceProto.GetGameSessionInfoRequest request, RpcCallback<AccountServiceProto.GetGameSessionInfoResponse> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(AccountServiceProto.GetGameSessionInfoResponse.getDefaultInstance());
    }

    @Override
    public void getCAISInfo(RpcController controller, AccountServiceProto.GetCAISInfoRequest request, RpcCallback<AccountServiceProto.GetCAISInfoResponse> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(AccountServiceProto.GetCAISInfoResponse.getDefaultInstance());
    }

    @Override
    public void getAuthorizedData(RpcController controller, AccountServiceProto.GetAuthorizedDataRequest request, RpcCallback<AccountServiceProto.GetAuthorizedDataResponse> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(AccountServiceProto.GetAuthorizedDataResponse.getDefaultInstance());
    }

    @Override
    public void getSignedAccountState(RpcController controller, AccountServiceProto.GetSignedAccountStateRequest request, RpcCallback<AccountServiceProto.GetSignedAccountStateResponse> done) {
        NettyRpcController nettyRpcController = (NettyRpcController) controller;
        nettyRpcController.setFailed(RpcErrorCode.ERROR_RPC_NOT_IMPLEMENTED);
        done.run(AccountServiceProto.GetSignedAccountStateResponse.getDefaultInstance());
    }

}
