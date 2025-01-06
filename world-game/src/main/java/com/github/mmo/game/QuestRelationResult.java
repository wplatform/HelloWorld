package com.github.mmo.game;


import java.util.ArrayList;

public class QuestRelationResult extends ArrayList<Integer> {
    private final boolean onlyActive;

    public QuestRelationResult() {
    }

    public QuestRelationResult(ArrayList<Integer> range, boolean onlyActive) {
        super(range);
        this.onlyActive = onlyActive;
    }

    public final boolean hasQuest(int questId) {
        return this.contains(questId) && (!onlyActive || Quest.isTakingQuestEnabled(questId));
    }
}
