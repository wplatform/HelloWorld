package com.github.azeroth.cache;


public interface CacheProvider {

    <T extends DbcEntity> DbcEntityStore<T> newDbcEntityStore(Class<T> clazz);
    <K, V> MapCache<K, V> newGenericMapCache(String cacheName, Class<K> keyClazz, Class<V> valueClazz);
    <K, V> MapCache<K, V> newGenericMapCache(String cacheName, TypeReference<K, V> valueClazz);

}

