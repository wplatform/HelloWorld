package com.rainbowland.service.cache;

import com.rainbowland.utils.SysProperties;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;
import javax.cache.spi.CachingProvider;
import java.net.URI;
import java.util.Map;
import java.util.Properties;

class MapdbCacheManager implements CacheManager {

    private final DB db = DBMaker.fileDB(SysProperties.CACHE_PERSISTENCE_FILE_NAME)
            .readOnly()
            .fileMmapEnableIfSupported()
            .fileMmapPreclearDisable()
            .cleanerHackEnable()
            .closeOnJvmShutdown()
            .fileDeleteAfterOpen()
            .concurrencyScale(16)
            .make();

    private final Map<String, MapdbCache<?, ?>> caches;
    private final MapdbCachingProvider cacheProvider;
    private final Properties properties;
    private final URI uri = URI.create(MapdbCacheManager.class.getName());

    MapdbCacheManager(Map<String, MapdbCache<?, ?>> caches, MapdbCachingProvider cacheProvider, Properties properties) {
        this.caches = caches;
        this.cacheProvider = cacheProvider;
        this.properties = properties;
    }

    @Override
    public CachingProvider getCachingProvider() {
        return this.cacheProvider;
    }

    @Override
    public URI getURI() {
        return uri;
    }

    @Override
    public ClassLoader getClassLoader() {
        return getClass().getClassLoader();
    }

    @Override
    public Properties getProperties() {
        return new Properties();
    }

    @Override
    public <K, V, C extends Configuration<K, V>> Cache<K, V> createCache(String cacheName, C configuration) throws IllegalArgumentException {
        return null;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String cacheName, Class<K> keyType, Class<V> valueType) {
        return null;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String cacheName) {
        return null;
    }

    @Override
    public Iterable<String> getCacheNames() {
        return caches.keySet();
    }

    @Override
    public void destroyCache(String cacheName) {

    }

    @Override
    public void enableManagement(String cacheName, boolean enabled) {

    }

    @Override
    public void enableStatistics(String cacheName, boolean enabled) {

    }

    @Override
    public void close() {

    }

    @Override
    public boolean isClosed() {
        return false;
    }

    @Override
    public <T> T unwrap(Class<T> clazz) {
        return null;
    }

}
