package com.github.mmo.game.networking.packet.movement;
import com.github.mmo.game.networking.ServerPacket;
public class MoveSkipTime extends ServerPacket
{
	public ObjectGuid moverGUID = ObjectGuid.EMPTY;
	public int timeSkipped;
	public MoveSkipTime()
	{
		super(ServerOpcode.MoveSkipTime, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeGuid(moverGUID);
		this.writeInt32(timeSkipped);
	}
}
