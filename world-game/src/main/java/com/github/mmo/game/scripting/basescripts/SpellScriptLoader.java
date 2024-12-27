package com.github.mmo.game.scripting.basescripts;

import com.github.mmo.game.scripting.interfaces.ispell.*;
import com.github.mmo.game.scripting.*;

public class SpellScriptLoader extends ScriptObject implements ISpellScriptLoaderGetSpellScript
{
	public SpellScriptLoader(String name)
	{
		super(name);
		global.getScriptMgr().addScript(this);
	}

	@Override
	public boolean isDatabaseBound()
	{
		return true;
	}

	// Should return a fully valid SpellScript.
	public SpellScript getSpellScript()
	{
		return null;
	}
}
