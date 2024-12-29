package com.github.mmo.game.service.model.misc;


import com.github.mmo.defines.Race;
import com.github.mmo.game.service.model.misc.ClassAvailability;

import java.util.ArrayList;

public class RaceClassAvailability
{
	public Race raceID;
	public ArrayList<ClassAvailability> classes = new ArrayList<>(4);
}
