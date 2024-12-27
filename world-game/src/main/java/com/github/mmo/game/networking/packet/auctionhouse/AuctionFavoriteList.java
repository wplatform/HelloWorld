package com.github.mmo.game.networking.packet.auctionhouse;


import java.util.*;
import com.github.mmo.game.networking.ServerPacket;
public class AuctionFavoriteList extends ServerPacket
{
	public int desiredDelay;
	public ArrayList<AuctionFavoriteInfo> items = new ArrayList<>();

	public AuctionFavoriteList()
	{
		super(ServerOpcode.AuctionFavoriteList);
	}

	@Override
	public void write()
	{
		this.writeInt32(desiredDelay);
		this.writeBits(items.size(), 7);
		this.flushBits();

		for (var favoriteInfo : items)
		{
			favoriteInfo.write(this);
		}
	}
}
