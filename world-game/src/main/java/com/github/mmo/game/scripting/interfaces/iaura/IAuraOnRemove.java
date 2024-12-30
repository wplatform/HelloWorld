package com.github.mmo.game.scripting.interfaces.iaura;

import com.github.mmo.game.scripting.interfaces.IAuraScript;
import com.github.mmo.game.spell.AuraRemoveMode;

public interface IAuraOnRemove extends IAuraScript {
    void AuraRemoved(AuraRemoveMode removeMode);
}
