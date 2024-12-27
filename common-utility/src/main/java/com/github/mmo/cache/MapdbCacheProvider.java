package com.github.mmo.cache;

import org.h2.mvstore.MVMap;
import org.h2.mvstore.MVStore;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MapdbCacheProvider implements CacheProvider, InitializingBean, DisposableBean {

    @Value("${worldserver.datadir}")
    private String pathOfCache;

    private MVStore mvStore;



    @Override
    public <T extends DbcEntity> DbcEntityStore<T> newDbcEntityStore(Class<T> clazz) {
        MVMap<Integer, byte[]> mvMap = mvStore.openMap(clazz.getSimpleName());
        return new DbcEntityFileStore<>(mvMap, clazz);
    }

    @Override
    public <K, V> MapCache<K, V> newGenericMapCache(String cacheName, Class<K> keyClazz, Class<V> valueClazz) {
        MVMap<byte[], byte[]> mvMap = mvStore.openMap(cacheName);
        return new GenericMapCache<>(mvMap, keyClazz, valueClazz);
    }

    @Override
    public <K, V> MapCache<K, V> newGenericMapCache(String cacheName, TypeReference<K, V> typeReference) {
        MVMap<byte[], byte[]> mvMap = mvStore.openMap(cacheName);
        return new GenericMapCache<>(mvMap, typeReference);
    }

    @Override
    public void destroy() {
        if(mvStore != null) {
            mvStore.closeImmediately();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Path pathOfCacheFile = Paths.get(this.pathOfCache, "cache/metadata.db");
        if (!Files.exists(pathOfCacheFile.getParent())) {
            Files.createDirectories(pathOfCacheFile.getParent());
        }
        mvStore = new MVStore.Builder().fileName(pathOfCacheFile.toString())
                .compress()
                .cacheSize(64)
                .autoCommitBufferSize(64)
                .open();
    }
}
