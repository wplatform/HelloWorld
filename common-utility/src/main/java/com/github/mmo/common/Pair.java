package com.github.mmo.common;

public record Pair<K extends Comparable<K>, V extends Comparable<V>>(K first, V second) implements Comparable<Pair<K, V>> {

    public static <K extends Comparable<K>, V extends Comparable<V>> Pair<K, V> of(K key, V value) {
        return new Pair<>(key, value);
    }

    @Override
    public int compareTo(Pair<K, V> o) {
        int result = this.first.compareTo(o.first);
        if (result == 0) {
            result = this.second.compareTo(o.second);
        }
        return result;

    }
}
