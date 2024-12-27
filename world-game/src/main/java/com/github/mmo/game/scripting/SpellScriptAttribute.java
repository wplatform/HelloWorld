package com.github.mmo.game.scripting;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
public class SpellScriptAttribute extends ScriptAttribute
{
	private int[] spellIds;
	public final int[] getSpellIds()
	{
		return spellIds;
	}
	private void setSpellIds(int[] value)
	{
		spellIds = value;
	}
	private boolean allRanks;
	public final boolean getAllRanks()
	{
		return allRanks;
	}
	private void setAllRanks(boolean value)
	{
		allRanks = value;
	}

	public SpellScriptAttribute(Integer... spellId)
	{
		super("", new Object[0]);
		setSpellIds(spellId);
	}


	public SpellScriptAttribute(String name)
	{
		this(name,);
	}

	public SpellScriptAttribute(String name, object... args)
	{
		super(name, args);
	}


	public SpellScriptAttribute(int spellId, String name, boolean allRanks)
	{
		this(spellId, name, allRanks,);
	}

	public SpellScriptAttribute(int spellId, String name)
	{
		this(spellId, name, false,);
	}

	public SpellScriptAttribute(int spellId, String name, boolean allRanks, object... args)
	{
		super(name, args);
		setSpellIds(new int[] {spellId});

		setAllRanks(allRanks);
	}


	public SpellScriptAttribute(int[] spellId, String name, boolean allRanks)
	{
		this(spellId, name, allRanks,);
	}

	public SpellScriptAttribute(int[] spellId, String name)
	{
		this(spellId, name, false,);
	}

	public SpellScriptAttribute(int[] spellId, String name, boolean allRanks, object... args)
	{
		super(name, args);
		setSpellIds(spellId);
		setAllRanks(allRanks);
	}
}
