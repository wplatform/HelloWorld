package com.github.mmo.game.scripting.interfaces;

public interface IScriptObject
{
	String getName();

	default boolean isDatabaseBound()
	{
		return false;
	}
}