package com.github.azeroth.game.domain.misc;


import java.util.ArrayList;
import java.util.HashMap;

public class ScriptNameContainer {
    private final HashMap<String, Entry> nameToIndex = new HashMap<>();
    private final ArrayList<Entry> indexToName = new ArrayList<>();

    public ScriptNameContainer() {
        // We insert an empty placeholder here so we can use the
        // script id 0 as dummy for "no script found".
        var id = insert("", false);
    }

    public final int insert(String scriptName, boolean isScriptNameBound) {
        var result = nameToIndex.compute(scriptName, (key, value)-> {
            if(value == null) {
                value = new Entry(nameToIndex.size(), isScriptNameBound, scriptName);
                indexToName.add(value);
            }
            return value;
        });

        return result.id;
    }

    public final int getSize() {
        return indexToName.size();
    }

    public final Entry find(int index) {
        return index < indexToName.size() ? indexToName.get(index) : null;
    }

    public final Entry find(String name) {
        // assume "" is the first element
        if (name.isEmpty()) {
            return null;
        }

        return nameToIndex.get(name);
    }

    public final ArrayList<String> getAllDBScriptNames() {
        ArrayList<String> scriptNames = new ArrayList<>();

        nameToIndex.forEach((k,v) -> {
            if (v.isScriptDatabaseBound) {
                scriptNames.add(v.name);
            }
        });
        return scriptNames;
    }

    public static class Entry {
        public int id;
        public boolean isScriptDatabaseBound;
        public String name;

        public Entry(int id, boolean isScriptDatabaseBound, String name) {
            this.id = id;
            this.isScriptDatabaseBound = isScriptDatabaseBound;
            this.name = name;
        }
    }
}
