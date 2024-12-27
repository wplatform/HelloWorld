package com.github.mmo.game.entity.player;

import com.github.mmo.game.battleground.*;

public class BgBattlegroundQueueIdRec
{
	private battlegroundQueueTypeId bgQueueTypeId = new battlegroundQueueTypeId();
	public final BattlegroundQueueTypeId getBgQueueTypeId()
	{
		return bgQueueTypeId;
	}
	public final void setBgQueueTypeId(BattlegroundQueueTypeId value)
	{
		bgQueueTypeId = value;
	}
	private int invitedToInstance;
	public final int getInvitedToInstance()
	{
		return invitedToInstance;
	}
	public final void setInvitedToInstance(int value)
	{
		invitedToInstance = value;
	}
	private int joinTime;
	public final int getJoinTime()
	{
		return joinTime;
	}
	public final void setJoinTime(int value)
	{
		joinTime = value;
	}
	private boolean mercenary;
	public final boolean getMercenary()
	{
		return mercenary;
	}
	public final void setMercenary(boolean value)
	{
		mercenary = value;
	}
}
