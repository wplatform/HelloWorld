package com.github.azeroth.game.domain.areatrigger;

import com.github.azeroth.common.EnumFlag;
import com.github.azeroth.game.domain.object.Position;

import java.util.ArrayList;
import java.util.List;

public class AreaTriggerCreateProperty {


    public AreaTriggerId id;
    public AreaTriggerId templateId;
    public AreaTriggerTemplate Template;
    public EnumFlag<AreaTriggerCreatePropertiesFlag> Flags;


    public int MoveCurveId;

    public int ScaleCurveId;

    public int MorphCurveId;

    public int FacingCurveId;

    public int AnimId;
    public int AnimKitId;


    public int DecalPropertiesId;

    public Integer SpellForVisuals;

    public int TimeToTarget;

    public int TimeToTargetScale;

    public float Speed;

    public AreaTriggerScaleCurveTemplate OverrideScale;
    public AreaTriggerScaleCurveTemplate ExtraScale;

    public AreaTriggerShapeInfo Shape = new AreaTriggerShapeInfo();

    public List<Position> SplinePoints = new ArrayList<>();
    public AreaTriggerOrbitInfo OrbitInfo;


    public int ScriptId;
    public String scriptName;

    public boolean HasSplines() {
        return SplinePoints.size() >= 2;
    }
}
