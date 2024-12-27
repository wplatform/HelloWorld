package com.github.mmo.game.service.domain.quest;
public class QuestGreeting {

    public short emoteType;

    public int emoteDelay;
    public String text;

    public QuestGreeting() {
        text = "";
    }


    public QuestGreeting(short emoteType, int emoteDelay, String text) {
        emoteType = emoteType;
        emoteDelay = emoteDelay;
        text = text;
    }
}
