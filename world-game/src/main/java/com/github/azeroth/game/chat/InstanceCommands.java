package com.github.azeroth.game.chat;


import com.github.azeroth.game.map.InstanceLock;

import java.util.ArrayList;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class InstanceCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleInstanceGetBossStateCommand(CommandHandler handler, int encounterId, PlayerIdentifier player) {
        // Character name must be provided when using this from console.
        if (player == null || handler.getSession() == null) {
            handler.sendSysMessage(CypherStrings.CmdSyntax);

            return false;
        }

        if (player == null) {
            player = PlayerIdentifier.fromSelf(handler);
        }

        if (player.isConnected()) {
            handler.sendSysMessage(CypherStrings.PlayerNotFound);

            return false;
        }

        var map = player.getConnectedPlayer().getMap().getToInstanceMap();

        if (map == null) {
            handler.sendSysMessage(CypherStrings.NotDungeon);

            return false;
        }

        if (map.getInstanceScript() == null) {
            handler.sendSysMessage(CypherStrings.NoInstanceData);

            return false;
        }

        if (encounterId > map.getInstanceScript().getEncounterCount()) {
            handler.sendSysMessage(CypherStrings.BadValue);

            return false;
        }

        var state = map.getInstanceScript().getBossState(encounterId);
        handler.sendSysMessage(CypherStrings.CommandInstGetBossState, encounterId, state);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleInstanceListBindsCommand(CommandHandler handler) {
        var player = handler.getSelectedPlayer();

        if (player == null) {
            player = handler.getSession().getPlayer();
        }

        var now = gameTime.GetDateAndTime();
        var instanceLocks = global.getInstanceLockMgr().getInstanceLocksForPlayer(player.getGUID());

        for (var instanceLock : instanceLocks) {
            MapDb2Entries entries = new MapDb2Entries(instanceLock.getMapId(), instanceLock.getDifficultyId());
            var timeleft = !instanceLock.isExpired() ? time.secsToTimeString((long) (instanceLock.getEffectiveExpiryTime() - now).TotalSeconds, 0, false) : "-";

            handler.sendSysMessage(CypherStrings.CommandListBindInfo, entries.Map.id, entries.Map.MapName.get(global.getWorldMgr().getDefaultDbcLocale()), entries.MapDifficulty.difficultyID, CliDB.DifficultyStorage.get(entries.MapDifficulty.difficultyID).name, instanceLock.getInstanceId(), handler.getCypherString(instanceLock.isExpired() ? CypherStrings.Yes : CypherStrings.No), handler.getCypherString(instanceLock.isExtended() ? CypherStrings.Yes : CypherStrings.No), timeleft);
        }

        handler.sendSysMessage(CypherStrings.CommandListBindPlayerBinds, instanceLocks.size());

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleInstanceSetBossStateCommand(CommandHandler handler, int encounterId, EncounterState state, PlayerIdentifier player) {
        // Character name must be provided when using this from console.
        if (player == null || handler.getSession() == null) {
            handler.sendSysMessage(CypherStrings.CmdSyntax);

            return false;
        }

        if (player == null) {
            player = PlayerIdentifier.fromSelf(handler);
        }

        if (!player.isConnected()) {
            handler.sendSysMessage(CypherStrings.PlayerNotFound);

            return false;
        }

        var map = player.getConnectedPlayer().getMap().getToInstanceMap();

        if (map == null) {
            handler.sendSysMessage(CypherStrings.NotDungeon);

            return false;
        }

        if (map.getInstanceScript() == null) {
            handler.sendSysMessage(CypherStrings.NoInstanceData);

            return false;
        }

        // Reject improper values.
        if (encounterId > map.getInstanceScript().getEncounterCount()) {
            handler.sendSysMessage(CypherStrings.BadValue);

            return false;
        }

        map.getInstanceScript().setBossState(encounterId, state);
        handler.sendSysMessage(CypherStrings.CommandInstSetBossState, encounterId, state);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleInstanceStatsCommand(CommandHandler handler) {
        handler.sendSysMessage("instances loaded: {0}", global.getMapMgr().GetNumInstances());
        handler.sendSysMessage("players in instances: {0}", global.getMapMgr().GetNumPlayersInInstances());

        var statistics = global.getInstanceLockMgr().getStatistics();

        handler.sendSysMessage(CypherStrings.CommandInstStatSaves, statistics.instanceCount);
        handler.sendSysMessage(CypherStrings.CommandInstStatPlayersbound, statistics.playerCount);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleInstanceUnbindCommand(CommandHandler handler, Object mapArg, Integer difficultyArg) {
        var player = handler.getSelectedPlayer();

        if (player == null) {
            player = handler.getSession().getPlayer();
        }

        Integer mapId = null;
        Difficulty difficulty = null;

        if (mapArg instanceof Integer) {
            mapId = (int) mapArg;
        }

        if (difficultyArg != null && CliDB.DifficultyStorage.containsKey(difficultyArg.intValue())) {
            difficulty = Difficulty.forValue(difficultyArg);
        }

        ArrayList<InstanceLock> locksReset = new ArrayList<>();
        ArrayList<InstanceLock> locksNotReset = new ArrayList<>();

        global.getInstanceLockMgr().resetInstanceLocksForPlayer(player.getGUID(), mapId, difficulty, locksReset, locksNotReset);

        var now = gameTime.GetDateAndTime();

        for (var instanceLock : locksReset) {
            MapDb2Entries entries = new MapDb2Entries(instanceLock.getMapId(), instanceLock.getDifficultyId());
            var timeleft = !instanceLock.isExpired() ? time.secsToTimeString((long) (instanceLock.getEffectiveExpiryTime() - now).TotalSeconds, 0, false) : "-";

            handler.sendSysMessage(CypherStrings.CommandInstUnbindUnbinding, entries.Map.id, entries.Map.MapName.get(global.getWorldMgr().getDefaultDbcLocale()), entries.MapDifficulty.difficultyID, CliDB.DifficultyStorage.get(entries.MapDifficulty.difficultyID).name, instanceLock.getInstanceId(), handler.getCypherString(instanceLock.isExpired() ? CypherStrings.Yes : CypherStrings.No), handler.getCypherString(instanceLock.isExtended() ? CypherStrings.Yes : CypherStrings.No), timeleft);
        }

        handler.sendSysMessage(CypherStrings.CommandInstUnbindUnbound, locksReset.size());

        for (var instanceLock : locksNotReset) {
            MapDb2Entries entries = new MapDb2Entries(instanceLock.getMapId(), instanceLock.getDifficultyId());
            var timeleft = !instanceLock.isExpired() ? time.secsToTimeString((long) (instanceLock.getEffectiveExpiryTime() - now).TotalSeconds, 0, false) : "-";

            handler.sendSysMessage(CypherStrings.CommandInstUnbindFailed, entries.Map.id, entries.Map.MapName.get(global.getWorldMgr().getDefaultDbcLocale()), entries.MapDifficulty.difficultyID, CliDB.DifficultyStorage.get(entries.MapDifficulty.difficultyID).name, instanceLock.getInstanceId(), handler.getCypherString(instanceLock.isExpired() ? CypherStrings.Yes : CypherStrings.No), handler.getCypherString(instanceLock.isExtended() ? CypherStrings.Yes : CypherStrings.No), timeleft);
        }

        player.sendRaidInfo();

        return true;
    }
}
