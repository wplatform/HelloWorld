package com.github.mmo.game.networking.packet.duel;


public class DuelWinner extends ServerPacket
{
	public String beatenName;
	public String winnerName;
	public int beatenVirtualRealmAddress;
	public int winnerVirtualRealmAddress;
	public boolean fled;
	public DuelWinner()
	{
		super(ServerOpcode.DuelWinner, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeBits(beatenName.getBytes().length, 6);
		this.writeBits(winnerName.getBytes().length, 6);
		this.writeBit(fled);
		this.writeInt32(beatenVirtualRealmAddress);
		this.writeInt32(winnerVirtualRealmAddress);
		this.writeString(beatenName);
		this.writeString(winnerName);
	}
}
