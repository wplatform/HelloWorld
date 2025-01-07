package com.github.azeroth.game.map;


import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntMap;
import com.github.azeroth.game.entity.gobject.GameObjectTemplate;
import com.github.azeroth.game.entity.gobject.transport;
import com.github.azeroth.game.movement.spline;
import game.PhasingHandler;

import java.util.ArrayList;


public class TransportManager {
    private final IntMap<TransportTemplate> transportTemplates = new IntMap<>();
    private final IntMap<Array<TransportSpawn>> transportsByMap = new IntMap<>();
    private final IntMap<TransportAnimation> transportAnimations = new IntMap<>();
    private final IntMap<TransportSpawn> transportSpawns = new IntMap<>();

    private TransportManager() {
    }

    private static void initializeLeg(TransportPathLeg leg, ArrayList<TransportPathEvent> outEvents, ArrayList<TaxiPathNodeRecord> pathPoints, ArrayList<TaxiPathNodeRecord> pauses, ArrayList<TaxiPathNodeRecord> events, GameObjectTemplate goInfo, tangible.RefObject<Integer> totalTime) {
        ArrayList<Vector3> splinePath = new ArrayList<Vector3>(pathPoints.Select(node -> new Vector3(node.loc.X, node.loc.Y, node.loc.Z)));
        SplineRawInitializer initer = new SplineRawInitializer(splinePath);
        leg.setSpline(new spline<Double>());
        leg.getSpline().set_steps_per_segment(20);
        leg.getSpline().initSplineCustom(initer);
        leg.getSpline().initLengths();

// C# TO JAVA CONVERTER TASK: Local functions are not converted by C# to Java Converter:
//		uint legTimeAccelDecel(double dist)
//			{
//				var speed = (double)goInfo.moTransport.moveSpeed;
//				var accel = (double)goInfo.moTransport.accelRate;
//				var accelDist = 0.5 * speed * speed / accel;
//
//				if (accelDist >= dist * 0.5)
//					return (uint)(Math.Sqrt(dist / accel) * 2000.0);
//				else
//					return (uint)((dist - (accelDist + accelDist)) / speed * 1000.0 + speed / accel * 2000.0);
//			}

// C# TO JAVA CONVERTER TASK: Local functions are not converted by C# to Java Converter:
//		uint legTimeAccel(double dist)
//			{
//				var speed = (double)goInfo.moTransport.moveSpeed;
//				var accel = (double)goInfo.moTransport.accelRate;
//				var accelDist = 0.5 * speed * speed / accel;
//
//				if (accelDist >= dist)
//					return (uint)(Math.Sqrt((dist + dist) / accel) * 1000.0);
//				else
//					return (uint)(((dist - accelDist) / speed + speed / accel) * 1000.0);
//			}

        ;

        // Init segments
        var pauseItr = 0;
        var eventItr = 0;
        var splineLengthToPreviousNode = 0.0;
        int delaySum = 0;

        if (!pauses.isEmpty()) {
            for (; pauseItr < pauses.size(); ++pauseItr) {
                var pausePointIndex = pathPoints.indexOf(pauses.get(pauseItr));

                if (pausePointIndex == pathPoints.size() - 1) // last point is a "fake" spline point, its position can never be reached so transport cannot stop there
                {
                    break;
                }

                for (; eventItr < events.size(); ++eventItr) {
                    var eventPointIndex = pathPoints.indexOf(events.get(eventItr));

                    if (eventPointIndex > pausePointIndex) {
                        break;
                    }

                    double eventLength = leg.getSpline().length(eventPointIndex) - splineLengthToPreviousNode;
                    int eventSplineTime = 0;

                    if (pauseItr != 0) {
                        eventSplineTime = legTimeAccelDecel(eventLength);
                    } else {
                        eventSplineTime = legTimeAccel(eventLength);
                    }

                    if (pathPoints.get(eventPointIndex).ArrivalEventID != 0) {
                        TransportPathEvent event = new TransportPathEvent();
                        event.timestamp = totalTime.refArgValue + eventSplineTime + leg.getDuration() + delaySum;
                        event.eventId = pathPoints.get(eventPointIndex).ArrivalEventID;
                        outEvents.add(event);
                    }

                    if (pathPoints.get(eventPointIndex).DepartureEventID != 0) {
                        TransportPathEvent event = new TransportPathEvent();
                        event.timestamp = totalTime.refArgValue + eventSplineTime + leg.getDuration() + delaySum + (pausePointIndex == eventPointIndex ? pathPoints.get(eventPointIndex).Delay * time.InMilliseconds : 0);
                        event.eventId = pathPoints.get(eventPointIndex).DepartureEventID;
                        outEvents.add(event);
                    }
                }

                double splineLengthToCurrentNode = leg.getSpline().length(pausePointIndex);
                var length1 = splineLengthToCurrentNode - splineLengthToPreviousNode;
                int movementTime = 0;

                if (pauseItr != 0) {
                    movementTime = legTimeAccelDecel(length1);
                } else {
                    movementTime = legTimeAccel(length1);
                }

                leg.setDuration(leg.getDuration() + movementTime);
                TransportPathSegment segment = new TransportPathSegment();
                segment.setSegmentEndArrivalTimestamp(leg.getDuration() + delaySum);
                segment.setDelay(pathPoints.get(pausePointIndex).Delay * time.InMilliseconds);
                segment.setDistanceFromLegStartAtEnd(splineLengthToCurrentNode);
                leg.segments.add(segment);
                delaySum += pathPoints.get(pausePointIndex).Delay * time.InMilliseconds;
                splineLengthToPreviousNode = splineLengthToCurrentNode;
            }
        }

        // Process events happening after last pause
        for (; eventItr < events.size(); ++eventItr) {
            var eventPointIndex = pathPoints.indexOf(events.get(eventItr));

            if (eventPointIndex == -1) // last point is a "fake" spline node, events cannot happen there
            {
                break;
            }

            double eventLength = leg.getSpline().length(eventPointIndex) - splineLengthToPreviousNode;
            int eventSplineTime = 0;

            if (pauseItr != 0) {
                eventSplineTime = legTimeAccel(eventLength);
            } else {
                eventSplineTime = (int) (eventLength / (double) goInfo.moTransport.moveSpeed * 1000.0);
            }

            if (pathPoints.get(eventPointIndex).ArrivalEventID != 0) {
                TransportPathEvent event = new TransportPathEvent();
                event.timestamp = totalTime.refArgValue + eventSplineTime + leg.getDuration();
                event.eventId = pathPoints.get(eventPointIndex).ArrivalEventID;
                outEvents.add(event);
            }

            if (pathPoints.get(eventPointIndex).DepartureEventID != 0) {
                TransportPathEvent event = new TransportPathEvent();
                event.timestamp = totalTime.refArgValue + eventSplineTime + leg.getDuration();
                event.eventId = pathPoints.get(eventPointIndex).DepartureEventID;
                outEvents.add(event);
            }
        }

        // Add segment after last pause
        double length = leg.getSpline().length() - splineLengthToPreviousNode;
        int splineTime = 0;

        if (pauseItr != 0) {
            splineTime = legTimeAccel(length);
        } else {
            splineTime = (int) (length / (double) goInfo.moTransport.moveSpeed * 1000.0);
        }

        leg.setStartTimestamp(totalTime.refArgValue);
        leg.setDuration(leg.getDuration() + splineTime + delaySum);
        TransportPathSegment pauseSegment = new TransportPathSegment();
        pauseSegment.setSegmentEndArrivalTimestamp(leg.getDuration());
        pauseSegment.setDelay(0);
        pauseSegment.setDistanceFromLegStartAtEnd(leg.getSpline().length());
        leg.segments.add(pauseSegment);
        totalTime.refArgValue += leg.segments.get(pauseItr).getSegmentEndArrivalTimestamp() + leg.segments.get(pauseItr).getDelay();

        for (var i = 0; i < leg.segments.size(); ++i) {
            leg.segments.get(i).setSegmentEndArrivalTimestamp(leg.segments.get(i).getSegmentEndArrivalTimestamp() + leg.getStartTimestamp());
        }
    }

    public final void loadTransportTemplates() {
        var oldMSTime = System.currentTimeMillis();

        var result = DB.World.query("SELECT entry FROM gameobject_template WHERE type = 15 ORDER BY entry ASC");

        if (result.isEmpty()) {
            Log.outInfo(LogFilter.ServerLoading, "Loaded 0 transports templates. DB table `gameobject_template` has no transports!");

            return;
        }

        int count = 0;

        do {
            var entry = result.<Integer>Read(0);
            var goInfo = global.getObjectMgr().getGameObjectTemplate(entry);

            if (goInfo == null) {
                Logs.SQL.error("Transport {0} has no associated GameObjectTemplate from `gameobject_template` , skipped.", entry);

                continue;
            }

            if (!CliDB.TaxiPathNodesByPath.containsKey(goInfo.moTransport.taxiPathID)) {
                Logs.SQL.error("Transport {0} (name: {1}) has an invalid path specified in `gameobject_template`.`data0` ({2}) field, skipped.", entry, goInfo.name, goInfo.moTransport.taxiPathID);

                continue;
            }

            if (goInfo.moTransport.taxiPathID == 0) {
                continue;
            }

            // paths are generated per template, saves us from generating it again in case of instanced transports
            TransportTemplate transport = new TransportTemplate();

            generatePath(goInfo, transport);
            transportTemplates.put(entry, transport);

            ++count;
        } while (result.NextRow());


        Log.outInfo(LogFilter.ServerLoading, "Loaded {0} transports in {1} ms", count, time.GetMSTimeDiffToNow(oldMSTime));
    }

    public final void loadTransportAnimationAndRotation() {
        for (var anim : CliDB.TransportAnimationStorage.values()) {
            addPathNodeToTransport(anim.transportID, anim.TimeIndex, anim);
        }

        for (var rot : CliDB.TransportRotationStorage.values()) {
            addPathRotationToTransport(rot.GameObjectsID, rot.TimeIndex, rot);
        }
    }

    public final void loadTransportSpawns() {
        if (transportTemplates.isEmpty()) {
            return;
        }

        var oldMSTime = System.currentTimeMillis();

        var result = DB.World.query("SELECT guid, entry, phaseUseFlags, phaseid, phasegroup FROM transports");

        int count = 0;

        if (!result.isEmpty()) {
            do {
                var guid = result.<Long>Read(0);
                var entry = result.<Integer>Read(1);
                var phaseUseFlags = PhaseUseFlagsValues.forValue(result.<Byte>Read(2));
                var phaseId = result.<Integer>Read(3);
                var phaseGroupId = result.<Integer>Read(4);

                var transportTemplate = getTransportTemplate(entry);

                if (transportTemplate == null) {
                    Logs.SQL.error(String.format("Table `transports` have transport (GUID: %1$s Entry: %2$s) with unknown gameobject `entry` set, skipped.", guid, entry));

                    continue;
                }

                if ((phaseUseFlags.getValue() & ~PhaseUseFlagsValues.All.getValue()) != 0) {
                    Logs.SQL.error(String.format("Table `transports` have transport (GUID: %1$s Entry: %2$s) with unknown `phaseUseFlags` set, removed unknown second.", guid, entry));
                    phaseUseFlags = PhaseUseFlagsValues.forValue(phaseUseFlags.getValue() & PhaseUseFlagsValues.All.getValue());
                }

                if (phaseUseFlags.hasFlag(PhaseUseFlagsValues.ALWAYSVISIBLE) && phaseUseFlags.hasFlag(PhaseUseFlagsValues.INVERSE)) {
                    Logs.SQL.error(String.format("Table `transports` have transport (GUID: %1$s Entry: %2$s) has both `phaseUseFlags` PHASE_USE_FLAGS_ALWAYS_VISIBLE and PHASE_USE_FLAGS_INVERSE, removing PHASE_USE_FLAGS_INVERSE.", guid, entry));
                    phaseUseFlags = PhaseUseFlagsValues.forValue(phaseUseFlags.getValue() & ~PhaseUseFlagsValues.INVERSE.getValue());
                }

                if (phaseGroupId != 0 && phaseId != 0) {
                    Logs.SQL.error(String.format("Table `transports` have transport (GUID: %1$s Entry: %2$s) with both `phaseid` and `phasegroup` set, `phasegroup` set to 0", guid, entry));
                    phaseGroupId = 0;
                }

                if (phaseId != 0) {
                    if (!CliDB.PhaseStorage.containsKey(phaseId)) {
                        Logs.SQL.error(String.format("Table `transports` have transport (GUID: %1$s Entry: %2$s) with `phaseid` %3$s does not exist, set to 0", guid, entry, phaseId));
                        phaseId = 0;
                    }
                }

                if (phaseGroupId != 0) {
                    if (global.getDB2Mgr().GetPhasesForGroup(phaseGroupId) == null) {
                        Logs.SQL.error(String.format("Table `transports` have transport (GUID: %1$s Entry: %2$s) with `phaseGroup` %3$s does not exist, set to 0", guid, entry, phaseGroupId));
                        phaseGroupId = 0;
                    }
                }

                TransportSpawn spawn = new TransportSpawn();
                spawn.setSpawnId(guid);
                spawn.setTransportGameObjectId(entry);
                spawn.setPhaseUseFlags(phaseUseFlags);
                spawn.setPhaseId(phaseId);
                spawn.setPhaseGroup(phaseGroupId);

                for (var mapId : transportTemplate.getMapIds()) {
                    transportsByMap.add(mapId, spawn);
                }

                transportSpawns.put(guid, spawn);

                count++;
            } while (result.NextRow());
        }

        Log.outInfo(LogFilter.ServerLoading, String.format("Spawned %1$s continent transports in %2$s ms", count, time.GetMSTimeDiffToNow(oldMSTime)));
    }

    public final void addPathNodeToTransport(int transportEntry, int timeSeg, TransportAnimationRecord node) {
        if (!transportAnimations.containsKey(transportEntry)) {
            transportAnimations.put(transportEntry, new TransportAnimation());
        }

        var animNode = transportAnimations.get(transportEntry);

        if (animNode.getTotalTime() < timeSeg) {
            animNode.setTotalTime(timeSeg);
        }

        animNode.getPath().put(timeSeg, node);
    }

    public final void addPathRotationToTransport(int transportEntry, int timeSeg, TransportRotationRecord node) {
        if (!transportAnimations.containsKey(transportEntry)) {
            transportAnimations.put(transportEntry, new TransportAnimation());
        }

        var animNode = transportAnimations.get(transportEntry);
        animNode.getRotations().put(timeSeg, node);

        if (animNode.getPath().isEmpty() && animNode.getTotalTime() < timeSeg) {
            animNode.setTotalTime(timeSeg);
        }
    }

    public final Transport createTransport(int entry, Map map, long guid, PhaseUseFlagsValues phaseUseFlags, int phaseId) {
        return createTransport(entry, map, guid, phaseUseFlags, phaseId, 0);
    }

    public final Transport createTransport(int entry, Map map, long guid, PhaseUseFlagsValues phaseUseFlags) {
        return createTransport(entry, map, guid, phaseUseFlags, 0, 0);
    }

    public final Transport createTransport(int entry, Map map, long guid) {
        return createTransport(entry, map, guid, 0, 0, 0);
    }

    public final Transport createTransport(int entry, Map map) {
        return createTransport(entry, map, 0, 0, 0, 0);
    }

    public final void createTransportsForMap(Map map) {
        var mapTransports = transportsByMap.get(map.getId());

        // no transports here
        if (mapTransports.isEmpty()) {
            return;
        }

        // create transports
        for (var transport : mapTransports) {
            createTransport(transport.getTransportGameObjectId(), map, transport.getSpawnId(), transport.getPhaseUseFlags(), transport.getPhaseId(), transport.getPhaseGroup());
        }
    }

    public final TransportTemplate getTransportTemplate(int entry) {
        return transportTemplates.get(entry);
    }

    public final TransportAnimation getTransportAnimInfo(int entry) {
        return transportAnimations.get(entry);
    }

    public final TransportSpawn getTransportSpawn(long spawnId) {
        return transportSpawns.get(spawnId);
    }

    private void unload() {
        transportTemplates.clear();
    }

    public final Transport createTransport(int entry, Map map, long guid, PhaseUseFlagsValues phaseUseFlags, int phaseId, int phaseGroupId) {
        // setZoneScript() is called after adding to map, so fetch the script using map
        var instanceMap = map.getToInstanceMap();

        if (instanceMap != null) {
            var instance = instanceMap.getInstanceScript();

            if (instance != null) {
                entry = instance.getGameObjectEntry(0, entry);
            }
        }

        if (entry == 0) {
            return null;
        }

        var tInfo = getTransportTemplate(entry);

        if (tInfo == null) {
            Logs.SQL.error("Transport {0} will not be loaded, `transport_template` missing", entry);

            return null;
        }

        if (!tInfo.getMapIds().contains(map.getId())) {
            Log.outError(LogFilter.transport, String.format("Transport %1$s attempted creation on map it has no path for %2$s!", entry, map.getId()));

            return null;
        }

        tangible.OutObject<TransportMovementState> tempOut__ = new tangible.OutObject<TransportMovementState>();
        tangible.OutObject<Integer> tempOut__2 = new tangible.OutObject<Integer>();
        var startingPosition = tInfo.computePosition(0, tempOut__, tempOut__2);
        _ = tempOut__2.outArgValue;
        _ = tempOut__.outArgValue;

        if (startingPosition == null) {
            Logs.SQL.error(String.format("Transport %1$s will not be loaded, failed to compute starting position", entry));

            return null;
        }

        // create transport...
        Transport trans = new transport();

        // ...at first waypoint
        var x = startingPosition.getX();
        var y = startingPosition.getY();
        var z = startingPosition.getZ();
        var o = startingPosition.getO();

        // initialize the gameobject base
        var guidLow = guid != 0 ? guid : map.generateLowGuid(HighGuid.Transport);

        if (!trans.create(guidLow, entry, x, y, z, o)) {
            return null;
        }

        PhasingHandler.initDbPhaseShift(trans.getPhaseShift(), phaseUseFlags, phaseId, phaseGroupId);

        // use preset map for instances (need to know which instance)
        trans.setMap(map);

        if (instanceMap != null) {
            trans.setZoneScript(instanceMap.getInstanceScript());
        }

        // Passengers will be loaded once a player is near

        map.addToMap(trans);

        return trans;
    }

    private void generatePath(GameObjectTemplate goInfo, TransportTemplate transport) {
        var pathId = goInfo.moTransport.taxiPathID;
        var path = CliDB.TaxiPathNodesByPath.get(pathId);

        transport.setSpeed((double) goInfo.moTransport.moveSpeed);
        transport.setAccelerationRate((double) goInfo.moTransport.accelRate);
        transport.setAccelerationTime(transport.getSpeed() / transport.getAccelerationRate());
        transport.setAccelerationDistance(0.5 * transport.getSpeed() * transport.getSpeed() / transport.getAccelerationRate());

        ArrayList<TaxiPathNodeRecord> pathPoints = new ArrayList<>();
        ArrayList<TaxiPathNodeRecord> pauses = new ArrayList<>();
        ArrayList<TaxiPathNodeRecord> events = new ArrayList<>();

        transport.getPathLegs().add(new TransportPathLeg());

        var leg = transport.getPathLegs().get(0);
        leg.setMapId(path[0].ContinentID);
        var prevNodeWasTeleport = false;
        int totalTime = 0;

        for (var node : path) {
            if (node.ContinentID != leg.getMapId() || prevNodeWasTeleport) {
                tangible.RefObject<Integer> tempRef_totalTime = new tangible.RefObject<Integer>(totalTime);
                initializeLeg(leg, transport.getEvents(), pathPoints, pauses, events, goInfo, tempRef_totalTime);
                totalTime = tempRef_totalTime.refArgValue;

                leg = new TransportPathLeg();
                leg.setMapId(node.ContinentID);
                pathPoints.clear();
                pauses.clear();
                events.clear();
                transport.getPathLegs().add(leg);
            }

            prevNodeWasTeleport = node.flags.hasFlag(TaxiPathNodeFlags.Teleport);
            pathPoints.add(node);

            if (node.flags.hasFlag(TaxiPathNodeFlags.Stop)) {
                pauses.add(node);
            }

            if (node.ArrivalEventID != 0 || node.DepartureEventID != 0) {
                events.add(node);
            }

            transport.getMapIds().add(node.ContinentID);
        }

        if (leg.getSpline() == null) {
            tangible.RefObject<Integer> tempRef_totalTime2 = new tangible.RefObject<Integer>(totalTime);
            initializeLeg(leg, transport.getEvents(), pathPoints, pauses, events, goInfo, tempRef_totalTime2);
            totalTime = tempRef_totalTime2.refArgValue;
        }

        transport.setTotalPathTime(totalTime);
    }
}
