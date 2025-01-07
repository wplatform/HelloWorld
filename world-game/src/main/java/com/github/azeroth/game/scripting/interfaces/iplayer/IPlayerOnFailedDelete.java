package com.github.azeroth.game.scripting.interfaces.iplayer;

import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IPlayerOnFailedDelete extends IScriptObject {

    void OnFailedDelete(ObjectGuid guid, int accountId);
}
