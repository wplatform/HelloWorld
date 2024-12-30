package com.github.mmo.game.networking.packet.combat;

import com.github.mmo.game.networking.ClientPacket;
import com.github.mmo.game.networking.WorldPacket;

public class AttackSwing extends ClientPacket {
    public ObjectGuid victim = ObjectGuid.EMPTY;

    public AttackSwing(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        victim = this.readPackedGuid();
    }
}

//Structs

