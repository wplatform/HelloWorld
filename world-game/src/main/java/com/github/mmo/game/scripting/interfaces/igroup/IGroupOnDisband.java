package com.github.mmo.game.scripting.interfaces.igroup;

import com.github.mmo.game.group.PlayerGroup;
import com.github.mmo.game.scripting.interfaces.IScriptObject;

public interface IGroupOnDisband extends IScriptObject {
    void onDisband(PlayerGroup group);
}
