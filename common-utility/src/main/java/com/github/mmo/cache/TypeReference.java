package com.github.mmo.cache;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


public abstract class TypeReference<K, V> {

    private final Type keyType;
    private final Type valueType;

    protected TypeReference() {
        Type superClass = getClass().getGenericSuperclass();
        if (superClass instanceof Class<?>) { // sanity check, should never happen
            throw new IllegalArgumentException("Internal error: TypeReference constructed without actual type information");
        }
        keyType = ((ParameterizedType) superClass).getActualTypeArguments()[0];
        valueType = ((ParameterizedType) superClass).getActualTypeArguments()[1];
    }


    public Class<K> getKeyType() {
        return getClassForType(keyType);
    }

    public Class<V> getValueType() {
        return getClassForType(valueType);
    }

    @SuppressWarnings("unchecked")
    private <T> Class<T> getClassForType(Type type) {
        if (type instanceof Class<?> rawType) {
            return (Class<T>) rawType;
        } else if (type instanceof ParameterizedType parameterizedType) {
            return (Class<T>) parameterizedType.getRawType();
        }else if (type instanceof GenericArrayType arrayType) {
            return (Class<T>) arrayType.getGenericComponentType();
        }
        throw new IllegalArgumentException("Unrecognized Type: "+((keyType == null) ? "[null]" : keyType.toString()));
    }




}