package com.github.azeroth.game.domain.player;


import com.github.azeroth.common.LocalizedString;

import java.util.HashMap;


public class PlayerChoiceLocale {
    public LocalizedString question = new LocalizedString();
    public HashMap<Integer, PlayerChoiceResponseLocale> responses = new HashMap<Integer, PlayerChoiceResponseLocale>();
}
