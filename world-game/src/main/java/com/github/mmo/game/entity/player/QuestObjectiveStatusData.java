package com.github.mmo.game.entity.player;

final class QuestObjectiveStatusData
{
// C# TO JAVA CONVERTER TASK: Tuple fields are not converted by C# to Java Converter:
	public (int questID, QuestStatusData status) questStatusPair;
	public Questobjective objective;

	public QuestObjectiveStatusData clone()
	{
		QuestObjectiveStatusData varCopy = new QuestObjectiveStatusData();

		varCopy.objective = this.objective;

		return varCopy;
	}
}
