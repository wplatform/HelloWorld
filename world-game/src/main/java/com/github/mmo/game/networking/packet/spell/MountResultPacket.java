package com.github.mmo.game.networking.packet.spell;
import com.github.mmo.game.networking.ServerPacket;
public class MountResultPacket extends ServerPacket
{
	public int result;
	public MountResultPacket()
	{
		super(ServerOpcode.MountResult, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeInt32(result);
	}
}
