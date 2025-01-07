package com.github.azeroth.game.scripting.interfaces.igroup;

import com.github.azeroth.game.group.PlayerGroup;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGroupOnChangeLeader extends IScriptObject {
    void onChangeLeader(PlayerGroup group, ObjectGuid newLeaderGuid, ObjectGuid oldLeaderGuid);
}
