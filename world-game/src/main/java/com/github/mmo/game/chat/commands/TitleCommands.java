package com.github.mmo.game.chat.commands;



import com.github.mmo.game.chat.*;// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
class TitleCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleTitlesCurrentCommand(CommandHandler handler, int titleId) {
        var target = handler.getSelectedPlayer();

        if (!target) {
            handler.sendSysMessage(CypherStrings.NoCharSelected);

            return false;
        }

        // check online security
        if (handler.hasLowerSecurity(target, ObjectGuid.Empty)) {
            return false;
        }

        var titleInfo = CliDB.CharTitlesStorage.get(titleId);

        if (titleInfo == null) {
            handler.sendSysMessage(CypherStrings.InvalidTitleId, titleId);

            return false;
        }

        var tNameLink = handler.getNameLink(target);
        var titleNameStr = String.format(target.getNativeGender() == gender.Male ? titleInfo.name.charAt(handler.getSessionDbcLocale()) : titleInfo.Name1[handler.getSessionDbcLocale()].ConvertFormatSyntax(), target.getName());

        target.setTitle(titleInfo);
        target.setChosenTitle(titleInfo.MaskID);

        handler.sendSysMessage(CypherStrings.TitleCurrentRes, titleId, titleNameStr, tNameLink);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleTitlesAddCommand(CommandHandler handler, int titleId) {
        var target = handler.getSelectedPlayer();

        if (!target) {
            handler.sendSysMessage(CypherStrings.NoCharSelected);

            return false;
        }

        // check online security
        if (handler.hasLowerSecurity(target, ObjectGuid.Empty)) {
            return false;
        }

        var titleInfo = CliDB.CharTitlesStorage.get(titleId);

        if (titleInfo == null) {
            handler.sendSysMessage(CypherStrings.InvalidTitleId, titleId);

            return false;
        }

        var tNameLink = handler.getNameLink(target);

        var titleNameStr = String.format((target.getNativeGender() == gender.Male ? titleInfo.Name : titleInfo.name1)[handler.getSessionDbcLocale()].ConvertFormatSyntax(), target.getName());

        target.setTitle(titleInfo);
        handler.sendSysMessage(CypherStrings.TitleAddRes, titleId, titleNameStr, tNameLink);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleTitlesRemoveCommand(CommandHandler handler, int titleId) {
        var target = handler.getSelectedPlayer();

        if (!target) {
            handler.sendSysMessage(CypherStrings.NoCharSelected);

            return false;
        }

        // check online security
        if (handler.hasLowerSecurity(target, ObjectGuid.Empty)) {
            return false;
        }

        var titleInfo = CliDB.CharTitlesStorage.get(titleId);

        if (titleInfo == null) {
            handler.sendSysMessage(CypherStrings.InvalidTitleId, titleId);

            return false;
        }

        target.setTitle(titleInfo, true);

        var tNameLink = handler.getNameLink(target);
        var titleNameStr = String.format((target.getNativeGender() == gender.Male ? titleInfo.Name : titleInfo.name1)[handler.getSessionDbcLocale()].ConvertFormatSyntax(), target.getName());

        handler.sendSysMessage(CypherStrings.TitleRemoveRes, titleId, titleNameStr, tNameLink);

        if (!target.hasTitle(target.getPlayerData().playerTitle)) {
            target.setChosenTitle(0);
            handler.sendSysMessage(CypherStrings.CurrentTitleReset, tNameLink);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class TitleSetCommands {
        //Edit Player KnownTitles
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleTitlesSetMaskCommand(CommandHandler handler, long mask) {
            var target = handler.getSelectedPlayer();

            if (!target) {
                handler.sendSysMessage(CypherStrings.NoCharSelected);

                return false;
            }

            // check online security
            if (handler.hasLowerSecurity(target, ObjectGuid.Empty)) {
                return false;
            }

            var titles2 = mask;

            for (var tEntry : CliDB.CharTitlesStorage.values()) {
                titles2 &= ~(1 << tEntry.MaskID);
            }

            mask &= ~titles2; // remove not existed titles

            target.setKnownTitles(0, mask);
            handler.sendSysMessage(CypherStrings.Done);

            if (!target.hasTitle(target.getPlayerData().playerTitle)) {
                target.setChosenTitle(0);
                handler.sendSysMessage(CypherStrings.CurrentTitleReset, handler.getNameLink(target));
            }

            return true;
        }
    }
}
