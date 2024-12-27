package com.github.mmo.game.networking.packet.spell;


import com.github.mmo.game.networking.*;

import java.util.*;public class SendSpellCharges extends ServerPacket {
    public ArrayList<SpellChargeEntry> entries = new ArrayList<>();

    public SendSpellCharges() {
        super(ServerOpcode.SendSpellCharges, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(entries.size());
        entries.forEach(p -> p.write(this));
    }
}
