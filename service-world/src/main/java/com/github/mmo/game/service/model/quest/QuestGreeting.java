package com.github.mmo.game.service.model.quest;
public class QuestGreeting {

    public short emoteType;

    public int emoteDelay;
    public String text;

    public QuestGreeting() {
        text = "";
    }


    public QuestGreeting(short emoteType, int emoteDelay, String text) {
        this.emoteType = emoteType;
        this.emoteDelay = emoteDelay;
        this.text = text;
    }
}
