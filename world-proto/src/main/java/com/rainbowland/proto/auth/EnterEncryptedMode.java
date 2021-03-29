package com.rainbowland.proto.auth;

import com.rainbowland.proto.SendPacketOpcode;
import com.rainbowland.proto.SendWorldPacket;
import com.rainbowland.utils.Bits;
import io.netty.buffer.ByteBuf;
import lombok.Setter;

@Setter
public class EnterEncryptedMode extends SendWorldPacket {


    private byte[] signature;
    private boolean enabled;

    public EnterEncryptedMode() {
        super(SendPacketOpcode.SMSG_ENTER_ENCRYPTED_MODE);
    }

    @Override
    public void serialize(ByteBuf buf) {
        buf.writeBytes(signature);
        buf.writeByte(Bits.of(0).addBit(enabled).values()[0]);
    }
}
