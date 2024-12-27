package com.github.mmo.game.entity.player;



import java.util.*;


public class BgData
{
	private int bgInstanceId;
	public final int getBgInstanceId()
	{
		return bgInstanceId;
	}
	public final void setBgInstanceId(int value)
	{
		bgInstanceId = value;
	}

	//  when player is teleported to BG - (it is Battleground's GUID)
	private BattlegroundTypeId bgTypeId = BattlegroundTypeId.values()[0];
	public final BattlegroundTypeId getBgTypeId()
	{
		return bgTypeId;
	}
	public final void setBgTypeId(BattlegroundTypeId value)
	{
		bgTypeId = value;
	}

	private ArrayList<ObjectGuid> bgAfkReporter = new ArrayList<>();
	public final ArrayList<ObjectGuid> getBgAfkReporter()
	{
		return bgAfkReporter;
	}
	public final void setBgAfkReporter(ArrayList<ObjectGuid> value)
	{
		bgAfkReporter = value;
	}
	private byte bgAfkReportedCount;
	public final byte getBgAfkReportedCount()
	{
		return bgAfkReportedCount;
	}
	public final void setBgAfkReportedCount(byte value)
	{
		bgAfkReportedCount = value;
	}
	private long bgAfkReportedTimer;
	public final long getBgAfkReportedTimer()
	{
		return bgAfkReportedTimer;
	}
	public final void setBgAfkReportedTimer(long value)
	{
		bgAfkReportedTimer = value;
	}

	private int bgTeam;
	public final int getBgTeam()
	{
		return bgTeam;
	}
	public final void setBgTeam(int value)
	{
		bgTeam = value;
	}

	private int mountSpell;
	public final int getMountSpell()
	{
		return mountSpell;
	}
	public final void setMountSpell(int value)
	{
		mountSpell = value;
	}
	private int[] taxiPath = new int[2];
	public final int[] getTaxiPath()
	{
		return taxiPath;
	}
	public final void setTaxiPath(int[] value)
	{
		taxiPath = value;
	}

	private WorldLocation joinPos;
	public final WorldLocation getJoinPos()
	{
		return joinPos;
	}
	public final void setJoinPos(WorldLocation value)
	{
		joinPos = value;
	}

	public BgData()
	{
		setBgTypeId(BattlegroundTypeId.NONE);
		clearTaxiPath();
		setJoinPos(new worldLocation());
	}

	public final void clearTaxiPath()
	{
		getTaxiPath()[1] = 0;
		getTaxiPath()[0] = getTaxiPath()[1];
	}

	public final boolean hasTaxiPath()
	{
		return getTaxiPath()[0] != 0 && getTaxiPath()[1] != 0;
	}
}
