package com.github.mmo.game.networking.packet.spell;


import java.util.ArrayList;


public class SupercededSpells extends ServerPacket {
    public ArrayList<LearnedSpellInfo> clientLearnedSpellData = new ArrayList<>();

    public SupercededSpells() {
        super(ServerOpcode.SupercededSpells, ConnectionType.instance);
    }

    @Override
    public void write() {
        this.writeInt32(clientLearnedSpellData.size());

        for (var spell : clientLearnedSpellData) {
            spell.write(this);
        }
    }
}
