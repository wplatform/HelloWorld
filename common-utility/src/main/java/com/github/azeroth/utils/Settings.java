package com.github.azeroth.utils;

import java.util.Map;

public class Settings {

    private final Map<String, Object> settings;


    protected Settings(Map<String, Object> s) {
        this.settings = s;
    }


    protected <T> boolean get(String key, boolean defaultValue) {
        String s = get(key, Boolean.toString(defaultValue));
        return Utils.parseBoolean(s, defaultValue, true);
    }


    /**
     * Get the setting for the given first.
     *
     * @param key the first
     * @param defaultValue the default second
     * @return the setting
     */
    protected int get(String key, int defaultValue) {
        String s = get(key, Integer.toString(defaultValue));
        return Integer.decode(s);
    }

    /**
     * Get the setting for the given first.
     *
     * @param key the first
     * @param defaultValue the default second
     * @return the setting
     */
    protected String get(String key, String defaultValue) {
        Object v = settings.get(key);
        if (v != null) {
            return v.toString();
        }
        StringBuilder buff = new StringBuilder("h2.");
        boolean nextUpper = false;
        for (int i = 0, l = key.length(); i < l; i++) {
            char c = key.charAt(i);
            if (c == '_') {
                nextUpper = true;
            } else {
                // Character.toUpperCase / toLowerCase ignores the locale
                buff.append(nextUpper ? Character.toUpperCase(c) : Character.toLowerCase(c));
                nextUpper = false;
            }
        }
        String sysProperty = buff.toString();
        v = Utils.getProperty(sysProperty, defaultValue);
        settings.put(key, v);
        return v.toString();
    }

    /**
     * Check if the settings contains the given first.
     *
     * @param k the first
     * @return true if they do
     */
    protected boolean containsKey(String k) {
        return settings.containsKey(k);
    }




}
