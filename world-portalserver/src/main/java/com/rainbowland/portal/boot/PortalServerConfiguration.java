package com.rainbowland.portal.boot;

import bgs.protocol.account.v1.AccountServiceProto;
import bgs.protocol.authentication.v1.AuthenticationServiceProto;
import bnet.protocol.connection.v1.ConnectionServiceProto;
import bnet.protocol.game_utilities.v1.GameUtilitiesServiceProto;
import com.rainbowland.portal.PortalRestfulServer;
import com.rainbowland.portal.PortalRpcServer;
import com.rainbowland.portal.handler.PortalRestfulHandler;
import com.rainbowland.portal.handler.PortalRpcHandler;
import com.rainbowland.portal.rpc.service.AccountService;
import com.rainbowland.portal.rpc.service.AuthenticationService;
import com.rainbowland.portal.rpc.service.ConnectionService;
import com.rainbowland.portal.rpc.service.GameUtilitiesService;
import com.rainbowland.service.auth.AuthService;
import com.rainbowland.service.realm.RealmManager;
import com.rainbowland.common.ServerProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PortalServerConfiguration {

    @Bean
    @ConfigurationProperties("portal")
    public PortalProperties portalProperties() {
        return new PortalProperties();
    }


    @Bean
    @ConfigurationProperties("portal.portal-server")
    public ServerProperties portalServerProperties() {
        return new ServerProperties();
    }

    @Bean
    @ConfigurationProperties("portal.restful-server")
    public ServerProperties restfulServerProperties() {
        return new ServerProperties();
    }

    @Bean
    public PortalRpcHandler portalHandler(PortalProperties portalProperties, AuthService authService, RealmManager realmManager) {
        PortalRpcHandler portalRpcHandler = new PortalRpcHandler();
        portalRpcHandler.registerService(ConnectionServiceProto.ConnectionService.newReflectiveService(new ConnectionService()));
        portalRpcHandler.registerService(AuthenticationServiceProto.AuthenticationService.newReflectiveService(new AuthenticationService(portalProperties, authService)));
        portalRpcHandler.registerService(AccountServiceProto.AccountService.newReflectiveService(new AccountService()));
        portalRpcHandler.registerService(GameUtilitiesServiceProto.GameUtilitiesService.newReflectiveService(new GameUtilitiesService(authService, realmManager)));
        return portalRpcHandler;
    }

    @Bean
    public PortalRestfulHandler portalRestfulHandler(PortalProperties portalProperties, AuthService authService) {
        return new PortalRestfulHandler(portalProperties, authService);
    }

    @Bean(destroyMethod = "stop")
    public PortalRpcServer portalServer(@Qualifier("portalServerProperties") ServerProperties properties, PortalRpcHandler handler) {
        PortalRpcServer server = new PortalRpcServer();
        server.setHandler(handler);
        server.setPort(properties.getPort());
        server.setBindIp(properties.getBindIp());
        return server;
    }

    @Bean(destroyMethod = "stop")
    public PortalRestfulServer portalRestfulServer(@Qualifier("restfulServerProperties") ServerProperties properties, PortalRestfulHandler handler) {
        PortalRestfulServer server = new PortalRestfulServer();
        server.setHandler(handler);
        server.setPort(properties.getPort());
        server.setBindIp(properties.getBindIp());
        return server;
    }


}
