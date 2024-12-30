package com.github.mmo.game.scripting.interfaces.igroup;

import com.github.mmo.game.group.PlayerGroup;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGroupOnChangeLeader extends IScriptObject {
    void onChangeLeader(PlayerGroup group, ObjectGuid newLeaderGuid, ObjectGuid oldLeaderGuid);
}
