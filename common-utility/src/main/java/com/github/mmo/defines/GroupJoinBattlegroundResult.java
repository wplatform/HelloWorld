package com.github.mmo.defines;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum GroupJoinBattlegroundResult {
    ERR_BATTLEGROUND_NONE(0),
    ERR_GROUP_JOIN_BATTLEGROUND_DESERTERS(2),        // You cannot join the battleground yet because you or one of your party members is flagged as a Deserter.
    ERR_ARENA_TEAM_PARTY_SIZE(3),        // Incorrect party size for this arena.
    ERR_BATTLEGROUND_TOO_MANY_QUEUES(4),        // You can only be queued for 2 battles at once
    ERR_BATTLEGROUND_CANNOT_QUEUE_FOR_RATED(5),        // You cannot queue for a rated match while queued for other battles
    ERR_BATTLEDGROUND_QUEUED_FOR_RATED(6),        // You cannot queue for another battle while queued for a rated arena match
    ERR_BATTLEGROUND_TEAM_LEFT_QUEUE(7),        // Your team has left the arena queue
    ERR_BATTLEGROUND_NOT_IN_BATTLEGROUND(8),        // You can't do that in a battleground.
    ERR_BATTLEGROUND_JOIN_XP_GAIN(9),        // Cannot join as a group unless all the members of your party have the same XP gain setting.
    ERR_BATTLEGROUND_JOIN_RANGE_INDEX(10),       // Cannot join the queue unless all members of your party are in the same battleground level range.
    ERR_BATTLEGROUND_JOIN_TIMED_OUT(11),       // %s was unavailable to join the queue. (ObjectGuid exist in client cache)
    //ERR_BATTLEGROUND_JOIN_TIMED_OUT               (12),       // same as 11
    //ERR_BATTLEGROUND_TEAM_LEFT_QUEUE              (13),       // same as 7
    ERR_LFG_CANT_USE_BATTLEGROUND(14),       // You cannot queue for a battleground or arena while using the dungeon system.
    ERR_IN_RANDOM_BG(15),       // Can't do that while in a Random Battleground queue.
    ERR_IN_NON_RANDOM_BG(16),       // Can't queue for Random Battleground while in another Battleground queue.
    ERR_BG_DEVELOPER_ONLY(17),       // This battleground is only available for developer testing at this time.
    ERR_BATTLEGROUND_INVITATION_DECLINED(18),       // Your War Game invitation has been declined
    ERR_MEETING_STONE_NOT_FOUND(19),       // Player not found.
    ERR_WARGAME_REQUEST_FAILURE(20),       // War Game request failed
    ERR_BATTLEFIELD_TEAM_PARTY_SIZE(22),       // Incorrect party size for this battlefield.
    ERR_NOT_ON_TOURNAMENT_REALM(23),       // Not available on a Tournament Realm.
    ERR_BATTLEGROUND_PLAYERS_FROM_DIFFERENT_REALMS(24),       // You cannot queue for a battleground while players from different realms are in your party.
    ERR_BATTLEGROUND_JOIN_LEVELUP(33),       // You have been removed from a PvP queue because you have gained a level.
    ERR_REMOVE_FROM_PVP_QUEUE_FACTION_CHANGE(34),       // You have been removed from a PvP Queue because you changed your faction.
    ERR_BATTLEGROUND_JOIN_FAILED(35),       // Join as a group failed
    ERR_BATTLEGROUND_DUPE_QUEUE(43),       // Someone in your group is already queued for that.
    ERR_BATTLEGROUND_JOIN_NO_VALID_SPEC_FOR_ROLE(44),       // Role check failed because one of your party members selected an invalid role.
    ERR_BATTLEGROUND_JOIN_RESPEC(45),       // You have been removed from a PvP queue because your specialization changed.
    ERR_ALREADY_USING_LFG_LIST(46),       // You can't do that while using Premade Groups.
    ERR_BATTLEGROUND_JOIN_MUST_COMPLETE_QUEST(47),       // You have been removed from a PvP queue because someone is missing required quest completion.
    ERR_BATTLERGOUND_RESTRICTED_ACCOUNT(48),       // Free Trial accounts cannot perform that action
    ERR_BATTLEGROUND_JOIN_MERCENARY(49),       // Cannot join as a group unless all the members of your party are flagged as a mercenary.
    ERR_BATTLEGROUND_JOIN_TOO_MANY_HEALERS(51),       // You can not enter this bracket of arena with more than one healer. / You can not enter a rated battleground with more than three healers.
    ERR_BATTLEGROUND_JOIN_TOO_MANY_TANKS(52),       // You can not enter this bracket of arena with more than one tank.
    ERR_BATTLEGROUND_JOIN_TOO_MANY_DAMAGE(53),       // You can not enter this bracket of arena with more than two damage dealers.
    ERR_GROUP_JOIN_BATTLEGROUND_DEAD(57),       // You cannot join the battleground because you or one of your party members is dead.
    ERR_BATTLEGROUND_JOIN_REQUIRES_LEVEL(58),       // Tournament rules requires all participants to be max level.
    ERR_BATTLEGROUND_JOIN_DISQUALIFIED(59),       // %s has been disqualified from ranked play in this bracket.
    ERR_ARENA_EXPIRED_CAIS(60),       // You may not queue while one or more of your team members is under the effect of restricted play.
    ERR_SOLO_SHUFFLE_WARGAME_GROUP_SIZE(64),       // Exactly 6 non-spectator players must be present to begin a Solo Shuffle Wargame.
    ERR_SOLO_SHUFFLE_WARGAME_GROUP_COMP(65);       // Exactly 4 DPS, and either 2 Tanks or 2 Healers, must be present to begin a Solo Shuffle Wargame.

    public final int value;
}
