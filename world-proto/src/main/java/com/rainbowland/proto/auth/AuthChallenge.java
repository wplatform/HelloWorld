package com.rainbowland.proto.auth;

import com.rainbowland.proto.SendPacketOpcode;
import com.rainbowland.proto.SendWorldPacket;
import io.netty.buffer.ByteBuf;
import lombok.Setter;

@Setter
public class AuthChallenge extends SendWorldPacket {

    private byte[] challenge;
    private byte[] dosChallenge;
    private int dosZeroBits;

    public AuthChallenge() {
        super(SendPacketOpcode.SMSG_AUTH_CHALLENGE);
    }

    @Override
    public void serialize(ByteBuf buf) {
        buf.writeBytes(challenge);
        buf.writeBytes(dosChallenge);
        buf.writeByte(dosZeroBits);
    }
}
