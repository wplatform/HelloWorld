package com.github.azeroth.game.entity.object;


import Time.GameTime;
import com.badlogic.gdx.utils.ByteArray;
import com.badlogic.gdx.utils.IntArray;
import com.github.azeroth.common.Assert;
import com.github.azeroth.common.EnumFlag;
import com.github.azeroth.defines.Power;
import com.github.azeroth.defines.UnitDynFlag;
import com.github.azeroth.exeception.ValueOverflowException;
import com.github.azeroth.game.entity.areatrigger.AreaTrigger;
import com.github.azeroth.game.entity.areatrigger.model.AreaTriggerCreatePropertiesFlag;
import com.github.azeroth.game.entity.conversation.Conversation;
import com.github.azeroth.game.entity.corpse.Corpse;
import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.creature.TempSummon;
import com.github.azeroth.game.entity.dynamic.DynamicObject;
import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.entity.item.Item;
import com.github.azeroth.game.entity.object.enums.TypeId;
import com.github.azeroth.game.entity.object.enums.TypeMask;
import com.github.azeroth.game.entity.object.update.*;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.entity.scene.SceneObject;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.domain.unit.MovementFlag;
import com.github.azeroth.game.domain.unit.UnitMoveType;
import com.github.azeroth.game.movement.model.MovementInfo;
import com.github.azeroth.game.movement.model.TransportInfo;
import com.github.azeroth.game.networking.WorldPacket;
import com.github.azeroth.game.networking.packet.movement.MovementIOUtil;
import com.github.azeroth.game.spell.auras.enums.AuraType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import lombok.Getter;
import lombok.Setter;

import java.nio.ByteBuffer;
import java.util.Objects;

import static com.github.azeroth.game.entity.object.update.ObjectFields.*;
import static com.github.azeroth.game.entity.object.update.UpdateFieldFlags.*;


@Getter
@Setter
public abstract class GenericObject {


    protected static final byte FIELD_BYTE_OFFSET_0 = 0;
    protected static final byte FIELD_BYTE_OFFSET_1 = 1;
    protected static final byte FIELD_BYTE_OFFSET_2 = 2;
    protected static final byte FIELD_BYTE_OFFSET_3 = 3;
    protected static final byte FIELD_SHORT_OFFSET_0 = 0;
    protected static final byte FIELD_SHORT_OFFSET_1 = 1;
    private static final int DYNAMIC_FIELD_UNCHANGED = 0;
    private static final int DYNAMIC_FIELD_VALUE_CHANGED = 0x7FFF;
    private static final int DYNAMIC_FIELD_VALUE_AND_SIZE_CHANGED = 0x8000;
    private final short objectType;
    private final TypeId typeId;
    private final int updateFlag;
    private final int[] int32Values;
    private final IntArray[] dynamicValues;
    private final short valuesCount;
    private final short dynamicValuesCount;
    protected UpdateMask changesMask;
    protected int[] dynamicChangesMask;
    protected MovementInfo movementInfo;
    boolean objectUpdated;
    private boolean inWorld;
    private boolean newObject;
    private boolean destroyedObject;
    private ByteArray[] dynamicChangesArrayMask;
    private int fieldNotifyFlags;


    protected GenericObject(ObjectGuid guid, short valuesCount, short dynamicValuesCount, EnumFlag<TypeMask> objectType, TypeId typeId, EnumFlag<ObjectUpdateFlag> updateFlag) {

        this.valuesCount = valuesCount;
        this.dynamicValuesCount = dynamicValuesCount;
        this.int32Values = new int[valuesCount];
        this.changesMask = new UpdateMask();
        this.changesMask.setCount(valuesCount);
        this.dynamicValues = new IntArray[dynamicValuesCount];
        this.dynamicChangesMask = new int[dynamicValuesCount];
        this.dynamicChangesArrayMask = new ByteArray[dynamicValuesCount];
        this.typeId = typeId;
        this.objectType = (short) objectType.getFlag();
        this.updateFlag = updateFlag.getFlag();
        this.objectUpdated = false;


        setGuidValue(OBJECT_FIELD_GUID, guid);
        setInt16Value(OBJECT_FIELD_TYPE, FIELD_SHORT_OFFSET_0, this.objectType);


        fieldNotifyFlags = UF_FLAG_DYNAMIC;

        inWorld = false;
        newObject = false;
        destroyedObject = false;
        objectUpdated = false;

    }

    private static float applyPercentModFloatVar(float var, float val, boolean apply) {
        if (val == -100.0f)     // prevent set var to zero
            val = -99.99f;
        return var * (apply ? (100.0f + val) / 100.0f : 100.0f / (100.0f + val));
    }

    protected abstract void addToWorld();

    protected abstract void removeFromWorld();

    public final ObjectGuid getGUID() {
        return getGuidValue(OBJECT_FIELD_GUID);
    }

    public final int getEntry() {
        return getUInt32Value(OBJECT_FIELD_ENTRY);
    }

    public final void setEntry(int entry) {
        setInt32Value(OBJECT_FIELD_ENTRY, entry);
    }

    public final float getObjectScale() {
        return getFloatValue(OBJECT_FIELD_SCALE_X);
    }

    public final void setObjectScale(float scale) {
        setFloatValue(OBJECT_FIELD_SCALE_X, scale);
    }

    protected final int getDynamicFlags() {
        return getInt32Value(OBJECT_DYNAMIC_FLAGS);
    }

    protected final boolean hasDynamicFlag(int flag) {
        return hasFlag(OBJECT_DYNAMIC_FLAGS, flag);
    }

    protected final void setDynamicFlag(int flag) {
        setFlag(OBJECT_DYNAMIC_FLAGS, flag);
    }

    protected final void removeDynamicFlag(int flag) {
        removeFlag(OBJECT_DYNAMIC_FLAGS, flag);
    }

    protected final void replaceAllDynamicFlags(int flag) {
        setInt32Value(OBJECT_DYNAMIC_FLAGS, flag);
    }

    protected final boolean isType(TypeMask mask) {
        return (mask.value & objectType) != 0;
    }

    protected void buildCreateUpdateBlockForPlayer(UpdateData data, Player target) {
        if (target == null) return;

        ObjectUpdateType updateType = newObject ? ObjectUpdateType.CREATE_OBJECT2 : ObjectUpdateType.CREATE_OBJECT;
        EnumFlag<ObjectUpdateFlag> flags = EnumFlag.of(ObjectUpdateFlag.class, updateFlag);
        // building packet for yourself
        if (target == this) {
            flags.addFlag(ObjectUpdateFlag.SELF);
        }

        switch (getGUID().highGuid()) {
            case Player:
            case Pet:
            case Corpse:
            case DynamicObject:
            case AreaTrigger:
            case Conversation:
            case SceneObject:
                updateType = ObjectUpdateType.CREATE_OBJECT2;
                break;
            case Creature:
            case Vehicle: {
                if (this instanceof TempSummon summon) {
                    if (summon.getSummonerGUID().isPlayer()) updateType = ObjectUpdateType.CREATE_OBJECT2;
                }


                break;
            }
            case GameObject: {
                if (toGameObject().getOwnerGUID().isPlayer()) updateType = ObjectUpdateType.CREATE_OBJECT2;
                break;
            }
            default:
                break;
        }

        if (this instanceof WorldObject worldObject) {
            if (!flags.hasFlag(ObjectUpdateFlag.LIVING)) {
                TransportInfo transport = worldObject.movementInfo.getTransport();
                if (transport != null && !transport.getGuid().isEmpty())
                    flags.addFlag(ObjectUpdateFlag.TRANSPORT_POSITION);
            }

            if (worldObject.getAIAnimKitId() != 0f || worldObject.getMovementAnimKitId() != 0f || worldObject.getMeleeAnimKitId() != 0f)
                flags.addFlag(ObjectUpdateFlag.ANIM_KITS);
        }

        if (flags.hasFlag(ObjectUpdateFlag.STATIONARY_POSITION)) {
            // UPDATETYPE_CREATE_OBJECT2 for some gameobject types...
            if (isType(TypeMask.GAME_OBJECT)) {
                switch (toGameObject().getGoType()) {
                    case TRAP:
                    case DUEL_ARBITER:
                    case FLAG_STAND:
                    case FLAG_DROP:
                        updateType = ObjectUpdateType.CREATE_OBJECT2;
                        break;
                    default:
                        break;
                }
            }
        }

        if (this instanceof Unit unit && unit.getVictim() != null) {
            flags.addFlag(ObjectUpdateFlag.HAS_TARGET);
        }


        WorldPacket buff = WorldPacket.wrap(ByteBufAllocator.DEFAULT.buffer(0x400));

        buff.writeInt8(updateType.ordinal());
        buff.writeGuid(getGUID());
        buff.writeInt8(typeId.ordinal());

        buildMovementUpdate(buff, flags, target);
        buildValuesUpdate(updateType, buff, target);
        buildDynamicValuesUpdate(updateType, buff, target);
        data.addUpdateBlock(buff);

    }

    public final void sendUpdateToPlayer(Player player) {
        // send create update to player
        UpdateData upd = new UpdateData(player.getLocation().getMapId());

        if (player.haveAtClient(this)) {
            buildValuesUpdateBlockForPlayer(upd, player);
        } else {
            buildCreateUpdateBlockForPlayer(upd, player);
        }

        WorldPacket packet = upd.buildPacket();

        player.sendPacket(packet);
    }

    public final void buildValuesUpdateBlockForPlayer(UpdateData data, Player target) {

        WorldPacket buffer = WorldPacket.wrap(ByteBufAllocator.DEFAULT.buffer(0x400));
        buffer.writeInt8(ObjectUpdateType.VALUES.ordinal());
        buffer.writeGuid(getGUID());

        buildValuesUpdate(ObjectUpdateType.VALUES, buffer, target);
        buildDynamicValuesUpdate(ObjectUpdateType.VALUES, buffer, target);

        data.addUpdateBlock(buffer);
    }

    void buildValuesUpdate(ObjectUpdateType updateType, WorldPacket data, Player target) {
        if (target == null) return;

        int[] flags = getUpdateFieldFlagsFor(target);
        int visibleFlag = getUpdateVisibleFlagFor(target);
        UpdateMaskPacketBuilder updateMask = new UpdateMaskPacketBuilder(valuesCount);
        ByteBuffer fieldBuffer = ByteBuffer.allocate(4 * valuesCount);
        for (int index = 0; index < valuesCount; index++) {
            if ((fieldNotifyFlags & flags[index]) != 0 || (updateType == ObjectUpdateType.VALUES ? changesMask.getBit(index) : int32Values[index] != 0 && (flags[index] & visibleFlag) != 0)) {
                updateMask.setBit(index);
                fieldBuffer.putInt(int32Values[index]);
            }
        }
        updateMask.appendToPacket(data);
        data.writeBytes(fieldBuffer);

    }

    private int[] getUpdateFieldFlagsFor(Player target) {
        return switch (typeId) {
            case ITEM, CONTAINER -> ITEM_UPDATE_FIELD_FLAGS;
            case UNIT, PLAYER -> UNIT_UPDATE_FIELD_FLAGS;
            case GAME_OBJECT -> GAME_OBJECT_UPDATE_FIELD_FLAGS;
            case DYNAMIC_OBJECT -> DYNAMIC_OBJECT_UPDATE_FIELD_FLAGS;
            case CORPSE -> CORPSE_UPDATE_FIELD_FLAGS;
            case AREA_TRIGGER -> AREA_TRIGGER_UPDATE_FIELD_FLAGS;
            case SCENE_OBJECT -> SCENE_OBJECT_UPDATE_FIELD_FLAGS;
            case CONVERSATION -> CONVERSATION_UPDATE_FIELD_FLAGS;
            default -> throw new IllegalStateException("Unexpected value: " + typeId);
        };
    }

    private int getUpdateVisibleFlagFor(Player target) {
        int visibleFlag = UF_FLAG_PUBLIC;

        if (target == this) visibleFlag |= UF_FLAG_PRIVATE;

        switch (typeId) {
            case ITEM, CONTAINER -> {
                if (this instanceof Item item && Objects.equals(item.getOwnerGUID(), target.getGUID())) {
                    visibleFlag |= UF_FLAG_OWNER | UF_FLAG_ITEM_OWNER;
                }
            }
            case UNIT, PLAYER -> {
                Player plr = toUnit().getCharmerOrOwnerPlayerOrPlayerItself();
                if (Objects.equals(toUnit().getOwnerGUID(), target.getGUID())) {

                    visibleFlag |= UF_FLAG_OWNER;
                }

                if (hasFlag(OBJECT_DYNAMIC_FLAGS, UnitDynFlag.SPECIAL_INFO) && toUnit().hasAuraTypeWithCaster(AuraType.EMPATHY, target.getGUID()))
                    visibleFlag |= UF_FLAG_SPECIAL_INFO;

                if (plr != null && plr.isInSameRaidWith(target)) visibleFlag |= UF_FLAG_PARTY_MEMBER;
            }
            case GAME_OBJECT -> {
                if (Objects.equals(toGameObject().getOwnerGUID(), target.getGUID())) visibleFlag |= UF_FLAG_OWNER;
            }
            case DYNAMIC_OBJECT -> {
                if (Objects.equals(toDynObject().getOwnerGUID(), target.getGUID())) visibleFlag |= UF_FLAG_OWNER;
            }
            case CORPSE -> {
                if (Objects.equals(toCorpse().getOwnerGUID(), target.getGUID())) visibleFlag |= UF_FLAG_OWNER;
            }
            case OBJECT -> Assert.fail();
        }
        return visibleFlag;
    }

    int[] getDynamicUpdateFieldFlagsFor(Player target) {
        return switch (typeId) {
            case ITEM, CONTAINER -> ITEM_DYNAMIC_UPDATE_FIELD_FLAGS;
            case UNIT, PLAYER -> UNIT_DYNAMIC_UPDATE_FIELD_FLAGS;
            case GAME_OBJECT -> GAME_OBJECT_DYNAMIC_UPDATE_FIELD_FLAGS;
            case CONVERSATION -> CONVERSATION_DYNAMIC_UPDATE_FIELD_FLAGS;
            default -> null;
        };
    }

    int getDynamicUpdateVisibleFlagFor(Player target) {

        int visibleFlag = UF_FLAG_PUBLIC;

        if (target == this) visibleFlag |= UF_FLAG_PRIVATE;

        switch (typeId) {
            case ITEM:
            case CONTAINER:
                if (this instanceof Item item && Objects.equals(item.getOwnerGUID(), target.getGUID())) {
                    visibleFlag |= UF_FLAG_OWNER | UF_FLAG_ITEM_OWNER;
                    break;
                }
            case UNIT:
            case PLAYER: {
                Player plr = toUnit().getCharmerOrOwnerPlayerOrPlayerItself();
                if (Objects.equals(toUnit().getOwnerGUID(), target.getGUID())) {
                    visibleFlag |= UF_FLAG_OWNER;

                    if (hasFlag(OBJECT_DYNAMIC_FLAGS, UnitDynFlag.SPECIAL_INFO) && toUnit().hasAuraTypeWithCaster(AuraType.EMPATHY, target.getGUID()))
                        visibleFlag |= UF_FLAG_SPECIAL_INFO;

                    if (plr != null && plr.isInSameRaidWith(target)) visibleFlag |= UF_FLAG_PARTY_MEMBER;
                    break;
                }
            }

            case CONVERSATION:
                if (Objects.equals(toConversation().getOwnerGUID(), target.getGUID())) {
                    visibleFlag |= UF_FLAG_0x100;
                    break;
                }
        }
        return visibleFlag;
    }

    void buildDynamicValuesUpdate(ObjectUpdateType updateType, WorldPacket buffer, Player target) {
        if (target == null) return;

        UpdateMaskPacketBuilder updateMask = new UpdateMaskPacketBuilder(dynamicValuesCount);
        int[] flags = getDynamicUpdateFieldFlagsFor(target);
        int visibleFlag = getDynamicUpdateVisibleFlagFor(target);

        ByteBuf fieldBuffer = Unpooled.buffer();
        for (int index = 0; index < dynamicValuesCount; ++index) {
            IntArray dynamicValue = dynamicValues[index];


            if ((fieldNotifyFlags & flags[index]) != 0 || ((updateType == ObjectUpdateType.VALUES ? dynamicChangesMask[index] != DYNAMIC_FIELD_UNCHANGED : !dynamicValue.isEmpty()) && (flags[index] & visibleFlag) != 0)) {
                updateMask.setBit(index);
                UpdateMaskPacketBuilder dynamicUpdateMask = new UpdateMaskPacketBuilder(dynamicValuesCount);

                //*data << uint16(UpdateMask::EncodeDynamicFieldChangeType(arrayBlockCount, _dynamicChangesMask[index], updateType));
                if (dynamicChangesMask[index] == DYNAMIC_FIELD_VALUE_AND_SIZE_CHANGED && updateType == ObjectUpdateType.VALUES)
                    //*data << uint32(values.size());

                    //std::size_t arrayMaskPos = data->wpos();
                    //data->resize(data->size() + arrayBlockCount * sizeof(UpdateMask::BlockType));
                    for (int v = 0; v < dynamicValue.size; ++v) {
                        if (updateType != ObjectUpdateType.VALUES || dynamicChangesArrayMask[index].items[v] != 0) {
                            //UpdateMask::SetUpdateBit(data->contents() + arrayMaskPos, v);
                            fieldBuffer.writeInt(dynamicValue.get(v));
                        }
                    }
            }
        }
        updateMask.appendToPacket(buffer);
        buffer.writeBytes(fieldBuffer);

    }

    public final void buildDestroyUpdateBlock(UpdateData data) {
        data.addDestroyObject(getGUID());
    }

    public final void buildOutOfRangeUpdateBlock(UpdateData data) {
        data.addOutOfRangeGUID(getGUID());
    }

    public void destroyForPlayer(Player target) {
        UpdateData updateData = new UpdateData(target.getLocation().getMapId());
        buildDestroyUpdateBlock(updateData);
        target.sendPacket(updateData.buildPacket());
    }

    public final void sendOutOfRangeForPlayer(Player target) {
        UpdateData updateData = new UpdateData(target.getLocation().getMapId());
        buildOutOfRangeUpdateBlock(updateData);
        target.sendPacket(updateData.buildPacket());
    }

    private void buildMovementUpdate(WorldPacket data, EnumFlag<ObjectUpdateFlag> flags, Player target) {
        boolean noBirthAnim = false;
        boolean enablePortals = false;
        boolean playHoverAnim = false;
        boolean HasMovementUpdate = flags.hasFlag(ObjectUpdateFlag.LIVING);
        boolean HasMovementTransport = flags.hasFlag(ObjectUpdateFlag.TRANSPORT_POSITION);
        boolean stationary = flags.hasFlag(ObjectUpdateFlag.STATIONARY_POSITION);
        boolean combatVictim = flags.hasFlag(ObjectUpdateFlag.HAS_TARGET);
        boolean serverTime = flags.hasFlag(ObjectUpdateFlag.TRANSPORT);
        boolean vehicleCreate = flags.hasFlag(ObjectUpdateFlag.VEHICLE);
        boolean AnimKitCreate = flags.hasFlag(ObjectUpdateFlag.ANIM_KITS);
        boolean rotation = flags.hasFlag(ObjectUpdateFlag.ROTATION);
        boolean HasAreaTrigger = flags.hasFlag(ObjectUpdateFlag.AREA_TRIGGER);
        boolean HasGameObject = flags.hasFlag(ObjectUpdateFlag.GAME_OBJECT);
        boolean thisIsYou = flags.hasFlag(ObjectUpdateFlag.SELF);
        boolean smoothPhasing = false;
        boolean SceneObjCreate = false;
        boolean PlayerCreateData = isPlayer() && toUnit().getPowerIndex(Power.RUNES) != Power.MAX_POWERS.index;

        IntArray pauseTimes = null;
        if (this instanceof GameObject go) {
            pauseTimes = go.getPauseTimes();
        }

        data.writeBit(noBirthAnim);
        data.writeBit(enablePortals);
        data.writeBit(playHoverAnim);
        data.writeBit(HasMovementUpdate);
        data.writeBit(HasMovementTransport);
        data.writeBit(stationary);
        data.writeBit(combatVictim);
        data.writeBit(serverTime);
        data.writeBit(vehicleCreate);
        data.writeBit(AnimKitCreate);
        data.writeBit(rotation);
        data.writeBit(HasAreaTrigger);
        data.writeBit(HasGameObject);
        data.writeBit(smoothPhasing);
        data.writeBit(thisIsYou);
        data.writeBit(SceneObjCreate);
        data.writeBit(PlayerCreateData);
        data.flushBits();

        if (HasMovementUpdate) {
            Unit unit = toUnit();
            boolean HasFallDirection = unit.hasUnitMovementFlag(MovementFlag.FALLING);
            boolean HasFall = HasFallDirection || unit.getMovementInfo().getJump().getFallTime() != 0;
            boolean HasSpline = unit.isSplineEnabled();


            data.writeGuid(getGUID()); // MoverGUID

            data.writeInt32(unit.movementInfo.getTime()); // MoveTime
            data.writeFloat(unit.getLocation().getX());
            data.writeFloat(unit.getLocation().getY());
            data.writeFloat(unit.getLocation().getZ());
            data.writeFloat(unit.getLocation().getO());

            data.writeFloat(unit.getMovementInfo().getPitch()); // Pitch
            data.writeFloat(unit.getMovementInfo().getStepUpStartElevation()); // StepUpStartElevation

            data.writeInt32(0); // RemoveForcesIDs.size()
            data.writeInt32(0); // MoveIndex

            //for (public uint i = 0; i < RemoveForcesIDs.count; ++i)
            //    *data << objectGuid(RemoveForcesIDs);


            data.writeBits(unit.getUnitMovementFlags(), 30);
            data.writeBits(unit.getExtraUnitMovementFlags(), 18);

            data.writeBit(!unit.getMovementInfo().getTransport().getGuid().isEmpty()); // HasTransport
            data.writeBit(HasFall); // HasFall
            data.writeBit(HasSpline); // HasSpline - marks that the unit uses spline movement
            data.writeBit(false); // HeightChangeFailed
            data.writeBit(false); // RemoteTimeValid

            if (!unit.getMovementInfo().getTransport().getGuid().isEmpty()) {
                MovementIOUtil.writeTransportInfo(data, unit.getMovementInfo().getTransport());
            }


            if (HasFall) {
                data.writeInt32(unit.getMovementInfo().getJump().getFallTime()); // Time
                data.writeFloat(unit.getMovementInfo().getJump().getZspeed()); // JumpVelocity

                if (data.writeBit(HasFallDirection)) {
                    data.writeFloat(unit.getMovementInfo().getJump().getSinAngle()); // Direction
                    data.writeFloat(unit.getMovementInfo().getJump().getCosAngle());
                    data.writeFloat(unit.getMovementInfo().getJump().getXyspeed()); // Speed
                }
            }

            data.writeFloat(unit.getSpeed(UnitMoveType.WALK));
            data.writeFloat(unit.getSpeed(UnitMoveType.RUN));
            data.writeFloat(unit.getSpeed(UnitMoveType.RUN_BACK));
            data.writeFloat(unit.getSpeed(UnitMoveType.SWIM));
            data.writeFloat(unit.getSpeed(UnitMoveType.SWIM_BACK));
            data.writeFloat(unit.getSpeed(UnitMoveType.FLIGHT));
            data.writeFloat(unit.getSpeed(UnitMoveType.FLIGHT_BACK));
            data.writeFloat(unit.getSpeed(UnitMoveType.TURN_RATE));
            data.writeFloat(unit.getSpeed(UnitMoveType.PITCH_RATE));

            var movementForces = unit.getMovementForces();

            if (movementForces != null) {
                data.writeInt32(movementForces.getForces().size());
                data.writeFloat(movementForces.getModMagnitude()); // MovementForcesModMagnitude
            } else {
                data.writeInt32(0);
                data.writeFloat(1.0f); // MovementForcesModMagnitude
            }

            data.writeBit(HasSpline);
            data.flushBits();

            if (movementForces != null) {
                for (var force : movementForces.getForces()) {
                    MovementIOUtil.writeMovementForceWithDirection(force, data, unit.getLocation());
                }
            }

            // HasMovementSpline - marks that spline data is present in packet
            if (HasSpline) {
                MovementIOUtil.writeCreateObjectSplineDataBlock(unit.getMoveSpline(), data);
            }
        }

        data.writeInt32(pauseTimes != null ? pauseTimes.size : 0);

        if (stationary) {
            var self = (WorldObject) this;
            data.writeFloat(self.getStationaryX());
            data.writeFloat(self.getStationaryY());
            data.writeFloat(self.getStationaryZ());
            data.writeFloat(self.getStationaryO());
        }

        if (combatVictim) {
            data.writeGuid(toUnit().getVictim().getGUID()); // CombatVictim
        }

        if (serverTime) {
            data.writeInt32(GameTime.getGameTimeMS());
        }

        if (vehicleCreate) {
            var unit = toUnit();
            data.writeInt32(unit.getVehicleKit().getVehicleInfo().getId()); // RecID
            data.writeFloat(unit.getLocation().getO()); // InitialRawFacing
        }

        if (AnimKitCreate) {
            var worldObject = (WorldObject) this;
            data.writeInt16(worldObject.getAIAnimKitId()); // AiID
            data.writeInt16(worldObject.getMovementAnimKitId()); // MovementID
            data.writeInt16(worldObject.getMeleeAnimKitId()); // MeleeID
        }

        if (rotation) {
            data.writeInt64(toGameObject().getPackedLocalRotation()); // Rotation
        }

        if (pauseTimes != null && !pauseTimes.isEmpty()) {
            for (var stopFrame : pauseTimes.items) {
                data.writeInt32(stopFrame);
            }
        }

        if (HasMovementTransport) {
            var self = (WorldObject) this;
            MovementIOUtil.writeTransportInfo(data, self.getMovementInfo().getTransport());
        }

        if (HasAreaTrigger) {
            var areaTrigger = toAreaTrigger();
            var createProperties = areaTrigger.getCreateProperties();
            var areaTriggerTemplate = areaTrigger.getTemplate();
            var shape = areaTrigger.getShape();

            data.writeInt32(areaTrigger.getTimeSinceCreated());

            data.writeVector3(areaTrigger.getRollPitchYaw());

            var hasAbsoluteOrientation = areaTriggerTemplate != null && areaTriggerTemplate.hasFlag(AreaTriggerCreatePropertiesFlag.HasAbsoluteOrientation);
            var hasDynamicShape = areaTriggerTemplate != null && areaTriggerTemplate.hasFlag(AreaTriggerCreatePropertiesFlag.HasDynamicShape);
            var hasAttached = areaTriggerTemplate != null && areaTriggerTemplate.hasFlag(AreaTriggerCreatePropertiesFlag.HasAttached);
            var hasFaceMovementDir = areaTriggerTemplate != null && areaTriggerTemplate.hasFlag(AreaTriggerCreatePropertiesFlag.HasFaceMovementDir);
            var hasFollowsTerrain = areaTriggerTemplate != null && areaTriggerTemplate.hasFlag(AreaTriggerCreatePropertiesFlag.HasFollowsTerrain);
            var hasUnk1 = areaTriggerTemplate != null && areaTriggerTemplate.hasFlag(AreaTriggerCreatePropertiesFlag.Unk1);
            var hasTargetRollPitchYaw = createProperties != null && createProperties.Flags.hasFlag(AreaTriggerCreatePropertiesFlag.HasTargetRollPitchYaw);
            var hasScaleCurveID = createProperties != null && createProperties.ScaleCurveId != 0;
            var hasMorphCurveID = createProperties != null && createProperties.MorphCurveId != 0;
            var hasFacingCurveID = createProperties != null && createProperties.FacingCurveId != 0;
            var hasMoveCurveID = createProperties != null && createProperties.MoveCurveId != 0;
            var hasAnimation = createProperties != null && createProperties.Flags.hasFlag(AreaTriggerCreatePropertiesFlag.HasAnimId);
            var hasUnk3 = createProperties != null && createProperties.Flags.hasFlag(AreaTriggerCreatePropertiesFlag.Unk3);
            var hasAnimKitID = createProperties != null && createProperties.Flags.hasFlag(AreaTriggerCreatePropertiesFlag.HasAnimKitId);

            var hasAreaTriggerSphere = shape.isSphere();
            var hasAreaTriggerBox = shape.isBox();
            var hasAreaTriggerPolygon = createProperties != null && shape.isPolygon();
            var hasAreaTriggerCylinder = shape.isCylinder();
            var hasAreaTriggerSpline = areaTrigger.getHasSplines();
            var hasOrbit = areaTrigger.hasOrbit();

            data.writeBit(hasAbsoluteOrientation);
            data.writeBit(hasDynamicShape);
            data.writeBit(hasAttached);
            data.writeBit(hasFaceMovementDir);
            data.writeBit(hasFollowsTerrain);
            data.writeBit(hasUnk1);
            data.writeBit(hasTargetRollPitchYaw);
            data.writeBit(hasScaleCurveID);
            data.writeBit(hasMorphCurveID);
            data.writeBit(hasFacingCurveID);
            data.writeBit(hasMoveCurveID);
            data.writeBit(hasAnimation);
            data.writeBit(hasUnk3);
            data.writeBit(hasAnimKitID);
            data.writeBit(hasAreaTriggerSphere);
            data.writeBit(hasAreaTriggerBox);
            data.writeBit(hasAreaTriggerPolygon);
            data.writeBit(hasAreaTriggerCylinder);
            data.writeBit(hasAreaTriggerSpline);
            data.writeBit(hasOrbit);

            if (hasUnk3) data.writeBit(true);//data->WriteBit(0);

            data.flushBits();

            if (hasAreaTriggerSpline) {
                data.writeInt32(areaTrigger.getTimeToTarget());
                data.writeInt32(areaTrigger.getElapsedTimeForMovement());
                MovementIOUtil.writeCreateObjectAreaTriggerSpline(areaTrigger.getSpline(), data);
            }

            if (hasTargetRollPitchYaw) {
                data.writeVector3(areaTrigger.getTargetRollPitchYaw());
            }

            if (hasScaleCurveID) {
                data.writeInt32(createProperties.ScaleCurveId);
            }

            if (hasMorphCurveID) {
                data.writeInt32(createProperties.MorphCurveId);
            }

            if (hasFacingCurveID) {
                data.writeInt32(createProperties.FacingCurveId);
            }

            if (hasMoveCurveID) {
                data.writeInt32(createProperties.MoveCurveId);
            }

            if (hasAnimation) {
                data.writeInt32(createProperties.AnimId);
            }

            if (hasAnimKitID) {
                data.writeInt32(createProperties.AnimKitId);
            }

            if (hasAreaTriggerSphere) {
                data.writeFloat(shape.SphereData.Radius);
                data.writeFloat(shape.SphereData.RadiusTarget);
            }

            if (hasAreaTriggerBox) {
                data.writeFloat(shape.BoxData.Extents[0]);
                data.writeFloat(shape.BoxData.Extents[1]);
                data.writeFloat(shape.BoxData.Extents[2]);
                data.writeFloat(shape.BoxData.ExtentsTarget[0]);
                data.writeFloat(shape.BoxData.ExtentsTarget[1]);
                data.writeFloat(shape.BoxData.ExtentsTarget[2]);
            }

            if (hasAreaTriggerPolygon) {
                data.writeInt32(shape.PolygonVertices.size());
                data.writeInt32(shape.PolygonVerticesTarget.size());
                data.writeFloat(shape.PolygonDatas.Height);
                data.writeFloat(shape.PolygonDatas.HeightTarget);

                for (var item : shape.PolygonVertices) {
                    data.writeVector2(item);
                }

                for (var item : shape.PolygonVerticesTarget) {
                    data.writeVector2(item);
                }
            }

            if (hasAreaTriggerCylinder) {
                data.writeFloat(shape.CylinderData.Radius);
                data.writeFloat(shape.CylinderData.RadiusTarget);
                data.writeFloat(shape.CylinderData.Height);
                data.writeFloat(shape.CylinderData.HeightTarget);
                data.writeFloat(shape.CylinderData.LocationZOffset);
                data.writeFloat(shape.CylinderData.LocationZOffsetTarget);
            }

            if (hasOrbit) {
                areaTrigger.getCircularMovementInfo().write(data);
            }
        }

        if (HasGameObject) {
            var gameObject = toGameObject();
            data.writeInt32(gameObject.getWorldEffectID());
            // bit8
            data.writeBit(false);
            data.flushBits();
        }

        if (smoothPhasing) {

            WorldObject self = (WorldObject) this;
            var smoothPhasingInfo = self.getSmoothPhasing().getInfoForSeer(target.getGUID());

            data.writeBit(smoothPhasingInfo.getReplaceActive());
            data.writeBit(smoothPhasingInfo.getStopAnimKits());
            data.writeBit(smoothPhasingInfo.replaceObject != null);
            data.flushBits();

            if (smoothPhasingInfo.replaceObject != null) {
                data.writeGuid(smoothPhasingInfo.replaceObject);
            }
        }

        if (SceneObjCreate) {
            data.writeBit(false); // HasLocalScriptData
            data.writeBit(false); // HasPetBattleFullUpdate
            data.flushBits();
        }

        if (PlayerCreateData) {
            var player = toPlayer();

            var hasSceneInstanceIDs = !player.getSceneMgr().getSceneTemplateByInstanceMap().isEmpty();
            var hasRuneState = toUnit().getPowerIndex(Power.RUNES) != Power.MAX_POWERS.index;

            data.writeBit(hasSceneInstanceIDs);
            data.writeBit(hasRuneState);
            data.flushBits();

            if (hasSceneInstanceIDs) {
                data.writeInt32(player.getSceneMgr().getSceneTemplateByInstanceMap().size());

                for (var pair : player.getSceneMgr().getSceneTemplateByInstanceMap().entrySet()) {
                    data.writeInt32(pair.getKey());
                }
            }

            if (hasRuneState) {
                float baseCd = player.getRuneBaseCooldown();
                var maxRunes = player.getMaxPower(Power.RUNES);

                data.writeInt8((byte) ((1 << maxRunes) - 1));
                data.writeInt8(player.getRunesState());
                data.writeInt32(maxRunes);

                for (byte i = 0; i < maxRunes; ++i) {
                    data.writeInt8((int) ((baseCd - (float) player.getRuneCooldown(i)) / baseCd * 255));
                }
            }
        }
    }

    abstract void addToObjectUpdate();

    private void addToObjectUpdateIfNeeded() {
        if (inWorld && !objectUpdated) {
            addToObjectUpdate();
            objectUpdated = true;
        }
    }

    protected final void setInt32Value(int index, int value) {
        checkIndex(index, true);
        int oldVal = int32Values[index];
        if (oldVal != value) {
            int32Values[index] = value;
            changesMask.setBit(index);
            addToObjectUpdateIfNeeded();
        }
    }

    protected final void updateInt32Value(int index, int value) {
        checkIndex(index, true);
        int32Values[index] = value;
        changesMask.setBit(index);
    }

    protected final void setInt64Value(int index, long value) {
        Assert.state(value < 0, "Overflowed value {}.", value);
        checkIndex(index + 1, true);
        int i0 = int32Values[index];
        int i1 = int32Values[index + 1];
        long oldValue = ((long) i1 << 32) | (long) i0;
        if (oldValue != value) {
            int32Values[index] = (int) (value & 0x00000000ffffffffL);
            int32Values[index + 1] = (int) (value >>> 32);
            changesMask.setBit(index);
            changesMask.setBit(index + 1);
            addToObjectUpdateIfNeeded();
        }
    }

    protected final boolean addGuidValue(int index, ObjectGuid value) {
        checkIndex(index + 3, true);
        ObjectGuid oldValue = getGuidValue(index);
        if (!value.isEmpty() && oldValue.isEmpty()) {
            setGuidValue(index, value);
            return true;
        }
        return false;
    }

    protected final boolean removeGuidValue(int index, ObjectGuid value) {
        checkIndex(index + 3, true);
        if (!value.isEmpty() && getGuidValue(index).equals(value)) {
            int32Values[index] = 0;
            int32Values[index + 1] = 0;
            int32Values[index + 2] = 0;
            int32Values[index + 3] = 0;

            changesMask.setBit(index);
            changesMask.setBit(index + 1);
            changesMask.setBit(index + 2);
            changesMask.setBit(index + 3);

            addToObjectUpdateIfNeeded();
            return true;
        }
        return false;
    }

    protected final void setFloatValue(int index, float value) {
        checkIndex(index, true);
        int intValue = Float.floatToIntBits(value);
        if (int32Values[index] != intValue) {
            int32Values[index] = intValue;
            changesMask.setBit(index);
            addToObjectUpdateIfNeeded();
        }
    }

    protected final void setByteValue(int index, byte offset, int value) {
        checkIndex(index, true);
        Assert.state(offset < 4, "getByteValue: wrong offset {}.", offset);
        int i = int32Values[index];
        if ((byte) (i >>> (offset * 8)) != value) {
            i &= ~(0xFF << (offset * 8));
            i |= (value & 0xff << (offset * 8));

            int32Values[index] = i;
            changesMask.setBit(index);

            addToObjectUpdateIfNeeded();
        }
    }

    protected final void setInt16Value(int index, byte offset, short value) {
        checkIndex(index, true);
        Assert.state(offset < 2, "setUInt16Value: wrong offset {}.", offset);
        int i = int32Values[index];
        if ((short) (i >>> (offset * 16)) != value) {
            i &= ~(0xFFFF << (offset * 16));
            i |= value << (offset * 16);
            changesMask.setBit(index);
            addToObjectUpdateIfNeeded();
        }
    }

    protected final void setGuidValue(int index, ObjectGuid value) {
        checkIndex(index + 3, true);

        if (!getGuidValue(index).equals(value)) {
            long l0 = value.lowValue();
            long l1 = value.highValue();
            int32Values[index] = (int) (l0 & 0x00000000ffffffffL);
            int32Values[index + 1] = (int) (l0 >>> 32);
            int32Values[index + 2] = (int) (l1 & 0x00000000ffffffffL);
            int32Values[index + 3] = (int) (l1 >>> 32);

            changesMask.setBit(index);
            changesMask.setBit(index + 1);
            changesMask.setBit(index + 2);
            changesMask.setBit(index + 3);
            addToObjectUpdateIfNeeded();
        }
    }

    protected final void setStatFloatValue(int index, float value) {
        if (value < 0) value = 0.0f;

        setFloatValue(index, value);
    }

    protected final void setStatInt32Value(int index, int value) {
        if (value < 0) value = 0;
        setInt32Value(index, value);
    }

    protected final void applyModUInt32Value(int index, int val, boolean apply) {
        int cur = getUInt32Value(index);
        cur += (apply ? val : -val);
        if (cur < 0) cur = 0;
        setInt32Value(index, cur);
    }

    protected final void applyModInt32Value(int index, int val, boolean apply) {
        int cur = getInt32Value(index);
        cur += (apply ? val : -val);
        setInt32Value(index, cur);
    }

    protected final void applyModUInt16Value(int index, byte offset, short val, boolean apply) {
        int cur = getUInt16Value(index, offset);
        cur += apply ? val : -val;
        if (cur < 0) cur = 0;
        setInt16Value(index, offset, (short) cur);
    }

    protected final void applyModSignedFloatValue(int index, float val, boolean apply) {
        float cur = getFloatValue(index);
        cur += (apply ? val : -val);
        setFloatValue(index, cur);
    }

    protected final void applyModPositiveFloatValue(int index, float val, boolean apply) {
        float cur = getFloatValue(index);
        cur += (apply ? val : -val);
        if (cur < 0) cur = 0;
        setFloatValue(index, cur);
    }

    protected final void setFlag(int index, EnumFlag.FlagValue flag) {
        setFlag(index, flag.getValue());
    }

    protected final void setFlag(int index, int newFlag) {

        int oldVal = getInt32Value(index);
        int newVal = oldVal | newFlag;

        if (oldVal != newVal) {
            setInt32Value(index, newVal);
        }
    }

    protected final void removeFlag(int index, EnumFlag.FlagValue flag) {
        removeFlag(index, flag.getValue());
    }

    protected final void removeFlag(int index, int oldFlag) {

        int oldVal = getInt32Value(index);
        int newVal = oldVal & ~oldFlag;

        if (oldVal != newVal) {
            setInt32Value(index, newVal);
        }
    }

    protected final void toggleFlag(int index, EnumFlag.FlagValue flag) {
        toggleFlag(index, flag.getValue());
    }

    protected final void toggleFlag(int index, int flag) {
        if (hasFlag(index, flag)) removeFlag(index, flag);
        else setFlag(index, flag);
    }


    protected final boolean hasFlag(int index, EnumFlag.FlagValue flag) {
        return hasFlag(index, flag.getValue());
    }

    protected final boolean hasFlag(int index, int flag) {
        int value = getInt32Value(index);

        return (value & flag) != 0;
    }

    protected final void applyModFlag(int index, int flag, boolean apply) {
        if (apply) setFlag(index, flag);
        else removeFlag(index, flag);
    }

    protected final void setByteFlag(int index, byte offset, byte newFlag) {
        checkIndex(index, true);
        Assert.notOutOfBound(offset, 4, "SetByteFlag: wrong offset {}.", offset);
        int i = int32Values[index];
        if (((byte) (i >>> (offset * 8)) & newFlag) == 0) {
            i |= newFlag << (offset * 8);
            int32Values[index] = i;
            changesMask.setBit(index);
            addToObjectUpdateIfNeeded();
        }
    }

    protected final void removeByteFlag(int index, byte offset, byte oldFlag) {
        checkIndex(index, true);
        Assert.notOutOfBound(offset, 4, "RemoveByteFlag: wrong offset {}.", offset);

        int i = int32Values[index];

        if (((byte) (i >>> (offset * 8)) & offset) != 0) {
            i &= ~oldFlag << (offset * 8);
            int32Values[index] = i;
            changesMask.setBit(index);
            addToObjectUpdateIfNeeded();
        }
    }

    protected final void toggleByteFlag(int index, byte offset, byte flag) {
        if (hasByteFlag(index, offset, flag)) removeByteFlag(index, offset, flag);
        else setByteFlag(index, offset, flag);
    }

    protected final boolean hasByteFlag(int index, byte offset, byte flag) {
        checkIndex(index, true);
        Assert.notOutOfBound(offset, 4, "HasByteFlag: wrong offset {}.", offset);
        int i = int32Values[index];
        return ((byte) (i >>> (offset * 8)) & flag) != 0;
    }

    protected final void setFlag64(int index, long newFlag) {
        long oldVal = getUInt64Value(index);
        long newVal = oldVal | newFlag;
        setInt64Value(index, newVal);
    }

    protected final void removeFlag64(int index, long oldFlag) {
        long oldVal = getUInt64Value(index);
        long newVal = oldVal & ~oldFlag;
        setInt64Value(index, newVal);
    }

    protected final void toggleFlag64(int index, long flag) {
        if (hasFlag64(index, flag)) removeFlag64(index, flag);
        else setFlag64(index, flag);
    }

    protected final boolean hasFlag64(int index, long flag) {
        return (getInt64Value(index) & flag) != 0;
    }

    protected final void applyModFlag64(int index, long flag, boolean apply) {
        if (apply) {
            setFlag64(index, flag);
        } else {
            removeFlag64(index, flag);
        }
    }

    protected final int[] getDynamicValues(int index) {
        checkDynamicIndex(index, false);
        return dynamicValues[index].items;
    }

    protected final int getDynamicValue(int index, short offset) {
        checkDynamicIndex(index, false);
        int[] dynamicValue = dynamicValues[index].items;
        Assert.notOutOfBound(offset, dynamicValue.length, "GetDynamicValue: wrong offset {}.", offset);
        return dynamicValue[offset];
    }

    protected final boolean hasDynamicValue(int index, int value) {
        checkDynamicIndex(index, false);
        int[] dynamicValue = dynamicValues[index].items;
        for (int i : dynamicValue) {
            if (i == value) return true;
        }
        return false;
    }

    protected final void addDynamicValue(int index, int value) {
        checkDynamicIndex(index, false);
        setDynamicValue(index, dynamicValues[index].size, value);
    }

    protected final void removeDynamicValue(int index, int value) {
        checkDynamicIndex(index, false);
        int[] values = dynamicValues[index].items;
        for (int i : values) {
            if (i == value) {
                values[i] = 0;
                dynamicChangesMask[index] = DYNAMIC_FIELD_VALUE_CHANGED;
                dynamicChangesArrayMask[index].items[i] = 1;
                addToObjectUpdateIfNeeded();
            }
        }
    }

    protected final void clearDynamicValue(int index) {
        checkDynamicIndex(index, false);

        if (!dynamicValues[index].isEmpty()) {
            dynamicValues[index].clear();
            dynamicChangesMask[index] = DYNAMIC_FIELD_VALUE_AND_SIZE_CHANGED;
            dynamicChangesArrayMask[index].clear();
            addToObjectUpdateIfNeeded();
        }
    }

    protected final void setDynamicValue(int index, int offset, int value) {
        checkDynamicIndex(index, false);

        int changeType = DYNAMIC_FIELD_VALUE_CHANGED;
        IntArray values = dynamicValues[index];
        if (values.size <= offset) {
            values.setSize(offset + 1);
            changeType = DYNAMIC_FIELD_VALUE_AND_SIZE_CHANGED;
        }

        ByteArray byteArray = dynamicChangesArrayMask[index];
        if (byteArray.size <= offset) byteArray.setSize((offset / 32 + 1) * 32);

        if (values.items[offset] != value || changeType == DYNAMIC_FIELD_VALUE_AND_SIZE_CHANGED) {
            values.items[offset] = value;
            dynamicChangesMask[index] = changeType;
            dynamicChangesArrayMask[index].items[offset] = 1;
            addToObjectUpdateIfNeeded();
        }
    }


    protected final int getInt32Value(int index) {
        checkIndex(index, false);
        return int32Values[index];
    }

    protected final int getUInt32Value(int index) {
        int value = getInt32Value(index);
        if (value < 0) {
            throw new ValueOverflowException("UInt " + value + " value overflowed.");
        }
        return value;
    }

    protected final long getInt64Value(int index) {
        checkIndex(index + 1, false);
        int i0 = int32Values[index];
        int i1 = int32Values[index + 1];

        return (((long) i1) << 32) | ((long) i0 & 0xffffffffL);
    }


    protected final long getUInt64Value(int index) {
        checkIndex(index + 1, false);
        long value = getInt64Value(index);
        if (value < 0) {
            throw new ValueOverflowException("UInt64 " + value + " value overflowed.");
        }
        return value;
    }

    protected final float getFloatValue(int index) {
        checkIndex(index, false);
        int intValue = int32Values[index];
        return Float.intBitsToFloat(intValue);
    }

    protected final byte getByteValue(int index, byte offset) {
        checkIndex(index, false);
        Assert.notOutOfBound(offset, 4, "getByteValue: wrong offset {}.", offset);

        int i = int32Values[index];

        return (byte) (i >>> offset);
    }

    protected final short getInt16Value(int index, byte offset) {
        checkIndex(index, false);
        Assert.notOutOfBound(offset, 2, "getInt16Value: wrong offset {}.", offset);
        int i = int32Values[index];
        return (short) (i >>> offset);
    }

    protected final short getUInt16Value(int index, byte offset) {
        short value = getInt16Value(index, offset);
        if (value < 0) {
            throw new ValueOverflowException("UInt16 " + value + " value overflowed.");
        }
        return value;
    }

    protected final ObjectGuid getGuidValue(int index) {
        checkIndex(index, false);
        int i0 = int32Values[index];
        int i1 = int32Values[index + 1];
        int i2 = int32Values[index + 2];
        int i3 = int32Values[index + 3];
        return new ObjectGuid(((long) i3 << 32) | i2, ((long) i1 << 32) | i0);
    }

    private <T extends GenericObject> T cast(Class<T> kclass) {
        return kclass.isInstance(this) ? kclass.cast(this) : null;

    }

    public final Player toPlayer() {
        return cast(Player.class);
    }

    public final GameObject toGameObject() {
        return cast(GameObject.class);
    }

    public final Unit toUnit() {
        return cast(Unit.class);
    }

    public final Conversation toConversation() {
        return cast(Conversation.class);
    }

    public final Creature toCreature() {
        return cast(Creature.class);
    }

    public final Corpse toCorpse() {
        return cast(Corpse.class);
    }

    public final AreaTrigger toAreaTrigger() {
        return cast(AreaTrigger.class);
    }

    public final DynamicObject toDynObject() {
        return cast(DynamicObject.class);
    }

    public final SceneObject toSceneObject() {
        return cast(SceneObject.class);
    }

    public final Item toItem() {
        return cast(Item.class);
    }


    public final boolean isPlayer() {
        return typeId == TypeId.PLAYER;
    }


    public final boolean isCreature() {
        return typeId == TypeId.UNIT;
    }


    public final boolean isUnit() {
        return isType(TypeMask.UNIT);
    }

    public final boolean isGameObject() {
        return typeId == TypeId.GAME_OBJECT;
    }

    public final boolean isCorpse() {
        return typeId == TypeId.CORPSE;
    }

    public final boolean isDynObject() {
        return typeId == TypeId.DYNAMIC_OBJECT;
    }

    public final boolean isAreaTrigger() {
        return typeId == TypeId.AREA_TRIGGER;
    }

    public final boolean isSceneObject() {
        return typeId == TypeId.SCENE_OBJECT;
    }

    public final boolean isConversation() {
        return typeId == TypeId.CONVERSATION;
    }

    public final boolean isItem() {
        return typeId == TypeId.ITEM;
    }


    private void checkIndex(int index, boolean set) {
        Assert.notOutOfBound(index, valuesCount, "Attempt to {} non-existing value field: {} (count: {}) for object typeId: {} type mask: {}", (set ? "set value to" : "get value from"), index, valuesCount, getTypeId(), objectType);
    }

    private void checkDynamicIndex(int index, boolean set) {
        Assert.notOutOfBound(index, dynamicValuesCount, "Attempt to {} non-existing dynamic value field: {} (count: {}) for object typeId: {} type mask: {}", (set ? "set dynamic value to" : "get dynamic value from"), index, dynamicValuesCount, getTypeId(), objectType);
    }

    protected final void applyPercentModFloatValue(int index, float val, boolean apply) {
        float value = getFloatValue(index);
        value = applyPercentModFloatVar(value, val, apply);
        setFloatValue(index, value);
    }
}
