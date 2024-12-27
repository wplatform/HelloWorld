package com.github.mmo.game.networking.packet.spell;

import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.entity.object.Position;
import com.github.mmo.game.networking.*;

public class TargetLocation
{
    public ObjectGuid transport = ObjectGuid.EMPTY;
	public Position location;

	public final void read(WorldPacket data)
	{
        transport = data.readPackedGuid();
		location = new Position();
        location.setX(data.readFloat());
        location.setY(data.readFloat());
        location.setZ(data.readFloat());
	}

	public final void write(WorldPacket data)
	{
        data.writeGuid(transport);
        data.writeFloat(location.getX());
        data.writeFloat(location.getY());
        data.writeFloat(location.getZ());
	}
}
