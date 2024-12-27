package com.github.mmo.game.chat.commands;



import com.github.mmo.game.chat.*;// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class AchievementCommand {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleAchievementAddCommand(CommandHandler handler, AchievementRecord achievementEntry) {
        var target = handler.getSelectedPlayer();

        if (!target) {
            handler.sendSysMessage(CypherStrings.NoCharSelected);

            return false;
        }

        target.completedAchievement(achievementEntry);

        return true;
    }
}
