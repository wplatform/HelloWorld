package com.rainbowland.proto.auth;

import com.rainbowland.proto.RecvPacketOpcode;
import com.rainbowland.proto.RecvWorldPacket;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ping extends RecvWorldPacket {

    long serial = 0;//uint32
    long latency = 0;//uint32

    public Ping() {
        super(RecvPacketOpcode.CMSG_PING);
    }

    @Override
    public void deserialize(ByteBuf buf) {
        this.serial = buf.readUnsignedIntLE();
        this.latency = buf.readUnsignedIntLE();
    }
}
