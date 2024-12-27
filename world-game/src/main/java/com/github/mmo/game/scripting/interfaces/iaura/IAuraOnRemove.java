package com.github.mmo.game.scripting.interfaces.iaura;

import com.github.mmo.game.spell.*;
import com.github.mmo.game.scripting.interfaces.*;

public interface IAuraOnRemove extends IAuraScript
{
	void AuraRemoved(AuraRemoveMode removeMode);
}
