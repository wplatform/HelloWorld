package com.github.mmo.game.service.domain;


// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
public final class ScriptInfo
{
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public ScriptsType type = ScriptsType.values()[0];

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public int id;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public int delay;

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public ScriptCommands command = ScriptCommands.values()[0];

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public raw raw = new raw();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public talk talk = new talk();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public emote emote = new emote();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public fieldset fieldSet = new fieldset();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public moveto moveTo = new moveto();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public flagtoggle flagToggle = new flagtoggle();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public teleportto teleportTo = new teleportto();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public questexplored questExplored = new questexplored();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public killcredit killCredit = new killcredit();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public respawngameobject respawnGameObject = new respawngameobject();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public tempsummoncreature tempSummonCreature = new tempsummoncreature();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public toggledoor toggleDoor = new toggledoor();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public removeaura removeAura = new removeaura();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public castspell castSpell = new castspell();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public playsound playSound = new playsound();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public createitem createItem = new createitem();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public despawnself despawnSelf = new despawnself();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public loadpath loadPath = new loadpath();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public Callscript callScript = new Callscript();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public kill kill = new kill();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public orientation orientation = new orientation();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public equip equip = new equip();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public model model = new model();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public playmovie playMovie = new playmovie();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public movement movement = new movement();

// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
	public playanimkit playAnimKit = new playanimkit();

	public String getDebugInfo()
	{
		return String.format("%1$s ('%2$s' script id: %3$s)", command, global.getObjectMgr().getScriptsTableNameByType(type), id);
	}

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
		///#region Structs

// C# TO JAVA CONVERTER TASK: C# 'unsafe' code is not converted by C# to Java Converter:
//	public unsafe struct raw
//		{
//			public fixed uint nData[3];
//			public fixed float fData[4];
//		}

	public final static class talk // TALK (0)
	{
		public ChatMsg chatType = ChatMsg.values()[0]; // datalong
		public eScriptflags flags = eScriptFlags.values()[0]; // datalong2
		public int textID; // dataint

		public talk clone()
		{
			talk varCopy = new talk();

			varCopy.chatType = this.chatType;
			varCopy.flags = this.flags;
			varCopy.textID = this.textID;

			return varCopy;
		}
	}

	public final static class emote // EMOTE (1)
	{
		public int emoteID; // datalong
		public eScriptFlags flags = eScriptFlags.values()[0]; // datalong2

		public emote clone()
		{
			emote varCopy = new emote();

			varCopy.emoteID = this.emoteID;
			varCopy.flags = this.flags;

			return varCopy;
		}
	}

	public final static class fieldset // FIELDSET (2)
	{
		public int fieldID; // datalong
		public int fieldValue; // datalong2

		public fieldset clone()
		{
			fieldset varCopy = new fieldset();

			varCopy.fieldID = this.fieldID;
			varCopy.fieldValue = this.fieldValue;

			return varCopy;
		}
	}

	public final static class moveto // MOVETO (3)
	{
		public int unused1; // datalong
		public int travelTime; // datalong2
		public int unused2; // dataint

		public float destX;
		public float destY;
		public float destZ;

		public moveto clone()
		{
			moveto varCopy = new moveto();

			varCopy.unused1 = this.unused1;
			varCopy.travelTime = this.travelTime;
			varCopy.unused2 = this.unused2;
			varCopy.destX = this.destX;
			varCopy.destY = this.destY;
			varCopy.destZ = this.destZ;

			return varCopy;
		}
	}

	public final static class flagtoggle // FLAGSET (4)
	{
		// FLAGREMOVE (5)
		public int fieldID; // datalong
		public int fieldValue; // datalong2

		public flagtoggle clone()
		{
			flagtoggle varCopy = new flagtoggle();

			varCopy.fieldID = this.fieldID;
			varCopy.fieldValue = this.fieldValue;

			return varCopy;
		}
	}

	public final static class teleportto // TELEPORTTO (6)
	{
		public int mapID; // datalong
		public eScriptFlags flags = eScriptFlags.values()[0]; // datalong2
		public int unused1; // dataint

		public float destX;
		public float destY;
		public float destZ;
		public float orientation;

		public teleportto clone()
		{
			teleportto varCopy = new teleportto();

			varCopy.mapID = this.mapID;
			varCopy.flags = this.flags;
			varCopy.unused1 = this.unused1;
			varCopy.destX = this.destX;
			varCopy.destY = this.destY;
			varCopy.destZ = this.destZ;
			varCopy.orientation = this.orientation;

			return varCopy;
		}
	}

	public final static class questexplored // QUESTEXPLORED (7)
	{
		public int questID; // datalong
		public int distance; // datalong2

		public questexplored clone()
		{
			questexplored varCopy = new questexplored();

			varCopy.questID = this.questID;
			varCopy.distance = this.distance;

			return varCopy;
		}
	}

	public final static class killcredit // KILLCREDIT (8)
	{
		public int creatureEntry; // datalong
		public eScriptFlags flags = eScriptFlags.values()[0]; // datalong2

		public killcredit clone()
		{
			killcredit varCopy = new killcredit();

			varCopy.creatureEntry = this.creatureEntry;
			varCopy.flags = this.flags;

			return varCopy;
		}
	}

	public final static class respawngameobject // RESPAWNGAMEOBJECT (9)
	{
		public int GOGuid; // datalong
		public int despawnDelay; // datalong2

		public respawngameobject clone()
		{
			respawngameobject varCopy = new respawngameobject();

			varCopy.GOGuid = this.GOGuid;
			varCopy.despawnDelay = this.despawnDelay;

			return varCopy;
		}
	}

	public final static class tempsummoncreature // TEMPSUMMONCREATURE (10)
	{
		public int creatureEntry; // datalong
		public int despawnDelay; // datalong2
		public int unused1; // dataint

		public float posX;
		public float posY;
		public float posZ;
		public float orientation;

		public tempsummoncreature clone()
		{
			tempsummoncreature varCopy = new tempsummoncreature();

			varCopy.creatureEntry = this.creatureEntry;
			varCopy.despawnDelay = this.despawnDelay;
			varCopy.unused1 = this.unused1;
			varCopy.posX = this.posX;
			varCopy.posY = this.posY;
			varCopy.posZ = this.posZ;
			varCopy.orientation = this.orientation;

			return varCopy;
		}
	}

	public final static class toggledoor // CLOSEDOOR (12)
	{
		// OPENDOOR (11)
		public int GOGuid; // datalong
		public int resetDelay; // datalong2

		public toggledoor clone()
		{
			toggledoor varCopy = new toggledoor();

			varCopy.GOGuid = this.GOGuid;
			varCopy.resetDelay = this.resetDelay;

			return varCopy;
		}
	}

	// ACTIVATEOBJECT (13)

	public final static class removeaura // REMOVEAURA (14)
	{
		public int spellID; // datalong
		public eScriptFlags flags = eScriptFlags.values()[0]; // datalong2

		public removeaura clone()
		{
			removeaura varCopy = new removeaura();

			varCopy.spellID = this.spellID;
			varCopy.flags = this.flags;

			return varCopy;
		}
	}

	public final static class castspell // CASTSPELL (15)
	{
		public int spellID; // datalong
		public eScriptFlags flags = eScriptFlags.values()[0]; // datalong2
		public int creatureEntry; // dataint

		public float searchRadius;

		public castspell clone()
		{
			castspell varCopy = new castspell();

			varCopy.spellID = this.spellID;
			varCopy.flags = this.flags;
			varCopy.creatureEntry = this.creatureEntry;
			varCopy.searchRadius = this.searchRadius;

			return varCopy;
		}
	}

	public final static class playsound // PLAYSOUND (16)
	{
		public int soundID; // datalong
		public eScriptFlags flags = eScriptFlags.values()[0]; // datalong2

		public playsound clone()
		{
			playsound varCopy = new playsound();

			varCopy.soundID = this.soundID;
			varCopy.flags = this.flags;

			return varCopy;
		}
	}

	public final static class createitem // CREATEITEM (17)
	{
		public int itemEntry; // datalong
		public int amount; // datalong2

		public createitem clone()
		{
			createitem varCopy = new createitem();

			varCopy.itemEntry = this.itemEntry;
			varCopy.amount = this.amount;

			return varCopy;
		}
	}

	public final static class despawnself // DESPAWNSELF (18)
	{
		public int despawnDelay; // datalong

		public despawnself clone()
		{
			despawnself varCopy = new despawnself();

			varCopy.despawnDelay = this.despawnDelay;

			return varCopy;
		}
	}

	public final static class loadpath // LOADPATH (20)
	{
		public int pathID; // datalong
		public int isRepeatable; // datalong2

		public loadpath clone()
		{
			loadpath varCopy = new loadpath();

			varCopy.pathID = this.pathID;
			varCopy.isRepeatable = this.isRepeatable;

			return varCopy;
		}
	}

	public final static class callscript // CALLSCRIPTTOUNIT (21)
	{
		public int creatureEntry; // datalong
		public int scriptID; // datalong2
		public int scriptType; // dataint

		public callscript clone()
		{
			callscript varCopy = new callscript();

			varCopy.creatureEntry = this.creatureEntry;
			varCopy.scriptID = this.scriptID;
			varCopy.scriptType = this.scriptType;

			return varCopy;
		}
	}

	public final static class kill // KILL (22)
	{
		public int unused1; // datalong
		public int unused2; // datalong2
		public int removeCorpse; // dataint

		public kill clone()
		{
			kill varCopy = new kill();

			varCopy.unused1 = this.unused1;
			varCopy.unused2 = this.unused2;
			varCopy.removeCorpse = this.removeCorpse;

			return varCopy;
		}
	}

	public final static class orientation // ORIENTATION (30)
	{
		public eScriptFlags flags = eScriptFlags.values()[0]; // datalong
		public int unused1; // datalong2
		public int unused2; // dataint

		public float unused3;
		public float unused4;
		public float unused5;
		public float _Orientation;

		public orientation clone()
		{
			orientation varCopy = new orientation();

			varCopy.flags = this.flags;
			varCopy.unused1 = this.unused1;
			varCopy.unused2 = this.unused2;
			varCopy.unused3 = this.unused3;
			varCopy.unused4 = this.unused4;
			varCopy.unused5 = this.unused5;
			varCopy._Orientation = this._Orientation;

			return varCopy;
		}
	}

	public final static class equip // EQUIP (31)
	{
		public int equipmentID; // datalong

		public equip clone()
		{
			equip varCopy = new equip();

			varCopy.equipmentID = this.equipmentID;

			return varCopy;
		}
	}

	public final static class model // MODEL (32)
	{
		public int modelID; // datalong

		public model clone()
		{
			model varCopy = new model();

			varCopy.modelID = this.modelID;

			return varCopy;
		}
	}

	// CLOSEGOSSIP (33)

	public final static class playmovie // PLAYMOVIE (34)
	{
		public int movieID; // datalong

		public playmovie clone()
		{
			playmovie varCopy = new playmovie();

			varCopy.movieID = this.movieID;

			return varCopy;
		}
	}

	public final static class movement // SCRIPT_COMMAND_MOVEMENT (35)
	{
		public int movementType; // datalong
		public int movementDistance; // datalong2
		public int path; // dataint

		public movement clone()
		{
			movement varCopy = new movement();

			varCopy.movementType = this.movementType;
			varCopy.movementDistance = this.movementDistance;
			varCopy.path = this.path;

			return varCopy;
		}
	}

	public final static class playanimkit // SCRIPT_COMMAND_PLAY_ANIMKIT (36)
	{
		public int animKitID; // datalong

		public playanimkit clone()
		{
			playanimkit varCopy = new playanimkit();

			varCopy.animKitID = this.animKitID;

			return varCopy;
		}
	}

// C# TO JAVA CONVERTER TASK: There is no preprocessor in Java:
		///#endregion

	public ScriptInfo clone()
	{
		ScriptInfo varCopy = new scriptInfo();

		varCopy.type = this.type;
		varCopy.id = this.id;
		varCopy.delay = this.delay;
		varCopy.command = this.command;
		varCopy.raw = this.raw;
		varCopy.talk = this.talk;
		varCopy.emote = this.emote;
		varCopy.fieldSet = this.fieldSet;
		varCopy.moveTo = this.moveTo;
		varCopy.flagToggle = this.flagToggle;
		varCopy.teleportTo = this.teleportTo;
		varCopy.questExplored = this.questExplored;
		varCopy.killCredit = this.killCredit;
		varCopy.respawnGameObject = this.respawnGameObject;
		varCopy.tempSummonCreature = this.tempSummonCreature;
		varCopy.toggleDoor = this.toggleDoor;
		varCopy.removeAura = this.removeAura;
		varCopy.castSpell = this.castSpell;
		varCopy.playSound = this.playSound;
		varCopy.createItem = this.createItem;
		varCopy.despawnSelf = this.despawnSelf;
		varCopy.loadPath = this.loadPath;
		varCopy.callScript = this.callScript;
		varCopy.kill = this.kill;
		varCopy.orientation = this.orientation;
		varCopy.equip = this.equip;
		varCopy.model = this.model;
		varCopy.playMovie = this.playMovie;
		varCopy.movement = this.movement;
		varCopy.playAnimKit = this.playAnimKit;

		return varCopy;
	}
}
