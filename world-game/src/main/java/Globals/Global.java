package Globals;

import com.github.mmo.game.account.AccountManager;
import com.github.mmo.game.account.BNetAccountManager;
import com.github.mmo.game.achievement.AchievementGlobalMgr;
import com.github.mmo.game.achievement.CriteriaManager;
import com.github.mmo.game.ai.SmartAIManager;
import com.github.mmo.game.arena.ArenaTeamManager;
import com.github.mmo.game.battlefield.BattleFieldManager;
import com.github.mmo.game.battleground.BattlegroundManager;
import com.github.mmo.game.blackmarket.BlackMarketManager;
import com.github.mmo.game.cache.CharacterCache;
import com.github.mmo.game.chat.LanguageManager;
import com.github.mmo.game.dungeonfinding.LFGManager;
import com.github.mmo.game.entity.player.PetitionManager;
import com.github.mmo.game.entity.player.SocialManager;
import com.github.mmo.game.garrison.GarrisonManager;
import com.github.mmo.game.globals.ObjectManager;
import com.github.mmo.game.group.GroupManager;
import com.github.mmo.game.loot.LootItemStorage;
import com.github.mmo.game.map.*;
import com.github.mmo.game.map.collision.VMapManager;
import com.github.mmo.game.pvp.OutdoorPvPManager;
import com.github.mmo.game.scenario.ScenarioManager;
import com.github.mmo.game.scripting.ScriptManager;
import com.github.mmo.game.service.WorldServiceManager;
import com.github.mmo.game.supportsystem.SupportManager;
import game.*;


public final class Global {
    //Main
    public static ObjectAccessor getObjAccessor() {
        return ObjectAccessor.getInstance();
    }

    public static ObjectManager getObjectMgr() {
        return ObjectManager.getInstance();
    }

    public static WorldManager getWorldMgr() {
        return WorldManager.getInstance();
    }

    public static RealmManager getRealmMgr() {
        return RealmManager.Instance;
    }

    public static WorldServiceManager getServiceMgr() {
        return WorldServiceManager.getInstance();
    }

    //Guild
    public static PetitionManager getPetitionMgr() {
        return PetitionManager.getInstance();
    }

    public static GuildManager getGuildMgr() {
        return GuildManager.getInstance();
    }

    //Social
    public static CalendarManager getCalendarMgr() {
        return CalendarManager.getInstance();
    }

    public static SocialManager getSocialMgr() {
        return SocialManager.getInstance();
    }

    public static WhoListStorageManager getWhoListStorageMgr() {
        return WhoListStorageManager.getInstance();
    }

    //Scripts
    public static ScriptManager getScriptMgr() {
        return ScriptManager.getInstance();
    }

    public static SmartAIManager getSmartAIMgr() {
        return SmartAIManager.getInstance();
    }

    //Groups
    public static GroupManager getGroupMgr() {
        return GroupManager.getInstance();
    }

    public static LFGManager getLFGMgr() {
        return LFGManager.getInstance();
    }

    public static ArenaTeamManager getArenaTeamMgr() {
        return ArenaTeamManager.getInstance();
    }

    //Maps System
    public static TerrainManager getTerrainMgr() {
        return TerrainManager.getInstance();
    }

    public static MapManager getMapMgr() {
        return MapManager.getInstance();
    }

    public static MMapManager getMMapMgr() {
        return MMapManager.getInstance();
    }

    public static VMapManager getVMapMgr() {
        return VMapManager.getInstance();
    }

    public static WaypointManager getWaypointMgr() {
        return WaypointManager.getInstance();
    }

    public static TransportManager getTransportMgr() {
        return TransportManager.getInstance();
    }

    public static InstanceLockManager getInstanceLockMgr() {
        return InstanceLockManager.getInstance();
    }

    public static ScenarioManager getScenarioMgr() {
        return ScenarioManager.getInstance();
    }

    //PVP
    public static BattlegroundManager getBattlegroundMgr() {
        return BattlegroundManager.getInstance();
    }

    public static OutdoorPvPManager getOutdoorPvPMgr() {
        return OutdoorPvPManager.getInstance();
    }

    public static BattleFieldManager getBattleFieldMgr() {
        return BattleFieldManager.getInstance();
    }

    //Account
    public static AccountManager getAccountMgr() {
        return AccountManager.getInstance();
    }

    public static BNetAccountManager getBNetAccountMgr() {
        return BNetAccountManager.getInstance();
    }

    //Garrison
    public static GarrisonManager getGarrisonMgr() {
        return GarrisonManager.getInstance();
    }

    //Achievement
    public static AchievementGlobalMgr getAchievementMgr() {
        return AchievementGlobalMgr.getInstance();
    }

    public static CriteriaManager getCriteriaMgr() {
        return CriteriaManager.getInstance();
    }

    //DataStorage
    public static AreaTriggerDataStorage getAreaTriggerDataStorage() {
        return getAreaTriggerDataStorage().Instance;
    }

    public static CharacterTemplateDataStorage getCharacterTemplateDataStorage() {
        return getCharacterTemplateDataStorage().Instance;
    }

    public static ConversationDataStorage getConversationDataStorage() {
        return getConversationDataStorage().Instance;
    }

    public static CharacterCache getCharacterCacheStorage() {
        return CharacterCache.getInstance();
    }

    public static LootItemStorage getLootItemStorage() {
        return getLootItemStorage().Instance;
    }

    //Misc
    public static ConditionManager getConditionMgr() {
        return ConditionManager.getInstance();
    }

    public static DB2Manager getDB2Mgr() {
        return DB2Manager.getInstance();
    }

    public static DisableManager getDisableMgr() {
        return DisableManager.getInstance();
    }

    public static PoolManager getPoolMgr() {
        return PoolManager.getInstance();
    }

    public static QuestPoolManager getQuestPoolMgr() {
        return QuestPoolManager.getInstance();
    }

    public static WeatherManager getWeatherMgr() {
        return WeatherManager.getInstance();
    }

    public static GameEventManager getGameEventMgr() {
        return GameEventManager.getInstance();
    }

    public static LanguageManager getLanguageMgr() {
        return LanguageManager.getInstance();
    }

    public static CreatureTextManager getCreatureTextMgr() {
        return CreatureTextManager.getInstance();
    }

    public static AuctionManager getAuctionHouseMgr() {
        return AuctionManager.getInstance();
    }

    public static SpellManager getSpellMgr() {
        return SpellManager.getInstance();
    }

    public static SupportManager getSupportMgr() {
        return SupportManager.getInstance();
    }

    public static WardenCheckManager getWardenCheckMgr() {
        return WardenCheckManager.getInstance();
    }

    public static BlackMarketManager getBlackMarketMgr() {
        return BlackMarketManager.getInstance();
    }

    public static WorldStateManager getWorldStateMgr() {
        return WorldStateManager.getInstance();
    }
}
