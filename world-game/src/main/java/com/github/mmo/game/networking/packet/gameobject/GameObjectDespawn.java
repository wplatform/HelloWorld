package com.github.mmo.game.networking.packet.gameobject;
import com.github.mmo.game.networking.ServerPacket;
public class GameObjectDespawn extends ServerPacket
{
	public ObjectGuid objectGUID = ObjectGuid.EMPTY;
	public GameObjectDespawn()
	{
		super(ServerOpcode.GameObjectDespawn);
	}

	@Override
	public void write()
	{
		this.writeGuid(objectGUID);
	}
}
