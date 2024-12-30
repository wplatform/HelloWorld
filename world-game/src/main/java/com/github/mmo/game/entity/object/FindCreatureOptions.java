package com.github.mmo.game.entity.object;

public final class FindCreatureOptions {
    public Integer creatureId = null;
    public String stringId;
    public Boolean isAlive = null;
    public Boolean isInCombat = null;
    public Boolean isSummon = null;
    public boolean ignorePhases;
    public boolean ignoreNotOwnedPrivateObjects;
    public boolean ignorePrivateObjects;
    public Integer auraSpellId = null;
    public ObjectGuid ownerGuid = null;
    public ObjectGuid charmerGuid = null;
    public ObjectGuid creatorGuid = null;
    public ObjectGuid demonCreatorGuid = null;
    public ObjectGuid privateObjectOwnerGuid = null;

    public FindCreatureOptions setCreatureId(int creatureId) {
        creatureId = creatureId;

        return this;
    }

    public FindCreatureOptions setStringId(String stringId) {
        stringId = stringId;

        return this;
    }

    public FindCreatureOptions setIsAlive(boolean isAlive) {
        isAlive = isAlive;

        return this;
    }

    public FindCreatureOptions setIsInCombat(boolean isInCombat) {
        isInCombat = isInCombat;

        return this;
    }

    public FindCreatureOptions setIsSummon(boolean isSummon) {
        isSummon = isSummon;

        return this;
    }

    public FindCreatureOptions setIgnorePhases(boolean ignorePhases) {
        ignorePhases = ignorePhases;

        return this;
    }

    public FindCreatureOptions setIgnoreNotOwnedPrivateObjects(boolean ignoreNotOwnedPrivateObjects) {
        ignoreNotOwnedPrivateObjects = ignoreNotOwnedPrivateObjects;

        return this;
    }

    public FindCreatureOptions setIgnorePrivateObjects(boolean ignorePrivateObjects) {
        ignorePrivateObjects = ignorePrivateObjects;

        return this;
    }

    public FindCreatureOptions setHasAura(int spellId) {
        auraSpellId = spellId;

        return this;
    }

    public FindCreatureOptions setOwner(ObjectGuid ownerGuid) {
        ownerGuid = ownerGuid;

        return this;
    }

    public FindCreatureOptions setCharmer(ObjectGuid charmerGuid) {
        charmerGuid = charmerGuid;

        return this;
    }

    public FindCreatureOptions setCreator(ObjectGuid creatorGuid) {
        creatorGuid = creatorGuid;

        return this;
    }

    public FindCreatureOptions setDemonCreator(ObjectGuid demonCreatorGuid) {
        demonCreatorGuid = demonCreatorGuid;

        return this;
    }

    public FindCreatureOptions setPrivateObjectOwner(ObjectGuid privateObjectOwnerGuid) {
        privateObjectOwnerGuid = privateObjectOwnerGuid;

        return this;
    }

    public FindCreatureOptions clone() {
        FindCreatureOptions varCopy = new FindCreatureOptions();

        varCopy.creatureId = this.creatureId;
        varCopy.stringId = this.stringId;
        varCopy.isAlive = this.isAlive;
        varCopy.isInCombat = this.isInCombat;
        varCopy.isSummon = this.isSummon;
        varCopy.ignorePhases = this.ignorePhases;
        varCopy.ignoreNotOwnedPrivateObjects = this.ignoreNotOwnedPrivateObjects;
        varCopy.ignorePrivateObjects = this.ignorePrivateObjects;
        varCopy.auraSpellId = this.auraSpellId;
        varCopy.ownerGuid = this.ownerGuid;
        varCopy.charmerGuid = this.charmerGuid;
        varCopy.creatorGuid = this.creatorGuid;
        varCopy.demonCreatorGuid = this.demonCreatorGuid;
        varCopy.privateObjectOwnerGuid = this.privateObjectOwnerGuid;

        return varCopy;
    }
}
