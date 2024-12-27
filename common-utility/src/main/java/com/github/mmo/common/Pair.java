package com.github.mmo.common;

public record Pair<K extends Comparable<K>, V extends Comparable<V>>(K key, V value) implements Comparable<Pair<K, V>> {

    public static <K extends Comparable<K>, V extends Comparable<V>> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }

    @Override
    public int compareTo(Pair<K, V> o) {
        int result = this.key.compareTo(o.key);
        if (result == 0) {
            result = this.value.compareTo(o.value);
        }
        return result;

    }
}
