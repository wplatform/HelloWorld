package com.github.mmo.game;

import com.github.mmo.game.condition.condition;

import java.util.ArrayList;

public class PhaseAreaInfo
{
	public phaseInfoStruct phaseInfo;
	public ArrayList<Integer> subAreaExclusions = new ArrayList<>();
	public ArrayList<Condition> conditions = new ArrayList<>();

	public PhaseAreaInfo(PhaseInfoStruct phaseInfo)
	{
		phaseInfo = phaseInfo;
	}
}