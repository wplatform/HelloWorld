package com.github.azeroth.game.chat;


import com.github.azeroth.game.achievement.PlayerAchievementMgr;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.scripting.interfaces.iplayer.IPlayerOnLevelChanged;

import java.util.Objects;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class ResetCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleResetAchievementsCommand(CommandHandler handler, PlayerIdentifier player) {
        if (player == null) {
            player = PlayerIdentifier.fromTargetOrSelf(handler);
        }

        if (player == null) {
            return false;
        }

        if (player.isConnected()) {
            player.getConnectedPlayer().resetAchievements();
        } else {
            PlayerAchievementMgr.deleteFromDB(player.getGUID());
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleResetHonorCommand(CommandHandler handler, PlayerIdentifier player) {
        if (player == null) {
            player = PlayerIdentifier.fromTargetOrSelf(handler);
        }

        if (player == null || !player.isConnected()) {
            return false;
        }

        player.getConnectedPlayer().resetHonorStats();
        player.getConnectedPlayer().updateCriteria(CriteriaType.honorableKills);

        return true;
    }

    private static boolean handleResetStatsOrLevelHelper(Player player) {
        var classEntry = CliDB.ChrClassesStorage.get(player.getClass());

        if (classEntry == null) {
            Log.outError(LogFilter.Server, "Class {0} not found in DBC (Wrong DBC files?)", player.getClass());

            return false;
        }

        var powerType = classEntry.displayPower;

        // reset m_form if no aura
        if (!player.hasAuraType(AuraType.ModShapeshift)) {
            player.setShapeshiftForm(ShapeShiftForm.NONE);
        }

        player.setFactionForRace(player.getRace());
        player.setPowerType(powerType);

        // reset only if player not in some form;
        if (player.getShapeshiftForm() == ShapeShiftForm.NONE) {
            player.initDisplayIds();
        }

        player.replaceAllPvpFlags(UnitPVPStateFlags.pvP);

        player.replaceAllUnitFlags(UnitFlag.PlayerControlled);

        //-1 is default second
        player.setWatchedFactionIndex((int) 0xFFFFFFFF);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleResetLevelCommand(CommandHandler handler, PlayerIdentifier player) {
        if (player == null) {
            player = PlayerIdentifier.fromTargetOrSelf(handler);
        }

        if (player == null || !player.isConnected()) {
            return false;
        }

        var target = player.getConnectedPlayer();

        if (!handleResetStatsOrLevelHelper(target)) {
            return false;
        }

        var oldLevel = (byte) target.getLevel();

        // set starting level
        var startLevel = target.getStartLevel(target.getRace(), target.getClass());

        target._ApplyAllLevelScaleItemMods(false);
        target.setLevel(startLevel);
        target.initRunes();
        target.initStatsForLevel(true);
        target.initTaxiNodesForLevel();
        target.initTalentForLevel();
        target.setXP(0);

        target._ApplyAllLevelScaleItemMods(true);

        // reset level for pet
        var pet = target.getCurrentPet();

        if (pet) {
            pet.SynchronizeLevelWithOwner();
        }

        global.getScriptMgr().<IPlayerOnLevelChanged>ForEach(target.getClass(), p -> p.OnLevelChanged(target, oldLevel));

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleResetSpellsCommand(CommandHandler handler, PlayerIdentifier player) {
        if (player == null) {
            player = PlayerIdentifier.fromTargetOrSelf(handler);
        }

        if (player == null) {
            return false;
        }

        if (player.isConnected()) {
            var target = player.getConnectedPlayer();
            target.resetSpells();

            target.sendSysMessage(CypherStrings.ResetSpells);

            if (handler.getSession() == null || handler.getSession().getPlayer() != target) {
                handler.sendSysMessage(CypherStrings.ResetSpellsOnline, handler.getNameLink(target));
            }
        } else {
            var stmt = DB.characters.GetPreparedStatement(CharStatements.UPD_ADD_AT_LOGIN_FLAG);
            stmt.AddValue(0, (short) AtLoginFlags.ResetSpells.getValue());
            stmt.AddValue(1, player.getGUID().getCounter());
            DB.characters.execute(stmt);

            handler.sendSysMessage(CypherStrings.ResetSpellsOffline, player.getName());
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleResetStatsCommand(CommandHandler handler, PlayerIdentifier player) {
        if (player == null) {
            player = PlayerIdentifier.fromTargetOrSelf(handler);
        }

        if (player == null || !player.isConnected()) {
            return false;
        }

        var target = player.getConnectedPlayer();

        if (!handleResetStatsOrLevelHelper(target)) {
            return false;
        }

        target.initRunes();
        target.initStatsForLevel(true);
        target.initTaxiNodesForLevel();
        target.initTalentForLevel();

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleResetTalentsCommand(CommandHandler handler, PlayerIdentifier player) {
        if (player == null) {
            player = PlayerIdentifier.fromTargetOrSelf(handler);
        }

        if (player == null) {
            return false;
        }

        if (player.isConnected()) {
            var target = player.getConnectedPlayer();
            target.resetTalents(true);
            target.resetTalentSpecialization();
            target.sendTalentsInfoData();
            target.sendSysMessage(CypherStrings.ResetTalents);

            if (handler.getSession() == null || handler.getSession().getPlayer() != target) {
                handler.sendSysMessage(CypherStrings.ResetTalentsOnline, handler.getNameLink(target));
            }

			/* TODO: 6.x remove/update pet talents
			Pet* pet = target.getPet();
			pet.resetTalentsForAllPetsOf(target, pet);
			if (pet)
				target.sendTalentsInfoData(true);
			*/
            return true;
        } else if (!player.getGUID().isEmpty()) {
            var stmt = DB.characters.GetPreparedStatement(CharStatements.UPD_ADD_AT_LOGIN_FLAG);
            stmt.AddValue(0, (short) (AtLoginFlags.NONE.getValue() | AtLoginFlags.ResetPetTalents.getValue()));
            stmt.AddValue(1, player.getGUID().getCounter());
            DB.characters.execute(stmt);

            var nameLink = handler.playerLink(player.getName());
            handler.sendSysMessage(CypherStrings.ResetTalentsOffline, nameLink);

            return true;
        }

        handler.sendSysMessage(CypherStrings.NoCharSelected);

        return false;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleResetAllCommand(CommandHandler handler, String subCommand) {
        AtLoginFlags atLogin;

        // Command specially created as single command to prevent using short case names
        if (Objects.equals(subCommand, "spells")) {
            atLogin = AtLoginFlags.ResetSpells;
            global.getWorldMgr().sendWorldText(CypherStrings.ResetallSpells);

            if (handler.getSession() == null) {
                handler.sendSysMessage(CypherStrings.ResetallSpells);
            }
        } else if (Objects.equals(subCommand, "talents")) {
            atLogin = AtLoginFlags.forValue(AtLoginFlags.ResetTalents.getValue() | AtLoginFlags.ResetPetTalents.getValue());
            global.getWorldMgr().sendWorldText(CypherStrings.ResetallTalents);

            if (handler.getSession() == null) {
                handler.sendSysMessage(CypherStrings.ResetallTalents);
            }
        } else {
            handler.sendSysMessage(CypherStrings.ResetallUnknownCase, subCommand);

            return false;
        }

        var stmt = DB.characters.GetPreparedStatement(CharStatements.UPD_ALL_AT_LOGIN_FLAGS);
        stmt.AddValue(0, (short) atLogin.getValue());
        DB.characters.execute(stmt);

        var plist = global.getObjAccessor().getPlayers();

        for (var player : plist) {
            player.setAtLoginFlag(atLogin);
        }

        return true;
    }
}
