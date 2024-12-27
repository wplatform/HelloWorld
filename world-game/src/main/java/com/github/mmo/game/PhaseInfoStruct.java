package com.github.mmo.game;


import java.util.ArrayList;

public class PhaseInfoStruct
{
	public int id;
	public ArrayList<Integer> areas = new ArrayList<>();

	public PhaseInfoStruct(int id)
	{
		id = id;
	}

	public final boolean isAllowedInArea(int areaId)
	{
		return areas.Any(areaToCheck -> global.getDB2Mgr().IsInArea(areaId, areaToCheck));
	}
}
