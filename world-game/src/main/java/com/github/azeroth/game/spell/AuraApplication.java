package com.github.azeroth.game.spell;


import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.networking.packet.AuraDataInfo;
import com.github.azeroth.game.networking.packet.AuraInfo;
import com.github.azeroth.game.networking.packet.AuraUpdate;

import java.util.HashSet;
import java.util.UUID;


public class AuraApplication {
    private final Unit target;
    private final Aura base;
    private final byte slot; // Aura slot on unit
    private final HashSet<Integer> effectMask = new HashSet<Integer>();
    private final UUID guid = system.guid.NewGuid();
    private AuraFlags flags = AuraFlags.values()[0]; // Aura info flag
    private HashSet<Integer> effectsToApply = new HashSet<Integer>(); // Used only at spell hit to determine which effect should be applied
    private boolean needClientUpdate;
    private AuraremoveMode removeMode = AuraRemoveMode.values()[0];

    public AuraApplication(Unit target, Unit caster, Aura aura, HashSet<Integer> effMask) {
        target = target;
        base = aura;
        setRemoveMode(AuraRemoveMode.NONE);
        slot = SpellConst.MaxAuras;
        flags = AuraFlags.NONE;
        effectsToApply = effMask;
        needClientUpdate = false;

        // Try find slot for aura
        byte slot = 0;

        // Lookup for auras already applied from spell
        for (var visibleAura : getTarget().getVisibleAuras()) {
            if (slot < visibleAura.getSlot()) {
                break;
            }

            ++slot;
        }

        // Register Visible Aura
        if (slot < SpellConst.MaxAuras) {
            slot = slot;
            getTarget().setVisibleAura(this);
            needClientUpdate = true;
            Log.outDebug(LogFilter.spells, "Aura: {0} Effect: {1} put to unit visible auras slot: {2}", getBase().getId(), getEffectMask(), slot);
        } else {
            Log.outError(LogFilter.spells, "Aura: {0} Effect: {1} could not find empty unit visible slot", getBase().getId(), getEffectMask());
        }


        _InitFlags(caster, effMask);
    }

    public final UUID getGuid() {
        return guid;
    }

    public final Unit getTarget() {
        return target;
    }

    public final Aura getBase() {
        return base;
    }

    public final byte getSlot() {
        return slot;
    }

    public final AuraFlags getFlags() {
        return flags;
    }

    public final HashSet<Integer> getEffectMask() {
        return effectMask;
    }

    public final boolean isPositive() {
        return flags.hasFlag(AuraFlags.positive);
    }

    public final HashSet<Integer> getEffectsToApply() {
        return effectsToApply;
    }

    public final AuraRemoveMode getRemoveMode() {
        return removeMode;
    }

    public final void setRemoveMode(AuraRemoveMode value) {
        removeMode = value;
    }

    public final boolean getHasRemoveMode() {
        return getRemoveMode() != 0;
    }

    public final boolean isNeedClientUpdate() {
        return needClientUpdate;
    }

    private boolean isSelfcasted() {
        return flags.hasFlag(AuraFlags.NOCASTER);
    }

    public final void _Remove() {
        // update for out of range group members
        if (getSlot() < SpellConst.MaxAuras) {
            getTarget().removeVisibleAura(this);
            clientUpdate(true);
        }
    }

    public final void _HandleEffect(int effIndex, boolean apply) {
        var aurEff = getBase().getEffect(effIndex);

        if (aurEff == null) {
            Log.outError(LogFilter.spells, "Aura {0} has no effect at effectIndex {1} but _HandleEffect was called", getBase().getSpellInfo().getId(), effIndex);

            return;
        }

        if (hasEffect(effIndex) != (!apply)) {
            Log.outError(LogFilter.spells, "Aura {0} has effect at effectIndex {1}(has effect: {2}) but _HandleEffect with {3} was called", getBase().getSpellInfo().getId(), effIndex, hasEffect(effIndex), apply);

            return;
        }

        Log.outDebug(LogFilter.spells, "AuraApplication._HandleEffect: {0}, apply: {1}: amount: {2}", aurEff.getAuraType(), apply, aurEff.getAmount());

        if (apply) {
            effectMask.add(effIndex);
            aurEff.handleEffect(this, AuraEffectHandleModes.Real, true);
        } else {
            effectMask.remove((Integer) effIndex);
            aurEff.handleEffect(this, AuraEffectHandleModes.Real, false);
        }

        setNeedClientUpdate();
    }

    public final void updateApplyEffectMask(HashSet<Integer> newEffMask, boolean canHandleNewEffects) {
        if (effectsToApply.SetEquals(newEffMask)) {
            return;
        }

        var toAdd = newEffMask.ToHashSet();
        var toRemove = effectsToApply.ToHashSet();

        toAdd.SymmetricExceptWith(effectsToApply);
        toRemove.SymmetricExceptWith(newEffMask);

        toAdd.ExceptWith(effectsToApply);
        toRemove.ExceptWith(newEffMask);

        // quick check, removes application completely
        if (toAdd.SetEquals(toRemove) && toAdd.count == 0) {
            target._UnapplyAura(this, AuraRemoveMode.Default);

            return;
        }

        // update real effects only if they were applied already
        effectsToApply = newEffMask;

        for (var eff : getBase().getAuraEffects().entrySet()) {
            if (hasEffect(eff.getKey()) && toRemove.contains(eff.getKey())) {
                _HandleEffect(eff.getKey(), false);
            }

            if (canHandleNewEffects) {
                if (toAdd.contains(eff.getKey())) {
                    _HandleEffect(eff.getKey(), true);
                }
            }
        }
    }

    public final void setNeedClientUpdate() {
        if (needClientUpdate || getRemoveMode() != AuraRemoveMode.NONE) {
            return;
        }

        needClientUpdate = true;
        target.setVisibleAuraUpdate(this);
    }

    public final void buildUpdatePacket(tangible.RefObject<AuraInfo> auraInfo, boolean remove) {
        auraInfo.refArgValue.slot = getSlot();

        if (remove) {
            return;
        }

        auraInfo.refArgValue.auraData = new AuraDataInfo();

        var aura = getBase();

        var auraData = auraInfo.refArgValue.auraData;
        auraData.castID = aura.getCastId();
        auraData.spellID = (int) aura.getId();
        auraData.visual = aura.getSpellVisual();
        auraData.flags = getFlags();

        if (aura.getAuraObjType() != AuraObjectType.DynObj && aura.getMaxDuration() > 0 && !aura.getSpellInfo().hasAttribute(SpellAttr5.DoNotDisplayDuration)) {
            auraData.flags = AuraFlags.forValue(auraData.flags.getValue() | AuraFlags.duration.getValue());
        }

        auraData.activeFlags = getEffectMask();

        if (!aura.getSpellInfo().hasAttribute(SpellAttr11.ScalesWithItemLevel)) {
            auraData.castLevel = aura.getCasterLevel();
        } else {
            auraData.castLevel = (short) aura.getCastItemLevel();
        }

        // send stack amount for aura which could be stacked (never 0 - causes incorrect display) or charges
        // stack amount has priority over charges (checked on retail with spell 50262)
        auraData.applications = aura.isUsingStacks() ? aura.getStackAmount() : aura.getCharges();

        if (!aura.getCasterGuid().isUnit()) {
            auraData.castUnit = ObjectGuid.Empty; // optional data is filled in, but cast unit contains empty guid in packet
        } else if (!auraData.flags.hasFlag(AuraFlags.NOCASTER)) {
            auraData.castUnit = aura.getCasterGuid();
        }

        if (auraData.flags.hasFlag(AuraFlags.duration)) {
            auraData.duration = aura.getMaxDuration();
            auraData.remaining = aura.getDuration();
        }

        if (!auraData.flags.hasFlag(AuraFlags.SCALABLE)) {
            return;
        }

        var hasEstimatedAmounts = false;

        for (var effect : getBase().getAuraEffects().entrySet()) {
            if (!hasEffect(effect.getValue().effIndex)) {
                continue;
            }

            auraData.points.add(effect.getValue().amount);

            if (effect.getValue().getEstimatedAmount().HasValue) {
                hasEstimatedAmounts = true;
            }
        }

        if (hasEstimatedAmounts) {
            for (var effect : getBase().getAuraEffects().entrySet()) {
                if (hasEffect(effect.getValue().effIndex)) {
                    auraData.estimatedPoints.add(effect.getValue().getEstimatedAmount().GetValueOrDefault(effect.getValue().amount));
                }
            }
        }
    }


    public final void clientUpdate() {
        clientUpdate(false);
    }

    public final void clientUpdate(boolean remove) {
        needClientUpdate = false;

        AuraUpdate update = new AuraUpdate();
        update.updateAll = false;
        update.unitGUID = getTarget().getGUID();

        AuraInfo auraInfo = new AuraInfo();
        tangible.RefObject<AuraInfo> tempRef_auraInfo = new tangible.RefObject<AuraInfo>(auraInfo);
        buildUpdatePacket(tempRef_auraInfo, remove);
        auraInfo = tempRef_auraInfo.refArgValue;
        update.auras.add(auraInfo);

        target.sendMessageToSet(update, true);
    }

    public final String getDebugInfo() {
        return String.format("Base: %1$s\nTarget: %2$s", (getBase() != null ? getBase().getDebugInfo() : "NULL"), (getTarget() != null ? getTarget().getDebugInfo() : "NULL"));
    }

    public final boolean hasEffect(int effect) {
        return effectMask.contains(effect);
    }

    private void _InitFlags(Unit caster, HashSet<Integer> effMask) {
        // mark as selfcasted if needed
        flags = flags.getValue() | (Objects.equals(getBase().getCasterGuid(), getTarget().getGUID())).getValue() ? AuraFlags.NoCaster : AuraFlags.NONE;

        // aura is casted by self or an enemy
        // one negative effect and we know aura is negative
        if (isSelfcasted() || caster == null || !caster.isFriendlyTo(getTarget())) {
            var negativeFound = false;

            for (var spellEffectInfo : getBase().getSpellInfo().getEffects()) {
                if (effMask.contains(spellEffectInfo.effectIndex) && !getBase().getSpellInfo().isPositiveEffect(spellEffectInfo.effectIndex)) {
                    negativeFound = true;

                    break;
                }
            }

            flags = flags.getValue() | negativeFound.getValue() ? AuraFlags.Negative : AuraFlags.positive;
        }
        // aura is casted by friend
        // one positive effect and we know aura is positive
        else {
            var positiveFound = false;

            for (var spellEffectInfo : getBase().getSpellInfo().getEffects()) {
                if (effMask.contains(spellEffectInfo.effectIndex) && getBase().getSpellInfo().isPositiveEffect(spellEffectInfo.effectIndex)) {
                    positiveFound = true;

                    break;
                }
            }

            flags = flags.getValue() | positiveFound.getValue() ? AuraFlags.Positive : AuraFlags.NEGATIVE;
        }


//		bool effectNeedsAmount(KeyValuePair<int, AuraEffect> effect)
//			{
//				return EffectsToApply.contains(effect.value.effIndex) && aura.effectTypeNeedsSendingAmount(effect.value.auraType);
//			}

        if (getBase().getSpellInfo().hasAttribute(SpellAttr8.AuraSendAmount) || getBase().getAuraEffects().Any(effectNeedsAmount)) {
            flags = AuraFlags.forValue(flags.getValue() | AuraFlags.SCALABLE.getValue());
        }
    }
}
