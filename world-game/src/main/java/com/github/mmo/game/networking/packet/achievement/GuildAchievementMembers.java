package com.github.mmo.game.networking.packet.achievement;


import java.util.ArrayList;
import com.github.mmo.game.networking.ServerPacket;
public class GuildAchievementMembers extends ServerPacket
{
    public ObjectGuid guildGUID = ObjectGuid.EMPTY;
	public int achievementID;
	public ArrayList<ObjectGuid> member = new ArrayList<>();
	public GuildAchievementMembers()
	{
		super(ServerOpcode.GuildAchievementMembers);
	}

	@Override
	public void write()
	{
        this.writeGuid(guildGUID);
        this.writeInt32(achievementID);
        this.writeInt32(member.size());

		for (var guid : member)
		{
            this.writeGuid(guid);
		}
	}
}
