package com.github.azeroth.game.ai;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
public final class SmartEvent {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public SmartEvents type = SmartEvents.values()[0];

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public int event_phase_mask;

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public int event_chance;

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public SmartEventFlags event_flags = SmartEventFlags.values()[0];

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public minMaxRepeat minMaxRepeat = new minMaxRepeat();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public kill kill = new kill();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public spellHit spellHit = new spellHit();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public los los = new los();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public respawn respawn = new respawn();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public minMax minMax = new minMax();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public targetCasting targetCasting = new targetCasting();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public friendlyCC friendlyCC = new friendlyCC();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public missingBuff missingBuff = new missingBuff();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public summoned summoned = new summoned();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public quest quest = new quest();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public questObjective questObjective = new questObjective();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public emote emote = new emote();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public aura aura = new aura();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public charm charm = new charm();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public movementInform movementInform = new movementInform();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public dataSet dataSet = new dataSet();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public waypoint waypoint = new waypoint();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public transportAddCreature transportAddCreature = new transportAddCreature();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public transportRelocate transportRelocate = new transportRelocate();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public instancePlayerEnter instancePlayerEnter = new instancePlayerEnter();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public areatrigger areatrigger = new areatrigger();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public textOver textOver = new textOver();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public timedEvent timedEvent = new timedEvent();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public gossipHello gossipHello = new gossipHello();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public gossip gossip = new gossip();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public gameEvent gameEvent = new gameEvent();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public goLootStateChanged goLootStateChanged = new goLootStateChanged();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public eventInform eventInform = new eventInform();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public doAction doAction = new doAction();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public friendlyHealthPct friendlyHealthPct = new friendlyHealthPct();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public distance distance = new distance();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public counter counter = new counter();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public spellCast spellCast = new spellCast();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public spell spell = new spell();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public raw raw = new raw();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public String param_string;

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
    ///#region Structs

    public SmartEvent clone() {
        SmartEvent varCopy = new smartEvent();

        varCopy.type = this.type;
        varCopy.event_phase_mask = this.event_phase_mask;
        varCopy.event_chance = this.event_chance;
        varCopy.event_flags = this.event_flags;
        varCopy.minMaxRepeat = this.minMaxRepeat;
        varCopy.kill = this.kill;
        varCopy.spellHit = this.spellHit;
        varCopy.los = this.los;
        varCopy.respawn = this.respawn;
        varCopy.minMax = this.minMax;
        varCopy.targetCasting = this.targetCasting;
        varCopy.friendlyCC = this.friendlyCC;
        varCopy.missingBuff = this.missingBuff;
        varCopy.summoned = this.summoned;
        varCopy.quest = this.quest;
        varCopy.questObjective = this.questObjective;
        varCopy.emote = this.emote;
        varCopy.aura = this.aura;
        varCopy.charm = this.charm;
        varCopy.movementInform = this.movementInform;
        varCopy.dataSet = this.dataSet;
        varCopy.waypoint = this.waypoint;
        varCopy.transportAddCreature = this.transportAddCreature;
        varCopy.transportRelocate = this.transportRelocate;
        varCopy.instancePlayerEnter = this.instancePlayerEnter;
        varCopy.areatrigger = this.areatrigger;
        varCopy.textOver = this.textOver;
        varCopy.timedEvent = this.timedEvent;
        varCopy.gossipHello = this.gossipHello;
        varCopy.gossip = this.gossip;
        varCopy.gameEvent = this.gameEvent;
        varCopy.goLootStateChanged = this.goLootStateChanged;
        varCopy.eventInform = this.eventInform;
        varCopy.doAction = this.doAction;
        varCopy.friendlyHealthPct = this.friendlyHealthPct;
        varCopy.distance = this.distance;
        varCopy.counter = this.counter;
        varCopy.spellCast = this.spellCast;
        varCopy.spell = this.spell;
        varCopy.raw = this.raw;
        varCopy.param_string = this.param_string;

        return varCopy;
    }

    public final static class MinMaxRepeat {
        public int min;
        public int max;
        public int repeatMin;
        public int repeatMax;

        public MinMaxRepeat clone() {
            MinMaxRepeat varCopy = new minMaxRepeat();

            varCopy.min = this.min;
            varCopy.max = this.max;
            varCopy.repeatMin = this.repeatMin;
            varCopy.repeatMax = this.repeatMax;

            return varCopy;
        }
    }

    public final static class Kill {
        public int cooldownMin;
        public int cooldownMax;
        public int playerOnly;
        public int creature;

        public Kill clone() {
            Kill varCopy = new kill();

            varCopy.cooldownMin = this.cooldownMin;
            varCopy.cooldownMax = this.cooldownMax;
            varCopy.playerOnly = this.playerOnly;
            varCopy.creature = this.creature;

            return varCopy;
        }
    }

    public final static class SpellHit {
        public int spell;
        public int school;
        public int cooldownMin;
        public int cooldownMax;

        public SpellHit clone() {
            SpellHit varCopy = new spellHit();

            varCopy.spell = this.spell;
            varCopy.school = this.school;
            varCopy.cooldownMin = this.cooldownMin;
            varCopy.cooldownMax = this.cooldownMax;

            return varCopy;
        }
    }

    public final static class Los {
        public int hostilityMode;
        public int maxDist;
        public int cooldownMin;
        public int cooldownMax;
        public int playerOnly;

        public Los clone() {
            Los varCopy = new los();

            varCopy.hostilityMode = this.hostilityMode;
            varCopy.maxDist = this.maxDist;
            varCopy.cooldownMin = this.cooldownMin;
            varCopy.cooldownMax = this.cooldownMax;
            varCopy.playerOnly = this.playerOnly;

            return varCopy;
        }
    }

    public final static class Respawn {
        public int type;
        public int map;
        public int area;

        public Respawn clone() {
            Respawn varCopy = new respawn();

            varCopy.type = this.type;
            varCopy.map = this.map;
            varCopy.area = this.area;

            return varCopy;
        }
    }

    public final static class MinMax {
        public int repeatMin;
        public int repeatMax;

        public MinMax clone() {
            MinMax varCopy = new minMax();

            varCopy.repeatMin = this.repeatMin;
            varCopy.repeatMax = this.repeatMax;

            return varCopy;
        }
    }

    public final static class TargetCasting {
        public int repeatMin;
        public int repeatMax;
        public int spellId;

        public TargetCasting clone() {
            TargetCasting varCopy = new targetCasting();

            varCopy.repeatMin = this.repeatMin;
            varCopy.repeatMax = this.repeatMax;
            varCopy.spellId = this.spellId;

            return varCopy;
        }
    }

    public final static class FriendlyCC {
        public int radius;
        public int repeatMin;
        public int repeatMax;

        public FriendlyCC clone() {
            FriendlyCC varCopy = new friendlyCC();

            varCopy.radius = this.radius;
            varCopy.repeatMin = this.repeatMin;
            varCopy.repeatMax = this.repeatMax;

            return varCopy;
        }
    }

    public final static class MissingBuff {
        public int spell;
        public int radius;
        public int repeatMin;
        public int repeatMax;

        public MissingBuff clone() {
            MissingBuff varCopy = new missingBuff();

            varCopy.spell = this.spell;
            varCopy.radius = this.radius;
            varCopy.repeatMin = this.repeatMin;
            varCopy.repeatMax = this.repeatMax;

            return varCopy;
        }
    }

    public final static class Summoned {
        public int creature;
        public int cooldownMin;
        public int cooldownMax;

        public Summoned clone() {
            Summoned varCopy = new summoned();

            varCopy.creature = this.creature;
            varCopy.cooldownMin = this.cooldownMin;
            varCopy.cooldownMax = this.cooldownMax;

            return varCopy;
        }
    }

    public final static class Quest {
        public int questId;
        public int cooldownMin;
        public int cooldownMax;

        public Quest clone() {
            Quest varCopy = new quest();

            varCopy.questId = this.questId;
            varCopy.cooldownMin = this.cooldownMin;
            varCopy.cooldownMax = this.cooldownMax;

            return varCopy;
        }
    }

    public final static class QuestObjective {
        public int id;

        public QuestObjective clone() {
            QuestObjective varCopy = new questObjective();

            varCopy.id = this.id;

            return varCopy;
        }
    }

    public final static class Emote {
        public int emoteId;
        public int cooldownMin;
        public int cooldownMax;

        public Emote clone() {
            Emote varCopy = new emote();

            varCopy.emoteId = this.emoteId;
            varCopy.cooldownMin = this.cooldownMin;
            varCopy.cooldownMax = this.cooldownMax;

            return varCopy;
        }
    }

    public final static class Aura {
        public int spell;
        public int count;
        public int repeatMin;
        public int repeatMax;

        public Aura clone() {
            Aura varCopy = new aura();

            varCopy.spell = this.spell;
            varCopy.count = this.count;
            varCopy.repeatMin = this.repeatMin;
            varCopy.repeatMax = this.repeatMax;

            return varCopy;
        }
    }

    public final static class Charm {
        public int onRemove;

        public Charm clone() {
            Charm varCopy = new charm();

            varCopy.onRemove = this.onRemove;

            return varCopy;
        }
    }

    public final static class MovementInform {
        public int type;
        public int id;

        public MovementInform clone() {
            MovementInform varCopy = new movementInform();

            varCopy.type = this.type;
            varCopy.id = this.id;

            return varCopy;
        }
    }

    public final static class DataSet {
        public int id;
        public int value;
        public int cooldownMin;
        public int cooldownMax;

        public DataSet clone() {
            DataSet varCopy = new dataSet();

            varCopy.id = this.id;
            varCopy.value = this.value;
            varCopy.cooldownMin = this.cooldownMin;
            varCopy.cooldownMax = this.cooldownMax;

            return varCopy;
        }
    }

    public final static class Waypoint {
        public int pointID;
        public int pathID;

        public Waypoint clone() {
            Waypoint varCopy = new waypoint();

            varCopy.pointID = this.pointID;
            varCopy.pathID = this.pathID;

            return varCopy;
        }
    }

    public final static class TransportAddCreature {
        public int creature;

        public TransportAddCreature clone() {
            TransportAddCreature varCopy = new transportAddCreature();

            varCopy.creature = this.creature;

            return varCopy;
        }
    }

    public final static class TransportRelocate {
        public int pointID;

        public TransportRelocate clone() {
            TransportRelocate varCopy = new transportRelocate();

            varCopy.pointID = this.pointID;

            return varCopy;
        }
    }

    public final static class InstancePlayerEnter {
        public int team;
        public int cooldownMin;
        public int cooldownMax;

        public InstancePlayerEnter clone() {
            InstancePlayerEnter varCopy = new instancePlayerEnter();

            varCopy.team = this.team;
            varCopy.cooldownMin = this.cooldownMin;
            varCopy.cooldownMax = this.cooldownMax;

            return varCopy;
        }
    }

    public final static class Areatrigger {
        public int id;

        public Areatrigger clone() {
            Areatrigger varCopy = new areatrigger();

            varCopy.id = this.id;

            return varCopy;
        }
    }

    public final static class TextOver {
        public int textGroupID;
        public int creatureEntry;

        public TextOver clone() {
            TextOver varCopy = new textOver();

            varCopy.textGroupID = this.textGroupID;
            varCopy.creatureEntry = this.creatureEntry;

            return varCopy;
        }
    }

    public final static class TimedEvent {
        public int id;

        public TimedEvent clone() {
            TimedEvent varCopy = new timedEvent();

            varCopy.id = this.id;

            return varCopy;
        }
    }

    public final static class GossipHello {
        public int filter;

        public GossipHello clone() {
            GossipHello varCopy = new gossipHello();

            varCopy.filter = this.filter;

            return varCopy;
        }
    }

    public final static class Gossip {
        public int sender;
        public int action;

        public Gossip clone() {
            Gossip varCopy = new gossip();

            varCopy.sender = this.sender;
            varCopy.action = this.action;

            return varCopy;
        }
    }

    public final static class GameEvent {
        public int gameEventId;

        public GameEvent clone() {
            GameEvent varCopy = new gameEvent();

            varCopy.gameEventId = this.gameEventId;

            return varCopy;
        }
    }

    public final static class GoLootStateChanged {
        public int lootState;

        public GoLootStateChanged clone() {
            GoLootStateChanged varCopy = new goLootStateChanged();

            varCopy.lootState = this.lootState;

            return varCopy;
        }
    }

    public final static class EventInform {
        public int eventId;

        public EventInform clone() {
            EventInform varCopy = new eventInform();

            varCopy.eventId = this.eventId;

            return varCopy;
        }
    }

    public final static class DoAction {
        public int eventId;

        public DoAction clone() {
            DoAction varCopy = new doAction();

            varCopy.eventId = this.eventId;

            return varCopy;
        }
    }

    public final static class FriendlyHealthPct {
        public int minHpPct;
        public int maxHpPct;
        public int repeatMin;
        public int repeatMax;
        public int radius;

        public FriendlyHealthPct clone() {
            FriendlyHealthPct varCopy = new friendlyHealthPct();

            varCopy.minHpPct = this.minHpPct;
            varCopy.maxHpPct = this.maxHpPct;
            varCopy.repeatMin = this.repeatMin;
            varCopy.repeatMax = this.repeatMax;
            varCopy.radius = this.radius;

            return varCopy;
        }
    }

    public final static class Distance {
        public int guid;
        public int entry;
        public int dist;
        public int repeat;

        public Distance clone() {
            Distance varCopy = new distance();

            varCopy.guid = this.guid;
            varCopy.entry = this.entry;
            varCopy.dist = this.dist;
            varCopy.repeat = this.repeat;

            return varCopy;
        }
    }

    public final static class Counter {
        public int id;
        public int value;
        public int cooldownMin;
        public int cooldownMax;

        public Counter clone() {
            Counter varCopy = new counter();

            varCopy.id = this.id;
            varCopy.value = this.value;
            varCopy.cooldownMin = this.cooldownMin;
            varCopy.cooldownMax = this.cooldownMax;

            return varCopy;
        }
    }

    public final static class SpellCast {
        public int spell;
        public int cooldownMin;
        public int cooldownMax;

        public SpellCast clone() {
            SpellCast varCopy = new spellCast();

            varCopy.spell = this.spell;
            varCopy.cooldownMin = this.cooldownMin;
            varCopy.cooldownMax = this.cooldownMax;

            return varCopy;
        }
    }

    public final static class Spell {
        public int effIndex;

        public Spell clone() {
            Spell varCopy = new spell();

            varCopy.effIndex = this.effIndex;

            return varCopy;
        }
    }

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
    ///#endregion

    public final static class Raw {
        public int param1;
        public int param2;
        public int param3;
        public int param4;
        public int param5;

        public Raw clone() {
            Raw varCopy = new raw();

            varCopy.param1 = this.param1;
            varCopy.param2 = this.param2;
            varCopy.param3 = this.param3;
            varCopy.param4 = this.param4;
            varCopy.param5 = this.param5;

            return varCopy;
        }
    }
}
