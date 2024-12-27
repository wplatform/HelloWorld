package com.github.mmo.game.scripting.interfaces.iaura;

import com.github.mmo.game.scripting.interfaces.*;
import com.github.mmo.game.spell.SpellProcEntry;

public interface IAuraOverrideProcInfo extends IAuraScript
{
	SpellProcEntry getSpellProcEntry();
}
