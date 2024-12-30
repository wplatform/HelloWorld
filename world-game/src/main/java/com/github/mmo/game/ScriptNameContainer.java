package com.github.mmo.game;


import java.util.ArrayList;
import java.util.HashMap;

class ScriptNameContainer {
    private final HashMap<String, entry> nameToIndex = new HashMap<String, entry>();
    private final ArrayList<entry> indexToName = new ArrayList<>();

    public scriptNameContainer() {
        // We insert an empty placeholder here so we can use the
        // script id 0 as dummy for "no script found".
        var id = insert("", false);
    }

    public final int insert(String scriptName, boolean isScriptNameBound) {
        Entry entry = new entry((int) nameToIndex.size(), isScriptNameBound, scriptName);
        var result = nameToIndex.TryAdd(scriptName, entry);

        if (result) {
            indexToName.add(entry);
        }

        return nameToIndex.get(scriptName).id;
    }

    public final int getSize() {
        return indexToName.size();
    }

    public final Entry find(int index) {
        return index < indexToName.size() ? indexToName.get((int) index) : null;
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

// C# TO JAVA CONVERTER TASK: Java has no equivalent to C# deconstruction declarations:
        for (var(name, entry) : nameToIndex) {
            if (entry.isScriptDatabaseBound) {
                scriptNames.add(name);
            }
        }

        return scriptNames;
    }

    public static class Entry {
        public int id;
        public boolean isScriptDatabaseBound;
        public String name;

        public entry(int id, boolean isScriptDatabaseBound, String name) {
            id = id;
            isScriptDatabaseBound = isScriptDatabaseBound;
            name = name;
        }
    }
}
