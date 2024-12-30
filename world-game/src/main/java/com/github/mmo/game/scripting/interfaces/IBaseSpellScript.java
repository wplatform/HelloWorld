package com.github.mmo.game.scripting.interfaces;

import com.github.mmo.game.spell.SpellInfo;

public interface IBaseSpellScript {
    byte getCurrentScriptState();

    void setCurrentScriptState(byte value);

    String getScriptName();

    void setScriptName(String value);

    int getScriptSpellId();

    void setScriptSpellId(int value);

    boolean load();

    void register();

    void unload();

    boolean validateSpellInfo(Integer... spellIds);

    String _GetScriptName();

    void _Init(String scriptname, int spellId);

    void _Register();

    void _Unload();

    boolean _Validate(SpellInfo entry);
}
