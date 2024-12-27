package com.github.mmo.game;


import com.github.mmo.game.entity.creature.CreatureBaseStats;

public class DefaultCreatureBaseStats extends CreatureBaseStats
{
	public DefaultCreatureBaseStats()
	{
		setBaseMana(0);
		setAttackPower(0);
		setRangedAttackPower(0);
	}
}
