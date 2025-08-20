package com.github.azeroth.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public static <T> T random(List<T> collection) {
        if(collection == null ||collection.isEmpty()) {
            return null;
        }
        // If only one element, ignore the probability (even if 0)
        if(collection.size() == 1) {
            return collection.getFirst();
        }

        int index = randomInt(0, collection.size());
        return collection.get(index);
    }

    public static <T> T randomByWeight(Collection<T> collection, Function<T, Float> eleWeight) {
        if(collection == null ||collection.isEmpty()) {
            return null;
        }
        // If only one element, ignore the probability (even if 0)
        if(collection.size() == 1) {
            return collection.iterator().next();
        }
        float totalWeight = collection.stream().map(eleWeight).filter(weight -> weight >= 0f).reduce(0f, Float::sum);

        if (totalWeight <= 0f) {
            return null;
        }

        float randomFloat = randomFloat(0f, totalWeight);
        float currentWeight = 0f;

        for (T element : collection) {
            float weight = eleWeight.apply(element);
            if (weight >= 0f) {
                currentWeight += weight;
                if (randomFloat <= currentWeight) {
                    return element;
                }
            }
        }

        return null;
    }
}
