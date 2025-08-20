package com.github.azeroth.game.domain.player;

import com.github.azeroth.dbc.defines.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccessRequirement {
    private int mapId;
    private Difficulty difficulty;
    private int levelMin;
    private int levelMax;
    private int item;
    private int item2;
    private int questDoneA;
    private int questDoneH;
    private int completedAchievement;
    private String questFailedText;
}
