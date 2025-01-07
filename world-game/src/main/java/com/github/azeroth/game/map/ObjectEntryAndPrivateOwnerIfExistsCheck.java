package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.object.WorldObject;

class ObjectEntryAndPrivateOwnerIfExistsCheck implements ICheck<WorldObject> {

    private final int entry;
    private final ObjectGuid ownerGUID;


    public ObjectEntryAndPrivateOwnerIfExistsCheck(ObjectGuid ownerGUID, int entry) {
        ownerGUID = ownerGUID;
        entry = entry;
    }

    public final boolean invoke(WorldObject obj) {
        return obj.getEntry() == entry && (!obj.isPrivateObject() || Objects.equals(obj.getPrivateObjectOwner(), ownerGUID));
    }
}
