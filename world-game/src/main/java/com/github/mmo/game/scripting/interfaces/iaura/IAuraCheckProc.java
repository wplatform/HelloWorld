package com.github.mmo.game.scripting.interfaces.iaura;

import com.github.mmo.game.entity.unit.ProcEventInfo;
import com.github.mmo.game.scripting.interfaces.IAuraScript;

public interface IAuraCheckProc extends IAuraScript
{
	boolean checkProc(ProcEventInfo info);
}
