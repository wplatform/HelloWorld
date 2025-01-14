package com.github.azeroth.game.entity.areatrigger.model;


/**
 * 6 bool is_override, only valid for AREATRIGGER_OVERRIDE_SCALE_CURVE, if true then use data from AREATRIGGER_OVERRIDE_SCALE_CURVE instead of ScaleCurveId from CreateObject
 */

public class AreaTriggerScaleInfo {

    public StructuredData structured = new StructuredData();


    public RawData raw = new rawData();


    public final static class StructuredData {

        public int startTimeOffset;


        public float X;


        public float Y;


        public float Z;


        public float W;


        public int curveParameters;


        public int overrideActive;

        public StructuredData clone() {
            StructuredData varCopy = new structuredData();

            varCopy.startTimeOffset = this.startTimeOffset;
            varCopy.X = this.X;
            varCopy.Y = this.Y;
            varCopy.Z = this.Z;
            varCopy.W = this.W;
            varCopy.curveParameters = this.curveParameters;
            varCopy.overrideActive = this.overrideActive;

            return varCopy;
        }

        public final static class curveparameters {
            public int raw;

            public int getNoData() {
                return raw & 1;
            }

            public int getInterpolationMode() {
                return (raw & 0x7) << 1;
            }

            public int getFirstPointOffset() {
                return (raw & 0x7FFFFF) << 4;
            }

            public int getPointCount() {
                return (raw & 0x1F) << 27;
            }

            public curveparameters clone() {
                curveparameters varCopy = new curveparameters();

                varCopy.raw = this.raw;

                return varCopy;
            }
        }
    }


//	public unsafe struct RawData
//		{
//			public fixed uint Data[SharedConst.MaxAreatriggerScale];
//		}
}
