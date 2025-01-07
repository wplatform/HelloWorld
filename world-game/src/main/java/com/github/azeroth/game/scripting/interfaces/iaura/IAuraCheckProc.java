package com.github.azeroth.game.scripting.interfaces.iaura;

import com.github.azeroth.game.entity.unit.ProcEventInfo;
import com.github.azeroth.game.scripting.interfaces.IAuraScript;

public interface IAuraCheckProc extends IAuraScript {
    boolean checkProc(ProcEventInfo info);
}
