package com.github.mmo.game.entity.creatures;


public class StaticCreatureFlags {
    private CreatureStaticFlags flags = CreatureStaticFlags.values()[0];
    private CreatureStaticFlags2 flags2 = CreatureStaticFlags2.values()[0];
    private CreatureStaticFlags3 flags3 = CreatureStaticFlags3.values()[0];
    private CreatureStaticFlags4 flags4 = CreatureStaticFlags4.values()[0];
    private CreatureStaticFlags5 flags5 = CreatureStaticFlags5.values()[0];
    private CreatureStaticFlags6 flags6 = CreatureStaticFlags6.values()[0];
    private CreatureStaticFlags7 flags7 = CreatureStaticFlags7.values()[0];
    private CreatureStaticFlags8 flags8 = CreatureStaticFlags8.values()[0];

    public final boolean hasFlag(CreatureStaticFlags flag) {
        return flags.hasFlag(flag);
    }

    public final boolean hasFlag(CreatureStaticFlags2 flag) {
        return flags2.hasFlag(flag);
    }

    public final boolean hasFlag(CreatureStaticFlags3 flag) {
        return flags3.hasFlag(flag);
    }

    public final boolean hasFlag(CreatureStaticFlags4 flag) {
        return flags4.hasFlag(flag);
    }

    public final boolean hasFlag(CreatureStaticFlags5 flag) {
        return flags5.hasFlag(flag);
    }

    public final boolean hasFlag(CreatureStaticFlags6 flag) {
        return flags6.hasFlag(flag);
    }

    public final boolean hasFlag(CreatureStaticFlags7 flag) {
        return flags7.hasFlag(flag);
    }

    public final boolean hasFlag(CreatureStaticFlags8 flag) {
        return flags8.hasFlag(flag);
    }


    public final CreatureStaticFlags modifyFlag(CreatureStaticFlags flag) {
        return modifyFlag(flag, true);
    }

    public final CreatureStaticFlags modifyFlag(CreatureStaticFlags flag, boolean apply) {
        return apply ? flags = flags.getValue() | flag.getValue() : flags = CreatureStaticFlags.forValue(flags.getValue() & ~flag.getValue());
    }

    public final CreatureStaticFlags2 modifyFlag(CreatureStaticFlags2 flag) {
        return modifyFlag(flag, true);
    }

    public final CreatureStaticFlags2 modifyFlag(CreatureStaticFlags2 flag, boolean apply) {
        return apply ? flags2 = flags2.getValue() | flag.getValue() : flags2 = CreatureStaticFlags2.forValue(flags2.getValue() & ~flag.getValue());
    }

    public final CreatureStaticFlags3 modifyFlag(CreatureStaticFlags3 flag) {
        return modifyFlag(flag, true);
    }

    public final CreatureStaticFlags3 modifyFlag(CreatureStaticFlags3 flag, boolean apply) {
        return apply ? flags3 = flags3.getValue() | flag.getValue() : flags3 = CreatureStaticFlags3.forValue(flags3.getValue() & ~flag.getValue());
    }

    public final CreatureStaticFlags4 modifyFlag(CreatureStaticFlags4 flag) {
        return modifyFlag(flag, true);
    }

    public final CreatureStaticFlags4 modifyFlag(CreatureStaticFlags4 flag, boolean apply) {
        return apply ? flags4 = flags4.getValue() | flag.getValue() : flags4 = CreatureStaticFlags4.forValue(flags4.getValue() & ~flag.getValue());
    }

    public final CreatureStaticFlags5 modifyFlag(CreatureStaticFlags5 flag) {
        return modifyFlag(flag, true);
    }

    public final CreatureStaticFlags5 modifyFlag(CreatureStaticFlags5 flag, boolean apply) {
        return apply ? flags5 = flags5.getValue() | flag.getValue() : flags5 = CreatureStaticFlags5.forValue(flags5.getValue() & ~flag.getValue());
    }

    public final CreatureStaticFlags6 modifyFlag(CreatureStaticFlags6 flag) {
        return modifyFlag(flag, true);
    }

    public final CreatureStaticFlags6 modifyFlag(CreatureStaticFlags6 flag, boolean apply) {
        return apply ? flags6 = flags6.getValue() | flag.getValue() : flags6 = CreatureStaticFlags6.forValue(flags6.getValue() & ~flag.getValue());
    }

    public final CreatureStaticFlags7 modifyFlag(CreatureStaticFlags7 flag) {
        return modifyFlag(flag, true);
    }

    public final CreatureStaticFlags7 modifyFlag(CreatureStaticFlags7 flag, boolean apply) {
        return apply ? flags7 = flags7.getValue() | flag.getValue() : flags7 = CreatureStaticFlags7.forValue(flags7.getValue() & ~flag.getValue());
    }

    public final CreatureStaticFlags8 modifyFlag(CreatureStaticFlags8 flag) {
        return modifyFlag(flag, true);
    }

    public final CreatureStaticFlags8 modifyFlag(CreatureStaticFlags8 flag, boolean apply) {
        return apply ? flags8 = flags8.getValue() | flag.getValue() : flags8 = CreatureStaticFlags8.forValue(flags8.getValue() & ~flag.getValue());
    }
}
