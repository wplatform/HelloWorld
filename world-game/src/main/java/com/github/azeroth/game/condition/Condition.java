package com.github.azeroth.game.condition;


import com.github.azeroth.common.EnumFlag;
import com.github.azeroth.common.Logs;
import com.github.azeroth.defines.RaceMask;
import com.github.azeroth.game.domain.unit.UnitStandStateType;
import com.github.azeroth.game.domain.unit.UnitState;
import com.github.azeroth.game.domain.object.enums.TypeId;
import com.github.azeroth.game.domain.object.enums.TypeMask;
import com.github.azeroth.game.map.InstanceMap;
import com.github.azeroth.game.map.grid.GridMapTypeMask;
import com.github.azeroth.game.domain.quest.QuestStatus;
import com.github.azeroth.game.scenario.Scenario;
import com.github.azeroth.game.scripting.interfaces.icondition.IConditionCheck;
import com.github.azeroth.utils.MathUtil;

import java.util.Objects;

public class Condition {
    public ConditionSourceType sourceType; //SourceTypeOrReferenceId
    public int sourceGroup;
    public int sourceEntry;
    public int sourceId; // So far, only used in CONDITION_SOURCE_TYPE_SMART_EVENT
    public int elseGroup;
    public ConditionType conditionType; //ConditionTypeOrReference
    public int conditionValue1;
    public int conditionValue2;
    public int conditionValue3;
    public int errorType;
    public int errorTextId;
    public int referenceId;
    public int scriptId;
    public byte conditionTarget;
    public boolean negativeCondition;

    public Condition() {
        sourceType = ConditionSourceType.NONE;
        conditionType = ConditionType.NONE;
    }

    public final boolean meets(ConditionSourceInfo sourceInfo) {
        var map = sourceInfo.mConditionMap;
        var condMeets = false;
        var needsObject = false;

        switch (conditionType) {
            case NONE:
                condMeets = true; // empty condition, always met

                break;
            case ACTIVE_EVENT:
                condMeets = global.getGameEventMgr().isActiveEvent((short) conditionValue1);

                break;
            case INSTANCE_INFO: {
                if (map.isDungeon()) {
                    var instance = ((InstanceMap) map).getInstanceScript();

                    if (instance != null) {
                        condMeets = switch (InstanceInfo.values()[conditionValue3]) {
                            case INFO_DATA -> instance.getData(conditionValue1) == conditionValue2;
                            //case INSTANCE_INFO_GUID_DATA:
                            //    condMeets = instance->GetGuidData(conditionValue1) == objectGuid(uint64(conditionValue2));
                            //    break;
                            case INFO_BOSS_STATE ->
                                    instance.getBossState(conditionValue1) == EncounterState.forValue(conditionValue2);
                            case INFO_DATA64 -> instance.getData64(conditionValue1) == conditionValue2;
                            default -> false;
                        };
                    }
                }

                break;
            }
            case MAP_ID:
                condMeets = map.getId() == conditionValue1;

                break;
            case WORLD_STATE: {
                condMeets = global.getWorldStateMgr().getValue((int) conditionValue1, map) == conditionValue2;

                break;
            }
            case REALM_ACHIEVEMENT: {
                var achievement = CliDB.AchievementStorage.get(conditionValue1);

                if (achievement != null && global.getAchievementMgr().isRealmCompleted(achievement)) {
                    condMeets = true;
                }

                break;
            }
            case DIFFICULTY_ID: {
                condMeets = map.getDifficultyID().ordinal() == conditionValue1;

                break;
            }
            case SCENARIO_STEP: {
                var instanceMap = map.getToInstanceMap();

                if (instanceMap != null) {
                    Scenario scenario = instanceMap.getInstanceScenario();

                    if (scenario != null) {
                        var step = scenario.getStep();

                        if (step != null) {
                            condMeets = step.id == conditionValue1;
                        }
                    }
                }

                break;
            }
            default:
                needsObject = true;

                break;
        }

        var obj = sourceInfo.conditionTargets[conditionTarget];

        // object not present, return false
        if (needsObject && obj == null) {
            Logs.CONDITION.debug("Condition object not found for {}", this);

            return false;
        }

        var player = obj == null ? null : obj.toPlayer();
        var unit = obj == null ? null : obj.toUnit();

        switch (conditionType) {
            case AURA:
                if (unit != null) {
                    condMeets = unit.hasAuraEffect(conditionValue1, (byte) conditionValue2);
                }

                break;
            case ITEM:
                if (player != null) {
                    var checkBank = conditionValue3 != 0;
                    condMeets = player.hasItemCount(conditionValue1, conditionValue2, checkBank);
                }

                break;
            case ITEM_EQUIPPED:
                if (player != null) {
                    condMeets = player.hasItemOrGemWithIdEquipped(conditionValue1, 1);
                }

                break;
            case ZONEID:
                condMeets = obj.getZone() == conditionValue1;

                break;
            case REPUTATION_RANK:
                if (player != null) {
                    var faction = CliDB.FactionStorage.get(conditionValue1);

                    if (faction != null) {
                        condMeets = (boolean) (conditionValue2 & (1 << player.getReputationMgr().getRank(faction).getValue()));
                    }
                }

                break;
            case ACHIEVEMENT:
                if (player != null) {
                    condMeets = player.hasAchieved(conditionValue1);
                }

                break;
            case TEAM:
                if (player != null) {
                    condMeets = player.getTeam().value == conditionValue1;
                }

                break;
            case CLASS:
                if (unit != null) {
                    condMeets =  (unit.getClassMask() & conditionValue1);
                }

                break;
            case RACE:
                if (unit != null) {
                    condMeets = (boolean) (RaceMask.getMaskForRace(unit.getRace()) & conditionValue1);
                }

                break;
            case GENDER:
                if (player != null) {
                    condMeets = player.getNativeGender() == gender.forValue((byte) conditionValue1);
                }

                break;
            case SKILL:
                if (player != null) {
                    condMeets = player.hasSkill(SkillType.forValue(conditionValue1)) && player.getBaseSkillValue(SkillType.forValue(conditionValue1)).getValue() >= conditionValue2;
                }

                break;
            case QUEST_REWARDED:
                if (player != null) {
                    condMeets = player.getQuestRewardStatus(conditionValue1);
                }

                break;
            case QUEST_TAKEN:
                if (player != null) {
                    var status = player.getQuestStatus(conditionValue1);
                    condMeets = (status == QuestStatus.INCOMPLETE);
                }

                break;
            case QUEST_COMPLETE:
                if (player != null) {
                    var status = player.getQuestStatus(conditionValue1);
                    condMeets = (status == QuestStatus.COMPLETE && !player.getQuestRewardStatus(conditionValue1));
                }

                break;
            case QUEST_NONE:
                if (player != null) {
                    var status = player.getQuestStatus(conditionValue1);
                    condMeets = (status == QuestStatus.NONE);
                }

                break;
            case AREA_ID:
                condMeets = obj.getArea() == conditionValue1;

                break;
            case SPELL:
                if (player != null) {
                    condMeets = player.hasSpell(conditionValue1);
                }

                break;
            case LEVEL:
                if (unit != null) {
                    condMeets = MathUtil.CompareValues(ComparisionType.forValue(conditionValue2), unit.getLevel(), conditionValue1);
                }

                break;
            case DRUNKEN_STATE:
                if (player != null) {
                    condMeets = (int) player.getDrunkenstateByValue(player.getDrunkValue()).getValue() >= conditionValue1;
                }

                break;
            case NEAR_CREATURE:
                condMeets = obj.findNearestCreature(conditionValue1, conditionValue2, conditionValue3 == 0) != null;

                break;
            case NEAR_GAME_OBJECT:
                condMeets = obj.findNearestGameObject(conditionValue1, conditionValue2) != null;

                break;
            case OBJECT_ENTRY_GUID:
                if ((int) obj.getTypeId().getValue() == conditionValue1) {
                    condMeets = conditionValue2 == 0 || (obj.getEntry() == conditionValue2);

                    if (conditionValue3 != 0) {
                        switch (obj.getTypeId()) {
                            case UNIT:
                                condMeets &= obj.toCreature().getSpawnId() == conditionValue3;

                                break;
                            case GAME_OBJECT:
                                condMeets &= obj.toGameObject().getSpawnId() == conditionValue3;

                                break;
                        }
                    }
                }

                break;
            case TYPE_MASK:
                condMeets = (boolean) (TypeMask.forValue(conditionValue1).getValue() & obj.getObjectTypeMask().getValue());

                break;
            case RELATION_TO: {
                var toObject = sourceInfo.conditionTargets[conditionValue1];

                if (toObject != null) {
                    var toUnit = toObject.toUnit();

                    if (toUnit != null && unit != null) {
                        condMeets = switch (RelationType.values()[conditionValue2]) {
                            case SELF -> unit == toUnit;
                            case IN_PARTY -> unit.isInPartyWith(toUnit);
                            case IN_RAID_OR_PARTY -> unit.isInRaidWith(toUnit);
                            case OWNED_BY -> Objects.equals(unit.getOwnerGUID(), toUnit.getGUID());
                            case PASSENGER_OF -> unit.isOnVehicle(toUnit);
                            case CREATED_BY -> Objects.equals(unit.getCreatorGUID(), toUnit.getGUID());
                            default -> condMeets;
                        };
                    }
                }

                break;
            }
            case REACTION_TO: {
                var toObject = sourceInfo.conditionTargets[conditionValue1];

                if (toObject != null) {
                    var toUnit = toObject.toUnit();

                    if (toUnit != null && unit != null) {
                        condMeets = (boolean) ((1 << unit.getReactionTo(toUnit).getValue()) & conditionValue2);
                    }
                }

                break;
            }
            case DISTANCE_TO: {
                var toObject = sourceInfo.conditionTargets[conditionValue1];

                if (toObject != null) {
                    condMeets = MathUtil.CompareValues(ComparisionType.forValue(conditionValue3), obj.getDistance(toObject), conditionValue2);
                }

                break;
            }
            case ALIVE:
                if (unit != null) {
                    condMeets = unit.isAlive();
                }

                break;
            case HP_VAL:
                if (unit != null) {
                    condMeets = MathUtil.compareValues(ComparisionType.forValue(conditionValue2), unit.getHealth(), conditionValue1);
                }

                break;
            case HP_PCT:
                if (unit != null) {
                    condMeets = MathUtil.compareValues(ComparisionType.forValue(conditionValue2), unit.getHealthPct(), conditionValue1);
                }

                break;
            case PHASE_ID:
                condMeets = obj.getPhaseShift().hasPhase(conditionValue1);

                break;
            case TITLE:
                if (player != null) {
                    condMeets = player.hasTitle(conditionValue1);
                }

                break;
            case UNIT_STATE:
                if (unit != null) {
                    condMeets = unit.hasUnitState(UnitState.values()[conditionValue1]);
                }

                break;
            case CREATURE_TYPE: {
                var creature = obj.toCreature();

                if (creature != null) {
                    condMeets = (int) creature.getTemplate().type.ordinal() == conditionValue1;
                }

                break;
            }
            case IN_WATER:
                if (unit != null) {
                    condMeets = unit.isInWater();
                }

                break;
            case TERRAIN_SWAP:
                condMeets = obj.getPhaseShift().hasVisibleMapId(conditionValue1);

                break;
            case STAND_STATE: {
                if (unit != null) {
                    if (conditionValue1 == 0) {
                        condMeets = (unit.getStandState() == UnitStandStateType.values()[conditionValue2]);
                    } else if (conditionValue2 == 0) {
                        condMeets = unit.isStandState();
                    } else if (conditionValue2 == 1) {
                        condMeets = unit.isSitState();
                    }
                }

                break;
            }
            case DAILY_QUEST_DONE: {
                if (player != null) {
                    condMeets = player.isDailyQuestDone(conditionValue1);
                }

                break;
            }
            case CHARMED: {
                if (unit) {
                    condMeets = unit.isCharmed();
                }

                break;
            }
            case PET_TYPE: {
                if (player) {
                    var pet = player.getCurrentPet();

                    if (pet) {
                        condMeets = (((1 << pet.getPetType().getValue()) & conditionValue1) != 0);
                    }
                }

                break;
            }
            case TAXI: {
                if (player) {
                    condMeets = player.isInFlight();
                }

                break;
            }
            case QUEST_STATE: {
                if (player) {
                    if (((boolean) (conditionValue2 & (1 << QuestStatus.NONE.getValue())) && (player.getQuestStatus(conditionValue1) == QuestStatus.NONE)) || ((boolean) (conditionValue2 & (1 << QuestStatus.Complete.getValue())) && (player.getQuestStatus(conditionValue1) == QuestStatus.Complete)) || ((boolean) (conditionValue2 & (1 << QuestStatus.INCOMPLETE.getValue())) && (player.getQuestStatus(conditionValue1) == QuestStatus.INCOMPLETE)) || ((boolean) (conditionValue2 & (1 << QuestStatus.Failed.getValue())) && (player.getQuestStatus(conditionValue1) == QuestStatus.Failed)) || ((boolean) (conditionValue2 & (1 << QuestStatus.Rewarded.getValue())) && player.getQuestRewardStatus(conditionValue1))) {
                        condMeets = true;
                    }
                }

                break;
            }
            case QUEST_OBJECTIVE_PROGRESS: {
                if (player != null) {
                    var questObj = global.getObjectMgr().getQuestObjective(conditionValue1);

                    if (questObj == null) {
                        break;
                    }

                    var quest = global.getObjectMgr().getQuestTemplate(questObj.questID);

                    if (quest == null) {
                        break;
                    }

                    var slot = player.findQuestSlot(questObj.questID);

                    if (slot >= SharedConst.MaxQuestLogSize) {
                        break;
                    }

                    condMeets = player.getQuestSlotObjectiveData(slot, questObj) == conditionValue3;
                }

                break;
            }
            case GAME_MASTER: {
                if (player != null) {
                    if (conditionValue1 == 1) {
                        condMeets = player.getCanBeGameMaster();
                    } else {
                        condMeets = player.isGameMaster();
                    }
                }

                break;
            }
            case BATTLE_PET_COUNT: {
                if (player != null) {
                    condMeets = MathUtil.CompareValues(ComparisionType.forValue(conditionValue3), player.getSession().getBattlePetMgr().getPetCount(CliDB.BattlePetSpeciesStorage.get(conditionValue1), player.getGUID()), conditionValue2);
                }

                break;
            }
            case SCENE_IN_PROGRESS: {
                if (player != null) {
                    condMeets = player.getSceneMgr().getActiveSceneCount(conditionValue1) > 0;
                }

                break;
            }
            case PLAYER_CONDITION: {
                if (player != null) {
                    var playerCondition = CliDB.PlayerConditionStorage.get(conditionValue1);

                    if (playerCondition != null) {
                        condMeets = ConditionManager.isPlayerMeetingCondition(player, playerCondition);
                    }
                }

                break;
            }
            default:
                break;
        }

        if (negativeCondition) {
            condMeets = !condMeets;
        }

        if (!condMeets) {
            sourceInfo.mLastFailedCondition = this;
        }

        return condMeets && global.getScriptMgr().<IConditionCheck>RunScriptRet(p -> p.OnConditionCheck(this, sourceInfo), scriptId, true); // Returns true by default.;
    }

    public final EnumFlag<GridMapTypeMask> getSearcherTypeMaskForCondition() {
        // build mask of types for which condition can return true
        // this is used for speeding up gridsearches
        if (negativeCondition)
            return EnumFlag.of(GridMapTypeMask.ALL);
        EnumFlag<GridMapTypeMask> mask = EnumFlag.of(GridMapTypeMask.class, 0);
        switch (conditionType)
        {
            case NONE:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case AURA:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case ITEM:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case ITEM_EQUIPPED:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case ZONEID:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case REPUTATION_RANK:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case ACHIEVEMENT:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case TEAM:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case CLASS:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case RACE:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case SKILL:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case QUEST_REWARDED:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case QUEST_TAKEN:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case QUEST_COMPLETE:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case QUEST_NONE:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case ACTIVE_EVENT:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case INSTANCE_INFO:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case MAP_ID:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case AREA_ID:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case SPELL:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case LEVEL:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case DRUNKEN_STATE:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case NEAR_CREATURE:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case NEAR_GAME_OBJECT:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case OBJECT_ENTRY_GUID:
                switch (TypeId.values()[conditionValue1])
                {
                    case UNIT:
                        mask.addFlag(GridMapTypeMask.CREATURE);
                        break;
                    case PLAYER:
                        mask.addFlag(GridMapTypeMask.PLAYER);
                        break;
                    case GAME_OBJECT:
                        mask.addFlag(GridMapTypeMask.GAME_OBJECT);
                        break;
                    case CORPSE:
                        mask.addFlag(GridMapTypeMask.CORPSE);
                        break;
                    case AREA_TRIGGER:
                        mask.addFlag(GridMapTypeMask.AREA_TRIGGER);
                        break;
                    default:
                        break;
                }
                break;
            case TYPE_MASK:
                if ((conditionValue1 & TypeMask.UNIT.value) != 0)
                    mask.addFlag(GridMapTypeMask.CREATURE, GridMapTypeMask.PLAYER);
                if ((conditionValue1 & TypeMask.PLAYER.value) != 0)
                    mask.addFlag(GridMapTypeMask.PLAYER);
                if ((conditionValue1 & TypeMask.GAME_OBJECT.value) !=0)
                    mask.addFlag(GridMapTypeMask.GAME_OBJECT);
                if ((conditionValue1 & TypeMask.CORPSE.value) !=0)
                    mask.addFlag(GridMapTypeMask.CORPSE);
                if ((conditionValue1 & TypeMask.AREA_TRIGGER.value) != 0)
                    mask.addFlag(GridMapTypeMask.AREA_TRIGGER);
                break;
            case RELATION_TO:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case REACTION_TO:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case DISTANCE_TO:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case ALIVE:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case HP_VAL:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case HP_PCT:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case WORLD_STATE:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case PHASE_ID:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case TITLE:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case GENDER:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case UNIT_STATE:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case CREATURE_TYPE:
                mask.addFlag(GridMapTypeMask.CREATURE);
                break;
            case REALM_ACHIEVEMENT:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case IN_WATER:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case TERRAIN_SWAP:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case STAND_STATE:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case DAILY_QUEST_DONE:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case CHARMED:
                mask.addFlag(GridMapTypeMask.CREATURE , GridMapTypeMask.PLAYER);
                break;
            case PET_TYPE:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case TAXI:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case QUEST_STATE:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case QUEST_OBJECTIVE_PROGRESS:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case DIFFICULTY_ID:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case GAME_MASTER:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case BATTLE_PET_COUNT:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case SCENARIO_STEP:
                mask.addFlag(GridMapTypeMask.ALL);
                break;
            case SCENE_IN_PROGRESS:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
            case PLAYER_CONDITION:
                mask.addFlag(GridMapTypeMask.PLAYER);
                break;
        }
        return mask;
    }

    public final boolean isLoaded() {
        return conditionType.getValue() > ConditionTypes.NONE.getValue() || referenceId != 0 || scriptId != 0;
    }

    public final int getMaxAvailableConditionTargets() {
        // returns number of targets which are available for given source type
        switch (sourceType) {
            case Spell:
            case SpellImplicitTarget:
            case CreatureTemplateVehicle:
            case VehicleSpell:
            case SpellClickEvent:
            case GossipMenu:
            case GossipMenuOption:
            case SmartEvent:
            case NpcVendor:
            case SpellProc:
                return 2;
            default:
                return 1;
        }
    }


    public final String toString() {
        return toString(false);
    }

    public final String toString(boolean ext) {
        StringBuilder ss = new StringBuilder();
        ss.append(String.format("[Condition SourceType: %1$s", sourceType));

        if (sourceType.getValue() < ConditionSourceType.max.getValue()) {
            if (global.getConditionMgr().staticSourceTypeData.length > sourceType.getValue()) {
                ss.append(String.format(" (%1$s)", global.getConditionMgr().StaticSourceTypeData[SourceType.getValue()]));
            }
        } else {
            ss.append(" (unknown)");
        }

        if (global.getConditionMgr().canHaveSourceGroupSet(sourceType)) {
            ss.append(String.format(", SourceGroup: %1$s", sourceGroup));
        }

        ss.append(String.format(", SourceEntry: %1$s", sourceEntry));

        if (global.getConditionMgr().canHaveSourceIdSet(sourceType)) {
            ss.append(String.format(", SourceId: %1$s", sourceId));
        }

        if (ext) {
            ss.append(String.format(", ConditionType: %1$s", conditionType));

            if (conditionType.getValue() < ConditionTypes.max.getValue()) {
                ss.append(String.format(" (%1$s)", global.getConditionMgr().StaticConditionTypeData[ConditionType.getValue()].name));
            } else {
                ss.append(" (unknown)");
            }
        }

        ss.append(']');

        return ss.toString();
    }
}
