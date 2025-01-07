package com.github.azeroth.game.scripting.interfaces.itransport;

import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface ITransportOnRemovePassenger extends IScriptObject {
    void OnRemovePassenger(Transport transport, Player player);
}
