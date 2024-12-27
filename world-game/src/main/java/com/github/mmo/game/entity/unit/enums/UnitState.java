package com.github.mmo.game.entity.unit.enums;

import com.github.mmo.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter(onMethod = @__({@Override}))
@RequiredArgsConstructor
public enum  UnitState implements EnumFlag.FlagValue {
    DIED(0x00000001), // player has fake death aura
    MELEE_ATTACKING(0x00000002), // player is melee attacking someone
    CHARMED(0x00000004), // having any kind of charm aura on self
    STUNNED(0x00000008),
    ROAMING(0x00000010),
    CHASE(0x00000020),
    FOCUSING(0x00000040),
    FLEEING(0x00000080),
    IN_FLIGHT(0x00000100), // player is in flight mode
    FOLLOW(0x00000200),
    ROOT(0x00000400),
    CONFUSED(0x00000800),
    DISTRACTED(0x00001000),
    ISOLATED(0x00002000), // area auras do not affect other players
    ATTACK_PLAYER(0x00004000),
    CASTING(0x00008000),
    POSSESSED(0x00010000), // being possessed by another unit
    CHARGING(0x00020000),
    JUMPING(0x00040000),
    FOLLOW_FORMATION(0x00080000),
    MOVE(0x00100000),
    ROTATING(0x00200000),
    EVADE(0x00400000),
    ROAMING_MOVE(0x00800000),
    CONFUSED_MOVE(0x01000000),
    FLEEING_MOVE(0x02000000),
    CHASE_MOVE(0x04000000),
    FOLLOW_MOVE(0x08000000),
    IGNORE_PATHFINDING(0x10000000), // do not use pathfinding in any MovementGenerator
    FOLLOW_FORMATION_MOVE(0x20000000),

    ALL_STATE_SUPPORTED(DIED.value | MELEE_ATTACKING.value | CHARMED.value | STUNNED.value | ROAMING.value | CHASE
            .value | FOCUSING.value | FLEEING.value | IN_FLIGHT.value | FOLLOW.value | ROOT.value | CONFUSED
            .value | DISTRACTED.value | ISOLATED.value | ATTACK_PLAYER.value | CASTING
            .value | POSSESSED.value | CHARGING.value | JUMPING.value | MOVE.value | ROTATING
            .value | EVADE.value | ROAMING_MOVE.value | CONFUSED_MOVE.value | FLEEING_MOVE
            .value | CHASE_MOVE.value | FOLLOW_MOVE.value | IGNORE_PATHFINDING.value | FOLLOW_FORMATION_MOVE.value),

    UNATTACKABLE(IN_FLIGHT.value),
    MOVING(ROAMING_MOVE.value | CONFUSED_MOVE.value | FLEEING_MOVE.value | CHASE_MOVE.value | FOLLOW_MOVE.value | FOLLOW_FORMATION_MOVE.value),
    CONTROLLED(CONFUSED.value | STUNNED.value | FLEEING.value),
    LOST_CONTROL(CONTROLLED.value | POSSESSED.value | JUMPING.value | CHARGING.value),
    CANNOT_AUTOATTACK(CONTROLLED.value | CHARGING.value),
    SIGHTLESS(LOST_CONTROL.value | EVADE.value),
    CANNOT_TURN(LOST_CONTROL.value | ROTATING.value | FOCUSING.value),
    NOT_MOVE(ROOT.value | STUNNED.value | DIED.value | DISTRACTED.value),

    ALL_ERASABLE(ALL_STATE_SUPPORTED.value & ~(IGNORE_PATHFINDING.value)),
    ALL_STATE(0xffffffff);


    public final int value;
}
