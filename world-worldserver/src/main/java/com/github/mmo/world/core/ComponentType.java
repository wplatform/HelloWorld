/*******************************************************************************
 * Copyright 2014 See AUTHORS file.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.github.mmo.world.core;

import com.badlogic.gdx.utils.Bits;
import com.badlogic.gdx.utils.ObjectMap;


public final class ComponentType {
    private static ObjectMap<Class<? extends Component>, ComponentType> assignedComponentTypes = new ObjectMap<Class<? extends Component>, ComponentType>();
    private static int typeIndex = 0;

    private final int index;

    private ComponentType() {
        index = typeIndex++;
    }


    public int getIndex() {
        return index;
    }


    public static ComponentType getFor(Class<? extends Component> componentType) {
        ComponentType type = assignedComponentTypes.get(componentType);

        if (type == null) {
            type = new ComponentType();
            assignedComponentTypes.put(componentType, type);
        }

        return type;
    }


    public static int getIndexFor(Class<? extends Component> componentType) {
        return getFor(componentType).getIndex();
    }


    public static Bits getBitsFor(Class<? extends Component>... componentTypes) {
        Bits bits = new Bits();

        int typesLength = componentTypes.length;
        for (int i = 0; i < typesLength; i++) {
            bits.set(ComponentType.getIndexFor(componentTypes[i]));
        }

        return bits;
    }

    @Override
    public int hashCode() {
        return index;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ComponentType other = (ComponentType) obj;
        return index == other.index;
    }
}
