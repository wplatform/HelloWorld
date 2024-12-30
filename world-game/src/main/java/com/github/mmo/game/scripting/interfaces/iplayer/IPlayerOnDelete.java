package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.scripting.interfaces.IScriptObject;

// Called when a player is deleted.
public interface IPlayerOnDelete extends IScriptObject {
    void OnDelete(ObjectGuid guid, int accountId);
}
