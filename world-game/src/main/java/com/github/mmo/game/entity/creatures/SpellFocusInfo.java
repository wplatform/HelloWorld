package com.github.mmo.game.entity;

final class SpellFocusInfo
{
	public spell spell;
	public int delay; // ms until the creature's target should snap back (0 = no snapback scheduled)
	public ObjectGuid target = ObjectGuid.EMPTY; // the creature's "real" target while casting
	public float orientation; // the creature's "real" orientation while casting

	public SpellFocusInfo clone()
	{
		SpellFocusInfo varCopy = new spellFocusInfo();

		varCopy.spell = this.spell;
		varCopy.delay = this.delay;
		varCopy.target = this.target;
		varCopy.orientation = this.orientation;

		return varCopy;
	}
}
