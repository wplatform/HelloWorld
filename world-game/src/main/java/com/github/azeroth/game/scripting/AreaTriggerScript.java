package com.github.azeroth.game.scripting;


import com.github.azeroth.game.entity.areatrigger.AreaTrigger;
import com.github.azeroth.game.scripting.interfaces.IAreaTriggerScript;
import com.github.azeroth.game.spell.SpellInfo;

public class AreaTriggerScript implements IAreaTriggerScript {
    private AreaTrigger areaTrigger;
    private byte currentScriptState;
    private String scriptName;
    private int scriptAreaTriggerId;

    public final byte getCurrentScriptState() {
        return currentScriptState;
    }

    public final void setCurrentScriptState(byte value) {
        currentScriptState = value;
    }

    public final String getScriptName() {
        return scriptName;
    }

    public final void setScriptName(String value) {
        scriptName = value;
    }

    public final int getScriptAreaTriggerId() {
        return scriptAreaTriggerId;
    }

    public final void setScriptAreaTriggerId(int value) {
        scriptAreaTriggerId = value;
    }

    public final AreaTrigger getAt() {
        return areaTrigger;
    }

    public final void _Register() {
        setCurrentScriptState((byte) SpellScriptState.Registration.getValue());
        register();
        setCurrentScriptState((byte) SpellScriptState.NONE.getValue());
    }

    public final void _Unload() {
        setCurrentScriptState((byte) SpellScriptState.Unloading.getValue());
        unload();
        setCurrentScriptState((byte) SpellScriptState.NONE.getValue());
    }

    public final void _Init(String scriptname, int areaTrigger) {
        setCurrentScriptState((byte) SpellScriptState.NONE.getValue());
        setScriptName(scriptname);
        setScriptAreaTriggerId(areaTrigger);
    }

    public final String _GetScriptName() {
        return getScriptName();
    }

    //
    // SpellScript/AuraScript interface base
    // these functions are safe to override, see notes below for usage instructions
    //
    // Function in which handler functions are registered, must be implemented in script
    public void register() {
    }

    // Function called when script is created, if returns false script will be unloaded afterwards
    // use for: initializing local script variables (DO NOT USE CONSTRUCTOR FOR THIS PURPOSE!)
    public boolean load() {
        return true;
    }

    // Function called when script is destroyed
    // use for: deallocating memory allocated by script
    public void unload() {
    }

    // Function called on server startup, if returns false script won't be used in core
    // use for: dbc/template _data presence/correctness checks
    public boolean validate(SpellInfo spellInfo) {
        return true;
    }

    public final boolean _Load(AreaTrigger areaTrigger) {
        areaTrigger = areaTrigger;
        _PrepareScriptCall(SpellScriptHookType.forValue(SpellScriptState.Loading));
        var load = load();
        _FinishScriptCall();

        return load;
    }

    public final void _PrepareScriptCall(SpellScriptHookType hookType) {
        setCurrentScriptState((byte) hookType.getValue());
    }

    public final void _FinishScriptCall() {
        setCurrentScriptState((byte) SpellScriptState.NONE.getValue());
    }
}
