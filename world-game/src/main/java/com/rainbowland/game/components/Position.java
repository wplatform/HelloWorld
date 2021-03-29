package com.rainbowland.game.components;

import com.rainbowland.core.Component;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Position extends Component {

    private float posX;
    private float posY;
    private float posZ;
    private float Orientation;


    public void relocate(float x, float y) {
        posX = x;
        posY = y;
    }

    public void relocate(float x, float y, float z) {
        posX = x;
        posY = y;
        posZ = z;
    }

    public void relocate(float x, float y, float z, float o) {
        posX = x;
        posY = y;
        posZ = z;
        SetOrientation(o);
    }

    public void relocate(Position loc) {
        relocate(loc.posX, loc.posY, loc.posZ, loc.Orientation);
    }

    public void relocate(Vector3 pos) {
        relocate(pos.X, pos.Y, pos.Z);
    }

    public void relocateOffset(Position offset) {
        posX = (float) (posX + (offset.posX * Math.cos(Orientation) + offset.posY * Math.sin(Orientation + Math.PI)));
        posY = (float) (posY + (offset.posY * Math.cos(Orientation) + offset.posX * Math.sin(Orientation)));
        posZ = posZ + offset.posZ;
        SetOrientation(Orientation + offset.Orientation);
    }

    public boolean isPositionValid() {
        return GridDefines.IsValidMapCoord(posX, posY, posZ, Orientation);
    }

    public float getRelativeAngle(Position pos) {
        return GetAngle(pos) - Orientation;
    }

    public float getRelativeAngle(float x, float y) {
        return GetAngle(x, y) - Orientation;
    }


    public Position getPositionOffsetTo(Position endPos) {
        Position retOffset = new Position();

        float dx = endPos.posZ - posZ;
        float dy = endPos.posY - posY;

        retOffset.posX = (float) (dx * Math.cos(Orientation) + dy * Math.sin(Orientation));
        retOffset.posY = (float) (dy * Math.cos(Orientation) - dx * Math.sin(Orientation));
        retOffset.posZ = endPos.posZ - posZ;
        retOffset.SetOrientation(endPos.Orientation - Orientation);

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
        float dz = posZ - z;

        return GetExactDist2dSq(x, y) + dz * dz;
    }

    public float GetExactDistSq(Position pos) {
        float dx = posX - pos.posX;
        float dy = posY - pos.posY;
        float dz = posZ - pos.posZ;

        return dx * dx + dy * dy + dz * dz;
    }

    public float GetExactDist2d(float x, float y) {
        return (float) Math.sqrt(GetExactDist2dSq(x, y));
    }

    public float GetExactDist2d(Position pos) {
        return (float) Math.sqrt(GetExactDist2dSq(pos));
    }

    public float GetExactDist2dSq(float x, float y) {
        float dx = posX - x;
        float dy = posY - y;

        return dx * dx + dy * dy;
    }

    public float GetExactDist2dSq(Position pos) {
        float dx = posX - pos.posX;
        float dy = posY - pos.posY;

        return dx * dx + dy * dy;
    }

    public float GetAngle(float x, float y) {
        float dx = x - posX;
        float dy = y - posY;

        float ang = (float) Math.atan2(dy, dx);
        ang = ang >= 0 ? ang : (float) (2 * Math.PI + ang);
        return ang;
    }

    public float GetAngle(Position pos) {
        if (pos == null)
            return 0;

        return GetAngle(pos.posX, pos.posY);
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
        Orientation = NormalizeOrientation(orientation);
    }

    public boolean IsWithinBox(Position center, float xradius, float yradius, float zradius) {
        // rotate the WorldObject position instead of rotating the whole cube, that way we can make a simplified
        // is-in-cube check and we have to calculate only one point instead of 4

        // 2PI = 360*, keep in mind that ingame orientation is counter-clockwise
        double rotation = 2 * Math.PI - center.Orientation;
        double sinVal = Math.sin(rotation);
        double cosVal = Math.cos(rotation);

        float BoxDistX = posX - center.posX;
        float BoxDistY = posY - center.posY;

        float rotX = (float) (center.posX + BoxDistX * cosVal - BoxDistY * sinVal);
        float rotY = (float) (center.posY + BoxDistY * cosVal + BoxDistX * sinVal);

        // box edges are parallel to coordiante axis, so we can treat every dimension independently :D
        float dz = GetPositionZ() - center.GetPositionZ();
        float dx = rotX - center.posX;
        float dy = rotY - center.posY;
        if ((Math.Abs(dx) > xradius) || (Math.Abs(dy) > yradius) || (Math.Abs(dz) > zradius))
            return false;

        return true;
    }

    public boolean IsWithinDoubleVerticalCylinder(Position center, float radius, float height) {
        float verticalDelta = posZ - center.posZ;
        return IsInDist2d(center, radius) && Math.abs(verticalDelta) <= height;
    }

    public boolean HasInArc(float arc, Position obj, float border =2.0f) {
        // always have self in arc
        if (obj == this)
            return true;

        // move arc to range 0.. 2*pi
        arc = NormalizeOrientation(arc);

        float angle = GetAngle(obj);
        angle -= Orientation;

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
        return Math.abs(Math.sin(angle)) * GetExactDist2d(pos.posX, pos.posY) < width;
    }

    public void GetSinCos(float x, float y, out float vsin, out float vcos) {
        float dx = posX - x;
        float dy = posY - y;

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
        return "X: %f Y: %f Z: %f O: %f".formatted(posX, posY, posZ, Orientation);
    }


}
