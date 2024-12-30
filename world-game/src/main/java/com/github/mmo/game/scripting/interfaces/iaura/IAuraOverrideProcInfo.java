package com.github.mmo.game.scripting.interfaces.iaura;

import com.github.mmo.game.scripting.interfaces.IAuraScript;
import com.github.mmo.game.spell.SpellProcEntry;

public interface IAuraOverrideProcInfo extends IAuraScript {
    SpellProcEntry getSpellProcEntry();
}
