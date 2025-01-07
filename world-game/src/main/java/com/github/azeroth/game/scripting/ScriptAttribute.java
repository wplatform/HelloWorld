package com.github.azeroth.game.scripting;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
public class ScriptAttribute extends Attribute {
    private String name;
    private Object[] args;

    public ScriptAttribute(String name) {
        this(name, );
    }

    public ScriptAttribute(String name, object... args) {
        setName(name);
        setArgs(args);
    }

    public final String getName() {
        return name;
    }

    private void setName(String value) {
        name = value;
    }

    public final Object[] getArgs() {
        return args;
    }

    private void setArgs(Object[] value) {
        args = value;
    }
}
