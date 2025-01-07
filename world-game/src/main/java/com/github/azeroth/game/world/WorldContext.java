package com.github.azeroth.game.world;

import com.github.azeroth.common.Locale;
import com.github.azeroth.dbc.DbcObjectManager;
import com.github.azeroth.game.condition.ConditionManager;
import com.github.azeroth.game.entity.areatrigger.AreaTrigger;
import com.github.azeroth.game.entity.conversation.Conversation;
import com.github.azeroth.game.entity.corpse.Corpse;
import com.github.azeroth.game.entity.creature.Creature;
import com.github.azeroth.game.entity.dynamic.DynamicObject;
import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.entity.gobject.Transport;
import com.github.azeroth.game.entity.object.GenericObject;
import com.github.azeroth.game.entity.object.ObjectGuid;
import com.github.azeroth.game.entity.object.WorldObject;
import com.github.azeroth.game.entity.object.enums.TypeMask;
import com.github.azeroth.game.entity.pet.Pet;
import com.github.azeroth.game.entity.player.Player;
import com.github.azeroth.game.entity.scene.SceneObject;
import com.github.azeroth.game.entity.unit.Unit;
import com.github.azeroth.game.globals.ObjectManager;
import com.github.azeroth.game.map.InstanceLockManager;
import com.github.azeroth.game.map.TerrainManager;
import com.github.azeroth.game.map.collision.VMapManager;
import com.github.azeroth.game.spell.SpellManager;
import com.github.azeroth.game.world.setting.WorldSetting;
import game.ConditionManager;
import game.ObjectManager;

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


    InstanceLockManager getInstanceLockManager();


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
