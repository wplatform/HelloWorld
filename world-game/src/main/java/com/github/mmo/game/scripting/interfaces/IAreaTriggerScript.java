package com.github.mmo.game.scripting.interfaces;

import com.github.mmo.game.entity.areatrigger.AreaTrigger;

public interface IAreaTriggerScript
{
	AreaTrigger getAt();
	byte getCurrentScriptState();
	void setCurrentScriptState(byte value);
	String getScriptName();
	void setScriptName(String value);
	int getScriptAreaTriggerId();
	void setScriptAreaTriggerId(int value);

	boolean load();
	void register();
	void unload();
	String _GetScriptName();
	void _Init(String scriptname, int sreaTriggerId);
	void _Register();
	void _Unload();
}
