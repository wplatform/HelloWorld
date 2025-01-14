package com.github.azeroth.game.domain.script;


import com.github.azeroth.defines.ChatMsg;


public final class ScriptInfo {

    public ScriptsType type;


    public int id;


    public int delay;


    public ScriptCommand command;


    public Raw raw = new Raw();


    public Talk talk = new Talk();


    public Emote emote = new Emote();


    public FieldSet fieldSet = new FieldSet();


    public MoveTo moveTo = new MoveTo();


    public FlagToggle flagToggle = new FlagToggle();


    public TeleportTo teleportTo = new TeleportTo();


    public QuestExplored questExplored = new QuestExplored();


    public KillCredit killCredit = new KillCredit();


    public RespawnGameObject respawnGameObject = new RespawnGameObject();


    public TempSummonCreature tempSummonCreature = new TempSummonCreature();


    public ToggleDoor toggleDoor = new ToggleDoor();


    public RemoveAura removeAura = new RemoveAura();


    public CastSpell castSpell = new CastSpell();


    public PlaySound playSound = new PlaySound();


    public CreateItem createItem = new CreateItem();


    public DespawnSelf despawnSelf = new DespawnSelf();


    public LoadPath loadPath = new LoadPath();


    public CallScript callScript = new CallScript();


    public Kill kill = new Kill();


    public Orientation orientation = new Orientation();


    public Equip equip = new Equip();


    public Model model = new Model();


    public PlayMovie playMovie = new PlayMovie();


    public Movement movement = new Movement();


    public PlayAnimKit playAnimKit = new PlayAnimKit();


    ///#region Structs


    public class Raw {
        public int[] nData = new int[3];
        public float[] fData = new float[4];
    }

    public final static class Talk // TALK (0)
    {
        public ChatMsg chatType = ChatMsg.values()[0]; // datalong
        public int flags; // datalong2
        public int textID; // dataint

    }

    public final static class Emote // EMOTE (1)
    {
        public int emoteID; // datalong
        public int flags; // datalong2

    }

    public final static class FieldSet // FIELDSET (2)
    {
        public int fieldID; // datalong
        public int fieldValue; // datalong2

    }

    public final static class MoveTo // MOVETO (3)
    {
        public int unused1; // datalong
        public int travelTime; // datalong2
        public int unused2; // dataint

        public float destX;
        public float destY;
        public float destZ;

    }

    public final static class FlagToggle // FLAGSET (4)
    {
        // FLAGREMOVE (5)
        public int fieldID; // datalong
        public int fieldValue; // datalong2

    }

    public final static class TeleportTo // TELEPORTTO (6)
    {
        public int mapID; // datalong
        public int flags; // datalong2
        public int unused1; // dataint

        public float destX;
        public float destY;
        public float destZ;
        public float orientation;

    }

    public final static class QuestExplored // QUESTEXPLORED (7)
    {
        public int questID; // datalong
        public int distance; // datalong2

    }

    public final static class KillCredit // KILLCREDIT (8)
    {
        public int creatureEntry; // datalong
        public int flags; // datalong2

    }

    public final static class RespawnGameObject // RESPAWNGAMEOBJECT (9)
    {
        public int GOGuid; // datalong
        public int despawnDelay; // datalong2

    }

    public final static class TempSummonCreature // TEMPSUMMONCREATURE (10)
    {
        public int creatureEntry; // datalong
        public int despawnDelay; // datalong2
        public int unused1; // dataint

        public float posX;
        public float posY;
        public float posZ;
        public float orientation;

    }

    public final static class ToggleDoor // CLOSEDOOR (12)
    {
        // OPENDOOR (11)
        public int GOGuid; // datalong
        public int resetDelay; // datalong2

    }

    // ACTIVATEOBJECT (13)

    public final static class RemoveAura // REMOVEAURA (14)
    {
        public int spellID; // datalong
        public int flags; // datalong2

    }

    public final static class CastSpell // CASTSPELL (15)
    {
        public int spellID; // datalong
        public int flags; // datalong2
        public int creatureEntry; // dataint

        public float searchRadius;

    }

    public final static class PlaySound // PLAYSOUND (16)
    {
        public int soundID; // datalong
        public int flags; // datalong2

    }

    public final static class CreateItem // CREATEITEM (17)
    {
        public int itemEntry; // datalong
        public int amount; // datalong2

    }

    public final static class DespawnSelf // DESPAWNSELF (18)
    {
        public int despawnDelay; // datalong

    }

    public final static class LoadPath // LOADPATH (20)
    {
        public int pathID; // datalong
        public int isRepeatable; // datalong2

    }

    public final static class CallScript // CALLSCRIPTTOUNIT (21)
    {
        public int creatureEntry; // datalong
        public int scriptID; // datalong2
        public int scriptType; // dataint

    }

    public final static class Kill // KILL (22)
    {
        public int unused1; // datalong
        public int unused2; // datalong2
        public int removeCorpse; // dataint

    }

    public final static class Orientation // ORIENTATION (30)
    {
        public int flags; // datalong
        public int unused1; // datalong2
        public int unused2; // dataint

        public float unused3;
        public float unused4;
        public float unused5;
        public float _Orientation;

    }

    public final static class Equip // EQUIP (31)
    {
        public int equipmentID; // datalong


    }

    public final static class Model // MODEL (32)
    {
        public int modelID; // datalong

    }

    // CLOSEGOSSIP (33)

    public final static class PlayMovie // PLAYMOVIE (34)
    {
        public int movieID; // datalong

    }

    public final static class Movement // SCRIPT_COMMAND_MOVEMENT (35)
    {
        public int movementType; // datalong
        public int movementDistance; // datalong2
        public int path; // dataint

    }

    public final static class PlayAnimKit // SCRIPT_COMMAND_PLAY_ANIMKIT (36)
    {
        public int animKitID; // datalong

    }


}
