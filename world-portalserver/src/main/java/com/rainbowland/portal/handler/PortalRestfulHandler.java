package com.rainbowland.portal.handler;

import com.rainbowland.portal.boot.PortalProperties;
import com.rainbowland.portal.model.*;
import com.rainbowland.portal.utils.JsonUtil;
import com.rainbowland.service.auth.AuthService;
import com.rainbowland.service.auth.domain.Account;
import com.rainbowland.service.auth.domain.BattlenetAccount;
import com.rainbowland.utils.SecureUtils;
import com.rainbowland.utils.SysProperties;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.relational.core.query.Criteria;
import org.springframework.data.relational.core.query.Query;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
public class PortalRestfulHandler {

    public static final String HEAD_AUTHORIZATION = "Authorization";
    private static final String MOBILE_PHONE_REGEX = "/^1[3|4|5|7|8]\\d{9}$/";


    private final PortalProperties portalProperties;
    private final AuthService authService;


    public Mono<Void> loginGet(HttpServerRequest request, HttpServerResponse response) {
        return Mono.from(response.status(HttpResponseStatus.OK)
                .sendString(Mono.just(FormInputs.DEFAULT_FORM_INPUTS)))
                .doOnError(e -> response.status(HttpResponseStatus.INTERNAL_SERVER_ERROR));
    }

    public Mono<Void> loginPost(HttpServerRequest request, HttpServerResponse response) {
        return request.receive().asString(StandardCharsets.UTF_8)
                .map(val -> JsonUtil.fromJson(val, LoginForm.class))
                .flatMap(loginForm -> doLongin(request, loginForm))
                .flatMap(result -> response.status(HttpResponseStatus.OK)
                        .sendString(Mono.just(JsonUtil.toJson(result)))).then()
                .doOnError(e -> response.status(HttpResponseStatus.INTERNAL_SERVER_ERROR));
    }


    private String getValue(LoginForm form, String varName) {
        return form.getInputs().stream()
                .filter(e -> varName.equals(e.getInput_id()))
                .map(LoginForm.FormInputValue::getValue)
                .findFirst()
                .orElseThrow();
    }


    private Mono<LoginResult> doLongin(HttpServerRequest request, LoginForm form) {
        String accountName = getValue(form, "account_name");
        String password = getValue(form, "password");
        String passwordHash = SecureUtils.passwordHash(accountName, password);
        return authService.getBattleNetAccount(accountName)
                .flatMap(account -> {
                    if (passwordHash.equals(account.getShaPassHash())) {
                        String loginTicket = SecureUtils.bytesToHexString(SecureUtils.generateRandomBytes(SysProperties.PORTAL_LOGIN_TICKET_LENGTH));
                        long loginTicketExpiry = System.currentTimeMillis() + portalProperties.getLoginTicketDuration().toMillis();
                        account.setLoginTicket(loginTicket);
                        account.setLoginTicketExpiry(loginTicketExpiry);
                        account.setFailedLogins(0);
                    } else {
                        account.setFailedLogins(account.getFailedLogins() == null ? 1 : account.getFailedLogins() + 1);
                    }
                    account.setLastIp(request.remoteAddress().getAddress().getHostName());
                    account.setOs(form.getPlatform_id());
                    account.setLastLogin(LocalDateTime.now());
                    return authService.update(account);
                }).map(account -> {
                    if (passwordHash.equals(account.getShaPassHash())) {
                        return LoginResult.builder()
                                .authentication_state(LoginResult.State.DONE)
                                .login_ticket(account.getLoginTicket()).build();
                    }
                    return LoginResult.builder()
                            .authentication_state(LoginResult.State.DONE).build();
                })
                .switchIfEmpty(Mono.just(LoginResult.builder()
                        .authentication_state(LoginResult.State.DONE).build()));

    }

    public Mono<Void> gameAccountsGet(HttpServerRequest request, HttpServerResponse response) {
        String user = request.requestHeaders().get("");
        String condition = user.matches(MOBILE_PHONE_REGEX) ? "mobile_phone" : "email";
        return authService.selectOne(Query.query(Criteria.where(condition).is(user)), BattlenetAccount.class)
                .flatMapMany(bnetAccount -> authService.select(Query.query(Criteria.where("battlenetAccount").is(bnetAccount.getId())), Account.class))
                .collectList()
                .map(accounts -> accounts.stream().map(e -> GameAccountInfo.builder().display_name("")
                        .expansion(e.getExpansion()).is_banned(true).is_suspended(true)
                        .suspension_reason("").build())
                        .collect(Collectors.toList()))
                .flatMap(result -> Mono.from(response.status(HttpResponseStatus.OK)
                        .sendString(Mono.just(JsonUtil.toJson(result)))))
                .doOnError(e -> response.status(HttpResponseStatus.INTERNAL_SERVER_ERROR));


    }

    public Mono<Void> portalGet(HttpServerRequest request, HttpServerResponse response) {
        return Mono.from(response.status(HttpResponseStatus.OK)
                .sendString(Mono.just("127.0.0.1:1119")))
                .doOnError(e -> response.status(HttpResponseStatus.INTERNAL_SERVER_ERROR));
    }

    public Mono<Void> refreshLoginTicketGet(HttpServerRequest request, HttpServerResponse response) {
        String authorization = request.requestHeaders().get(HEAD_AUTHORIZATION);
        if (StringUtils.hasText(authorization)) {
            return response.status(HttpResponseStatus.UNAUTHORIZED)
                    .send();
        }
        return authService.selectOne(Query.query(Criteria.where("LoginTicket").is(authorization)), BattlenetAccount.class)
                .flatMap(account -> {
                    Long loginTicketExpiry = account.getLoginTicketExpiry();
                    if (loginTicketExpiry > System.currentTimeMillis()) {
                        loginTicketExpiry = System.currentTimeMillis() + portalProperties.getLoginTicketDuration().toMillis();
                        account.setLoginTicketExpiry(loginTicketExpiry);
                        return authService.update(account).map(e -> LoginRefreshResult.builder()
                                .login_ticket_expiry(e.getLoginTicketExpiry()).build());
                    }
                    return Mono.just(LoginRefreshResult.builder().is_expired(true).build());
                }).switchIfEmpty(Mono.just(LoginRefreshResult.builder().is_expired(true).build()))
                .flatMap(result -> Mono.from(response.status(HttpResponseStatus.OK)
                        .sendString(Mono.just(JsonUtil.toJson(result)), StandardCharsets.UTF_8)))
                .doOnError(e -> response.status(HttpResponseStatus.INTERNAL_SERVER_ERROR));


    }


}
