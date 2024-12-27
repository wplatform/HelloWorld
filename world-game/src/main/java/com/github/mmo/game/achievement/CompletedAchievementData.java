package com.github.mmo.game.achievement;

import java.util.*;


public class CompletedAchievementData
{
	public long date;
	public ArrayList<ObjectGuid> completingPlayers = new ArrayList<>();
	public boolean changed;
}
