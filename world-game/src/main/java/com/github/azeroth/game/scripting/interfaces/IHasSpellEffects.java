package com.github.azeroth.game.scripting.interfaces;

import com.github.azeroth.game.scripting.interfaces.ispell.ISpellEffect;

import java.util.ArrayList;


public interface IHasSpellEffects {
    ArrayList<ISpellEffect> getSpellEffects();
}
