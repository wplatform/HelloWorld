package com.github.mmo.game.service.domain.misc;


import com.github.mmo.defines.Race;

import java.util.ArrayList;

public class RaceClassAvailability
{
	public Race raceID;
	public ArrayList<ClassAvailability> classes = new ArrayList<>(4);
}
