package com.github.mmo.defines;

public enum SpellCustomErrors {
    SPELL_CUSTOM_ERROR_NONE,
    SPELL_CUSTOM_ERROR_CUSTOM_MSG,  // Something bad happened, and we want to display a custom message!
    SPELL_CUSTOM_ERROR_ALEX_BROKE_QUEST,  // Alex broke your quest! Thank him later!
    SPELL_CUSTOM_ERROR_NEED_HELPLESS_VILLAGER,  // This spell may only be used on Helpless Wintergarde Villagers that have not been rescued.
    SPELL_CUSTOM_ERROR_NEED_WARSONG_DISGUISE,  // Requires that you be wearing the Warsong Orc Disguise.
    SPELL_CUSTOM_ERROR_REQUIRES_PLAGUE_WAGON,  // You must be closer to a plague wagon in order to drop off your 7th Legion Siege Engineer.
    SPELL_CUSTOM_ERROR_CANT_TARGET_FRIENDLY_NONPARTY,  // You cannot target friendly units outside your party.
    SPELL_CUSTOM_ERROR_NEED_CHILL_NYMPH,  // You must target a weakened chill nymph.
    SPELL_CUSTOM_ERROR_MUST_BE_IN_ENKILAH,  // The Imbued Scourge Shroud will only work when equipped in the Temple City of En'kilah.
    SPELL_CUSTOM_ERROR_REQUIRES_CORPSE_DUST,  // Requires Corpse Dust
    SPELL_CUSTOM_ERROR_CANT_SUMMON_GARGOYLE,  // You cannot summon another gargoyle yet.
    SPELL_CUSTOM_ERROR_NEED_CORPSE_DUST_IF_NO_TARGET,  // Requires Corpse Dust if the target is not dead and humanoid.
    SPELL_CUSTOM_ERROR_MUST_BE_AT_SHATTERHORN,  // Can only be placed near Shatterhorn
    SPELL_CUSTOM_ERROR_MUST_TARGET_PROTO_DRAKE_EGG,  // You must first select a Proto-Drake Egg.
    SPELL_CUSTOM_ERROR_MUST_BE_CLOSE_TO_TREE,  // You must be close to a marked tree.
    SPELL_CUSTOM_ERROR_MUST_TARGET_TURKEY,  // You must target a Fjord Turkey.
    SPELL_CUSTOM_ERROR_MUST_TARGET_HAWK,  // You must target a Fjord Hawk.
    SPELL_CUSTOM_ERROR_TOO_FAR_FROM_BOUY,  // You are too far from the bouy.
    SPELL_CUSTOM_ERROR_MUST_BE_CLOSE_TO_OIL_SLICK,  // Must be used near an oil slick.
    SPELL_CUSTOM_ERROR_MUST_BE_CLOSE_TO_BOUY,  // You must be closer to the buoy!
    SPELL_CUSTOM_ERROR_WYRMREST_VANQUISHER,  // You may only call for the aid of a Wyrmrest Vanquisher in Wyrmrest Temple, The Dragon Wastes, Galakrond's Rest or The Wicked Coil.
    SPELL_CUSTOM_ERROR_MUST_TARGET_ICE_HEART_JORMUNGAR,  // That can only be used on a Ice Heart Jormungar Spawn.
    SPELL_CUSTOM_ERROR_MUST_BE_CLOSE_TO_SINKHOLE,  // You must be closer to a sinkhole to use your map.
    SPELL_CUSTOM_ERROR_REQUIRES_HAROLD_LANE,  // You may only call down a stampede on Harold Lane.
    SPELL_CUSTOM_ERROR_REQUIRES_GAMMOTH_MAGNATAUR,  // You may only use the Pouch of Crushed Bloodspore on Gammothra or other magnataur in the Bloodspore Plains and Gammoth.
    SPELL_CUSTOM_ERROR_MUST_BE_IN_RESURRECTION_CHAMBER,  // Requires the magmawyrm resurrection chamber in the back of the Maw of Neltharion.
    SPELL_CUSTOM_ERROR_CANT_CALL_WINTERGARDE_HERE,  // You may only call down a Wintergarde Gryphon in Wintergarde Keep or the Carrion Fields.
    SPELL_CUSTOM_ERROR_MUST_TARGET_WILHELM,  // What are you doing? Only aim that thing at Wilhelm!
    SPELL_CUSTOM_ERROR_NOT_ENOUGH_HEALTH,  // Not enough health!
    SPELL_CUSTOM_ERROR_NO_NEARBY_CORPSES,  // There are no nearby corpses to use.
    SPELL_CUSTOM_ERROR_TOO_MANY_GHOULS,  // You've created enough ghouls. Return to Gothik the Harvester at Death's Breach.
    SPELL_CUSTOM_ERROR_GO_FURTHER_FROM_SUNDERED_SHARD,  // Your companion does not want to come here.  Go further from the Sundered Shard.
    SPELL_CUSTOM_ERROR_MUST_BE_IN_CAT_FORM,  // Must be in Cat Form
    SPELL_CUSTOM_ERROR_MUST_BE_DEATH_KNIGHT,  // Only Death Knights may enter Ebon Hold.
    SPELL_CUSTOM_ERROR_MUST_BE_IN_BEAR_FORM,  // Must be in Bear Form
    SPELL_CUSTOM_ERROR_MUST_BE_NEAR_HELPLESS_VILLAGER,  // You must be within range of a Helpless Wintergarde Villager.
    SPELL_CUSTOM_ERROR_CANT_TARGET_ELEMENTAL_MECHANICAL,  // You cannot target an elemental or mechanical corpse.
    SPELL_CUSTOM_ERROR_MUST_HAVE_USED_DALARAN_CRYSTAL,  // This teleport crystal cannot be used until the teleport crystal in Dalaran has been used at least once.
    SPELL_CUSTOM_ERROR_YOU_ALREADY_HOLD_SOMETHING,  // You are already holding something in your hand. You must throw the creature in your hand before picking up another.
    SPELL_CUSTOM_ERROR_YOU_DONT_HOLD_ANYTHING,  // You don't have anything to throw! Find a Vargul and use Gymer Grab to pick one up!
    SPELL_CUSTOM_ERROR_MUST_BE_CLOSE_TO_VALDURAN,  // Bouldercrag's War Horn can only be used within 10 yards of Valduran the Stormborn.
    SPELL_CUSTOM_ERROR_NO_PASSENGER,  // You are not carrying a passenger. There is nobody to drop off.
    SPELL_CUSTOM_ERROR_CANT_BUILD_MORE_VEHICLES,  // You cannot build any more siege vehicles.
    SPELL_CUSTOM_ERROR_ALREADY_CARRYING_CRUSADER,  // You are already carrying a captured Argent Crusader. You must return to the Argent Vanguard infirmary and drop off your passenger before you may pick up another.
    SPELL_CUSTOM_ERROR_CANT_DO_WHILE_ROOTED,  // You can't do that while rooted.
    SPELL_CUSTOM_ERROR_REQUIRES_NEARBY_TARGET,  // Requires a nearby target.
    SPELL_CUSTOM_ERROR_NOTHING_TO_DISCOVER,  // Nothing left to discover.
    SPELL_CUSTOM_ERROR_NOT_ENOUGH_TARGETS,  // No targets close enough to bluff.
    SPELL_CUSTOM_ERROR_CONSTRUCT_TOO_FAR,  // Your Iron Rune Construct is out of range.
    SPELL_CUSTOM_ERROR_REQUIRES_GRAND_MASTER_ENGINEER,  // Requires Engineering (350)
    SPELL_CUSTOM_ERROR_CANT_USE_THAT_MOUNT,  // You can't use that mount.
    SPELL_CUSTOM_ERROR_NOONE_TO_EJECT,  // There is nobody to eject!
    SPELL_CUSTOM_ERROR_TARGET_MUST_BE_BOUND,  // The target must be bound to you.
    SPELL_CUSTOM_ERROR_TARGET_MUST_BE_UNDEAD,  // Target must be undead.
    SPELL_CUSTOM_ERROR_TARGET_TOO_FAR,  // You have no target or your target is too far away.
    SPELL_CUSTOM_ERROR_MISSING_DARK_MATTER,  // Missing Reagents: Dark Matter
    SPELL_CUSTOM_ERROR_CANT_USE_THAT_ITEM,  // You can't use that item
    SPELL_CUSTOM_ERROR_CANT_DO_WHILE_CYCYLONED,  // You can't do that while Cycloned
    SPELL_CUSTOM_ERROR_TARGET_HAS_SCROLL,  // Target is already affected by a similar effect
    SPELL_CUSTOM_ERROR_POISON_TOO_STRONG,  // That anti-venom is not strong enough to dispel that poison
    SPELL_CUSTOM_ERROR_MUST_HAVE_LANCE_EQUIPPED,  // You must have a lance equipped.
    SPELL_CUSTOM_ERROR_MUST_BE_CLOSE_TO_MAIDEN,  // You must be near the Maiden of Winter's Breath Lake.
    SPELL_CUSTOM_ERROR_LEARNED_EVERYTHING,  // You have learned everything from that book
    SPELL_CUSTOM_ERROR_PET_IS_DEAD,  // Your pet is dead
    SPELL_CUSTOM_ERROR_NO_VALID_TARGETS,  // There are no valid targets within range.
    SPELL_CUSTOM_ERROR_GM_ONLY,  // Only GMs may use that. Your account has been reported for investigation.
    SPELL_CUSTOM_ERROR_REQUIRES_LEVEL_58,  // You must reach level 58 to use this portal.
    SPELL_CUSTOM_ERROR_AT_HONOR_CAP,  // You already have the maximum amount of honor.
    SPELL_CUSTOM_ERROR_HAVE_HOT_ROD,  // You already have a Hot Rod.
    SPELL_CUSTOM_ERROR_PARTYGOER_MORE_BUBBLY,  // This partygoer wants some more bubbly.
    SPELL_CUSTOM_ERROR_PARTYGOER_NEED_BUCKET,  // This partygoer needs a bucket!
    SPELL_CUSTOM_ERROR_PARTYGOER_WANT_TO_DANCE,  // This partygoer wants to dance with you.
    SPELL_CUSTOM_ERROR_PARTYGOER_WANT_FIREWORKS,  // This partygoer wants to see some fireworks.
    SPELL_CUSTOM_ERROR_PARTYGOER_WANT_APPETIZER,  // This partygoer wants some more hors d'oeuvres.
    SPELL_CUSTOM_ERROR_GOBLIN_BATTERY_DEPLETED,  // The Goblin All-In-1-Der Belt's battery is depleted.
    SPELL_CUSTOM_ERROR_MUST_HAVE_DEMONIC_CIRCLE,  // You must have a demonic circle active.
    SPELL_CUSTOM_ERROR_AT_MAX_RAGE,  // You already have maximum rage
    SPELL_CUSTOM_ERROR_REQUIRES_350_ENGINEERING,  // Requires Engineering (350)
    SPELL_CUSTOM_ERROR_SOUL_BELONGS_TO_LICH_KING,  // Your soul belongs to the Lich King
    SPELL_CUSTOM_ERROR_ATTENDANT_HAS_PONY,  // Your attendant already has an Argent Pony
    SPELL_CUSTOM_ERROR_GOBLIN_STARTING_MISSION,  // First, Overload the Defective Generator, Activate the Leaky Stove, and Drop a Cigar on the Flammable Bed.
    SPELL_CUSTOM_ERROR_GASBOT_ALREADY_SENT,  // You've already sent in the Gasbot and destroyed headquarters!
    SPELL_CUSTOM_ERROR_GOBLIN_IS_PARTIED_OUT,  // This goblin is all partied out!
    SPELL_CUSTOM_ERROR_MUST_HAVE_FIRE_TOTEM,  // You must have a Magma, Flametongue, or Fire Elemental Totem active.
    SPELL_CUSTOM_ERROR_CANT_TARGET_VAMPIRES,  // You may not bite other vampires.
    SPELL_CUSTOM_ERROR_PET_ALREADY_AT_YOUR_LEVEL,  // Your pet is already at your level.
    SPELL_CUSTOM_ERROR_MISSING_ITEM_REQUIREMENS,  // You do not meet the level requirements for this item.
    SPELL_CUSTOM_ERROR_TOO_MANY_ABOMINATIONS,  // There are too many Mutated Abominations.
    SPELL_CUSTOM_ERROR_ALL_POTIONS_USED,  // The potions have all been depleted by Professor Putricide.
    SPELL_CUSTOM_ERROR_DEFEATED_ENOUGH_ALREADY,  // You have already defeated enough of them.
    SPELL_CUSTOM_ERROR_REQUIRES_LEVEL_65,  // Requires level 65
    SPELL_CUSTOM_ERROR_DESTROYED_KTC_OIL_PLATFORM,  // You have already destroyed the KTC Oil Platform.
    SPELL_CUSTOM_ERROR_LAUNCHED_ENOUGH_CAGES,  // You have already launched enough cages.
    SPELL_CUSTOM_ERROR_REQUIRES_BOOSTER_ROCKETS,  // Requires Single-Stage Booster Rockets. Return to Hobart Grapplehammer to get more.
    SPELL_CUSTOM_ERROR_ENOUGH_WILD_CLUCKERS,  // You have already captured enough wild cluckers.
    SPELL_CUSTOM_ERROR_REQUIRES_CONTROL_FIREWORKS,  // Requires Remote Control Fireworks. Return to Hobart Grapplehammer to get more.
    SPELL_CUSTOM_ERROR_MAX_NUMBER_OF_RECRUITS,  // You already have the max number of recruits.
    SPELL_CUSTOM_ERROR_MAX_NUMBER_OF_VOLUNTEERS,  // You already have the max number of volunteers.
    SPELL_CUSTOM_ERROR_FROSTMOURNE_RENDERED_RESURRECT,  // Frostmourne has rendered you unable to resurrect.
    SPELL_CUSTOM_ERROR_CANT_MOUNT_WITH_SHAPESHIFT,  // You can't mount while affected by that shapeshift.
    SPELL_CUSTOM_ERROR_FAWNS_ALREADY_FOLLOWING, // Three fawns are already following you!
    SPELL_CUSTOM_ERROR_ALREADY_HAVE_RIVER_BOAT, // You already have a River Boat.
    SPELL_CUSTOM_ERROR_NO_ACTIVE_ENCHANTMENT, // You have no active enchantment to unleash.
    SPELL_CUSTOM_ERROR_ENOUGH_HIGHBOURNE_SOULS, // You have bound enough Highborne souls. Return to Arcanist Valdurian.
    SPELL_CUSTOM_ERROR_ATLEAST_40YD_FROM_OIL_DRILLING, // You must be at least 40 yards away from all other Oil Drilling Rigs.
    SPELL_CUSTOM_ERROR_ABOVE_ENSLAVED_PEARL_MINER, // You must be above the Enslaved Pearl Miner.
    SPELL_CUSTOM_ERROR_MUST_TARGET_CORPSE_SPECIAL_1, // You must target the corpse of a Seabrush Terrapin, Scourgut Remora, or Spinescale Hammerhead.
    SPELL_CUSTOM_ERROR_SLAGHAMMER_ALREADY_PRISONER, // Ambassador Slaghammer is already your prisoner.
    SPELL_CUSTOM_ERROR_REQUIRE_ATTUNED_LOCATION_1, // Requires a location that is attuned with the Naz'jar Battlemaiden.
    SPELL_CUSTOM_ERROR_NEED_TO_FREE_DRAKE_FIRST, // Free the Drake from the net first!
    SPELL_CUSTOM_ERROR_DRAGONMAW_ALLIES_ALREADY_FOLLOW, // You already have three Dragonmaw allies following you.
    SPELL_CUSTOM_ERROR_REQUIRE_OPPOSABLE_THUMBS, // Requires Opposable Thumbs.
    SPELL_CUSTOM_ERROR_NOT_ENOUGH_HEALTH_2, // Not enough health
    SPELL_CUSTOM_ERROR_ENOUGH_FORSAKEN_TROOPERS, // You already have enough Forsaken Troopers.
    SPELL_CUSTOM_ERROR_CANNOT_JUMP_TO_BOULDER, // You cannot jump to another boulder yet.
    SPELL_CUSTOM_ERROR_SKILL_TOO_HIGH, // Skill too high.
    SPELL_CUSTOM_ERROR_ALREADY_6_SURVIVORS_RESCUED, // You have already rescued 6 Survivors.
    SPELL_CUSTOM_ERROR_MUST_FACE_SHIPS_FROM_BALLOON, // You need to be facing the ships from the rescue balloon.
    SPELL_CUSTOM_ERROR_CANNOT_SUPERVISE_MORE_CULTISTS, // You cannot supervise more than 5 Arrested Cultists at a time.
    SPELL_CUSTOM_ERROR_REQUIRES_LEVEL_85, // You must reach level 85 to use this portal.
    SPELL_CUSTOM_ERROR_MUST_BE_BELOW_35_HEALTH, // Your target must be below 35% health.
    SPELL_CUSTOM_ERROR_MUST_SELECT_SPECIALIZATION, // You must select a specialization first.
    SPELL_CUSTOM_ERROR_TOO_WISE_AND_POWERFUL, // You are too wise and powerful to gain any benefit from that item.
    SPELL_CUSTOM_ERROR_TOO_CLOSE_ARGENT_LIGHTWELL, // You are within 10 yards of another Argent Lightwell.
    SPELL_CUSTOM_ERROR_NOT_WHILE_SHAPESHIFTED, // You can't do that while shapeshifted.
    SPELL_CUSTOM_ERROR_MANA_GEM_IN_BANK, // You already have a Mana Gem in your bank.
    SPELL_CUSTOM_ERROR_FLAME_SHOCK_NOT_ACTIVE, // You must have at least one Flame Shock active.
    SPELL_CUSTOM_ERROR_CANT_TRANSFORM, // You cannot transform right now
    SPELL_CUSTOM_ERROR_PET_MUST_BE_ATTACKING, // Your pet must be attacking a target.
    SPELL_CUSTOM_ERROR_GNOMISH_ENGINEERING, // Requires Gnomish Engineering
    SPELL_CUSTOM_ERROR_GOBLIN_ENGINEERING, // Requires Goblin Engineering
    SPELL_CUSTOM_ERROR_NO_TARGET, // You have no target.
    SPELL_CUSTOM_ERROR_PET_OUT_OF_RANGE, // Your Pet is out of range of the target.
    SPELL_CUSTOM_ERROR_HOLDING_FLAG, // You can't do that while holding the flag.
    SPELL_CUSTOM_ERROR_TARGET_HOLDING_FLAG, // You can't do that to targets holding the flag.
    SPELL_CUSTOM_ERROR_PORTAL_NOT_OPEN, // The portal is not yet open.  Continue helping the druids at the Sanctuary of Malorne.
    SPELL_CUSTOM_ERROR_AGGRA_AIR_TOTEM, // You need to be closer to Aggra's Air Totem, in the west.
    SPELL_CUSTOM_ERROR_AGGRA_WATER_TOTEM, // You need to be closer to Aggra's Water Totem, in the north.
    SPELL_CUSTOM_ERROR_AGGRA_EARTH_TOTEM, // You need to be closer to Aggra's Earth Totem, in the east.
    SPELL_CUSTOM_ERROR_AGGRA_FIRE_TOTEM, // You need to be closer to Aggra's Fire Totem, near Thrall.
    SPELL_CUSTOM_ERROR_FACING_WRONG_WAY, // You are facing the wrong way.
    SPELL_CUSTOM_ERROR_TOO_CLOSE_TO_MAKESHIFT_DYNAMITE, // You are within 10 yards of another Makeshift Dynamite.
    SPELL_CUSTOM_ERROR_NOT_NEAR_SAPPHIRE_SUNKEN_SHIP, // You must be near the sunken ship at Sapphire's End in the Jade Forest.
    SPELL_CUSTOM_ERROR_DEMONS_HEALTH_FULL, // That demon's health is already full.
    SPELL_CUSTOM_ERROR_ONYX_SERPENT_NOT_OVERHEAD, // Wait until the Onyx Serpent is directly overhead.
    SPELL_CUSTOM_ERROR_OBJECTIVE_ALREADY_COMPLETE, // Your objective is already complete.
    SPELL_CUSTOM_ERROR_PUSH_SAD_PANDA_TOWARDS_TOWN, // You can only push Sad Panda towards Sad Panda Town!
    SPELL_CUSTOM_ERROR_TARGET_HAS_STARTDUST_2, // Target is already affected by Stardust No. 2.
    SPELL_CUSTOM_ERROR_ELEMENTIUM_GEM_CLUSTERS, // You cannot deconstruct Elementium Gem Clusters while collecting them!
    SPELL_CUSTOM_ERROR_YOU_DONT_HAVE_ENOUGH_HEALTH, // You don't have enough health.
    SPELL_CUSTOM_ERROR_YOU_CANNOT_USE_THE_GATEWAY_YET, // You cannot use the gateway yet.
    SPELL_CUSTOM_ERROR_CHOOSE_SPEC_FOR_ASCENDANCE, // You must choose a specialization to use Ascendance.
    SPELL_CUSTOM_ERROR_INSUFFICIENT_BLOOD_CHARGES, // You have insufficient Blood Charges.
    SPELL_CUSTOM_ERROR_NO_FULLY_DEPLETED_RUNES, // No fully depleted runes.
    SPELL_CUSTOM_ERROR_NO_MORE_CHARGES, // No more charges.
    SPELL_CUSTOM_ERROR_STATUE_IS_OUT_OF_RANGE_OF_TARGET, // Statue is out of range of the target.
    SPELL_CUSTOM_ERROR_YOU_DONT_HAVE_A_STATUE_SUMMONED, // You don't have a statue summoned.
    SPELL_CUSTOM_ERROR_YOU_HAVE_NO_SPIRIT_ACTIVE, // You have no spirit active.
    SPELL_CUSTOM_ERROR_BOTH_DISESASES_MUST_BE_ON_TARGET, // Both Frost Fever and Blood Plague must be present on the target.
    SPELL_CUSTOM_ERROR_CANT_DO_THAT_WITH_ORB_OF_POWER, // You can't do that while holding an Orb of Power.
    SPELL_CUSTOM_ERROR_CANT_DO_THAT_WHILE_JUMPING_OR_FALLING, // You can't do that while jumping or falling.
    SPELL_CUSTOM_ERROR_MUST_BE_TRANSFORMED_BY_POLYFORMIC_ACID, // You must be transformed by Polyformic Acid.
    SPELL_CUSTOM_ERROR_NOT_ENOUGH_ACID_TO_STORE_TRANSFORMATION, // There isn't enough acid left to store this transformation.
    SPELL_CUSTOM_ERROR_MUST_HAVE_FLIGHT_MASTERS_LICENSE, // You must obtain a Flight Master's License before using this spell.
    SPELL_CUSTOM_ERROR_ALREADY_SAMPLED_SAP_FROM_FEEDER, // You have already sampled sap from this Feeder.
    SPELL_CUSTOM_ERROR_MUST_BE_NEWR_MANTID_FEEDER, // Requires you to be near a Mantid Feeder in the Heart of Fear.
    SPELL_CUSTOM_ERROR_TARGET_MUST_BE_IN_DIRECTLY_FRONT, // Target must be directly in front of you.
    SPELL_CUSTOM_ERROR_CANT_DO_THAT_WHILE_MYTHIC_KEYSTONE_IS_ACTIVE, // You can't do that while a Mythic Keystone is active.
    SPELL_CUSTOM_ERROR_WRONG_CLASS_FOR_MOUNT, // You are not the correct class for that mount.
    SPELL_CUSTOM_ERROR_NOTHING_LEFT_TO_DISCOVER, // Nothing left to discover.
    SPELL_CUSTOM_ERROR_NO_EXPLOSIVES_AVAILABLE, // There are no explosives available.
    SPELL_CUSTOM_ERROR_YOU_MUST_BE_FLAGGED_FOR_PVP, // You must be flagged for PvP.
    SPELL_CUSTOM_ERROR_REQUIRES_BATTLE_RATIONS, // Requires Battle Rations or Meaty Haunch
    SPELL_CUSTOM_ERROR_REQUIRES_BRITTLE_ROOT, // Requires Brittle Root
    SPELL_CUSTOM_ERROR_REQUIRES_LABORERS_TOOL, // Requires Laborer's Tool
    SPELL_CUSTOM_ERROR_REQUIRES_UNEXPLODED_CANNONBALL, // Requires Unexploded Cannonball
    SPELL_CUSTOM_ERROR_REQUIRES_MISPLACED_KEG, // Requires Misplaced Keg
    SPELL_CUSTOM_ERROR_REQUIRES_LIQUID_FIRE, // Requires Liquid Fire, Jungle Hops, or Spirit-kissed Water
    SPELL_CUSTOM_ERROR_REQUIRES_KRASARI_IRON, // Requires Krasari Iron
    SPELL_CUSTOM_ERROR_REQUIRES_SPIRIT_KISSED_WATER, // Requires Spirit-Kissed Water
    SPELL_CUSTOM_ERROR_REQUIRES_SNAKE_OIL, // Requires Snake Oil
    SPELL_CUSTOM_ERROR_SCENARIO_IS_IN_PROGRESS, // You can't do that while a Scenario is in progress.
    SPELL_CUSTOM_ERROR_REQUIRES_DARKMOON_FAIRE_OPEN, // Requires the Darkmoon Faire to be open.
    SPELL_CUSTOM_ERROR_ALREADY_AT_VALOR_CAP, // Already at Valor cap
    SPELL_CUSTOM_ERROR_ALREADY_COMMENDED_BY_THIS_FACTION, // Already commended by this faction
    SPELL_CUSTOM_ERROR_OUT_OF_COINS, // Out of coins! Pickpocket humanoids to get more.
    SPELL_CUSTOM_ERROR_ONLY_ONE_ELEMENTAL_SPIRIT, // Only one elemental spirit on a target at a time.
    SPELL_CUSTOM_ERROR_DONT_KNOW_HOW_TO_TAME_DIREHORNS, // You do not know how to tame Direhorns.
    SPELL_CUSTOM_ERROR_MUST_BE_NEAR_BLOODIED_COURT_GATE, // You must be near the Bloodied Court gate.
    SPELL_CUSTOM_ERROR_YOU_ARE_NOT_ELECTRIFIED, // You are not Electrified.
    SPELL_CUSTOM_ERROR_THERE_IS_NOTHING_TO_BE_FETCHED, // There is nothing to be fetched.
    SPELL_CUSTOM_ERROR_REQUIRES_THE_THUNDER_FORGE, // Requires The Thunder Forge.
    SPELL_CUSTOM_ERROR_CANNOT_USE_THE_DICE_AGAIN_YET, // You cannot use the dice again yet.
    SPELL_CUSTOM_ERROR_ALREADY_MEMBER_OF_BRAWLERS_GUILD, // You are already a member of the Brawler's Guild.
    SPELL_CUSTOM_ERROR_CANT_CHANGE_SPEC_IN_CELESTIAL_CHALLENGE, // You may not change talent specializations during a celestial challenge.
    SPELL_CUSTOM_ERROR_SPEC_DOES_MATCH_CHALLENGE, // Your talent specialization does not match the selected challenge.
    SPELL_CUSTOM_ERROR_YOU_DONT_HAVE_ENOUGH_CURRENCY, // You don't have enough currency to do that.
    SPELL_CUSTOM_ERROR_TARGET_CANNOT_BENEFIT_FROM_SPELL, // Target cannot benefit from that spell
    SPELL_CUSTOM_ERROR_YOU_CAN_ONLY_HAVE_ONE_HEALING_RAIN, // You can only have one Healing Rain active at a time.
    SPELL_CUSTOM_ERROR_THE_DOOR_IS_LOCKED, // The door is locked.
    SPELL_CUSTOM_ERROR_YOU_NEED_TO_SELECT_WAITING_CUSTOMER, // You need to select a customer who is waiting in line first.
    SPELL_CUSTOM_ERROR_CANT_CHANGE_SPEC_DURING_TRIAL, // You may not change specialization while a trial is in progress.
    SPELL_CUSTOM_ERROR_CUSTOMER_NEED_TO_GET_IN_LINE, // You must wait for customers to get in line before you can select them to be seated.
    SPELL_CUSTOM_ERROR_MUST_BE_CLOSER_TO_GAZLOWE_OBJECTIVE, // Must be closer to one of Gazlowe's objectives to deploy!
    SPELL_CUSTOM_ERROR_MUST_BE_CLOSER_TO_THAELIN_OBJECTIVE, // Must be closer to one of Thaelin's objectives to deploy!
    SPELL_CUSTOM_ERROR_YOUR_PACK_OF_VOLEN_IS_FULL, // Your pack of volen is already full!
    SPELL_CUSTOM_ERROR_REQUIRES_600_MINING_OR_BLACKSMITHING, // Requires 600 Mining or Blacksmithing
    SPELL_CUSTOM_ERROR_ARKONITE_PROTECTOR_NOT_IN_RANGE, // The Arkonite Protector is not in range.
    SPELL_CUSTOM_ERROR_TARGET_CANNOT_HAVE_BOTH_BEACONS, // You are unable to have both Beacon of Light and Beacon of Faith on the same target.
    SPELL_CUSTOM_ERROR_CAN_ONLY_USE_ON_AFK_PLAYER, // Can only be used on AFK players.
    SPELL_CUSTOM_ERROR_NO_LOOTABLE_CORPSES_IN_RANGE, // No lootable corpse in range
    SPELL_CUSTOM_ERROR_CHIMAERON_TOO_CALM_TO_TAME, // Chimaeron is too calm to tame right now.
    SPELL_CUSTOM_ERROR_CAN_ONLY_CARRY_ONE_TYPE_OF_MUNITIONS, // You may only carry one type of Blackrock Munitions.
    SPELL_CUSTOM_ERROR_OUT_OF_BLACKROCK_MUNITIONS, // You have run out of Blackrock Munitions.
    SPELL_CUSTOM_ERROR_CARRYING_MAX_AMOUNT_OF_MUNITIONS, // You are carrying the maximum amount of Blackrock Munitions.
    SPELL_CUSTOM_ERROR_TARGET_IS_TOO_FAR_AWAY, // Target is too far away.
    SPELL_CUSTOM_ERROR_CANNOT_USE_DURING_BOSS_ENCOUNTER, // Cannot use during a boss encounter.
    SPELL_CUSTOM_ERROR_MUST_HAVE_MELEE_WEAPON_IN_BOTH_HANDS, // Must have a Melee Weapon equipped in both hands
    SPELL_CUSTOM_ERROR_YOUR_WEAPON_HAS_OVERHEATED, // Your weapon has overheated.
    SPELL_CUSTOM_ERROR_MUST_BE_PARTY_LEADER_TO_QUEUE, // You must be a party leader to queue your group.
    SPELL_CUSTOM_ERROR_NOT_ENOUGH_FUEL, // Not enough fuel
    SPELL_CUSTOM_ERROR_YOU_ARE_ALREADY_DISGUISED, // You are already disguised!
    SPELL_CUSTOM_ERROR_YOU_NEED_TO_BE_IN_SHREDDER, // You need to be in a Shredder to chop this up!
    SPELL_CUSTOM_ERROR_FOOD_CANNOT_EAT_FOOD, // Food cannot eat food
    SPELL_CUSTOM_ERROR_MYSTERIOUS_FORCE_PREVENTS_OPENING_CHEST, // A mysterious force prevents you from opening the chest.
    SPELL_CUSTOM_ERROR_CANT_DO_THAT_WHILE_HOLDING_EMPOWERED_ORE, // You can't do that while holding Empowered Ore.
    SPELL_CUSTOM_ERROR_NOT_ENOUGH_AMMUNITION, // Not enough Ammunition!
    SPELL_CUSTOM_ERROR_YOU_NEED_BEATFACE_THE_GLADIATOR, // You need Beatface the Sparring Arena gladiator to break this!
    SPELL_CUSTOM_ERROR_YOU_CAN_ONLY_HAVE_ONE_WAYGATE, // You can only have one waygate open. Disable an activated waygate first.
    SPELL_CUSTOM_ERROR_YOU_CAN_ONLY_HAVE_TWO_WAYGATES, // You can only have two waygates open. Disable an activated waygate first.
    SPELL_CUSTOM_ERROR_YOU_CAN_ONLY_HAVE_THREE_WAYGATES, // You can only have three waygates open. Disable an activated waygate first.
    SPELL_CUSTOM_ERROR_REQUIRES_MAGE_TOWER, // Requires Mage Tower
    SPELL_CUSTOM_ERROR_REQUIRES_SPIRIT_LODGE, // Requires Spirit Lodge
    SPELL_CUSTOM_ERROR_FROST_WYRM_ALREADY_ACTIVE, // A Frost Wyrm is already active.
    SPELL_CUSTOM_ERROR_NOT_ENOUGH_RUNIC_POWER, // Not enough Runic Power
    SPELL_CUSTOM_ERROR_YOU_ARE_THE_PARTY_LEADER, // You are the Party Leader.
    SPELL_CUSTOM_ERROR_YULON_IS_ALREADY_ACTIVE, // Yu'lon is already active.
    SPELL_CUSTOM_ERROR_A_STAMPEDE_IS_ALREADY_ACTIVE, // A Stampede is already active.
    SPELL_CUSTOM_ERROR_YOU_ARE_ALREADY_WELL_FED, // You are already Well Fed.
    SPELL_CUSTOM_ERROR_CANT_DO_THAT_UNDER_SUPPRESSIVE_FIRE, // You cannot do that while under Suppressive Fire.
    SPELL_CUSTOM_ERROR_YOU_ALREADY_HAVE_MURLOC_SLOP, // You already have a piece of Murloc Slop.
    SPELL_CUSTOM_ERROR_YOU_DONT_HAVE_ARTIFACT_FRAGMENTS, // You don't have any Artifact Fragments.
    SPELL_CUSTOM_ERROR_YOU_ARENT_IN_A_PARTY, // You aren't in a Party.
    SPELL_CUSTOM_ERROR_REQUIRES_20_AMMUNITION, // Requires 30 Ammunition!
    SPELL_CUSTOM_ERROR_REQUIRES_30_AMMUNITION, // Requires 20 Ammunition!
    SPELL_CUSTOM_ERROR_YOU_ALREADY_HAVE_MAX_OUTCAST_FOLLOWERS, // You already have the maximum amount of Outcasts following you.
    SPELL_CUSTOM_ERROR_NOT_IN_WORLD_PVP_ZONE, // Not in World PvP zone.
    SPELL_CUSTOM_ERROR_ALREADY_AT_RESOURCE_CAP, // Already at Resource cap
    SPELL_CUSTOM_ERROR_APEXIS_SENTINEL_REQUIRES_ENERGY, // This Apexis Sentinel requires energy from a nearby Apexis Pylon to be powered up.
    SPELL_CUSTOM_ERROR_YOU_MUST_HAVE_3_OR_FEWER_PLAYER, // You must have 3 or fewer players.
    SPELL_CUSTOM_ERROR_YOU_ALREADY_READ_TREASURE_MAP, // You have already read that treasure map.
    SPELL_CUSTOM_ERROR_MAY_ONLY_USE_WHILE_GARRISON_UNDER_ATTACK, // You may only use this item while your garrison is under attack.
    SPELL_CUSTOM_ERROR_REQUIRES_ACTIVE_MUSHROOMS, // This spell requires active mushrooms for you to detonate.
    SPELL_CUSTOM_ERROR_REQUIRES_FASTER_TIME_WITH_RACER, // Requires a faster time with the basic racer
    SPELL_CUSTOM_ERROR_REQUIRES_INFERNO_SHOT_AMMO, // Requires Inferno Shot Ammo!
    SPELL_CUSTOM_ERROR_YOU_CANNOT_DO_THAT_RIGHT_NOW, // You cannot do that right now.
    SPELL_CUSTOM_ERROR_A_TRAP_IS_ALREADY_PLACED_THERE, // A trap is already placed there.
    SPELL_CUSTOM_ERROR_YOU_ARE_ALREADY_ON_THAT_QUEST, // You are already on that quest.
    SPELL_CUSTOM_ERROR_REQUIRES_FELFORGED_CUDGEL, // Requires a Felforged Cudgel!
    SPELL_CUSTOM_ERROR_CANT_TAKE_WHILE_BEING_DAMAGED, // Can't take while being damaged!
    SPELL_CUSTOM_ERROR_YOU_ARE_BOUND_TO_DRAENOR, // You are bound to Draenor by Archimonde's magic.
    SPELL_CUSTOM_ERROR_ALREAY_HAVE_MAX_NUMBER_OF_SHIPS, // You already have the maximum number of ships your shipyard can support.
    SPELL_CUSTOM_ERROR_MUST_BE_AT_SHIPYARD, // You must be at your shipyard.
    SPELL_CUSTOM_ERROR_REQUIRES_LEVEL_3_MAGE_TOWER, // Requires a level 3 Mage Tower.
    SPELL_CUSTOM_ERROR_REQUIRES_LEVEL_3_SPIRIT_LODGE, // Requires a level 3 Spirit Lodge.
    SPELL_CUSTOM_ERROR_YOU_DO_NOT_LIKE_FEL_EGGS_AND_HAM, // You do not like Fel Eggs and Ham.
    SPELL_CUSTOM_ERROR_ALREADY_ENTERED_IN_THIS_AGREEMENT, // You have already entered in to this trade agreement.
    SPELL_CUSTOM_ERROR_CANNOT_STEAL_THAT_WHILE_GUARDS_ARE_ON_DUTY, // You cannot steal that while guards are on duty.
    SPELL_CUSTOM_ERROR_YOU_ALREADY_USED_VANTUS_RUNE, // You have already used a Vantus Rune this week.
    SPELL_CUSTOM_ERROR_THAT_ITEM_CANNOT_BE_OBLITERATED, // That item cannot be obliterated.
    SPELL_CUSTOM_ERROR_NO_SKINNABLE_CORPSE_IN_RANGE, // No skinnable corpse in range
    SPELL_CUSTOM_ERROR_MUST_BE_MERCENARY_TO_USE_TRINKET, // You must be a Mercenary to use this trinket.
    SPELL_CUSTOM_ERROR_YOU_MUST_BE_IN_COMBAT, // You must be in combat.
    SPELL_CUSTOM_ERROR_NO_ENEMIES_NEAR_TARGET, // No enemies near target.
    SPELL_CUSTOM_ERROR_REQUIRES_LEYSPINE_MISSILE, // Requires a Leyspine Missile
    SPELL_CUSTOM_ERROR_REQUIRES_BOTH_CURRENTS_CONNECTED, // Requires both currents connected.
    SPELL_CUSTOM_ERROR_CANT_DO_THAT_IN_DEMON_FORM, // Can't do that while in demon form (yet)
    SPELL_CUSTOM_ERROR_YOU_DONT_KNOW_HOW_TO_TAME_MECHS, // You do not know how to tame or obtain lore about Mechs.
    SPELL_CUSTOM_ERROR_CANNOT_CHARM_ANY_MORE_WITHERED, // You cannot charm any more withered.
    SPELL_CUSTOM_ERROR_REQUIRES_ACTIVE_HEALING_RAIN, // Requires an active Healing Rain.
    SPELL_CUSTOM_ERROR_ALREADY_COLLECTED_APPEARANCES, // You've already collected these appearances
    SPELL_CUSTOM_ERROR_CANNOT_RESURRECT_SURRENDERED_TO_MADNESS, // Cannot resurrect someone who has surrendered to madness
    SPELL_CUSTOM_ERROR_YOU_MUST_BE_IN_CAT_FORM, // You must be in Cat Form.
    SPELL_CUSTOM_ERROR_YOU_CANNOT_RELEASE_SPIRIT_YET, // You cannot Release Spirit yet.
    SPELL_CUSTOM_ERROR_NO_FISHING_NODES_NEARBY, // No fishing nodes nearby.
    SPELL_CUSTOM_ERROR_YOU_ARE_NOT_IN_CORRECT_SPEC, // You are not the correct specialization.
    SPELL_CUSTOM_ERROR_ULTHALESH_HAS_NO_POWER_WITHOUT_SOULS, // Ulthalesh has no power without souls.
    SPELL_CUSTOM_ERROR_CANNOT_CAST_THAT_WITH_VOODOO_TOTEM, // You cannot cast that while talented into Voodoo Totem.
    SPELL_CUSTOM_ERROR_ALREADY_COLLECTED_THIS_APPEARANCE, // You've already collected this appearance.
    SPELL_CUSTOM_ERROR_YOUR_PET_MAXIMUM_IS_ALREADY_HIGH, // Your total pet maximum is already this high.
    SPELL_CUSTOM_ERROR_YOU_DONT_HAVE_ENOUGH_WITHERED, // You do not have enough withered to do that.
    SPELL_CUSTOM_ERROR_REQUIRES_NEARBY_SOUL_FRAGMENT, // Requires a nearby Soul Fragment.
    SPELL_CUSTOM_ERROR_REQUIRES_AT_LEAST_10_WITHERED, // Requires at least 10 living withered
    SPELL_CUSTOM_ERROR_REQUIRES_AT_LEAST_14_WITHERED, // Requires at least 14 living withered
    SPELL_CUSTOM_ERROR_REQUIRES_AT_LEAST_18_WITHERED, // Requires at least 18 living withered
    SPELL_CUSTOM_ERROR_REQUIRES_2_WITHERED_MANA_RAGERS, // Requires 2 Withered Mana-Ragers
    SPELL_CUSTOM_ERROR_REQUIRES_1_WITHERED_BERSERKE, // Requires 1 Withered Berserker
    SPELL_CUSTOM_ERROR_REQUIRES_2_WITHERED_BERSERKER, // Requires 2 Withered Berserkers
    SPELL_CUSTOM_ERROR_TARGET_HEALTH_IS_TOO_LOW, // Target's health is too low
    SPELL_CUSTOM_ERROR_CANNOT_SHAPESHIFT_WHILE_RIDING_STORMTALON, // You cannot shapeshift while riding Stormtalon
    SPELL_CUSTOM_ERROR_CANNOT_CHANGE_SPEC_IN_COMBAT_TRAINING, // You can not change specializations while in Combat Training.
    SPELL_CUSTOM_ERROR_UNKNOWN_PHENOMENON_PREVENTS_LEYLINE_CONNECTION, // Unknown phenomenon is preventing a connection to the Leyline.
    SPELL_CUSTOM_ERROR_THE_NIGHTMARE_OBSCURES_YOUR_VISION, // The Nightmare obscures your vision.
    SPELL_CUSTOM_ERROR_YOU_ARE_IN_WRONG_CLASS_SPEC, // You are in the wrong class specialization.
    SPELL_CUSTOM_ERROR_THERE_ARE_NO_VALID_CORPSES_NEARBY, // There are no valid corpses nearby.
    SPELL_CUSTOM_ERROR_CANT_CAST_THAT_RIGHT_NOW, // Can't cast that right now.
    SPELL_CUSTOM_ERROR_NOT_ENOUGH_ANCIENT_MAN, // Not enough Ancient Mana.
    SPELL_CUSTOM_ERROR_REQUIRES_SONG_SCROLL, // Requires a Song Scroll to function.
    SPELL_CUSTOM_ERROR_MUST_HAVE_ARTIFACT_EQUIPPED, // You must have an artifact weapon equipped.
    SPELL_CUSTOM_ERROR_REQUIRES_CAT_FORM, // Requires Cat Form.
    SPELL_CUSTOM_ERROR_REQUIRES_BEAR_FORM, // Requires Bear Form.
    SPELL_CUSTOM_ERROR_REQUIRES_CONJURED_FOOD, // Requires either a Conjured Mana Pudding or Conjured Mana Fritter.
    SPELL_CUSTOM_ERROR_REQUIRES_ARTIFACT_WEAPON, // Requires an artifact weapon.
    SPELL_CUSTOM_ERROR_YOU_CANT_CAST_THAT_HERE, // You can't cast that here
    SPELL_CUSTOM_ERROR_CANT_DO_THAT_ON_CLASS_TRIAL, // You cannot do that while on a Class Trial.
    SPELL_CUSTOM_ERROR_RITUAL_OF_DOOM_ONCE_PER_DAY, // You can only benefit from the Ritual of Doom once per day.
    SPELL_CUSTOM_ERROR_CANNOT_RITUAL_OF_DOOM_WHILE_SUMMONING_SITERS, // You cannot perform the Ritual of Doom while attempting to summon the sisters.
    SPELL_CUSTOM_ERROR_LEARNED_ALL_THAT_YOU_CAN_ABOUT_YOUR_ARTIFACT, // You have learned all that you can about your artifact.
    SPELL_CUSTOM_ERROR_CANT_CALL_PET_WITH_LONE_WOLF, // You cannot use Call Pet while Lone Wolf is active.
    SPELL_CUSTOM_ERROR_YOU_MUST_BE_IN_AN_INN_TO_STRUM_THAT_GUITAR, // You must be in an inn to strum that guitar.
    SPELL_CUSTOM_ERROR_YOU_CANNOT_REACH_THE_LATCH, // You cannot reach the latch.
    SPELL_CUSTOM_ERROR_REQUIRES_A_BRIMMING_KEYSTONE, // Requires a Brimming Keystone.
    SPELL_CUSTOM_ERROR_YOU_MUST_BE_WIELDING_THE_UNDERLIGHT_ANGLER, // You must be wielding the Underlight Angler.
    SPELL_CUSTOM_ERROR_YOUR_TARGET_MUST_BE_SHACKLED, // Your target must be Shackled.
    SPELL_CUSTOM_ERROR_YOU_ALREADY_POSSES_ALL_OF_THE_KNOWLEDGE_CONTAINED_IN_THOSE_PAGES, // You already possess all of the knowledge contained in these pages.
    SPELL_CUSTOM_ERROR_YOU_CANT_RISK_GETTING_THE_GRUMMELS_WET, // You can't risk getting the grummels wet!
    SPELL_CUSTOM_ERROR_YOU_CANNOT_CHANGE_SPECIALIZATION_RIGHT_NOW, // You cannot change specializations right now.
    SPELL_CUSTOM_ERROR_YOUVE_REACHED_THE_MAXIMUM_NUMBER_OF_ARTIFACT_RESEARCH_NOTES_AVAILABLE, // You've reached the maximum number of Artifact Research Notes available.
    SPELL_CUSTOM_ERROR_YOU_DONT_HAVE_ENOUGH_NETHERSHARDS, // You don't have enough Nethershards.
    SPELL_CUSTOM_ERROR_THE_SENTINAX_IS_NOT_PATROLLING_THIS_AREA, // The Sentinax is not patrolling this area.
    SPELL_CUSTOM_ERROR_THE_SENTINAX_CANNOT_OPEN_ANOTHER_PORTAL_RIGHT_NOW, // The Sentinax cannot open another portal right now.
    SPELL_CUSTOM_ERROR_YOU_CANNOT_GAIN_ADDITIONAL_REPUTATION_WITH_THIS_ITEM, // You cannot gain additional reputation with this item.
    SPELL_CUSTOM_ERROR_CANT_DO_THAT_WHILE_GHOST_WOLF_FORM, // Can't do that while in Ghost Wolf form.
    SPELL_CUSTOM_ERROR_YOUR_SUPPLIES_ARE_FROZEN, // Your supplies are frozen.
    SPELL_CUSTOM_ERROR_YOU_DO_NOT_KNOW_HOW_TO_TAME_FEATHERMANES, // You do not know how to tame Feathermanes.
    SPELL_CUSTOM_ERROR_YOU_MUST_REACH_ARTIFACT_KNOWLEDGE_LEVEL_25, // You must reach Artifact Knowledge level 25 to use the Tome.
    SPELL_CUSTOM_ERROR_REQUIRES_A_NETHER_PORTAL_DISRUPTOR, // Requires a Nether Portal Disruptor.
    SPELL_CUSTOM_ERROR_MUST_BE_STANDING_NEAR_INJURED_CHROMIE_IN_MOUNT_HYJAL, // Must be standing near the injured Chromie in Mount Hyjal.
    SPELL_CUSTOM_ERROR_REMOVE_CANNONS_HEAVY_IRON_PLATING_FIRST, // You should remove the cannon's Heavy Iron Plating first.
    SPELL_CUSTOM_ERROR_REMOVE_CANNONS_ELECTROKINETIC_DEFENSE_GRID_FIRST, // You should remove the cannon's Electrokinetic Defense Grid first.
    SPELL_CUSTOM_ERROR_REQUIRES_THE_ARMORY_KEY_AND_DENDRITE_CLUSTERS, // You are missing pieces of the Armory Key or do not have enough Dendrite Clusters.
    SPELL_CUSTOM_ERROR_THIS_ITEM_REQUIRES_BASIC_OBLITERUM_TO_UPGRADE, // This item requires basic Obliterum to upgrade.
    SPELL_CUSTOM_ERROR_THIS_ITEM_REQUIRES_PRIMAL_OBLITERUM_TO_UPGRADE, // This item requires Primal Obliterum to upgrade.
    SPELL_CUSTOM_ERROR_THIS_ITEM_REQUIRES_FLIGHT_MASTERS_WHISTLE, // This item requires a Flight Master's Whistle.
    SPELL_CUSTOM_ERROR_REQUIRES_POWER_THAT_ECHOES_THAT_OF_THE_AUGARI, // Will only open to one wielding the power that echoes that of the Augari.
    SPELL_CUSTOM_ERROR_THAT_PLAYER_HAS_A_PENDING_TOTEMIC_REVIVAL, // That player has a pending Totemic Revival.
    SPELL_CUSTOM_ERROR_YOU_HAVE_NO_FIRE_MINES_DEPLOYED, // You have no Fire Mines deployed.
    SPELL_CUSTOM_ERROR_YOU_ARE_BLOCKED_BY_A_STRUCTURE_ABOVE_YOU, // You are blocked by a structure above you.
    SPELL_CUSTOM_ERROR_REQUIRES_100_IMP_MEAT, // Requires 100 Imp Meat.
    SPELL_CUSTOM_ERROR_YOU_HAVE_NOT_OBTAINED_ANY_BACKGROUND_FILTERS, // You have not obtained any background filters.
    SPELL_CUSTOM_ERROR_NOTHING_INTERESTING_POSTED_HERE_RIGHT_NOW, // There is nothing interesting posted here right now.
    SPELL_CUSTOM_ERROR_PARAGON_REPUTATION_REQUIRES_HIGHER_LEVEL, // Paragon Reputation is not available until a higher level.
    SPELL_CUSTOM_ERROR_UUNA_IS_MISSING                                   // Uuna is missing.
}
