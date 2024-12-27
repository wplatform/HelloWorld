package com.github.mmo.game.networking.packet.auctionhouse;
import com.github.mmo.game.networking.ServerPacket;
public class AuctionWonNotification extends ServerPacket
{
	public auctionBidderNotification info = new auctionBidderNotification();

	public AuctionWonNotification()
	{
		super(ServerOpcode.AuctionWonNotification);
	}

	@Override
	public void write()
	{
		info.write(this);
	}
}
