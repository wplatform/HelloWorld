package com.rainbowland.core.link;

import com.rainbowland.core.ComponentType;
import com.rainbowland.core.World;
import com.rainbowland.core.annotations.LinkPolicy;
import com.rainbowland.core.utils.IntArray;
import com.rainbowland.core.utils.reflect.Field;

class UniLinkSite extends LinkSite {
	UniFieldMutator fieldMutator;

	private final IntArray sourceToTarget = new IntArray();

	protected UniLinkSite(World world,
						  ComponentType type,
						  Field field) {

		super(world, type, field, LinkPolicy.Policy.CHECK_SOURCE_AND_TARGETS);
	}

	@Override
	protected void check(int id) {
		// -1 == not linked
		int target = fieldMutator.read(mapper.get(id), field);
		if (target != -1 && !activeEntityIds.unsafeGet(target)) {
			// target is dead or linked field is set to null/-1
			target = -1;
			fieldMutator.write(target, mapper.get(id), field);
		}

		int oldTarget = sourceToTarget.get(id);
		if (target != oldTarget) {
			if (listener != null) {
				fireLinkListener(id, target);
			}

			sourceToTarget.set(id, target);
		}
	}

	private void fireLinkListener(int id, int target) {
		int oldTarget = sourceToTarget.get(id);
		if (oldTarget == -1) {
			listener.onLinkEstablished(id, target);
		} else if (target != -1) {
			listener.onTargetChanged(id, target, oldTarget);
		} else {
			listener.onTargetDead(id, oldTarget);
		}
	}

	@Override
	protected void insert(int id) {
		int target = fieldMutator.read(mapper.get(id), field);
		sourceToTarget.set(id, target);
		if (target != -1 && listener != null)
			listener.onLinkEstablished(id, target);
	}

	@Override
	protected void removed(int id) {
		int target = sourceToTarget.size() > id
			? sourceToTarget.get(id)
			: -1;

		if (target != -1)
			sourceToTarget.set(id, -1);

		if (listener != null)
			listener.onLinkKilled(id, target);
	}
}
