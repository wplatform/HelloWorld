package com.github.mmo.game.networking.packet.loot;
import com.github.mmo.game.networking.ServerPacket;
public class AELootTargets extends ServerPacket
{
	private final int count;

	public AELootTargets(int count)
	{
		super(ServerOpcode.AeLootTargets, ConnectionType.instance);
		count = count;
	}

	@Override
	public void write()
	{
		this.writeInt32(count);
	}
}
