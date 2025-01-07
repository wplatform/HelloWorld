package com.github.azeroth.game.domain.misc;


import com.github.azeroth.defines.Race;

import java.util.ArrayList;

public class RaceClassAvailability
{
	public Race raceID;
	public ArrayList<ClassAvailability> classes = new ArrayList<>(4);
}
