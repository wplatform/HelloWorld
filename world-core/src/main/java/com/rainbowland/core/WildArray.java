package com.rainbowland.core;

import com.rainbowland.core.utils.Array;


/**
 * Let the user set the size.
 * <p>
 * Setting the size does not resize the bag, nor will it clean up contents
 * beyond the given size. Only use this if you know what you are doing!
 * </p>
 *
 * @author junkdog
 *
 * @param <T> object type this bag holds
 */
class WildArray<T> extends Array<T> {


	public WildArray(Class<T> type) {
		super(type);
	}

	/**
	 * Set the size.
	 * <p>
	 * This will not resize the bag, nor will it clean up contents beyond the
	 * given size. Use with caution.
	 * </p>
	 *
	 * @param size the size to set
	 */
	void setSize(int size) {
		this.size = size;
	}

}
