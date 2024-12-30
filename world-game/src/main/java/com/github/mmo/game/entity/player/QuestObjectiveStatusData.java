package com.github.mmo.game.entity.player;

final class QuestObjectiveStatusData {
// C# TO JAVA CONVERTER TASK: Tuple fields are not converted by C# to Java Converter:
    public (
    public Questobjective objective;
    status)questStatusPair;
    int questID, QuestStatusData

    public QuestObjectiveStatusData clone() {
        QuestObjectiveStatusData varCopy = new QuestObjectiveStatusData();

        varCopy.objective = this.objective;

        return varCopy;
    }
}
