package com.github.mmo.game.entity.creature;


import com.github.mmo.game.entity.FormationInfo;
import com.github.mmo.game.entity.FormationMgr;
import com.github.mmo.game.entity.unit.Unit;

import java.util.HashMap;


public class CreatureGroup {
    private final HashMap<CREATURE, FormationInfo> members = new HashMap<CREATURE, FormationInfo>();
    private final long leaderSpawnId;
    private final boolean formed;
    private Creature leader;
    private boolean engaging;


    public creatureGroup(long leaderSpawnId) {
        leaderSpawnId = leaderSpawnId;
    }

    public final Creature getLeader() {
        return leader;
    }

    public final long getLeaderSpawnId() {
        return leaderSpawnId;
    }

    public final boolean isEmpty() {
        return members.isEmpty();
    }

    public final boolean isFormed() {
        return formed;
    }

    public final void addMember(Creature member) {
        Log.outDebug(LogFilter.unit, "CreatureGroup.AddMember: Adding {0}.", member.getGUID().toString());

        //Check if it is a leader
        if (member.getSpawnId() == leaderSpawnId) {
            Log.outDebug(LogFilter.unit, "{0} is formation leader. Adding group.", member.getGUID().toString());
            leader = member;
        }

        // formation must be registered at this point
        var formationInfo = FormationMgr.getFormationInfo(member.getSpawnId());
        members.put(member, formationInfo);
        member.setFormation(this);
    }

    public final void removeMember(Creature member) {
        if (leader == member) {
            leader = null;
        }

        members.remove(member);
        member.setFormation(null);
    }

    public final void memberEngagingTarget(Creature member, Unit target) {
        // used to prevent recursive calls
        if (engaging) {
            return;
        }

        var groupAI = GroupAIFlags.forValue(FormationMgr.getFormationInfo(member.getSpawnId()).getGroupAi());

        if (groupAI == 0) {
            return;
        }

        if (member == leader) {
            if (!groupAI.hasFlag(GroupAIFlags.MembersAssistLeader)) {
                return;
            }
        } else if (!groupAI.hasFlag(GroupAIFlags.LeaderAssistsMember)) {
            return;
        }

        engaging = true;

        for (var pair : members.entrySet()) {
            var other = pair.getKey();

            // Skip self
            if (other == member) {
                continue;
            }

            if (!other.isAlive) {
                continue;
            }

            if (((other != leader && groupAI.hasFlag(GroupAIFlags.MembersAssistLeader)) || (other == leader && groupAI.hasFlag(GroupAIFlags.LeaderAssistsMember))) && other.isValidAttackTarget(target)) {
                other.engageWithTarget(target);
            }
        }

        engaging = false;
    }

    public final void formationReset(boolean dismiss) {
        for (var creature : members.keySet()) {
            if (creature != leader && creature.isAlive) {
                creature.MotionMaster.moveIdle();
            }
        }

        //_formed = !dismiss;
    }

    public final void leaderStartedMoving() {
        if (leader == null) {
            return;
        }

        for (var pair : members.entrySet()) {
            var member = pair.getKey();

            if (member == leader || !member.isAlive || member.IsEngaged || !pair.getValue().groupAi.hasFlag((int) GroupAIFlags.IdleInFormation.getValue())) {
                continue;
            }

            var angle = pair.getValue().followAngle + (float) Math.PI; // for some reason, someone thought it was a great idea to invert relativ angles...
            var dist = pair.getValue().followDist;

            if (!member.hasUnitState(UnitState.FollowFormation)) {
                member.MotionMaster.moveFormation(leader, dist, angle, pair.getValue().LeaderWaypointIDs[0], pair.getValue().LeaderWaypointIDs[1]);
            }
        }
    }

    public final boolean canLeaderStartMoving() {
        for (var pair : members.entrySet()) {
            if (pair.getKey() != leader && pair.getKey().isAlive) {
                if (pair.getKey().IsEngaged || pair.getKey().IsReturningHome) {
                    return false;
                }
            }
        }

        return true;
    }

    public final boolean isLeader(Creature creature) {
        return leader == creature;
    }

    public final boolean hasMember(Creature member) {
        return members.containsKey(member);
    }
}
