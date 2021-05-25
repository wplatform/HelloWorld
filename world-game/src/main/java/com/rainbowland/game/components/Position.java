package com.rainbowland.game.components;

import com.badlogic.gdx.math.Vector3;
import com.rainbowland.game.core.Component;

public class Position implements Component {


    private float x;
    private float y;
    private float z;
    private float o;


    public void relocate(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void relocate(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void relocate(float x, float y, float z, float o) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.o = o;
    }

    public void relocate(Position loc) {
        relocate(loc.x, loc.y, loc.z, loc.o);
    }

    public void relocate(Vector3 pos) {
        relocate(pos.x, pos.y, pos.z);
    }

    public void relocateOffset(Position offset) {
        this.x = (float) (x + (offset.x * Math.cos(o) + offset.y * Math.sin(o + Math.PI)));
        this.y = (float) (y + (offset.y * Math.cos(o) + offset.x * Math.sin(o)));
        this.z = z + offset.z;
        this.o = o + offset.o;
    }
/*
    public boolean isPositionValid() {
        return GridDefines.IsValidMapCoord(x, y, z, o);
    }

    public float getRelativeAngle(Position pos) {
        return getAngle(pos) - o;
    }

    public float getRelativeAngle(float x, float y) {
        return getAngle(x, y) - o;
    }


    public Position getPositionOffsetTo(Position endPos) {
        Position retOffset = new Position();

        float dx = endPos.z - z;
        float dy = endPos.y - y;

        retOffset.x = (float) (dx * Math.cos(o) + dy * Math.sin(o));
        retOffset.y = (float) (dy * Math.cos(o) - dx * Math.sin(o));
        retOffset.z = endPos.z - z;
        retOffset.SetOrientation(endPos.o - o);

        return retOffset;
    }

    public Position GetPositionWithOffset(Position offset) {
        Position ret = this;
        ret.relocateOffset(offset);
        return ret;
    }

    public static float NormalizeOrientation(float o) {
        // fmod only supports positive numbers. Thus we have
        // to emulate negative numbers
        if (o < 0) {
            float mod = o * -1;
            mod = (float) (mod % (2.0f * Math.PI));
            mod = (float) (-mod + 2.0f * Math.PI);
            return mod;
        }
        return (float) (o % (2.0f * Math.PI));
    }

    public float GetExactDist(float x, float y, float z) {
        return (float) Math.sqrt(GetExactDistSq(x, y, z));
    }

    public float GetExactDist(Position pos) {
        return (float) Math.sqrt(GetExactDistSq(pos));
    }

    public float GetExactDistSq(float x, float y, float z) {
        float dz = this.z - z;

        return GetExactDist2dSq(x, y) + dz * dz;
    }

    public float GetExactDistSq(Position pos) {
        float dx = x - pos.x;
        float dy = y - pos.y;
        float dz = z - pos.z;

        return dx * dx + dy * dy + dz * dz;
    }

    public float GetExactDist2d(float x, float y) {
        return (float) Math.sqrt(GetExactDist2dSq(x, y));
    }

    public float GetExactDist2d(Position pos) {
        return (float) Math.sqrt(GetExactDist2dSq(pos));
    }

    public float GetExactDist2dSq(float x, float y) {
        float dx = this.x - x;
        float dy = this.y - y;

        return dx * dx + dy * dy;
    }

    public float GetExactDist2dSq(Position pos) {
        float dx = x - pos.x;
        float dy = y - pos.y;

        return dx * dx + dy * dy;
    }

    public float getAngle(float x, float y) {
        float dx = x - this.x;
        float dy = y - this.y;

        float ang = (float) Math.atan2(dy, dx);
        ang = ang >= 0 ? ang : (float) (2 * Math.PI + ang);
        return ang;
    }

    public float getAngle(Position pos) {
        if (pos == null)
            return 0;

        return getAngle(pos.x, pos.y);
    }

    public boolean IsInDist(float x, float y, float z, float dist) {
        return GetExactDistSq(x, y, z) < dist * dist;
    }

    public boolean IsInDist(Position pos, float dist) {
        return GetExactDistSq(pos) < dist * dist;
    }

    public boolean IsInDist2d(float x, float y, float dist) {
        return GetExactDist2dSq(x, y) < dist * dist;
    }

    public boolean IsInDist2d(Position pos, float dist) {
        return GetExactDist2dSq(pos) < dist * dist;
    }

    public void SetOrientation(float orientation) {
        o = NormalizeOrientation(orientation);
    }

    public boolean IsWithinBox(Position center, float xradius, float yradius, float zradius) {
        // rotate the WorldObject position instead of rotating the whole cube, that way we can make a simplified
        // is-in-cube check and we have to calculate only one point instead of 4

        // 2PI = 360*, keep in mind that ingame orientation is counter-clockwise
        double rotation = 2 * Math.PI - center.o;
        double sinVal = Math.sin(rotation);
        double cosVal = Math.cos(rotation);

        float BoxDistX = x - center.x;
        float BoxDistY = y - center.y;

        float rotX = (float) (center.x + BoxDistX * cosVal - BoxDistY * sinVal);
        float rotY = (float) (center.y + BoxDistY * cosVal + BoxDistX * sinVal);

        // box edges are parallel to coordiante axis, so we can treat every dimension independently :D
        float dz = GetPositionZ() - center.GetPositionZ();
        float dx = rotX - center.x;
        float dy = rotY - center.y;
        if ((Math.Abs(dx) > xradius) || (Math.Abs(dy) > yradius) || (Math.Abs(dz) > zradius))
            return false;

        return true;
    }

    public boolean IsWithinDoubleVerticalCylinder(Position center, float radius, float height) {
        float verticalDelta = z - center.z;
        return IsInDist2d(center, radius) && Math.abs(verticalDelta) <= height;
    }

    public boolean HasInArc(float arc, Position obj, float border =2.0f) {
        // always have self in arc
        if (obj == this)
            return true;

        // move arc to range 0.. 2*pi
        arc = NormalizeOrientation(arc);

        float angle = getAngle(obj);
        angle -= o;

        // move angle to range -pi ... +pi
        angle = NormalizeOrientation(angle);
        if (angle > Math.PI)
            angle -= 2.0f * Math.PI;

        float lborder = -1 * (arc / border);                        // in range -pi..0
        float rborder = (arc / border);                             // in range 0..pi
        return ((angle >= lborder) && (angle <= rborder));
    }

    public boolean HasInLine(Position pos, float objSize, float width) {
        if (!HasInArc(Math.PI, pos))
            return false;

        width += objSize;
        float angle = GetRelativeAngle(pos);
        return Math.abs(Math.sin(angle)) * GetExactDist2d(pos.x, pos.y) < width;
    }

    public void GetSinCos(float x, float y, out float vsin, out float vcos) {
        float dx = this.x - x;
        float dy = this.y - y;

        if (Math.abs(dx) < 0.001f && Math.abs(dy) < 0.001f) {
            float angle = (float) RandomHelper.NextDouble() * Math.TwoPi;
            vcos = (float) Math.cos(angle);
            vsin = (float) Math.sin(angle);
        } else {
            float dist = (float) Math.sqrt((dx * dx) + (dy * dy));
            vcos = dx / dist;
            vsin = dy / dist;
        }
    }

    public String toString() {
        return "X: %f Y: %f Z: %f O: %f".formatted(x, y, z, o);
    }
*/
}
