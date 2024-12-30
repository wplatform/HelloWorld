package com.github.mmo.game.map;


import java.util.ArrayList;
import java.util.HashSet;


public class TransportTemplate {
    private int totalPathTime;
    private double speed;
    private double accelerationRate;
    private double accelerationTime;
    private double accelerationDistance;
    private ArrayList<TransportPathLeg> pathLegs = new ArrayList<>();
    private ArrayList<TransportPathEvent> events = new ArrayList<>();
    private HashSet<Integer> mapIds = new HashSet<Integer>();

    public final int getTotalPathTime() {
        return totalPathTime;
    }

    public final void setTotalPathTime(int value) {
        totalPathTime = value;
    }

    public final double getSpeed() {
        return speed;
    }

    public final void setSpeed(double value) {
        speed = value;
    }

    public final double getAccelerationRate() {
        return accelerationRate;
    }

    public final void setAccelerationRate(double value) {
        accelerationRate = value;
    }

    public final double getAccelerationTime() {
        return accelerationTime;
    }

    public final void setAccelerationTime(double value) {
        accelerationTime = value;
    }

    public final double getAccelerationDistance() {
        return accelerationDistance;
    }

    public final void setAccelerationDistance(double value) {
        accelerationDistance = value;
    }

    public final ArrayList<TransportPathLeg> getPathLegs() {
        return pathLegs;
    }

    public final void setPathLegs(ArrayList<TransportPathLeg> value) {
        pathLegs = value;
    }

    public final ArrayList<TransportPathEvent> getEvents() {
        return events;
    }

    public final void setEvents(ArrayList<TransportPathEvent> value) {
        events = value;
    }

    public final HashSet<Integer> getMapIds() {
        return mapIds;
    }

    public final void setMapIds(HashSet<Integer> value) {
        mapIds = value;
    }

    public final Position computePosition(int time, tangible.OutObject<TransportMovementState> moveState, tangible.OutObject<Integer> legIndex) {
        moveState.outArgValue = TransportMovementState.Moving;
        legIndex.outArgValue = 0;

        time %= getTotalPathTime();

        // find leg
        var leg = getLegForTime(time);

        if (leg == null) {
            return null;
        }

        // find segment
        var prevSegmentTime = leg.getStartTimestamp();
        var segmentIndex = 0;
        var distanceMoved = 0.0;
        var isOnPause = false;

        for (segmentIndex = 0; segmentIndex < leg.segments.size() - 1; ++segmentIndex) {
            var segment = leg.segments.get(segmentIndex);

            if (time < segment.getSegmentEndArrivalTimestamp()) {
                break;
            }

            distanceMoved = segment.getDistanceFromLegStartAtEnd();

            if (time < segment.getSegmentEndArrivalTimestamp() + segment.getDelay()) {
                isOnPause = true;

                break;
            }

            prevSegmentTime = segment.getSegmentEndArrivalTimestamp() + segment.getDelay();
        }

        var pathSegment = leg.segments.get(segmentIndex);

        if (!isOnPause) {
            distanceMoved += calculateDistanceMoved((double) (time - prevSegmentTime) * 0.001, (double) (pathSegment.getSegmentEndArrivalTimestamp() - prevSegmentTime) * 0.001, segmentIndex == 0, segmentIndex == leg.segments.size() - 1);
        }

        var splineIndex = 0;
        float splinePointProgress = 0;
        tangible.RefObject<Integer> tempRef_splineIndex = new tangible.RefObject<Integer>(splineIndex);
        tangible.RefObject<Float> tempRef_splinePointProgress = new tangible.RefObject<Float>(splinePointProgress);
        leg.getSpline().computeIndex((float) Math.min(distanceMoved / leg.getSpline().length(), 1.0), tempRef_splineIndex, tempRef_splinePointProgress);
        splinePointProgress = tempRef_splinePointProgress.refArgValue;
        splineIndex = tempRef_splineIndex.refArgValue;

        Vector3 pos;
        tangible.OutObject<Vector3> tempOut_pos = new tangible.OutObject<Vector3>();
        leg.getSpline().evaluate_Percent(splineIndex, splinePointProgress, tempOut_pos);
        pos = tempOut_pos.outArgValue;
        Vector3 dir;
        tangible.OutObject<Vector3> tempOut_dir = new tangible.OutObject<Vector3>();
        leg.getSpline().evaluate_Derivative(splineIndex, splinePointProgress, tempOut_dir);
        dir = tempOut_dir.outArgValue;

        moveState.outArgValue = isOnPause ? TransportMovementState.WaitingOnPauseWaypoint : TransportMovementState.Moving;
        legIndex.outArgValue = getPathLegs().indexOf(leg);

        return new Position(pos.X, pos.Y, pos.Z, (float) Math.atan2(dir.Y, dir.X) + (float) Math.PI);
    }

    public final TransportPathLeg getLegForTime(int time) {
        var legIndex = 0;

        while (getPathLegs().get(legIndex).getStartTimestamp() + getPathLegs().get(legIndex).getDuration() <= time) {
            ++legIndex;

            if (legIndex >= getPathLegs().size()) {
                return null;
            }
        }

        return getPathLegs().get(legIndex);
    }

    public final int getNextPauseWaypointTimestamp(int time) {
        var leg = getLegForTime(time);

        if (leg == null) {
            return time;
        }

        var segmentIndex = 0;

        for (; segmentIndex != leg.segments.size() - 1; ++segmentIndex) {
            if (time < leg.segments.get(segmentIndex).getSegmentEndArrivalTimestamp() + leg.segments.get(segmentIndex).getDelay()) {
                break;
            }
        }

        return leg.segments.get(segmentIndex).getSegmentEndArrivalTimestamp() + leg.segments.get(segmentIndex).getDelay();
    }

    private double calculateDistanceMoved(double timePassedInSegment, double segmentDuration, boolean isFirstSegment, boolean isLastSegment) {
        if (isFirstSegment) {
            if (!isLastSegment) {
                var accelerationTime = Math.min(getAccelerationTime(), segmentDuration);
                var segmentTimeAtFullSpeed = segmentDuration - accelerationTime;

                if (timePassedInSegment <= segmentTimeAtFullSpeed) {
                    return timePassedInSegment * getSpeed();
                } else {
                    var segmentAccelerationTime = timePassedInSegment - segmentTimeAtFullSpeed;
                    var segmentAccelerationDistance = getAccelerationRate() * accelerationTime;
                    var segmentDistanceAtFullSpeed = segmentTimeAtFullSpeed * getSpeed();

                    return (2.0 * segmentAccelerationDistance - segmentAccelerationTime * getAccelerationRate()) * 0.5 * segmentAccelerationTime + segmentDistanceAtFullSpeed;
                }
            }

            return timePassedInSegment * getSpeed();
        }

        if (isLastSegment) {
            if (!isFirstSegment) {
                if (timePassedInSegment <= Math.min(getAccelerationTime(), segmentDuration)) {
                    return getAccelerationRate() * timePassedInSegment * 0.5 * timePassedInSegment;
                } else {
                    return (timePassedInSegment - getAccelerationTime()) * getSpeed() + getAccelerationDistance();
                }
            }

            return timePassedInSegment * getSpeed();
        }

        var accelerationTime1 = Math.min(segmentDuration * 0.5, getAccelerationTime());

        if (timePassedInSegment <= segmentDuration - accelerationTime1) {
            if (timePassedInSegment <= accelerationTime1) {
                return getAccelerationRate() * timePassedInSegment * 0.5 * timePassedInSegment;
            } else {
                return (timePassedInSegment - getAccelerationTime()) * getSpeed() + getAccelerationDistance();
            }
        } else {
            var segmentTimeSpentAccelerating = timePassedInSegment - (segmentDuration - accelerationTime1);

            return (segmentDuration - 2 * accelerationTime1) * getSpeed() + getAccelerationRate() * accelerationTime1 * 0.5 * accelerationTime1 + (2.0 * getAccelerationRate() * accelerationTime1 - segmentTimeSpentAccelerating * getAccelerationRate()) * 0.5 * segmentTimeSpentAccelerating;
        }
    }
}
