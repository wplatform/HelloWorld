package com.rainbowland.core;

import com.rainbowland.core.annotations.PooledWeaver;

/**
 * Components are pure data classes with optionally some helper methods.
 * <p/>
 * Extend to create your own components. Decorate with {@link PooledWeaver}
 * or manually extend {@link PooledComponent} to make the component pooled.
 *
 * @author Arni Arent
 * @see PooledComponent
 * @see PooledWeaver
 */
public abstract class Component {
}
