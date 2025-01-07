package com.github.azeroth.game.domain.quest;

import com.github.azeroth.common.LocalizedString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QuestGreeting {

    public int id;
    public byte type;
    public short emoteType;
    public int emoteDelay;
    public LocalizedString text = new LocalizedString();
}
