package com.github.mmo.game.chat.commands;


import com.github.mmo.game.chat.CommandHandler;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class HonorCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleHonorUpdateCommand(CommandHandler handler) {
        var target = handler.getSelectedPlayer();

        if (!target) {
            handler.sendSysMessage(CypherStrings.PlayerNotFound);

            return false;
        }

        // check online security
        if (handler.hasLowerSecurity(target, ObjectGuid.Empty)) {
            return false;
        }

        target.updateHonorFields();

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class HonorAddCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleHonorAddCommand(CommandHandler handler, int amount) {
            var target = handler.getSelectedPlayer();

            if (!target) {
                handler.sendSysMessage(CypherStrings.PlayerNotFound);

                return false;
            }

            // check online security
            if (handler.hasLowerSecurity(target, ObjectGuid.Empty)) {
                return false;
            }

            target.rewardHonor(null, 1, amount);

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleHonorAddKillCommand(CommandHandler handler) {
            var target = handler.getSelectedUnit();

            if (!target) {
                handler.sendSysMessage(CypherStrings.PlayerNotFound);

                return false;
            }

            // check online security
            var player = target.toPlayer();

            if (player) {
                if (handler.hasLowerSecurity(player, ObjectGuid.Empty)) {
                    return false;
                }
            }

            handler.getPlayer().rewardHonor(target, 1);

            return true;
        }
    }
}
