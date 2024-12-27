package com.github.mmo.game.scripting;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
public class ScriptAttribute extends Attribute
{
	private String name;
	public final String getName()
	{
		return name;
	}
	private void setName(String value)
	{
		name = value;
	}
	private Object[] args;
	public final Object[] getArgs()
	{
		return args;
	}
	private void setArgs(Object[] value)
	{
		args = value;
	}


	public ScriptAttribute(String name)
	{
		this(name,);
	}

	public ScriptAttribute(String name, object... args)
	{
		setName(name);
		setArgs(args);
	}
}
