package com.rainbowland.utils;

import java.lang.reflect.Constructor;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class Utils {



    public static Object newInstance(Class<?> clazz, Object... params) throws Exception {
        Constructor<?> best = null;
        int bestMatch = 0;
        Constructor<?>[] constructors = clazz.getConstructors();
        for (Constructor<?> c : constructors) {
            int p = match(c.getParameterTypes(), params);
            if (p > bestMatch) {
                bestMatch = p;
                best = c;
            }
        }
        if (best == null) {
            throw new NoSuchMethodException(clazz.toString());
        }
        return best.newInstance(params);
    }

    public static Object newInstance(String className, Object... params)
            throws Exception {
        return newInstance(Class.forName(className), params);
    }

    private static int match(Class<?>[] params, Object[] values) {
        int len = params.length;
        if (len == values.length) {
            int points = 1;
            for (int i = 0; i < len; i++) {
                Class<?> pc = getNonPrimitiveClass(params[i]);
                Object v = values[i];
                Class<?> vc = v == null ? null : v.getClass();
                if (pc == vc) {
                    points++;
                } else if (vc == null) {
                    // can't verify
                } else if (!pc.isAssignableFrom(vc)) {
                    return 0;
                }
            }
            return points;
        }
        return 0;
    }

    public static Class<?> getNonPrimitiveClass(Class<?> clazz) {
        if (!clazz.isPrimitive()) {
            return clazz;
        } else if (clazz == boolean.class) {
            return Boolean.class;
        } else if (clazz == byte.class) {
            return Byte.class;
        } else if (clazz == char.class) {
            return Character.class;
        } else if (clazz == double.class) {
            return Double.class;
        } else if (clazz == float.class) {
            return Float.class;
        } else if (clazz == int.class) {
            return Integer.class;
        } else if (clazz == long.class) {
            return Long.class;
        } else if (clazz == short.class) {
            return Short.class;
        } else if (clazz == void.class) {
            return Void.class;
        }
        return clazz;
    }

    /**
     * Get the system property. If the system property is not set, or if a
     * security exception occurs, the default value is returned.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value
     */
    public static String getProperty(String key, String defaultValue) {
        try {
            return System.getProperty(key, defaultValue);
        } catch (SecurityException se) {
            return defaultValue;
        }
    }

    /**
     * Get the system property. If the system property is not set, or if a
     * security exception occurs, the default value is returned.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value
     */
    public static int getProperty(String key, int defaultValue) {
        String s = getProperty(key, null);
        if (s != null) {
            try {
                return Integer.decode(s);
            } catch (NumberFormatException e) {
                // ignore
            }
        }
        return defaultValue;
    }

    /**
     * Get the system property. If the system property is not set, or if a
     * security exception occurs, the default value is returned.
     *
     * @param key the key
     * @param defaultValue the default value
     * @return the value
     */
    public static boolean getProperty(String key, boolean defaultValue) {
        return parseBoolean(getProperty(key, null), defaultValue, false);
    }

    /**
     * Parses the specified string to boolean value.
     *
     * @param value
     *            string to parse
     * @param defaultValue
     *            value to return if value is null or on parsing error
     * @param throwException
     *            throw exception on parsing error or return default value instead
     * @return parsed or default value
     * @throws IllegalArgumentException
     *             on parsing error if {@code throwException} is true
     */
    public static boolean parseBoolean(String value, boolean defaultValue, boolean throwException) {
        if (value == null) {
            return defaultValue;
        }
        switch (value.length()) {
            case 1:
                if (value.equals("1") || value.equalsIgnoreCase("t") || value.equalsIgnoreCase("y")) {
                    return true;
                }
                if (value.equals("0") || value.equalsIgnoreCase("f") || value.equalsIgnoreCase("n")) {
                    return false;
                }
                break;
            case 2:
                if (value.equalsIgnoreCase("no")) {
                    return false;
                }
                break;
            case 3:
                if (value.equalsIgnoreCase("yes")) {
                    return true;
                }
                break;
            case 4:
                if (value.equalsIgnoreCase("true")) {
                    return true;
                }
                break;
            case 5:
                if (value.equalsIgnoreCase("false")) {
                    return false;
                }
        }
        if (throwException) {
            throw new IllegalArgumentException(value);
        }
        return defaultValue;
    }


    public static String getHostString(SocketAddress socketAddress) {
        if (socketAddress instanceof InetSocketAddress) {
            InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddress;
            return inetSocketAddress.getHostString();
        } else {
            return socketAddress.toString();
        }
    }


}
