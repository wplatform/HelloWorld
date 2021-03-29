package com.rainbowland.worldserver.handler;

import com.rainbowland.proto.RecvWorldPacket;
import com.rainbowland.proto.SendWorldPacket;
import com.rainbowland.proto.auth.Ping;
import com.rainbowland.proto.auth.Pong;
import com.rainbowland.worldserver.adapter.ServerSession;
import com.rainbowland.worldserver.adapter.SessionState;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class ConnectionHandler {


    public Mono<SendWorldPacket> ping(ServerSession session, RecvWorldPacket packet) {
        if(session.getState() != SessionState.AUTHENTICATED) {
            log.error( "peer sent CMSG_PING, but is not authenticated or got recently kicked, address = {}", session.getRemoteHostName());
            session.close();
            return Mono.empty();
        }
        return Mono.just(packet).cast(Ping.class).map(ping -> {
            session.setAttachment("Latency", ping.getLatency());
            Pong result = new Pong();
            result.setSerial(ping.getSerial());
            return result;
        });
    }


    public Mono<SendWorldPacket> keepAlive(ServerSession session, RecvWorldPacket packet) {
        return Mono.empty();
    }

    public Mono<SendWorldPacket> logDisconnect(ServerSession session, RecvWorldPacket packet) {
        return Mono.empty();
    }

    public Mono<SendWorldPacket> enableNagle(ServerSession session, RecvWorldPacket packet) {
        return Mono.empty();
    }

    public Mono<SendWorldPacket> connectFailed(ServerSession session, RecvWorldPacket packet) {
        return Mono.empty();
    }

    public Mono<SendWorldPacket> hotfixRequest(ServerSession session, RecvWorldPacket packet) {
        return Mono.empty();
    }
}
