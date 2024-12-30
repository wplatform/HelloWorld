package com.github.mmo.game.scripting.interfaces.iplayer;

import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnFailedDelete extends IScriptObject {

    void OnFailedDelete(ObjectGuid guid, int accountId);
}
