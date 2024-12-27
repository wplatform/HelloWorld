package com.github.mmo.game.group;


import com.github.mmo.defines.Race;
import com.github.mmo.game.entity.object.ObjectGuid;

public class MemberSlot
{
    public ObjectGuid guid = ObjectGuid.EMPTY;
	public String name;
	public Race race = Framework.Constants.race.values()[0];
	public byte class;
	public byte group;
	public GroupMemberflags flags = GroupMemberFlags.values()[0];
	public Lfgroles roles = LfgRoles.values()[0];
	public boolean readyChecked;
}
