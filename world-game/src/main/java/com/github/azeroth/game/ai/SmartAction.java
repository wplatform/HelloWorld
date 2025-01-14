package com.github.azeroth.game.ai;



public final class SmartAction {

    public SmartActions type = SmartActions.values()[0];


    public talk talk = new talk();


    public simpleTalk simpleTalk = new simpleTalk();


    public faction faction = new faction();


    public morphOrMount morphOrMount = new morphOrMount();


    public sound sound = new sound();


    public emote emote = new emote();


    public quest quest = new quest();


    public questOffer questOffer = new questOffer();


    public react react = new react();


    public randomEmote randomEmote = new randomEmote();


    public cast cast = new cast();


    public crossCast crossCast = new crossCast();


    public summonCreature summonCreature = new summonCreature();


    public threatPCT threatPCT = new threatPCT();


    public threat threat = new threat();


    public castCreatureOrGO castCreatureOrGO = new castCreatureOrGO();


    public autoAttack autoAttack = new autoAttack();


    public combatMove combatMove = new combatMove();


    public setEventPhase setEventPhase = new setEventPhase();


    public incEventPhase incEventPhase = new incEventPhase();


    public castedCreatureOrGO castedCreatureOrGO = new castedCreatureOrGO();


    public removeAura removeAura = new removeAura();


    public follow follow = new follow();


    public randomPhase randomPhase = new randomPhase();


    public randomPhaseRange randomPhaseRange = new randomPhaseRange();


    public killedMonster killedMonster = new killedMonster();


    public setInstanceData setInstanceData = new setInstanceData();


    public setInstanceData64 setInstanceData64 = new setInstanceData64();


    public updateTemplate updateTemplate = new updateTemplate();


    public callHelp callHelp = new callHelp();


    public setSheath setSheath = new setSheath();


    public forceDespawn forceDespawn = new forceDespawn();


    public invincHP invincHP = new invincHP();


    public ingamePhaseId ingamePhaseId = new ingamePhaseId();


    public ingamePhaseGroup ingamePhaseGroup = new ingamePhaseGroup();


    public setData setData = new setData();


    public moveRandom moveRandom = new moveRandom();


    public visibility visibility = new visibility();


    public summonGO summonGO = new summonGO();


    public active active = new active();


    public taxi taxi = new taxi();


    public wpStart wpStart = new wpStart();


    public wpPause wpPause = new wpPause();


    public wpStop wpStop = new wpStop();


    public item item = new item();


    public setRun setRun = new setRun();


    public setDisableGravity setDisableGravity = new setDisableGravity();


    public teleport teleport = new teleport();


    public setCounter setCounter = new setCounter();


    public storeTargets storeTargets = new storeTargets();


    public timeEvent timeEvent = new timeEvent();


    public movie movie = new movie();


    public equip equip = new equip();


    public flag flag = new flag();


    public setunitByte setunitByte = new setunitByte();


    public delunitByte delunitByte = new delunitByte();


    public timedActionList timedActionList = new timedActionList();


    public randTimedActionList randTimedActionList = new randTimedActionList();


    public randRangeTimedActionList randRangeTimedActionList = new randRangeTimedActionList();


    public interruptSpellCasting interruptSpellCasting = new interruptSpellCasting();


    public jump jump = new jump();


    public fleeAssist fleeAssist = new fleeAssist();


    public enableTempGO enableTempGO = new enableTempGO();


    public moveToPos moveToPos = new moveToPos();


    public sendGossipMenu sendGossipMenu = new sendGossipMenu();


    public setGoLootState setGoLootState = new setGoLootState();


    public sendTargetToTarget sendTargetToTarget = new sendTargetToTarget();


    public setRangedMovement setRangedMovement = new setRangedMovement();


    public setHealthRegen setHealthRegen = new setHealthRegen();


    public setRoot setRoot = new setRoot();


    public goState goState = new goState();


    public creatureGroup creatureGroup = new creatureGroup();


    public power power = new power();


    public gameEventStop gameEventStop = new gameEventStop();


    public gameEventStart gameEventStart = new gameEventStart();


    public closestWaypointFromList closestWaypointFromList = new closestWaypointFromList();


    public moveOffset moveOffset = new moveOffset();


    public randomSound randomSound = new randomSound();


    public corpseDelay corpseDelay = new corpseDelay();


    public disableEvade disableEvade = new disableEvade();


    public groupSpawn groupSpawn = new groupSpawn();


    public AuraType auraType = AuraType.values()[0];


    public loadEquipment loadEquipment = new loadEquipment();


    public randomTimedEvent randomTimedEvent = new randomTimedEvent();


    public pauseMovement pauseMovement = new pauseMovement();


    public respawnData respawnData = new respawnData();


    public animKit animKit = new animKit();


    public scene scene = new scene();


    public cinematic cinematic = new cinematic();


    public movementSpeed movementSpeed = new movementSpeed();


    public spellVisualKit spellVisualKit = new spellVisualKit();


    public overrideLight overrideLight = new overrideLight();


    public overrideWeather overrideWeather = new overrideWeather();


    public setHover setHover = new setHover();


    public evade evade = new evade();


    public setHealthPct setHealthPct = new setHealthPct();


    public conversation conversation = new conversation();


    public setImmunePC setImmunePC = new setImmunePC();


    public setImmuneNPC setImmuneNPC = new setImmuneNPC();


    public setUninteractible setUninteractible = new setUninteractible();


    public activateGameObject activateGameObject = new activateGameObject();


    public addToStoredTargets addToStoredTargets = new addToStoredTargets();


    public becomePersonalClone becomePersonalClone = new becomePersonalClone();


    public triggerGameEvent triggerGameEvent = new triggerGameEvent();


    public doAction doAction = new doAction();


    public raw raw = new raw();


    ///#region Stucts

    public SmartAction clone() {
        SmartAction varCopy = new smartAction();

        varCopy.type = this.type;
        varCopy.talk = this.talk;
        varCopy.simpleTalk = this.simpleTalk;
        varCopy.faction = this.faction;
        varCopy.morphOrMount = this.morphOrMount;
        varCopy.sound = this.sound;
        varCopy.emote = this.emote;
        varCopy.quest = this.quest;
        varCopy.questOffer = this.questOffer;
        varCopy.react = this.react;
        varCopy.randomEmote = this.randomEmote;
        varCopy.cast = this.cast;
        varCopy.crossCast = this.crossCast;
        varCopy.summonCreature = this.summonCreature;
        varCopy.threatPCT = this.threatPCT;
        varCopy.threat = this.threat;
        varCopy.castCreatureOrGO = this.castCreatureOrGO;
        varCopy.autoAttack = this.autoAttack;
        varCopy.combatMove = this.combatMove;
        varCopy.setEventPhase = this.setEventPhase;
        varCopy.incEventPhase = this.incEventPhase;
        varCopy.castedCreatureOrGO = this.castedCreatureOrGO;
        varCopy.removeAura = this.removeAura;
        varCopy.follow = this.follow;
        varCopy.randomPhase = this.randomPhase;
        varCopy.randomPhaseRange = this.randomPhaseRange;
        varCopy.killedMonster = this.killedMonster;
        varCopy.setInstanceData = this.setInstanceData;
        varCopy.setInstanceData64 = this.setInstanceData64;
        varCopy.updateTemplate = this.updateTemplate;
        varCopy.callHelp = this.callHelp;
        varCopy.setSheath = this.setSheath;
        varCopy.forceDespawn = this.forceDespawn;
        varCopy.invincHP = this.invincHP;
        varCopy.ingamePhaseId = this.ingamePhaseId;
        varCopy.ingamePhaseGroup = this.ingamePhaseGroup;
        varCopy.setData = this.setData;
        varCopy.moveRandom = this.moveRandom;
        varCopy.visibility = this.visibility;
        varCopy.summonGO = this.summonGO;
        varCopy.active = this.active;
        varCopy.taxi = this.taxi;
        varCopy.wpStart = this.wpStart;
        varCopy.wpPause = this.wpPause;
        varCopy.wpStop = this.wpStop;
        varCopy.item = this.item;
        varCopy.setRun = this.setRun;
        varCopy.setDisableGravity = this.setDisableGravity;
        varCopy.teleport = this.teleport;
        varCopy.setCounter = this.setCounter;
        varCopy.storeTargets = this.storeTargets;
        varCopy.timeEvent = this.timeEvent;
        varCopy.movie = this.movie;
        varCopy.equip = this.equip;
        varCopy.flag = this.flag;
        varCopy.setunitByte = this.setunitByte;
        varCopy.delunitByte = this.delunitByte;
        varCopy.timedActionList = this.timedActionList;
        varCopy.randTimedActionList = this.randTimedActionList;
        varCopy.randRangeTimedActionList = this.randRangeTimedActionList;
        varCopy.interruptSpellCasting = this.interruptSpellCasting;
        varCopy.jump = this.jump;
        varCopy.fleeAssist = this.fleeAssist;
        varCopy.enableTempGO = this.enableTempGO;
        varCopy.moveToPos = this.moveToPos;
        varCopy.sendGossipMenu = this.sendGossipMenu;
        varCopy.setGoLootState = this.setGoLootState;
        varCopy.sendTargetToTarget = this.sendTargetToTarget;
        varCopy.setRangedMovement = this.setRangedMovement;
        varCopy.setHealthRegen = this.setHealthRegen;
        varCopy.setRoot = this.setRoot;
        varCopy.goState = this.goState;
        varCopy.creatureGroup = this.creatureGroup;
        varCopy.power = this.power;
        varCopy.gameEventStop = this.gameEventStop;
        varCopy.gameEventStart = this.gameEventStart;
        varCopy.closestWaypointFromList = this.closestWaypointFromList;
        varCopy.moveOffset = this.moveOffset;
        varCopy.randomSound = this.randomSound;
        varCopy.corpseDelay = this.corpseDelay;
        varCopy.disableEvade = this.disableEvade;
        varCopy.groupSpawn = this.groupSpawn;
        varCopy.auraType = this.auraType;
        varCopy.loadEquipment = this.loadEquipment;
        varCopy.randomTimedEvent = this.randomTimedEvent;
        varCopy.pauseMovement = this.pauseMovement;
        varCopy.respawnData = this.respawnData;
        varCopy.animKit = this.animKit;
        varCopy.scene = this.scene;
        varCopy.cinematic = this.cinematic;
        varCopy.movementSpeed = this.movementSpeed;
        varCopy.spellVisualKit = this.spellVisualKit;
        varCopy.overrideLight = this.overrideLight;
        varCopy.overrideWeather = this.overrideWeather;
        varCopy.setHover = this.setHover;
        varCopy.evade = this.evade;
        varCopy.setHealthPct = this.setHealthPct;
        varCopy.conversation = this.conversation;
        varCopy.setImmunePC = this.setImmunePC;
        varCopy.setImmuneNPC = this.setImmuneNPC;
        varCopy.setUninteractible = this.setUninteractible;
        varCopy.activateGameObject = this.activateGameObject;
        varCopy.addToStoredTargets = this.addToStoredTargets;
        varCopy.becomePersonalClone = this.becomePersonalClone;
        varCopy.triggerGameEvent = this.triggerGameEvent;
        varCopy.doAction = this.doAction;
        varCopy.raw = this.raw;

        return varCopy;
    }

    public final static class Talk {
        public int textGroupId;
        public int duration;
        public int useTalkTarget;

        public Talk clone() {
            Talk varCopy = new talk();

            varCopy.textGroupId = this.textGroupId;
            varCopy.duration = this.duration;
            varCopy.useTalkTarget = this.useTalkTarget;

            return varCopy;
        }
    }

    public final static class SimpleTalk {
        public int textGroupId;
        public int duration;

        public SimpleTalk clone() {
            SimpleTalk varCopy = new simpleTalk();

            varCopy.textGroupId = this.textGroupId;
            varCopy.duration = this.duration;

            return varCopy;
        }
    }

    public final static class Faction {
        public int factionId;

        public Faction clone() {
            Faction varCopy = new faction();

            varCopy.factionId = this.factionId;

            return varCopy;
        }
    }

    public final static class MorphOrMount {
        public int creature;
        public int model;

        public MorphOrMount clone() {
            MorphOrMount varCopy = new morphOrMount();

            varCopy.creature = this.creature;
            varCopy.model = this.model;

            return varCopy;
        }
    }

    public final static class Sound {
        public int soundId;
        public int onlySelf;
        public int distance;
        public int keyBroadcastTextId;

        public Sound clone() {
            Sound varCopy = new sound();

            varCopy.soundId = this.soundId;
            varCopy.onlySelf = this.onlySelf;
            varCopy.distance = this.distance;
            varCopy.keyBroadcastTextId = this.keyBroadcastTextId;

            return varCopy;
        }
    }

    public final static class Emote {
        public int emoteId;

        public Emote clone() {
            Emote varCopy = new emote();

            varCopy.emoteId = this.emoteId;

            return varCopy;
        }
    }

    public final static class Quest {
        public int questId;

        public Quest clone() {
            Quest varCopy = new quest();

            varCopy.questId = this.questId;

            return varCopy;
        }
    }

    public final static class QuestOffer {
        public int questId;
        public int directAdd;

        public QuestOffer clone() {
            QuestOffer varCopy = new questOffer();

            varCopy.questId = this.questId;
            varCopy.directAdd = this.directAdd;

            return varCopy;
        }
    }

    public final static class React {
        public int state;

        public React clone() {
            React varCopy = new react();

            varCopy.state = this.state;

            return varCopy;
        }
    }

    public final static class RandomEmote {
        public int emote1;
        public int emote2;
        public int emote3;
        public int emote4;
        public int emote5;
        public int emote6;

        public RandomEmote clone() {
            RandomEmote varCopy = new randomEmote();

            varCopy.emote1 = this.emote1;
            varCopy.emote2 = this.emote2;
            varCopy.emote3 = this.emote3;
            varCopy.emote4 = this.emote4;
            varCopy.emote5 = this.emote5;
            varCopy.emote6 = this.emote6;

            return varCopy;
        }
    }

    public final static class Cast {
        public int spell;
        public int castFlags;
        public int triggerFlags;
        public int targetsLimit;

        public Cast clone() {
            Cast varCopy = new cast();

            varCopy.spell = this.spell;
            varCopy.castFlags = this.castFlags;
            varCopy.triggerFlags = this.triggerFlags;
            varCopy.targetsLimit = this.targetsLimit;

            return varCopy;
        }
    }

    public final static class CrossCast {
        public int spell;
        public int castFlags;
        public int targetType;
        public int targetParam1;
        public int targetParam2;
        public int targetParam3;

        public CrossCast clone() {
            CrossCast varCopy = new crossCast();

            varCopy.spell = this.spell;
            varCopy.castFlags = this.castFlags;
            varCopy.targetType = this.targetType;
            varCopy.targetParam1 = this.targetParam1;
            varCopy.targetParam2 = this.targetParam2;
            varCopy.targetParam3 = this.targetParam3;

            return varCopy;
        }
    }

    public final static class SummonCreature {
        public int creature;
        public int type;
        public int duration;
        public int storageID;
        public int attackInvoker;
        public int flags; // SmartActionSummonCreatureFlags
        public int count;

        public SummonCreature clone() {
            SummonCreature varCopy = new summonCreature();

            varCopy.creature = this.creature;
            varCopy.type = this.type;
            varCopy.duration = this.duration;
            varCopy.storageID = this.storageID;
            varCopy.attackInvoker = this.attackInvoker;
            varCopy.flags = this.flags;
            varCopy.count = this.count;

            return varCopy;
        }
    }

    public final static class ThreatPCT {
        public int threatINC;
        public int threatDEC;

        public ThreatPCT clone() {
            ThreatPCT varCopy = new threatPCT();

            varCopy.threatINC = this.threatINC;
            varCopy.threatDEC = this.threatDEC;

            return varCopy;
        }
    }

    public final static class CastCreatureOrGO {
        public int quest;
        public int spell;

        public CastCreatureOrGO clone() {
            CastCreatureOrGO varCopy = new castCreatureOrGO();

            varCopy.quest = this.quest;
            varCopy.spell = this.spell;

            return varCopy;
        }
    }

    public final static class Threat {
        public int threatINC;
        public int threatDEC;

        public Threat clone() {
            Threat varCopy = new threat();

            varCopy.threatINC = this.threatINC;
            varCopy.threatDEC = this.threatDEC;

            return varCopy;
        }
    }

    public final static class AutoAttack {
        public int attack;

        public AutoAttack clone() {
            AutoAttack varCopy = new autoAttack();

            varCopy.attack = this.attack;

            return varCopy;
        }
    }

    public final static class CombatMove {
        public int move;

        public CombatMove clone() {
            CombatMove varCopy = new combatMove();

            varCopy.move = this.move;

            return varCopy;
        }
    }

    public final static class SetEventPhase {
        public int phase;

        public SetEventPhase clone() {
            SetEventPhase varCopy = new setEventPhase();

            varCopy.phase = this.phase;

            return varCopy;
        }
    }

    public final static class IncEventPhase {
        public int inc;
        public int dec;

        public IncEventPhase clone() {
            IncEventPhase varCopy = new incEventPhase();

            varCopy.inc = this.inc;
            varCopy.dec = this.dec;

            return varCopy;
        }
    }

    public final static class CastedCreatureOrGO {
        public int creature;
        public int spell;

        public CastedCreatureOrGO clone() {
            CastedCreatureOrGO varCopy = new castedCreatureOrGO();

            varCopy.creature = this.creature;
            varCopy.spell = this.spell;

            return varCopy;
        }
    }

    public final static class RemoveAura {
        public int spell;
        public int charges;
        public int onlyOwnedAuras;

        public RemoveAura clone() {
            RemoveAura varCopy = new removeAura();

            varCopy.spell = this.spell;
            varCopy.charges = this.charges;
            varCopy.onlyOwnedAuras = this.onlyOwnedAuras;

            return varCopy;
        }
    }

    public final static class Follow {
        public int dist;
        public int angle;
        public int entry;
        public int credit;
        public int creditType;

        public Follow clone() {
            Follow varCopy = new follow();

            varCopy.dist = this.dist;
            varCopy.angle = this.angle;
            varCopy.entry = this.entry;
            varCopy.credit = this.credit;
            varCopy.creditType = this.creditType;

            return varCopy;
        }
    }

    public final static class RandomPhase {
        public int phase1;
        public int phase2;
        public int phase3;
        public int phase4;
        public int phase5;
        public int phase6;

        public RandomPhase clone() {
            RandomPhase varCopy = new randomPhase();

            varCopy.phase1 = this.phase1;
            varCopy.phase2 = this.phase2;
            varCopy.phase3 = this.phase3;
            varCopy.phase4 = this.phase4;
            varCopy.phase5 = this.phase5;
            varCopy.phase6 = this.phase6;

            return varCopy;
        }
    }

    public final static class RandomPhaseRange {
        public int phaseMin;
        public int phaseMax;

        public RandomPhaseRange clone() {
            RandomPhaseRange varCopy = new randomPhaseRange();

            varCopy.phaseMin = this.phaseMin;
            varCopy.phaseMax = this.phaseMax;

            return varCopy;
        }
    }

    public final static class KilledMonster {
        public int creature;

        public KilledMonster clone() {
            KilledMonster varCopy = new killedMonster();

            varCopy.creature = this.creature;

            return varCopy;
        }
    }

    public final static class SetInstanceData {
        public int field;
        public int data;
        public int type;

        public SetInstanceData clone() {
            SetInstanceData varCopy = new setInstanceData();

            varCopy.field = this.field;
            varCopy.data = this.data;
            varCopy.type = this.type;

            return varCopy;
        }
    }

    public final static class SetInstanceData64 {
        public int field;

        public SetInstanceData64 clone() {
            SetInstanceData64 varCopy = new setInstanceData64();

            varCopy.field = this.field;

            return varCopy;
        }
    }

    public final static class UpdateTemplate {
        public int creature;
        public int updateLevel;

        public UpdateTemplate clone() {
            UpdateTemplate varCopy = new updateTemplate();

            varCopy.creature = this.creature;
            varCopy.updateLevel = this.updateLevel;

            return varCopy;
        }
    }

    public final static class CallHelp {
        public int range;
        public int withEmote;

        public CallHelp clone() {
            CallHelp varCopy = new callHelp();

            varCopy.range = this.range;
            varCopy.withEmote = this.withEmote;

            return varCopy;
        }
    }

    public final static class SetSheath {
        public int sheath;

        public SetSheath clone() {
            SetSheath varCopy = new setSheath();

            varCopy.sheath = this.sheath;

            return varCopy;
        }
    }

    public final static class ForceDespawn {
        public int delay;
        public int forceRespawnTimer;

        public ForceDespawn clone() {
            ForceDespawn varCopy = new forceDespawn();

            varCopy.delay = this.delay;
            varCopy.forceRespawnTimer = this.forceRespawnTimer;

            return varCopy;
        }
    }

    public final static class InvincHP {
        public int minHP;
        public int percent;

        public InvincHP clone() {
            InvincHP varCopy = new invincHP();

            varCopy.minHP = this.minHP;
            varCopy.percent = this.percent;

            return varCopy;
        }
    }

    public final static class IngamePhaseId {
        public int id;
        public int apply;

        public IngamePhaseId clone() {
            IngamePhaseId varCopy = new ingamePhaseId();

            varCopy.id = this.id;
            varCopy.apply = this.apply;

            return varCopy;
        }
    }

    public final static class IngamePhaseGroup {
        public int groupId;
        public int apply;

        public IngamePhaseGroup clone() {
            IngamePhaseGroup varCopy = new ingamePhaseGroup();

            varCopy.groupId = this.groupId;
            varCopy.apply = this.apply;

            return varCopy;
        }
    }

    public final static class SetData {
        public int field;
        public int data;

        public SetData clone() {
            SetData varCopy = new setData();

            varCopy.field = this.field;
            varCopy.data = this.data;

            return varCopy;
        }
    }

    public final static class MoveRandom {
        public int distance;

        public MoveRandom clone() {
            MoveRandom varCopy = new moveRandom();

            varCopy.distance = this.distance;

            return varCopy;
        }
    }

    public final static class Visibility {
        public int state;

        public Visibility clone() {
            Visibility varCopy = new visibility();

            varCopy.state = this.state;

            return varCopy;
        }
    }

    public final static class SummonGO {
        public int entry;
        public int despawnTime;
        public int summonType;

        public SummonGO clone() {
            SummonGO varCopy = new summonGO();

            varCopy.entry = this.entry;
            varCopy.despawnTime = this.despawnTime;
            varCopy.summonType = this.summonType;

            return varCopy;
        }
    }

    public final static class Active {
        public int state;

        public Active clone() {
            Active varCopy = new active();

            varCopy.state = this.state;

            return varCopy;
        }
    }

    public final static class Taxi {
        public int id;

        public Taxi clone() {
            Taxi varCopy = new taxi();

            varCopy.id = this.id;

            return varCopy;
        }
    }

    public final static class WpStart {
        public int run;
        public int pathID;
        public int repeat;
        public int quest;

        public int despawnTime;
        //public uint reactState; DO NOT REUSE

        public WpStart clone() {
            WpStart varCopy = new wpStart();

            varCopy.run = this.run;
            varCopy.pathID = this.pathID;
            varCopy.repeat = this.repeat;
            varCopy.quest = this.quest;
            varCopy.despawnTime = this.despawnTime;

            return varCopy;
        }
    }

    public final static class WpPause {
        public int delay;

        public WpPause clone() {
            WpPause varCopy = new wpPause();

            varCopy.delay = this.delay;

            return varCopy;
        }
    }

    public final static class WpStop {
        public int despawnTime;
        public int quest;
        public int fail;

        public WpStop clone() {
            WpStop varCopy = new wpStop();

            varCopy.despawnTime = this.despawnTime;
            varCopy.quest = this.quest;
            varCopy.fail = this.fail;

            return varCopy;
        }
    }

    public final static class Item {
        public int entry;
        public int count;

        public Item clone() {
            Item varCopy = new item();

            varCopy.entry = this.entry;
            varCopy.count = this.count;

            return varCopy;
        }
    }

    public final static class SetRun {
        public int run;

        public SetRun clone() {
            SetRun varCopy = new setRun();

            varCopy.run = this.run;

            return varCopy;
        }
    }

    public final static class SetDisableGravity {
        public int disable;

        public SetDisableGravity clone() {
            SetDisableGravity varCopy = new setDisableGravity();

            varCopy.disable = this.disable;

            return varCopy;
        }
    }

    public final static class Teleport {
        public int mapID;

        public Teleport clone() {
            Teleport varCopy = new teleport();

            varCopy.mapID = this.mapID;

            return varCopy;
        }
    }

    public final static class SetCounter {
        public int counterId;
        public int value;
        public int reset;

        public SetCounter clone() {
            SetCounter varCopy = new setCounter();

            varCopy.counterId = this.counterId;
            varCopy.value = this.value;
            varCopy.reset = this.reset;

            return varCopy;
        }
    }

    public final static class StoreTargets {
        public int id;

        public StoreTargets clone() {
            StoreTargets varCopy = new storeTargets();

            varCopy.id = this.id;

            return varCopy;
        }
    }

    public final static class TimeEvent {
        public int id;
        public int min;
        public int max;
        public int repeatMin;
        public int repeatMax;
        public int chance;

        public TimeEvent clone() {
            TimeEvent varCopy = new timeEvent();

            varCopy.id = this.id;
            varCopy.min = this.min;
            varCopy.max = this.max;
            varCopy.repeatMin = this.repeatMin;
            varCopy.repeatMax = this.repeatMax;
            varCopy.chance = this.chance;

            return varCopy;
        }
    }

    public final static class Movie {
        public int entry;

        public Movie clone() {
            Movie varCopy = new movie();

            varCopy.entry = this.entry;

            return varCopy;
        }
    }

    public final static class Equip {
        public int entry;
        public int mask;
        public int slot1;
        public int slot2;
        public int slot3;

        public Equip clone() {
            Equip varCopy = new equip();

            varCopy.entry = this.entry;
            varCopy.mask = this.mask;
            varCopy.slot1 = this.slot1;
            varCopy.slot2 = this.slot2;
            varCopy.slot3 = this.slot3;

            return varCopy;
        }
    }

    public final static class Flag {
        public int flag;

        public Flag clone() {
            Flag varCopy = new flag();

            varCopy.flag = this.flag;

            return varCopy;
        }
    }

    public final static class SetunitByte {
        public int byte1;
        public int type;

        public SetunitByte clone() {
            SetunitByte varCopy = new setunitByte();

            varCopy.byte1 = this.byte1;
            varCopy.type = this.type;

            return varCopy;
        }
    }

    public final static class DelunitByte {
        public int byte1;
        public int type;

        public DelunitByte clone() {
            DelunitByte varCopy = new delunitByte();

            varCopy.byte1 = this.byte1;
            varCopy.type = this.type;

            return varCopy;
        }
    }

    public final static class TimedActionList {
        public int id;
        public int timerType;
        public int allowOverride;

        public TimedActionList clone() {
            TimedActionList varCopy = new timedActionList();

            varCopy.id = this.id;
            varCopy.timerType = this.timerType;
            varCopy.allowOverride = this.allowOverride;

            return varCopy;
        }
    }

    public final static class RandTimedActionList {
        public int actionList1;
        public int actionList2;
        public int actionList3;
        public int actionList4;
        public int actionList5;
        public int actionList6;

        public RandTimedActionList clone() {
            RandTimedActionList varCopy = new randTimedActionList();

            varCopy.actionList1 = this.actionList1;
            varCopy.actionList2 = this.actionList2;
            varCopy.actionList3 = this.actionList3;
            varCopy.actionList4 = this.actionList4;
            varCopy.actionList5 = this.actionList5;
            varCopy.actionList6 = this.actionList6;

            return varCopy;
        }
    }

    public final static class RandRangeTimedActionList {
        public int idMin;
        public int idMax;

        public RandRangeTimedActionList clone() {
            RandRangeTimedActionList varCopy = new randRangeTimedActionList();

            varCopy.idMin = this.idMin;
            varCopy.idMax = this.idMax;

            return varCopy;
        }
    }

    public final static class InterruptSpellCasting {
        public int withDelayed;
        public int spell_id;
        public int withInstant;

        public InterruptSpellCasting clone() {
            InterruptSpellCasting varCopy = new interruptSpellCasting();

            varCopy.withDelayed = this.withDelayed;
            varCopy.spell_id = this.spell_id;
            varCopy.withInstant = this.withInstant;

            return varCopy;
        }
    }

    public final static class Jump {
        public int speedXY;
        public int speedZ;
        public int gravity;
        public int useDefaultGravity;
        public int pointId;
        public int contactDistance;

        public Jump clone() {
            Jump varCopy = new jump();

            varCopy.speedXY = this.speedXY;
            varCopy.speedZ = this.speedZ;
            varCopy.gravity = this.gravity;
            varCopy.useDefaultGravity = this.useDefaultGravity;
            varCopy.pointId = this.pointId;
            varCopy.contactDistance = this.contactDistance;

            return varCopy;
        }
    }

    public final static class FleeAssist {
        public int withEmote;

        public FleeAssist clone() {
            FleeAssist varCopy = new fleeAssist();

            varCopy.withEmote = this.withEmote;

            return varCopy;
        }
    }

    public final static class EnableTempGO {
        public int duration;

        public EnableTempGO clone() {
            EnableTempGO varCopy = new enableTempGO();

            varCopy.duration = this.duration;

            return varCopy;
        }
    }

    public final static class MoveToPos {
        public int pointId;
        public int transport;
        public int disablePathfinding;
        public int contactDistance;

        public MoveToPos clone() {
            MoveToPos varCopy = new moveToPos();

            varCopy.pointId = this.pointId;
            varCopy.transport = this.transport;
            varCopy.disablePathfinding = this.disablePathfinding;
            varCopy.contactDistance = this.contactDistance;

            return varCopy;
        }
    }

    public final static class SendGossipMenu {
        public int gossipMenuId;
        public int gossipNpcTextId;

        public SendGossipMenu clone() {
            SendGossipMenu varCopy = new sendGossipMenu();

            varCopy.gossipMenuId = this.gossipMenuId;
            varCopy.gossipNpcTextId = this.gossipNpcTextId;

            return varCopy;
        }
    }

    public final static class SetGoLootState {
        public int state;

        public SetGoLootState clone() {
            SetGoLootState varCopy = new setGoLootState();

            varCopy.state = this.state;

            return varCopy;
        }
    }

    public final static class SendTargetToTarget {
        public int id;

        public SendTargetToTarget clone() {
            SendTargetToTarget varCopy = new sendTargetToTarget();

            varCopy.id = this.id;

            return varCopy;
        }
    }

    public final static class SetRangedMovement {
        public int distance;
        public int angle;

        public SetRangedMovement clone() {
            SetRangedMovement varCopy = new setRangedMovement();

            varCopy.distance = this.distance;
            varCopy.angle = this.angle;

            return varCopy;
        }
    }

    public final static class SetHealthRegen {
        public int regenHealth;

        public SetHealthRegen clone() {
            SetHealthRegen varCopy = new setHealthRegen();

            varCopy.regenHealth = this.regenHealth;

            return varCopy;
        }
    }

    public final static class SetRoot {
        public int root;

        public SetRoot clone() {
            SetRoot varCopy = new setRoot();

            varCopy.root = this.root;

            return varCopy;
        }
    }

    public final static class GoState {
        public int state;

        public GoState clone() {
            GoState varCopy = new goState();

            varCopy.state = this.state;

            return varCopy;
        }
    }

    public final static class CreatureGroup {
        public int group;
        public int attackInvoker;

        public CreatureGroup clone() {
            CreatureGroup varCopy = new creatureGroup();

            varCopy.group = this.group;
            varCopy.attackInvoker = this.attackInvoker;

            return varCopy;
        }
    }

    public final static class Power {
        public int powerType;
        public int newPower;

        public Power clone() {
            Power varCopy = new power();

            varCopy.powerType = this.powerType;
            varCopy.newPower = this.newPower;

            return varCopy;
        }
    }

    public final static class GameEventStop {
        public int id;

        public GameEventStop clone() {
            GameEventStop varCopy = new gameEventStop();

            varCopy.id = this.id;

            return varCopy;
        }
    }

    public final static class GameEventStart {
        public int id;

        public GameEventStart clone() {
            GameEventStart varCopy = new gameEventStart();

            varCopy.id = this.id;

            return varCopy;
        }
    }

    public final static class ClosestWaypointFromList {
        public int wp1;
        public int wp2;
        public int wp3;
        public int wp4;
        public int wp5;
        public int wp6;

        public ClosestWaypointFromList clone() {
            ClosestWaypointFromList varCopy = new closestWaypointFromList();

            varCopy.wp1 = this.wp1;
            varCopy.wp2 = this.wp2;
            varCopy.wp3 = this.wp3;
            varCopy.wp4 = this.wp4;
            varCopy.wp5 = this.wp5;
            varCopy.wp6 = this.wp6;

            return varCopy;
        }
    }

    public final static class MoveOffset {
        public int pointId;

        public MoveOffset clone() {
            MoveOffset varCopy = new moveOffset();

            varCopy.pointId = this.pointId;

            return varCopy;
        }
    }

    public final static class RandomSound {
        public int sound1;
        public int sound2;
        public int sound3;
        public int sound4;
        public int onlySelf;
        public int distance;

        public RandomSound clone() {
            RandomSound varCopy = new randomSound();

            varCopy.sound1 = this.sound1;
            varCopy.sound2 = this.sound2;
            varCopy.sound3 = this.sound3;
            varCopy.sound4 = this.sound4;
            varCopy.onlySelf = this.onlySelf;
            varCopy.distance = this.distance;

            return varCopy;
        }
    }

    public final static class CorpseDelay {
        public int timer;
        public int includeDecayRatio;

        public CorpseDelay clone() {
            CorpseDelay varCopy = new corpseDelay();

            varCopy.timer = this.timer;
            varCopy.includeDecayRatio = this.includeDecayRatio;

            return varCopy;
        }
    }

    public final static class DisableEvade {
        public int disable;

        public DisableEvade clone() {
            DisableEvade varCopy = new disableEvade();

            varCopy.disable = this.disable;

            return varCopy;
        }
    }

    public final static class GroupSpawn {
        public int groupId;
        public int minDelay;
        public int maxDelay;
        public int spawnflags;

        public GroupSpawn clone() {
            GroupSpawn varCopy = new groupSpawn();

            varCopy.groupId = this.groupId;
            varCopy.minDelay = this.minDelay;
            varCopy.maxDelay = this.maxDelay;
            varCopy.spawnflags = this.spawnflags;

            return varCopy;
        }
    }

    public final static class LoadEquipment {
        public int id;
        public int force;

        public LoadEquipment clone() {
            LoadEquipment varCopy = new loadEquipment();

            varCopy.id = this.id;
            varCopy.force = this.force;

            return varCopy;
        }
    }

    public final static class RandomTimedEvent {
        public int minId;
        public int maxId;

        public RandomTimedEvent clone() {
            RandomTimedEvent varCopy = new randomTimedEvent();

            varCopy.minId = this.minId;
            varCopy.maxId = this.maxId;

            return varCopy;
        }
    }

    public final static class PauseMovement {
        public int movementSlot;
        public int pauseTimer;
        public int force;

        public PauseMovement clone() {
            PauseMovement varCopy = new pauseMovement();

            varCopy.movementSlot = this.movementSlot;
            varCopy.pauseTimer = this.pauseTimer;
            varCopy.force = this.force;

            return varCopy;
        }
    }

    public final static class RespawnData {
        public int spawnType;
        public int spawnId;

        public RespawnData clone() {
            RespawnData varCopy = new respawnData();

            varCopy.spawnType = this.spawnType;
            varCopy.spawnId = this.spawnId;

            return varCopy;
        }
    }

    public final static class AnimKit {
        public int animKit;
        public int type;

        public AnimKit clone() {
            AnimKit varCopy = new animKit();

            varCopy.animKit = this.animKit;
            varCopy.type = this.type;

            return varCopy;
        }
    }

    public final static class Scene {
        public int sceneId;

        public Scene clone() {
            Scene varCopy = new scene();

            varCopy.sceneId = this.sceneId;

            return varCopy;
        }
    }

    public final static class Cinematic {
        public int entry;

        public Cinematic clone() {
            Cinematic varCopy = new cinematic();

            varCopy.entry = this.entry;

            return varCopy;
        }
    }

    public final static class MovementSpeed {
        public int movementType;
        public int speedInteger;
        public int speedFraction;

        public MovementSpeed clone() {
            MovementSpeed varCopy = new movementSpeed();

            varCopy.movementType = this.movementType;
            varCopy.speedInteger = this.speedInteger;
            varCopy.speedFraction = this.speedFraction;

            return varCopy;
        }
    }

    public final static class SpellVisualKit {
        public int spellVisualKitId;
        public int kitType;
        public int duration;

        public SpellVisualKit clone() {
            SpellVisualKit varCopy = new spellVisualKit();

            varCopy.spellVisualKitId = this.spellVisualKitId;
            varCopy.kitType = this.kitType;
            varCopy.duration = this.duration;

            return varCopy;
        }
    }

    public final static class OverrideLight {
        public int zoneId;
        public int areaLightId;
        public int overrideLightId;
        public int transitionMilliseconds;

        public OverrideLight clone() {
            OverrideLight varCopy = new overrideLight();

            varCopy.zoneId = this.zoneId;
            varCopy.areaLightId = this.areaLightId;
            varCopy.overrideLightId = this.overrideLightId;
            varCopy.transitionMilliseconds = this.transitionMilliseconds;

            return varCopy;
        }
    }

    public final static class OverrideWeather {
        public int zoneId;
        public int weatherId;
        public int intensity;

        public OverrideWeather clone() {
            OverrideWeather varCopy = new overrideWeather();

            varCopy.zoneId = this.zoneId;
            varCopy.weatherId = this.weatherId;
            varCopy.intensity = this.intensity;

            return varCopy;
        }
    }

    public final static class SetHover {
        public int enable;

        public SetHover clone() {
            SetHover varCopy = new setHover();

            varCopy.enable = this.enable;

            return varCopy;
        }
    }

    public final static class Evade {
        public int toRespawnPosition;

        public Evade clone() {
            Evade varCopy = new evade();

            varCopy.toRespawnPosition = this.toRespawnPosition;

            return varCopy;
        }
    }

    public final static class SetHealthPct {
        public int percent;

        public SetHealthPct clone() {
            SetHealthPct varCopy = new setHealthPct();

            varCopy.percent = this.percent;

            return varCopy;
        }
    }

    public final static class Conversation {
        public int id;

        public Conversation clone() {
            Conversation varCopy = new conversation();

            varCopy.id = this.id;

            return varCopy;
        }
    }

    public final static class SetImmunePC {
        public int immunePC;

        public SetImmunePC clone() {
            SetImmunePC varCopy = new setImmunePC();

            varCopy.immunePC = this.immunePC;

            return varCopy;
        }
    }

    public final static class SetImmuneNPC {
        public int immuneNPC;

        public SetImmuneNPC clone() {
            SetImmuneNPC varCopy = new setImmuneNPC();

            varCopy.immuneNPC = this.immuneNPC;

            return varCopy;
        }
    }

    public final static class SetUninteractible {
        public int uninteractible;

        public SetUninteractible clone() {
            SetUninteractible varCopy = new setUninteractible();

            varCopy.uninteractible = this.uninteractible;

            return varCopy;
        }
    }

    public final static class ActivateGameObject {
        public int gameObjectAction;
        public int param;

        public ActivateGameObject clone() {
            ActivateGameObject varCopy = new activateGameObject();

            varCopy.gameObjectAction = this.gameObjectAction;
            varCopy.param = this.param;

            return varCopy;
        }
    }

    public final static class AddToStoredTargets {
        public int id;

        public AddToStoredTargets clone() {
            AddToStoredTargets varCopy = new addToStoredTargets();

            varCopy.id = this.id;

            return varCopy;
        }
    }

    public final static class BecomePersonalClone {
        public int type;
        public int duration;

        public BecomePersonalClone clone() {
            BecomePersonalClone varCopy = new becomePersonalClone();

            varCopy.type = this.type;
            varCopy.duration = this.duration;

            return varCopy;
        }
    }

    public final static class TriggerGameEvent {
        public int eventId;
        public int useSaiTargetAsGameEventSource;

        public TriggerGameEvent clone() {
            TriggerGameEvent varCopy = new triggerGameEvent();

            varCopy.eventId = this.eventId;
            varCopy.useSaiTargetAsGameEventSource = this.useSaiTargetAsGameEventSource;

            return varCopy;
        }
    }

    public final static class DoAction {
        public int actionId;

        public DoAction clone() {
            DoAction varCopy = new doAction();

            varCopy.actionId = this.actionId;

            return varCopy;
        }
    }


    ///#endregion

    public final static class Raw {
        public int param1;
        public int param2;
        public int param3;
        public int param4;
        public int param5;
        public int param6;
        public int param7;

        public Raw clone() {
            Raw varCopy = new raw();

            varCopy.param1 = this.param1;
            varCopy.param2 = this.param2;
            varCopy.param3 = this.param3;
            varCopy.param4 = this.param4;
            varCopy.param5 = this.param5;
            varCopy.param6 = this.param6;
            varCopy.param7 = this.param7;

            return varCopy;
        }
    }
}
