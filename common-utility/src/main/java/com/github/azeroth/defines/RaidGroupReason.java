package com.github.azeroth.defines;

public enum RaidGroupReason {
    RAID_GROUP_ERR_NONE,
    RAID_GROUP_ERR_LOWLEVEL, // "You are too low level to enter this instance."
    RAID_GROUP_ERR_ONLY, // "You must be in a raid group to enter this instance."
    RAID_GROUP_ERR_FULL, // "The instance is full."
    RAID_GROUP_ERR_REQUIREMENTS_UNMATCH   // "You do not meet the requirements to enter this instance."
}
