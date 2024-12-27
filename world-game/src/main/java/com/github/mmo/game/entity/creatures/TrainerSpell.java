package com.github.mmo.game.entity.creatures;



public class TrainerSpell
{
	private int spellId;
	public final int getSpellId()
	{
		return spellId;
	}
	public final void setSpellId(int value)
	{
		spellId = value;
	}
	private int moneyCost;
	public final int getMoneyCost()
	{
		return moneyCost;
	}
	public final void setMoneyCost(int value)
	{
		moneyCost = value;
	}
	private int reqSkillLine;
	public final int getReqSkillLine()
	{
		return reqSkillLine;
	}
	public final void setReqSkillLine(int value)
	{
		reqSkillLine = value;
	}
	private int reqSkillRank;
	public final int getReqSkillRank()
	{
		return reqSkillRank;
	}
	public final void setReqSkillRank(int value)
	{
		reqSkillRank = value;
	}
	private Array<Integer> reqAbility = new Array<Integer>(3);
	public final Array<Integer> getReqAbility()
	{
		return reqAbility;
	}
	public final void setReqAbility(Array<Integer> value)
	{
		reqAbility = value;
	}
	private byte reqLevel;
	public final byte getReqLevel()
	{
		return reqLevel;
	}
	public final void setReqLevel(byte value)
	{
		reqLevel = value;
	}

	public final boolean isCastable()
	{
		return global.getSpellMgr().getSpellInfo(getSpellId(), Difficulty.NONE).hasEffect(SpellEffectName.LearnSpell);
	}
}
