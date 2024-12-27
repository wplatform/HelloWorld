package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.networking.*;class TradeSkillSetFavorite extends ClientPacket {

    public int recipeID;
    public boolean isFavorite;

    public TradeSkillSetFavorite(WorldPacket packet) {
        super(packet);
    }

    @Override
    public void read() {
        recipeID = this.readUInt();
        isFavorite = this.readBit();
    }
}
