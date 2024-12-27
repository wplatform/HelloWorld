package com.github.mmo.game.networking.packet.collection;

import com.github.mmo.game.networking.*;
class CollectionItemSetFavorite extends ClientPacket
{
	public Collectiontype type = CollectionType.values()[0];
	public int id;
	public boolean isFavorite;
	public CollectionItemSetFavorite(WorldPacket packet)
	{
		super(packet);
	}

	@Override
	public void read()
	{
        type = CollectionType.forValue(this.readUInt());
        id = this.readUInt();
        isFavorite = this.readBit();
	}
}
