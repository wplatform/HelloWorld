package com.github.mmo.game.networking.packet.guild;


public class GuildEventBankContentsChanged extends ServerPacket {
    public GuildEventBankContentsChanged() {
        super(ServerOpcode.GuildEventBankContentsChanged);
    }

    @Override
    public void write() {
    }
}
