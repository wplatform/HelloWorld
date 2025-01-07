package com.github.azeroth.game.scripting.interfaces.igroup;

import com.github.azeroth.game.group.PlayerGroup;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGroupOnInviteMember extends IScriptObject {
    void onInviteMember(PlayerGroup group, ObjectGuid guid);
}
