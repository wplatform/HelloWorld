package com.github.mmo.game.scripting.interfaces.iaura;

import com.github.mmo.game.entity.unit.DispelInfo;
import com.github.mmo.game.scripting.interfaces.IAuraScript;

public interface IAuraOnDispel extends IAuraScript {
    void OnDispel(DispelInfo dispelInfo);
}