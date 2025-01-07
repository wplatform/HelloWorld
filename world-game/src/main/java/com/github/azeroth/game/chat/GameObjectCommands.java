package com.github.azeroth.game.chat;


import com.github.azeroth.game.entity.gobject.GameObject;
import com.github.azeroth.game.entity.gobject.GameObjectData;
import com.github.azeroth.game.entity.object.WorldObject;
import game.PhasingHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

class GameObjectCommands {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGameObjectActivateCommand(CommandHandler handler, long guidLow) {
        var obj = handler.getObjectFromPlayerMapByDbGuid(guidLow);

        if (!obj) {
            handler.sendSysMessage(CypherStrings.CommandObjnotfound, guidLow);

            return false;
        }

        var autoCloseTime = obj.getTemplate().getAutoCloseTime() != 0 ? 10000 : 0;

        // Activate
        obj.setLootState(LootState.Ready);
        obj.useDoorOrButton(autoCloseTime, false, handler.getSession().getPlayer());

        handler.sendSysMessage("Object activated!");

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGameObjectDeleteCommand(CommandHandler handler, long spawnId) {
        var obj = handler.getObjectFromPlayerMapByDbGuid(spawnId);

        if (obj != null) {
            var player = handler.getSession().getPlayer();
            var ownerGuid = obj.getOwnerGUID();

            if (!ownerGuid.isEmpty()) {
                var owner = global.getObjAccessor().GetUnit(player, ownerGuid);

                if (!owner || !ownerGuid.isPlayer()) {
                    handler.sendSysMessage(CypherStrings.CommandDelobjrefercreature, ownerGuid.toString(), obj.getGUID().toString());

                    return false;
                }

                owner.removeGameObject(obj, false);
            }
        }

        if (gameObject.deleteFromDB(spawnId)) {
            handler.sendSysMessage(CypherStrings.CommandDelobjmessage, spawnId);

            return true;
        }

        handler.sendSysMessage(CypherStrings.CommandObjnotfound, obj.getGUID().toString());

        return false;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGameObjectDespawnGroup(CommandHandler handler, String[] opts) {
        if (opts == null || opts.isEmpty()) {
            return false;
        }

        var deleteRespawnTimes = false;
        int groupId = 0;

        // Decode arguments
        for (var variant : opts) {
            if (variant.equalsIgnoreCase("removerespawntime")) {
                deleteRespawnTimes = true;
            } else {
                tangible.OutObject<Integer> tempOut_groupId = new tangible.OutObject<Integer>();
                tangible.TryParseHelper.tryParseInt(variant, tempOut_groupId);
                groupId = tempOut_groupId.outArgValue;
            }
        }

        var player = handler.getSession().getPlayer();

        int n;
        tangible.OutObject<Integer> tempOut_n = new tangible.OutObject<Integer>();
        if (!player.getMap().spawnGroupDespawn(groupId, deleteRespawnTimes, tempOut_n)) {
            n = tempOut_n.outArgValue;
            handler.sendSysMessage(CypherStrings.SpawngroupBadgroup, groupId);

            return false;
        } else {
            n = tempOut_n.outArgValue;
        }

        handler.sendSysMessage(String.format("Despawned a total of %1$s Objects.", n));

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGameObjectInfoCommand(CommandHandler handler, String isGuid, long data) {
        GameObject thisGO = null;
        GameObjectData spawnData = null;

        int entry;
        long spawnId = 0;

        if (!isGuid.isEmpty() && isGuid.equalsIgnoreCase("guid")) {
            spawnId = data;
            spawnData = global.getObjectMgr().getGameObjectData(spawnId);

            if (spawnData == null) {
                handler.sendSysMessage(CypherStrings.CommandObjnotfound, spawnId);

                return false;
            }

            entry = spawnData.id;
            thisGO = handler.getObjectFromPlayerMapByDbGuid(spawnId);
        } else {
            entry = (int) data;
        }

        var gameObjectInfo = global.getObjectMgr().getGameObjectTemplate(entry);

        if (gameObjectInfo == null) {
            handler.sendSysMessage(CypherStrings.GameobjectNotExist, entry);

            return false;
        }

        var type = gameObjectInfo.type;
        var displayId = gameObjectInfo.displayId;
        var name = gameObjectInfo.name;
        var lootId = gameObjectInfo.getLootId();

        if (type == GameObjectTypes.chest && lootId == 0) {
            lootId = gameObjectInfo.chest.chestPersonalLoot;
        }

        // If we have a real object, send some info about it
        if (thisGO != null) {
            handler.sendSysMessage(CypherStrings.SpawninfoGuidinfo, thisGO.getGUID().toString());
            handler.sendSysMessage(CypherStrings.SpawninfoCompatibilityMode, thisGO.getRespawnCompatibilityMode());

            if (thisGO.getGameObjectData() != null && thisGO.getGameObjectData().getSpawnGroupData().getGroupId() != 0) {
                var groupData = thisGO.toGameObject().getGameObjectData().getSpawnGroupData();
                handler.sendSysMessage(CypherStrings.SpawninfoGroupId, groupData.getName(), groupData.getGroupId(), groupData.getFlags(), thisGO.getMap().isSpawnGroupActive(groupData.getGroupId()));
            }

            var goOverride = global.getObjectMgr().getGameObjectOverride(spawnId);

            if (goOverride == null) {
                goOverride = global.getObjectMgr().getGameObjectTemplateAddon(entry);
            }

            if (goOverride != null) {
                handler.sendSysMessage(CypherStrings.GoinfoAddon, goOverride.faction, goOverride.flags);
            }
        }

        if (spawnData != null) {
            var yaw;
            var pitch;
            var roll;
// C# TO JAVA CONVERTER TASK: The following method call contained an unresolved 'out' keyword - these cannot be converted using the 'OutObject' helper class unless the method is within the code being modified:
            spawnData.rotation.toEulerAnglesZYX(out yaw, out pitch, out roll);
            handler.sendSysMessage(CypherStrings.SpawninfoSpawnidLocation, spawnData.getSpawnId(), spawnData.spawnPoint.getX(), spawnData.spawnPoint.getY(), spawnData.spawnPoint.getZ());
            handler.sendSysMessage(CypherStrings.SpawninfoRotation, yaw, pitch, roll);
        }

        handler.sendSysMessage(CypherStrings.GoinfoEntry, entry);
        handler.sendSysMessage(CypherStrings.GoinfoType, type);
        handler.sendSysMessage(CypherStrings.GoinfoLootid, lootId);
        handler.sendSysMessage(CypherStrings.GoinfoDisplayid, displayId);
        handler.sendSysMessage(CypherStrings.GoinfoName, name);
        handler.sendSysMessage(CypherStrings.GoinfoSize, gameObjectInfo.size);

        handler.sendSysMessage(CypherStrings.ObjectinfoAiInfo, gameObjectInfo.AIName, global.getObjectMgr().getScriptName(gameObjectInfo.scriptId));
        var ai = thisGO != null ? thisGO.getAI() : null;

        if (ai != null) {
            handler.sendSysMessage(CypherStrings.ObjectinfoAiType, "ai");
        }

        var modelInfo = CliDB.GameObjectDisplayInfoStorage.get(displayId);

        if (modelInfo != null) {
            handler.sendSysMessage(CypherStrings.GoinfoModel, modelInfo.GeoBoxMax.X, modelInfo.GeoBoxMax.Y, modelInfo.GeoBoxMax.Z, modelInfo.GeoBoxMin.X, modelInfo.GeoBoxMin.Y, modelInfo.GeoBoxMin.Z);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGameObjectMoveCommand(CommandHandler handler, long guidLow, float[] xyz) {
        var obj = handler.getObjectFromPlayerMapByDbGuid(guidLow);

        if (!obj) {
            handler.sendSysMessage(CypherStrings.CommandObjnotfound, guidLow);

            return false;
        }

        Position pos;

        if (xyz != null) {
            pos = new Position(xyz[0], xyz[1], xyz[2]);

            if (!MapDefine.isValidMapCoordinatei(obj.getLocation().getMapId(), pos)) {
                handler.sendSysMessage(CypherStrings.InvalidTargetCoord, pos.getX(), pos.getY(), obj.getLocation().getMapId());

                return false;
            }
        } else {
            pos = handler.getSession().getPlayer().getLocation();
        }

        var map = obj.getMap();

        pos.setO(obj.getLocation().getO());
        obj.getLocation().relocate(pos);

        // update which cell has this gameobject registered for loading
        global.getObjectMgr().removeGameObjectFromGrid(obj.getGameObjectData());
        obj.saveToDB();
        global.getObjectMgr().addGameObjectToGrid(obj.getGameObjectData());

        // Generate a completely new spawn with new guid
        // client caches recently deleted objects and brings them back to life
        // when CreateObject block for this guid is received again
        // however it entirely skips parsing that block and only uses already known location
        obj.delete();

        obj = gameObject.createGameObjectFromDb(guidLow, map);

        if (!obj) {
            return false;
        }

        handler.sendSysMessage(CypherStrings.CommandMoveobjmessage, obj.getSpawnId(), obj.getTemplate().name, obj.getGUID().toString());

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGameObjectNearCommand(CommandHandler handler, Float dist) {
        var distance = (dist == null ? 10f : dist.floatValue());
        int count = 0;

        var player = handler.getPlayer();

        var stmt = DB.World.GetPreparedStatement(WorldStatements.SEL_GAMEOBJECT_NEAREST);
        stmt.AddValue(0, player.getLocation().getX());
        stmt.AddValue(1, player.getLocation().getY());
        stmt.AddValue(2, player.getLocation().getZ());
        stmt.AddValue(3, player.getLocation().getMapId());
        stmt.AddValue(4, player.getLocation().getX());
        stmt.AddValue(5, player.getLocation().getY());
        stmt.AddValue(6, player.getLocation().getZ());
        stmt.AddValue(7, distance * distance);
        var result = DB.World.query(stmt);

        if (!result.isEmpty()) {
            do {
                var guid = result.<Long>Read(0);
                var entry = result.<Integer>Read(1);
                var x = result.<Float>Read(2);
                var y = result.<Float>Read(3);
                var z = result.<Float>Read(4);
                var mapId = result.<SHORT>Read(5);

                var gameObjectInfo = global.getObjectMgr().getGameObjectTemplate(entry);

                if (gameObjectInfo == null) {
                    continue;
                }

                handler.sendSysMessage(CypherStrings.GoListChat, guid, entry, guid, gameObjectInfo.name, x, y, z, mapId, "", "");

                ++count;
            } while (result.NextRow());
        }

        handler.sendSysMessage(CypherStrings.CommandNearobjmessage, distance, count);

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGameObjectSpawnGroup(CommandHandler handler, StringArguments args) {
        if (args.isEmpty()) {
            return false;
        }

        var ignoreRespawn = false;
        var force = false;
        int groupId = 0;

        // Decode arguments
        var arg = args.NextString(" ");

        while (!arg.isEmpty()) {
            var thisArg = arg.toLowerCase();

            if (Objects.equals(thisArg, "ignorerespawn")) {
                ignoreRespawn = true;
            } else if (Objects.equals(thisArg, "force")) {
                force = true;
            } else if (thisArg.isEmpty() || !thisArg.IsNumber()) {
                return false;
            } else {
                groupId = Integer.parseInt(thisArg);
            }

            arg = args.NextString(" ");
        }

        var player = handler.getSession().getPlayer();

        ArrayList<WorldObject> creatureList = new ArrayList<>();

        if (!player.getMap().spawnGroupSpawn(groupId, ignoreRespawn, force, creatureList)) {
            handler.sendSysMessage(CypherStrings.SpawngroupBadgroup, groupId);

            return false;
        }

        handler.sendSysMessage(CypherStrings.SpawngroupSpawncount, creatureList.size());

        for (var obj : creatureList) {
            handler.sendSysMessage(String.format("%1$s (%2$s)", obj.getName(), obj.getGUID()));
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGameObjectTargetCommand(CommandHandler handler, String objectIdStr) {
        var player = handler.getSession().getPlayer();
        SQLResult result;
        var activeEventsList = global.getGameEventMgr().getActiveEventList();

        if (objectIdStr.isEmpty()) {
            int objectId;
            tangible.OutObject<Integer> tempOut_objectId = new tangible.OutObject<Integer>();
            if (tangible.TryParseHelper.tryParseInt(objectIdStr, tempOut_objectId)) {
                objectId = tempOut_objectId.outArgValue;
                result = DB.World.query("SELECT guid, id, position_x, position_y, position_z, orientation, map, phaseId, phaseGroup, (POW(position_x - '{0}', 2) + POW(position_y - '{1}', 2) + POW(position_z - '{2}', 2)) AS order_ FROM gameobject WHERE map = '{3}' AND id = '{4}' ORDER BY order_ ASC LIMIT 1", player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getMapId(), objectId);
            } else {
                objectId = tempOut_objectId.outArgValue;
                result = DB.World.query("SELECT guid, id, position_x, position_y, position_z, orientation, map, phaseId, phaseGroup, (POW(position_x - {0}, 2) + POW(position_y - {1}, 2) + POW(position_z - {2}, 2)) AS order_ " + "FROM gameobject LEFT JOIN gameobject_template ON gameobject_template.entry = gameobject.id WHERE map = {3} AND name LIKE CONCAT('%%', '{4}', '%%') ORDER BY order_ ASC LIMIT 1", player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getMapId(), objectIdStr);
            }
        } else {
            StringBuilder eventFilter = new StringBuilder();
            eventFilter.append(" AND (eventEntry IS NULL ");
            var initString = true;

            for (var entry : activeEventsList) {
                if (initString) {
                    eventFilter.append("OR eventEntry IN (" + entry);
                    initString = false;
                } else {
                    eventFilter.append(',' + entry);
                }
            }

            if (!initString) {
                eventFilter.append("))");
            } else {
                eventFilter.append(')');
            }

            result = DB.World.query("SELECT gameobject.guid, id, position_x, position_y, position_z, orientation, map, phaseId, phaseGroup, " + "(POW(position_x - {0}, 2) + POW(position_y - {1}, 2) + POW(position_z - {2}, 2)) AS order_ FROM gameobject " + "LEFT OUTER JOIN game_event_gameobject on gameobject.guid = game_event_gameobject.guid WHERE map = '{3}' {4} ORDER BY order_ ASC LIMIT 10", handler.getSession().getPlayer().getLocation().getX(), handler.getSession().getPlayer().getLocation().getY(), handler.getSession().getPlayer().getLocation().getZ(), handler.getSession().getPlayer().getLocation().getMapId(), eventFilter.toString());
        }

        if (result.isEmpty()) {
            handler.sendSysMessage(CypherStrings.CommandTargetobjnotfound);

            return true;
        }

        var found = false;
        float x, y, z, o;
        long guidLow;
        int id, phaseId, phaseGroup;
        short mapId;
        int poolId;

        do {
            guidLow = result.<Long>Read(0);
            id = result.<Integer>Read(1);
            x = result.<Float>Read(2);
            y = result.<Float>Read(3);
            z = result.<Float>Read(4);
            o = result.<Float>Read(5);
            mapId = result.<SHORT>Read(6);
            phaseId = result.<Integer>Read(7);
            phaseGroup = result.<Integer>Read(8);
            poolId = global.getPoolMgr().<GameObject>IsPartOfAPool(guidLow);

            if (poolId == 0 || global.getPoolMgr().<GameObject>IsSpawnedObject(guidLow)) {
                found = true;
            }
        } while (result.NextRow() && !found);

        if (!found) {
            handler.sendSysMessage(CypherStrings.GameobjectNotExist, id);

            return false;
        }

        var objectInfo = global.getObjectMgr().getGameObjectTemplate(id);

        if (objectInfo == null) {
            handler.sendSysMessage(CypherStrings.GameobjectNotExist, id);

            return false;
        }

        var target = handler.getObjectFromPlayerMapByDbGuid(guidLow);

        handler.sendSysMessage(CypherStrings.GameobjectDetail, guidLow, objectInfo.name, guidLow, id, x, y, z, mapId, o, phaseId, phaseGroup);

        if (target) {
            var curRespawnDelay = (int) (target.getRespawnTimeEx() - gameTime.GetGameTime());

            if (curRespawnDelay < 0) {
                curRespawnDelay = 0;
            }

            var curRespawnDelayStr = time.secsToTimeString((int) curRespawnDelay, TimeFormat.ShortText, false);
            var defRespawnDelayStr = time.secsToTimeString(target.getRespawnDelay(), TimeFormat.ShortText, false);

            handler.sendSysMessage(CypherStrings.CommandRawpawntimes, defRespawnDelayStr, curRespawnDelayStr);
        }

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static boolean handleGameObjectTurnCommand(CommandHandler handler, long guidLow, Float oz, Float oy, Float ox) {
        var obj = handler.getObjectFromPlayerMapByDbGuid(guidLow);

        if (!obj) {
            handler.sendSysMessage(CypherStrings.CommandObjnotfound, guidLow);

            return false;
        }

        if (oz == null) {
            oz = handler.getSession().getPlayer().getLocation().getO();
        }

        var map = obj.getMap();

        obj.getLocation().relocate(obj.getLocation().getX(), obj.getLocation().getY(), obj.getLocation().getZ(), oz.floatValue());
        obj.setLocalRotationAngles(oz.floatValue(), (oy == null ? 0f : oy.floatValue()), (ox == null ? 0f : ox.floatValue()));
        obj.saveToDB();

        // Generate a completely new spawn with new guid
        // client caches recently deleted objects and brings them back to life
        // when CreateObject block for this guid is received again
        // however it entirely skips parsing that block and only uses already known location
        obj.delete();

        obj = gameObject.createGameObjectFromDb(guidLow, map);

        if (!obj) {
            return false;
        }

        handler.sendSysMessage(CypherStrings.CommandTurnobjmessage, obj.getSpawnId(), obj.getTemplate().name, obj.getGUID().toString(), obj.getLocation().getO());

        return true;
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class AddCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleGameObjectAddCommand(CommandHandler handler, int objectId, Integer spawnTimeSecs) {
            if (objectId == 0) {
                return false;
            }

            var objectInfo = global.getObjectMgr().getGameObjectTemplate(objectId);

            if (objectInfo == null) {
                handler.sendSysMessage(CypherStrings.GameobjectNotExist, objectId);

                return false;
            }

            if (objectInfo.displayId != 0 && !CliDB.GameObjectDisplayInfoStorage.containsKey(objectInfo.displayId)) {
                // report to DB errors log as in loading case
                Logs.SQL.error("Gameobject (Entry {0} GoType: {1}) have invalid displayId ({2}), not spawned.", objectId, objectInfo.type, objectInfo.displayId);
                handler.sendSysMessage(CypherStrings.GameobjectHaveInvalidData, objectId);

                return false;
            }

            var player = handler.getPlayer();
            var map = player.getMap();

            var obj = gameObject.createGameObject(objectInfo.entry, map, player.getLocation(), Quaternion.CreateFromRotationMatrix(Extensions.fromEulerAnglesZYX(player.getLocation().getO(), 0.0f, 0.0f)), 255, GOState.Ready);

            if (!obj) {
                return false;
            }

            PhasingHandler.inheritPhaseShift(obj, player);

            if (spawnTimeSecs != null) {
                obj.setRespawnTime(spawnTimeSecs.intValue());
            }

            // fill the gameobject data and save to the db
            obj.saveToDB(map.getId(), new ArrayList<Difficulty>(Arrays.asList(map.getDifficultyID())));

            var spawnId = obj.getSpawnId();

            // this will generate a new guid if the object is in an instance
            obj = gameObject.createGameObjectFromDb(spawnId, map);

            if (!obj) {
                return false;
            }

            // TODO: is it really necessary to add both the real and DB table guid here ?
            global.getObjectMgr().addGameObjectToGrid(global.getObjectMgr().getGameObjectData(spawnId));
            handler.sendSysMessage(CypherStrings.GameobjectAdd, objectId, objectInfo.name, spawnId, player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ());

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleGameObjectAddTempCommand(CommandHandler handler, int objectId, Long spawntime) {
            var player = handler.getPlayer();
            var spawntm = duration.FromSeconds((spawntime == null ? 300 : spawntime.longValue()));

            var rotation = Quaternion.CreateFromRotationMatrix(Extensions.fromEulerAnglesZYX(player.getLocation().getO(), 0.0f, 0.0f));

            if (global.getObjectMgr().getGameObjectTemplate(objectId) == null) {
                handler.sendSysMessage(CypherStrings.GameobjectNotExist, objectId);

                return false;
            }

            player.summonGameObject(objectId, player.getLocation(), rotation, spawntm);

            return true;
        }
    }

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    private static class SetCommands {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleGameObjectSetPhaseCommand(CommandHandler handler, long guidLow, int phaseId) {
            if (guidLow == 0) {
                return false;
            }

            var obj = handler.getObjectFromPlayerMapByDbGuid(guidLow);

            if (!obj) {
                handler.sendSysMessage(CypherStrings.CommandObjnotfound, guidLow);

                return false;
            }

            if (phaseId == 0) {
                handler.sendSysMessage(CypherStrings.BadValue);

                return false;
            }

            PhasingHandler.addPhase(obj, phaseId, true);
            obj.saveToDB();

            return true;
        }

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        private static boolean handleGameObjectSetStateCommand(CommandHandler handler, long guidLow, int objectType, Integer objectState) {
            if (guidLow == 0) {
                return false;
            }

            var obj = handler.getObjectFromPlayerMapByDbGuid(guidLow);

            if (!obj) {
                handler.sendSysMessage(CypherStrings.CommandObjnotfound, guidLow);

                return false;
            }

            if (objectType < 0) {
                if (objectType == -1) {
                    obj.sendGameObjectDespawn();
                } else if (objectType == -2) {
                    return false;
                }

                return true;
            }

            if (objectState.equals(0)) {
                return false;
            }

            switch (objectType) {
                case 0:
                    obj.setGoState(GOState.forValue(objectState));

                    break;
                case 1:
                    obj.setGoType(GameObjectTypes.forValue(objectState));

                    break;
                case 2:
                    obj.setGoArtKit(objectState.intValue());

                    break;
                case 3:
                    obj.setGoAnimProgress(objectState.intValue());

                    break;
                case 4:
                    obj.sendCustomAnim(objectState.intValue());

                    break;
                case 5:
// C# TO JAVA CONVERTER TASK: Comparisons involving nullable type instances are not converted to null-value logic:
                    if (objectState < 0 || objectState > (int) GameObjectDestructibleState.Rebuilding.getValue()) {
                        return false;
                    }

                    obj.setDestructibleState(GameObjectDestructibleState.forValue(objectState));

                    break;
                default:
                    break;
            }

            handler.sendSysMessage("Set gobject type {0} state {1}", objectType, objectState);

            return true;
        }
    }
}
