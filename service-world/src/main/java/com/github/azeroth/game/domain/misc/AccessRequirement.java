package com.github.azeroth.game.domain.misc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccessRequirement {
    private int mapid;
    private int difficulty;
    private int levelMin;
    private int levelMax;
    private int item;
    private int item2;
    private int questDoneA;
    private int questDoneH;
    private int completedAchievement;
    private String questFailedText;
}