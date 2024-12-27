package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.scripting.interfaces.*;// Called when a player delete failed
public interface IPlayerOnFailedDelete extends IScriptObject {

    void OnFailedDelete(ObjectGuid guid, int accountId);
}
