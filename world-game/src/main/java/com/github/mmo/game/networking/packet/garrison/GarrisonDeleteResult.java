package com.github.mmo.game.networking.packet.garrison;
import com.github.mmo.game.networking.ServerPacket;
public class GarrisonDeleteResult extends ServerPacket
{
	public GarrisonError result = GarrisonError.values()[0];
	public int garrSiteID;
	public GarrisonDeleteResult()
	{
		super(ServerOpcode.GarrisonDeleteResult, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeInt32((int) result.getValue());
        this.writeInt32(garrSiteID);
	}
}
