package com.github.azeroth.game.scripting.interfaces.ispell;


import com.github.azeroth.game.entity.object.WorldObject;

public interface ISpellObjectTargetSelectHandler extends ITargetHookHandler {
    void targetSelect(WorldObject targets);
}
