package com.github.mmo.defines;

import com.github.mmo.common.EnumFlag;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter(onMethod = @__({@Override}))
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum CreatureTypeFlags implements EnumFlag.FlagValue {
    TAMEABLE(0x00000001), // Makes the mob tameable (must also be a beast and have family set)
    VISIBLE_TO_GHOSTS(0x00000002), // Creature is also visible for not alive player. Allows gossip interaction if npcflag allows?
    BOSS_MOB(0x00000004), // Changes creature's visible level to "??" in the creature's portrait - Immune Knockback.
    DO_NOT_PLAY_WOUND_ANIM(0x00000008),
    NO_FACTION_TOOLTIP(0x00000010),
    MORE_AUDIBLE(0x00000020), // Sound related
    SPELL_ATTACKABLE(0x00000040),
    INTERACT_WHILE_DEAD(0x00000080), // Player can interact with the creature if creature is dead (not if player is dead)
    SKIN_WITH_HERBALISM(0x00000100), // Can be looted by herbalist
    SKIN_WITH_MINING(0x00000200), // Can be looted by miner
    NO_DEATH_MESSAGE(0x00000400), // Death event will not show up in combat log
    ALLOW_MOUNTED_COMBAT(0x00000800), // Creature can remain mounted when entering combat
    CAN_ASSIST(0x00001000), // ? Can aid any player in combat if in range?
    NO_PET_BAR(0x00002000),
    MASK_UID(0x00004000),
    SKIN_WITH_ENGINEERING(0x00008000), // Can be looted by engineer
    TAMEABLE_EXOTIC(0x00010000), // Can be tamed by hunter as exotic pet
    USE_MODEL_COLLISION_SIZE(0x00020000), // Collision related. (always using default collision box?)
    ALLOW_INTERACTION_WHILE_IN_COMBAT(0x00040000),
    COLLIDE_WITH_MISSILES(0x00080000), // Projectiles can collide with this creature - interacts with TARGET_DEST_TRAJ
    NO_NAME_PLATE(0x00100000),
    DO_NOT_PLAY_MOUNTED_ANIMATIONS(0x00200000),
    LINK_ALL(0x00400000),
    INTERACT_ONLY_WITH_CREATOR(0x00800000),
    DO_NOT_PLAY_UNIT_EVENT_SOUNDS(0x01000000),
    HAS_NO_SHADOW_BLOB(0x02000000),
    TREAT_AS_RAID_UNIT(0x04000000), //!< Creature can be targeted by spells that require target to be in caster's party/raid
    FORCE_GOSSIP(0x08000000), // Allows the creature to display a single gossip option.
    DO_NOT_SHEATHE(0x10000000),
    DO_NOT_TARGET_ON_INTERACTION(0x20000000),
    DO_NOT_RENDER_OBJECT_NAME(0x40000000),
    QUEST_BOSS(0x80000000);  // Not verified
    public final int value;
}
