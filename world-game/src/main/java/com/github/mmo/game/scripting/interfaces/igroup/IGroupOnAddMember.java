package com.github.mmo.game.scripting.interfaces.igroup;

import com.github.mmo.game.group.PlayerGroup;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGroupOnAddMember extends IScriptObject {
    void onAddMember(PlayerGroup group, ObjectGuid guid);
}
