package com.github.azeroth.game.scripting.interfaces.iaura;

import com.github.azeroth.game.entity.unit.ProcEventInfo;
import com.github.azeroth.game.scripting.interfaces.IAuraScript;

public interface IAuraOnProc extends IAuraScript {
    void OnProc(ProcEventInfo info);
}
