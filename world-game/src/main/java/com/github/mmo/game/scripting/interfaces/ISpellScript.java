package com.github.mmo.game.scripting.interfaces;


import com.github.mmo.game.entity.corpse.Corpse;
import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.item.Item;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.spell.*;

import java.util.*;


public interface ISpellScript extends IBaseSpellScript
{
	Difficulty getCastDifficulty();
	Unit getCaster();

	Item getCastItem();
	SpellEffectInfo getEffectInfo();
	double getEffectValue();
	void setEffectValue(double value);

	double getEffectVariance();
	void setEffectVariance(double value);
	WorldLocation getExplTargetDest();
	void setExplTargetDest(WorldLocation value);

	GameObject getExplTargetGObj();

	Item getExplTargetItem();
	Unit getExplTargetUnit();
	WorldObject getExplTargetWorldObject();
	GameObject getGObjCaster();
	Corpse getHitCorpse();
	Creature getHitCreature();

	double getHitDamage();
	void setHitDamage(double value);
	WorldLocation getHitDest();
	GameObject getHitGObj();

	double getHitHeal();
	void setHitHeal(double value);
	Item getHitItem();
	Player getHitPlayer();
	Unit getHitUnit();
	Unit getOriginalCaster();

	Spell getSpell();
	SpellInfo getSpellInfo();

	SpellValue getSpellValue();

	SpellInfo getTriggeringSpell();
	boolean isHitCrit();
	boolean isInCheckCastHook();
	boolean isInEffectHook();
	boolean isInHitPhase();

	boolean isInTargetHook();
	void createItem(int itemId, ItemContext context);

	void finishCast(SpellCastResult result, Integer param1);
	void finishCast(SpellCastResult result);
	void finishCast(SpellCastResult result, Integer param1, Integer param2);

	long getCorpseTargetCountForEffect(int effect);

	SpellEffectInfo getEffectInfo(int effIndex);

	long getGameObjectTargetCountForEffect(int effect);


	Aura getHitAura();
	Aura getHitAura(boolean dynObjAura);

	long getItemTargetCountForEffect(int effect);

	long getUnitTargetCountForEffect(int effect);

	void preventHitAura();
	void preventHitDamage();
	void preventHitDefaultEffect(int effIndex);
	void preventHitEffect(int effIndex);
	void selectRandomInjuredTargets(ArrayList<WorldObject> targets, int maxTargets, boolean prioritizePlayers);
	void setCustomCastResultMessage(SpellCustomErrors result);
	void _FinishScriptCall();
	void _InitHit();
	boolean _IsDefaultEffectPrevented(int effIndex);
	boolean _IsEffectPrevented(int effIndex);
	boolean _Load(Spell spell);
	void _PrepareScriptCall(SpellScriptHookType hookType);
}
