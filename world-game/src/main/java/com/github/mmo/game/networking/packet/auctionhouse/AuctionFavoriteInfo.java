package com.github.mmo.game.networking.packet.auctionhouse;

import com.github.mmo.game.networking.WorldPacket;

public final class AuctionFavoriteInfo {
    public int order;
    public int itemID;
    public int itemLevel;
    public int battlePetSpeciesID;
    public int suffixItemNameDescriptionID;

    public auctionFavoriteInfo() {
    }

    public auctionFavoriteInfo(WorldPacket data) {
        order = data.readUInt();
        itemID = data.readUInt();
        itemLevel = data.readUInt();
        battlePetSpeciesID = data.readUInt();
        suffixItemNameDescriptionID = data.readUInt();
    }

    public void write(WorldPacket data) {
        data.writeInt32(order);
        data.writeInt32(itemID);
        data.writeInt32(itemLevel);
        data.writeInt32(battlePetSpeciesID);
        data.writeInt32(suffixItemNameDescriptionID);
    }

    public AuctionFavoriteInfo clone() {
        AuctionFavoriteInfo varCopy = new auctionFavoriteInfo();

        varCopy.order = this.order;
        varCopy.itemID = this.itemID;
        varCopy.itemLevel = this.itemLevel;
        varCopy.battlePetSpeciesID = this.battlePetSpeciesID;
        varCopy.suffixItemNameDescriptionID = this.suffixItemNameDescriptionID;

        return varCopy;
    }
}
