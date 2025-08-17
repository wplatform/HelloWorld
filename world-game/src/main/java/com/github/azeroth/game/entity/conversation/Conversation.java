package com.github.azeroth.game.entity.conversation;


import com.github.azeroth.game.domain.object.ObjectGuid;
import com.github.azeroth.game.domain.object.Position;
import com.github.azeroth.game.entity.object.WorldObject;



import java.time.Duration;
import java.util.Locale;


public class Conversation extends WorldObject {

    private final ConversationData mConversationData;
    private final Position stationaryPosition = new Position();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: readonly Dictionary<(Locale locale, uint lineId), TimeSpan> _lineStartTimes = new();
    private final HashMap<(
        private final TimeSpan[] lastLineEndTimes = new TimeSpan[Locale.Total.getValue()];, Locale locale),TimeSpan>lineStartTimes =new HashMap<(
    int lineId, Locale locale),TimeSpan>();
int lineId
    private ObjectGuid creatorGuid = ObjectGuid.EMPTY;
    private Duration duration;
    //C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: uint _textureKitId;
    private int textureKitId;

    public Conversation() {
        super(false);
        objectTypeMask = TypeMask.forValue(objectTypeMask.getValue() | TypeMask.Conversation.getValue());
        objectTypeId = TypeId.Conversation;

        updateFlag.stationary = true;
        updateFlag.conversation = true;

        mConversationData = new ConversationData();
    }

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