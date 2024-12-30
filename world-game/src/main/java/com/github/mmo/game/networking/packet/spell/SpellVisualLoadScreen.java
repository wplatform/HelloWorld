package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.ServerPacket;

public class SpellVisualLoadScreen extends ServerPacket {
    public int spellVisualKitID;
    public int delay;

    public SpellVisualLoadScreen(int spellVisualKitId, int delay) {
        super(ServerOpcode.SpellVisualLoadScreen, ConnectionType.instance);
        spellVisualKitID = spellVisualKitId;
        delay = delay;
    }

    @Override
    public void write() {
        this.writeInt32(spellVisualKitID);
        this.writeInt32(delay);
    }
}
