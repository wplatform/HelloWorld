package com.github.mmo.game;


public class PetLevelInfo
{
	public int[] stats = new int[Stats.max.getValue()];
	public int health;
	public int mana;
	public int armor;

	public PetLevelInfo()
	{
		health = 0;
		mana = 0;
	}
}
