package com.github.azeroth.game.map;

import com.github.azeroth.game.entity.object.WorldObject;

public class ObjectGUIDCheck implements ICheck<WorldObject> {
    private final ObjectGuid gUID;

    public ObjectGUIDCheck(ObjectGuid GUID) {
        gUID = GUID;
    }

    public final boolean invoke(WorldObject obj) {
        return Objects.equals(obj.getGUID(), gUID);
    }

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator Predicate<WorldObject>(ObjectGUIDCheck check)
//		{
//			return check.Invoke;
//		}
}
