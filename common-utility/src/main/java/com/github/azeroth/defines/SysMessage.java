package com.github.azeroth.defines;

public interface SysMessage {
    // for chat commands
    short LANG_SELECT_CHAR_OR_CREATURE          = 1;
    short LANG_SELECT_CREATURE                  = 2;

    // level 0 chat
    short LANG_SYSTEMMESSAGE                    = 3;
    short LANG_EVENTMESSAGE                     = 4;
    short LANG_NO_HELP_CMD                      = 5;
    short LANG_CMD_INVALID                      = 6;
    short LANG_SUBCMD_AMBIGUOUS                 = 7;
    short LANG_SUBCMDS_LIST                     = 8;
    short LANG_AVAILABLE_CMDS                   = 9;
    short LANG_CMD_SYNTAX                       = 10;
    short LANG_ACCOUNT_LEVEL                    = 11;
    short LANG_CONNECTED_USERS                  = 12;
    short LANG_UPTIME                           = 13;
    short LANG_PLAYER_SAVED                     = 14;
    short LANG_PLAYERS_SAVED                    = 15;
    short LANG_GMS_ON_SRV                       = 16;
    short LANG_GMS_NOT_LOGGED                   = 17;
    short LANG_YOU_IN_FLIGHT                    = 18;
    short LANG_UPDATE_DIFF                      = 19;
    short LANG_SHUTDOWN_TIMELEFT                = 20;
    short LANG_CHAR_IN_FLIGHT                   = 21;
    short LANG_CHAR_NON_MOUNTED                 = 22;
    short LANG_YOU_IN_COMBAT                    = 23;
    short LANG_YOU_USED_IT_RECENTLY             = 24;
    short LANG_COMMAND_NOTCHANGEPASSWORD        = 25;
    short LANG_COMMAND_PASSWORD                 = 26;
    short LANG_COMMAND_WRONGOLDPASSWORD         = 27;
    short LANG_COMMAND_ACCLOCKLOCKED            = 28;
    short LANG_COMMAND_ACCLOCKUNLOCKED          = 29;
    short LANG_SPELL_RANK                       = 30;
    short LANG_KNOWN                            = 31;
    short LANG_LEARN                            = 32;
    short LANG_PASSIVE                          = 33;
    short LANG_TALENT                           = 34;
    short LANG_ACTIVE                           = 35;
    short LANG_COMPLETE                         = 36;
    short LANG_OFFLINE                          = 37;
    short LANG_ON                               = 38;
    short LANG_OFF                              = 39;
    short LANG_YOU_ARE                          = 40;
    short LANG_VISIBLE                          = 41;
    short LANG_INVISIBLE                        = 42;
    short LANG_DONE                             = 43;
    short LANG_YOU                              = 44;
    short LANG_UNKNOWN                          = 45;
    short LANG_ERROR                            = 46;
    short LANG_NON_EXIST_CHARACTER              = 47;
    short LANG_ONLINE                           = 48;
    short LANG_LEVEL_MINREQUIRED                = 49;
    short LANG_LEVEL_MINREQUIRED_AND_ITEM       = 50;
    short LANG_NPC_TAINER_HELLO                 = 51;
    short LANG_COMMAND_INVALID_ITEM_COUNT       = 52;
    short LANG_COMMAND_MAIL_ITEMS_LIMIT         = 53;
    short LANG_NEW_PASSWORDS_NOT_MATCH          = 54;
    short LANG_PASSWORD_TOO_LONG                = 55;
    short LANG_MOTD_CURRENT                     = 56;
    short LANG_USING_WORLD_DB                   = 57;
    short LANG_USING_SCRIPT_LIB                 = 58;
    short LANG_USING_EVENT_AI                   = 59;
    short LANG_CONNECTED_PLAYERS                = 60;
    short LANG_ACCOUNT_ADDON                    = 61;
    short LANG_IMPROPER_VALUE                   = 62;
    short LANG_RBAC_WRONG_PARAMETER_ID          = 63;
    short LANG_RBAC_WRONG_PARAMETER_REALM       = 64;
    short LANG_RBAC_LIST_HEADER_GRANTED         = 65;
    short LANG_RBAC_LIST_HEADER_DENIED          = 66;
    short LANG_RBAC_LIST_HEADER_BY_SEC_LEVEL    = 67;
    short LANG_RBAC_LIST_PERMISSIONS_HEADER     = 68;
    short LANG_RBAC_LIST_PERMS_LINKED_HEADER    = 69;
    short LANG_RBAC_LIST_EMPTY                  = 70;
    short LANG_RBAC_LIST_ELEMENT                = 71;
    short LANG_RBAC_PERM_GRANTED_IN_LIST        = 72;
    short LANG_RBAC_PERM_GRANTED_IN_DENIED_LIST = 73;
    short LANG_RBAC_PERM_GRANTED                = 74;
    short LANG_RBAC_PERM_DENIED_IN_LIST         = 75;
    short LANG_RBAC_PERM_DENIED_IN_GRANTED_LIST = 76;
    short LANG_RBAC_PERM_DENIED                 = 77;
    short LANG_RBAC_PERM_REVOKED                = 78;
    short LANG_RBAC_PERM_REVOKED_NOT_IN_LIST    = 79;
    short LANG_PVPSTATS                         = 80;
    short LANG_PVPSTATS_DISABLED                = 81;
    short LANG_COMMAND_NEARGRAVEYARD            = 82;
    short LANG_COMMAND_NEARGRAVEYARD_NOTFOUND   = 83;
    short LANG_GOINFO_SIZE                      = 84;
    short LANG_GOINFO_ADDON                     = 85;
    short LANG_GOINFO_MODEL                     = 86;
    short LANG_UNKNOWN_ERROR                    = 87;
    short LANG_2FA_COMMANDS_NOT_SETUP           = 88;
    short LANG_2FA_ALREADY_SETUP                = 89;
    short LANG_2FA_INVALID_TOKEN                = 90;
    short LANG_2FA_SECRET_SUGGESTION            = 91;
    short LANG_2FA_SETUP_COMPLETE               = 92;
    short LANG_2FA_NOT_SETUP                    = 93;
    short LANG_2FA_REMOVE_NEED_TOKEN            = 94;
    short LANG_2FA_REMOVE_COMPLETE              = 95;
    short LANG_GUILD_RENAME_ALREADY_EXISTS      = 96;
    short LANG_GUILD_RENAME_DONE                = 97;
    short LANG_RENAME_PLAYER_ALREADY_EXISTS     = 98;
    short LANG_RENAME_PLAYER_WITH_NEW_NAME      = 99;

    // level 1 chat
    short LANG_GLOBAL_NOTIFY                    = 100;
    short LANG_MAP_POSITION                     = 101;
    short LANG_IS_TELEPORTED                    = 102;
    short LANG_CANNOT_SUMMON_TO_INST            = 103;
    short LANG_CANNOT_GO_TO_INST_PARTY          = 104;
    short LANG_CANNOT_GO_TO_INST_GM             = 105;
    short LANG_CANNOT_GO_INST_INST              = 106;
    short LANG_CANNOT_SUMMON_INST_INST          = 107;
    short LANG_SUMMONING                        = 108;
    short LANG_SUMMONED_BY                      = 109;
    short LANG_TELEPORTING_TO                   = 110;
    short LANG_TELEPORTED_TO_BY                 = 111;
    short LANG_NO_PLAYER                        = 112;
    short LANG_APPEARING_AT                     = 113;
    short LANG_APPEARING_TO                     = 114;
    short LANG_BAD_VALUE                        = 115;
    short LANG_NO_CHAR_SELECTED                 = 116;
    short LANG_NOT_IN_GROUP                     = 117;

    short LANG_YOU_CHANGE_HP                    = 118;
    short LANG_YOURS_HP_CHANGED                 = 119;
    short LANG_YOU_CHANGE_MANA                  = 120;
    short LANG_YOURS_MANA_CHANGED               = 121;
    short LANG_YOU_CHANGE_ENERGY                = 122;
    short LANG_YOURS_ENERGY_CHANGED             = 123;

    short LANG_CURRENT_ENERGY                   = 124;              //log
    short LANG_YOU_CHANGE_RAGE                  = 125;
    short LANG_YOURS_RAGE_CHANGED               = 126;
    short LANG_YOU_CHANGE_LVL                   = 127;
    short LANG_CURRENT_FACTION                  = 128;
    short LANG_WRONG_FACTION                    = 129;
    short LANG_YOU_CHANGE_FACTION               = 130;
    short LANG_YOU_CHANGE_SPELLFLATID           = 131;
    short LANG_YOURS_SPELLFLATID_CHANGED        = 132;
    short LANG_YOU_GIVE_TAXIS                   = 133;
    short LANG_YOU_REMOVE_TAXIS                 = 134;
    short LANG_YOURS_TAXIS_ADDED                = 135;
    short LANG_YOURS_TAXIS_REMOVED              = 136;

    short LANG_YOU_CHANGE_ASPEED                = 137;
    short LANG_YOURS_ASPEED_CHANGED             = 138;
    short LANG_YOU_CHANGE_SPEED                 = 139;
    short LANG_YOURS_SPEED_CHANGED              = 140;
    short LANG_YOU_CHANGE_SWIM_SPEED            = 141;
    short LANG_YOURS_SWIM_SPEED_CHANGED         = 142;
    short LANG_YOU_CHANGE_BACK_SPEED            = 143;
    short LANG_YOURS_BACK_SPEED_CHANGED         = 144;
    short LANG_YOU_CHANGE_FLY_SPEED             = 145;
    short LANG_YOURS_FLY_SPEED_CHANGED          = 146;

    short LANG_YOU_CHANGE_SIZE                  = 147;
    short LANG_YOURS_SIZE_CHANGED               = 148;
    short LANG_NO_MOUNT                         = 149;
    short LANG_YOU_GIVE_MOUNT                   = 150;
    short LANG_MOUNT_GIVED                      = 151;

    short LANG_CURRENT_MONEY                    = 152;
    short LANG_YOU_TAKE_ALL_MONEY               = 153;
    short LANG_YOURS_ALL_MONEY_GONE             = 154;
    short LANG_YOU_TAKE_MONEY                   = 155;
    short LANG_YOURS_MONEY_TAKEN                = 156;
    short LANG_YOU_GIVE_MONEY                   = 157;
    short LANG_YOURS_MONEY_GIVEN                = 158;
    short LANG_YOU_HEAR_SOUND                   = 159;

    short LANG_NEW_MONEY                        = 160;              // Log

    short LANG_REMOVE_BIT                       = 161;
    short LANG_SET_BIT                          = 162;
    short LANG_COMMAND_TELE_TABLEEMPTY          = 163;
    short LANG_COMMAND_TELE_NOTFOUND            = 164;
    short LANG_COMMAND_TELE_PARAMETER           = 165;
    short LANG_COMMAND_TELE_NOLOCATION          = 166;
    short LANG_RESERVED_NAME                    = 167;
    short LANG_COMMAND_TELE_LOCATION            = 168;

    short LANG_MAIL_SENT                        = 169;
    short LANG_SOUND_NOT_EXIST                  = 170;
    short LANG_CANT_TELEPORT_SELF               = 171;
    short LANG_CONSOLE_COMMAND                  = 172;
    short LANG_YOU_CHANGE_RUNIC_POWER           = 173;
    short LANG_YOURS_RUNIC_POWER_CHANGED        = 174;
    short LANG_LIQUID_STATUS                    = 175;
    short LANG_INVALID_GAMEOBJECT_TYPE          = 176;
    short LANG_GAMEOBJECT_DAMAGED               = 177;
    short LANG_GRID_POSITION                    = 178;

    short LANG_PHASESHIFT_STATUS                = 179;
    short LANG_PHASESHIFT_PHASES                = 180;
    short LANG_PHASESHIFT_VISIBLE_MAP_IDS       = 181;
    short LANG_PHASESHIFT_UI_WORLD_MAP_AREA_SWAPS = 182;
    short LANG_PHASE_FLAG_COSMETIC              = 183;
    short LANG_PHASE_FLAG_PERSONAL              = 184;

    //                                      185 not used
    short LANG_TRANSPORT_POSITION               = 186;
    short LANG_PARTIAL_GROUP_SUMMON             = 187;
    short LANG_2FA_SECRET_TOO_LONG              = 188;
    short LANG_2FA_SECRET_INVALID               = 189;
    short LANG_2FA_SECRET_SET_COMPLETE          = 190;
    short LANG_SUBCMDS_LIST_ENTRY               = 191;
    short LANG_SUBCMDS_LIST_ENTRY_ELLIPSIS      = 192;
    short LANG_SUBCMD_INVALID                   = 193;
    short LANG_CMD_AMBIGUOUS                    = 194;
    short LANG_CMD_HELP_GENERIC                 = 195;
    short LANG_CMD_NO_HELP_AVAILABLE            = 196;
    // Room for more level 1                197-199 not used

    // level 2 chat
    short LANG_NO_SELECTION                     = 200;
    short LANG_OBJECT_GUID                      = 201;
    short LANG_TOO_LONG_NAME                    = 202;
    short LANG_CHARS_ONLY                       = 203;
    short LANG_TOO_LONG_SUBNAME                 = 204;
    short LANG_NOT_IMPLEMENTED                  = 205;

    short LANG_ITEM_ADDED_TO_LIST               = 206;
    short LANG_ITEM_NOT_FOUND                   = 207;
    short LANG_ITEM_DELETED_FROM_LIST           = 208;
    short LANG_ITEM_NOT_IN_LIST                 = 209;
    short LANG_ITEM_ALREADY_IN_LIST             = 210;

    short LANG_RESET_SPELLS_ONLINE              = 211;
    short LANG_RESET_SPELLS_OFFLINE             = 212;
    short LANG_RESET_TALENTS_ONLINE             = 213;
    short LANG_RESET_TALENTS_OFFLINE            = 214;
    short LANG_RESET_SPELLS                     = 215;
    short LANG_RESET_TALENTS                    = 216;

    short LANG_RESETALL_UNKNOWN_CASE            = 217;
    short LANG_RESETALL_SPELLS                  = 218;
    short LANG_RESETALL_TALENTS                 = 219;

    short LANG_WAYPOINT_NOTFOUND                = 220;
    short LANG_WAYPOINT_NOTFOUNDLAST            = 221;
    short LANG_WAYPOINT_NOTFOUNDSEARCH          = 222;
    short LANG_WAYPOINT_NOTFOUNDDBPROBLEM       = 223;
    short LANG_WAYPOINT_CREATSELECTED           = 224;
    short LANG_WAYPOINT_CREATNOTFOUND           = 225;
    short LANG_WAYPOINT_VP_SELECT               = 226;
    short LANG_WAYPOINT_VP_NOTFOUND             = 227;
    short LANG_WAYPOINT_VP_NOTCREATED           = 228;
    short LANG_WAYPOINT_VP_ALLREMOVED           = 229;
    short LANG_WAYPOINT_NOTCREATED              = 230;
    short LANG_WAYPOINT_NOGUID                  = 231;
    short LANG_WAYPOINT_NOWAYPOINTGIVEN         = 232;
    short LANG_WAYPOINT_ARGUMENTREQ             = 233;
    short LANG_WAYPOINT_ADDED                   = 234;
    short LANG_WAYPOINT_ADDED_NO                = 235;
    short LANG_WAYPOINT_CHANGED                 = 236;
    short LANG_WAYPOINT_CHANGED_NO              = 237;
    short LANG_WAYPOINT_EXPORTED                = 238;
    short LANG_WAYPOINT_NOTHINGTOEXPORT         = 239;
    short LANG_WAYPOINT_IMPORTED                = 240;
    short LANG_WAYPOINT_REMOVED                 = 241;
    short LANG_WAYPOINT_NOTREMOVED              = 242;
    short LANG_WAYPOINT_TOOFAR1                 = 243;
    short LANG_WAYPOINT_TOOFAR2                 = 244;
    short LANG_WAYPOINT_TOOFAR3                 = 245;
    short LANG_WAYPOINT_INFO_TITLE              = 246;
    short LANG_WAYPOINT_INFO_WAITTIME           = 247;
    short LANG_WAYPOINT_INFO_MODEL              = 248;
    short LANG_WAYPOINT_INFO_EMOTE              = 249;
    short LANG_WAYPOINT_INFO_SPELL              = 250;
    short LANG_WAYPOINT_INFO_TEXT               = 251;
    short LANG_WAYPOINT_INFO_AISCRIPT           = 252;

    short LANG_RENAME_PLAYER                    = 253;
    short LANG_RENAME_PLAYER_GUID               = 254;

    short LANG_WAYPOINT_WPCREATNOTFOUND         = 255;
    short LANG_WAYPOINT_NPCNOTFOUND             = 256;

    short LANG_MOVE_TYPE_SET                    = 257;
    short LANG_MOVE_TYPE_SET_NODEL              = 258;
    short LANG_USE_BOL                          = 259;
    short LANG_VALUE_SAVED                      = 260;
    short LANG_VALUE_SAVED_REJOIN               = 261;

    short LANG_COMMAND_GOAREATRNOTFOUND         = 262;
    short LANG_INVALID_TARGET_COORD             = 263;
    short LANG_INVALID_ZONE_COORD               = 264;
    short LANG_INVALID_ZONE_MAP                 = 265;
    short LANG_COMMAND_TARGETOBJNOTFOUND        = 266;
    short LANG_COMMAND_GOOBJNOTFOUND            = 267;
    short LANG_COMMAND_GOCREATNOTFOUND          = 268;
    short LANG_COMMAND_GOCREATMULTIPLE          = 269;
    short LANG_COMMAND_DELCREATMESSAGE          = 270;
    short LANG_COMMAND_CREATUREMOVED            = 271;
    short LANG_COMMAND_CREATUREATSAMEMAP        = 272;
    short LANG_COMMAND_OBJNOTFOUND              = 273;
    short LANG_COMMAND_DELOBJREFERCREATURE      = 274;
    short LANG_COMMAND_DELOBJMESSAGE            = 275;
    short LANG_COMMAND_TURNOBJMESSAGE           = 276;
    short LANG_COMMAND_MOVEOBJMESSAGE           = 277;
    short LANG_COMMAND_VENDORSELECTION          = 278;
    short LANG_COMMAND_NEEDITEMSEND             = 279;
    short LANG_COMMAND_ADDVENDORITEMITEMS       = 280;
    short LANG_COMMAND_KICKSELF                 = 281;
    short LANG_COMMAND_KICKMESSAGE              = 282;
    short LANG_COMMAND_DISABLE_CHAT_DELAYED     = 283;
    short LANG_COMMAND_WHISPERACCEPTING         = 284;
    short LANG_COMMAND_WHISPERON                = 285;
    short LANG_COMMAND_WHISPEROFF               = 286;
    short LANG_COMMAND_CREATGUIDNOTFOUND        = 287;
    short LANG_COMMAND_NOT_DEAD_OR_NO_LOOT      = 288;
    short LANG_COMMAND_NPC_SHOWLOOT_HEADER      = 289;
    short LANG_COMMAND_NPC_SHOWLOOT_LABEL       = 290;
    short LANG_COMMAND_NPC_SHOWLOOT_ENTRY       = 291;
    short LANG_COMMAND_NPC_SHOWLOOT_MONEY       = 292;
    short LANG_COMMAND_NPC_SHOWLOOT_LABEL_2     = 293;
    short LANG_COMMAND_NPC_SHOWLOOT_SUBLABEL    = 294;
    short LANG_COMMAND_NPC_SHOWLOOT_ENTRY_2     = 295;
    // 296 free

    // END
    short LANG_COMMAND_WANDER_DISTANCE          = 297;
    short LANG_COMMAND_SPAWNTIME                = 298;
    short LANG_COMMAND_MODIFY_HONOR             = 299;

    short LANG_YOUR_CHAT_DISABLED               = 300;
    short LANG_YOU_DISABLE_CHAT                 = 301;
    short LANG_CHAT_ALREADY_ENABLED             = 302;
    short LANG_YOUR_CHAT_ENABLED                = 303;
    short LANG_YOU_ENABLE_CHAT                  = 304;

    short LANG_COMMAND_MODIFY_REP               = 305;
    short LANG_COMMAND_MODIFY_ARENA             = 306;
    short LANG_COMMAND_FACTION_NOTFOUND         = 307;
    short LANG_COMMAND_FACTION_UNKNOWN          = 308;
    short LANG_COMMAND_INVALID_PARAM            = 309;
    short LANG_COMMAND_FACTION_DELTA            = 310;
    short LANG_FACTION_LIST                     = 311;
    short LANG_FACTION_VISIBLE                  = 312;
    short LANG_FACTION_ATWAR                    = 313;
    short LANG_FACTION_PEACE_FORCED             = 314;
    short LANG_FACTION_HIDDEN                   = 315;
    short LANG_FACTION_INVISIBLE_FORCED         = 316;
    short LANG_FACTION_INACTIVE                 = 317;
    short LANG_REP_HATED                        = 318;
    short LANG_REP_HOSTILE                      = 319;
    short LANG_REP_UNFRIENDLY                   = 320;
    short LANG_REP_NEUTRAL                      = 321;
    short LANG_REP_FRIENDLY                     = 322;
    short LANG_REP_HONORED                      = 323;
    short LANG_REP_REVERED                      = 324;
    short LANG_REP_EXALTED                      = 325;
    short LANG_COMMAND_FACTION_NOREP_ERROR      = 326;
    short LANG_FACTION_NOREPUTATION             = 327;
    short LANG_LOOKUP_PLAYER_ACCOUNT            = 328;
    short LANG_LOOKUP_PLAYER_CHARACTER          = 329;
    short LANG_NO_PLAYERS_FOUND                 = 330;
    short LANG_EXTENDED_COST_NOT_EXIST          = 331;
    short LANG_GM_ON                            = 332;
    short LANG_GM_OFF                           = 333;
    short LANG_GM_CHAT_ON                       = 334;
    short LANG_GM_CHAT_OFF                      = 335;
    short LANG_YOU_REPAIR_ITEMS                 = 336;
    short LANG_YOUR_ITEMS_REPAIRED              = 337;
    short LANG_YOU_SET_WATERWALK                = 338;
    short LANG_YOUR_WATERWALK_SET               = 339;
    short LANG_CREATURE_FOLLOW_YOU_NOW          = 340;
    short LANG_CREATURE_NOT_FOLLOW_YOU          = 341;
    short LANG_CREATURE_NOT_FOLLOW_YOU_NOW      = 342;
    short LANG_CREATURE_NON_TAMEABLE            = 343;
    short LANG_YOU_ALREADY_HAVE_PET             = 344;
    short LANG_CUSTOMIZE_PLAYER                 = 345;
    short LANG_CUSTOMIZE_PLAYER_GUID            = 346;
    short LANG_COMMAND_GOTAXINODENOTFOUND       = 347;
    short LANG_GAMEOBJECT_HAVE_INVALID_DATA     = 348;
    short LANG_TITLE_LIST_CHAT                  = 349;
    short LANG_TITLE_LIST_CONSOLE               = 350;
    short LANG_COMMAND_NOTITLEFOUND             = 351;
    short LANG_INVALID_TITLE_ID                 = 352;
    short LANG_TITLE_ADD_RES                    = 353;
    short LANG_TITLE_REMOVE_RES                 = 354;
    short LANG_TITLE_CURRENT_RES                = 355;
    short LANG_CURRENT_TITLE_RESET              = 356;
    short LANG_COMMAND_CHEAT_STATUS             = 357;
    short LANG_COMMAND_CHEAT_GOD                = 358;
    short LANG_COMMAND_CHEAT_CT                 = 359;
    short LANG_COMMAND_CHEAT_CD                 = 360;
    short LANG_COMMAND_CHEAT_POWER              = 361;
    short LANG_COMMAND_CHEAT_WW                 = 362;
    short LANG_COMMAND_WHISPEROFFPLAYER         = 363;
    short LANG_COMMAND_CHEAT_TAXINODES          = 364;
    short LANG_COMMAND_ACHIEVEMENT_ADD_HELP     = 365;
    short LANG_COMMAND_ACC_SET_ADDON_HELP       = 366;
    short LANG_COMMAND_ACC_SET_SEC_REGMAIL_HELP = 367;
    short LANG_COMMAND_ACC_SET_SEC_EMAIL_HELP   = 368;
    short LANG_COMMAND_ACC_SET_2FA_HELP         = 369;
    short LANG_COMMAND_ACC_SET_SECLEVEL_HELP    = 370;
    short LANG_COMMAND_ACC_SET_PASSWORD_HELP    = 371;
    short LANG_COMMAND_ACC_2FA_SETUP_HELP       = 372;
    short LANG_COMMAND_ACC_2FA_REMOVE_HELP      = 373;
    short LANG_COMMAND_ACC_ADDON_HELP           = 374;
    short LANG_COMMAND_ACC_CREATE_HELP          = 375;
    short LANG_COMMAND_ACC_DELETE_HELP          = 376;
    short LANG_COMMAND_ACC_EMAIL_HELP           = 377;
    short LANG_COMMAND_ACC_ONLINELIST_HELP      = 378;
    short LANG_COMMAND_ACC_LOCK_COUNTRY_HELP    = 379;
    short LANG_COMMAND_ACC_LOCK_IP_HELP         = 380;
    short LANG_COMMAND_ACC_PASSWORD_HELP        = 381;
    short LANG_COMMAND_ACCOUNT_HELP             = 382;
    short LANG_COMMAND_LEARN_HELP               = 383;
    short LANG_COMMAND_UNLEARN_HELP             = 384;
    short LANG_COMMAND_LEARN_MY_QUESTS_HELP     = 385;
    short LANG_COMMAND_LEARN_MY_TRAINER_HELP    = 386;
    short LANG_COMMAND_LEARN_ALL_BLIZZARD_HELP  = 387;
    short LANG_COMMAND_LEARN_ALL_DEBUG_HELP     = 388;
    short LANG_COMMAND_LEARN_ALL_CRAFTS_HELP    = 389;
    short LANG_COMMAND_LEARN_ALL_DEFAULT_HELP   = 390;
    short LANG_COMMAND_LEARN_ALL_LANGUAGES_HELP = 391;
    short LANG_COMMAND_LEARN_ALL_RECIPES_HELP   = 392;
    short LANG_COMMAND_LEARN_ALL_TALENTS_HELP   = 393;
    short LANG_COMMAND_LEARN_ALL_PETTALENT_HELP = 394;
    // Room for more level 2                395-399 not used

    // level 3 chat
    short LANG_SCRIPTS_RELOADED                 = 400;
    short LANG_YOU_CHANGE_SECURITY              = 401;
    short LANG_YOURS_SECURITY_CHANGED           = 402;
    short LANG_YOURS_SECURITY_IS_LOW            = 403;
    short LANG_CREATURE_MOVE_DISABLED           = 404;
    short LANG_CREATURE_MOVE_ENABLED            = 405;
    short LANG_NO_WEATHER                       = 406;
    short LANG_WEATHER_DISABLED                 = 407;

    short LANG_BAN_YOUBANNED                    = 408;
    short LANG_BAN_YOUPERMBANNED                = 409;
    short LANG_BAN_NOTFOUND                     = 410;

    short LANG_UNBAN_UNBANNED                   = 411;
    short LANG_UNBAN_ERROR                      = 412;

    short LANG_ACCOUNT_NOT_EXIST                = 413;

    short LANG_BANINFO_NOCHARACTER              = 414;
    short LANG_BANINFO_NOIP                     = 415;
    short LANG_BANINFO_NOACCOUNTBAN             = 416;
    short LANG_BANINFO_BANHISTORY               = 417;
    short LANG_BANINFO_HISTORYENTRY             = 418;
    short LANG_BANINFO_INFINITE                 = 419;
    short LANG_BANINFO_NEVER                    = 420;
    short LANG_YES                              = 421;
    short LANG_NO                               = 422;
    short LANG_BANINFO_IPENTRY                  = 423;

    short LANG_BANLIST_NOIP                     = 424;
    short LANG_BANLIST_NOACCOUNT                = 425;
    short LANG_BANLIST_NOCHARACTER              = 426;
    short LANG_BANLIST_MATCHINGIP               = 427;
    short LANG_BANLIST_MATCHINGACCOUNT          = 428;

    short LANG_COMMAND_LEARN_MANY_SPELLS        = 429;
    short LANG_COMMAND_LEARN_CLASS_SPELLS       = 430;
    short LANG_COMMAND_LEARN_CLASS_TALENTS      = 431;
    short LANG_COMMAND_LEARN_ALL_LANG           = 432;
    short LANG_COMMAND_LEARN_ALL_CRAFT          = 433;
    short LANG_COMMAND_COULDNOTFIND             = 434;
    short LANG_COMMAND_ITEMIDINVALID            = 435;
    short LANG_COMMAND_NOITEMFOUND              = 436;
    short LANG_COMMAND_LISTOBJINVALIDID         = 437;
    short LANG_COMMAND_LISTITEMMESSAGE          = 438;
    short LANG_COMMAND_LISTOBJMESSAGE           = 439;
    short LANG_COMMAND_INVALIDCREATUREID        = 440;
    short LANG_COMMAND_LISTCREATUREMESSAGE      = 441;
    short LANG_COMMAND_NOAREAFOUND              = 442;
    short LANG_COMMAND_NOITEMSETFOUND           = 443;
    short LANG_COMMAND_NOSKILLFOUND             = 444;
    short LANG_COMMAND_NOSPELLFOUND             = 445;
    short LANG_COMMAND_NOQUESTFOUND             = 446;
    short LANG_COMMAND_NOCREATUREFOUND          = 447;
    short LANG_COMMAND_NOGAMEOBJECTFOUND        = 448;
    short LANG_COMMAND_GRAVEYARDNOEXIST         = 449;
    short LANG_COMMAND_GRAVEYARDALRLINKED       = 450;
    short LANG_COMMAND_GRAVEYARDLINKED          = 451;
    short LANG_COMMAND_GRAVEYARDWRONGZONE       = 452;
    //                                    = 453; see short LANG_PINFO_PLAYER
    short LANG_COMMAND_GRAVEYARDERROR           = 454;
    short LANG_COMMAND_GRAVEYARD_NOTEAM         = 455;
    short LANG_COMMAND_GRAVEYARD_ANY            = 456;
    short LANG_COMMAND_GRAVEYARD_ALLIANCE       = 457;
    short LANG_COMMAND_GRAVEYARD_HORDE          = 458;
    short LANG_COMMAND_GRAVEYARDNEAREST         = 459;
    short LANG_COMMAND_ZONENOGRAVEYARDS         = 460;
    short LANG_COMMAND_ZONENOGRAFACTION         = 461;
    short LANG_COMMAND_TP_ALREADYEXIST          = 462;
    short LANG_COMMAND_TP_ADDED                 = 463;
    short LANG_COMMAND_TP_ADDEDERR              = 464;
    short LANG_COMMAND_TP_DELETED               = 465;
    short LANG_COMMAND_NOTAXINODEFOUND          = 466;
    short LANG_COMMAND_TARGET_LISTAURAS         = 467;
    short LANG_COMMAND_TARGET_AURADETAIL        = 468;
    short LANG_COMMAND_TARGET_LISTAURATYPE      = 469;
    short LANG_COMMAND_TARGET_AURASIMPLE        = 470;

    short LANG_COMMAND_QUEST_NOTFOUND           = 471;
    short LANG_COMMAND_QUEST_STARTFROMITEM      = 472;
    short LANG_COMMAND_QUEST_REMOVED            = 473;
    short LANG_COMMAND_QUEST_REWARDED           = 474;
    short LANG_COMMAND_QUEST_COMPLETE           = 475;
    short LANG_COMMAND_QUEST_ACTIVE             = 476;

    short LANG_COMMAND_FLYMODE_STATUS           = 477;

    short LANG_COMMAND_OPCODESENT               = 478;

    short LANG_COMMAND_IMPORT_SUCCESS           = 479;
    short LANG_COMMAND_IMPORT_FAILED            = 480;
    short LANG_COMMAND_EXPORT_SUCCESS           = 481;
    short LANG_COMMAND_EXPORT_FAILED            = 482;

    short LANG_COMMAND_SPELL_BROKEN             = 483;

    short LANG_SET_SKILL                        = 484;
    short LANG_SET_SKILL_ERROR                  = 485;

    short LANG_INVALID_SKILL_ID                 = 486;
    short LANG_LEARNING_GM_SKILLS               = 487;
    short LANG_YOU_KNOWN_SPELL                  = 488;
    short LANG_TARGET_KNOWN_SPELL               = 489;
    short LANG_UNKNOWN_SPELL                    = 490;
    short LANG_FORGET_SPELL                     = 491;
    short LANG_REMOVEALL_COOLDOWN               = 492;
    short LANG_REMOVE_COOLDOWN                  = 493;

    short LANG_ADDITEM                          = 494;              //log
    short LANG_ADDITEMSET                       = 495;              //log
    short LANG_REMOVEITEM                       = 496;
    short LANG_ITEM_CANNOT_CREATE               = 497;
    short LANG_INSERT_GUILD_NAME                = 498;
    short LANG_PLAYER_NOT_FOUND                 = 499;
    short LANG_PLAYER_IN_GUILD                  = 500;
    short LANG_GUILD_NOT_CREATED                = 501;
    short LANG_NO_ITEMS_FROM_ITEMSET_FOUND      = 502;

    short LANG_DISTANCE                         = 503;

    short LANG_ITEM_SLOT                        = 504;
    short LANG_ITEM_SLOT_NOT_EXIST              = 505;
    short LANG_ITEM_ADDED_TO_SLOT               = 506;
    short LANG_ITEM_SAVE_FAILED                 = 507;
    short LANG_ITEMLIST_SLOT                    = 508;
    short LANG_ITEMLIST_MAIL                    = 509;
    short LANG_ITEMLIST_AUCTION                 = 510;

    short LANG_WRONG_LINK_TYPE                  = 511;
    short LANG_ITEM_LIST_CHAT                   = 512;
    short LANG_QUEST_LIST_CHAT                  = 513;
    short LANG_CREATURE_ENTRY_LIST_CHAT         = 514;
    short LANG_CREATURE_LIST_CHAT               = 515;
    short LANG_GO_ENTRY_LIST_CHAT               = 516;
    short LANG_GO_LIST_CHAT                     = 517;
    short LANG_ITEMSET_LIST_CHAT                = 518;
    short LANG_TELE_LIST                        = 519;
    short LANG_SPELL_LIST                       = 520;
    short LANG_SKILL_LIST_CHAT                  = 521;

    short LANG_GAMEOBJECT_NOT_EXIST             = 522;

    short LANG_GAMEOBJECT_CURRENT               = 523;              //log
    short LANG_GAMEOBJECT_DETAIL                = 524;
    short LANG_GAMEOBJECT_ADD                   = 525;

    short LANG_MOVEGENS_LIST                    = 526;
    short LANG_MOVEGENS_IDLE                    = 527;
    short LANG_MOVEGENS_RANDOM                  = 528;
    short LANG_MOVEGENS_WAYPOINT                = 529;
    //                                    = 530; not used
    short LANG_MOVEGENS_CONFUSED                = 531;
    short LANG_MOVEGENS_CHASE_PLAYER            = 532;
    short LANG_MOVEGENS_CHASE_CREATURE          = 533;
    short LANG_MOVEGENS_CHASE_NULL              = 534;
    short LANG_MOVEGENS_HOME_CREATURE           = 535;
    short LANG_MOVEGENS_HOME_PLAYER             = 536;
    short LANG_MOVEGENS_FLIGHT                  = 537;
    short LANG_MOVEGENS_UNKNOWN                 = 538;

    short LANG_NPCINFO_CHAR                     = 539;
    short LANG_NPCINFO_LEVEL                    = 540;
    short LANG_NPCINFO_HEALTH                   = 541;
    short LANG_NPCINFO_DYNAMIC_FLAGS            = 542;
    short LANG_NPCINFO_LOOT                     = 543;
    short LANG_NPCINFO_POSITION                 = 544;
    short LANG_NPCINFO_VENDOR                   = 545;
    short LANG_NPCINFO_TRAINER                  = 546;
    short LANG_NPCINFO_DUNGEON_ID               = 547;

    //                                    = 548; see short LANG_PINFO_GM_ACTIVE
    //                                    = 549; see short LANG_PINFO_BANNED
    //                                    = 550; see short LANG_PINFO_MUTED

    short LANG_YOU_SET_EXPLORE_ALL              = 551;
    short LANG_YOU_SET_EXPLORE_NOTHING          = 552;
    short LANG_YOURS_EXPLORE_SET_ALL            = 553;
    short LANG_YOURS_EXPLORE_SET_NOTHING        = 554;

    short LANG_NPC_SETDATA                      = 555;

    //! Old ones now free:
    short LANG_COMMAND_NEAR_NPC_MESSAGE         = 556;

    short LANG_YOURS_LEVEL_UP                   = 557;
    short LANG_YOURS_LEVEL_DOWN                 = 558;
    short LANG_YOURS_LEVEL_PROGRESS_RESET       = 559;
    short LANG_EXPLORE_AREA                     = 560;
    short LANG_UNEXPLORE_AREA                   = 561;

    short LANG_UPDATE                           = 562;
    short LANG_UPDATE_CHANGE                    = 563;
    short LANG_TOO_BIG_INDEX                    = 564;
    short LANG_SET_UINT                         = 565;              //log
    short LANG_SET_UINT_FIELD                   = 566;
    short LANG_SET_FLOAT                        = 567;              //log
    short LANG_SET_FLOAT_FIELD                  = 568;
    short LANG_GET_UINT                         = 569;              //log
    short LANG_GET_UINT_FIELD                   = 570;
    short LANG_GET_FLOAT                        = 571;              //log
    short LANG_GET_FLOAT_FIELD                  = 572;
    short LANG_SET_32BIT                        = 573;              //log
    short LANG_SET_32BIT_FIELD                  = 574;
    short LANG_CHANGE_32BIT                     = 575;              //log
    short LANG_CHANGE_32BIT_FIELD               = 576;

    short LANG_INVISIBLE_INVISIBLE              = 577;
    short LANG_INVISIBLE_VISIBLE                = 578;
    short LANG_SELECTED_TARGET_NOT_HAVE_VICTIM  = 579;

    short LANG_COMMAND_LEARN_ALL_DEFAULT_AND_QUEST = 580;
    short LANG_COMMAND_NEAROBJMESSAGE           = 581;
    short LANG_COMMAND_RAWPAWNTIMES             = 582;

    short LANG_EVENT_ENTRY_LIST_CHAT            = 583;
    short LANG_NOEVENTFOUND                     = 584;
    short LANG_EVENT_NOT_EXIST                  = 585;
    short LANG_EVENT_INFO                       = 586;
    short LANG_EVENT_ALREADY_ACTIVE             = 587;
    short LANG_EVENT_NOT_ACTIVE                 = 588;

    short LANG_MOVEGENS_POINT                   = 589;
    short LANG_MOVEGENS_FEAR                    = 590;
    short LANG_MOVEGENS_DISTRACT                = 591;

    short LANG_COMMAND_LEARN_ALL_RECIPES        = 592;
    short LANG_BANLIST_ACCOUNTS                 = 593;
    short LANG_BANLIST_ACCOUNTS_HEADER          = 594;
    short LANG_BANLIST_IPS                      = 595;
    short LANG_BANLIST_IPS_HEADER               = 596;
    short LANG_GMLIST                           = 597;
    short LANG_GMLIST_HEADER                    = 598;
    short LANG_GMLIST_EMPTY                     = 599;

    short LANG_REMOVEITEM_FAILURE               = 600;

    // End Level 3 list; continued at 1100

    // 601-704 - free

    short LANG_WAIT_BEFORE_SPEAKING             = 705;
    short LANG_NOT_EQUIPPED_ITEM                = 706;
    short LANG_PLAYER_DND                       = 707;
    short LANG_PLAYER_AFK                       = 708;
    short LANG_PLAYER_DND_DEFAULT               = 709;
    short LANG_PLAYER_AFK_DEFAULT               = 710;

    short LANG_BG_QUEUE_ANNOUNCE_SELF           = 711;
    short LANG_BG_QUEUE_ANNOUNCE_WORLD          = 712;
    short LANG_YOUR_ARENA_LEVEL_REQ_ERROR       = 713;
//                                        = 714; see short LANG_PINFO_ACC_ACCOUNT
    short LANG_YOUR_BG_LEVEL_REQ_ERROR          = 715;
//                                        = 716; see short LANG_PINFO_ACC_LASTLOGIN
    short LANG_BG_STARTED_ANNOUNCE_WORLD        = 717;
    short LANG_ARENA_QUEUE_ANNOUNCE_WORLD_JOIN  = 718;
    short LANG_ARENA_QUEUE_ANNOUNCE_WORLD_EXIT  = 719;

    short LANG_BG_GROUP_TOO_LARGE               = 720;              // "Your group is too large for this battleground. Please regroup to join."
    short LANG_ARENA_GROUP_TOO_LARGE            = 721;              // "Your group is too large for this arena. Please regroup to join."
    short LANG_ARENA_YOUR_TEAM_ONLY             = 722;              // "Your group has members not in your arena team. Please regroup to join."
    short LANG_ARENA_NOT_ENOUGH_PLAYERS         = 723;              // "Your group does not have enough players to join this match."
    //                                      724-726 - free
    short LANG_BG_GROUP_OFFLINE_MEMBER          = 727;              // "Your group has an offline member. Please remove him before joining."
    short LANG_BG_GROUP_MIXED_FACTION           = 728;              // "Your group has players from the opposing faction. You can't join the battleground as a group."
    short LANG_BG_GROUP_MIXED_LEVELS            = 729;              // "Your group has players from different battleground brakets. You can't join as group."
    short LANG_BG_GROUP_MEMBER_ALREADY_IN_QUEUE = 730;            // "Someone in your party is already in this battleground queue. (S)he must leave it before joining as group."
    short LANG_BG_GROUP_MEMBER_DESERTER         = 731;              // "Someone in your party is Deserter. You can't join as group."
    short LANG_BG_GROUP_MEMBER_NO_FREE_QUEUE_SLOTS = 732;         // "Someone in your party is already in three battleground queues. You cannot join as group."

    short LANG_CANNOT_TELE_TO_BG                = 733;              // "You cannot teleport to a battleground or arena map."
    short LANG_CANNOT_SUMMON_TO_BG              = 734;              // "You cannot summon players to a battleground or arena map."
    short LANG_CANNOT_GO_TO_BG_GM               = 735;              // "You must be in GM mode to teleport to a player in a battleground."
    short LANG_CANNOT_GO_TO_BG_FROM_BG          = 736;              // "You cannot teleport to a battleground from another battleground. Please leave the current battleground first."
    short LANG_DEBUG_ARENA_ON                   = 737;
    short LANG_DEBUG_ARENA_OFF                  = 738;
    short LANG_DEBUG_BG_ON                      = 739;
    short LANG_DEBUG_BG_OFF                     = 740;
    short LANG_DIST_ARENA_POINTS_START          = 741; // 3.3.5 RESERVED
    short LANG_DIST_ARENA_POINTS_ONLINE_START   = 742; // 3.3.5 RESERVED
    short LANG_DIST_ARENA_POINTS_ONLINE_END     = 743; // 3.3.5 RESERVED
    short LANG_DIST_ARENA_POINTS_TEAM_START     = 744; // 3.3.5 RESERVED
    short LANG_DIST_ARENA_POINTS_TEAM_END       = 745; // 3.3.5 RESERVED
    short LANG_DIST_ARENA_POINTS_END            = 746; // 3.3.5 RESERVED
    short LANG_BG_DISABLED                      = 747;
    short LANG_ARENA_DISABLED                   = 748;
//                                        = 749; see short LANG_PINFO_ACC_OS
    short LANG_BATTLEGROUND_PREMATURE_FINISH_WARNING = 750;       // "Not enough players. This game will close in %u mins."
    short LANG_BATTLEGROUND_PREMATURE_FINISH_WARNING_SECS = 751;  // "Not enough players. This game will close in %u seconds."
//                                        = 752; see short LANG_PINFO_ACC_IP
    // 753-755 - free

    // Room for BG/ARENA                  = 773-784
    short LANG_ARENA_TESTING                    = 785;
    short LANG_AUTO_ANN                         = 786;
    short LANG_ANNOUNCE_COLOR                   = 787;
    // 788-799 - free

    // in game strings
    short LANG_PET_INVALID_NAME                 = 800;
    short LANG_NOT_ENOUGH_GOLD                  = 801;
    short LANG_NOT_FREE_TRADE_SLOTS             = 802;
    short LANG_NOT_PARTNER_FREE_TRADE_SLOTS     = 803;
    short LANG_YOU_NOT_HAVE_PERMISSION          = 804;
    short LANG_UNKNOWN_LANGUAGE                 = 805;
    short LANG_NOT_LEARNED_LANGUAGE             = 806;
    short LANG_NEED_CHARACTER_NAME              = 807;
    short LANG_PLAYER_NOT_EXIST_OR_OFFLINE      = 808;
    short LANG_ACCOUNT_FOR_PLAYER_NOT_FOUND     = 809;
    // unused                             = 810;
    short LANG_GUILD_MASTER                     = 811;
    short LANG_GUILD_OFFICER                    = 812;
    short LANG_GUILD_VETERAN                    = 813;
    short LANG_GUILD_MEMBER                     = 814;
    short LANG_GUILD_INITIATE                   = 815;
    short LANG_ZONE_NOFLYZONE                   = 816;

    short LANG_COMMAND_CREATURETEMPLATE_NOTFOUND = 817;
    short LANG_COMMAND_CREATURESTORAGE_NOTFOUND  = 818;

    short LANG_CHANNEL_CITY                     = 819;

    // Pinfo commands
    short LANG_PINFO_PLAYER                     = 453;
    short LANG_PINFO_GM_ACTIVE                  = 548;
    short LANG_PINFO_BANNED                     = 549;
    short LANG_PINFO_MUTED                      = 550;
    short LANG_PINFO_ACC_ACCOUNT                = 714;
    short LANG_PINFO_ACC_LASTLOGIN              = 716;
    short LANG_PINFO_ACC_OS                     = 749;
    short LANG_PINFO_ACC_REGMAILS               = 879;
    short LANG_PINFO_ACC_IP                     = 752;
    short LANG_PINFO_CHR_LEVEL_LOW              = 843;
    short LANG_PINFO_CHR_RACE                   = 844;
    short LANG_PINFO_CHR_ALIVE                  = 845;
    short LANG_PINFO_CHR_PHASES                 = 846;
    short LANG_PINFO_CHR_MONEY                  = 847;
    short LANG_PINFO_CHR_MAP                    = 848;
    short LANG_PINFO_CHR_GUILD                  = 849;
    short LANG_PINFO_CHR_GUILD_RANK             = 850;
    short LANG_PINFO_CHR_GUILD_NOTE             = 851;
    short LANG_PINFO_CHR_GUILD_ONOTE            = 852;
    short LANG_PINFO_CHR_PLAYEDTIME             = 853;
    short LANG_PINFO_CHR_MAILS                  = 854;
    short LANG_PINFO_CHR_LEVEL_HIGH             = 871;
    short LANG_PINFO_CHR_MAP_WITH_AREA          = 882;

    short LANG_CHARACTER_GENDER_MALE            = 855;
    short LANG_CHARACTER_GENDER_FEMALE          = 856;

    short LANG_ARENA_ERROR_NOT_FOUND            = 857;
    short LANG_ARENA_ERROR_NAME_EXISTS          = 858;
    short LANG_ARENA_ERROR_SIZE                 = 859;
    short LANG_ARENA_ERROR_COMBAT               = 860;
    short LANG_ARENA_ERROR_NAME_NOT_FOUND       = 861;
    short LANG_ARENA_ERROR_NOT_MEMBER           = 862;
    short LANG_ARENA_ERROR_CAPTAIN              = 863;
    short LANG_ARENA_CREATE                     = 864;
    short LANG_ARENA_DISBAND                    = 865;
    short LANG_ARENA_RENAME                     = 866;
    short LANG_ARENA_CAPTAIN                    = 867;
    short LANG_ARENA_INFO_HEADER                = 868;
    short LANG_ARENA_INFO_MEMBERS               = 869;
    short LANG_ARENA_LOOKUP                     = 870;
    //                                    = 871; see short LANG_PINFO_CHR_LEVEL_HIGH
    short LANG_COMMAND_WRONGEMAIL               = 872;
    short LANG_NEW_EMAILS_NOT_MATCH             = 873;
    short LANG_COMMAND_EMAIL                    = 874;
    short LANG_EMAIL_TOO_LONG                   = 875;
    short LANG_COMMAND_NOTCHANGEEMAIL           = 876;
    short LANG_OLD_EMAIL_IS_NEW_EMAIL           = 877;
    short LANG_COMMAND_EMAIL_OUTPUT             = 878;
    //                                    = 879; see short LANG_PINFO_CHR_REGMAILS
    short LANG_ACCOUNT_SEC_TYPE                 = 880;
    short LANG_RBAC_EMAIL_REQUIRED              = 881;
    //                                    = 882; short LANG_PINFO_CHR_MAP_WITH_AREA
    short LANG_ACCOUNT                          = 883;
    short LANG_COMMAND_QUEST_OBJECTIVE_NOTFOUND = 884;
    // Room for in-game strings             885-999 not used

    // Level 4 (CLI only commands)
    short LANG_COMMAND_EXIT                     = 1000;
    short LANG_ACCOUNT_DELETED                  = 1001;
    short LANG_ACCOUNT_NOT_DELETED_SQL_ERROR    = 1002;
    short LANG_ACCOUNT_NOT_DELETED              = 1003;
    short LANG_ACCOUNT_CREATED                  = 1004;
    short LANG_ACCOUNT_NAME_TOO_LONG            = 1005;
    short LANG_ACCOUNT_ALREADY_EXIST            = 1006;
    short LANG_ACCOUNT_NOT_CREATED_SQL_ERROR    = 1007;
    short LANG_ACCOUNT_NOT_CREATED              = 1008;
    short LANG_CHARACTER_DELETED                = 1009;
    short LANG_ACCOUNT_LIST_HEADER              = 1010;
    short LANG_ACCOUNT_LIST_ERROR               = 1011;
    short LANG_ACCOUNT_LIST_BAR                 = 1012;
    short LANG_ACCOUNT_LIST_LINE                = 1013;
    short LANG_ACCOUNT_LIST_EMPTY               = 1014;
    short LANG_ACCOUNT_LIST_BAR_HEADER          = 1015;
    short LANG_CHARACTER_DELETED_LIST_HEADER    = 1016;
    short LANG_CHARACTER_DELETED_LIST_LINE_CONSOLE = 1017;
    short LANG_CHARACTER_DELETED_LIST_BAR       = 1018;
    short LANG_CHARACTER_DELETED_LIST_EMPTY     = 1019;
    short LANG_CHARACTER_DELETED_RESTORE        = 1020;
    short LANG_CHARACTER_DELETED_DELETE         = 1021;
    short LANG_CHARACTER_DELETED_ERR_RENAME     = 1022;
    short LANG_CHARACTER_DELETED_SKIP_ACCOUNT   = 1023;
    short LANG_CHARACTER_DELETED_SKIP_FULL      = 1024;
    short LANG_CHARACTER_DELETED_SKIP_NAME      = 1025;
    short LANG_CHARACTER_DELETED_LIST_LINE_CHAT = 1026;
    short LANG_SQLDRIVER_QUERY_LOGGING_ENABLED  = 1027;
    short LANG_SQLDRIVER_QUERY_LOGGING_DISABLED = 1028;
    short LANG_ACCOUNT_INVALID_BNET_NAME        = 1029;
    short LANG_ACCOUNT_USE_BNET_COMMANDS        = 1030;
    short LANG_ACCOUNT_PASS_TOO_LONG            = 1031;
    short LANG_ACCOUNT_CREATED_BNET_WITH_GAME   = 1032;
    short LANG_ACCOUNT_CREATED_BNET             = 1033;
    short LANG_ACCOUNT_BNET_LIST_HEADER         = 1034;
    short LANG_ACCOUNT_BNET_LIST_NO_ACCOUNTS    = 1035;
    // Room for more level 4                1036-1099 not used

    // Level 3 (continue)
    short LANG_ACCOUNT_SETADDON                 = 1100;
    short LANG_MOTD_NEW                         = 1101;
    short LANG_SENDMESSAGE                      = 1102;
    short LANG_EVENT_ENTRY_LIST_CONSOLE         = 1103;
    short LANG_CREATURE_ENTRY_LIST_CONSOLE      = 1104;
    short LANG_ITEM_LIST_CONSOLE                = 1105;
    short LANG_ITEMSET_LIST_CONSOLE             = 1106;
    short LANG_GO_ENTRY_LIST_CONSOLE            = 1107;
    short LANG_QUEST_LIST_CONSOLE               = 1108;
    short LANG_SKILL_LIST_CONSOLE               = 1109;
    short LANG_CREATURE_LIST_CONSOLE            = 1110;
    short LANG_GO_LIST_CONSOLE                  = 1111;
    short LANG_FILE_OPEN_FAIL                   = 1112;
    short LANG_ACCOUNT_CHARACTER_LIST_FULL      = 1113;
    short LANG_DUMP_BROKEN                      = 1114;
    short LANG_INVALID_CHARACTER_NAME           = 1115;
    short LANG_INVALID_CHARACTER_GUID           = 1116;
    short LANG_CHARACTER_GUID_IN_USE            = 1117;
    short LANG_ITEMLIST_GUILD                   = 1118;
    short LANG_MUST_MALE_OR_FEMALE              = 1119;
    short LANG_YOU_CHANGE_GENDER                = 1120;
    short LANG_YOUR_GENDER_CHANGED              = 1121;
    short LANG_SKILL_VALUES                     = 1122;
    short LANG_NO_PET_FOUND                     = 1123;
    short LANG_WRONG_PET_TYPE                   = 1124;
    short LANG_COMMAND_LEARN_PET_TALENTS        = 1125;
    short LANG_RESET_PET_TALENTS                = 1126;
    short LANG_RESET_PET_TALENTS_ONLINE         = 1127;
    short LANG_TAXINODE_ENTRY_LIST_CHAT         = 1128;
    short LANG_TAXINODE_ENTRY_LIST_CONSOLE      = 1129;
    short LANG_COMMAND_EXPORT_DELETED_CHAR      = 1130;
    short LANG_BANLIST_MATCHINGCHARACTER        = 1131;
    short LANG_BANLIST_CHARACTERS               = 1132;
    short LANG_BANLIST_CHARACTERS_HEADER        = 1133;
    short LANG_ALLOW_TICKETS                    = 1134;
    short LANG_DISALLOW_TICKETS                 = 1135;
    short LANG_CHAR_NOT_BANNED                  = 1136;
    short LANG_DEV_ON                           = 1137;
    short LANG_DEV_OFF                          = 1138;
    short LANG_MOVEGENS_FOLLOW_PLAYER           = 1139;
    short LANG_MOVEGENS_FOLLOW_CREATURE         = 1140;
    short LANG_MOVEGENS_FOLLOW_NULL             = 1141;
    short LANG_MOVEGENS_EFFECT                  = 1142;
    short LANG_MOVEFLAGS_GET                    = 1143;
    short LANG_MOVEFLAGS_SET                    = 1144;
    short LANG_GROUP_ALREADY_IN_GROUP           = 1145;
    short LANG_GROUP_PLAYER_JOINED              = 1146;
    short LANG_GROUP_NOT_IN_GROUP               = 1147;
    short LANG_GROUP_FULL                       = 1148;
    short LANG_GROUP_TYPE                       = 1149;
    short LANG_GROUP_PLAYER_NAME_GUID           = 1150;
    short LANG_LIST_MAIL_HEADER                 = 1151;
    short LANG_LIST_MAIL_INFO_1                 = 1152;
    short LANG_LIST_MAIL_INFO_2                 = 1153;
    short LANG_LIST_MAIL_INFO_3                 = 1154;
    short LANG_LIST_MAIL_INFO_ITEM              = 1155;
    short LANG_LIST_MAIL_NOT_FOUND              = 1156;
    short LANG_AHBOT_RELOAD_OK                  = 1157;
    short LANG_AHBOT_STATUS_BAR_CONSOLE         = 1158;
    short LANG_AHBOT_STATUS_MIDBAR_CONSOLE      = 1159;
    short LANG_AHBOT_STATUS_TITLE1_CONSOLE      = 1160;
    short LANG_AHBOT_STATUS_TITLE1_CHAT         = 1161;
    short LANG_AHBOT_STATUS_FORMAT_CONSOLE      = 1162;
    short LANG_AHBOT_STATUS_FORMAT_CHAT         = 1163;
    short LANG_AHBOT_STATUS_ITEM_COUNT          = 1164;
    short LANG_AHBOT_STATUS_ITEM_RATIO          = 1165;
    short LANG_AHBOT_STATUS_TITLE2_CONSOLE      = 1166;
    short LANG_AHBOT_STATUS_TITLE2_CHAT         = 1167;
    short LANG_AHBOT_QUALITY_GRAY               = 1168;
    short LANG_AHBOT_QUALITY_WHITE              = 1169;
    short LANG_AHBOT_QUALITY_GREEN              = 1170;
    short LANG_AHBOT_QUALITY_BLUE               = 1171;
    short LANG_AHBOT_QUALITY_PURPLE             = 1172;
    short LANG_AHBOT_QUALITY_ORANGE             = 1173;
    short LANG_AHBOT_QUALITY_YELLOW             = 1174;
    short LANG_AHBOT_ITEMS_AMOUNT               = 1175;
    short LANG_AHBOT_ITEMS_RATIO                = 1176;
    short LANG_GUILD_INFO_NAME                  = 1177;
    short LANG_GUILD_INFO_GUILD_MASTER          = 1178;
    short LANG_GUILD_INFO_CREATION_DATE         = 1179;
    short LANG_GUILD_INFO_MEMBER_COUNT          = 1180;
    short LANG_GUILD_INFO_BANK_GOLD             = 1181;
    short LANG_GUILD_INFO_MOTD                  = 1182;
    short LANG_GUILD_INFO_EXTRA_INFO            = 1183;
    short LANG_CHANGEACCOUNT_SUCCESS            = 1184;             // log
    short LANG_GROUP_NOT_IN_RAID_GROUP          = 1185;
    short LANG_GROUP_ROLE_CHANGED               = 1186;
    short LANG_LEADER_CANNOT_BE_ASSISTANT       = 1187;
    short LANG_BAN_EXISTS                       = 1188;
    short LANG_COMMAND_NO_INSTANCES_MATCH       = 1189;
    short LANG_COMMAND_MULTIPLE_INSTANCES_MATCH = 1190;
    short LANG_COMMAND_MULTIPLE_INSTANCES_ENTRY = 1191;
    //                                      1192 unused
    short LANG_COMMAND_INSTANCE_NO_ENTRANCE     = 1193;
    short LANG_COMMAND_INSTANCE_NO_EXIT         = 1194;
    short LANG_COMMAND_WENT_TO_INSTANCE_GATE    = 1195;
    short LANG_COMMAND_WENT_TO_INSTANCE_START   = 1196;
    short LANG_COMMAND_GO_INSTANCE_GATE_FAILED  = 1197;
    short LANG_COMMAND_GO_INSTANCE_START_FAILED = 1198;
    // Room for more level 3                1199 not used

    // Debug commands
    short LANG_CINEMATIC_NOT_EXIST              = 1200;
    short LANG_MOVIE_NOT_EXIST                  = 1201;
    short LANG_DEBUG_AREATRIGGER_ON             = 1202;
    short LANG_DEBUG_AREATRIGGER_OFF            = 1203;
    short LANG_DEBUG_AREATRIGGER_ENTERED        = 1204;

    short LANG_COMMAND_NO_BOSSES_MATCH          = 1205;
    short LANG_COMMAND_MULTIPLE_BOSSES_MATCH    = 1206;
    short LANG_COMMAND_MULTIPLE_BOSSES_ENTRY    = 1207;
    short LANG_COMMAND_BOSS_MULTIPLE_SPAWNS     = 1208;
    short LANG_COMMAND_BOSS_MULTIPLE_SPAWN_ETY  = 1209;
    short LANG_COMMAND_GO_BOSS_FAILED           = 1210;
    short LANG_COMMAND_WENT_TO_BOSS             = 1211;
    short LANG_GUILD_INFO_LEVEL                 = 1212;
    short LANG_ACCOUNT_BNET_LINKED              = 1213;
    short LANG_ACCOUNT_OR_BNET_DOES_NOT_EXIST   = 1214;
    short LANG_ACCOUNT_ALREADY_LINKED           = 1215;
    short LANG_ACCOUNT_BNET_UNLINKED            = 1216;
    short LANG_ACCOUNT_BNET_NOT_LINKED          = 1217;
    short LANG_DISALLOW_TICKETS_CONFIG          = 1218;
    // 1219-1499 - free

    // Command argument parsers
    short LANG_CMDPARSER_EITHER                 = 1500;
    short LANG_CMDPARSER_OR                     = 1501;
    short LANG_CMDPARSER_STRING_VALUE_INVALID   = 1502;
    short LANG_CMDPARSER_INVALID_UTF8           = 1503;
    short LANG_CMDPARSER_LINKDATA_INVALID       = 1504;
    short LANG_CMDPARSER_ACCOUNT_NAME_NO_EXIST  = 1505;
    short LANG_CMDPARSER_ACCOUNT_ID_NO_EXIST    = 1506;
    short LANG_CMDPARSER_CHAR_GUID_NO_EXIST     = 1507;
    short LANG_CMDPARSER_CHAR_NAME_NO_EXIST     = 1508;
    short LANG_CMDPARSER_CHAR_NAME_INVALID      = 1509;
    short LANG_CMDPARSER_ACHIEVEMENT_NO_EXIST   = 1510;
    short LANG_CMDPARSER_GAME_TELE_ID_NO_EXIST  = 1511;
    short LANG_CMDPARSER_GAME_TELE_NO_EXIST     = 1512;
    short LANG_CMDPARSER_ITEM_NO_EXIST          = 1513;
    short LANG_CMDPARSER_SPELL_NO_EXIST         = 1514;
    short LANG_CMDPARSER_EXACT_SEQ_MISMATCH     = 1515;
    short LANG_CMDPARSER_CURRENCY_NO_EXIST      = 1516;
    short LANG_CMDPARSER_QUEST_NO_EXIST         = 1517;

    // 1516-1996 - free
    short LANG_DEBUG_AREATRIGGER_ENTITY_ENTERED = 1997;
    short LANG_DEBUG_AREATRIGGER_ENTITY_LEFT    = 1998;
    short LANG_DEBUG_AREATRIGGER_LEFT           = 1999;
    // Ticket Strings 2000-2030
    short LANG_COMMAND_TICKETNEW                = 2000; // 3.3.5 RESERVED
    short LANG_COMMAND_TICKETUPDATED            = 2001; // 3.3.5 RESERVED
    short LANG_COMMAND_TICKETPLAYERABANDON      = 2002; // 3.3.5 RESERVED
    short LANG_COMMAND_TICKETCLOSED             = 2003;
    short LANG_COMMAND_TICKETDELETED            = 2004;
    short LANG_COMMAND_TICKETNOTEXIST           = 2005;
    short LANG_COMMAND_TICKETCLOSEFIRST         = 2006;
    short LANG_COMMAND_TICKETALREADYASSIGNED    = 2007;
    short LANG_COMMAND_TICKETRELOAD             = 2008; // 3.3.5 RESERVED
    short LANG_COMMAND_TICKETSHOWLIST           = 2009;
    short LANG_COMMAND_TICKETSHOWONLINELIST     = 2010; // 3.3.5 RESERVED
    short LANG_COMMAND_TICKETSHOWCLOSEDLIST     = 2011;
    short LANG_COMMAND_TICKETASSIGNERROR_A      = 2012;
    short LANG_COMMAND_TICKETASSIGNERROR_B      = 2013;
    short LANG_COMMAND_TICKETNOTASSIGNED        = 2014;
    short LANG_COMMAND_TICKETUNASSIGNSECURITY   = 2015;
    short LANG_COMMAND_TICKETCANNOTCLOSE        = 2016;
    short LANG_COMMAND_TICKETLISTGUID           = 2017;
    short LANG_COMMAND_TICKETLISTNAME           = 2018;
    short LANG_COMMAND_TICKETLISTAGE            = 2019; // 3.3.5 RESERVED
    short LANG_COMMAND_TICKETLISTASSIGNEDTO     = 2020;
    short LANG_COMMAND_TICKETLISTUNASSIGNED     = 2021;
    short LANG_COMMAND_TICKETLISTMESSAGE        = 2022;
    short LANG_COMMAND_TICKETLISTCOMMENT        = 2023;
    short LANG_COMMAND_TICKETLISTADDCOMMENT     = 2024;
    short LANG_COMMAND_TICKETLISTAGECREATE      = 2025;
    short LANG_COMMAND_TICKETSHOWESCALATEDLIST  = 2026; // 3.3.5 RESERVED
    short LANG_COMMAND_TICKETPENDING            = 2027;
    short LANG_COMMAND_TICKETRESET              = 2028;
    short LANG_COMMAND_TICKETLISTRESPONSE       = 2029; // 3.3.5 RESERVED
    short LANG_COMMAND_TICKETCOMPLETED          = 2030; // 3.3.5 RESERVED

    // Trinity strings                      5000-9999
    short LANG_COMMAND_FREEZE                   = 5000;
    short LANG_COMMAND_FREEZE_ERROR             = 5001;
    short LANG_COMMAND_FREEZE_WRONG             = 5002;
    short LANG_COMMAND_UNFREEZE                 = 5003;
    short LANG_COMMAND_NO_FROZEN_PLAYERS        = 5004;
    short LANG_COMMAND_LIST_FREEZE              = 5005;
    short LANG_COMMAND_PERMA_FROZEN_PLAYER      = 5006;
    short LANG_PHASE_NOTFOUND                   = 5007;
    short LANG_INSTANCE_CLOSED                  = 5008;
    short LANG_COMMAND_PLAYED_TO_ALL            = 5009;
    short LANG_NPCINFO_LINKGUID                 = 5010;
    short LANG_TELEPORTED_TO_BY_CONSOLE         = 5011;
    // for command lookup map
    short LANG_COMMAND_NOMAPFOUND               = 5012;
    short LANG_CONTINENT                        = 5013;
    short LANG_INSTANCE                         = 5014;
    short LANG_BATTLEGROUND                     = 5015;
    short LANG_ARENA                            = 5016;
    short LANG_RAID                             = 5017;
    short LANG_NPCINFO_REACTSTATE               = 5018;
    short LANG_COMMAND_TEMP_FROZEN_PLAYER       = 5019;
    short LANG_NPCINFO_PHASES                   = 5020;
    short LANG_NPCINFO_ARMOR                    = 5021;
    short LANG_CHANNEL_ENABLE_OWNERSHIP         = 5022;
    short LANG_CHANNEL_DISABLE_OWNERSHIP        = 5023;
    short LANG_GOINFO_ENTRY                     = 5024;
    short LANG_GOINFO_TYPE                      = 5025;
    short LANG_GOINFO_DISPLAYID                 = 5026;
    short LANG_GOINFO_NAME                      = 5027;
    short LANG_GOINFO_LOOTID                    = 5028;
    short LANG_COMMAND_LOOKUP_MAX_RESULTS       = 5029;
    short LANG_UNAUTHORIZED                     = 5030;
    short LANG_OBJECTINFO_AIINFO                = 5031;
    short LANG_COMMAND_NO_BATTLEGROUND_FOUND    = 5032;
    short LANG_COMMAND_NO_ACHIEVEMENT_CRITERIA_FOUND = 5033;
    short LANG_COMMAND_NO_OUTDOOR_PVP_FORUND    = 5034;
    short LANG_NO_REASON                        = 5035;
    short LANG_NPCINFO_EQUIPMENT                = 5036;
    short LANG_NPCINFO_MECHANIC_IMMUNE          = 5037;
    short LANG_NPCINFO_UNIT_FIELD_FLAGS         = 5038;
    short LANG_CONSOLE                          = 5039;
    short LANG_CHARACTER                        = 5040;
    short LANG_PERMANENTLY                      = 5041;
    short LANG_GPS_POSITION_OUTDOORS            = 5042;
    short LANG_GPS_POSITION_INDOORS             = 5043;
    short LANG_GPS_NO_VMAP                      = 5044;

    // Instance commands
    short LANG_COMMAND_LIST_BIND_INFO           = 5045;
    short LANG_COMMAND_LIST_BIND_PLAYER_BINDS   = 5046;
    short LANG_COMMAND_INST_UNBIND_FAILED       = 5047;
    short LANG_COMMAND_INST_UNBIND_UNBINDING    = 5048;
    short LANG_COMMAND_INST_UNBIND_UNBOUND      = 5049;
    short LANG_COMMAND_INST_STAT_LOADED_INST    = 5050;
    short LANG_COMMAND_INST_STAT_PLAYERS_IN     = 5051;
    short LANG_COMMAND_INST_STAT_SAVES          = 5052;
    short LANG_COMMAND_INST_STAT_PLAYERSBOUND   = 5053;
    //                                    = 5054; // old short LANG_COMMAND_INST_STAT_GROUPSBOUND
    short LANG_NOT_DUNGEON                      = 5055; // Map is not a dungeon.
    short LANG_NO_INSTANCE_DATA                 = 5056; // Map has no instance data.
    short LANG_COMMAND_INST_SET_BOSS_STATE      = 5057;
    short LANG_COMMAND_INST_GET_BOSS_STATE      = 5058;

    // Mutehistory commands
    short LANG_COMMAND_MUTEHISTORY              = 5059;
    short LANG_COMMAND_MUTEHISTORY_EMPTY        = 5060;
    short LANG_COMMAND_MUTEHISTORY_OUTPUT       = 5061;

    // Scene debugs commands
    short LANG_COMMAND_SCENE_DEBUG_ON           = 5062;
    short LANG_COMMAND_SCENE_DEBUG_OFF          = 5063;
    short LANG_COMMAND_SCENE_DEBUG_PLAY         = 5064;
    short LANG_COMMAND_SCENE_DEBUG_TRIGGER      = 5065;
    short LANG_COMMAND_SCENE_DEBUG_CANCEL       = 5066;
    short LANG_COMMAND_SCENE_DEBUG_COMPLETE     = 5067;
    short LANG_DEBUG_SCENE_OBJECT_LIST          = 5068;
    short LANG_DEBUG_SCENE_OBJECT_DETAIL        = 5069;

    // Strings added for dynamic_spawning
    short LANG_SPAWNINFO_GROUP_ID               = 5070;
    short LANG_SPAWNINFO_COMPATIBILITY_MODE     = 5071;
    short LANG_SPAWNINFO_GUIDINFO               = 5072;
    short LANG_SPAWNINFO_SPAWNID_LOCATION       = 5073;
    short LANG_SPAWNINFO_ROTATION               = 5074;
    short LANG_SPAWNGROUP_BADGROUP              = 5075;
    short LANG_SPAWNGROUP_SPAWNCOUNT            = 5076;
    short LANG_LIST_RESPAWNS_RANGE              = 5077;
    short LANG_LIST_RESPAWNS_ZONE               = 5078;
    short LANG_LIST_RESPAWNS_LISTHEADER         = 5079;
    short LANG_LIST_RESPAWNS_OVERDUE            = 5080;
    // unused 5081
    // unused 5082
    short LANG_OBJECTINFO_AITYPE                = 5083;
    short LANG_NPCINFO_UNIT_FIELD_FLAGS_2       = 5084;
    short LANG_NPCINFO_UNIT_FIELD_FLAGS_3       = 5085;
    short LANG_NPCINFO_NPC_FLAGS                = 5086;
    short LANG_NPCINFO_PHASE_IDS                = 5087;
    short LANG_SCENARIO                         = 5088;
    short LANG_OBJECTINFO_STRINGIDS             = 5089;

    // Room for more Trinity strings        5090-6603

    // Level requirement notifications
    short LANG_SAY_REQ                          = 6604;
    short LANG_WHISPER_REQ                      = 6605;
    short LANG_CHANNEL_REQ                      = 6606;
    short LANG_AUCTION_REQ                      = 6607;
    short LANG_TICKET_REQ                       = 6608;
    short LANG_TRADE_REQ                        = 6609;
    short LANG_TRADE_OTHER_REQ                  = 6610;
    short LANG_MAIL_SENDER_REQ                  = 6611;
    short LANG_MAIL_RECEIVER_REQ                = 6612;

    // Used for GM Announcements
    short LANG_GM_BROADCAST                     = 6613;
    short LANG_GM_NOTIFY                        = 6614;
    short LANG_GM_ANNOUNCE_COLOR                = 6615;

    short LANG_GM_SILENCE                       = 6616;  // "Silence is ON for %s" - Spell 1852

    short LANG_WORLD_CLOSED                     = 7523;
    short LANG_WORLD_OPENED                     = 7524;

    short LANG_LFG_PLAYER_INFO                  = 9980;
    short LANG_LFG_GROUP_INFO                   = 9981;
    short LANG_LFG_NOT_IN_GROUP                 = 9982;
    short LANG_LFG_CLEAN                        = 9983;
    short LANG_LFG_OPTIONS                      = 9984;
    short LANG_LFG_OPTIONS_CHANGED              = 9985;
    short LANG_LFG_STATE_NONE                   = 9986;
    short LANG_LFG_STATE_ROLECHECK              = 9987;
    short LANG_LFG_STATE_QUEUED                 = 9988;
    short LANG_LFG_STATE_PROPOSAL               = 9989;
    short LANG_LFG_STATE_BOOT                   = 9990;
    short LANG_LFG_STATE_DUNGEON                = 9991;
    short LANG_LFG_STATE_FINISHED_DUNGEON       = 9992;
    short LANG_LFG_STATE_RAIDBROWSER            = 9993;
    short LANG_LFG_ROLE_TANK                    = 9994;
    short LANG_LFG_ROLE_HEALER                  = 9995;
    short LANG_LFG_ROLE_DAMAGE                  = 9996;
    short LANG_LFG_ROLE_LEADER                  = 9997;
    short LANG_LFG_ROLE_NONE                    = 9998;
    short LANG_LFG_ERROR                        = 9999;

    // Use for not-in-official-sources patches
    //                                      10000-10999
    // opvp si
    short LANG_OPVP_SI_CAPTURE_H                = 10049;
    short LANG_OPVP_SI_CAPTURE_A                = 10050;
    // opvp gossips
    short LANG_OPVP_EP_FLIGHT_NPT               = 10051;
    short LANG_OPVP_EP_FLIGHT_EWT               = 10052;
    short LANG_OPVP_EP_FLIGHT_CGT               = 10053;
    short LANG_OPVP_ZM_GOSSIP_ALLIANCE          = 10054;
    short LANG_OPVP_ZM_GOSSIP_HORDE             = 10055;

    // 10056-10066 - free

    // Use for custom patches               11000-11999
    short LANG_AUTO_BROADCAST                   = 11000;
    short LANG_INVALID_REALMID                  = 11001;

    // Show Kick in world
    short LANG_COMMAND_KICKMESSAGE_WORLD        = 11002;

    // Show Mute in world
    short LANG_COMMAND_MUTEMESSAGE_WORLD        = 11003;

    // Show Ban in world
    short LANG_BAN_CHARACTER_YOUBANNEDMESSAGE_WORLD     = 11004;
    short LANG_BAN_CHARACTER_YOUPERMBANNEDMESSAGE_WORLD = 11005;
    short LANG_BAN_ACCOUNT_YOUBANNEDMESSAGE_WORLD       = 11006;
    short LANG_BAN_ACCOUNT_YOUPERMBANNEDMESSAGE_WORLD   = 11007;

    short LANG_NPCINFO_MOVEMENT_DATA                    = 11008;
    short LANG_NPCINFO_FLAGS_EXTRA                      = 11009;
    short LANG_INSTANCE_LOGIN_GAMEMASTER_EXCEPTION      = 11010;

    short LANG_CREATURE_NO_INTERIOR_POINT_FOUND         = 11011;
    short LANG_CREATURE_MOVEMENT_NOT_BOUNDED            = 11012;
    short LANG_CREATURE_MOVEMENT_MAYBE_UNBOUNDED        = 11013;
    short LANG_INSTANCE_BIND_MISMATCH                   = 11014;
    short LANG_CREATURE_NOT_AI_ENABLED                  = 11015;
    short LANG_SELECT_PLAYER_OR_PET                     = 11016;
    short LANG_SHUTDOWN_DELAYED                         = 11017;
    short LANG_SHUTDOWN_CANCELLED                       = 11018;
    short LANG_YOU_CHANGE_POWER                         = 11019;
    short LANG_YOUR_POWER_CHANGED                       = 11020;
    short LANG_INVALID_POWER_NAME                       = 11021;
}
