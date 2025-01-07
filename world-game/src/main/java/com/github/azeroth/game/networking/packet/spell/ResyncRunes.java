package com.github.azeroth.game.networking.packet.spell;

import com.github.azeroth.game.networking.ServerPacket;

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
