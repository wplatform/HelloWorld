package com.github.mmo.game.pools;

import java.util.*;

public class QuestPool
{
	public int poolId;
	public int numActive;
	public MultiMap<Integer, Integer> members = new MultiMap<Integer, Integer>();
	public ArrayList<Integer> activeQuests = new ArrayList<>();
}
