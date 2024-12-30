package com.github.mmo.game.scripting.interfaces.iaura;

import com.github.mmo.game.entity.unit.ProcEventInfo;
import com.github.mmo.game.scripting.interfaces.IAuraScript;

public interface IAuraPrepareProc extends IAuraScript {
    boolean DoPrepareProc(ProcEventInfo info);
}
