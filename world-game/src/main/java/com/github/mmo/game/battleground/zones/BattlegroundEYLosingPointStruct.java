package com.github.mmo.game.battleground.zones;



final class BattlegroundEYLosingPointStruct
{
	public BattlegroundEYLosingPointStruct()
	{
	}

	public BattlegroundEYLosingPointStruct(int _SpawnNeutralObjectType, int _DespawnObjectTypeAlliance, int _MessageIdAlliance, int _DespawnObjectTypeHorde, int _MessageIdHorde)
	{
		spawnNeutralObjectType = _SpawnNeutralObjectType;
		despawnObjectTypeAlliance = _DespawnObjectTypeAlliance;
		messageIdAlliance = _MessageIdAlliance;
		despawnObjectTypeHorde = _DespawnObjectTypeHorde;
		messageIdHorde = _MessageIdHorde;
	}

	public int spawnNeutralObjectType;
	public int despawnObjectTypeAlliance;
	public int messageIdAlliance;
	public int despawnObjectTypeHorde;
	public int messageIdHorde;

	public BattlegroundEYLosingPointStruct clone()
	{
		BattlegroundEYLosingPointStruct varCopy = new BattlegroundEYLosingPointStruct();

		varCopy.spawnNeutralObjectType = this.spawnNeutralObjectType;
		varCopy.despawnObjectTypeAlliance = this.despawnObjectTypeAlliance;
		varCopy.messageIdAlliance = this.messageIdAlliance;
		varCopy.despawnObjectTypeHorde = this.despawnObjectTypeHorde;
		varCopy.messageIdHorde = this.messageIdHorde;

		return varCopy;
	}
}