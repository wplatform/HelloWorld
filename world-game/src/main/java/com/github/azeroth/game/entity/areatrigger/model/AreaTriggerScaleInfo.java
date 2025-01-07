package com.github.azeroth.game.entity.areatrigger.model;


/**
 * 6 bool is_override, only valid for AREATRIGGER_OVERRIDE_SCALE_CURVE, if true then use data from AREATRIGGER_OVERRIDE_SCALE_CURVE instead of ScaleCurveId from CreateObject
 */
// C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
public class AreaTriggerScaleInfo {
    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public StructuredData structured = new StructuredData();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public RawData raw = new rawData();

    // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
    public final static class StructuredData {
        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        public int startTimeOffset;

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        public float X;

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        public float Y;

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        public float Z;

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        public float W;

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
        public int curveParameters;

        // C# TO JAVA CONVERTER TASK: Java annotations will not correspond to .NET attributes:
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

// C# TO JAVA CONVERTER TASK: C# 'unsafe' code is not converted by C# to Java Converter:
//	public unsafe struct RawData
//		{
//			public fixed uint Data[SharedConst.MaxAreatriggerScale];
//		}
}
