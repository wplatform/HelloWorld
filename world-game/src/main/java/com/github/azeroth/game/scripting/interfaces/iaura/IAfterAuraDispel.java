package com.github.azeroth.game.scripting.interfaces.iaura;

import com.github.azeroth.game.entity.unit.DispelInfo;
import com.github.azeroth.game.scripting.interfaces.IAuraScript;

public interface IAfterAuraDispel extends IAuraScript {
    void HandleDispel(DispelInfo dispelInfo);
}
