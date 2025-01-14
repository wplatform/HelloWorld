package com.github.azeroth.game.scripting.interfaces.ispell;


public interface ITargetHookHandler extends ISpellEffect {
    Targets getTargetType();

    default boolean getArea() {
        return true;
    }

    default boolean getDest() {
        return false;
    }
}
