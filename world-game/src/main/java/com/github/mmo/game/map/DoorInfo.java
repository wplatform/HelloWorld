package com.github.mmo.game.map;



class DoorInfo
{
	private bossInfo bossInfo;
	public final BossInfo getBossInfo()
	{
		return bossInfo;
	}
	public final void setBossInfo(BossInfo value)
	{
		bossInfo = value;
	}
	private Doortype type = DoorType.values()[0];
	public final DoorType getType()
	{
		return type;
	}
	public final void setType(DoorType value)
	{
		type = value;
	}

	public DoorInfo(BossInfo bossInfo, DoorType doorType)
	{
		setBossInfo(bossInfo);
		setType(doorType);
	}
}
