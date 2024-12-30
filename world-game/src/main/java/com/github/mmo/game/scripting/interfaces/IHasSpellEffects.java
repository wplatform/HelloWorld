package com.github.mmo.game.scripting.interfaces;

import com.github.mmo.game.scripting.interfaces.ispell.ISpellEffect;

import java.util.ArrayList;


public interface IHasSpellEffects {
    ArrayList<ISpellEffect> getSpellEffects();
}
