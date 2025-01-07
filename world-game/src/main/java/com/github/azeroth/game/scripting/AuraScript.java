package com.github.azeroth.game.scripting;


import com.github.azeroth.game.entity.dynamic.DynamicObject;
import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IAuraScript;
import com.github.azeroth.game.spell.*;

import java.util.stack;

public class AuraScript extends BaseSpellScript implements IAuraScript {
    private final stack<ScriptStateStore> scriptStates = new stack<ScriptStateStore>();
    private Aura aura;
    private AuraApplication auraApplication;
    private boolean defaultActionPrevented;

    // AuraScript interface - functions which are redirecting to Aura class

    public AuraScript() {
        aura = null;
        auraApplication = null;
        defaultActionPrevented = false;
    }

    // returns proto of the spell
    public final SpellInfo getSpellInfo() {
        return aura.getSpellInfo();
    }

    // returns spellid of the spell
    public final int getId() {
        return aura.getId();
    }

    // returns Guid of object which casted the aura (_originalCaster of the Spell class)
    public final ObjectGuid getCasterGUID() {
        return aura.getCasterGuid();
    }

    // returns unit which casted the aura or null if not avalible (caster logged out for example)
    public final Unit getCaster() {
        return aura.getCaster();
    }

    // returns gameobject which cast the aura or NULL if not available
    public final GameObject getGObjCaster() {
        WorldObject caster = aura.getCaster();

        if (caster != null) {
            return caster.toGameObject();
        }

        return null;
    }

    // returns object on which aura was casted, Target for non-area auras, area aura source for area Auras
    public final WorldObject getOwner() {
        return aura.getOwner();
    }

    // returns owner if it's unit or unit derived object, null otherwise (only for persistent area Auras null is returned)
    public final Unit getOwnerAsUnit() {
        return aura.getOwnerAsUnit();
    }

    // returns aura object of script
    public final Aura getAura() {
        return aura;
    }

    // aura duration manipulation - when duration goes to 0 aura is removed
    public final int getDuration() {
        return aura.getDuration();
    }

    public final void setDuration(int duration) {
        setDuration(duration, false);
    }

    public final void setDuration(double duration) {
        setDuration(duration, false);
    }

    public final int getMaxDuration() {
        return aura.getMaxDuration();
    }

    public final void setMaxDuration(int value) {
        aura.setMaxDuration(value);
    }

    // AuraScript interface - functions which are redirecting to AuraApplication class
    // Do not call these in hooks in which AuraApplication is not avalible, otherwise result will differ from expected (the functions will return null)

    // expired - duration just went to 0
    public final boolean isExpired() {
        return aura.isExpired();
    }

    // stack amount manipulation
    public final byte getStackAmount() {
        return aura.getStackAmount();
    }

    public final void setStackAmount(byte value) {
        aura.setStackAmount(value);
    }

    // returns currently processed Target of an aura
    // Return value does not need to be null-checked, the only situation this will (always)
    // return null is when the call happens in an unsupported hook, in other cases, it is always valid
    public final Unit getTarget() {
        switch (AuraScriptHookType.forValue(getCurrentScriptState())) {
            case EffectApply:
            case EffectRemove:
            case EffectAfterApply:
            case EffectAfterRemove:
            case EffectPeriodic:
            case EffectAbsorb:
            case EffectAfterAbsorb:
            case EffectManaShield:
            case EffectAfterManaShield:
            case EffectSplit:
            case CheckProc:
            case CheckEffectProc:
            case PrepareProc:
            case Proc:
            case AfterProc:
            case EffectProc:
            case EffectAfterProc:
            case EnterLeaveCombat:
                return auraApplication.getTarget();
            default:
                Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}` AuraScript.GetTarget called in a hook in which the call won't have effect!", getScriptName(), getScriptSpellId());

                break;
        }

        return null;
    }

    // returns AuraApplication object of currently processed Target
    public final AuraApplication getTargetApplication() {
        return auraApplication;
    }

    public final Difficulty getCastDifficulty() {
        return getAura().getCastDifficulty();
    }

    // returns owner if it's dynobj, null otherwise
    public final DynamicObject getDynobjOwner() {
        return aura.getDynobjOwner();
    }

    // returns Type of the aura, may be dynobj owned aura or unit owned aura
    public final AuraObjectType getAuraObjType() {
        return aura.getAuraObjType();
    }

    public final long getApplyTime() {
        return aura.getApplyTime();
    }

    // permament - has infinite duration
    public final boolean isPermanent() {
        return aura.isPermanent();
    }

    // charges manipulation - 0 - not charged aura
    public final byte getCharges() {
        return aura.getCharges();
    }

    public final void setCharges(byte value) {
        aura.setCharges(value);
    }

    // passive - "working in background", not saved, not removed by immunities, not seen by player
    public final boolean isPassive() {
        return aura.isPassive();
    }

    // death persistent - not removed on death
    public final boolean isDeathPersistent() {
        return aura.isDeathPersistent();
    }

    public final boolean _Load(Aura aura) {
        aura = aura;
        _PrepareScriptCall(AuraScriptHookType.forValue(SpellScriptState.Loading), null);
        var load = load();
        _FinishScriptCall();

        return load;
    }

    public final void _PrepareScriptCall(AuraScriptHookType hookType) {
        _PrepareScriptCall(hookType, null);
    }

    public final void _PrepareScriptCall(AuraScriptHookType hookType, AuraApplication aurApp) {
        scriptStates.push(new ScriptStateStore(getCurrentScriptState(), auraApplication, defaultActionPrevented));
        setCurrentScriptState((byte) hookType.getValue());
        defaultActionPrevented = false;
        auraApplication = aurApp;
    }

    public final void _FinishScriptCall() {
        var stateStore = scriptStates.peek();
        setCurrentScriptState(stateStore.currentScriptState);
        auraApplication = stateStore.auraApplication;
        defaultActionPrevented = stateStore.defaultActionPrevented;
        scriptStates.pop();
    }

    public final boolean _IsDefaultActionPrevented() {
        switch (AuraScriptHookType.forValue(getCurrentScriptState())) {
            case EffectApply:
            case EffectRemove:
            case EffectPeriodic:
            case EffectAbsorb:
            case EffectSplit:
            case PrepareProc:
            case Proc:
            case EffectProc:
                return defaultActionPrevented;
            default:
                throw new RuntimeException("AuraScript._IsDefaultActionPrevented is called in a wrong place");
        }
    }

    // removes aura with remove mode (see AuraRemoveMode enum)

    // prevents default Action of a hook from being executed (works only while called in a hook which default Action can be prevented)
    public final void preventDefaultAction() {
        switch (AuraScriptHookType.forValue(getCurrentScriptState())) {
            case EffectApply:
            case EffectRemove:
            case EffectPeriodic:
            case EffectAbsorb:
            case EffectSplit:
            case PrepareProc:
            case EffectProc:
                defaultActionPrevented = true;

                break;
            default:
                Log.outError(LogFilter.Scripts, "Script: `{0}` Spell: `{1}` AuraScript.PreventDefaultAction called in a hook in which the call won't have effect!", getScriptName(), getScriptSpellId());

                break;
        }
    }

    public final SpellEffectInfo getEffectInfo(int effIndex) {
        return aura.getSpellInfo().getEffect(effIndex);
    }

    public final void remove() {
        remove(0);
    }

    public final void remove(AuraRemoveMode removeMode) {
        aura.remove(removeMode);
    }

    public final void setDuration(int duration, boolean withMods) {
        aura.setDuration(duration, withMods);
    }

    public final boolean modStackAmount(int num) {
        return modStackAmount(num, AuraRemoveMode.Default);
    }

    public final boolean modStackAmount(int num, AuraRemoveMode removeMode) {
        return aura.modStackAmount(num, removeMode);
    }

    // check if aura has effect of given effindex
    public final boolean hasEffect(byte effIndex) {
        return aura.hasEffect(effIndex);
    }

    // returns aura effect of given effect index or null
    public final AuraEffect getEffect(byte effIndex) {
        return aura.getEffect(effIndex);
    }

    public final boolean tryGetCaster(tangible.OutObject<unit> caster) {
        caster.outArgValue = getCaster();

        return caster.outArgValue != null;
    }

    public final boolean tryGetCasterAsPlayer(tangible.OutObject<Player> player) {
        var caster = aura.getCaster();

        if (caster.isPlayer(player)) {
            return true;
        }

        return false;
    }

    public final void setDuration(double duration, boolean withMods) {
        aura.setDuration(duration, withMods);
    }

    // sets duration to maxduration
    public final void refreshDuration() {
        aura.refreshDuration();
    }

    public final int calcMaxDuration() {
        return aura.calcMaxDuration();
    }


    public final byte calcMaxCharges() {
        return aura.calcMaxCharges();
    }


    public final boolean modCharges(byte num) {
        return modCharges(num, AuraRemoveMode.Default);
    }

    public final boolean modCharges(byte num, AuraRemoveMode removeMode) {
        return aura.modCharges(num, removeMode);
    }

    // returns true if last charge dropped

    public final boolean dropCharge() {
        return dropCharge(AuraRemoveMode.Default);
    }

    public final boolean dropCharge(AuraRemoveMode removeMode) {
        return aura.dropCharge(removeMode);
    }

    // check if aura has effect of given aura Type
    public final boolean hasEffectType(AuraType type) {
        return aura.hasEffectType(type);
    }

    private static class ScriptStateStore {
        public final AuraApplication auraApplication;

        public final byte currentScriptState;
        public final boolean defaultActionPrevented;


        public ScriptStateStore(byte currentScriptState, AuraApplication auraApplication, boolean defaultActionPrevented) {
            auraApplication = auraApplication;
            currentScriptState = currentScriptState;
            defaultActionPrevented = defaultActionPrevented;
        }
    }
}
