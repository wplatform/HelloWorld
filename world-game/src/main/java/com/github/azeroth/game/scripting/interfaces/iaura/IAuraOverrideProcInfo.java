package com.github.azeroth.game.scripting.interfaces.iaura;

import com.github.azeroth.game.scripting.interfaces.IAuraScript;
import com.github.azeroth.game.spell.SpellProcEntry;

public interface IAuraOverrideProcInfo extends IAuraScript {
    SpellProcEntry getSpellProcEntry();
}
