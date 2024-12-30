package com.github.mmo.game.networking.packet.guild;


public class GuildEventDisbanded extends ServerPacket {
    public GuildEventDisbanded() {
        super(ServerOpcode.GuildEventDisbanded);
    }

    @Override
    public void write() {
    }
}
