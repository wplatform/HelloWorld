package com.github.mmo.game.networking.packet.scenario;

import com.github.mmo.game.scenario.*;

import java.util.*;


final class ScenarioPOIData
{
	public int criteriaTreeID;
	public ArrayList<ScenarioPOI> scenarioPOIs;

	public ScenarioPOIData clone()
	{
		ScenarioPOIData varCopy = new ScenarioPOIData();

		varCopy.criteriaTreeID = this.criteriaTreeID;
		varCopy.scenarioPOIs = this.scenarioPOIs;

		return varCopy;
	}
}
