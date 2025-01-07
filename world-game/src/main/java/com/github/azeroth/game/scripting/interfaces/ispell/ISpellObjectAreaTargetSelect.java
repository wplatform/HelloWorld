package com.github.azeroth.game.scripting.interfaces.ispell;


import com.github.azeroth.game.entity.object.WorldObject;

import java.util.ArrayList;


public interface ISpellObjectAreaTargetSelect extends ITargetHookHandler {
    void filterTargets(ArrayList<WorldObject> targets);
}
