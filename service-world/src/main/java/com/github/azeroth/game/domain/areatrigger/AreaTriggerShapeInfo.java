package com.github.azeroth.game.domain.areatrigger;

import com.badlogic.gdx.math.Vector2;
import com.github.azeroth.game.domain.object.Position;

import java.util.ArrayList;

public class AreaTriggerShapeInfo {


    public AreaTriggerShapeType Type;
    public ArrayList<Vector2> PolygonVertices = new ArrayList<>();
    public ArrayList<Vector2> PolygonVerticesTarget = new ArrayList<>();
    public DefaultData DefaultData;
    public SphereData SphereData;
    public BoxData BoxData;
// C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
    public PolygonData PolygonDatas;
    public CylinderData CylinderData;
    public DiskData DiskData;
    public BoundedPlaneData BoundedPlaneData;

    public final boolean isSphere() {
        return Type == AreaTriggerShapeType.Sphere;
    }

    public final boolean isBox() {
        return Type == AreaTriggerShapeType.Box;
    }

    public final boolean isPolygon() {
        return Type == AreaTriggerShapeType.Polygon;
    }

    public final boolean isCylinder() {
        return Type == AreaTriggerShapeType.Cylinder;
    }

    public final boolean isDisk() {
        return Type == AreaTriggerShapeType.Disk;
    }

    public final boolean isBoundedPlane() {
        return Type == AreaTriggerShapeType.BoundedPlane;
    }

    public float GetMaxSearchRadius() {
        switch (Type) {
            case AreaTriggerShapeType.Sphere:
                return Math.max(SphereData.Radius, SphereData.RadiusTarget);
            case AreaTriggerShapeType.Box:
                return (float) Math.sqrt(Math.max(BoxData.Extents[0] * BoxData.Extents[0] + BoxData.Extents[1] * BoxData.Extents[1], BoxData.ExtentsTarget[0] * BoxData.ExtentsTarget[0] + BoxData.ExtentsTarget[1] * BoxData.ExtentsTarget[1]));
            case AreaTriggerShapeType.Polygon: {
                Position center = new Position(0.0f, 0.0f);
                float maxSearchRadius = 0.0f;

                for (Vector2 vertex : PolygonVertices) {
                    maxSearchRadius = Math.max(maxSearchRadius, center.getExactDist2D(vertex.x, vertex.y));
                }

                for (Vector2 vertex : PolygonVerticesTarget) {
                    maxSearchRadius = Math.max(maxSearchRadius, center.getExactDist2D(vertex.x, vertex.y));
                }

                return maxSearchRadius;
            }
            case AreaTriggerShapeType.Cylinder:
                return Math.max(CylinderData.Radius, CylinderData.RadiusTarget);
            case AreaTriggerShapeType.Disk:
                return Math.max(DiskData.OuterRadius, DiskData.OuterRadiusTarget);
            case AreaTriggerShapeType.BoundedPlane:
                return (float) Math.sqrt(Math.max(BoundedPlaneData.Extents[0] * BoundedPlaneData.Extents[0] / 4 + BoundedPlaneData.Extents[1] * BoundedPlaneData.Extents[1] / 4, BoundedPlaneData.ExtentsTarget[0] * BoundedPlaneData.ExtentsTarget[0] / 4 + BoundedPlaneData.ExtentsTarget[1] * BoundedPlaneData.ExtentsTarget[1] / 4));
            default:
                break;
        }

        return 0.0f;
    }


    public static class DefaultData {
        public float[] Data = new float[AreaTriggerDefine.MAX_AREATRIGGER_ENTITY_DATA];
    }

    // AREATRIGGER_TYPE_SPHERE
    public static class SphereData {
        public float Radius;
        public float RadiusTarget;
    }

    // AREATRIGGER_TYPE_BOX
    public static class BoxData {
        public float[] Extents = new float[3];
        public float[] ExtentsTarget = new float[3];
    }

    // AREATRIGGER_TYPE_POLYGON
    public static class PolygonData {
        public float Height;
        public float HeightTarget;
    }

    // AREATRIGGER_TYPE_CYLINDER
    public static class CylinderData {
        public float Radius;
        public float RadiusTarget;
        public float Height;
        public float HeightTarget;
        public float LocationZOffset;
        public float LocationZOffsetTarget;
    }

    // AREATRIGGER_TYPE_DISK
    public static class DiskData {
        public float InnerRadius;
        public float InnerRadiusTarget;
        public float OuterRadius;
        public float OuterRadiusTarget;
        public float Height;
        public float HeightTarget;
        public float LocationZOffset;
        public float LocationZOffsetTarget;
    }

    // AREATRIGGER_TYPE_BOUNDED_PLANE
    public static class BoundedPlaneData {
        public float[] Extents = new float[2];
        public float[] ExtentsTarget = new float[2];
    }


}
