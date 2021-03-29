package com.rainbowland.proto.auth;

import com.rainbowland.proto.RecvPacketOpcode;
import com.rainbowland.proto.RecvWorldPacket;
import com.rainbowland.utils.Bits;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthSession extends RecvWorldPacket {


    private static final int DIGEST_LENGTH = 24;

    private static final int CHALLENGE_LENGTH = 16;

    /*
            uint32 RegionID = 0;
            uint32 BattlegroupID = 0;
            uint32 RealmID = 0;
            std::array<uint8, 16> LocalChallenge;
            std::array<uint8, DigestLength> Digest;
            uint64 DosResponse = 0;
            std::string RealmJoinTicket;
            bool UseIPv6 = false;
     */

    private long dosResponse = 0;

    private int regionID = 0;
    private int battleGroupID = 0;
    private int realmID = 0;

    //uint8, 16
    private byte[] localChallenge;
    private byte[] digest;

    private boolean useIPv6;


    private String realmJoinTicket;

    public AuthSession() {
        super(RecvPacketOpcode.CMSG_AUTH_SESSION);
    }

    @Override
    public void deserialize(ByteBuf buf) {
        this.dosResponse = buf.readLongLE();
        this.regionID = buf.readIntLE();
        this.battleGroupID = buf.readIntLE();
        this.realmID = buf.readIntLE();
        this.localChallenge = new byte[CHALLENGE_LENGTH];
        this.digest = new byte[DIGEST_LENGTH];
        buf.readBytes(this.localChallenge);
        buf.readBytes(this.digest);
        this.useIPv6 = Bits.of(buf.readByte()).getBit();
        int realmJoinTicketSize = buf.readIntLE();
        this.realmJoinTicket = readString(buf, realmJoinTicketSize);
    }
}
