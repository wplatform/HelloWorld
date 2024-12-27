package com.github.mmo.game.networking.packet.battleground;
import com.github.mmo.game.networking.ServerPacket;
public class PVPMatchComplete extends ServerPacket
{
	public byte winner;
	public int duration;
	public PVPMatchStatistics logData;
	public int soloShuffleStatus;
	public PVPMatchComplete()
	{
		super(ServerOpcode.PvpMatchComplete, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeInt8(winner);
        this.writeInt32(duration);
        this.writeBit(logData != null);
        this.writeBits(soloShuffleStatus, 2);
        this.flushBits();

		if (logData != null)
		{
			logData.write(this);
		}
	}
}
