package com.github.mmo.game.phasing;

import com.github.mmo.game.condition.*;
import java.util.*;

public class PhaseRef
{
	public PhaseFlag flags = PhaseFlag.NONE;
	public int references;
	public ArrayList<Condition> areaConditions;

	public PhaseRef(PhaseFlag flags, ArrayList<Condition> conditions)
	{
		this.flags = flags;
		references = 0;
		areaConditions = conditions;
	}

	public final boolean isPersonal()
	{
		return (flags.value & PhaseFlag.PERSONAL.value) != 0;
	}
}
