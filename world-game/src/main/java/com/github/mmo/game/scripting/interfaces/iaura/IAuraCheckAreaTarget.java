package com.github.mmo.game.scripting.interfaces.iaura;

import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.scripting.interfaces.IAuraScript;

public interface IAuraCheckAreaTarget extends IAuraScript {
    boolean checkAreaTarget(Unit target);
}
