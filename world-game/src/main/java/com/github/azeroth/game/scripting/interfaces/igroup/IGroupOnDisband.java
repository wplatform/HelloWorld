package com.github.azeroth.game.scripting.interfaces.igroup;

import com.github.azeroth.game.group.PlayerGroup;
import com.github.azeroth.game.scripting.interfaces.IScriptObject;

public interface IGroupOnDisband extends IScriptObject {
    void onDisband(PlayerGroup group);
}
