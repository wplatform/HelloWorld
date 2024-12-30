package com.github.mmo.game.entity.player;

public class AccessRequirement {
    private byte levelMin;
    private byte levelMax;
    private int item;
    private int item2;
    private int questA;
    private int questH;
    private int achievement;
    private String questFailedText;

    public final byte getLevelMin() {
        return levelMin;
    }

    public final void setLevelMin(byte value) {
        levelMin = value;
    }

    public final byte getLevelMax() {
        return levelMax;
    }

    public final void setLevelMax(byte value) {
        levelMax = value;
    }

    public final int getItem() {
        return item;
    }

    public final void setItem(int value) {
        item = value;
    }

    public final int getItem2() {
        return item2;
    }

    public final void setItem2(int value) {
        item2 = value;
    }

    public final int getQuestA() {
        return questA;
    }

    public final void setQuestA(int value) {
        questA = value;
    }

    public final int getQuestH() {
        return questH;
    }

    public final void setQuestH(int value) {
        questH = value;
    }

    public final int getAchievement() {
        return achievement;
    }

    public final void setAchievement(int value) {
        achievement = value;
    }

    public final String getQuestFailedText() {
        return questFailedText;
    }

    public final void setQuestFailedText(String value) {
        questFailedText = value;
    }
}
