package com.github.azeroth.game.domain.player;


import com.github.azeroth.common.LocalizedString;
import lombok.AllArgsConstructor;

import java.util.HashMap;

@AllArgsConstructor
public class PlayerChoiceLocale {
    public int choiceId;
    public int locale;
    public String question;
}
