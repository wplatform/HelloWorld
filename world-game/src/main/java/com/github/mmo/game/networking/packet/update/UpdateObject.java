package com.github.mmo.game.networking.packet.update;


public class UpdateObject extends ServerPacket
{
	public int numObjUpdates;
	public short mapID;
	public byte[] data;
	public UpdateObject()
	{
		super(ServerOpcode.UpdateObject, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeInt32(numObjUpdates);
		this.writeInt16(mapID);
		this.writeBytes(data);
	}
}
