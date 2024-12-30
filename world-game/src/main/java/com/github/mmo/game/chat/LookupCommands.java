package com.github.mmo.game.chat;


import com.github.mmo.game.entity.ObjectGuid;
import game.WorldConfig;
import game.datastorage.CliDB;

class LookupCommands {
    private static final int maxResults = 50;

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleLookupAreaCommand(CommandHandler handler, String namePart) {
        namePart = namePart.toLowerCase();

        var found = false;
        int count = 0;

        // Search in AreaTable.dbc
        for (var areaEntry : CliDB.AreaTableStorage.values()) {
            var locale = handler.getSessionDbcLocale();
            var name = areaEntry.AreaName[locale];

            if (tangible.StringHelper.isNullOrEmpty(name)) {
                continue;
            }

            if (!name.Like(namePart)) {
                locale = locale.forValue(0);

                for (; locale.getValue() < locale.Total.getValue(); ++locale) {
                    if (locale == handler.getSessionDbcLocale()) {
                        continue;
                    }

                    name = areaEntry.AreaName[locale];

                    if (name.isEmpty()) {
                        continue;
                    }

                    if (name.Like(namePart)) {
                        break;
                    }
                }
            }

            if (locale.getValue() < locale.Total.getValue()) {
                if (maxResults != 0 && count++ == maxResults) {
                    handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                    return true;
                }

                // send area in "id - [name]" format
                var ss = "";

                if (handler.getSession() != null) {
                    ss += areaEntry.id + " - |cffffffff|Harea:" + areaEntry.id + "|h[" + name + "]|h|r";
                } else {
                    ss += areaEntry.id + " - " + name;
                }

                handler.sendSysMessage(ss);

                if (!found) {
                    found = true;
                }
            }
        }

        if (!found) {
            handler.sendSysMessage(CypherStrings.CommandNoareafound);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleLookupCreatureCommand(CommandHandler handler, String namePart) {
        namePart = namePart.toLowerCase();

        var found = false;
        int count = 0;

        var ctc = global.getObjectMgr().getCreatureTemplates();

        for (var template : ctc.entrySet()) {
            var id = template.getValue().entry;
            var localeIndex = handler.getSessionDbLocaleIndex();
            var creatureLocale = global.getObjectMgr().getCreatureLocale(id);

            if (creatureLocale != null) {
                if (creatureLocale.name.length > localeIndex && !tangible.StringHelper.isNullOrEmpty(creatureLocale.name.charAt(localeIndex))) {
                    var name = creatureLocale.name.charAt(localeIndex);

                    if (name.Like(namePart)) {
                        if (maxResults != 0 && count++ == maxResults) {
                            handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                            return true;
                        }

                        if (handler.getSession() != null) {
                            handler.sendSysMessage(CypherStrings.CreatureEntryListChat, id, id, name);
                        } else {
                            handler.sendSysMessage(CypherStrings.CreatureEntryListConsole, id, name);
                        }

                        if (!found) {
                            found = true;
                        }

                        continue;
                    }
                }
            }

            var name = template.getValue().name;

            if (tangible.StringHelper.isNullOrEmpty(name)) {
                continue;
            }

            if (name.Like(namePart)) {
                if (maxResults != 0 && count++ == maxResults) {
                    handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                    return true;
                }

                if (handler.getSession() != null) {
                    handler.sendSysMessage(CypherStrings.CreatureEntryListChat, id, id, name);
                } else {
                    handler.sendSysMessage(CypherStrings.CreatureEntryListConsole, id, name);
                }

                if (!found) {
                    found = true;
                }
            }
        }

        if (!found) {
            handler.sendSysMessage(CypherStrings.CommandNocreaturefound);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleLookupEventCommand(CommandHandler handler, String namePart) {
        namePart = namePart.toLowerCase();

        var found = false;
        int count = 0;

        var events = global.getGameEventMgr().getEventMap();
        var activeEvents = global.getGameEventMgr().getActiveEventList();

        for (short id = 0; id < events.length; ++id) {
            var eventData = events[id];

            var descr = eventData.description;

            if (tangible.StringHelper.isNullOrEmpty(descr)) {
                continue;
            }

            if (descr.Like(namePart)) {
                if (maxResults != 0 && count++ == maxResults) {
                    handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                    return true;
                }

                var active = activeEvents.contains(id) ? handler.getCypherString(CypherStrings.active) : "";

                if (handler.getSession() != null) {
                    handler.sendSysMessage(CypherStrings.EventEntryListChat, id, id, eventData.description, active);
                } else {
                    handler.sendSysMessage(CypherStrings.EventEntryListConsole, id, eventData.description, active);
                }

                if (!found) {
                    found = true;
                }
            }
        }

        if (!found) {
            handler.sendSysMessage(CypherStrings.Noeventfound);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleLookupFactionCommand(CommandHandler handler, String namePart) {
        // Can be NULL at console call
        var target = handler.getSelectedPlayer();

        namePart = namePart.toLowerCase();

        var found = false;
        int count = 0;


        for (var factionEntry : CliDB.FactionStorage.values()) {
            var factionState = target ? target.getReputationMgr().getState(factionEntry) : null;

            var locale = handler.getSessionDbcLocale();
            var name = factionEntry.name.charAt(locale);

            if (tangible.StringHelper.isNullOrEmpty(name)) {
                continue;
            }

            if (!name.Like(namePart)) {
                locale = locale.forValue(0);

                for (; locale.getValue() < locale.Total.getValue(); ++locale) {
                    if (locale == handler.getSessionDbcLocale()) {
                        continue;
                    }

                    name = factionEntry.name.charAt(locale);

                    if (name.isEmpty()) {
                        continue;
                    }

                    if (name.Like(namePart)) {
                        break;
                    }
                }
            }

            if (locale.getValue() < locale.Total.getValue()) {
                if (maxResults != 0 && count++ == maxResults) {
                    handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                    return true;
                }

                // send faction in "id - [faction] rank reputation [visible] [at war] [own team] [unknown] [invisible] [inactive]" format
                // or              "id - [faction] [no reputation]" format
                StringBuilder ss = new StringBuilder();

                if (handler.getSession() != null) {
                    ss.append(String.format("%1$s - |cffffffff|Hfaction:%1$s|h[%2$s]|h|r", factionEntry.id, name));
                } else {
                    ss.append(factionEntry.id + " - " + name);
                }

                if (factionState != null) // and then target != NULL also
                {
                    var index = target.getReputationMgr().getReputationRankStrIndex(factionEntry);
                    var rankName = handler.getCypherString(CypherStrings.forValue(index));

                    ss.append(String.format(" %1$s|h|r (%2$s)", rankName, target.getReputationMgr().getReputation(factionEntry)));

                    if (factionState.flags.hasFlag(ReputationFlags.Visible)) {
                        ss.append(handler.getCypherString(CypherStrings.FactionVisible));
                    }

                    if (factionState.flags.hasFlag(ReputationFlags.AtWar)) {
                        ss.append(handler.getCypherString(CypherStrings.FactionAtwar));
                    }

                    if (factionState.flags.hasFlag(ReputationFlags.Peaceful)) {
                        ss.append(handler.getCypherString(CypherStrings.FactionPeaceForced));
                    }

                    if (factionState.flags.hasFlag(ReputationFlags.hidden)) {
                        ss.append(handler.getCypherString(CypherStrings.FactionHidden));
                    }

                    if (factionState.flags.hasFlag(ReputationFlags.header)) {
                        ss.append(handler.getCypherString(CypherStrings.FactionInvisibleForced));
                    }

                    if (factionState.flags.hasFlag(ReputationFlags.inactive)) {
                        ss.append(handler.getCypherString(CypherStrings.FactionInactive));
                    }
                } else {
                    ss.append(handler.getCypherString(CypherStrings.FactionNoreputation));
                }

                handler.sendSysMessage(ss.toString());

                if (!found) {
                    found = true;
                }
            }
        }

        if (!found) {
            handler.sendSysMessage(CypherStrings.CommandFactionNotfound);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleLookupItemSetCommand(CommandHandler handler, String namePart) {
        namePart = namePart.toLowerCase();

        var found = false;
        int count = 0;

        // Search in ItemSet.dbc
        for (var set : CliDB.ItemSetStorage.values()) {
            var locale = handler.getSessionDbcLocale();
            var name = set.name.charAt(locale);

            if (name.isEmpty()) {
                continue;
            }

            if (!name.Like(namePart)) {
                locale = locale.forValue(0);

                for (; locale.getValue() < locale.Total.getValue(); ++locale) {
                    if (locale == handler.getSessionDbcLocale()) {
                        continue;
                    }

                    name = set.name.charAt(locale);

                    if (name.isEmpty()) {
                        continue;
                    }

                    if (name.Like(namePart)) {
                        break;
                    }
                }
            }

            if (locale.getValue() < locale.Total.getValue()) {
                if (maxResults != 0 && count++ == maxResults) {
                    handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                    return true;
                }

                // send item set in "id - [namedlink locale]" format
                if (handler.getSession() != null) {
                    handler.sendSysMessage(CypherStrings.ItemsetListChat, set.id, set.id, name, "");
                } else {
                    handler.sendSysMessage(CypherStrings.ItemsetListConsole, set.id, name, "");
                }

                if (!found) {
                    found = true;
                }
            }
        }

        if (!found) {
            handler.sendSysMessage(CypherStrings.CommandNoitemsetfound);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleLookupObjectCommand(CommandHandler handler, String namePart) {
        var found = false;
        int count = 0;

        var gotc = global.getObjectMgr().getGameObjectTemplates();

        for (var template : gotc.values()) {
            var localeIndex = handler.getSessionDbLocaleIndex();

            var objectLocalte = global.getObjectMgr().getGameObjectLocale(template.entry);

            if (objectLocalte != null) {
                if (objectLocalte.name.length > localeIndex && !tangible.StringHelper.isNullOrEmpty(objectLocalte.name.charAt(localeIndex))) {
                    var name = objectLocalte.name.charAt(localeIndex);

                    if (name.Like(namePart)) {
                        if (maxResults != 0 && count++ == maxResults) {
                            handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                            return true;
                        }

                        if (handler.getSession() != null) {
                            handler.sendSysMessage(CypherStrings.GoEntryListChat, template.entry, template.entry, name);
                        } else {
                            handler.sendSysMessage(CypherStrings.GoEntryListConsole, template.entry, name);
                        }

                        if (!found) {
                            found = true;
                        }

                        continue;
                    }
                }
            }

            var name = template.name;

            if (tangible.StringHelper.isNullOrEmpty(name)) {
                continue;
            }

            if (name.Like(namePart)) {
                if (maxResults != 0 && count++ == maxResults) {
                    handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                    return true;
                }

                if (handler.getSession() != null) {
                    handler.sendSysMessage(CypherStrings.GoEntryListChat, template.entry, template.entry, name);
                } else {
                    handler.sendSysMessage(CypherStrings.GoEntryListConsole, template.entry, name);
                }

                if (!found) {
                    found = true;
                }
            }
        }

        if (!found) {
            handler.sendSysMessage(CypherStrings.CommandNogameobjectfound);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleLookupSkillCommand(CommandHandler handler, String namePart) {
        // can be NULL in console call
        var target = handler.getSelectedPlayer();

        var found = false;
        int count = 0;

        // Search in skillLine.dbc
        for (var skillInfo : CliDB.SkillLineStorage.values()) {
            var locale = handler.getSessionDbcLocale();
            var name = skillInfo.DisplayName[locale];

            if (tangible.StringHelper.isNullOrEmpty(name)) {
                continue;
            }

            if (!name.Like(namePart)) {
                locale = locale.forValue(0);

                for (; locale.getValue() < locale.Total.getValue(); ++locale) {
                    if (locale == handler.getSessionDbcLocale()) {
                        continue;
                    }

                    name = skillInfo.DisplayName[locale];

                    if (name.isEmpty()) {
                        continue;
                    }

                    if (name.Like(namePart)) {
                        break;
                    }
                }
            }

            if (locale.getValue() < locale.Total.getValue()) {
                if (maxResults != 0 && count++ == maxResults) {
                    handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                    return true;
                }

                var valStr = "";
                var knownStr = "";

                if (target && target.hasSkill(SkillType.forValue(skillInfo.id))) {
                    knownStr = handler.getCypherString(CypherStrings.Known);
                    int curValue = target.getPureSkillValue(SkillType.forValue(skillInfo.id));
                    int maxValue = target.getPureMaxSkillValue(SkillType.forValue(skillInfo.id));
                    int permValue = target.getSkillPermBonusValue(skillInfo.id);
                    int tempValue = target.getSkillTempBonusValue(skillInfo.id);

                    var valFormat = handler.getCypherString(CypherStrings.SkillValues);
                    valStr = String.format(valFormat, curValue, maxValue, permValue, tempValue);
                }

                // send skill in "id - [namedlink locale]" format
                if (handler.getSession() != null) {
                    handler.sendSysMessage(CypherStrings.SkillListChat, skillInfo.id, skillInfo.id, name, "", knownStr, valStr);
                } else {
                    handler.sendSysMessage(CypherStrings.SkillListConsole, skillInfo.id, name, "", knownStr, valStr);
                }

                if (!found) {
                    found = true;
                }
            }
        }

        if (!found) {
            handler.sendSysMessage(CypherStrings.CommandNoskillfound);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleLookupTaxiNodeCommand(CommandHandler handler, String namePart) {
        var found = false;
        int count = 0;
        var locale = handler.getSessionDbcLocale();

        // Search in TaxiNodes.dbc
        for (var nodeEntry : CliDB.TaxiNodesStorage.values()) {
            var name = nodeEntry.name.charAt(locale);

            if (tangible.StringHelper.isNullOrEmpty(name)) {
                continue;
            }

            if (!name.Like(namePart)) {
                continue;
            }

            if (maxResults != 0 && count++ == maxResults) {
                handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                return true;
            }

            // send taxinode in "id - [name] (Map:m X:x Y:y Z:z)" format
            if (handler.getSession() != null) {
                handler.sendSysMessage(CypherStrings.TaxinodeEntryListChat, nodeEntry.id, nodeEntry.id, name, "", nodeEntry.ContinentID, nodeEntry.pos.X, nodeEntry.pos.Y, nodeEntry.pos.Z);
            } else {
                handler.sendSysMessage(CypherStrings.TaxinodeEntryListConsole, nodeEntry.id, name, "", nodeEntry.ContinentID, nodeEntry.pos.X, nodeEntry.pos.Y, nodeEntry.pos.Z);
            }

            if (!found) {
                found = true;
            }
        }

        if (!found) {
            handler.sendSysMessage(CypherStrings.CommandNotaxinodefound);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleLookupTeleCommand(CommandHandler handler, String namePart) {
        namePart = namePart.toLowerCase();

        StringBuilder reply = new StringBuilder();
        int count = 0;
        var limitReached = false;

        for (var tele : global.getObjectMgr().gameTeleStorage.entrySet()) {
            if (!tele.getValue().name.Like(namePart)) {
                continue;
            }

            if (maxResults != 0 && count++ == maxResults) {
                limitReached = true;

                break;
            }

            if (handler.getPlayer() != null) {
                reply.append(String.format("  |cffffffff|Htele:%1$s|h[%2$s]|h|r\n", tele.getKey(), tele.getValue().name));
            } else {
                reply.append(String.format("  %1$s : %2$s\n", tele.getKey(), tele.getValue().name));
            }
        }

        if (reply.capacity() == 0) {
            handler.sendSysMessage(CypherStrings.CommandTeleNolocation);
        } else {
            handler.sendSysMessage(CypherStrings.CommandTeleLocation, reply.toString());
        }

        if (limitReached) {
            handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleLookupTitleCommand(CommandHandler handler, String namePart) {
        // can be NULL in console call
        var target = handler.getSelectedPlayer();

        // title name have single string arg for player name
        var targetName = target ? target.getName() : "NAME";

        int counter = 0; // Counter for figure out that we found smth.

        // Search in CharTitles.dbc
        for (var titleInfo : CliDB.CharTitlesStorage.values()) {
            for (var gender = gender.Male; gender.getValue() <= gender.Female.getValue(); ++gender) {
                if (target && target.getGender() != gender) {
                    continue;
                }

                var locale = handler.getSessionDbcLocale();
                var name = gender == gender.Male ? titleInfo.name.charAt(locale) : titleInfo.Name1[locale];

                if (tangible.StringHelper.isNullOrEmpty(name)) {
                    continue;
                }

                if (!name.Like(namePart)) {
                    locale = locale.forValue(0);

                    for (; locale.getValue() < locale.Total.getValue(); ++locale) {
                        if (locale == handler.getSessionDbcLocale()) {
                            continue;
                        }

                        name = (gender == gender.Male ? titleInfo.Name : titleInfo.name1)[locale];

                        if (name.isEmpty()) {
                            continue;
                        }

                        if (name.Like(namePart)) {
                            break;
                        }
                    }
                }

                if (locale.getValue() < locale.Total.getValue()) {
                    if (maxResults != 0 && counter == maxResults) {
                        handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                        return true;
                    }

                    var knownStr = target && target.hasTitle(titleInfo) ? handler.getCypherString(CypherStrings.Known) : "";

                    var activeStr = target && target.getPlayerData().playerTitle == titleInfo.MaskID ? handler.getCypherString(CypherStrings.active) : "";

                    var titleNameStr = String.format(name.ConvertFormatSyntax(), targetName);

                    // send title in "id (idx:idx) - [namedlink locale]" format
                    if (handler.getSession() != null) {
                        handler.sendSysMessage(CypherStrings.TitleListChat, titleInfo.id, titleInfo.MaskID, titleInfo.id, titleNameStr, "", knownStr, activeStr);
                    } else {
                        handler.sendSysMessage(CypherStrings.TitleListConsole, titleInfo.id, titleInfo.MaskID, titleNameStr, "", knownStr, activeStr);
                    }

                    ++counter;
                }
            }
        }

        if (counter == 0) // if counter == 0 then we found nth
        {
            handler.sendSysMessage(CypherStrings.CommandNotitlefound);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class LookupItemCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleLookupItemCommand(CommandHandler handler, String namePart) {
            var found = false;
            int count = 0;

            // Search in ItemSparse
            var its = global.getObjectMgr().getItemTemplates();

            for (var template : its.values()) {
                var name = template.getName(handler.getSessionDbcLocale());

                if (tangible.StringHelper.isNullOrEmpty(name)) {
                    continue;
                }

                if (name.Like(namePart)) {
                    if (maxResults != 0 && count++ == maxResults) {
                        handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                        return true;
                    }

                    if (handler.getSession() != null) {
                        handler.sendSysMessage(CypherStrings.ItemListChat, template.id, template.id, name);
                    } else {
                        handler.sendSysMessage(CypherStrings.ItemListConsole, template.id, name);
                    }

                    if (!found) {
                        found = true;
                    }
                }
            }

            if (!found) {
                handler.sendSysMessage(CypherStrings.CommandNoitemfound);
            }

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleLookupItemIdCommand(CommandHandler handler, int id) {
            var itemTemplate = global.getObjectMgr().getItemTemplate(id);

            if (itemTemplate != null) {
                var name = itemTemplate.getName(handler.getSessionDbcLocale());

                if (name.isEmpty()) {
                    handler.sendSysMessage(CypherStrings.CommandNoitemfound);

                    return true;
                }

                if (handler.getSession()) {
                    handler.sendSysMessage(CypherStrings.ItemListChat, id, id, name);
                } else {
                    handler.sendSysMessage(CypherStrings.ItemListConsole, id, name);
                }
            } else {
                handler.sendSysMessage(CypherStrings.CommandNoitemfound);
            }

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleLookupItemSetCommand(CommandHandler handler, String namePart) {
            if (namePart.isEmpty()) {
                return false;
            }

            var found = false;
            int count = 0;
            var maxResults = WorldConfig.getUIntValue(WorldCfg.MaxResultsLookupCommands);

            // Search in ItemSet.dbc
// C# TO JAVA CONVERTER TASK: Java has no equivalent to C# deconstruction declarations:
            for (var(id, set) : CliDB.ItemSetStorage) {
                var locale = handler.getSessionDbcLocale();
                var name = set.name.charAt(locale);

                if (name.isEmpty()) {
                    continue;
                }

                if (!name.Equals(namePart, StringComparison.OrdinalIgnoreCase)) {
                    locale = locale.enUS;

                    for (; locale.getValue() < locale.Total.getValue(); ++locale) {
                        if (locale == handler.getSessionDbcLocale()) {
                            continue;
                        }

                        name = set.name.charAt(locale);

                        if (name.isEmpty()) {
                            continue;
                        }

                        if (name.Equals(namePart, StringComparison.OrdinalIgnoreCase)) {
                            break;
                        }
                    }
                }

                if (locale.getValue() < locale.Total.getValue()) {
                    if (maxResults != 0 && count++ == maxResults) {
                        handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                        return true;
                    }

                    // send item set in "id - [namedlink locale]" format
                    if (handler.getSession()) {
                        handler.sendSysMessage(CypherStrings.ItemsetListChat, id, id, name, "");
                    } else {
                        handler.sendSysMessage(CypherStrings.ItemsetListConsole, id, name, "");
                    }

                    if (!found) {
                        found = true;
                    }
                }
            }

            if (!found) {
                handler.sendSysMessage(CypherStrings.CommandNoitemsetfound);
            }

            return true;
        }
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class LookupMapCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleLookupMapCommand(CommandHandler handler, String namePart) {
            if (namePart.isEmpty()) {
                return false;
            }

            int counter = 0;

            // search in Map.dbc
            for (var mapInfo : CliDB.MapStorage.values()) {
                var locale = handler.getSessionDbcLocale();
                var name = mapInfo.MapName[locale];

                if (tangible.StringHelper.isNullOrEmpty(name)) {
                    continue;
                }

                if (!name.Like(namePart) && handler.getSession()) {
                    locale = locale.forValue(0);

                    for (; locale.getValue() < locale.Total.getValue(); ++locale) {
                        if (locale == handler.getSessionDbcLocale()) {
                            continue;
                        }

                        name = mapInfo.MapName[locale];

                        if (name.isEmpty()) {
                            continue;
                        }

                        if (name.Like(namePart)) {
                            break;
                        }
                    }
                }

                if (locale.getValue() < locale.Total.getValue()) {
                    if (maxResults != 0 && counter == maxResults) {
                        handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                        return true;
                    }

                    StringBuilder ss = new StringBuilder();
                    ss.append(mapInfo.id + " - [" + name + ']');

                    if (mapInfo.IsContinent()) {
                        ss.append(handler.getCypherString(CypherStrings.Continent));
                    }

                    switch (mapInfo.instanceType) {
                        case MapTypes.Instance:
                            ss.append(handler.getCypherString(CypherStrings.instance));

                            break;
                        case MapTypes.Raid:
                            ss.append(handler.getCypherString(CypherStrings.raid));

                            break;
                        case MapTypes.Battleground:
                            ss.append(handler.getCypherString(CypherStrings.Battleground));

                            break;
                        case MapTypes.Arena:
                            ss.append(handler.getCypherString(CypherStrings.Arena));

                            break;
                    }

                    handler.sendSysMessage(ss.toString());

                    ++counter;
                }
            }

            if (counter == 0) {
                handler.sendSysMessage(CypherStrings.CommandNomapfound);
            }

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleLookupMapIdCommand(CommandHandler handler, int id) {
            var mapInfo = CliDB.MapStorage.get(id);

            if (mapInfo != null) {
                var locale = handler.getSession() ? handler.getSession().getSessionDbcLocale() : global.getWorldMgr().getDefaultDbcLocale();
                var name = mapInfo.MapName[locale];

                if (name.isEmpty()) {
                    handler.sendSysMessage(CypherStrings.CommandNomapfound);

                    return true;
                }

                StringBuilder ss = new StringBuilder();
                ss.append(String.format("%1$s - [%2$s]", id, name));

                if (mapInfo.IsContinent()) {
                    ss.append(handler.getCypherString(CypherStrings.Continent));
                }

                switch (mapInfo.instanceType) {
                    case MapTypes.Instance:
                        ss.append(handler.getCypherString(CypherStrings.instance));

                        break;
                    case MapTypes.Raid:
                        ss.append(handler.getCypherString(CypherStrings.raid));

                        break;
                    case MapTypes.Battleground:
                        ss.append(handler.getCypherString(CypherStrings.Battleground));

                        break;
                    case MapTypes.Arena:
                        ss.append(handler.getCypherString(CypherStrings.Arena));

                        break;
                    case MapTypes.Scenario:
                        ss.append(handler.getCypherString(CypherStrings.Scenario));

                        break;
                }

                handler.sendSysMessage(ss.toString());
            } else {
                handler.sendSysMessage(CypherStrings.CommandNomapfound);
            }

            return true;
        }
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class LookupPlayerCommands {
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:

        private static boolean handleLookupPlayerIpCommand(CommandHandler handler, String ip) {
            return handleLookupPlayerIpCommand(handler, ip, -1);
        }

        private static boolean handleLookupPlayerIpCommand(CommandHandler handler, String ip, int limit) {
            var target = handler.getSelectedPlayer();

            if (ip.isEmpty()) {
                // NULL only if used from console
                if (!target || target == handler.getSession().getPlayer()) {
                    return false;
                }

                ip = target.getSession().getRemoteAddress();
            }

            var stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_ACCOUNT_BY_IP);
            stmt.AddValue(0, ip);

            return lookupPlayerSearchCommand(DB.Login.query(stmt), limit, handler);
        }

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:

        private static boolean handleLookupPlayerAccountCommand(CommandHandler handler, String account) {
            return handleLookupPlayerAccountCommand(handler, account, -1);
        }

        private static boolean handleLookupPlayerAccountCommand(CommandHandler handler, String account, int limit) {
            var stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_ACCOUNT_LIST_BY_NAME);
            stmt.AddValue(0, account);

            return lookupPlayerSearchCommand(DB.Login.query(stmt), limit, handler);
        }

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:

        private static boolean handleLookupPlayerEmailCommand(CommandHandler handler, String email) {
            return handleLookupPlayerEmailCommand(handler, email, -1);
        }

        private static boolean handleLookupPlayerEmailCommand(CommandHandler handler, String email, int limit) {
            var stmt = DB.Login.GetPreparedStatement(LoginStatements.SEL_ACCOUNT_LIST_BY_EMAIL);
            stmt.AddValue(0, email);

            return lookupPlayerSearchCommand(DB.Login.query(stmt), limit, handler);
        }

        private static boolean lookupPlayerSearchCommand(SQLResult result, int limit, CommandHandler handler) {
            if (result.isEmpty()) {
                handler.sendSysMessage(CypherStrings.NoPlayersFound);

                return false;
            }

            var counter = 0;
            int count = 0;

            do {
                if (maxResults != 0 && count++ == maxResults) {
                    handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                    return true;
                }

                var accountId = result.<Integer>Read(0);
                var accountName = result.<String>Read(1);

                var stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_CHAR_GUID_NAME_BY_ACC);
                stmt.AddValue(0, accountId);
                var result2 = DB.characters.query(stmt);

                if (!result2.isEmpty()) {
                    handler.sendSysMessage(CypherStrings.LookupPlayerAccount, accountName, accountId);

                    do {
                        var guid = ObjectGuid.create(HighGuid.Player, result2.<Long>Read(0));
                        var name = result2.<String>Read(1);
                        var online = result2.<Boolean>Read(2);

                        handler.sendSysMessage(CypherStrings.LookupPlayerCharacter, name, guid.toString(), online ? handler.getCypherString(CypherStrings.online) : "");
                        ++counter;
                    } while (result2.NextRow() && (limit == -1 || counter < limit));
                }
            } while (result.NextRow());

            if (counter == 0) // empty accounts only
            {
                handler.sendSysMessage(CypherStrings.NoPlayersFound);

                return false;
            }

            return true;
        }
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class LookupQuestCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleLookupQuestCommand(CommandHandler handler, String namePart) {
            // can be NULL at console call
            var target = handler.getSelectedPlayer();

            namePart = namePart.toLowerCase();

            var found = false;
            int count = 0;

            var qTemplates = global.getObjectMgr().getQuestTemplates();

            for (var qInfo : qTemplates.values()) {
                int localeIndex = handler.getSessionDbLocaleIndex();
                var questLocale = global.getObjectMgr().getQuestLocale(qInfo.id);

                if (questLocale != null) {
                    if (questLocale.logTitle.length > localeIndex && !questLocale.logTitle.get(localeIndex).isEmpty()) {
                        var title = questLocale.logTitle.get(localeIndex);

                        if (title.Like(namePart)) {
                            if (maxResults != 0 && count++ == maxResults) {
                                handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                                return true;
                            }

                            var statusStr = "";

                            if (target) {
                                switch (target.getQuestStatus(qInfo.id)) {
                                    case Complete:
                                        statusStr = handler.getCypherString(CypherStrings.CommandQuestComplete);

                                        break;
                                    case Incomplete:
                                        statusStr = handler.getCypherString(CypherStrings.CommandQuestActive);

                                        break;
                                    case Rewarded:
                                        statusStr = handler.getCypherString(CypherStrings.CommandQuestRewarded);

                                        break;
                                    default:
                                        break;
                                }
                            }

                            if (handler.getSession() != null) {
                                var maxLevel = 0;
                                var questLevels = global.getDB2Mgr().GetContentTuningData(qInfo.contentTuningId, handler.getSession().getPlayer().getPlayerData().ctrOptions.getValue().contentTuningConditionMask);

                                if (questLevels != null) {
                                    maxLevel = questLevels.getValue().maxLevel;
                                }

                                var scalingFactionGroup = 0;
                                var contentTuning = CliDB.ContentTuningStorage.get(qInfo.contentTuningId);

                                if (contentTuning != null) {
                                    scalingFactionGroup = contentTuning.GetScalingFactionGroup();
                                }

                                handler.sendSysMessage(CypherStrings.QuestListChat, qInfo.id, qInfo.id, handler.getSession().getPlayer().getQuestLevel(qInfo), handler.getSession().getPlayer().getQuestMinLevel(qInfo), maxLevel, scalingFactionGroup, title, statusStr);
                            } else {
                                handler.sendSysMessage(CypherStrings.QuestListConsole, qInfo.id, title, statusStr);
                            }

                            if (!found) {
                                found = true;
                            }

                            continue;
                        }
                    }
                }

                var _title = qInfo.logTitle;

                if (tangible.StringHelper.isNullOrEmpty(_title)) {
                    continue;
                }

                if (_title.Like(namePart)) {
                    if (maxResults != 0 && count++ == maxResults) {
                        handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                        return true;
                    }

                    var statusStr = "";

                    if (target) {
                        var status = target.getQuestStatus(qInfo.id);

                        switch (status) {
                            case Complete:
                                statusStr = handler.getCypherString(CypherStrings.CommandQuestComplete);

                                break;
                            case Incomplete:
                                statusStr = handler.getCypherString(CypherStrings.CommandQuestActive);

                                break;
                            case Rewarded:
                                statusStr = handler.getCypherString(CypherStrings.CommandQuestRewarded);

                                break;
                            default:
                                break;
                        }
                    }

                    if (handler.getSession() != null) {
                        var maxLevel = 0;
                        var questLevels = global.getDB2Mgr().GetContentTuningData(qInfo.contentTuningId, handler.getSession().getPlayer().getPlayerData().ctrOptions.getValue().contentTuningConditionMask);

                        if (questLevels != null) {
                            maxLevel = questLevels.getValue().maxLevel;
                        }

                        var scalingFactionGroup = 0;
                        var contentTuning = CliDB.ContentTuningStorage.get(qInfo.contentTuningId);

                        if (contentTuning != null) {
                            scalingFactionGroup = contentTuning.GetScalingFactionGroup();
                        }

                        handler.sendSysMessage(CypherStrings.QuestListChat, qInfo.id, qInfo.id, handler.getSession().getPlayer().getQuestLevel(qInfo), handler.getSession().getPlayer().getQuestMinLevel(qInfo), maxLevel, scalingFactionGroup, _title, statusStr);
                    } else {
                        handler.sendSysMessage(CypherStrings.QuestListConsole, qInfo.id, _title, statusStr);
                    }

                    if (!found) {
                        found = true;
                    }
                }
            }

            if (!found) {
                handler.sendSysMessage(CypherStrings.CommandNoquestfound);
            }

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleLookupQuestIdCommand(CommandHandler handler, int id) {
            // can be NULL at console call
            var target = handler.getSelectedPlayerOrSelf();

            var quest = global.getObjectMgr().getQuestTemplate(id);

            if (quest != null) {
                var title = quest.logTitle;

                if (title.isEmpty()) {
                    handler.sendSysMessage(CypherStrings.CommandNoquestfound);

                    return true;
                }

                var statusStr = "";

                if (target) {
                    switch (target.getQuestStatus(id)) {
                        case Complete:
                            statusStr = handler.getCypherString(CypherStrings.CommandQuestComplete);

                            break;
                        case Incomplete:
                            statusStr = handler.getCypherString(CypherStrings.CommandQuestActive);

                            break;
                        case Rewarded:
                            statusStr = handler.getCypherString(CypherStrings.CommandQuestRewarded);

                            break;
                        default:
                            break;
                    }
                }

                if (handler.getSession()) {
                    var maxLevel = 0;
                    var questLevels = global.getDB2Mgr().GetContentTuningData(quest.contentTuningId, handler.getSession().getPlayer().getPlayerData().ctrOptions.getValue().contentTuningConditionMask);

                    if (questLevels != null) {
                        maxLevel = questLevels.getValue().maxLevel;
                    }

                    var scalingFactionGroup = 0;
                    var contentTuning = CliDB.ContentTuningStorage.get(quest.contentTuningId);

                    if (contentTuning != null) {
                        scalingFactionGroup = contentTuning.GetScalingFactionGroup();
                    }

                    handler.sendSysMessage(CypherStrings.QuestListChat, id, id, handler.getSession().getPlayer().getQuestLevel(quest), handler.getSession().getPlayer().getQuestMinLevel(quest), maxLevel, scalingFactionGroup, title, statusStr);
                } else {
                    handler.sendSysMessage(CypherStrings.QuestListConsole, id, title, statusStr);
                }
            } else {
                handler.sendSysMessage(CypherStrings.CommandNoquestfound);
            }

            return true;
        }
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class LookupSpellCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleLookupSpellCommand(CommandHandler handler, String namePart) {
            // can be NULL at console call
            var target = handler.getSelectedPlayer();

            var found = false;
            int count = 0;

            // Search in spellName.dbc
            for (var spellName : CliDB.SpellNameStorage.values()) {
                var spellInfo = global.getSpellMgr().getSpellInfo(spellName.id, Difficulty.NONE);

                if (spellInfo != null) {
                    var locale = handler.getSessionDbcLocale();
                    var name = spellInfo.SpellName[locale];

                    if (name.isEmpty()) {
                        continue;
                    }

                    if (!name.Like(namePart)) {
                        locale = locale.forValue(0);

                        for (; locale.getValue() < locale.Total.getValue(); ++locale) {
                            if (locale == handler.getSessionDbcLocale()) {
                                continue;
                            }

                            name = spellInfo.SpellName[locale];

                            if (name.isEmpty()) {
                                continue;
                            }

                            if (name.Like(namePart)) {
                                break;
                            }
                        }
                    }

                    if (locale.getValue() < locale.Total.getValue()) {
                        if (maxResults != 0 && count++ == maxResults) {
                            handler.sendSysMessage(CypherStrings.CommandLookupMaxResults, maxResults);

                            return true;
                        }

                        var known = target && target.hasSpell(spellInfo.id);
                        var spellEffectInfo = spellInfo.effects.find(spelleffectInfo -> spelleffectInfo.isEffect(SpellEffectName.LearnSpell));

                        var learnSpellInfo = spellEffectInfo != null ? global.getSpellMgr().getSpellInfo(spellEffectInfo.triggerSpell, spellInfo.Difficulty) : null;

                        var talent = spellInfo.hasAttribute(SpellCustomAttributes.IsTalent);
                        var passive = spellInfo.isPassive;
                        var active = target && target.hasAura(spellInfo.id);

                        // unit32 used to prevent interpreting public byte as char at output
                        // find rank of learned spell for learning spell, or talent rank
                        int rank = learnSpellInfo != null ? learnSpellInfo.Rank : spellInfo.rank;

                        // send spell in "id - [name, rank N] [talent] [passive] [learn] [known]" format
                        StringBuilder ss = new StringBuilder();

                        if (handler.getSession() != null) {
                            ss.append(spellInfo.id + " - |cffffffff|Hspell:" + spellInfo.id + "|h[" + name);
                        } else {
                            ss.append(spellInfo.id + " - " + name);
                        }

                        // include rank in link name
                        if (rank != 0) {
                            ss.append(handler.getCypherString(CypherStrings.SpellRank) + rank);
                        }

                        if (handler.getSession() != null) {
                            ss.append("]|h|r");
                        }

                        if (talent) {
                            ss.append(handler.getCypherString(CypherStrings.Talent));
                        }

                        if (passive) {
                            ss.append(handler.getCypherString(CypherStrings.Passive));
                        }

                        if (learnSpellInfo != null) {
                            ss.append(handler.getCypherString(CypherStrings.Learn));
                        }

                        if (known) {
                            ss.append(handler.getCypherString(CypherStrings.Known));
                        }

                        if (active) {
                            ss.append(handler.getCypherString(CypherStrings.active));
                        }

                        handler.sendSysMessage(ss.toString());

                        if (!found) {
                            found = true;
                        }
                    }
                }
            }

            if (!found) {
                handler.sendSysMessage(CypherStrings.CommandNospellfound);
            }

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleLookupSpellIdCommand(CommandHandler handler, int id) {
            // can be NULL at console call
            var target = handler.getSelectedPlayer();

            var spellInfo = global.getSpellMgr().getSpellInfo(id, Difficulty.NONE);

            if (spellInfo != null) {
                var locale = handler.getSessionDbcLocale();
                var name = spellInfo.getSpellName().get(locale);

                if (tangible.StringHelper.isNullOrEmpty(name)) {
                    handler.sendSysMessage(CypherStrings.CommandNospellfound);

                    return true;
                }

                var known = target && target.hasSpell(id);
                var spellEffectInfo = tangible.ListHelper.find(spellInfo.getEffects(), spelleffectInfo -> spelleffectInfo.isEffect(SpellEffectName.LearnSpell));

                var learnSpellInfo = global.getSpellMgr().getSpellInfo(spellEffectInfo.triggerSpell, Difficulty.NONE);

                var talent = spellInfo.hasAttribute(SpellCustomAttributes.IsTalent);
                var passive = spellInfo.isPassive();
                var active = target && target.hasAura(id);

                // unit32 used to prevent interpreting public byte as char at output
                // find rank of learned spell for learning spell, or talent rank
                int rank = learnSpellInfo != null ? learnSpellInfo.getRank() : spellInfo.getRank();

                // send spell in "id - [name, rank N] [talent] [passive] [learn] [known]" format
                StringBuilder ss = new StringBuilder();

                if (handler.getSession() != null) {
                    ss.append(id + " - |cffffffff|Hspell:" + id + "|h[" + name);
                } else {
                    ss.append(id + " - " + name);
                }

                // include rank in link name
                if (rank != 0) {
                    ss.append(handler.getCypherString(CypherStrings.SpellRank) + rank);
                }

                if (handler.getSession() != null) {
                    ss.append("]|h|r");
                }

                if (talent) {
                    ss.append(handler.getCypherString(CypherStrings.Talent));
                }

                if (passive) {
                    ss.append(handler.getCypherString(CypherStrings.Passive));
                }

                if (learnSpellInfo != null) {
                    ss.append(handler.getCypherString(CypherStrings.Learn));
                }

                if (known) {
                    ss.append(handler.getCypherString(CypherStrings.Known));
                }

                if (active) {
                    ss.append(handler.getCypherString(CypherStrings.active));
                }

                handler.sendSysMessage(ss.toString());
            } else {
                handler.sendSysMessage(CypherStrings.CommandNospellfound);
            }

            return true;
        }
    }
}
