package com.rainbowland.service.cache;

import javax.cache.CacheManager;
import javax.cache.configuration.OptionalFeature;
import javax.cache.spi.CachingProvider;
import java.net.URI;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;

public class MapdbCachingProvider implements CachingProvider {

    private final Map<ClassLoader, Map<URI, CacheManager>> cacheManagers;

    public MapdbCachingProvider() {
        this.cacheManagers = new WeakHashMap<>(1);
    }


    @Override
    public CacheManager getCacheManager(URI uri, ClassLoader classLoader, Properties properties) {
        return null;
    }

    @Override
    public ClassLoader getDefaultClassLoader() {
        return null;
    }

    @Override
    public URI getDefaultURI() {
        return URI.create(getClass().getName());
    }

    @Override
    public Properties getDefaultProperties() {
        return new Properties();
    }

    @Override
    public CacheManager getCacheManager(URI uri, ClassLoader classLoader) {
        return null;
    }

    @Override
    public CacheManager getCacheManager() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void close(ClassLoader classLoader) {

    }

    @Override
    public void close(URI uri, ClassLoader classLoader) {

    }

    @Override
    public boolean isSupported(OptionalFeature optionalFeature) {
        return false;
    }
}
