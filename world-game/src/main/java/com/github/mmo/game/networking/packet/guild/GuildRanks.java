package com.github.mmo.game.networking.packet.guild;


import java.util.ArrayList;


public class GuildRanks extends ServerPacket {
    public ArrayList<GuildRankData> ranks;

    public GuildRanks() {
        super(ServerOpcode.GuildRanks);
        ranks = new ArrayList<>();
    }

    @Override
    public void write() {
        this.writeInt32(ranks.size());

        ranks.forEach(p -> p.write(this));
    }
}
