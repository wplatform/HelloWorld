package com.rainbowland.core.annotations;

import com.rainbowland.core.EntitySubscription.SubscriptionListener;
import com.rainbowland.core.utils.IntArray;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Extends the lifecycle of this component type, ensuring removed instances are retrievable until
 * all {@link SubscriptionListener#removed(IntArray) listeners} have been notified - regardless
 * of removal method.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface DelayedComponentRemoval {}
