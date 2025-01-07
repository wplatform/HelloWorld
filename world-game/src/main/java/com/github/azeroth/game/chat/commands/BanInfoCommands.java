package com.github.azeroth.game.chat.commands;


import com.github.azeroth.game.entity.ObjectGuid;
import game.ObjectManager;

class BanInfoCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleBanInfoAccountCommand(CommandHandler handler, String accountName) {
        if (accountName.isEmpty()) {
            return false;
        }

        var accountId = global.getAccountMgr().getId(accountName);

        if (accountId == 0) {
            handler.sendSysMessage(CypherStrings.AccountNotExist, accountName);

            return true;
        }

        return handleBanInfoHelper(accountId, accountName, handler);
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleBanInfoCharacterCommand(CommandHandler handler, String name) {
        tangible.RefObject<String> tempRef_name = new tangible.RefObject<String>(name);
        if (!ObjectManager.normalizePlayerName(tempRef_name)) {
            name = tempRef_name.refArgValue;
            handler.sendSysMessage(CypherStrings.BaninfoNocharacter);

            return false;
        } else {
            name = tempRef_name.refArgValue;
        }

        var target = global.getObjAccessor().FindPlayerByName(name);
        ObjectGuid targetGuid = ObjectGuid.EMPTY;

        if (!target) {
            targetGuid = global.getCharacterCacheStorage().getCharacterGuidByName(name);

            if (targetGuid.isEmpty()) {
                handler.sendSysMessage(CypherStrings.BaninfoNocharacter);

                return false;
            }
        } else {
            targetGuid = target.getGUID();
        }

        var stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_BANINFO);
        stmt.AddValue(0, targetGuid.getCounter());
        var result = DB.characters.query(stmt);

        if (result.isEmpty()) {
            handler.sendSysMessage(CypherStrings.CharNotBanned, name);

            return true;
        }

        handler.sendSysMessage(CypherStrings.BaninfoBanhistory, name);

        do {
            var unbanDate = result.<Long>Read(3);
            var active = result.<Boolean>Read(2) && (result.<Long>Read(1) == 0L || unbanDate >= gameTime.GetGameTime());

            var permanent = (result.<Long>Read(1) == 0L);
            var banTime = permanent ? handler.getCypherString(CypherStrings.BaninfoInfinite) : time.secsToTimeString(result.<Long>Read(1), TimeFormat.ShortText, false);

            handler.sendSysMessage(CypherStrings.BaninfoHistoryentry, time.UnixTimeToDateTime(result.<Long>Read(0)).ToShortTimeString(), banTime, active ? handler.getCypherString(CypherStrings.Yes) : handler.getCypherString(CypherStrings.No), result.<String>Read(4), result.<String>Read(5));
        } while (result.NextRow());

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleBanInfoIPCommand(CommandHandler handler, String ip) {
        if (ip.isEmpty()) {
            return false;
        }

        var result = DB.Login.query("SELECT ip, FROM_UNIXTIME(bandate), FROM_UNIXTIME(unbandate), unbandate-UNIX_TIMESTAMP(), banreason, bannedby, unbandate-bandate FROM ip_banned WHERE ip = '{0}'", ip);

        if (result.isEmpty()) {
            handler.sendSysMessage(CypherStrings.BaninfoNoip);

            return true;
        }

        var permanent = result.<Long>Read(6) == 0;

        handler.sendSysMessage(CypherStrings.BaninfoIpentry, result.<String>Read(0), result.<String>Read(1), permanent ? handler.getCypherString(CypherStrings.BaninfoNever) : result.<String>Read(2), permanent ? handler.getCypherString(CypherStrings.BaninfoInfinite) : time.secsToTimeString(result.<Long>Read(3), TimeFormat.ShortText, false), result.<String>Read(4), result.<String>Read(5));

        return true;
    }


    private static boolean handleBanInfoHelper(int accountId, String accountName, CommandHandler handler) {
        var result = DB.Login.query("SELECT FROM_UNIXTIME(bandate), unbandate-bandate, active, unbandate, banreason, bannedby FROM account_banned WHERE id = '{0}' ORDER BY bandate ASC", accountId);

        if (result.isEmpty()) {
            handler.sendSysMessage(CypherStrings.BaninfoNoaccountban, accountName);

            return true;
        }

        handler.sendSysMessage(CypherStrings.BaninfoBanhistory, accountName);

        do {
            long unbanDate = result.<Integer>Read(3);
            var active = result.<Boolean>Read(2) && (result.<Long>Read(1) == 0 || unbanDate >= gameTime.GetGameTime());


            var permanent = (result.<Long>Read(1) == 0);
            var banTime = permanent ? handler.getCypherString(CypherStrings.BaninfoInfinite) : time.secsToTimeString(result.<Long>Read(1), TimeFormat.ShortText, false);

            handler.sendSysMessage(CypherStrings.BaninfoHistoryentry, result.<String>Read(0), banTime, active ? handler.getCypherString(CypherStrings.Yes) : handler.getCypherString(CypherStrings.No), result.<String>Read(4), result.<String>Read(5));
        } while (result.NextRow());

        return true;
    }
}
