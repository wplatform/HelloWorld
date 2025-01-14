package game;


import com.github.azeroth.game.GameEventData;
import com.github.azeroth.game.GameEventQuestToEventConditionNum;
import com.github.azeroth.game.GameEventState;
import com.github.azeroth.game.ModelEquip;
import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.player.Player;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameEventManager {
    private final HashMap<Integer, GameEventQuestToEventConditionNum> mQuestToEventConditions = new HashMap<Integer, GameEventQuestToEventConditionNum>();
    private final ArrayList<Short> m_ActiveEvents = new ArrayList<>();
    public ArrayList<Long>[] mGameEventCreatureGuids;
    public ArrayList<Long>[] mGameEventGameobjectGuids;
long guid
long npcflag
    private ArrayList<Tuple<Integer, Integer>>[] mGameEventCreatureQuests;
    private ArrayList<Tuple<Integer, Integer>>[] mGameEventGameObjectQuests;
    private HashMap<Integer, VendorItem>[] mGameEventVendors;
    private ArrayList<Tuple<Long, ModelEquip>>[] mGameEventModelEquip;
    private ArrayList<Integer>[] mGameEventPoolIds;
	private ArrayList<(
        private GameEventData[] mGameEvent;,     private int[] mGameEventBattlegroundHolidays;)>[]mGameEventNPCFlags;
    private boolean isSystemInit;

    private GameEventManager() {
    }

    public final int nextCheck(short entry) {
        var currenttime = gameTime.GetGameTime();

        // for NEXTPHASE state world events, return the delay to start the next event, so the followup event will be checked correctly
        if ((mGameEvent[entry].state == GameEventState.WorldNextPhase || mGameEvent[entry].state == GameEventState.WorldFinished) && mGameEvent[entry].nextstart >= currenttime) {
            return (int) (mGameEvent[entry].nextstart - currenttime);
        }

        // for CONDITIONS state world events, return the length of the wait period, so if the conditions are met, this check will be called again to set the timer as NEXTPHASE event
        if (mGameEvent[entry].state == GameEventState.WorldConditions) {
            if (mGameEvent[entry].length != 0) {
                return mGameEvent[entry].length * 60;
            } else {
                return time.Day;
            }
        }

        // outdated event: we return max
        if (currenttime > mGameEvent[entry].end) {
            return time.Day;
        }

        // never started event, we return delay before start
        if (mGameEvent[entry].start > currenttime) {
            return (int) (mGameEvent[entry].start - currenttime);
        }

        int delay;

        // in event, we return the end of it
        if ((((currenttime - mGameEvent[entry].start) % (mGameEvent[entry].occurence * 60)) < (mGameEvent[entry].length * 60))) {
            // we return the delay before it ends
            delay = (int) ((mGameEvent[entry].length * time.Minute) - ((currenttime - mGameEvent[entry].start) % (mGameEvent[entry].occurence * time.Minute)));
        } else // not in window, we return the delay before next start
        {
            delay = (int) ((mGameEvent[entry].occurence * time.Minute) - ((currenttime - mGameEvent[entry].start) % (mGameEvent[entry].occurence * time.Minute)));
        }

        // In case the end is before next check
        if (mGameEvent[entry].end < currenttime + delay) {
            return (int) (mGameEvent[entry].end - currenttime);
        } else {
            return delay;
        }
    }


    public final boolean startEvent(short event_id) {
        return startEvent(event_id, false);
    }

    public final boolean startEvent(short event_id, boolean overwrite) {
        var data = mGameEvent[event_id];

        if (data.state == GameEventState.NORMAL || data.state == GameEventState.internal) {
            addActiveEvent(event_id);
            applyNewEvent(event_id);

            if (overwrite) {
                mGameEvent[event_id].start = gameTime.GetGameTime();

                if (data.end <= data.start) {
                    data.end = data.start + data.length;
                }
            }

            return false;
        } else {
            if (data.state == GameEventState.WorldInactive) {
                // set to conditions phase
                data.state = GameEventState.WorldConditions;
            }

            // add to active events
            addActiveEvent(event_id);
            // add spawns
            applyNewEvent(event_id);

            // check if can go to next state
            var conditions_met = checkOneGameEventConditions(event_id);
            // save to db
            saveWorldEventStateToDB(event_id);

            // force game event update to set the update timer if conditions were met from a command
            // this update is needed to possibly start events dependent on the started one
            // or to scedule another update where the next event will be started
            if (overwrite && conditions_met) {
                global.getWorldMgr().forceGameEventUpdate();
            }

            return conditions_met;
        }
    }


    public final void stopEvent(short event_id) {
        stopEvent(event_id, false);
    }

    public final void stopEvent(short event_id, boolean overwrite) {
        var data = mGameEvent[event_id];
        var serverwide_evt = data.state != GameEventState.NORMAL && data.state != GameEventState.internal;

        removeActiveEvent(event_id);
        unApplyEvent(event_id);

        if (overwrite && !serverwide_evt) {
            data.start = gameTime.GetGameTime() - data.length * time.Minute;

            if (data.end <= data.start) {
                data.end = data.start + data.length;
            }
        } else if (serverwide_evt) {
            // if finished world event, then only gm command can stop it
            if (overwrite || data.state != GameEventState.WorldFinished) {
                // reset conditions
                data.nextstart = 0;
                data.state = GameEventState.WorldInactive;

                for (var pair : data.conditions.entrySet()) {
                    pair.getValue().done = 0;
                }

                SQLTransaction trans = new SQLTransaction();
                var stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_ALL_GAME_EVENT_CONDITION_SAVE);
                stmt.AddValue(0, event_id);
                trans.append(stmt);

                stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_GAME_EVENT_SAVE);
                stmt.AddValue(0, event_id);
                trans.append(stmt);

                DB.characters.CommitTransaction(trans);
            }
        }
    }

    public final void loadFromDB() {
        {
            var oldMSTime = System.currentTimeMillis();
            //                                         0           1                           2                         3          4       5        6            7            8             9
            var result = DB.World.query("SELECT eventEntry, UNIX_TIMESTAMP(start_time), UNIX_TIMESTAMP(end_time), occurence);

            if (result.isEmpty()) {
                mGameEvent.clear();
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 game events. DB table `game_event` is empty.");

                return;
            }

            int count = 0;

            do {
                var event_id = result.<Byte>Read(0);

                if (event_id == 0) {
                    Logs.SQL.error("`game_event` game event entry 0 is reserved and can't be used.");

                    continue;
                }

                GameEventData pGameEvent = new GameEventData();
                var starttime = result.<Long>Read(1);
                pGameEvent.start = (long) starttime;
                var endtime = result.<Long>Read(2);
                pGameEvent.end = (long) endtime;
                pGameEvent.occurence = result.<Integer>Read(3);
                pGameEvent.length = result.<Integer>Read(4);
                pGameEvent.holiday_id = HolidayIds.forValue(result.<Integer>Read(5));

                pGameEvent.holidayStage = result.<Byte>Read(6);
                pGameEvent.description = result.<String>Read(7);
                pGameEvent.state = GameEventState.forValue(result.<Byte>Read(8));
                pGameEvent.announce = result.<Byte>Read(9);
                pGameEvent.nextstart = 0;

                ++count;

                if (pGameEvent.length == 0 && pGameEvent.state == GameEventState.NORMAL) // length>0 is validity check
                {
                    Logs.SQL.error(String.format("`game_event` game event id (%1$s) isn't a world event and has length = 0, thus it can't be used.", event_id));

                    continue;
                }

                if (pGameEvent.holiday_id != HolidayIds.NONE) {
                    if (!CliDB.HolidaysStorage.containsKey((int) pGameEvent.holiday_id.getValue())) {
                        Logs.SQL.error(String.format("`game_event` game event id (%1$s) contains nonexisting holiday id %2$s.", event_id, pGameEvent.holiday_id));
                        pGameEvent.holiday_id = HolidayIds.NONE;

                        continue;
                    }

                    if (pGameEvent.holidayStage > SharedConst.MaxHolidayDurations) {
                        Logs.SQL.error("`game_event` game event id ({event_id}) has out of range holidayStage {pGameEvent.holidayStage}.");
                        pGameEvent.holidayStage = 0;

                        continue;
                    }

                    setHolidayEventTime(pGameEvent);
                }

                mGameEvent[event_id] = pGameEvent;
            } while (result.NextRow());

            Log.outInfo(LogFilter.ServerLoading, "Loaded {0} game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event Saves data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                                       0       1        2
            var result = DB.characters.query("SELECT eventEntry, state, next_start FROM game_event_save");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 game event saves in game events. DB table `game_event_save` is empty.");
            } else {
                int count = 0;

                do {
                    var event_id = result.<Byte>Read(0);

                    if (event_id >= mGameEvent.length) {
                        Logs.SQL.error("`game_event_save` game event entry ({0}) not exist in `game_event`", event_id);

                        continue;
                    }

                    if (mGameEvent[event_id].state != GameEventState.NORMAL && mGameEvent[event_id].state != GameEventState.internal) {
                        mGameEvent[event_id].state = GameEventState.forValue(result.<Byte>Read(1));
                        mGameEvent[event_id].nextstart = result.<Integer>Read(2);
                    } else {
                        Logs.SQL.error("game_event_save includes event save for non-worldevent id {0}", event_id);

                        continue;
                    }

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} game event saves in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event Prerequisite data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                                   0             1
            var result = DB.World.query("SELECT eventEntry, prerequisite_event FROM game_event_prerequisite");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 game event prerequisites in game events. DB table `game_event_prerequisite` is empty.");
            } else {
                int count = 0;

                do {
                    short event_id = result.<Byte>Read(0);

                    if (event_id >= mGameEvent.length) {
                        Logs.SQL.error("`game_event_prerequisite` game event id ({0}) is out of range compared to max event id in `game_event`", event_id);

                        continue;
                    }

                    if (mGameEvent[event_id].state != GameEventState.NORMAL && mGameEvent[event_id].state != GameEventState.internal) {
                        short prerequisite_event = result.<Byte>Read(1);

                        if (prerequisite_event >= mGameEvent.length) {
                            Logs.SQL.error("`game_event_prerequisite` game event prerequisite id ({0}) not exist in `game_event`", prerequisite_event);

                            continue;
                        }

                        mGameEvent[event_id].prerequisite_events.add(prerequisite_event);
                    } else {
                        Logs.SQL.error("game_event_prerequisiste includes event entry for non-worldevent id {0}", event_id);

                        continue;
                    }

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} game event prerequisites in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event Creature data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                                 0        1
            var result = DB.World.query("SELECT guid, eventEntry FROM game_event_creature");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creatures in game events. DB table `game_event_creature` is empty");
            } else {
                int count = 0;

                do {
                    var guid = result.<Long>Read(0);
                    short event_id = result.<Byte>Read(1);
                    var internal_event_id = mGameEvent.length + event_id - 1;

                    var data = global.getObjectMgr().getCreatureData(guid);

                    if (data == null) {
                        if (ConfigMgr.GetDefaultValue("load.autoclean", false)) {
                            DB.World.execute(String.format("DELETE FROM game_event_creature WHERE guid = %1$s", guid));
                        } else {
                            Logs.SQL.error("`game_event_creature` contains creature (GUID: {0}) not found in `creature` table.", guid);
                        }

                        continue;
                    }

                    if (internal_event_id < 0 || internal_event_id >= mGameEventCreatureGuids.length) {
                        Logs.SQL.error("`game_event_creature` game event id ({0}) not exist in `game_event`", event_id);

                        continue;
                    }

                    // Log error for pooled object, but still spawn it
                    if (data.poolId != 0) {
                        Logs.SQL.error(String.format("`game_event_creature`: game event id (%1$s) contains creature (%2$s) which is part of a pool (%3$s). This should be spawned in game_event_pool", event_id, guid, data.poolId));
                    }

                    mGameEventCreatureGuids[internal_event_id].add(guid);

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} creatures in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event GO data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                                0         1
            var result = DB.World.query("SELECT guid, eventEntry FROM game_event_gameobject");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 gameobjects in game events. DB table `game_event_gameobject` is empty.");
            } else {
                int count = 0;

                do {
                    var guid = result.<Long>Read(0);
                    short event_id = result.<Byte>Read(1);
                    var internal_event_id = mGameEvent.length + event_id - 1;

                    var data = global.getObjectMgr().getGameObjectData(guid);

                    if (data == null) {
                        Logs.SQL.error("`game_event_gameobject` contains gameobject (GUID: {0}) not found in `gameobject` table.", guid);

                        continue;
                    }

                    if (internal_event_id < 0 || internal_event_id >= mGameEventGameobjectGuids.length) {
                        Logs.SQL.error("`game_event_gameobject` game event id ({0}) not exist in `game_event`", event_id);

                        continue;
                    }

                    // Log error for pooled object, but still spawn it
                    if (data.poolId != 0) {
                        Logs.SQL.error(String.format("`game_event_gameobject`: game event id (%1$s) contains game object (%2$s) which is part of a pool (%3$s). This should be spawned in game_event_pool", event_id, guid, data.poolId));
                    }

                    mGameEventGameobjectGuids[internal_event_id].add(guid);

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} gameobjects in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event Model/Equipment Change data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                                       0           1                       2                                 3                                     4
            var result = DB.World.query("SELECT creature.guid, creature.id, game_event_model_equip.eventEntry, game_event_model_equip.modelid, game_event_model_equip.equipment_id " + "FROM creature JOIN game_event_model_equip ON creature.guid=game_event_model_equip.guid");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 model/equipment changes in game events. DB table `game_event_model_equip` is empty.");
            } else {
                int count = 0;

                do {
                    var guid = result.<Long>Read(0);
                    var entry = result.<Integer>Read(1);
                    short event_id = result.<Byte>Read(2);

                    if (event_id >= mGameEventModelEquip.length) {
                        Logs.SQL.error("`game_event_model_equip` game event id ({0}) is out of range compared to max event id in `game_event`", event_id);

                        continue;
                    }

                    ModelEquip newModelEquipSet = new ModelEquip();
                    newModelEquipSet.modelid = result.<Integer>Read(3);
                    newModelEquipSet.equipment_id = result.<Byte>Read(4);
                    newModelEquipSet.equipement_id_prev = 0;
                    newModelEquipSet.modelid_prev = 0;

                    if (newModelEquipSet.equipment_id > 0) {
                        var equipId = (byte) newModelEquipSet.equipment_id;

                        if (global.getObjectMgr().getEquipmentInfo(entry, equipId) == null) {
                            Logs.SQL.error("Table `game_event_model_equip` have creature (Guid: {0}, entry: {1}) with equipment_id {2} not found in table `creature_equip_template`, set to no equipment.", guid, entry, newModelEquipSet.equipment_id);

                            continue;
                        }
                    }

                    mGameEventModelEquip[event_id].add(Tuple.create(guid, newModelEquipSet));

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} model/equipment changes in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event Quest data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                               0     1      2
            var result = DB.World.query("SELECT id, quest, eventEntry FROM game_event_creature_quest");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quests additions in game events. DB table `game_event_creature_quest` is empty.");
            } else {
                int count = 0;

                do {
                    var id = result.<Integer>Read(0);
                    var quest = result.<Integer>Read(1);
                    short event_id = result.<Byte>Read(2);

                    if (event_id >= mGameEventCreatureQuests.length) {
                        Logs.SQL.error("`game_event_creature_quest` game event id ({0}) not exist in `game_event`", event_id);

                        continue;
                    }

                    mGameEventCreatureQuests[event_id].add(Tuple.create(id, quest));

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} quests additions in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event GO Quest data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                               0     1      2
            var result = DB.World.query("SELECT id, quest, eventEntry FROM game_event_gameobject_quest");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 go quests additions in game events. DB table `game_event_gameobject_quest` is empty.");
            } else {
                int count = 0;

                do {
                    var id = result.<Integer>Read(0);
                    var quest = result.<Integer>Read(1);
                    short event_id = result.<Byte>Read(2);

                    if (event_id >= mGameEventGameObjectQuests.length) {
                        Logs.SQL.error("`game_event_gameobject_quest` game event id ({0}) not exist in `game_event`", event_id);

                        continue;
                    }

                    mGameEventGameObjectQuests[event_id].add(Tuple.create(id, quest));

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} quests additions in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event Quest Condition data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                                 0       1         2             3
            var result = DB.World.query("SELECT quest, eventEntry, condition_id, num FROM game_event_quest_condition");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 quest event conditions in game events. DB table `game_event_quest_condition` is empty.");
            } else {
                int count = 0;

                do {
                    var quest = result.<Integer>Read(0);
                    short event_id = result.<Byte>Read(1);
                    var condition = result.<Integer>Read(2);
                    var num = result.<Float>Read(3);

                    if (event_id >= mGameEvent.length) {
                        Logs.SQL.error("`game_event_quest_condition` game event id ({0}) is out of range compared to max event id in `game_event`", event_id);

                        continue;
                    }

                    if (!mQuestToEventConditions.containsKey(quest)) {
                        mQuestToEventConditions.put(quest, new GameEventQuestToEventConditionNum());
                    }

                    mQuestToEventConditions.get(quest).event_id = event_id;
                    mQuestToEventConditions.get(quest).condition = condition;
                    mQuestToEventConditions.get(quest).num = num;

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} quest event conditions in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event Condition data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                                  0          1            2             3                      4
            var result = DB.World.query("SELECT eventEntry, condition_id, req_num, max_world_state_field, done_world_state_field FROM game_event_condition");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 conditions in game events. DB table `game_event_condition` is empty.");
            } else {
                int count = 0;

                do {
                    short event_id = result.<Byte>Read(0);
                    var condition = result.<Integer>Read(1);

                    if (event_id >= mGameEvent.length) {
                        Logs.SQL.error("`game_event_condition` game event id ({0}) is out of range compared to max event id in `game_event`", event_id);

                        continue;
                    }

                    mGameEvent[event_id].conditions.get(condition).reqNum = result.<Float>Read(2);
                    mGameEvent[event_id].conditions.get(condition).done = 0;
                    mGameEvent[event_id].conditions.get(condition).max_world_state = result.<SHORT>Read(3);
                    mGameEvent[event_id].conditions.get(condition).done_world_state = result.<SHORT>Read(4);

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} conditions in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event Condition Save data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                                      0           1         2
            var result = DB.characters.query("SELECT eventEntry, condition_id, done FROM game_event_condition_save");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 condition saves in game events. DB table `game_event_condition_save` is empty.");
            } else {
                int count = 0;

                do {
                    short event_id = result.<Byte>Read(0);
                    var condition = result.<Integer>Read(1);

                    if (event_id >= mGameEvent.length) {
                        Logs.SQL.error("`game_event_condition_save` game event id ({0}) is out of range compared to max event id in `game_event`", event_id);

                        continue;
                    }

                    if (mGameEvent[event_id].conditions.containsKey(condition)) {
                        mGameEvent[event_id].conditions.get(condition).done = result.<Integer>Read(2);
                    } else {
                        Logs.SQL.error("game_event_condition_save contains not present condition evt id {0} cond id {1}", event_id, condition);

                        continue;
                    }

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} condition saves in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event NPCflag data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                                0       1        2
            var result = DB.World.query("SELECT guid, eventEntry, npcflag FROM game_event_npcflag");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 npcflags in game events. DB table `game_event_npcflag` is empty.");
            } else {
                int count = 0;

                do {
                    var guid = result.<Long>Read(0);
                    short event_id = result.<Byte>Read(1);
                    var npcflag = result.<Long>Read(2);

                    if (event_id >= mGameEvent.length) {
                        Logs.SQL.error("`game_event_npcflag` game event id ({0}) is out of range compared to max event id in `game_event`", event_id);

                        continue;
                    }

                    mGameEventNPCFlags[event_id].add((guid, npcflag));

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} npcflags in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event Seasonal Quest Relations...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                                  0          1
            var result = DB.World.query("SELECT questId, eventEntry FROM game_event_seasonal_questrelation");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 seasonal quests additions in game events. DB table `game_event_seasonal_questrelation` is empty.");
            } else {
                int count = 0;

                do {
                    var questId = result.<Integer>Read(0);
                    short eventEntry = result.<Byte>Read(1); // @todo Change to byte

                    var questTemplate = global.getObjectMgr().getQuestTemplate(questId);

                    if (questTemplate == null) {
                        Logs.SQL.error("`game_event_seasonal_questrelation` quest id ({0}) does not exist in `quest_template`", questId);

                        continue;
                    }

                    if (eventEntry >= mGameEvent.length) {
                        Logs.SQL.error("`game_event_seasonal_questrelation` event id ({0}) not exist in `game_event`", eventEntry);

                        continue;
                    }

                    questTemplate.setEventIdForQuest(eventEntry);
                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} quests additions in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event Vendor Additions data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                               0           1     2     3         4         5             6     7             8                  9
            var result = DB.World.query("SELECT eventEntry, guid, item, maxcount, incrtime, extendedCost, type, bonusListIDs, playerConditionId, IgnoreFiltering FROM game_event_npc_vendor ORDER BY guid, slot ASC");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 vendor additions in game events. DB table `game_event_npc_vendor` is empty.");
            } else {
                int count = 0;

                do {
                    var event_id = result.<Byte>Read(0);
                    var guid = result.<Long>Read(1);

                    if (event_id >= mGameEventVendors.length) {
                        Logs.SQL.error("`game_event_npc_vendor` game event id ({0}) not exist in `game_event`", event_id);

                        continue;
                    }

                    // get the event npc flag for checking if the npc will be vendor during the event or not
                    long event_npc_flag = 0;
                    var flist = mGameEventNPCFlags[event_id];

                    for (var pair : flist) {
                        if (pair.guid == guid) {
                            event_npc_flag = pair.npcflag;

                            break;
                        }
                    }

                    // get creature entry
                    int entry = 0;
                    var data = global.getObjectMgr().getCreatureData(guid);

                    if (data != null) {
                        entry = data.id;
                    }

                    VendorItem vItem = new VendorItem();
                    vItem.setItem(result.<Integer>Read(2));
                    vItem.setMaxcount(result.<Integer>Read(3));
                    vItem.setIncrtime(result.<Integer>Read(4));
                    vItem.setExtendedCost(result.<Integer>Read(5));
                    vItem.setType(ItemVendorType.forValue(result.<Byte>Read(6)));
                    vItem.setPlayerConditionId(result.<Integer>Read(8));
                    vItem.setIgnoreFiltering(result.<Boolean>Read(9));

                    var bonusListIDsTok = new LocalizedString();

                    if (!bonusListIDsTok.isEmpty()) {
                        for (int token : bonusListIDsTok) {
                            vItem.getBonusListIDs().add(token);
                        }
                    }

                    // check validity with event's npcflag
                    if (!global.getObjectMgr().isVendorItemValid(entry, vItem, null, null, event_npc_flag)) {
                        continue;
                    }

                    mGameEventVendors[event_id].put(entry, vItem);

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} vendor additions in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event Battleground Holiday data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                         0           1
            var result = DB.World.query("SELECT EventEntry, BattlegroundID FROM game_event_battleground_holiday");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 Battlegroundholidays in game events. DB table `game_event_battleground_holiday` is empty.");
            } else {
                int count = 0;

                do {
                    short eventId = result.<Byte>Read(0);

                    if (eventId >= mGameEvent.length) {
                        Logs.SQL.error("`game_event_battleground_holiday` game event id ({0}) not exist in `game_event`", eventId);

                        continue;
                    }

                    mGameEventBattlegroundHolidays[eventId] = result.<Integer>Read(1);

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} Battlegroundholidays in game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loading Game Event Pool data...");

        {
            var oldMSTime = System.currentTimeMillis();

            //                                                               0                         1
            var result = DB.World.query("SELECT pool_template.entry, game_event_pool.eventEntry FROM pool_template" + " JOIN game_event_pool ON pool_template.entry = game_event_pool.pool_entry");

            if (result.isEmpty()) {
                Log.outInfo(LogFilter.ServerLoading, "Loaded 0 pools for game events. DB table `game_event_pool` is empty.");
            } else {
                int count = 0;

                do {
                    var entry = result.<Integer>Read(0);
                    short event_id = result.<Byte>Read(1);
                    var internal_event_id = mGameEvent.length + event_id - 1;

                    if (internal_event_id < 0 || internal_event_id >= mGameEventPoolIds.length) {
                        Logs.SQL.error("`game_event_pool` game event id ({0}) not exist in `game_event`", event_id);

                        continue;
                    }

                    if (!global.getPoolMgr().checkPool(entry)) {
                        Logs.SQL.error("Pool id ({0}) has all creatures or gameobjects with explicit chance sum <>100 and no equal chance defined. The pool system cannot pick one to spawn.", entry);

                        continue;
                    }


                    mGameEventPoolIds[internal_event_id].add(entry);

                    ++count;
                } while (result.NextRow());

                Log.outInfo(LogFilter.ServerLoading, "Loaded {0} pools for game events in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
            }
        }
    }

    public final long getNPCFlag(Creature cr) {
        long mask = 0;
        var guid = cr.getSpawnId();

        for (var id : m_ActiveEvents) {
            for (var pair : mGameEventNPCFlags[id]) {
                if (pair.guid == guid) {
                    mask |= pair.npcflag;
                }
            }
        }

        return mask;
    }

    public final void initialize() {
        var result = DB.World.query("SELECT MAX(eventEntry) FROM game_event");

        if (!result.isEmpty()) {
            int maxEventId = result.<Byte>Read(0);

            // Id starts with 1 and array with 0, thus increment
            maxEventId++;

            mGameEvent = new GameEventData[maxEventId];
            mGameEventCreatureGuids = new ArrayList<Long>[maxEventId * 2 - 1];
            mGameEventGameobjectGuids = new ArrayList<Long>[maxEventId * 2 - 1];
            mGameEventPoolIds = new ArrayList<Integer>[maxEventId * 2 - 1];

            for (var i = 0; i < maxEventId * 2 - 1; ++i) {
                mGameEventCreatureGuids[i] = new ArrayList<>();
                mGameEventGameobjectGuids[i] = new ArrayList<>();
                mGameEventPoolIds[i] = new ArrayList<>();
            }

            mGameEventCreatureQuests = new ArrayList<Tuple<Integer, Integer>>[maxEventId];
            mGameEventGameObjectQuests = new ArrayList<Tuple<Integer, Integer>>[maxEventId];
            mGameEventVendors = new HashMap<Integer, VendorItem>[maxEventId];
            mGameEventBattlegroundHolidays = new int[maxEventId];
            mGameEventNPCFlags = new ArrayList<( long guid, long npcflag)>[maxEventId];
            mGameEventModelEquip = new ArrayList<Tuple<Long, ModelEquip>>[maxEventId];

            for (var i = 0; i < maxEventId; ++i) {
                mGameEvent[i] = new GameEventData();
                mGameEventCreatureQuests[i] = new ArrayList<Tuple<Integer, Integer>>();
                mGameEventGameObjectQuests[i] = new ArrayList<Tuple<Integer, Integer>>();
                mGameEventVendors[i] = new HashMap<Integer, VendorItem>();
                mGameEventNPCFlags[i] = new ArrayList<( long guid, long npcflag)>();
                mGameEventModelEquip[i] = new ArrayList<Tuple<Long, ModelEquip>>();
            }
        }
    }

    public final int startSystem() // return the next event delay in ms
    {
        m_ActiveEvents.clear();
        var delay = update();
        isSystemInit = true;

        return delay;
    }

    public final void startArenaSeason() {
        var season = WorldConfig.getIntValue(WorldCfg.ArenaSeasonId);
        var result = DB.World.query("SELECT eventEntry FROM game_event_arena_seasons WHERE season = '{0}'", season);

        if (result.isEmpty()) {
            Log.outError(LogFilter.Gameevent, "ArenaSeason ({0}) must be an existant Arena Season", season);

            return;
        }

        short eventId = result.<Byte>Read(0);

        if (eventId >= mGameEvent.length) {
            Log.outError(LogFilter.Gameevent, "EventEntry {0} for ArenaSeason ({1}) does not exists", eventId, season);

            return;
        }

        startEvent(eventId, true);
        Log.outInfo(LogFilter.Gameevent, "Arena Season {0} started...", season);
    }

    public final int update() // return the next event delay in ms
    {
        var currenttime = gameTime.GetGameTime();
        int nextEventDelay = time.Day; // 1 day
        int calcDelay;
        ArrayList<SHORT> activate = new ArrayList<>();
        ArrayList<SHORT> deactivate = new ArrayList<>();

        for (short id = 1; id < mGameEvent.length; ++id) {
            // must do the activating first, and after that the deactivating
            // so first queue it
            if (checkOneGameEvent(id)) {
                // if the world event is in NEXTPHASE state, and the time has passed to finish this event, then do so
                if (mGameEvent[id].state == GameEventState.WorldNextPhase && mGameEvent[id].nextstart <= currenttime) {
                    // set this event to finished, null the nextstart time
                    mGameEvent[id].state = GameEventState.WorldFinished;
                    mGameEvent[id].nextstart = 0;
                    // save the state of this gameevent
                    saveWorldEventStateToDB(id);

                    // queue for deactivation
                    if (isActiveEvent(id)) {
                        deactivate.add(id);
                    }

                    // go to next event, this no longer needs an event update timer
                    continue;
                } else if (mGameEvent[id].state == GameEventState.WorldConditions && checkOneGameEventConditions(id)) {
                    // changed, save to DB the gameevent state, will be updated in next update cycle
                    saveWorldEventStateToDB(id);
                }

                Log.outDebug(LogFilter.misc, "GameEvent {0} is active", id);

                // queue for activation
                if (!isActiveEvent(id)) {
                    activate.add(id);
                }
            } else {
                Log.outDebug(LogFilter.misc, "GameEvent {0} is not active", id);

                if (isActiveEvent(id)) {
                    deactivate.add(id);
                } else {
                    if (!isSystemInit) {
                        var event_nid = (short) (-1 * id);
                        // spawn all negative ones for this event
                        gameEventSpawn(event_nid);
                    }
                }
            }

            calcDelay = nextCheck(id);

            if (calcDelay < nextEventDelay) {
                nextEventDelay = calcDelay;
            }
        }

        // now activate the queue
        // a now activated event can contain a spawn of a to-be-deactivated one
        // following the activate - deactivate order, deactivating the first event later will leave the spawn in (wont disappear then reappear clientside)
        for (var eventId : activate) {
            // start the event
            // returns true the started event completed
            // in that case, initiate next update in 1 second
            if (startEvent(eventId)) {
                nextEventDelay = 0;
            }
        }

        for (var eventId : deactivate) {
            stopEvent(eventId);
        }

        Log.outInfo(LogFilter.Gameevent, "Next game event check in {0} seconds.", nextEventDelay + 1);

        return (nextEventDelay + 1) * time.InMilliseconds; // Add 1 second to be sure event has started/stopped at next call
    }

    public final void handleQuestComplete(int quest_id) {
        // translate the quest to event and condition
        var questToEvent = mQuestToEventConditions.get(quest_id);

        // quest is registered
        if (questToEvent != null) {
            var event_id = questToEvent.event_id;
            var condition = questToEvent.condition;
            var num = questToEvent.num;

            // the event is not active, so return, don't increase condition finishes
            if (!isActiveEvent(event_id)) {
                return;
            }

            // not in correct phase, return
            if (mGameEvent[event_id].state != GameEventState.WorldConditions) {
                return;
            }

            var eventFinishCond = mGameEvent[event_id].conditions.get(condition);

            // condition is registered
            if (eventFinishCond != null) {
                // increase the done count, only if less then the req
                if (eventFinishCond.done < eventFinishCond.reqNum) {
                    eventFinishCond.done += num;

                    // check max limit
                    if (eventFinishCond.done > eventFinishCond.reqNum) {
                        eventFinishCond.done = eventFinishCond.reqNum;
                    }

                    // save the change to db
                    SQLTransaction trans = new SQLTransaction();

                    var stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_GAME_EVENT_CONDITION_SAVE);
                    stmt.AddValue(0, event_id);
                    stmt.AddValue(1, condition);
                    trans.append(stmt);

                    stmt = DB.characters.GetPreparedStatement(CharStatements.INS_GAME_EVENT_CONDITION_SAVE);
                    stmt.AddValue(0, event_id);
                    stmt.AddValue(1, condition);
                    stmt.AddValue(2, eventFinishCond.done);
                    trans.append(stmt);
                    DB.characters.CommitTransaction(trans);

                    // check if all conditions are met, if so, update the event state
                    if (checkOneGameEventConditions(event_id)) {
                        // changed, save to DB the gameevent state
                        saveWorldEventStateToDB(event_id);
                        // force update events to set timer
                        global.getWorldMgr().forceGameEventUpdate();
                    }
                }
            }
        }
    }

    public final boolean isHolidayActive(HolidayIds id) {
        if (id == HolidayIds.NONE) {
            return false;
        }

        var events = getEventMap();
        var activeEvents = getActiveEventList();

        for (var eventId : activeEvents) {
            if (events[eventId].holiday_id == id) {
                return true;
            }
        }

        return false;
    }

    public final boolean isEventActive(short eventId) {
        var ae = getActiveEventList();

        return ae.contains(eventId);
    }

    public final ArrayList<SHORT> getActiveEventList() {
        return m_ActiveEvents;
    }

    public final GameEventData[] getEventMap() {
        return mGameEvent;
    }

    public final boolean isActiveEvent(short event_id) {
        return m_ActiveEvents.contains(event_id);
    }

    private boolean checkOneGameEvent(short entry) {
        switch (mGameEvent[entry].state) {
            default:
            case Normal: {
                var currenttime = gameTime.GetGameTime();

                // Get the event information
                return mGameEvent[entry].start < currenttime && currenttime < mGameEvent[entry].end && (currenttime - mGameEvent[entry].start) % (mGameEvent[entry].occurence * time.Minute) < mGameEvent[entry].length * time.Minute;
            }
            // if the state is conditions or nextphase, then the event should be active
            case WorldConditions:
            case WorldNextPhase:
                return true;
            // finished world events are inactive
            case WorldFinished:
            case Internal:
                return false;
            // if inactive world event, check the prerequisite events
            case WorldInactive: {
                var currenttime = gameTime.GetGameTime();

                for (var gameEventId : mGameEvent[entry].prerequisite_events) {
                    if ((mGameEvent[gameEventId].state != GameEventState.WorldNextPhase && mGameEvent[gameEventId].state != GameEventState.WorldFinished) || mGameEvent[gameEventId].nextstart > currenttime) // if not in nextphase state for long enough, can't start this one
                    {
                        return false;
                    }
                }

                // all prerequisite events are met
                // but if there are no prerequisites, this can be only activated through gm command
                return !(mGameEvent[entry].prerequisite_events.isEmpty());
            }
        }
    }

    private void startInternalEvent(short event_id) {
        if (event_id < 1 || event_id >= mGameEvent.length) {
            return;
        }

        if (!mGameEvent[event_id].isValid()) {
            return;
        }

        if (m_ActiveEvents.contains(event_id)) {
            return;
        }

        startEvent(event_id);
    }

    private void unApplyEvent(short event_id) {
        Log.outInfo(LogFilter.Gameevent, "GameEvent {0} \"{1}\" removed.", event_id, mGameEvent[event_id].description);
        //! Run SAI scripts with SMART_EVENT_GAME_EVENT_END
        runSmartAIScripts(event_id, false);
        // un-spawn positive event tagged objects
        gameEventUnspawn((short) event_id);
        // spawn negative event tagget objects
        var event_nid = (short) (-1 * event_id);
        gameEventSpawn(event_nid);
        // restore equipment or model
        changeEquipOrModel((short) event_id, false);
        // Remove quests that are events only to non event npc
        updateEventQuests(event_id, false);
        updateWorldStates(event_id, false);
        // update npcflags in this event
        updateEventNPCFlags(event_id);
        // remove vendor items
        updateEventNPCVendor(event_id, false);
        // update bg holiday
        updateBattlegroundSettings();
    }

    private void applyNewEvent(short event_id) {
        var announce = mGameEvent[event_id].announce;

        if (announce == 1) // || (announce == 2 && WorldConfigEventAnnounce))
        {
            global.getWorldMgr().sendWorldText(SysMessage.Eventmessage, mGameEvent[event_id].description);
        }

        Log.outInfo(LogFilter.Gameevent, "GameEvent {0} \"{1}\" started.", event_id, mGameEvent[event_id].description);

        // spawn positive event tagget objects
        gameEventSpawn((short) event_id);
        // un-spawn negative event tagged objects
        var event_nid = (short) (-1 * event_id);
        gameEventUnspawn(event_nid);
        // Change equipement or model
        changeEquipOrModel((short) event_id, true);
        // Add quests that are events only to non event npc
        updateEventQuests(event_id, true);
        updateWorldStates(event_id, true);
        // update npcflags in this event
        updateEventNPCFlags(event_id);
        // add vendor items
        updateEventNPCVendor(event_id, true);
        // update bg holiday
        updateBattlegroundSettings();

        //! Run SAI scripts with SMART_EVENT_GAME_EVENT_START
        runSmartAIScripts(event_id, true);

        // check for seasonal quest reset.
        global.getWorldMgr().resetEventSeasonalQuests(event_id, getLastStartTime(event_id));
    }

    private void updateEventNPCFlags(short event_id) {
        MultiMap<Integer, Long> creaturesByMap = new MultiMap<Integer, Long>();

        // go through the creatures whose npcflags are changed in the event

        for (var(guid, npcflag) : mGameEventNPCFlags[event_id]) {
            // get the creature data from the low guid to get the entry, to be able to find out the whole guid
            var data = global.getObjectMgr().getCreatureData(guid);

            if (data != null) {
                creaturesByMap.add(data.getMapId(), guid);
            }
        }

        for (var key : creaturesByMap.keySet()) {
            global.getMapMgr().DoForAllMapsWithMapId(key, (Map map) ->
            {
                for (var spawnId : creaturesByMap.get(key)) {
                    var creatureBounds = map.getCreatureBySpawnIdStore().get(spawnId);

                    for (var creature : creatureBounds) {
                        var npcflag = getNPCFlag(creature);
                        var creatureTemplate = creature.getTemplate();

                        if (creatureTemplate != null) {
                            npcflag |= (long) creatureTemplate.npcflag;
                        }

                        creature.replaceAllNpcFlags(NPCFlags.forValue(npcflag & 0xFFFFFFFF));
                        creature.replaceAllNpcFlags2(NPCFlags2.forValue(npcflag >>> 32));
                        // reset gossip options, since the flag change might have added / removed some
                        //cr.ResetGossipOptions();
                    }
                }
            });
        }
    }

    private void updateBattlegroundSettings() {
        global.getBattlegroundMgr().resetHolidays();

        for (var activeEventId : m_ActiveEvents) {
            global.getBattlegroundMgr().setHolidayActive(mGameEventBattlegroundHolidays[activeEventId]);
        }
    }

    private void updateEventNPCVendor(short eventId, boolean activate) {
        for (var npcEventVendor : mGameEventVendors[eventId].entrySet()) {
            if (activate) {
                global.getObjectMgr().addVendorItem(npcEventVendor.getKey(), npcEventVendor.getValue(), false);
            } else {
                global.getObjectMgr().removeVendorItem(npcEventVendor.getKey(), npcEventVendor.getValue().item, npcEventVendor.getValue().type, false);
            }
        }
    }

    private void gameEventSpawn(short event_id) {
        var internal_event_id = mGameEvent.length + event_id - 1;

        if (internal_event_id < 0 || internal_event_id >= mGameEventCreatureGuids.length) {
            Log.outError(LogFilter.Gameevent, "GameEventMgr.GameEventSpawn attempt access to out of range mGameEventCreatureGuids element {0} (size: {1})", internal_event_id, mGameEventCreatureGuids.length);

            return;
        }

        for (var guid : mGameEventCreatureGuids[internal_event_id]) {
            // Add to correct cell
            var data = global.getObjectMgr().getCreatureData(guid);

            if (data != null) {
                global.getObjectMgr().addCreatureToGrid(data);

                // Spawn if necessary (loaded grids only)
                global.getMapMgr().DoForAllMapsWithMapId(data.getMapId(), map ->
                {
                    map.removeRespawnTime(SpawnObjectType.CREATURE, guid);

                    // We use spawn coords to spawn
                    if (map.isGridLoaded(data.spawnPoint)) {
                        CREATURE.createCreatureFromDB(guid, map);
                    }
                });
            }
        }

        if (internal_event_id < 0 || internal_event_id >= mGameEventGameobjectGuids.length) {
            Log.outError(LogFilter.Gameevent, "GameEventMgr.GameEventSpawn attempt access to out of range mGameEventGameobjectGuids element {0} (size: {1})", internal_event_id, mGameEventGameobjectGuids.length);

            return;
        }

        for (var guid : mGameEventGameobjectGuids[internal_event_id]) {
            // Add to correct cell
            var data = global.getObjectMgr().getGameObjectData(guid);

            if (data != null) {
                global.getObjectMgr().addGameObjectToGrid(data);

                // Spawn if necessary (loaded grids only)
                // this base map checked as non-instanced and then only existed
                global.getMapMgr().DoForAllMapsWithMapId(data.getMapId(), map ->
                {
                    map.removeRespawnTime(SpawnObjectType.gameObject, guid);

                    // We use current coords to unspawn, not spawn coords since creature can have changed grid
                    if (map.isGridLoaded(data.spawnPoint)) {
                        var go = gameObject.createGameObjectFromDb(guid, map, false);

                        // @todo find out when it is add to map
                        if (go) {
                            // @todo find out when it is add to map
                            if (go.isSpawnedByDefault()) {
                                if (!map.addToMap(go)) {
                                    go.close();
                                }
                            }
                        }
                    }
                });
            }
        }

        if (internal_event_id < 0 || internal_event_id >= mGameEventPoolIds.length) {
            Log.outError(LogFilter.Gameevent, "GameEventMgr.GameEventSpawn attempt access to out of range mGameEventPoolIds element {0} (size: {1})", internal_event_id, mGameEventPoolIds.length);

            return;
        }

        for (var id : mGameEventPoolIds[internal_event_id]) {
            var poolTemplate = global.getPoolMgr().getPoolTemplate(id);

            if (poolTemplate != null) {
                global.getMapMgr().DoForAllMapsWithMapId((int) poolTemplate.mapId, map ->
                {
                    global.getPoolMgr().spawnPool(map.PoolData, id);
                });
            }
        }
    }

    private void gameEventUnspawn(short event_id) {
        var internal_event_id = mGameEvent.length + event_id - 1;

        if (internal_event_id < 0 || internal_event_id >= mGameEventCreatureGuids.length) {
            Log.outError(LogFilter.Gameevent, "GameEventMgr.GameEventUnspawn attempt access to out of range mGameEventCreatureGuids element {0} (size: {1})", internal_event_id, mGameEventCreatureGuids.length);

            return;
        }

        for (var guid : mGameEventCreatureGuids[internal_event_id]) {
            // check if it's needed by another event, if so, don't remove
            if (event_id > 0 && hasCreatureActiveEventExcept(guid, (short) event_id)) {
                continue;
            }

            // Remove the creature from grid
            var data = global.getObjectMgr().getCreatureData(guid);

            if (data != null) {
                global.getObjectMgr().removeCreatureFromGrid(data);

                global.getMapMgr().DoForAllMapsWithMapId(data.getMapId(), map ->
                {
                    map.removeRespawnTime(SpawnObjectType.CREATURE, guid);
                    var creatureBounds = map.CreatureBySpawnIdStore.get(guid);

                    for (var creature : creatureBounds) {
                        creature.addObjectToRemoveList();
                    }
                });
            }
        }

        if (internal_event_id < 0 || internal_event_id >= mGameEventGameobjectGuids.length) {
            Log.outError(LogFilter.Gameevent, "GameEventMgr.GameEventUnspawn attempt access to out of range mGameEventGameobjectGuids element {0} (size: {1})", internal_event_id, mGameEventGameobjectGuids.length);

            return;
        }

        for (var guid : mGameEventGameobjectGuids[internal_event_id]) {
            // check if it's needed by another event, if so, don't remove
            if (event_id > 0 && hasGameObjectActiveEventExcept(guid, (short) event_id)) {
                continue;
            }

            // Remove the gameobject from grid
            var data = global.getObjectMgr().getGameObjectData(guid);

            if (data != null) {
                global.getObjectMgr().removeGameObjectFromGrid(data);

                global.getMapMgr().DoForAllMapsWithMapId(data.getMapId(), map ->
                {
                    map.removeRespawnTime(SpawnObjectType.gameObject, guid);
                    var gameobjectBounds = map.GameObjectBySpawnIdStore.get(guid);

                    for (var go : gameobjectBounds) {
                        go.addObjectToRemoveList();
                    }
                });
            }
        }

        if (internal_event_id < 0 || internal_event_id >= mGameEventPoolIds.length) {
            Log.outError(LogFilter.Gameevent, "GameEventMgr.GameEventUnspawn attempt access to out of range mGameEventPoolIds element {0} (size: {1})", internal_event_id, mGameEventPoolIds.length);

            return;
        }

        for (var poolId : mGameEventPoolIds[internal_event_id]) {
            var poolTemplate = global.getPoolMgr().getPoolTemplate(poolId);

            if (poolTemplate != null) {
                global.getMapMgr().DoForAllMapsWithMapId((int) poolTemplate.mapId, map ->
                {
                    global.getPoolMgr().despawnPool(map.PoolData, poolId, true);
                });
            }
        }
    }

    private void changeEquipOrModel(short event_id, boolean activate) {
        for (var tuple : mGameEventModelEquip[event_id]) {
            // Remove the creature from grid
            var data = global.getObjectMgr().getCreatureData(tuple.Item1);

            if (data == null) {
                continue;
            }

            // Update if spawned
            global.getMapMgr().DoForAllMapsWithMapId(data.getMapId(), map ->
            {
                var creatureBounds = map.CreatureBySpawnIdStore.get(tuple.Item1);

                for (var creature : creatureBounds) {
                    if (activate) {
                        tuple.item2.equipement_id_prev = creature.currentEquipmentId;
                        tuple.item2.modelid_prev = creature.displayId;
                        creature.loadEquipment(tuple.item2.equipment_id, true);

                        if (tuple.item2.modelid > 0 && tuple.item2.modelid_prev != tuple.item2.modelid && global.getObjectMgr().getCreatureModelInfo(tuple.item2.modelid) != null) {
                            creature.setDisplayId(tuple.item2.modelid);
                            creature.setNativeDisplayId(tuple.item2.modelid);
                        }
                    } else {
                        creature.loadEquipment(tuple.item2.equipement_id_prev, true);

                        if (tuple.item2.modelid_prev > 0 && tuple.item2.modelid_prev != tuple.item2.modelid && global.getObjectMgr().getCreatureModelInfo(tuple.item2.modelid_prev) != null) {
                            creature.setDisplayId(tuple.item2.modelid_prev);
                            creature.setNativeDisplayId(tuple.item2.modelid_prev);
                        }
                    }
                }
            });

            // now last step: put in data
            var data2 = global.getObjectMgr().newOrExistCreatureData(tuple.Item1);

            if (activate) {
                tuple.item2.modelid_prev = data2.displayid;
                tuple.item2.equipement_id_prev = (byte) data2.equipmentId;
                data2.displayid = tuple.item2.modelid;
                data2.equipmentId = (byte) tuple.item2.equipment_id;
            } else {
                data2.displayid = tuple.item2.modelid_prev;
                data2.equipmentId = (byte) tuple.item2.equipement_id_prev;
            }
        }
    }

    private boolean hasCreatureQuestActiveEventExcept(int questId, short eventId) {
        for (var activeEventId : m_ActiveEvents) {
            if (activeEventId != eventId) {
                for (var pair : mGameEventCreatureQuests[activeEventId]) {
                    if (pair.item2 == questId) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean hasGameObjectQuestActiveEventExcept(int questId, short eventId) {
        for (var activeEventId : m_ActiveEvents) {
            if (activeEventId != eventId) {
                for (var pair : mGameEventGameObjectQuests[activeEventId]) {
                    if (pair.item2 == questId) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean hasCreatureActiveEventExcept(long creatureId, short eventId) {
        for (var activeEventId : m_ActiveEvents) {
            if (activeEventId != eventId) {
                var internal_event_id = mGameEvent.length + activeEventId - 1;

                for (var id : mGameEventCreatureGuids[internal_event_id]) {
                    if (id == creatureId) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean hasGameObjectActiveEventExcept(long goId, short eventId) {
        for (var activeEventId : m_ActiveEvents) {
            if (activeEventId != eventId) {
                var internal_event_id = mGameEvent.length + activeEventId - 1;

                for (var id : mGameEventGameobjectGuids[internal_event_id]) {
                    if (id == goId) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void updateEventQuests(short eventId, boolean activate) {
        for (var pair : mGameEventCreatureQuests[eventId]) {
            var CreatureQuestMap = global.getObjectMgr().getCreatureQuestRelationMapHACK();

            if (activate) // Add the pair(id, quest) to the multimap
            {
                CreatureQuestMap.add(pair.Item1, pair.item2);
            } else {
                if (!hasCreatureQuestActiveEventExcept(pair.item2, eventId)) {
                    // Remove the pair(id, quest) from the multimap
                    CreatureQuestMap.remove(pair.Item1, pair.item2);
                }
            }
        }

        for (var pair : mGameEventGameObjectQuests[eventId]) {
            var GameObjectQuestMap = global.getObjectMgr().getGOQuestRelationMapHACK();

            if (activate) // Add the pair(id, quest) to the multimap
            {
                GameObjectQuestMap.add(pair.Item1, pair.item2);
            } else {
                if (!hasGameObjectQuestActiveEventExcept(pair.item2, eventId)) {
                    // Remove the pair(id, quest) from the multimap
                    GameObjectQuestMap.remove(pair.Item1, pair.item2);
                }
            }
        }
    }

    private void updateWorldStates(short event_id, boolean Activate) {
        var event = mGameEvent[event_id];

        if (event.holiday_id != HolidayIds.NONE) {
            var bgTypeId = global.getBattlegroundMgr().weekendHolidayIdToBGType(event.holiday_id);

            if (bgTypeId != BattlegroundTypeId.NONE) {
                var bl = CliDB.BattlemasterListStorage.get(global.getBattlegroundMgr().weekendHolidayIdToBGType(event.holiday_id));

                if (bl != null) {
                    if (bl.HolidayWorldState != 0) {
                        global.getWorldStateMgr().setValue(bl.HolidayWorldState, Activate ? 1 : 0, false, null);
                    }
                }
            }
        }
    }

    private boolean checkOneGameEventConditions(short event_id) {
        for (var pair : mGameEvent[event_id].conditions.entrySet()) {
            if (pair.getValue().done < pair.getValue().reqNum) {
                // return false if a condition doesn't match
                return false;
            }
        }

        // set the phase
        mGameEvent[event_id].state = GameEventState.WorldNextPhase;

        // set the followup events' start time
        if (mGameEvent[event_id].nextstart == 0) {
            var currenttime = gameTime.GetGameTime();
            mGameEvent[event_id].nextstart = currenttime + mGameEvent[event_id].length * 60;
        }

        return true;
    }

    private void saveWorldEventStateToDB(short event_id) {
        SQLTransaction trans = new SQLTransaction();

        var stmt = DB.characters.GetPreparedStatement(CharStatements.DEL_GAME_EVENT_SAVE);
        stmt.AddValue(0, event_id);
        trans.append(stmt);

        stmt = DB.characters.GetPreparedStatement(CharStatements.INS_GAME_EVENT_SAVE);
        stmt.AddValue(0, event_id);
        stmt.AddValue(1, (byte) mGameEvent[event_id].state.getValue());
        stmt.AddValue(2, mGameEvent[event_id].nextstart != 0 ? mGameEvent[event_id].nextstart : 0L);
        trans.append(stmt);
        DB.characters.CommitTransaction(trans);
    }

    private void sendWorldStateUpdate(Player player, short event_id) {
        for (var pair : mGameEvent[event_id].conditions.entrySet()) {
            if (pair.getValue().done_world_state != 0) {
                player.sendUpdateWorldState(pair.getValue().done_world_state, (int) (pair.getValue().done));
            }

            if (pair.getValue().max_world_state != 0) {
                player.sendUpdateWorldState(pair.getValue().max_world_state, (int) (pair.getValue().reqNum));
            }
        }
    }

    private void runSmartAIScripts(short event_id, boolean activate) {
        //! Iterate over every supported source type (creature and gameobject)
        //! Not entirely sure how this will affect units in non-loaded grids.
        global.getMapMgr().DoForAllMaps(map ->
        {
            GameEventAIHookWorker worker = new GameEventAIHookWorker(event_id, activate);

            worker.visit(map.ObjectsStore.VALUES.ToList());
        });
    }

    private void setHolidayEventTime(GameEventData gameEvent) {
        if (gameEvent.holidayStage == 0) // Ignore holiday
        {
            return;
        }

        var holiday = CliDB.HolidaysStorage.get(gameEvent.holiday_id);

        if (holiday.Date[0] == 0 || holiday.Duration[0] == 0) // Invalid definitions
        {
            Logs.SQL.error(String.format("Missing date or duration for holiday %1$s.", gameEvent.holiday_id));

            return;
        }

        var stageIndex = (byte) (gameEvent.holidayStage - 1);
        gameEvent.length = (int) (holiday.Duration[stageIndex] * time.Hour / time.Minute);

        long stageOffset = 0;

        for (var i = 0; i < stageIndex; ++i) {
            stageOffset += holiday.Duration[i] * time.Hour;
        }

        switch (holiday.CalendarFilterType) {
            case -1: // Yearly
                gameEvent.occurence = time.Year / time.Minute; // Not all too useful

                break;
            case 0: // Weekly
                gameEvent.occurence = time.Week / time.Minute;

                break;
            case 1: // Defined dates only (Darkmoon Faire)
                break;
            case 2: // Only used for looping events (Call to Arms)
                break;
        }

        if (holiday.Looping != 0) {
            gameEvent.occurence = 0;

            for (var i = 0; i < SharedConst.MaxHolidayDurations && holiday.Duration[i] != 0; ++i) {
                gameEvent.occurence += (int) (holiday.Duration[i] * time.Hour / time.Minute);
            }
        }

        var singleDate = ((holiday.Date[0] >> 24) & 0x1F) == 31; // Events with fixed date within year have - 1

        var curTime = gameTime.GetGameTime();

        for (var i = 0; i < SharedConst.MaxHolidayDates && holiday.Date[i] != 0; ++i) {
            var date = holiday.Date[i];

            int year;

            if (singleDate) {
                year = time.UnixTimeToDateTime(curTime).ToLocalTime().getYear() - 1; // First try last year (event active through New Year)
            } else {
                year = (int) ((date >> 24) & 0x1F) + 100 + 1900;
            }

            var timeInfo = LocalDateTime.of(year, (int) ((date >> 20) & 0xF) + 1, (int) ((date >> 14) & 0x3F) + 1, (int) ((date >> 6) & 0x1F), (int) (date & 0x3F), 0);

            var startTime = time.DateTimeToUnixTime(timeInfo);

            if (curTime < startTime + gameEvent.length * time.Minute) {
                gameEvent.start = startTime + stageOffset;

                break;
            } else if (singleDate) {
                var tmCopy = timeInfo.plusYears(time.UnixTimeToDateTime(curTime).ToLocalTime().getYear()); // This year
                gameEvent.start = time.DateTimeToUnixTime(tmCopy) + stageOffset;

                break;
            } else {
                // date is due and not a singleDate event, try with next DBC date (modified by holiday_dates)
                // if none is found we don't modify start date and use the one in game_event
            }
        }
    }

    private long getLastStartTime(short event_id) {
        if (event_id >= mGameEvent.length) {
            return 0;
        }

        if (mGameEvent[event_id].state != GameEventState.NORMAL) {
            return 0;
        }

        var now = gameTime.GetSystemTime();
        var eventInitialStart = time.UnixTimeToDateTime(mGameEvent[event_id].start);
        var occurence = durationofMinutes(mGameEvent[event_id].occurence);
        var durationSinceLastStart = duration.FromTicks((now - eventInitialStart).Ticks % occurence.ticks);

        return time.DateTimeToUnixTime(now - durationSinceLastStart);
    }

    private void addActiveEvent(short event_id) {
        m_ActiveEvents.add(event_id);
    }

    private void removeActiveEvent(short event_id) {
        m_ActiveEvents.remove((SHORT) event_id);
    }
}
