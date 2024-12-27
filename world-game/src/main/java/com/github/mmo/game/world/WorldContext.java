package com.github.mmo.game.world;

import com.github.mmo.common.Locale;
import com.github.mmo.dbc.DbcObjectManager;
import game.ConditionManager;
import game.ObjectManager;
import com.github.mmo.game.entity.object.GenericObject;
import com.github.mmo.game.entity.object.ObjectGuid;
import com.github.mmo.game.entity.object.WorldObject;
import com.github.mmo.game.map.TerrainManager;
import com.github.mmo.game.map.collision.VMapManager;
import com.github.mmo.game.entity.areatrigger.AreaTrigger;
import com.github.mmo.game.entity.conversation.Conversation;
import com.github.mmo.game.entity.corpse.Corpse;
import com.github.mmo.game.entity.creature.Creature;
import com.github.mmo.game.entity.dynamic.DynamicObject;
import com.github.mmo.game.entity.gobject.GameObject;
import com.github.mmo.game.entity.gobject.Transport;
import com.github.mmo.game.entity.object.enums.TypeMask;
import com.github.mmo.game.entity.pet.Pet;
import com.github.mmo.game.entity.player.Player;
import com.github.mmo.game.entity.scene.SceneObject;
import com.github.mmo.game.entity.unit.Unit;
import com.github.mmo.game.spell.SpellManager;
import com.github.mmo.game.world.setting.WorldSetting;

import java.util.Iterator;

public interface WorldContext {

    Locale getDbcLocale();
    WorldSetting getWorldSettings();
    int getSetting(String name, int defaultValue);


    DbcObjectManager getDbcObjectManager();
    ObjectManager getObjectManager();
    ConditionManager getConditionManager();
    SpellManager getSpellManager();
    TerrainManager getTerrainManager();
    VMapManager getVMapManager();


    // these functions return objects only if in map of specified object
    WorldObject getWorldObject(ObjectGuid guid);
    GenericObject getObjectByTypeMask(ObjectGuid guid, TypeMask mask);
    Corpse getCorpse(ObjectGuid guid);
    GameObject GetGameObject(ObjectGuid guid);
    Transport getTransport(ObjectGuid guid);
    DynamicObject getDynamicObject(ObjectGuid guid);
    AreaTrigger getAreaTrigger(ObjectGuid guid);
    SceneObject getSceneObject(ObjectGuid guid);
    Conversation getConversation(ObjectGuid guid);
    Unit getUnit(ObjectGuid guid);
    Creature getCreature(ObjectGuid guid);
    Pet getPet(ObjectGuid guid);
    Player getPlayer(ObjectGuid guid);
    Creature getCreatureOrPetOrVehicle(ObjectGuid guid);

    // these functions return objects if found in whole world
    // ACCESS LIKE THAT IS NOT THREAD SAFE
    Player findPlayer(ObjectGuid guid);
    Player findPlayerByName(String name);
    Player findPlayerByLowGUID(int entry);

    // this returns Player even if he is not in world, for example teleporting
    Player findConnectedPlayer(ObjectGuid guid);
    Player findConnectedPlayerByName(String name);

    // when using this, you must use the hashmapholder's lock
    Iterator<Player> getPlayers();

}
