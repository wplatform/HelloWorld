package com.github.mmo.game.networking.packet.spell;


public class CancelOrphanSpellVisual extends ServerPacket {
    public int spellVisualID;

    public CancelOrphanSpellVisual() {
        super(ServerOpcode.CancelOrphanSpellVisual);
    }

    @Override
    public void write() {
        this.writeInt32(spellVisualID);
    }
}
