package com.github.azeroth.game.scripting.interfaces.igroup;


import com.github.azeroth.game.group.PlayerGroup;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGroupOnRemoveMember extends IScriptObject {
    void onRemoveMember(PlayerGroup group, ObjectGuid guid, RemoveMethod method, ObjectGuid kicker, String reason);
}
