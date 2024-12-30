package com.github.mmo.game.entity;


import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.creature.CreatureGroup;

import java.util.ArrayList;
import java.util.HashMap;


public class FormationMgr {
    private static final HashMap<Long, FormationInfo> CREATUREGROUPMAP = new HashMap<Long, FormationInfo>();

    public static void addCreatureToGroup(long leaderSpawnId, Creature creature) {
        var map = creature.getMap();

        var creatureGroup = map.getCreatureGroupHolder().get(leaderSpawnId);

        if (creatureGroup != null) {
            //Add member to an existing group
            Log.outDebug(LogFilter.unit, "Group found: {0}, inserting creature GUID: {1}, Group InstanceID {2}", leaderSpawnId, creature.getGUID().toString(), creature.getInstanceId());

            // With dynamic spawn the creature may have just respawned
            // we need to find previous instance of creature and delete it from the formation, as it'll be invalidated
            var bounds = map.getCreatureBySpawnIdStore().get(creature.getSpawnId());

            for (var other : bounds) {
                if (other == creature) {
                    continue;
                }

                if (creatureGroup.hasMember(other)) {
                    creatureGroup.removeMember(other);
                }
            }

            creatureGroup.addMember(creature);
        } else {
            //Create new group
            Log.outDebug(LogFilter.unit, "Group not found: {0}. Creating new group.", leaderSpawnId);
            CreatureGroup group = new creatureGroup(leaderSpawnId);
            map.getCreatureGroupHolder().put(leaderSpawnId, group);
            group.addMember(creature);
        }
    }

    public static void removeCreatureFromGroup(CreatureGroup group, Creature member) {
        Log.outDebug(LogFilter.unit, "Deleting member GUID: {0} from group {1}", group.getLeaderSpawnId(), member.getSpawnId());
        group.removeMember(member);

        if (group.isEmpty()) {
            var map = member.getMap();

            Log.outDebug(LogFilter.unit, "Deleting group with InstanceID {0}", member.getInstanceId());
            map.getCreatureGroupHolder().remove(group.getLeaderSpawnId());
        }
    }

    public static void loadCreatureFormations() {
        var oldMSTime = System.currentTimeMillis();

        //Get group data
        var result = DB.World.query("SELECT leaderGUID, memberGUID, dist, angle, groupAI, point_1, point_2 FROM creature_formations ORDER BY leaderGUID");

        if (result.isEmpty()) {
            Log.outInfo(LogFilter.ServerLoading, "Loaded 0 creatures in formations. DB table `creature_formations` is empty!");

            return;
        }

        int count = 0;
        ArrayList<Long> leaderSpawnIds = new ArrayList<>();

        do {
            //Load group member data
            FormationInfo member = new FormationInfo();
            member.setLeaderSpawnId(result.<Long>Read(0));
            var memberSpawnId = result.<Long>Read(1);
            member.setFollowDist(0f);
            member.setFollowAngle(0f);

            //If creature is group leader we may skip loading of dist/angle
            if (member.getLeaderSpawnId() != memberSpawnId) {
                member.setFollowDist(result.<Float>Read(2));
                member.setFollowAngle(result.<Float>Read(3) * MathUtil.PI / 180);
            }

            member.setGroupAi(result.<Integer>Read(4));

            for (var i = 0; i < 2; ++i) {
                member.getLeaderWaypointIDs()[i] = result.<SHORT>Read(5 + i);
            }

            {
                // check data correctness
                if (global.getObjectMgr().getCreatureData(member.getLeaderSpawnId()) == null) {
                    if (ConfigMgr.GetDefaultValue("load.autoclean", false)) {
                        DB.World.execute(String.format("DELETE FROM creature_formations WHERE leaderGUID = %1$s", member.getLeaderSpawnId()));
                    } else {
                        Logs.SQL.error(String.format("creature_formations table leader guid %1$s incorrect (not exist)", member.getLeaderSpawnId()));
                    }

                    continue;
                }

                if (global.getObjectMgr().getCreatureData(memberSpawnId) == null) {
                    if (ConfigMgr.GetDefaultValue("load.autoclean", false)) {
                        DB.World.execute(String.format("DELETE FROM creature_formations WHERE memberGUID = %1$s", memberSpawnId));
                    } else {
                        Logs.SQL.error(String.format("creature_formations table member guid %1$s incorrect (not exist)", memberSpawnId));
                    }

                    continue;
                }

                leaderSpawnIds.add(member.getLeaderSpawnId());
            }

            CREATUREGROUPMAP.put(memberSpawnId, member);
            ++count;
        } while (result.NextRow());

        for (var leaderSpawnId : leaderSpawnIds) {
            if (!CREATUREGROUPMAP.containsKey(leaderSpawnId)) {
                Logs.SQL.error(String.format("creature_formation contains leader spawn %1$s which is not included on its formation, removing", leaderSpawnId));

                for (var itr : CREATUREGROUPMAP.ToList()) {
                    if (itr.value.leaderSpawnId == leaderSpawnId) {
                        CREATUREGROUPMAP.remove(itr.key);
                    }
                }
            }
        }

        Log.outInfo(LogFilter.ServerLoading, "Loaded {0} creatures in formations in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
    }

    public static FormationInfo getFormationInfo(long spawnId) {
        return CREATUREGROUPMAP.get(spawnId);
    }

    public static void addFormationMember(long spawnId, float followAng, float followDist, long leaderSpawnId, int groupAI) {
        FormationInfo member = new FormationInfo();
        member.setLeaderSpawnId(leaderSpawnId);
        member.setFollowDist(followDist);
        member.setFollowAngle(followAng);
        member.setGroupAi(groupAI);

        for (var i = 0; i < 2; ++i) {
            member.getLeaderWaypointIDs()[i] = 0;
        }

        CREATUREGROUPMAP.put(spawnId, member);
    }
}
