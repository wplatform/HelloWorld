package com.github.mmo.game.domain.quest;

import com.github.mmo.common.LocalizedString;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class QuestGreeting {

    public int id;
    public byte type;
    public short emoteType;
    public int emoteDelay;
    public LocalizedString text = new LocalizedString();
}
