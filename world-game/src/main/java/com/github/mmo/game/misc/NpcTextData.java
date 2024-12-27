package com.github.mmo.game.misc;

public final class NpcTextData
{
	public float probability;
	public int broadcastTextID;

	public NpcTextData clone()
	{
		NpcTextData varCopy = new NpcTextData();

		varCopy.probability = this.probability;
		varCopy.broadcastTextID = this.broadcastTextID;

		return varCopy;
	}
}
