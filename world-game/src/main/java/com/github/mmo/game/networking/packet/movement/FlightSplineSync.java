package com.github.mmo.game.networking.packet.movement;
import com.github.mmo.game.networking.ServerPacket;
public class FlightSplineSync extends ServerPacket
{
    public ObjectGuid guid = ObjectGuid.EMPTY;
	public float splineDist;
	public FlightSplineSync()
	{
		super(ServerOpcode.FlightSplineSync, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeGuid(guid);
        this.writeFloat(splineDist);
	}
}
