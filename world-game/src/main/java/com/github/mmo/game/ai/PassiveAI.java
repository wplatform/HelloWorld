package com.github.mmo.game.ai;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.unit.Unit;

public class PassiveAI extends CreatureAI
{
	public PassiveAI(Creature creature)
	{
		super(creature);
		creature.setReactState(ReactStates.Passive);
	}

	@Override
	public void updateAI(int diff)
	{
		if (me.isEngaged() && !me.isInCombat())
		{
			enterEvadeMode(EvadeReason.NoHostiles);
		}
	}

	@Override
	public void attackStart(Unit victim)
	{
	}

	@Override
	public void moveInLineOfSight(Unit who)
	{
	}
}
