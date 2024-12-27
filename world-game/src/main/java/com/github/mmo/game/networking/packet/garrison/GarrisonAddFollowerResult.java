package com.github.mmo.game.networking.packet.garrison;
import com.github.mmo.game.networking.ServerPacket;
public class GarrisonAddFollowerResult extends ServerPacket
{
	public GarrisonType garrTypeID = GarrisonType.values()[0];
	public Garrisonfollower follower;
	public GarrisonError result = GarrisonError.values()[0];
	public GarrisonAddFollowerResult()
	{
		super(ServerOpcode.GarrisonAddFollowerResult, ConnectionType.instance);
	}

	@Override
	public void write()
	{
        this.writeInt32(garrTypeID.getValue());
        this.writeInt32((int) result.getValue());
		follower.write(this);
	}
}
