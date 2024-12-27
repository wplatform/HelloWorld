package com.github.mmo.game.scripting.basescripts;

import com.github.mmo.game.scripting.*;

public class GenericSpellScriptLoader<S extends SpellScript> extends SpellScriptLoader
{
	private final Object[] args;

	public GenericSpellScriptLoader(String name, Object[] args)
	{
		super(name);
		args = args;
	}

	@Override
	public SpellScript getSpellScript()
	{
		return (S)system.Activator.CreateInstance(S.class, args);
	}
}
