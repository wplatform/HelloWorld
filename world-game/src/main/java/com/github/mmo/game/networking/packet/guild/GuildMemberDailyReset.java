package com.github.mmo.game.networking.packet.guild;


public class GuildMemberDailyReset extends ServerPacket {
    public GuildMemberDailyReset() {
        super(ServerOpcode.GuildMemberDailyReset);
    }

    @Override
    public void write() {
    }
}
