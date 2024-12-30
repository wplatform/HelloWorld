package com.github.mmo.game.condition;


import com.github.mmo.game.map.InstanceMap;
import com.github.mmo.game.scenario.Scenario;
import com.github.mmo.game.scripting.interfaces.icondition.IConditionCheck;

public class Condition {
    public ConditionsourceType sourceType = ConditionSourceType.values()[0]; //SourceTypeOrReferenceId
    public int sourceGroup;
    public int sourceEntry;
    public int sourceId; // So far, only used in CONDITION_SOURCE_TYPE_SMART_EVENT
    public int elseGroup;
    public conditionTypes conditionType = ConditionTypes.values()[0]; //ConditionTypeOrReference
    public int conditionValue1;
    public int conditionValue2;
    public int conditionValue3;
    public int errorType;
    public int errorTextId;
    public int referenceId;
    public int scriptId;
    public byte conditionTarget;
    public boolean negativeCondition;

    public condition() {
        sourceType = ConditionSourceType.NONE;
        conditionType = ConditionTypes.NONE;
    }

    public final boolean meets(ConditionSourceInfo sourceInfo) {
        var map = sourceInfo.mConditionMap;
        var condMeets = false;
        var needsObject = false;

        switch (conditionType) {
            case None:
                condMeets = true; // empty condition, always met

                break;
            case ActiveEvent:
                condMeets = global.getGameEventMgr().isActiveEvent((short) conditionValue1);

                break;
            case InstanceInfo: {
                if (map.isDungeon()) {
                    var instance = ((InstanceMap) map).getInstanceScript();

                    if (instance != null) {
                        switch (InstanceInfo.forValue(conditionValue3)) {
                            case Data:
                                condMeets = instance.getData(conditionValue1) == conditionValue2;

                                break;
                            //case INSTANCE_INFO_GUID_DATA:
                            //    condMeets = instance->GetGuidData(conditionValue1) == objectGuid(uint64(conditionValue2));
                            //    break;
                            case BossState:
                                condMeets = instance.getBossState(conditionValue1) == EncounterState.forValue(conditionValue2);

                                break;
                            case Data64:
                                condMeets = instance.getData64(conditionValue1) == conditionValue2;

                                break;
                            default:
                                condMeets = false;

                                break;
                        }
                    }
                }

                break;
            }
            case Mapid:
                condMeets = map.getId() == conditionValue1;

                break;
            case WorldState: {
                condMeets = global.getWorldStateMgr().getValue((int) conditionValue1, map) == conditionValue2;

                break;
            }
            case RealmAchievement: {
                var achievement = CliDB.AchievementStorage.get(conditionValue1);

                if (achievement != null && global.getAchievementMgr().isRealmCompleted(achievement)) {
                    condMeets = true;
                }

                break;
            }
            case DifficultyId: {
                condMeets = (int) map.getDifficultyID().getValue() == conditionValue1;

                break;
            }
            case ScenarioStep: {
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

        var obj = sourceInfo.mConditionTargets[ConditionTarget];

        // object not present, return false
        if (needsObject && obj == null) {
            Log.outDebug(LogFilter.condition, "Condition object not found for condition (Entry: {0} Type: {1} Group: {2})", sourceEntry, sourceType, sourceGroup);

            return false;
        }

        var player = obj == null ? null : obj.toPlayer();
        var unit = obj == null ? null : obj.toUnit();

        switch (conditionType) {
            case Aura:
                if (unit != null) {
                    condMeets = unit.hasAuraEffect(conditionValue1, (byte) conditionValue2);
                }

                break;
            case Item:
                if (player != null) {
                    var checkBank = conditionValue3 != 0;
                    condMeets = player.hasItemCount(conditionValue1, conditionValue2, checkBank);
                }

                break;
            case ItemEquipped:
                if (player != null) {
                    condMeets = player.hasItemOrGemWithIdEquipped(conditionValue1, 1);
                }

                break;
            case Zoneid:
                condMeets = obj.getZone() == conditionValue1;

                break;
            case ReputationRank:
                if (player != null) {
                    var faction = CliDB.FactionStorage.get(conditionValue1);

                    if (faction != null) {
                        condMeets = (boolean) (conditionValue2 & (1 << player.getReputationMgr().getRank(faction).getValue()));
                    }
                }

                break;
            case Achievement:
                if (player != null) {
                    condMeets = player.hasAchieved(conditionValue1);
                }

                break;
            case Team:
                if (player != null) {
                    condMeets = (int) player.getTeam().getValue() == conditionValue1;
                }

                break;
            case Class:
                if (unit != null) {
                    condMeets = (boolean) (unit.getClassMask() & conditionValue1);
                }

                break;
            case Race:
                if (unit != null) {
                    condMeets = (boolean) (SharedConst.GetMaskForRace(unit.getRace()) & conditionValue1);
                }

                break;
            case Gender:
                if (player != null) {
                    condMeets = player.getNativeGender() == gender.forValue((byte) conditionValue1);
                }

                break;
            case Skill:
                if (player != null) {
                    condMeets = player.hasSkill(SkillType.forValue(conditionValue1)) && player.getBaseSkillValue(SkillType.forValue(conditionValue1)).getValue() >= conditionValue2;
                }

                break;
            case QuestRewarded:
                if (player != null) {
                    condMeets = player.getQuestRewardStatus(conditionValue1);
                }

                break;
            case QuestTaken:
                if (player != null) {
                    var status = player.getQuestStatus(conditionValue1);
                    condMeets = (status == QuestStatus.INCOMPLETE);
                }

                break;
            case QuestComplete:
                if (player != null) {
                    var status = player.getQuestStatus(conditionValue1);
                    condMeets = (status == QuestStatus.Complete && !player.getQuestRewardStatus(conditionValue1));
                }

                break;
            case QuestNone:
                if (player != null) {
                    var status = player.getQuestStatus(conditionValue1);
                    condMeets = (status == QuestStatus.NONE);
                }

                break;
            case Areaid:
                condMeets = obj.getArea() == conditionValue1;

                break;
            case Spell:
                if (player != null) {
                    condMeets = player.hasSpell(conditionValue1);
                }

                break;
            case Level:
                if (unit != null) {
                    condMeets = MathUtil.CompareValues(ComparisionType.forValue(conditionValue2), unit.getLevel(), conditionValue1);
                }

                break;
            case DrunkenState:
                if (player != null) {
                    condMeets = (int) player.getDrunkenstateByValue(player.getDrunkValue()).getValue() >= conditionValue1;
                }

                break;
            case NearCreature:
                condMeets = obj.findNearestCreature(conditionValue1, conditionValue2, conditionValue3 == 0) != null;

                break;
            case NearGameobject:
                condMeets = obj.findNearestGameObject(conditionValue1, conditionValue2) != null;

                break;
            case ObjectEntryGuid:
                if ((int) obj.getTypeId().getValue() == conditionValue1) {
                    condMeets = conditionValue2 == 0 || (obj.getEntry() == conditionValue2);

                    if (conditionValue3 != 0) {
                        switch (obj.getTypeId()) {
                            case Unit:
                                condMeets &= obj.toCreature().getSpawnId() == conditionValue3;

                                break;
                            case GameObject:
                                condMeets &= obj.toGameObject().getSpawnId() == conditionValue3;

                                break;
                        }
                    }
                }

                break;
            case TypeMask:
                condMeets = (boolean) (TypeMask.forValue(conditionValue1).getValue() & obj.getObjectTypeMask().getValue());

                break;
            case RelationTo: {
                var toObject = sourceInfo.mConditionTargets[ConditionValue1];

                if (toObject != null) {
                    var toUnit = toObject.toUnit();

                    if (toUnit != null && unit != null) {
                        switch (RelationType.forValue(conditionValue2)) {
                            case Self:
                                condMeets = unit == toUnit;

                                break;
                            case InParty:
                                condMeets = unit.isInPartyWith(toUnit);

                                break;
                            case InRaidOrParty:
                                condMeets = unit.isInRaidWith(toUnit);

                                break;
                            case OwnedBy:
                                condMeets = Objects.equals(unit.getOwnerGUID(), toUnit.getGUID());

                                break;
                            case PassengerOf:
                                condMeets = unit.isOnVehicle(toUnit);

                                break;
                            case CreatedBy:
                                condMeets = Objects.equals(unit.getCreatorGUID(), toUnit.getGUID());

                                break;
                        }
                    }
                }

                break;
            }
            case ReactionTo: {
                var toObject = sourceInfo.mConditionTargets[ConditionValue1];

                if (toObject != null) {
                    var toUnit = toObject.toUnit();

                    if (toUnit != null && unit != null) {
                        condMeets = (boolean) ((1 << unit.getReactionTo(toUnit).getValue()) & conditionValue2);
                    }
                }

                break;
            }
            case DistanceTo: {
                var toObject = sourceInfo.mConditionTargets[ConditionValue1];

                if (toObject != null) {
                    condMeets = MathUtil.CompareValues(ComparisionType.forValue(conditionValue3), obj.getDistance(toObject), conditionValue2);
                }

                break;
            }
            case Alive:
                if (unit != null) {
                    condMeets = unit.isAlive();
                }

                break;
            case HpVal:
                if (unit != null) {
                    condMeets = MathUtil.CompareValues(ComparisionType.forValue(conditionValue2), unit.getHealth(), conditionValue1);
                }

                break;
            case HpPct:
                if (unit != null) {
                    condMeets = MathUtil.CompareValues(ComparisionType.forValue(conditionValue2), unit.getHealthPct(), conditionValue1);
                }

                break;
            case PhaseId:
                condMeets = obj.getPhaseShift().hasPhase(conditionValue1);

                break;
            case Title:
                if (player != null) {
                    condMeets = player.hasTitle(conditionValue1);
                }

                break;
            case UnitState:
                if (unit != null) {
                    condMeets = unit.hasUnitState(UnitState.forValue(conditionValue1));
                }

                break;
            case CreatureType: {
                var creature = obj.toCreature();

                if (creature) {
                    condMeets = (int) creature.getTemplate().creatureType.getValue() == conditionValue1;
                }

                break;
            }
            case InWater:
                if (unit) {
                    condMeets = unit.isInWater();
                }

                break;
            case TerrainSwap:
                condMeets = obj.getPhaseShift().hasVisibleMapId(conditionValue1);

                break;
            case StandState: {
                if (unit) {
                    if (conditionValue1 == 0) {
                        condMeets = (unit.getStandState() == UnitStandStateType.forValue((byte) conditionValue2));
                    } else if (conditionValue2 == 0) {
                        condMeets = unit.isStandState();
                    } else if (conditionValue2 == 1) {
                        condMeets = unit.isSitState();
                    }
                }

                break;
            }
            case DailyQuestDone: {
                if (player) {
                    condMeets = player.isDailyQuestDone(conditionValue1);
                }

                break;
            }
            case Charmed: {
                if (unit) {
                    condMeets = unit.isCharmed();
                }

                break;
            }
            case PetType: {
                if (player) {
                    var pet = player.getCurrentPet();

                    if (pet) {
                        condMeets = (((1 << pet.getPetType().getValue()) & conditionValue1) != 0);
                    }
                }

                break;
            }
            case Taxi: {
                if (player) {
                    condMeets = player.isInFlight();
                }

                break;
            }
            case Queststate: {
                if (player) {
                    if (((boolean) (conditionValue2 & (1 << QuestStatus.NONE.getValue())) && (player.getQuestStatus(conditionValue1) == QuestStatus.NONE)) || ((boolean) (conditionValue2 & (1 << QuestStatus.Complete.getValue())) && (player.getQuestStatus(conditionValue1) == QuestStatus.Complete)) || ((boolean) (conditionValue2 & (1 << QuestStatus.INCOMPLETE.getValue())) && (player.getQuestStatus(conditionValue1) == QuestStatus.INCOMPLETE)) || ((boolean) (conditionValue2 & (1 << QuestStatus.Failed.getValue())) && (player.getQuestStatus(conditionValue1) == QuestStatus.Failed)) || ((boolean) (conditionValue2 & (1 << QuestStatus.Rewarded.getValue())) && player.getQuestRewardStatus(conditionValue1))) {
                        condMeets = true;
                    }
                }

                break;
            }
            case ObjectiveProgress: {
                if (player) {
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
            case Gamemaster: {
                if (player != null) {
                    if (conditionValue1 == 1) {
                        condMeets = player.getCanBeGameMaster();
                    } else {
                        condMeets = player.isGameMaster();
                    }
                }

                break;
            }
            case BattlePetCount: {
                if (player != null) {
                    condMeets = MathUtil.CompareValues(ComparisionType.forValue(conditionValue3), player.getSession().getBattlePetMgr().getPetCount(CliDB.BattlePetSpeciesStorage.get(conditionValue1), player.getGUID()), conditionValue2);
                }

                break;
            }
            case SceneInProgress: {
                if (player != null) {
                    condMeets = player.getSceneMgr().getActiveSceneCount(conditionValue1) > 0;
                }

                break;
            }
            case PlayerCondition: {
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

    public final GridMapTypeMask getSearcherTypeMaskForCondition() {
        // build mask of types for which condition can return true
        // this is used for speeding up gridsearches
        if (negativeCondition) {
            return GridMapTypeMask.All;
        }

        GridMapTypeMask mask = GridMapTypeMask.forValue(0);

        switch (conditionType) {
            case ActiveEvent:
            case Areaid:
            case DifficultyId:
            case DistanceTo:
            case InstanceInfo:
            case Mapid:
            case NearCreature:
            case NearGameobject:
            case None:
            case PhaseId:
            case RealmAchievement:
            case TerrainSwap:
            case WorldState:
            case Zoneid:
                mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.All.getValue());

                break;
            case Gender:
            case Title:
            case DrunkenState:
            case Spell:
            case QuestTaken:
            case QuestComplete:
            case QuestNone:
            case Skill:
            case QuestRewarded:
            case ReputationRank:
            case Achievement:
            case Team:
            case Item:
            case ItemEquipped:
            case PetType:
            case Taxi:
            case Queststate:
            case Gamemaster:
                mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.player.getValue());

                break;
            case UnitState:
            case Alive:
            case HpVal:
            case HpPct:
            case RelationTo:
            case ReactionTo:
            case Level:
            case Class:
            case Race:
            case Aura:
            case InWater:
            case StandState:
                mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.forValue(GridMapTypeMask.CREATURE.getValue() | GridMapTypeMask.player.getValue()).getValue());

                break;
            case ObjectEntryGuid:
                switch (TypeId.forValue(conditionValue1)) {
                    case Unit:
                        mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.CREATURE.getValue());

                        break;
                    case Player:
                        mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.player.getValue());

                        break;
                    case GameObject:
                        mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.gameObject.getValue());

                        break;
                    case Corpse:
                        mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.Corpse.getValue());

                        break;
                    case AreaTrigger:
                        mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.areaTrigger.getValue());

                        break;
                    default:
                        break;
                }

                break;
            case TypeMask:
                if ((boolean) (TypeMask.forValue(conditionValue1).getValue() & TypeMask.unit.getValue())) {
                    mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.forValue(GridMapTypeMask.CREATURE.getValue() | GridMapTypeMask.player.getValue()).getValue());
                }

                if ((boolean) (TypeMask.forValue(conditionValue1).getValue() & TypeMask.player.getValue())) {
                    mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.player.getValue());
                }

                if ((boolean) (TypeMask.forValue(conditionValue1).getValue() & TypeMask.gameObject.getValue())) {
                    mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.gameObject.getValue());
                }

                if ((boolean) (TypeMask.forValue(conditionValue1).getValue() & TypeMask.Corpse.getValue())) {
                    mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.Corpse.getValue());
                }

                if ((boolean) (TypeMask.forValue(conditionValue1).getValue() & TypeMask.areaTrigger.getValue())) {
                    mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.areaTrigger.getValue());
                }

                break;
            case DailyQuestDone:
            case ObjectiveProgress:
            case BattlePetCount:
                mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.player.getValue());

                break;
            case ScenarioStep:
                mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.All.getValue());

                break;
            case SceneInProgress:
                mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.player.getValue());

                break;
            case PlayerCondition:
                mask = GridMapTypeMask.forValue(mask.getValue() | GridMapTypeMask.player.getValue());

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
