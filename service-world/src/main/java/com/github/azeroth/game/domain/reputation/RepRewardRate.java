package com.github.azeroth.game.domain.reputation;
public class RepRewardRate
{
	public int factionId;
	public float questRate; // We allow rate = 0.0 in database. For this case, it means that
	public float questDailyRate;
	public float questWeeklyRate;
	public float questMonthlyRate;
	public float questRepeatableRate;
	public float creatureRate; // no reputation are given at all for this faction/rate type.
	public float spellRate;
}
