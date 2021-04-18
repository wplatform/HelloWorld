package com.rainbowland.enums;

public enum GroupJoinBattlegroundResult {
    ERR_BATTLEGROUND_NONE(0),
    ERR_GROUP_JOIN_BATTLEGROUND_DESERTERS(2),        // You cannot join the battleground yet because you or one of your party members is flagged as a Deserter.
    ERR_ARENA_TEAM_PARTY_SIZE(3),        // Incorrect party size for this arena.
    ERR_BATTLEGROUND_TOO_MANY_QUEUES(4),        // You can only be queued for 2 battles at once
    ERR_BATTLEGROUND_CANNOT_QUEUE_FOR_RATED(5),        // You cannot queue for a rated match while queued for other battles
    ERR_BATTLEDGROUND_QUEUED_FOR_RATED(6),        // You cannot queue for another battle while queued for a rated arena match
    ERR_BATTLEGROUND_TEAM_LEFT_QUEUE(7),        // Your team has left the arena queue
    ERR_BATTLEGROUND_NOT_IN_BATTLEGROUND(8),        // You can't do that in a battleground.
    ERR_BATTLEGROUND_JOIN_XP_GAIN(9),        // wtf), doesn't exist in client...
    ERR_BATTLEGROUND_JOIN_RANGE_INDEX(10),       // Cannot join the queue unless all members of your party are in the same battleground level range.
    ERR_BATTLEGROUND_JOIN_TIMED_OUT(11),       // %s was unavailable to join the queue. (ObjectGuid exist in client cache)
    //ERR_BATTLEGROUND_JOIN_TIMED_OUT               ( 12),       // same as 11
    //ERR_BATTLEGROUND_TEAM_LEFT_QUEUE              ( 13),       // same as 7
    ERR_LFG_CANT_USE_BATTLEGROUND(14),       // You cannot queue for a battleground or arena while using the dungeon system.
    ERR_IN_RANDOM_BG(15),       // Can't do that while in a Random Battleground queue.
    ERR_IN_NON_RANDOM_BG(16),       // Can't queue for Random Battleground while in another Battleground queue.
    ERR_BG_DEVELOPER_ONLY(17),
    ERR_BATTLEGROUND_INVITATION_DECLINED(18),
    ERR_MEETING_STONE_NOT_FOUND(19),
    ERR_WARGAME_REQUEST_FAILURE(20),
    ERR_BATTLEFIELD_TEAM_PARTY_SIZE(22),
    ERR_NOT_ON_TOURNAMENT_REALM(23),
    ERR_BATTLEGROUND_PLAYERS_FROM_DIFFERENT_REALMS(24),
    ERR_REMOVE_FROM_PVP_QUEUE_GRANT_LEVEL(33),
    ERR_REMOVE_FROM_PVP_QUEUE_FACTION_CHANGE(34),
    ERR_BATTLEGROUND_JOIN_FAILED(35),
    ERR_BATTLEGROUND_DUPE_QUEUE(43),
    ERR_BATTLEGROUND_JOIN_NO_VALID_SPEC_FOR_ROLE(44),
    ERR_BATTLEGROUND_JOIN_RESPEC(45),
    ERR_ALREADY_USING_LFG_LIST(46),
    ERR_BATTLEGROUND_JOIN_MUST_COMPLETE_QUEST(47);
    private final int value;

    GroupJoinBattlegroundResult(int value) {
        this.value = value;
    }

    public int val() {
        return this.value;
    }
}
