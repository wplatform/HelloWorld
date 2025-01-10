package com.github.azeroth.game.domain.player;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerChoiceResponseLocale {

    public int choiceId;
    public int locale;
    public int responseId;
    public String answer;
    public String header;
    public String subHeader;
    public String buttonTooltip;
    public String description;
    public String confirmation;
}
