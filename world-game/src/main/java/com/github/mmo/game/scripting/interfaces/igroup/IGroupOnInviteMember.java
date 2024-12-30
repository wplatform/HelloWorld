package com.github.mmo.game.scripting.interfaces.igroup;

import com.github.mmo.game.group.PlayerGroup;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGroupOnInviteMember extends IScriptObject {
    void onInviteMember(PlayerGroup group, ObjectGuid guid);
}
