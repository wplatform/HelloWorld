package com.github.mmo.game.scripting;


import com.github.mmo.game.scripting.interfaces.IBaseSpellScript;
import com.github.mmo.game.spell.SpellInfo;


// helper class from which SpellScript and SpellAura derive, use these classes instead
public class BaseSpellScript implements IBaseSpellScript {
    private byte currentScriptState;
    private String scriptName;
    private int scriptSpellId;

    // internal use classes & functions
    // DO NOT OVERRIDE THESE IN SCRIPTS
    public BaseSpellScript() {
        setCurrentScriptState((byte) SpellScriptState.NONE.getValue());
    }

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

    public final int getScriptSpellId() {
        return scriptSpellId;
    }

    public final void setScriptSpellId(int value) {
        scriptSpellId = value;
    }

    public boolean _Validate(SpellInfo entry) {
        if (!validateSpellInfo(entry.getId())) {
            Log.outError(LogFilter.Scripts, "Spell `{0}` did not pass validate() function of script `{1}` - script will be not added to the spell", entry.getId(), getScriptName());

            return false;
        }

        return true;
    }

    public final boolean validateSpellInfo(Integer... spellIds) {
        var allValid = true;

        for (var spellId : spellIds) {
            if (!global.getSpellMgr().hasSpellInfo(spellId, Difficulty.NONE)) {
                Log.outError(LogFilter.Scripts, "BaseSpellScript::ValidateSpellInfo: Spell {0} does not exist.", spellId);
                allValid = false;
            }
        }

        return allValid;
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

    public final void _Init(String scriptname, int spellId) {
        setCurrentScriptState((byte) SpellScriptState.NONE.getValue());
        setScriptName(scriptname);
        setScriptSpellId(spellId);
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
}
