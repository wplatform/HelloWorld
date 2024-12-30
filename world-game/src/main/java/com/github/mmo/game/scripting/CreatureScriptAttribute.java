package com.github.mmo.game.scripting;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
public class CreatureScriptAttribute extends ScriptAttribute {
    private int[] creatureIds;

    public CreatureScriptAttribute(Integer... creatureIds) {
        setCreatureIds(creatureIds);
    }

    public CreatureScriptAttribute(String name) {
        this(name, );
    }

    public CreatureScriptAttribute(String name, object... args) {
        super(name, args);
    }


    public CreatureScriptAttribute(int creatureId, String name) {
        this(creatureId, name, );
    }

    public CreatureScriptAttribute(int creatureId, String name, object... args) {
        super(name, args);
        setCreatureIds(new int[]{creatureId});
    }


    public CreatureScriptAttribute(int[] creatureIds, String name) {
        this(creatureIds, name, );
    }

    public CreatureScriptAttribute(int[] creatureIds, String name, object... args) {
        super(name, args);
        setCreatureIds(creatureIds);
    }

    public final int[] getCreatureIds() {
        return creatureIds;
    }

    private void setCreatureIds(int[] value) {
        creatureIds = value;
    }
}
