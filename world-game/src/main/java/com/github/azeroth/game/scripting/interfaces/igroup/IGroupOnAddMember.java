package com.github.azeroth.game.scripting.interfaces.igroup;

import com.github.azeroth.game.group.PlayerGroup;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGroupOnAddMember extends IScriptObject {
    void onAddMember(PlayerGroup group, ObjectGuid guid);
}
