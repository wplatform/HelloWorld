package com.github.mmo.game.networking.packet.achievement;


public class RespondInspectAchievements extends ServerPacket
{
	public ObjectGuid player = ObjectGuid.EMPTY;
	public allAchievements data = new allAchievements();
	public RespondInspectAchievements()
	{
		super(ServerOpcode.RespondInspectAchievements, ConnectionType.instance);
	}

	@Override
	public void write()
	{
		this.writeGuid(player);
		data.write(this);
	}
}
