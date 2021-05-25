package com.rainbowland.worldserver.handler;

import com.rainbowland.common.RpcErrorCode;
import com.rainbowland.proto.RecvWorldPacket;
import com.rainbowland.proto.SendWorldPacket;
import com.rainbowland.proto.auth.AuthContinuedSession;
import com.rainbowland.proto.auth.AuthResponse;
import com.rainbowland.proto.auth.AuthSession;
import com.rainbowland.proto.auth.EnterEncryptedMode;
import com.rainbowland.service.auth.AuthService;
import com.rainbowland.service.auth.domain.Account;
import com.rainbowland.service.realm.Realm;
import com.rainbowland.service.realm.RealmBuildInfo;
import com.rainbowland.service.realm.RealmKey;
import com.rainbowland.service.realm.RealmManager;
import com.rainbowland.utils.Bits;
import com.rainbowland.utils.SecureUtils;
import com.rainbowland.utils.SysProperties;
import com.rainbowland.worldserver.adapter.ChannelSession;
import com.rainbowland.worldserver.adapter.ServerSession;
import com.rainbowland.worldserver.adapter.SessionState;
import com.rainbowland.worldserver.constant.Constants;
import com.rainbowland.worldserver.crypto.Rsa;
import com.rainbowland.worldserver.utils.SessionKeyGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.data.relational.core.query.Update;
import reactor.core.publisher.Mono;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
public class AuthorizationHandler {


    private static final String SESSION_ACCOUNT_KEY = "SessionAccount";

    private final AuthService authService;

    private final RealmManager realmManager;


    public Mono<SendWorldPacket> authSession(ServerSession session, RecvWorldPacket request) {
        ChannelSession channelSession = (ChannelSession) session;
        AuthSession payload = request.cast(AuthSession.class);
        RealmKey realmKey = RealmKey.createRealmKey(payload.getRegionID(), payload.getBattleGroupID(), payload.getRealmID());
        Realm thisRealm = realmManager.getRealmByKey(realmKey);

        return authService.queryAccountByRealmJoinTicket(payload.getRealmID(), payload.getRealmJoinTicket())
                .flatMap(account -> {
                    RealmBuildInfo buildInfo = realmManager.getBuildInfo(thisRealm.getBuild());
                    if (buildInfo == null) {
                        return Mono.just(AuthResponse.result(RpcErrorCode.ERROR_BAD_VERSION));
                    }

                    if (Objects.equals(account.getBanned(), true)) {
                        log.error("Account {} is banned. reject to auth session. address: {}",
                                account.getUsername(), session.getRemoteHostName());
                        session.close();
                        return Mono.empty();
                    }

                    String os = account.getOs();
                    byte[] hmacKey = switch (os) {
                        case "Wn64" -> SecureUtils.sha256(account.getSessionKeyBnet(), buildInfo.getWin64AuthSeed());
                        case "Mc64" -> SecureUtils.sha256(account.getSessionKeyBnet(), buildInfo.getMac64AuthSeed());
                        default -> SecureUtils.sha256(account.getSessionKeyBnet());
                    };
                    byte[] hmacSHA256 = SecureUtils.hmacSHA256(hmacKey, payload.getLocalChallenge(),
                            session.getServerChallenge(), Constants.AUTH_CHECK_SEED);

                    if (!Arrays.equals(hmacSHA256, payload.getDigest())) {
                        log.error("Authentication failed for account: {} ({}) address: {}",
                                account.getId(), payload.getRealmJoinTicket(), session.getRemoteHostName());
                        session.close();
                        return Mono.empty();
                    }

                    byte[] keyData = SecureUtils.sha256(account.getSessionKeyBnet());
                    byte[] sessionKeyHmac = SecureUtils.hmacSHA256(keyData,
                            session.getServerChallenge(), payload.getLocalChallenge(), Constants.SESSION_KEY_SEED);

                    SessionKeyGenerator generator = new SessionKeyGenerator(sessionKeyHmac);
                    byte[] sessionKey = generator.generate();
                    channelSession.setSessionKey(sessionKey);

                    // only first 16 bytes of the hmac are used
                    byte[] encryptKeyGen = SecureUtils.hmacSHA256(sessionKey, payload.getLocalChallenge(), session.getServerChallenge(), Constants.ENCRYPTION_KEY_SEED);
                    byte[] encryptKey = new byte[SysProperties.PORTAL_ENCRYPT_KEY_LENGTH];
                    System.arraycopy(encryptKeyGen, 0, encryptKey, 0, encryptKey.length);
                    channelSession.setSecretKey(encryptKey);


                    byte[] enableEncryptionData = SecureUtils.hmacSHA256(encryptKey,
                            Bits.of(0).addBit(true).values(), Constants.ENABLE_ENCRYPTION_SEED);
                    byte[] signature = Rsa.sign(enableEncryptionData);

                    EnterEncryptedMode enterEncryptedMode = new EnterEncryptedMode();
                    enterEncryptedMode.setSignature(signature);
                    enterEncryptedMode.setEnabled(true);

                    Update update = Update.update("last_attempt_ip", session.getRemoteHostName());
                    update.set("session_key_bnet", channelSession.getSessionKey());
                    update.set("last_ip", session.getRemoteHostName());

                    channelSession.setAttachment(SESSION_ACCOUNT_KEY, account);

                    return authService.update(Account.class)
                            .matching(Query.query(Criteria.where("id").is(account.getId()))).apply(update)
                            .then(Mono.just(enterEncryptedMode));
                });

    }


    public Mono<SendWorldPacket> authContinuedSession(ServerSession session, RecvWorldPacket request) {
        AuthContinuedSession payload = request.cast(AuthContinuedSession.class);
        ChannelSession channelSession = (ChannelSession) session;
        return Mono.just(session.<Account>getAttachment(SESSION_ACCOUNT_KEY))
                .map(account -> {
                    AuthResponse response = new AuthResponse();
                    byte[] hmacSHA256 = SecureUtils.hmacSHA256(session.getSessionKey(),
                            ByteBuffer.wrap(new byte[8]).order(ByteOrder.LITTLE_ENDIAN).putLong(payload.getKey()).array(),
                            payload.getLocalChallenge(),
                            session.getServerChallenge(), Constants.CONTINUED_SESSION_SEED);

                    if (!Arrays.equals(hmacSHA256, payload.getDigest())) {
                        log.error("Authentication continued session failed for account: {} ({}) address: {}",
                                account.getId(), account.getUsername(), session.getRemoteHostName());
                        session.close();
                        return response;
                    }

                    // only first 16 bytes of the hmac are used
                    byte[] encryptKeyGen = SecureUtils.hmacSHA256(session.getSessionKey(),
                            payload.getLocalChallenge(), session.getServerChallenge(), Constants.ENCRYPTION_KEY_SEED);
                    byte[] encryptKey = new byte[SysProperties.PORTAL_ENCRYPT_KEY_LENGTH];
                    System.arraycopy(encryptKeyGen, 0, encryptKey, 0, encryptKey.length);

                    channelSession.setSecretKey(encryptKey);

                    byte[] enableEncryptionData = SecureUtils.hmacSHA256(encryptKey,
                            Bits.of(0).addBit(true).values(), Constants.ENABLE_ENCRYPTION_SEED);
                    byte[] signature = Rsa.sign(enableEncryptionData);

                    EnterEncryptedMode enterEncryptedMode = new EnterEncryptedMode();
                    enterEncryptedMode.setSignature(signature);
                    enterEncryptedMode.setEnabled(true);
                    return enterEncryptedMode;

                }).switchIfEmpty(Mono.just(AuthResponse.result(RpcErrorCode.ERROR_DENIED)));
    }


    public Mono<SendWorldPacket> enterEncryptedModeAck(ServerSession session, RecvWorldPacket request) {
        ChannelSession channelSession = (ChannelSession) session;
        channelSession.setState(SessionState.AUTHENTICATED);
        return Mono.empty();
    }


}
