package com.rainbowland.core.utils;

import com.rainbowland.core.BaseSystem;
import com.rainbowland.core.World;
import com.rainbowland.core.annotations.Profile;


/**
 * @see Profile
 */
public interface ArtemisProfiler {
	void start();
	void stop();
	void initialize(BaseSystem owner, World world);
}