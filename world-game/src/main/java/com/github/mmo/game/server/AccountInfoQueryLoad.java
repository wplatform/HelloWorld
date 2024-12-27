package com.github.mmo.game.server;
enum AccountInfoQueryLoad
{
	GlobalAccountToys,
	BattlePets,
	BattlePetSlot,
	GlobalAccountHeirlooms,
	GlobalRealmCharacterCounts,
	mounts,
	ItemAppearances,
	ItemFavoriteAppearances,
	GlobalAccountDataIndexPerRealm,
	TutorialsIndexPerRealm,
	transmogIllusions;

	public static final int SIZE = Integer.SIZE;

	public int getValue()
	{
		return this.ordinal();
	}

	public static AccountInfoQueryLoad forValue(int value)
	{
		return values()[value];
	}
}
