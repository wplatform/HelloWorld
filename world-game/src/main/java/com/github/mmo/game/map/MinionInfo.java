package com.github.mmo.game.map;
class MinionInfo
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

	public MinionInfo(BossInfo _bossInfo)
	{
		setBossInfo(_bossInfo);
	}
}