package com.github.mmo.game.scripting.interfaces.itransport;

import com.github.mmo.game.entity.gobject.transport;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface ITransportOnRemovePassenger extends IScriptObject
{
	void OnRemovePassenger(Transport transport, Player player);
}
