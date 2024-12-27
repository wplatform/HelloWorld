package com.github.mmo.game.pvp;


import com.github.mmo.game.map.*;
import com.github.mmo.game.scripting.*;
import com.github.mmo.game.scripting.interfaces.ioutdoorpvp.*;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class OutdoorPvP_hellfire_peninsula extends ScriptObjectAutoAddDBBound implements IOutdoorPvPGetOutdoorPvP
{
	public OutdoorPvP_hellfire_peninsula()
	{
		super("outdoorpvp_hp");
	}

	public final OutdoorPvP getOutdoorPvP(Map map)
	{
		return new HellfirePeninsulaPvP(map);
	}
}
