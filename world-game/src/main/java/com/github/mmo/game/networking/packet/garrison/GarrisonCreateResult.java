package com.github.mmo.game.networking.packet.garrison;
import com.github.mmo.game.networking.ServerPacket;
public class GarrisonCreateResult extends ServerPacket
{
	public int garrSiteLevelID;
	public int result;
	public GarrisonCreateResult()
	{
		super(ServerOpcode.GarrisonCreateResult, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeInt32(result);
		this.writeInt32(garrSiteLevelID);
	}
}

//Structs

