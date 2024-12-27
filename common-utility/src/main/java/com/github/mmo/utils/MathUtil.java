package com.github.mmo.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MathUtil {


    public static final float E = 2.71828f;
    public static final float Log10E = 0.434294f;
    public static final float Log2E = 1.4427f;
    public static final float PI = 3.14159f;


    private static double eps(double a, double b) {
        var aa = Math.abs(a) + 1.0f;

        if (Double.isInfinite(aa))
            return 0.0000005f;

        return 0.0000005f * aa;
    }

    static double eps(float a, float b) {
        var aa = Math.abs(a) + 1.0f;

        if (Float.isInfinite(aa))
            return 0.0000005f;

        return 0.0000005f * aa;
    }

    public static boolean fuzzyEq(double a, double b) {
        return (a == b) || (Math.abs(a - b) <= eps(a, b));
    }

    public static boolean fuzzyEq(float a, float b) {
        return (a == b) || (Math.abs(a - b) <= eps(a, b));
    }

    public static boolean fuzzyGt(float a, float b) {
        return a > b + eps(a, b);
    }

    public static boolean fuzzyLt(float a, float b) {
        return a < b - eps(a, b);
    }

    public static boolean fuzzyNe(float a, float b) {
        return !fuzzyEq(a, b);
    }

    public static boolean fuzzyLe(float a, float b) {
        return a < b + eps(a, b);
    }

    public static boolean fuzzyLe(double a, double b) {
        return a < b + eps(a, b);
    }

    public static boolean fuzzyGe(float a, float b) {
        return a > b - eps(a, b);
    }





    public static int calculatePct(int value, double pct)
    {
        return (int)(value * (pct / 100.0f));
    }
    
    public static long calculatePct(long value, double pct)
    {
        return (long)(value * (pct / 100.0f));
    }

    public static double calculatePct(double value, double pct)
    {
        return (value * (pct / 100.0f));
    }
    
    public static double calculatePct(float value, double pct)
    {
        return (value * (pct / 100.0f));
    }

    public static double calculatePct(double value, float pct)
    {
        return (value * (pct / 100.0f));
    }

    public static int calculatePct(int value, float pct)
    {
        return (int)(value * (pct / 100.0f));
    }
    

    public static float calculatePct(float value, float pct)
    {
        return value * (pct / 100.0f);
    }
    

    public static long calculatePct(long value, float pct)
    {
        return (long)(value * (pct / 100.0f));
    }

    public static float GetPctOf(float value, float max)
    {
        return (value / max) * 100.0f;
    }

    public static double GetPctOf(double value, int max)
    {
        return (value / max) * 100.0f;
    }

    public static int GetPctOf(int value, int max)
    {
        return (int)(((float) value / max) * 100.0f);
    }

    public static int roundToInterval(int num, int floor, int ceil) {
        return Math.min(Math.max(num, floor), ceil);
    }


    public static float roundToInterval(float num, float floor, float ceil) {
        return Math.min(Math.max(num, floor), ceil);
    }

    public static double roundToInterval(double num, double floor, double ceil) {
        return Math.min(Math.max(num, floor), ceil);
    }

    
}
