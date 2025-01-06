package com.github.mmo.game.domain.player;


import com.github.mmo.common.LocalizedString;

import java.util.HashMap;


public class PlayerChoiceLocale {
    public LocalizedString question = new LocalizedString();
    public HashMap<Integer, PlayerChoiceResponseLocale> responses = new HashMap<Integer, PlayerChoiceResponseLocale>();
}
