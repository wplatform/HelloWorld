package com.github.mmo.game.scripting.interfaces.igroup;


import com.github.mmo.game.group.PlayerGroup;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGroupOnRemoveMember extends IScriptObject {
    void onRemoveMember(PlayerGroup group, ObjectGuid guid, RemoveMethod method, ObjectGuid kicker, String reason);
}
