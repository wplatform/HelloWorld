package com.github.mmo.game;


public final class ExtendedPlayerName
{
	public ExtendedPlayerName()
	{
	}

	public ExtendedPlayerName(String name, String realmName)
	{
		name = name;
		realm = realmName;
	}

	public String name;
	public String realm;

	public ExtendedPlayerName clone()
	{
		ExtendedPlayerName varCopy = new ExtendedPlayerName();

		varCopy.name = this.name;
		varCopy.realm = this.realm;

		return varCopy;
	}
}
