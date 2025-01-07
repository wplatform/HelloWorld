package com.github.azeroth.game.chat;


import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.guild.guild;
import game.ObjectManager;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class GuildCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGuildCreateCommand(CommandHandler handler, StringArguments args) {
        if (args.isEmpty()) {
            return false;
        }

        Player target;
        tangible.OutObject<Player> tempOut_target = new tangible.OutObject<Player>();
        if (!handler.extractPlayerTarget(args.get(0) != '"' ? args : null, tempOut_target)) {
            target = tempOut_target.outArgValue;
            return false;
        } else {
            target = tempOut_target.outArgValue;
        }

        var guildName = handler.extractQuotedArg(args.NextString(" "));

        if (tangible.StringHelper.isNullOrEmpty(guildName)) {
            return false;
        }

        if (target.getGuildId() != 0) {
            handler.sendSysMessage(CypherStrings.PlayerInGuild);

            return false;
        }

        if (global.getGuildMgr().getGuildByName(guildName)) {
            handler.sendSysMessage(CypherStrings.GuildRenameAlreadyExists);

            return false;
        }

        if (global.getObjectMgr().isReservedName(guildName) || !ObjectManager.isValidCharterName(guildName)) {
            handler.sendSysMessage(CypherStrings.BadValue);

            return false;
        }

        Guild guild = new guild();

        if (!guild.create(target, guildName)) {
            handler.sendSysMessage(CypherStrings.GuildNotCreated);

            return false;
        }

        global.getGuildMgr().addGuild(guild);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGuildDeleteCommand(CommandHandler handler, QuotedString guildName) {
        if (guildName.isEmpty()) {
            return false;
        }

        var guild = global.getGuildMgr().getGuildByName(guildName);

        if (guild == null) {
            return false;
        }

        guild.disband();

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGuildInviteCommand(CommandHandler handler, PlayerIdentifier targetIdentifier, QuotedString guildName) {
        if (targetIdentifier == null) {
            targetIdentifier = PlayerIdentifier.fromTargetOrSelf(handler);
        }

        if (targetIdentifier == null) {
            return false;
        }

        if (guildName.isEmpty()) {
            return false;
        }

        var targetGuild = global.getGuildMgr().getGuildByName(guildName);

        if (targetGuild == null) {
            return false;
        }

        targetGuild.addMember(null, targetIdentifier.getGUID());

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGuildUninviteCommand(CommandHandler handler, PlayerIdentifier targetIdentifier, QuotedString guildName) {
        if (targetIdentifier == null) {
            targetIdentifier = PlayerIdentifier.fromTargetOrSelf(handler);
        }

        if (targetIdentifier == null) {
            return false;
        }

        var guildId = targetIdentifier.isConnected() ? targetIdentifier.getConnectedPlayer().getGuildId() : global.getCharacterCacheStorage().getCharacterGuildIdByGuid(targetIdentifier.getGUID());

        if (guildId == 0) {
            return false;
        }

        var targetGuild = global.getGuildMgr().getGuildById(guildId);

        if (targetGuild == null) {
            return false;
        }

        targetGuild.deleteMember(null, targetIdentifier.getGUID(), false, true, true);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGuildRankCommand(CommandHandler handler, PlayerIdentifier player, byte rank) {
        if (player == null) {
            player = PlayerIdentifier.fromTargetOrSelf(handler);
        }

        if (player == null) {
            return false;
        }

        var guildId = player.isConnected() ? player.getConnectedPlayer().getGuildId() : global.getCharacterCacheStorage().getCharacterGuildIdByGuid(player.getGUID());

        if (guildId == 0) {
            return false;
        }

        var targetGuild = global.getGuildMgr().getGuildById(guildId);

        if (!targetGuild) {
            return false;
        }

        return targetGuild.changeMemberRank(null, player.getGUID(), GuildRankId.forValue(rank));
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGuildRenameCommand(CommandHandler handler, QuotedString oldGuildName, QuotedString newGuildName) {
        if (oldGuildName.isEmpty()) {
            handler.sendSysMessage(CypherStrings.BadValue);

            return false;
        }

        if (newGuildName.isEmpty()) {
            handler.sendSysMessage(CypherStrings.InsertGuildName);

            return false;
        }

        var guild = global.getGuildMgr().getGuildByName(oldGuildName);

        if (!guild) {
            handler.sendSysMessage(CypherStrings.CommandCouldnotfind, oldGuildName);

            return false;
        }

        if (global.getGuildMgr().getGuildByName(newGuildName)) {
            handler.sendSysMessage(CypherStrings.GuildRenameAlreadyExists, newGuildName);

            return false;
        }

        if (!guild.setName(newGuildName)) {
            handler.sendSysMessage(CypherStrings.BadValue);

            return false;
        }

        handler.sendSysMessage(CypherStrings.GuildRenameDone, oldGuildName, newGuildName);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGuildInfoCommand(CommandHandler handler, StringArguments args) {
        Guild guild = null;
        var target = handler.getSelectedPlayerOrSelf();

        if (!args.isEmpty() && args.get(0) != '\0') {
            if (Character.isDigit(args.get(0))) {
                guild = global.getGuildMgr().getGuildById(args.NextUInt64(" "));
            } else {
                guild = global.getGuildMgr().getGuildByName(args.NextString(" "));
            }
        } else if (target) {
            guild = target.getGuild();
        }

        if (!guild) {
            return false;
        }

        // Display Guild Information
        handler.sendSysMessage(CypherStrings.GuildInfoName, guild.getName(), guild.getId()); // Guild id + Name

        String guildMasterName;
        tangible.OutObject<String> tempOut_guildMasterName = new tangible.OutObject<String>();
        if (global.getCharacterCacheStorage().getCharacterNameByGuid(guild.getLeaderGUID(), tempOut_guildMasterName)) {
            guildMasterName = tempOut_guildMasterName.outArgValue;
            handler.sendSysMessage(CypherStrings.GuildInfoGuildMaster, guildMasterName, guild.getLeaderGUID().toString()); // Guild Master
        } else {
            guildMasterName = tempOut_guildMasterName.outArgValue;
        }

        // Format creation date

        var createdDateTime = time.UnixTimeToDateTime(guild.getCreatedDate());
        handler.sendSysMessage(CypherStrings.GuildInfoCreationDate, createdDateTime.ToLongDateString()); // Creation Date
        handler.sendSysMessage(CypherStrings.GuildInfoMemberCount, guild.getMembersCount()); // Number of Members
        handler.sendSysMessage(CypherStrings.GuildInfoBankGold, guild.getBankMoney() / 100 / 100); // Bank gold (in gold coins)
        handler.sendSysMessage(CypherStrings.GuildInfoLevel, guild.getLevel()); // Level
        handler.sendSysMessage(CypherStrings.GuildInfoMotd, guild.getMOTD()); // Message of the Day
        handler.sendSysMessage(CypherStrings.GuildInfoExtraInfo, guild.getInfo()); // Extra Information

        return true;
    }
}
