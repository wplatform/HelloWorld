package com.github.azeroth.game.chat;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class SceneCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleCancelSceneCommand(CommandHandler handler, int sceneScriptPackageId) {
        var target = handler.getSelectedPlayerOrSelf();

        if (!target) {
            handler.sendSysMessage(CypherStrings.PlayerNotFound);

            return false;
        }

        if (!CliDB.SceneScriptPackageStorage.HasRecord(sceneScriptPackageId)) {
            return false;
        }

        target.getSceneMgr().cancelSceneByPackageId(sceneScriptPackageId);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleDebugSceneCommand(CommandHandler handler) {
        var player = handler.getSession().getPlayer();

        if (player) {
            player.getSceneMgr().toggleDebugSceneMode();
            handler.sendSysMessage(player.getSceneMgr().isInDebugSceneMode() ? CypherStrings.CommandSceneDebugOn : CypherStrings.CommandSceneDebugOff);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handlePlaySceneCommand(CommandHandler handler, int sceneId) {
        var target = handler.getSelectedPlayerOrSelf();

        if (!target) {
            handler.sendSysMessage(CypherStrings.PlayerNotFound);

            return false;
        }

        if (global.getObjectMgr().getSceneTemplate(sceneId) == null) {
            return false;
        }

        target.getSceneMgr().playScene(sceneId);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handlePlayScenePackageCommand(CommandHandler handler, int sceneScriptPackageId, SceneFlags flags) {
        var target = handler.getSelectedPlayerOrSelf();

        if (!target) {
            handler.sendSysMessage(CypherStrings.PlayerNotFound);

            return false;
        }

        if (!CliDB.SceneScriptPackageStorage.HasRecord(sceneScriptPackageId)) {
            return false;
        }

        target.getSceneMgr().playSceneByPackageId(sceneScriptPackageId, flags.GetValueOrDefault(0));

        return true;
    }
}
