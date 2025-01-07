package com.github.azeroth.game.scripting.interfaces.iaura;

import com.github.azeroth.game.scripting.interfaces.IAuraScript;
import com.github.azeroth.game.spell.AuraRemoveMode;

public interface IAuraOnRemove extends IAuraScript {
    void AuraRemoved(AuraRemoveMode removeMode);
}
