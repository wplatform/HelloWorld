package com.github.mmo.game.scripting.interfaces.ispell;


import com.github.mmo.game.entity.object.WorldObject;

import java.util.ArrayList;


public interface ISpellObjectAreaTargetSelect extends ITargetHookHandler {
    void filterTargets(ArrayList<WorldObject> targets);
}
