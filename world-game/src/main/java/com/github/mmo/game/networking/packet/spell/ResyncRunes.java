package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.ServerPacket;

public class ResyncRunes extends ServerPacket {
    public runeData runes = new runeData();

    public resyncRunes() {
        super(ServerOpcode.ResyncRunes);
    }

    @Override
    public void write() {
        runes.write(this);
    }
}
