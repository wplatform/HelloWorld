package com.rainbowland.worldserver.boot;

import com.rainbowland.service.auth.AuthService;
import com.rainbowland.service.realm.RealmManager;
import com.rainbowland.worldserver.adapter.ServerRoutes;
import com.rainbowland.worldserver.handler.AuthorizationHandler;
import com.rainbowland.worldserver.handler.ConnectionHandler;
import com.rainbowland.worldserver.server.WorldServer;
import com.rainbowland.common.ServerProperties;
import com.rainbowland.proto.RecvPacketOpcode;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorldServerConfiguration {

    @Bean
    @ConfigurationProperties("world.realm")
    public WorldRealmProperties worldRealmProperties() {
        return new WorldRealmProperties();
    }

    @Bean
    @ConfigurationProperties("world.character")
    public WorldCharacterProperties worldCharacterProperties() {
        return new WorldCharacterProperties();
    }



    @Bean
    @ConfigurationProperties("world.world-server")
    public ServerProperties worldServerProperties() {
        return new ServerProperties();
    }




    @Bean
    public WorldServer worldServer(@Qualifier("worldServerProperties") ServerProperties properties, ServerRoutes serverRoutes) {
        WorldServer worldServer = new WorldServer();
        worldServer.setProperties(properties);
        worldServer.setServerRoutes(serverRoutes);
        return worldServer;
    }

    @Bean
    public AuthorizationHandler authorizationHandler(AuthService authService, RealmManager realmManager) {
        return new AuthorizationHandler(authService, realmManager);
    }

    @Bean
    public ConnectionHandler connectionHandler() {
        return new ConnectionHandler();
    }


    @Bean
    public ServerRoutes serverRoutes(ApplicationContext ctx) {
        return ServerRoutes.route(routes -> {

            routes.route(RecvPacketOpcode.CMSG_PING, ctx.getBean(ConnectionHandler.class)::ping);
            routes.route(RecvPacketOpcode.CMSG_KEEP_ALIVE, ctx.getBean(ConnectionHandler.class)::keepAlive);
            routes.route(RecvPacketOpcode.CMSG_LOG_DISCONNECT, ctx.getBean(ConnectionHandler.class)::logDisconnect);
            routes.route(RecvPacketOpcode.CMSG_ENABLE_NAGLE, ctx.getBean(ConnectionHandler.class)::enableNagle);
            routes.route(RecvPacketOpcode.CMSG_CONNECT_TO_FAILED, ctx.getBean(ConnectionHandler.class)::connectFailed);

            routes.route(RecvPacketOpcode.CMSG_AUTH_SESSION, ctx.getBean(AuthorizationHandler.class)::authSession);
            routes.route(RecvPacketOpcode.CMSG_AUTH_CONTINUED_SESSION, ctx.getBean(AuthorizationHandler.class)::authContinuedSession);
            routes.route(RecvPacketOpcode.CMSG_ENTER_ENCRYPTED_MODE_ACK, ctx.getBean(AuthorizationHandler.class)::enterEncryptedModeAck);


        });
    }


}
