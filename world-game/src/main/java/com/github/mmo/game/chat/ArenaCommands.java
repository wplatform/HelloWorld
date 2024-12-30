package com.github.mmo.game.chat;


import com.github.mmo.game.arena.ArenaTeam;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class ArenaCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleArenaCreateCommand(CommandHandler handler, PlayerIdentifier captain, String name, ArenaTypes type) {
        if (global.getArenaTeamMgr().getArenaTeamByName(name) != null) {
            handler.sendSysMessage(CypherStrings.ArenaErrorNameExists, name);

            return false;
        }

        if (captain == null) {
            captain = PlayerIdentifier.fromTargetOrSelf(handler);
        }

        if (captain == null) {
            return false;
        }

        if (global.getCharacterCacheStorage().getCharacterArenaTeamIdByGuid(captain.getGUID(), (byte) type.getValue()) != 0) {
            handler.sendSysMessage(CypherStrings.ArenaErrorSize, captain.getName());

            return false;
        }

        ArenaTeam arena = new ArenaTeam();

        if (!arena.create(captain.getGUID(), (byte) type.getValue(), name, (int) 4293102085, (byte) 101, (int) 4293253939, (byte) 4, (int) 4284049911)) {
            handler.sendSysMessage(CypherStrings.BadValue);

            return false;
        }

        global.getArenaTeamMgr().addArenaTeam(arena);
        handler.sendSysMessage(CypherStrings.ArenaCreate, arena.getName(), arena.getId(), arena.getArenaType(), arena.getCaptain());

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleArenaDisbandCommand(CommandHandler handler, int teamId) {
        var arena = global.getArenaTeamMgr().getArenaTeamById(teamId);

        if (arena == null) {
            handler.sendSysMessage(CypherStrings.ArenaErrorNotFound, teamId);

            return false;
        }

        if (arena.isFighting()) {
            handler.sendSysMessage(CypherStrings.ArenaErrorCombat);

            return false;
        }

        var name = arena.getName();
        arena.disband();

        handler.sendSysMessage(CypherStrings.ArenaDisband, name, teamId);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleArenaRenameCommand(CommandHandler handler, String oldName, String newName) {
        var arena = global.getArenaTeamMgr().getArenaTeamByName(oldName);

        if (arena == null) {
            handler.sendSysMessage(CypherStrings.ArenaErrorNameNotFound, oldName);

            return false;
        }

        if (global.getArenaTeamMgr().getArenaTeamByName(newName) != null) {
            handler.sendSysMessage(CypherStrings.ArenaErrorNameExists, oldName);

            return false;
        }

        if (arena.isFighting()) {
            handler.sendSysMessage(CypherStrings.ArenaErrorCombat);

            return false;
        }

        if (!arena.setName(newName)) {
            handler.sendSysMessage(CypherStrings.ArenaRename, arena.getId(), oldName, newName);

            return true;
        }

        handler.sendSysMessage(CypherStrings.BadValue);

        return false;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleArenaCaptainCommand(CommandHandler handler, int teamId, PlayerIdentifier target) {
        var arena = global.getArenaTeamMgr().getArenaTeamById(teamId);

        if (arena == null) {
            handler.sendSysMessage(CypherStrings.ArenaErrorNotFound, teamId);

            return false;
        }

        if (arena.isFighting()) {
            handler.sendSysMessage(CypherStrings.ArenaErrorCombat);

            return false;
        }

        if (target == null) {
            target = PlayerIdentifier.fromTargetOrSelf(handler);
        }

        if (target == null) {
            return false;
        }

        if (!arena.isMember(target.getGUID())) {
            handler.sendSysMessage(CypherStrings.ArenaErrorNotMember, target.getName(), arena.getName());

            return false;
        }

        if (com.github.mmo.game.entity.Objects.equals(arena.getCaptain(), target.getGUID())) {
            handler.sendSysMessage(CypherStrings.ArenaErrorCaptain, target.getName(), arena.getName());

            return false;
        }

        String oldCaptainName;
        tangible.OutObject<String> tempOut_oldCaptainName = new tangible.OutObject<String>();
        if (!global.getCharacterCacheStorage().getCharacterNameByGuid(arena.getCaptain(), tempOut_oldCaptainName)) {
            oldCaptainName = tempOut_oldCaptainName.outArgValue;
            return false;
        } else {
            oldCaptainName = tempOut_oldCaptainName.outArgValue;
        }

        arena.setCaptain(target.getGUID());
        handler.sendSysMessage(CypherStrings.ArenaCaptain, arena.getName(), arena.getId(), oldCaptainName, target.getName());

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleArenaInfoCommand(CommandHandler handler, int teamId) {
        var arena = global.getArenaTeamMgr().getArenaTeamById(teamId);

        if (arena == null) {
            handler.sendSysMessage(CypherStrings.ArenaErrorNotFound, teamId);

            return false;
        }

        handler.sendSysMessage(CypherStrings.ArenaInfoHeader, arena.getName(), arena.getId(), arena.getRating(), arena.getArenaType(), arena.getArenaType());

        for (var member : arena.getMembers()) {
            handler.sendSysMessage(CypherStrings.ArenaInfoMembers, member.name, member.guid, member.personalRating, (com.github.mmo.game.entity.Objects.equals(arena.getCaptain(), member.guid) ? "- Captain" : ""));
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleArenaLookupCommand(CommandHandler handler, String needle) {
        if (needle.isEmpty()) {
            return false;
        }

        var found = false;

// C# TO JAVA CONVERTER TASK: Java has no equivalent to C# deconstruction declarations:
        for (var(_, team) : global.getArenaTeamMgr().getArenaTeamMap()) {
            if (team.getName().Equals(needle, StringComparison.OrdinalIgnoreCase)) {
                if (handler.getSession() != null) {
                    handler.sendSysMessage(CypherStrings.ArenaLookup, team.getName(), team.getId(), team.getArenaType(), team.getArenaType());
                    found = true;

                    continue;
                }
            }
        }

        if (!found) {
            handler.sendSysMessage(CypherStrings.ArenaErrorNameNotFound, needle);
        }

        return true;
    }
}
