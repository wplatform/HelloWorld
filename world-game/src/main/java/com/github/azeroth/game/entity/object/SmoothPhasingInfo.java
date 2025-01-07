package com.github.azeroth.game.entity.object;

public class SmoothPhasingInfo {
    // Fields visible on client
    public ObjectGuid replaceObject = null;

    private boolean replaceActive = true;
    private boolean stopAnimKits = true;
    // Serverside fields
    private boolean disabled = false;

    public SmoothPhasingInfo(ObjectGuid replaceObject, boolean replaceActive, boolean stopAnimKits) {
        this.replaceObject = replaceObject;
        setReplaceActive(replaceActive);
        setStopAnimKits(stopAnimKits);
    }

    public final boolean getReplaceActive() {
        return replaceActive;
    }

    public final void setReplaceActive(boolean value) {
        replaceActive = value;
    }

    public final boolean getStopAnimKits() {
        return stopAnimKits;
    }

    public final void setStopAnimKits(boolean value) {
        stopAnimKits = value;
    }

    public final boolean getDisabled() {
        return disabled;
    }

    public final void setDisabled(boolean value) {
        disabled = value;
    }
}
