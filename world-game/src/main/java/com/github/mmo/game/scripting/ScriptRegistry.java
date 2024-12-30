package com.github.mmo.game.scripting;

import com.github.mmo.game.scripting.interfaces.IScriptObject;

import java.util.HashMap;
import java.util.Objects;


public class ScriptRegistry {
    private final HashMap<Integer, IScriptObject> scriptMap = new HashMap<Integer, IScriptObject>();

    // Counter used for code-only scripts.
    private int scriptIdCounter;

    public final void addScript(IScriptObject script) {
        if (!script.isDatabaseBound()) {
            // We're dealing with a code-only script; just add it.
            tangible.RefObject<Long> tempRef__scriptIdCounter = new tangible.RefObject<Long>(scriptIdCounter);
            scriptMap.put(Interlocked.Increment(tempRef__scriptIdCounter), script);
            scriptIdCounter = tempRef__scriptIdCounter.refArgValue;
            global.getScriptMgr().incrementScriptCount();

            return;
        }

        // Get an ID for the script. An ID only exists if it's a script that is assigned in the database
        // through a script name (or similar).
        var id = global.getObjectMgr().getScriptId(script.getName());

        if (id != 0) {
            // Try to find an existing script.
            var existing = false;

            synchronized (scriptMap) {
                if (scriptMap.values().contains(script)) // its already in here
                {
                    return;
                }

                for (var it : scriptMap.entrySet()) {
                    if (Objects.equals(it.getValue().getName(), script.getName())) {
                        existing = true;

                        break;
                    }
                }
            }

            // If the script isn't assigned . assign it!
            if (!existing) {
                synchronized (scriptMap) {
                    scriptMap.put(id, script);
                }

                global.getScriptMgr().incrementScriptCount();
            }
        } else {
            // The script uses a script Name from database, but isn't assigned to anything.
            Log.outError(LogFilter.ServerLoading, "Script named '{0}' does not have a script Name assigned in database.", script.getName());
        }
    }

    // Gets a script by its ID (assigned by ObjectMgr).
    public final <T extends IScriptObject> T getScriptById(int id) {
        synchronized (scriptMap) {
            return (T) scriptMap.get(id);
        }
    }

    public final boolean empty() {
        synchronized (scriptMap) {
            return scriptMap.isEmpty();
        }
    }

    public final void unload() {
        synchronized (scriptMap) {
            scriptMap.clear();
        }
    }
}
