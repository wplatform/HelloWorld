package com.rainbowland.proto.auth;

import com.rainbowland.proto.SendPacketOpcode;
import com.rainbowland.proto.SendWorldPacket;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pong extends SendWorldPacket {

    //uint32
    private long serial = 0;

    public Pong() {
        super(SendPacketOpcode.SMSG_PONG);
    }

    @Override
    public void serialize(ByteBuf buf) {
        buf.writeIntLE((int) serial);
    }
}
