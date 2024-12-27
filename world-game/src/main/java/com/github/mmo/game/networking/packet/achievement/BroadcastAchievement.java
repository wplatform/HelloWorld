package com.github.mmo.game.networking.packet.achievement;


public class BroadcastAchievement extends ServerPacket
{
	public ObjectGuid playerGUID = ObjectGuid.EMPTY;
	public String name = "";
	public int achievementID;
	public boolean guildAchievement;
	public BroadcastAchievement()
	{
		super(ServerOpcode.BroadcastAchievement);
	}

	@Override
	public void write()
	{
		this.writeBits(name.GetByteCount(), 7);
		this.writeBit(guildAchievement);
		this.writeGuid(playerGUID);
		this.writeInt32(achievementID);
		this.writeString(name);
	}
}
