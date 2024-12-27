package com.github.mmo.game.scripting.basescripts;

import com.github.mmo.game.map.*;

public class InstanceMapScript extends MapScript<InstanceMap>
{
	public InstanceMapScript(String name, int mapId)
	{
		super(name, mapId);
		if (getEntry() != null && !getEntry().IsDungeon())
		{
			Log.outError(LogFilter.Scripts, "InstanceMapScript for map {0} is invalid.", mapId);
		}

		global.getScriptMgr().addScript(this);
	}

	@Override
	public boolean isDatabaseBound()
	{
		return true;
	}
}
