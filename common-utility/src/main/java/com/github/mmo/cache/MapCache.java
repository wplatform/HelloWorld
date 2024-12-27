package com.github.mmo.cache;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Map;


public interface MapCache<K, V> extends Map<K, V> {

    @Getter
    @Setter
    @RequiredArgsConstructor
    class Entry<K, V> implements Map.Entry<K, V> {
        public final K key;
        public final V value;

        @Override
        public V setValue(V value) {
            return null;
        }
    }

}
