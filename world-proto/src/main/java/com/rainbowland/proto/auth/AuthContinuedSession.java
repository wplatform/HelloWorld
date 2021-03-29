package com.rainbowland.proto.auth;

import com.rainbowland.proto.RecvPacketOpcode;
import com.rainbowland.proto.RecvWorldPacket;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuthContinuedSession extends RecvWorldPacket {

    private static final int DIGEST_LENGTH = 24;


    private long dosResponse = 0;
    private long key = 0;
    private byte[] localChallenge; //16 bytes
    private byte[] digest; //DIGEST_LENGTH

    public AuthContinuedSession() {
        super(RecvPacketOpcode.CMSG_AUTH_CONTINUED_SESSION);
    }

    @Override
    public void deserialize(ByteBuf buf) {
        dosResponse = buf.readLongLE();
        key = buf.readLongLE();
        localChallenge = new byte[16];
        buf.readBytes(localChallenge);
        digest = new byte[DIGEST_LENGTH];
        buf.readBytes(digest);
    }
}
