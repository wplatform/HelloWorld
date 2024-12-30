package com.github.mmo.game.networking.packet.social;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class AddFriend extends ClientPacket {
    public String notes;
    public String name;

    public AddFriend(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        var nameLength = this.<Integer>readBit(9);
        var noteslength = this.<Integer>readBit(10);
        name = this.readString(nameLength);
        notes = this.readString(noteslength);
    }
}
