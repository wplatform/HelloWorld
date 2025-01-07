package com.github.azeroth.cache;

import com.github.azeroth.utils.FuryUtil;
import lombok.RequiredArgsConstructor;
import org.h2.mvstore.MVMap;

import java.util.*;

class GenericMapCache<K, V> implements MapCache<K, V> {

    private final MVMap<byte[],byte[]> mvMap;
    private final Class<K> keyClazz;
    private final Class<V> valueClazz;

    GenericMapCache(MVMap<byte[],byte[]> mvMap, Class<K> keyClazz, Class<V> valueClazz) {
        this.mvMap = mvMap;
        this.keyClazz = keyClazz;
        this.valueClazz = valueClazz;
        FuryUtil.FURY.register(keyClazz);
        FuryUtil.FURY.register(valueClazz);
    }

    GenericMapCache(MVMap<byte[],byte[]> mvMap, TypeReference<K, V> typeReference) {
        this(mvMap, typeReference.getKeyType(), typeReference.getValueType());
    }

    public int size() {
        return mvMap.size();
    }

    public boolean isEmpty() {
        return mvMap.isEmpty();
    }

    public boolean containsKey(Object key) {
        byte[] bytes = FuryUtil.serializeIntKey(key);
        return mvMap.containsKey(bytes);
    }

    public boolean containsValue(Object value) {
        byte[] bytes = FuryUtil.serializeIntKey(value);
        return mvMap.containsValue(bytes);
    }
    @Override
    public V get(Object key) {
        byte[] bytes = FuryUtil.serializeIntKey(key);
        byte[] valueByte = mvMap.get(bytes);
        return FuryUtil.deserialize(valueByte, valueClazz);
    }
    @Override
    public V put(K key, V value) {
        byte[] keyByte = FuryUtil.serializeIntKey(key);
        byte[] valueByte = FuryUtil.serializeIntKey(value);
        byte[] bytes = mvMap.put(keyByte, valueByte);
        if(bytes != null) {
            return FuryUtil.deserialize(bytes, valueClazz);
        }
        return null;
    }
    @Override
    public V remove(Object key) {
        byte[] bytes = FuryUtil.serializeIntKey(key);
        byte[] valueBytes = mvMap.remove(bytes);
        if(valueBytes != null) {
            return FuryUtil.deserialize(bytes, valueClazz);
        }
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> m) {

        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            byte[] keyByte = FuryUtil.serializeIntKey(key);
            byte[] valueByte = FuryUtil.serializeIntKey(value);
            mvMap.put(keyByte, valueByte);
        }

    }

    public void clear() {
        mvMap.clear();
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new EntrySet(mvMap.entrySet());
    }


    @RequiredArgsConstructor
    class EntrySet extends AbstractSet<Map.Entry<K, V>> {

        final Set<Map.Entry<byte[], byte[]>> entries;

        @Override
        public Iterator<Map.Entry<K, V>> iterator() {
            return new MVMapItr(entries.iterator());
        }

        @Override
        public int size() {
            return entries.size();
        }
    }


    @RequiredArgsConstructor
    class MVMapItr implements Iterator<Map.Entry<K, V>> {

        final Iterator<Map.Entry<byte[], byte[]>> iterator;

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Entry<K, V> next() {
            Map.Entry<byte[], byte[]> next = iterator.next();
            return new Entry<>(FuryUtil.deserialize(next.getValue(), keyClazz), FuryUtil.deserialize(next.getValue(), valueClazz));
        }
    }
}
