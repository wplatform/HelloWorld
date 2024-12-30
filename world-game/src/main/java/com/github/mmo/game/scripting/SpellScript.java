package com.github.mmo.game.scripting;


import com.github.mmo.game.entity.corpse.Corpse;
import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.item.Item;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.ISpellScript;
import com.github.mmo.game.spell.*;

import java.util.ArrayList;
import java.util.Objects;

public class SpellScript extends BaseSpellScript implements ISpellScript {
    private Spell spell;

    private int hitPreventEffectMask;

    private int hitPreventDefaultEffectMask;

    public final boolean isInCheckCastHook() {
        return getCurrentScriptState() == (byte) SpellScriptHookType.CheckCast.getValue();
    }

    public final boolean isInTargetHook() {
        switch (SpellScriptHookType.forValue(getCurrentScriptState())) {
            case LaunchTarget:
            case EffectHitTarget:
            case EffectSuccessfulDispel:
            case BeforeHit:
            case Hit:
            case AfterHit:
                return true;
        }

        return false;
    }

    public final boolean isInHitPhase() {
        return getCurrentScriptState() >= (byte) SpellScriptHookType.EffectHit.getValue() && getCurrentScriptState() < (byte) SpellScriptHookType.AfterHit.getValue() + 1;
    }

    public final boolean isInEffectHook() {
        return getCurrentScriptState() >= (byte) SpellScriptHookType.Launch.getValue() && getCurrentScriptState() <= (byte) SpellScriptHookType.EffectHitTarget.getValue() || getCurrentScriptState() == (byte) SpellScriptHookType.EffectSuccessfulDispel.getValue();
    }

    // hooks are executed in following order, at specified event of spell:
    // 1. BeforeCast - executed when spell preparation is finished (when cast bar becomes full) before cast is handled
    // 2. OnCheckCast - allows to override result of CheckCast function
    // 3a. OnObjectAreaTargetSelect - executed just before adding selected targets to final Target list (for area targets)
    // 3b. OnObjectTargetSelect - executed just before adding selected Target to final Target list (for single unit targets)
    // 4. OnCast - executed just before spell is launched (creates missile) or executed
    // 5. AfterCast - executed after spell missile is launched and immediate spell actions are done
    // 6. OnEffectLaunch - executed just before specified effect handler call - when spell missile is launched
    // 7. OnEffectLaunchTarget - executed just before specified effect handler call - when spell missile is launched - called for each Target from spell Target map
    // 8. OnEffectHit - executed just before specified effect handler call - when spell missile hits dest
    // 9. BeforeHit - executed just before spell hits a Target - called for each Target from spell Target map
    // 10. OnEffectHitTarget - executed just before specified effect handler call - called for each Target from spell Target map
    // 11. OnHit - executed just before spell deals Damage and procs Auras - when spell hits Target - called for each Target from spell Target map
    // 12. AfterHit - executed just after spell finishes all it's jobs for Target - called for each Target from spell Target map

    //
    // methods allowing interaction with Spell object
    //
    // methods useable during all spell handling phases
    public final Unit getCaster() {
        return spell.getCaster().toUnit();
    }

    public final GameObject getGObjCaster() {
        return spell.getCaster().toGameObject();
    }

    public final Unit getOriginalCaster() {
        return spell.getOriginalCaster();
    }

    public final SpellInfo getSpellInfo() {
        return spell.spellInfo;
    }

    public final Difficulty getCastDifficulty() {
        return spell.getCastDifficulty();
    }

    public final SpellValue getSpellValue() {
        return spell.spellValue;
    }

    // methods useable after spell is prepared
    // accessors to the explicit targets of the spell
    // explicit Target - Target selected by caster (player, game client, or script - doCast(explicitTarget, ...), required for spell to be cast
    // examples:
    // -shadowstep - explicit Target is the unit you want to go behind of
    // -chain heal - explicit Target is the unit to be healed first
    // -holy nova/arcane explosion - explicit target = null because Target you are selecting doesn't affect how spell targets are selected
    // you can determine if spell requires explicit targets by dbc columns:
    // - Targets - mask of explicit Target types
    // - ImplicitTargetXX set to TARGET_XXX_TARGET_YYY, _TARGET_ here means that explicit Target is used by the effect, so spell needs one too

    // returns: WorldLocation which was selected as a spell destination or null
    public final WorldLocation getExplTargetDest() {
        if (spell.targets.getHasDst()) {
            return spell.targets.getDstPos();
        }

        return null;
    }

    public final void setExplTargetDest(WorldLocation value) {
        spell.targets.setDst(value);
    }

    // returns: WorldObject which was selected as an explicit spell Target or null if there's no Target
    public final WorldObject getExplTargetWorldObject() {
        return spell.targets.getObjectTarget();
    }

    // returns: Unit which was selected as an explicit spell Target or null if there's no Target
    public final Unit getExplTargetUnit() {
        return spell.targets.getUnitTarget();
    }

    // returns: GameObject which was selected as an explicit spell Target or null if there's no Target
    public final GameObject getExplTargetGObj() {
        return spell.targets.getGOTarget();
    }

    // returns: Item which was selected as an explicit spell Target or null if there's no Target
    public final Item getExplTargetItem() {
        return spell.targets.getItemTarget();
    }

    /**
     * useable only during spell hit on target, or during spell launch on Target
     *
     * @return Target of current effect if it was Unit otherwise null
     */
    public final Unit getHitUnit() {
        if (!isInTargetHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.GetHitUnit was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return null;
        }

        return spell.unitTarget;
    }

    /**
     * @return Target of current effect if it was Creature otherwise null
     */
    public final Creature getHitCreature() {
        if (!isInTargetHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.GetHitCreature was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return null;
        }

        if (spell.unitTarget != null) {
            return spell.unitTarget.toCreature();
        } else {
            return null;
        }
    }

    /**
     * @return Target of current effect if it was Player otherwise null
     */
    public final Player getHitPlayer() {
        if (!isInTargetHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.GetHitPlayer was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return null;
        }

        if (spell.unitTarget != null) {
            return spell.unitTarget.toPlayer();
        } else {
            return null;
        }
    }

    /**
     * @return Target of current effect if it was Item otherwise null
     */
    public final Item getHitItem() {
        if (!isInTargetHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.GetHitItem was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return null;
        }

        return spell.itemTarget;
    }

    /**
     * @return Target of current effect if it was GameObject otherwise null
     */
    public final GameObject getHitGObj() {
        if (!isInTargetHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.GetHitGObj was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return null;
        }

        return spell.gameObjTarget;
    }

    /**
     * @return Target of current effect if it was Corpse otherwise nullptr
     */
    public final Corpse getHitCorpse() {
        if (!isInTargetHook()) {
            Log.outError(LogFilter.Scripts, String.format("Script: `%1$s` Spell: `%2$s`: function SpellScript::GetHitCorpse was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId()));

            return null;
        }

        return spell.corpseTarget;
    }

    /**
     * @return destination of current effect
     */
    public final WorldLocation getHitDest() {
        if (!isInEffectHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.GetHitDest was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return null;
        }

        return spell.destTarget;
    }

    // setter/getter for for Damage done by spell to Target of spell hit
    // returns Damage calculated before hit, and real dmg done after hit
    public final double getHitDamage() {
        if (!isInTargetHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.GetHitDamage was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return 0;
        }

        return spell.damageInEffects;
    }

    public final void setHitDamage(double value) {
        if (!isInModifiableHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.SetHitDamage was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return;
        }

        spell.damageInEffects = value;
    }

    // setter/getter for for heal done by spell to Target of spell hit
    // returns healing calculated before hit, and real dmg done after hit
    public final double getHitHeal() {
        if (!isInTargetHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.GetHitHeal was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return 0;
        }

        return spell.healingInEffects;
    }

    public final void setHitHeal(double value) {
        if (!isInModifiableHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.SetHitHeal was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return;
        }

        spell.healingInEffects = value;
    }

    public final Spell getSpell() {
        return spell;
    }

    /**
     * @return true if spell critically hits current HitUnit
     */
    public final boolean isHitCrit() {
        if (!isInTargetHook()) {
            Log.outError(LogFilter.Scripts, String.format("Script: `%1$s` Spell: `%2$s`: function SpellScript::IsHitCrit was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId()));

            return false;
        }

        var hitUnit = getHitUnit();

        if (hitUnit != null) {
            var targetInfo = tangible.ListHelper.find(spell.uniqueTargetInfoOrgi, targetInfo -> Objects.equals(targetInfo.targetGuid, hitUnit.getGUID()));

            return targetInfo.isCrit;
        }

        return false;
    }

    public final SpellEffectInfo getEffectInfo() {
        return spell.effectInfo;
    }

    // method avalible only in EffectHandler method
    public final double getEffectValue() {
        if (!isInEffectHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.PreventHitDefaultEffect was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return 0;
        }

        return spell.damage;
    }

    public final void setEffectValue(double value) {
        if (!isInEffectHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.SetEffectValue was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return;
        }

        spell.damage = value;
    }

    public final double getEffectVariance() {
        if (!isInEffectHook()) {
            Log.outError(LogFilter.Scripts, String.format("Script: `%1$s` Spell: `%2$s`: function SpellScript::GetEffectVariance was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId()));

            return 0.0f;
        }

        return spell.variance;
    }

    public final void setEffectVariance(double value) {
        if (!isInEffectHook()) {
            Log.outError(LogFilter.Scripts, String.format("Script: `%1$s` Spell: `%2$s`: function SpellScript::SetEffectVariance was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId()));

            return;
        }

        spell.variance = value;
    }

    // returns: cast Item if present.
    public final Item getCastItem() {
        return spell.castItem;
    }

    // Returns SpellInfo from the spell that triggered the current one
    public final SpellInfo getTriggeringSpell() {
        return spell.triggeredByAuraSpell;
    }

    public final Position getTargetPosition() {
        Position pos = getExplTargetWorldObject().getLocation();

        if (pos == null || pos.isDefault() || !pos.isPositionValid()) {
            pos = spell.targets.getDst().position;
        }

        return pos;
    }

    private boolean isAfterTargetSelectionPhase() {
        return isInHitPhase() || isInEffectHook() || getCurrentScriptState() == (byte) SpellScriptHookType.OnCast.getValue() || getCurrentScriptState() == (byte) SpellScriptHookType.AfterCast.getValue() || getCurrentScriptState() == (byte) SpellScriptHookType.CalcCritChance.getValue();
    }

    private boolean isInModifiableHook() {
        // after hit hook executed after Damage/healing is already done
        // modifying it at this point has no effect
        switch (SpellScriptHookType.forValue(getCurrentScriptState())) {
            case LaunchTarget:
            case EffectHitTarget:
            case BeforeHit:
            case Hit:
                return true;
        }

        return false;
    }

    public final boolean _Load(Spell spell) {
        spell = spell;
        _PrepareScriptCall(SpellScriptHookType.forValue(SpellScriptState.Loading));
        var load = load();
        _FinishScriptCall();

        return load;
    }

    public final void _InitHit() {
        hitPreventEffectMask = 0;
        hitPreventDefaultEffectMask = 0;
    }

    public final boolean _IsEffectPrevented(int effIndex) {
        return (boolean) (hitPreventEffectMask & 1 << effIndex);
    }

    public final boolean _IsDefaultEffectPrevented(int effIndex) {
        return (boolean) (hitPreventDefaultEffectMask & 1 << effIndex);
    }

    public final void _PrepareScriptCall(SpellScriptHookType hookType) {
        setCurrentScriptState((byte) hookType.getValue());
    }

    public final void _FinishScriptCall() {
        setCurrentScriptState((byte) SpellScriptState.NONE.getValue());
    }

    public final SpellEffectInfo getEffectInfo(int effIndex) {
        return getSpellInfo().getEffect(effIndex);
    }

    public final long getUnitTargetCountForEffect(int effect) {
        if (!isAfterTargetSelectionPhase()) {
            Log.outError(LogFilter.Scripts, String.format("Script: `%1$s` Spell: `%2$s`: function SpellScript.GetUnitTargetCountForEffect was called, but function has no effect in current hook! (spell has not selected targets yet)", getScriptName(), getScriptSpellId()));

            return 0;
        }

        return spell.getUnitTargetCountForEffect(effect);
    }

    public final long getGameObjectTargetCountForEffect(int effect) {
        if (!isAfterTargetSelectionPhase()) {
            Log.outError(LogFilter.Scripts, String.format("Script: `%1$s` Spell: `%2$s`: function SpellScript.GetGameObjectTargetCountForEffect was called, but function has no effect in current hook! (spell has not selected targets yet)", getScriptName(), getScriptSpellId()));

            return 0;
        }

        return spell.getGameObjectTargetCountForEffect(effect);
    }

    public final long getItemTargetCountForEffect(int effect) {
        if (!isAfterTargetSelectionPhase()) {
            Log.outError(LogFilter.Scripts, String.format("Script: `%1$s` Spell: `%2$s`: function SpellScript.GetItemTargetCountForEffect was called, but function has no effect in current hook! (spell has not selected targets yet)", getScriptName(), getScriptSpellId()));

            return 0;
        }

        return spell.getItemTargetCountForEffect(effect);
    }

    public final long getCorpseTargetCountForEffect(int effect) {
        if (!isAfterTargetSelectionPhase()) {
            Log.outError(LogFilter.Scripts, String.format("Script: `%1$s` Spell: `%2$s`: function SpellScript::GetCorpseTargetCountForEffect was called, but function has no effect in current hook! (spell has not selected targets yet)", getScriptName(), getScriptSpellId()));

            return 0;
        }

        return spell.getCorpseTargetCountForEffect(effect);
    }

    public final void preventHitDamage() {
        setHitDamage(0);
    }

    // returns current spell hit Target aura

    public final Aura getHitAura() {
        return getHitAura(false);
    }

    public final Aura getHitAura(boolean dynObjAura) {
        if (!isInTargetHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.GetHitAura was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return null;
        }

        Aura aura = spell.spellAura;

        if (dynObjAura) {
            aura = spell.dynObjAura;
        }

        if (aura == null || aura.isRemoved()) {
            return null;
        }

        return aura;
    }

    // prevents applying aura on current spell hit Target
    public final void preventHitAura() {
        if (!isInTargetHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.PreventHitAura was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return;
        }

        var unitAura = spell.spellAura;
        if (unitAura != null) {
            unitAura.remove();
        }

        var dynAura = spell.dynObjAura;
        if (dynAura != null) {
            dynAura.remove();
        }
    }

    // prevents effect execution on current spell hit Target
    // including other effect/hit scripts
    // will not work on aura/Damage/heal
    // will not work if effects were already handled
    public final void preventHitEffect(int effIndex) {
        if (!isInHitPhase() && !isInEffectHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.PreventHitEffect was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return;
        }

        hitPreventEffectMask |= 1 << effIndex;
        preventHitDefaultEffect(effIndex);
    }

    // prevents default effect execution on current spell hit Target
    // will not work on aura/Damage/heal effects
    // will not work if effects were already handled
    public final void preventHitDefaultEffect(int effIndex) {
        if (!isInHitPhase() && !isInEffectHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.PreventHitDefaultEffect was called, but function has no effect in current hook!", getScriptName(), getScriptSpellId());

            return;
        }

        hitPreventDefaultEffectMask |= 1 << effIndex;
    }

    // Creates item. Calls spell.DoCreateItem method.
    public final void createItem(int itemId, ItemContext context) {
        spell.doCreateItem(itemId, context);
    }

    // finishes spellcast prematurely with selected error message

    public final void finishCast(SpellCastResult result, Integer param1) {
        finishCast(result, param1, null);
    }

    public final void finishCast(SpellCastResult result) {
        finishCast(result, null, null);
    }

    public final void finishCast(SpellCastResult result, Integer param1, Integer param2) {
        spell.sendCastResult(result, param1, param2);
        spell.finish(result);
    }

    public final void setCustomCastResultMessage(SpellCustomErrors result) {
        if (!isInCheckCastHook()) {
            Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}`: function SpellScript.SetCustomCastResultMessage was called while spell not in check cast phase!", getScriptName(), getScriptSpellId());

            return;
        }

        spell.customErrors = result;
    }


    public final void selectRandomInjuredTargets(ArrayList<WorldObject> targets, int maxTargets, boolean prioritizePlayers) {
        if (targets.size() <= maxTargets) {
            return;
        }

        //List of all player targets.
        var tempPlayers = targets.stream().filter(p -> p.IsPlayer).collect(Collectors.toList());

        //List of all injured non player targets.
        var tempInjuredUnits = targets.stream().filter(target -> target.IsUnit && !target.AsUnit.IsFullHealth).collect(Collectors.toList());

        //List of all none injured non player targets.
        var tempNoneInjuredUnits = targets.stream().filter(target -> target.IsUnit && target.AsUnit.IsFullHealth).collect(Collectors.toList());

        targets.clear();

        if (prioritizePlayers) {
            if (tempPlayers.size() < maxTargets) {
                // not enough players, add nonplayer targets
                // prioritize injured nonplayers over full health nonplayers
                if (tempPlayers.size() + tempInjuredUnits.size() < maxTargets) {
                    // not enough players + injured nonplayers
                    // fill remainder with random full health nonplayers
                    targets.addAll(tempPlayers);
                    targets.addAll(tempInjuredUnits);
                    targets.addAll(tempNoneInjuredUnits.shuffle());
                } else if (tempPlayers.size() + tempInjuredUnits.size() > maxTargets) {
                    // randomize injured nonplayers order
                    // final list will contain all players + random injured nonplayers
                    targets.addAll(tempPlayers);
                    targets.addAll(tempInjuredUnits.shuffle());
                }

                targets.Resize(maxTargets);

                return;
            }
        }

        var lookupPlayers = tempPlayers.ToLookup(target -> !target.AsUnit.IsFullHealth);

        if (lookupPlayers[true].count() < maxTargets) {
            // not enough injured units
            // fill remainder with full health units
            targets.addAll(lookupPlayers[true]);
            targets.addAll(lookupPlayers[false].shuffle());
        } else if (lookupPlayers[true].count() > maxTargets) {
            // select random injured units
            targets.addAll(lookupPlayers[true].shuffle());
        }

        targets.Resize(maxTargets);
    }

    public final boolean tryGetCaster(tangible.OutObject<unit> result) {
        result.outArgValue = spell.getCaster() == null ? null : spell.getCaster().toUnit();

        return result.outArgValue != null;
    }

    public final boolean tryGetCaster(tangible.OutObject<Player> result) {
        result.outArgValue = spell.getCaster() == null ? null : spell.getCaster().toPlayer();

        return result.outArgValue != null;
    }

    public final boolean tryGetExplTargetUnit(tangible.OutObject<unit> target) {
        target.outArgValue = spell.targets.getUnitTarget();

        return target.outArgValue != null;
    }

    public final void preventHitHeal() {
        setHitHeal(0);
    }
}
