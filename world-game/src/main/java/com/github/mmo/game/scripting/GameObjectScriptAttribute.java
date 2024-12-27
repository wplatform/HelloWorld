package com.github.mmo.game.scripting;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
public class GameObjectScriptAttribute extends ScriptAttribute
{
	private int[] gameObjectIds;
	public final int[] getGameObjectIds()
	{
		return gameObjectIds;
	}
	private void setGameObjectIds(int[] value)
	{
		gameObjectIds = value;
	}


	public GameObjectScriptAttribute(String name)
	{
		this(name,);
	}

	public GameObjectScriptAttribute(String name, object... args)
	{
		super(name, args);
	}


	public GameObjectScriptAttribute(int gameObjectId, String name)
	{
		this(gameObjectId, name,);
	}

	public GameObjectScriptAttribute(int gameObjectId, String name, object... args)
	{
		super(name, args);
		setGameObjectIds(new int[] {gameObjectId});
	}


	public GameObjectScriptAttribute(int[] gameObjectIds, String name)
	{
		this(gameObjectIds, name,);
	}

	public GameObjectScriptAttribute(int[] gameObjectIds, String name, object... args)
	{
		super(name, args);
		setGameObjectIds(gameObjectIds);
	}
}
