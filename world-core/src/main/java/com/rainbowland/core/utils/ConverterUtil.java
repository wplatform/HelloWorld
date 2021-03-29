package com.rainbowland.core.utils;

public final class ConverterUtil {
	private ConverterUtil() {}

	public static IntArray toIntBag(BitSet bs, IntArray out) {
		return bs.toIntBag(out);
	}

	public static IntArray toIntBag(java.util.BitSet bs, IntArray out) {
		if (bs.isEmpty()) {
			out.setSize(0);
			return out;
		}

		int size = bs.cardinality();
		out.setSize(size);
		out.ensureCapacity(size);

		int[] activesArray = out.getData();
		for (int i = 0, id = -1, s = size; s > i; i++) {
			id = bs.nextSetBit(id + 1);
			activesArray[i] = id;
		}

		return out;
	}

	public static BitSet toBitVector(IntArray bag, BitSet out) {
		int[] data = bag.getData();
		for (int i = 0, s = bag.size(); s > i; i++) {
			out.set(data[i]);
		}

		return out;
	}

	public static java.util.BitSet toBitSet(IntArray bag, java.util.BitSet out) {
		int[] data = bag.getData();
		for (int i = 0, s = bag.size(); s > i; i++) {
			out.set(data[i]);
		}

		return out;
	}
}