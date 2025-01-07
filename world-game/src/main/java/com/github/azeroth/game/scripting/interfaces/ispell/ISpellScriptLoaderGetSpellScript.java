package com.github.azeroth.game.scripting.interfaces.ispell;

import com.github.azeroth.game.scripting.SpellScript;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface ISpellScriptLoaderGetSpellScript extends IScriptObject {
    SpellScript getSpellScript();
}
