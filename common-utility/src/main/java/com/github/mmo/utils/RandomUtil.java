package com.github.mmo.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RandomUtil {

    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static boolean randomBoolean() {
        return SECURE_RANDOM.nextBoolean();
    }
    public static byte[] randomBytes(int count) {
        byte[] bytes = new byte[count];
        SECURE_RANDOM.nextBytes(bytes);
        return bytes;
    }
    public static double randomDouble() {
        return SECURE_RANDOM.nextDouble();
    }
    public static double randomDouble(double startInclusive, double endExclusive) {
        return SECURE_RANDOM.nextDouble() * (endExclusive - startInclusive);
    }
    public static float randomFloat() {
        return SECURE_RANDOM.nextFloat();
    }
    public static float randomFloat(float startInclusive, float endExclusive) {
        return SECURE_RANDOM.nextFloat() * (endExclusive - startInclusive);
    }
    public static int randomInt() {
        return SECURE_RANDOM.nextInt();
    }
    public static int randomInt(int startInclusive, int endExclusive) {
        return SECURE_RANDOM.nextInt(endExclusive - startInclusive) + startInclusive;
    }
    public static long randomLong() {
        return SECURE_RANDOM.nextLong();
    }
    public static long randomLong(long startInclusive, long endExclusive) {
        return SECURE_RANDOM.nextLong() * (endExclusive - startInclusive);
    }



}
