package com.github.mmo.game.networking.packet.gameobject;
import com.github.mmo.game.networking.ServerPacket;
public class GameObjectSetStateLocal extends ServerPacket
{
	public ObjectGuid objectGUID = ObjectGuid.EMPTY;
	public byte state;
	public GameObjectSetStateLocal()
	{
		super(ServerOpcode.GameObjectSetStateLocal, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeGuid(objectGUID);
		this.writeInt8(state);
	}
}
