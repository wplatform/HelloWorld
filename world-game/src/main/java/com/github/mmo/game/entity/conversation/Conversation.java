package com.github.mmo.game.entity.conversation;


import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.entity.object.Position;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.map.grid.GridObject;
import com.github.mmo.game.map.grid.GridReference;
import game.maps.*;
import game.spells.*;
import lombok.Getter;

import java.time.Duration;
import java.util.*;



public class Conversation extends WorldObject implements GridObject<Conversation> {

    @Getter
    private final GridReference<Conversation> gridReference = new GridReference<>();

    private final ConversationData mConversationData;
    private final Position stationaryPosition = new Position();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: readonly Dictionary<(Locale locale, uint lineId), TimeSpan> _lineStartTimes = new();
    private final HashMap<(Locale locale, int lineId), TimeSpan> lineStartTimes = new HashMap<(Locale locale, int lineId), TimeSpan>();
    private final TimeSpan[] lastLineEndTimes = new TimeSpan[Locale.Total.getValue()];
    private ObjectGuid creatorGuid = ObjectGuid.EMPTY;
    private Duration duration;
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: uint _textureKitId;
    private int textureKitId;

    @Override
    public ObjectGuid getOwnerGUID() {
        return getCreatorGuid();
    }

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public override uint getFaction()
    @Override
    public int getFaction() {
        return 0;
    }

    @Override
    public float getStationaryX() {
        return stationaryPosition.x;
    }

    @Override
    public float getStationaryY() {
        return stationaryPosition.y;
    }

    @Override
    public float getStationaryZ() {
        return stationaryPosition.z;
    }

    @Override
    public float getStationaryO() {
        return stationaryPosition.getOrientation();
    }

    public Conversation() {
        super(false);
        objectTypeMask = TypeMask.forValue(objectTypeMask.getValue() | TypeMask.Conversation.getValue());
        objectTypeId = TypeId.Conversation;

        updateFlag.stationary = true;
        updateFlag.conversation = true;

        mConversationData = new ConversationData();
    }

    @Override
    public void addToWorld() {
        //- Register the Conversation for guid lookup and for caster
        if (!isInWorld) {
//C# TO JAVA CONVERTER TODO TASK: There is no Java ConcurrentHashMap equivalent to this .NET ConcurrentDictionary method:
            getMap().getObjectsStore().TryAdd(getGUID().clone(), this);
            super.addToWorld();
        }
    }

    @Override
    public void removeFromWorld() {
        //- Remove the Conversation from the accessor and from all lists of objects in world
        if (isInWorld) {
            super.removeFromWorld();
            tangible.OutObject<WorldObject> tempOut__ = new tangible.OutObject<WorldObject>();
//C# TO JAVA CONVERTER TODO TASK: There is no Java ConcurrentHashMap equivalent to this .NET ConcurrentDictionary method:
            getMap().getObjectsStore().TryRemove(getGUID().clone(), tempOut__);
        _ = tempOut__.outArgValue;
        }
    }

//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: public override void Update(uint diff)
    @Override
    public void update(int diff) {
        if (getDuration() > TimeSpan.FromMilliseconds(diff)) {
            duration -= TimeSpan.FromMilliseconds(diff);

            doWithSuppressingObjectUpdates(() -> {
                    // Only sent in CreateObject
                    ApplyModUpdateFieldValue(values.modifyValue(mConversationData).modifyValue(mConversationData.progress), diff, true);
                    mConversationData.clearChanged(mConversationData.progress);
            });
        } else {
            remove(); // expired

            return;
        }

        super.update(diff);
    }