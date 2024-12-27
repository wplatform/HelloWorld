package com.github.mmo.game.scripting.registers;

import com.github.mmo.game.scripting.interfaces.*;
import com.github.mmo.game.scripting.*;

public class SpellScriptRegister implements IScriptRegister
{
	public final Class getAttributeType()
	{
		return SpellScriptAttribute.class;
	}

	public final void register(ScriptAttribute attribute, IScriptObject script, String scriptName)
	{
		if (attribute instanceof SpellScriptAttribute spellScript && spellScript.getSpellIds() != null)
		{
			for (var id : spellScript.getSpellIds())
			{
				global.getObjectMgr().registerSpellScript(id, scriptName, spellScript.getAllRanks());
			}
		}
	}
}
