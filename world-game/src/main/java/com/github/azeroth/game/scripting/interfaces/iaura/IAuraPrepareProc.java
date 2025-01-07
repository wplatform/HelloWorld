package com.github.azeroth.game.scripting.interfaces.iaura;

import com.github.azeroth.game.entity.unit.ProcEventInfo;
import com.github.azeroth.game.scripting.interfaces.IAuraScript;

public interface IAuraPrepareProc extends IAuraScript {
    boolean DoPrepareProc(ProcEventInfo info);
}
