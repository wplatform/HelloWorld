package com.github.mmo.game.networking.packet.battleground;
import com.github.mmo.game.networking.ServerPacket;
public class BattlegroundPlayerJoined extends ServerPacket
{
	public ObjectGuid guid = ObjectGuid.EMPTY;
	public BattlegroundPlayerJoined()
	{
		super(ServerOpcode.BattlegroundPlayerJoined, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeGuid(guid);
	}
}
