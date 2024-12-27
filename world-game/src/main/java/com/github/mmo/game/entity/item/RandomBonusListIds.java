package com.github.mmo.game.entity.item;

import java.util.*;


public class RandomBonusListIds
{
	private ArrayList<Integer> bonusListIDs = new ArrayList<>();
	public final ArrayList<Integer> getBonusListIDs()
	{
		return bonusListIDs;
	}
	public final void setBonusListIDs(ArrayList<Integer> value)
	{
		bonusListIDs = value;
	}
	private ArrayList<Double> chances = new ArrayList<>();
	public final ArrayList<Double> getChances()
	{
		return chances;
	}
	public final void setChances(ArrayList<Double> value)
	{
		chances = value;
	}
}
