package com.github.mmo.game.scripting.interfaces.igroup;

import com.github.mmo.game.group.*;
import com.github.mmo.game.scripting.interfaces.*;public interface IGroupOnAddMember extends IScriptObject {
    void onAddMember(PlayerGroup group, ObjectGuid guid);
}
