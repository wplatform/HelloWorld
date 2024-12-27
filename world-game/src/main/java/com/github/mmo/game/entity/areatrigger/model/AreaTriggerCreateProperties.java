package com.github.mmo.game.entity.areatrigger.model;

import com.github.mmo.common.EnumFlag;
import com.github.mmo.game.entity.areatrigger.AreaTriggerDefine;
import com.github.mmo.game.entity.object.Position;

import java.util.ArrayList;

public class AreaTriggerCreateProperties {

//	AreaTriggerCreateProperties();

//	public final void close();

// C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:

//	boolean HasSplines();

    public AreaTriggerDefine.AreaTriggerId Id = new AreaTriggerDefine.AreaTriggerId();
    public AreaTriggerDefine.AreaTriggerTemplate Template;
    public EnumFlag<AreaTriggerCreatePropertiesFlag> Flags = EnumFlag.of(AreaTriggerCreatePropertiesFlag.class);


    public int MoveCurveId;

    public int ScaleCurveId;

    public int MorphCurveId;

    public int FacingCurveId;

    public int AnimId;
    public int AnimKitId;


    public int DecalPropertiesId;


    public int TimeToTarget;

    public int TimeToTargetScale;

    public AreaTriggerDefine.AreaTriggerScaleCurveTemplate OverrideScale;
    public AreaTriggerDefine.AreaTriggerScaleCurveTemplate ExtraScale;

    public AreaTriggerShapeInfo Shape = new AreaTriggerShapeInfo();

    public ArrayList<Position> SplinePoints = new ArrayList<>();
    public AreaTriggerDefine.AreaTriggerOrbitInfo OrbitInfo;


    public int ScriptId;
}
