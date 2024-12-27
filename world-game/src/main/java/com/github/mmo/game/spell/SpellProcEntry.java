package com.github.mmo.game.spell;


public class SpellProcEntry
{
	private SpellschoolMask schoolMask = spellSchoolMask.values()[0];
	public final SpellSchoolMask getSchoolMask()
	{
		return schoolMask;
	}
	public final void setSchoolMask(SpellSchoolMask value)
	{
		schoolMask = value;
	}
	private spellFamilyNames spellFamilyName = SpellFamilyNames.values()[0];
	public final SpellFamilyNames getSpellFamilyName()
	{
		return spellFamilyName;
	}
	public final void setSpellFamilyName(SpellFamilyNames value)
	{
		spellFamilyName = value;
	}
	private flagArray128 spellFamilyMask = new flagArray128(4);
	public final FlagArray128 getSpellFamilyMask()
	{
		return spellFamilyMask;
	}
	public final void setSpellFamilyMask(FlagArray128 value)
	{
		spellFamilyMask = value;
	}
	private procFlagsInit procFlags;
	public final ProcFlagsInit getProcFlags()
	{
		return procFlags;
	}
	public final void setProcFlags(ProcFlagsInit value)
	{
		procFlags = value;
	}
	private ProcFlagsSpellType spellTypeMask = ProcFlagsSpellType.values()[0];
	public final ProcFlagsSpellType getSpellTypeMask()
	{
		return spellTypeMask;
	}
	public final void setSpellTypeMask(ProcFlagsSpellType value)
	{
		spellTypeMask = value;
	}
	private ProcFlagsSpellPhase spellPhaseMask = ProcFlagsSpellPhase.values()[0];
	public final ProcFlagsSpellPhase getSpellPhaseMask()
	{
		return spellPhaseMask;
	}
	public final void setSpellPhaseMask(ProcFlagsSpellPhase value)
	{
		spellPhaseMask = value;
	}
	private ProcFlagsHit hitMask = ProcFlagsHit.values()[0];
	public final ProcFlagsHit getHitMask()
	{
		return hitMask;
	}
	public final void setHitMask(ProcFlagsHit value)
	{
		hitMask = value;
	}
	private ProcAttributes attributesMask = ProcAttributes.values()[0];
	public final ProcAttributes getAttributesMask()
	{
		return attributesMask;
	}
	public final void setAttributesMask(ProcAttributes value)
	{
		attributesMask = value;
	}
	private int disableEffectsMask;
	public final int getDisableEffectsMask()
	{
		return disableEffectsMask;
	}
	public final void setDisableEffectsMask(int value)
	{
		disableEffectsMask = value;
	}
	private float procsPerMinute;
	public final float getProcsPerMinute()
	{
		return procsPerMinute;
	}
	public final void setProcsPerMinute(float value)
	{
		procsPerMinute = value;
	}
	private float chance;
	public final float getChance()
	{
		return chance;
	}
	public final void setChance(float value)
	{
		chance = value;
	}
	private int cooldown;
	public final int getCooldown()
	{
		return cooldown;
	}
	public final void setCooldown(int value)
	{
		cooldown = value;
	}
	private int charges;
	public final int getCharges()
	{
		return charges;
	}
	public final void setCharges(int value)
	{
		charges = value;
	}
}
