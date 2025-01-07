package com.github.azeroth.game.chat.commands;


import com.github.azeroth.game.chat.CommandHandler;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class DeserterCommands {
    private static boolean handleDeserterAdd(CommandHandler handler, int time, boolean isInstance) {
        var player = handler.getSelectedPlayer();

        if (!player) {
            handler.sendSysMessage(CypherStrings.NoCharSelected);

            return false;
        }

        var aura = player.addAura(isInstance ? spells.LFGDundeonDeserter : spells.BGDeserter, player);

        if (aura == null) {
            handler.sendSysMessage(CypherStrings.BadValue);

            return false;
        }

        aura.setDuration((int) (time * time.InMilliseconds));

        return true;
    }

    private static boolean handleDeserterRemove(CommandHandler handler, boolean isInstance) {
        var player = handler.getSelectedPlayer();

        if (!player) {
            handler.sendSysMessage(CypherStrings.NoCharSelected);

            return false;
        }

        player.removeAura(isInstance ? spells.LFGDundeonDeserter : spells.BGDeserter);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class DeserterInstanceCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleDeserterInstanceAdd(CommandHandler handler, int time) {
            return handleDeserterAdd(handler, time, true);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleDeserterInstanceRemove(CommandHandler handler) {
            return handleDeserterRemove(handler, true);
        }
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class DeserterBGCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleDeserterBGAdd(CommandHandler handler, int time) {
            return handleDeserterAdd(handler, time, false);
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleDeserterBGRemove(CommandHandler handler) {
            return handleDeserterRemove(handler, false);
        }
    }
}
