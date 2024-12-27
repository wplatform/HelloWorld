package com.github.mmo.game.networking.packet.authentication;

import com.github.mmo.game.networking.*;class AuthSession extends ClientPacket {

    public int regionID;

    public int battlegroupID;

    public int realmID;

    public Array<Byte> localChallenge = new Array<Byte>(16);

    public byte[] digest = new byte[24];

    public long dosResponse;
    public String realmJoinTicket;
    public boolean useIPv6;

    public AuthSession(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        dosResponse = this.readUInt64();
        regionID = this.readUInt();
        battlegroupID = this.readUInt();
        realmID = this.readUInt();

        for (var i = 0; i < localChallenge.GetLimit(); ++i) {
            localChallenge.set(i, this.readUInt8());
        }

        digest = this.readBytes(24);

        useIPv6 = this.readBit();
        var realmJoinTicketSize = this.readUInt();

        if (realmJoinTicketSize != 0) {
            realmJoinTicket = this.readString(realmJoinTicketSize);
        }
    }
}
