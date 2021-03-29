package com.rainbowland.core.link;

import com.rainbowland.core.ComponentType;
import com.rainbowland.core.Entity;
import com.rainbowland.core.World;
import com.rainbowland.core.annotations.EntityId;
import com.rainbowland.core.annotations.LinkPolicy;
import com.rainbowland.core.utils.Array;
import com.rainbowland.core.utils.IntArray;
import com.rainbowland.core.utils.reflect.Annotation;
import com.rainbowland.core.utils.reflect.ClassReflection;
import com.rainbowland.core.utils.reflect.Field;

import static com.rainbowland.core.utils.reflect.ReflectionUtil.isGenericType;

class LinkFactory {
	private static final int NULL_REFERENCE = 0;
	private static final int SINGLE_REFERENCE = 1;
	private static final int MULTI_REFERENCE = 2;

	private final Array<LinkSite> links = new Array<LinkSite>();
	private final World world;

	private final ReflexiveMutators reflexiveMutators;

	public LinkFactory(World world) {
		this.world = world;
		reflexiveMutators = new ReflexiveMutators(world);
	}

	static int getReferenceTypeId(Field f) {
		Class type = f.getType();
		if (Entity.class == type)
			return SINGLE_REFERENCE;
		if (isGenericType(f, Array.class, Entity.class))
			return MULTI_REFERENCE;

		boolean explicitEntityId = f.getDeclaredAnnotation(EntityId.class) != null;
		if (int.class == type && explicitEntityId)
			return SINGLE_REFERENCE;
		if (IntArray.class == type && explicitEntityId)
			return MULTI_REFERENCE;

		return NULL_REFERENCE;
	}

	Array<LinkSite> create(ComponentType ct) {
		Class<?> type = ct.getType();
		Field[] fields = ClassReflection.getDeclaredFields(type);

		links.clear();
		for (int i = 0; fields.length > i; i++) {
			Field f = fields[i];
			int referenceTypeId = getReferenceTypeId(f);
			if (referenceTypeId != NULL_REFERENCE && (LinkPolicy.Policy.SKIP != getPolicy(f))) {
				if (SINGLE_REFERENCE == referenceTypeId) {
					UniLinkSite ls = new UniLinkSite(world, ct, f);
					if (!configureMutator(ls))
						reflexiveMutators.withMutator(ls);

					links.add(ls);
				} else if (MULTI_REFERENCE == referenceTypeId) {
					MultiLinkSite ls = new MultiLinkSite(world, ct, f);
					if (!configureMutator(ls))
						reflexiveMutators.withMutator(ls);

					links.add(ls);
				}
			}
		}

		return links;
	}

	static LinkPolicy.Policy getPolicy(Field f) {
		Annotation annotation = f.getDeclaredAnnotation(LinkPolicy.class);
		if (annotation != null) {
			LinkPolicy lp = annotation.getAnnotation(LinkPolicy.class);
			return lp != null ? lp.value() : null;
		}

		return null;
	}

	private boolean configureMutator(UniLinkSite linkSite) {
		UniFieldMutator mutator = MutatorUtil.getGeneratedMutator(linkSite);
		if (mutator != null) {
			mutator.setWorld(world);
			linkSite.fieldMutator = mutator;
			return true;
		} else {
			return false;
		}
	}

	private boolean configureMutator(MultiLinkSite linkSite) {
		MultiFieldMutator mutator = MutatorUtil.getGeneratedMutator(linkSite);
		if (mutator != null) {
			mutator.setWorld(world);
			linkSite.fieldMutator = mutator;
			return true;
		} else {
			return false;
		}
	}

	static class ReflexiveMutators {
		final EntityFieldMutator entityField;
		final IntFieldMutator intField;
		final IntBagFieldMutator intBagField;
		final EntityBagFieldMutator entityBagField;

		public ReflexiveMutators(World world) {
			entityField = new EntityFieldMutator();
			entityField.setWorld(world);

			intField = new IntFieldMutator();
			intField.setWorld(world);

			intBagField = new IntBagFieldMutator();
			intBagField.setWorld(world);

			entityBagField = new EntityBagFieldMutator();
			entityBagField.setWorld(world);
		}

		UniLinkSite withMutator(UniLinkSite linkSite) {
			if (linkSite.fieldMutator != null)
				return linkSite;

			Class type = linkSite.field.getType();
			if (Entity.class == type) {
				linkSite.fieldMutator = entityField;
			} else if (int.class == type) {
				linkSite.fieldMutator = intField;
			} else {
				throw new RuntimeException("unexpected '" + type + "', on " + linkSite.type);
			}

			return linkSite;
		}

		MultiLinkSite withMutator(MultiLinkSite linkSite) {
			if (linkSite.fieldMutator != null)
				return linkSite;

			Class type = linkSite.field.getType();
			if (IntArray.class == type) {
				linkSite.fieldMutator = intBagField;
			} else if (Array.class == type) {
				linkSite.fieldMutator = entityBagField;
			} else {
				throw new RuntimeException("unexpected '" + type + "', on " + linkSite.type);
			}

			return linkSite;
		}
	}
}
