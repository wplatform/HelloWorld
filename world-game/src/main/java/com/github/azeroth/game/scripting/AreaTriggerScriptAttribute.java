package com.github.azeroth.game.scripting;

public class AreaTriggerScriptAttribute extends ScriptAttribute {

    private int[] areaTriggerIds;


    public AreaTriggerScriptAttribute(Integer... areaTriggerId) {
        super("", new Object[0]);
        setAreaTriggerIds(areaTriggerId);
    }

    public AreaTriggerScriptAttribute(String name) {
        this(name, );
    }

    public AreaTriggerScriptAttribute(String name, object... args) {
        super(name, args);
    }


    public AreaTriggerScriptAttribute(int areaTriggerId, String name) {
        this(areaTriggerId, name, );
    }

    public AreaTriggerScriptAttribute(int areaTriggerId, String name, object... args) {
        super(name, args);
        setAreaTriggerIds(new int[]{areaTriggerId});
    }


    public AreaTriggerScriptAttribute(int[] areaTriggerId, String name) {
        this(areaTriggerId, name, );
    }

    public AreaTriggerScriptAttribute(int[] areaTriggerId, String name, object... args) {
        super(name, args);
        setAreaTriggerIds(areaTriggerId);
    }


    public final int[] getAreaTriggerIds() {
        return areaTriggerIds;
    }


    private void setAreaTriggerIds(int[] value) {
        areaTriggerIds = value;
    }
}
