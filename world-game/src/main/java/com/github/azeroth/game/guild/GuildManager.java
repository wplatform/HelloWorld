package com.github.azeroth.game.guild;


import com.github.azeroth.game.GuildReward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public final class GuildManager {
    private final HashMap<Long, guild> guildStore = new HashMap<Long, guild>();
    private final ArrayList<GuildReward> guildRewards = new ArrayList<>();

    private int nextGuildId;

    private GuildManager() {
    }

    public void addGuild(Guild guild) {
        guildStore.put(guild.getId(), guild);
    }

    public void removeGuild(long guildId) {
        guildStore.remove(guildId);
    }

    public void saveGuilds() {
        for (var guild : guildStore.values()) {
            guild.saveToDB();
        }
    }

    public int generateGuildId() {
        if (nextGuildId >= 0xFFFFFFFE) {
            Log.outError(LogFilter.guild, "Guild ids overflow!! Can't continue, shutting down server. ");
            global.getWorldMgr().stopNow();
        }

        return nextGuildId++;
    }

    public Guild getGuildById(long guildId) {
        return guildStore.get(guildId);
    }

    public Guild getGuildByGuid(ObjectGuid guid) {
        // Full guids are only used when receiving/sending data to client
        // everywhere else guild id is used
        if (guid.isGuild()) {
            var guildId = guid.getCounter();

            if (guildId != 0) {
                return getGuildById(guildId);
            }
        }

        return null;
    }

    public Guild getGuildByName(String guildName) {
        for (var guild : guildStore.values()) {
            if (Objects.equals(guildName, guild.getName())) {
                return guild;
            }
        }

        return null;
    }

    public String getGuildNameById(int guildId) {
        var guild = getGuildById(guildId);

        if (guild != null) {
            return guild.getName();
        }

        return "";
    }

    public Guild getGuildByLeader(ObjectGuid guid) {
        for (var guild : guildStore.values()) {
            if (Objects.equals(guild.getLeaderGUID(), guid)) {
                return guild;
            }
        }

        return null;
    }

    public void loadGuilds() {
        Log.outInfo(LogFilter.ServerLoading, "Loading Guilds Definitions...");

        {
            var oldMSTime = System.currentTimeMillis();

            //          0          1       2             3              4              5              6
            var result = DB.characters.query("SELECT g.guildid, g.name, g.leaderguid, g.emblemStyle, g.emblemColor, g.borderStyle, g.borderColor, " + "g.backgroundColor, g.info, g.motd, g.createdate, g.BankMoney, COUNT(gbt.guildid) " + "FROM guild g LEFT JOIN guild_bank_tab gbt ON g.guildid = gbt.guildid GROUP BY g.guildid ORDER BY g.guildid ASC");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.guild, "Loaded 0 guild definitions. DB table `guild` is empty.");

                return;
            }

            int count = 0;

            do {
                Guild guild = new guild();

                if (!guild.loadFromDB(result.GetFields())) {
                    continue;
                }

                addGuild(guild);
                count++;
            } while (result.NextRow());

            Log.outInfo(LogFilter.ServerLoading, "Loaded {0} guild definitions in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading guild ranks...");

        {
            var oldMSTime = System.currentTimeMillis();

            // Delete orphaned guild rank entries before loading the valid ones
            DB.characters.DirectExecute("DELETE gr FROM guild_rank gr LEFT JOIN guild g ON gr.guildId = g.guildId WHERE g.guildId IS NULL");

            //                                                   0    1      2       3      4       5
            var result = DB.characters.query("SELECT guildid, rid, rankOrder, rname, rights, BankMoneyPerDay FROM guild_rank ORDER BY guildid ASC, rid ASC");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 guild ranks. DB table `guild_rank` is empty.");
            } else {
                int count = 0;

                do {
                    var guildId = result.<Integer>Read(0);
                    var guild = getGuildById(guildId);

                    if (guild) {
                        guild.loadRankFromDB(result.GetFields());
                    }

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} guild ranks in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        // 3. Load all guild members
        Log.outInfo(LogFilter.ServerLoading, "Loading guild members...");

        {
            var oldMSTime = System.currentTimeMillis();

            // Delete orphaned guild member entries before loading the valid ones
            DB.characters.DirectExecute("DELETE gm FROM guild_member gm LEFT JOIN guild g ON gm.guildId = g.guildId WHERE g.guildId IS NULL");
            DB.characters.DirectExecute("DELETE gm FROM guild_member_withdraw gm LEFT JOIN guild_member g ON gm.guid = g.guid WHERE g.guid IS NULL");

            //           0           1        2     3      4        5       6       7       8       9       10
            var result = DB.characters.query("SELECT gm.guildid, gm.guid, `rank`, pnote, offnote, w.tab0, w.tab1, w.tab2, w.tab3, w.tab4, w.tab5, " + "w.tab6, w.tab7, w.money, c.name, c.level, c.race, c.class, c.gender, c.zone, c.account, c.logout_time " + "FROM guild_member gm LEFT JOIN guild_member_withdraw w ON gm.guid = w.guid " + "LEFT JOIN character c ON c.guid = gm.guid ORDER BY gm.guildid ASC");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 guild members. DB table `guild_member` is empty.");
            } else {
                int count = 0;

                do {
                    var guildId = result.<Integer>Read(0);
                    var guild = getGuildById(guildId);

                    if (guild) {
                        guild.loadMemberFromDB(result.GetFields());
                    }

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} guild members in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        // 4. Load all guild bank tab rights
        Log.outInfo(LogFilter.ServerLoading, "Loading bank tab rights...");

        {
            var oldMSTime = System.currentTimeMillis();

            // Delete orphaned guild bank right entries before loading the valid ones
            DB.characters.DirectExecute("DELETE gbr FROM guild_bank_right gbr LEFT JOIN guild g ON gbr.guildId = g.guildId WHERE g.guildId IS NULL");

            //      0        1      2    3        4
            var result = DB.characters.query("SELECT guildid, TabId, rid, gbright, SlotPerDay FROM guild_bank_right ORDER BY guildid ASC, TabId ASC");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 guild bank tab rights. DB table `guild_bank_right` is empty.");
            } else {
                int count = 0;

                do {
                    var guildId = result.<Integer>Read(0);
                    var guild = getGuildById(guildId);

                    if (guild) {
                        guild.loadBankRightFromDB(result.GetFields());
                    }

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} bank tab rights in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        // 5. Load all event logs
        Log.outInfo(LogFilter.ServerLoading, "Loading guild event logs...");

        {
            var oldMSTime = System.currentTimeMillis();

            DB.characters.DirectExecute("DELETE FROM guild_eventlog WHERE LogGuid > {0}", GuildConst.EventLogMaxRecords);

            //          0        1        2          3            4            5        6
            var result = DB.characters.query("SELECT guildid, LogGuid, eventType, PlayerGuid1, PlayerGuid2, NewRank, TimeStamp FROM guild_eventlog ORDER BY TimeStamp DESC, LogGuid DESC");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 guild event logs. DB table `guild_eventlog` is empty.");
            } else {
                int count = 0;

                do {
                    var guildId = result.<Integer>Read(0);
                    var guild = getGuildById(guildId);

                    if (guild) {
                        guild.loadEventLogFromDB(result.GetFields());
                    }

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} guild event logs in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        // 6. Load all bank event logs
        Log.outInfo(LogFilter.ServerLoading, "Loading guild bank event logs...");

        {
            var oldMSTime = System.currentTimeMillis();

            // Remove log entries that exceed the number of allowed entries per guild
            DB.characters.DirectExecute("DELETE FROM guild_bank_eventlog WHERE LogGuid > {0}", GuildConst.BankLogMaxRecords);

            //          0        1      2        3          4           5            6               7          8
            var result = DB.characters.query("SELECT guildid, TabId, LogGuid, eventType, playerGuid, ItemOrMoney, ItemStackCount, DestTabId, TimeStamp FROM guild_bank_eventlog ORDER BY TimeStamp DESC, LogGuid DESC");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 guild bank event logs. DB table `guild_bank_eventlog` is empty.");
            } else {
                int count = 0;

                do {
                    var guildId = result.<Integer>Read(0);
                    var guild = getGuildById(guildId);

                    if (guild) {
                        guild.loadBankEventLogFromDB(result.GetFields());
                    }

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} guild bank event logs in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        // 7. Load all news event logs
        Log.outInfo(LogFilter.ServerLoading, "Loading Guild News...");

        {
            var oldMSTime = System.currentTimeMillis();

            DB.characters.DirectExecute("DELETE FROM guild_newslog WHERE LogGuid > {0}", GuildConst.NewsLogMaxRecords);

            //      0        1        2          3           4      5      6
            var result = DB.characters.query("SELECT guildid, LogGuid, eventType, playerGuid, flags, value, Timestamp FROM guild_newslog ORDER BY TimeStamp DESC, LogGuid DESC");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 guild event logs. DB table `guild_newslog` is empty.");
            } else {
                int count = 0;

                do {
                    var guildId = result.<Integer>Read(0);
                    var guild = getGuildById(guildId);

                    if (guild) {
                        guild.loadGuildNewsLogFromDB(result.GetFields());
                    }

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} guild new logs in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        // 8. Load all guild bank tabs
        Log.outInfo(LogFilter.ServerLoading, "Loading guild bank tabs...");

        {
            var oldMSTime = System.currentTimeMillis();

            // Delete orphaned guild bank tab entries before loading the valid ones
            DB.characters.DirectExecute("DELETE gbt FROM guild_bank_tab gbt LEFT JOIN guild g ON gbt.guildId = g.guildId WHERE g.guildId IS NULL");

            //                                              0        1      2        3        4
            var result = DB.characters.query("SELECT guildid, TabId, TabName, TabIcon, TabText FROM guild_bank_tab ORDER BY guildid ASC, TabId ASC");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 guild bank tabs. DB table `guild_bank_tab` is empty.");
            } else {
                int count = 0;

                do {
                    var guildId = result.<Integer>Read(0);
                    var guild = getGuildById(guildId);

                    if (guild) {
                        guild.loadBankTabFromDB(result.GetFields());
                    }

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} guild bank tabs in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        // 9. Fill all guild bank tabs
        Log.outInfo(LogFilter.ServerLoading, "Filling bank tabs with items...");

        {
            var oldMSTime = System.currentTimeMillis();

            // Delete orphan guild bank items
            DB.characters.DirectExecute("DELETE gbi FROM guild_bank_item gbi LEFT JOIN guild g ON gbi.guildId = g.guildId WHERE g.guildId IS NULL");

            var result = DB.characters.query(DB.characters.GetPreparedStatement(CharStatements.SEL_GUILD_BANK_ITEMS));

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 guild bank tab items. DB table `guild_bank_item` or `item_instance` is empty.");
            } else {
                int count = 0;

                do {
                    var guildId = result.<Long>Read(51);
                    var guild = getGuildById(guildId);

                    if (guild) {
                        guild.loadBankItemFromDB(result.GetFields());
                    }

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} guild bank tab items in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        // 10. Load guild achievements
        Log.outInfo(LogFilter.ServerLoading, "Loading guild achievements...");

        {
            var oldMSTime = System.currentTimeMillis();

            for (var pair : guildStore.entrySet()) {
                var stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_GUILD_ACHIEVEMENT);
                stmt.AddValue(0, pair.getKey());
                var achievementResult = DB.characters.query(stmt);

                stmt = DB.characters.GetPreparedStatement(CharStatements.SEL_GUILD_ACHIEVEMENT_CRITERIA);
                stmt.AddValue(0, pair.getKey());
                var criteriaResult = DB.characters.query(stmt);

                pair.getValue().getAchievementMgr().loadFromDB(achievementResult, criteriaResult);
            }

            Log.outInfo(LogFilter.ServerLoading, "Loaded guild achievements and criterias in {0} ms", time.GetMSTimeDiffToNow(oldMSTime));
        }

        // 11. Validate loaded guild data
        Log.outInfo(LogFilter.Server, "Validating data of loaded guilds...");

        {
            var oldMSTime = System.currentTimeMillis();

            for (var guild : guildStore.ToList()) {
                if (!guild.value.validate()) {
                    guildStore.remove(guild.key);
                }
            }

            Log.outInfo(LogFilter.ServerLoading, "Validated data of loaded guilds in {0} ms", time.GetMSTimeDiffToNow(oldMSTime));
        }
    }

    public void loadGuildRewards() {
        var oldMSTime = System.currentTimeMillis();

        //                                            0      1            2         3
        var result = DB.World.query("SELECT itemID, minGuildRep, raceMask, Cost FROM guild_rewards");

        if (result.isEmpty()) {
            Log.outInfo(LogFilter.ServerLoading, "Loaded 0 guild reward definitions. DB table `guild_rewards` is empty.");

            return;
        }

        int count = 0;

        do {
            GuildReward reward = new GuildReward();

            reward.itemID = result.<Integer>Read(0);
            reward.minGuildRep = result.<Byte>Read(1);
            reward.raceMask = result.<Long>Read(2);
            reward.cost = result.<Long>Read(3);

            if (global.getObjectMgr().getItemTemplate(reward.itemID) == null) {
                Log.outError(LogFilter.ServerLoading, "Guild rewards constains not existing item entry {0}", reward.itemID);

                continue;
            }

            if (reward.minGuildRep >= ReputationRank.max.getValue()) {
                Log.outError(LogFilter.ServerLoading, "Guild rewards contains wrong reputation standing {0}, max is {1}", reward.minGuildRep, ReputationRank.max.getValue() - 1);

                continue;
            }

            var stmt = DB.World.GetPreparedStatement(WorldStatements.SEL_GUILD_REWARDS_REQ_ACHIEVEMENTS);
            stmt.AddValue(0, reward.itemID);
            var reqAchievementResult = DB.World.query(stmt);

            if (!reqAchievementResult.isEmpty()) {
                do {
                    var requiredAchievementId = reqAchievementResult.<Integer>Read(0);

                    if (!CliDB.AchievementStorage.containsKey(requiredAchievementId)) {
                        Log.outError(LogFilter.ServerLoading, "Guild rewards constains not existing achievement entry {0}", requiredAchievementId);

                        continue;
                    }

                    reward.achievementsRequired.add(requiredAchievementId);
                } while (reqAchievementResult.NextRow());
            }

            guildRewards.add(reward);
            ++count;
        } while (result.NextRow());

        Log.outInfo(LogFilter.ServerLoading, "Loaded {0} guild reward definitions in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
    }

    public void resetTimes(boolean week) {
        DB.characters.execute(DB.characters.GetPreparedStatement(CharStatements.DEL_GUILD_MEMBER_WITHDRAW));

        for (var guild : guildStore.values()) {
            guild.resetTimes(week);
        }
    }

    public void setNextGuildId(int id) {
        nextGuildId = id;
    }

    public ArrayList<GuildReward> getGuildRewards() {
        return guildRewards;
    }
}
