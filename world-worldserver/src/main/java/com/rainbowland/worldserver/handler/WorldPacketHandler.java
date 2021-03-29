package com.rainbowland.worldserver.handler;

import com.rainbowland.proto.RecvWorldPacket;
import com.rainbowland.proto.SendWorldPacket;
import com.rainbowland.worldserver.adapter.ServerSession;
import org.reactivestreams.Publisher;

public interface WorldPacketHandler {

    Publisher<SendWorldPacket> handle(RecvWorldPacket request);

    Publisher<SendWorldPacket> handle(ServerSession session, RecvWorldPacket request);

}
