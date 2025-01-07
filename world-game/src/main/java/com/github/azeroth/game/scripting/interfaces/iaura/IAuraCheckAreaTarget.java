package com.github.azeroth.game.scripting.interfaces.iaura;

import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.scripting.interfaces.IAuraScript;

public interface IAuraCheckAreaTarget extends IAuraScript {
    boolean checkAreaTarget(Unit target);
}
