package com.github.mmo.cache;

import com.github.mmo.utils.FuryUtil;
import lombok.NonNull;
import org.h2.mvstore.Cursor;
import org.h2.mvstore.MVMap;

import java.util.Iterator;

class DbcEntityFileStore<T extends DbcEntity> implements DbcEntityStore<T>, Iterator<T> {

    private final Class<T> clazz;
    private final MVMap<Integer,byte[]> mvMap;
    private Cursor<Integer, byte[]> cursor = null;


    DbcEntityFileStore(MVMap<Integer,byte[]> mvMap, Class<T> clazz) {
        this.mvMap = mvMap;
        this.clazz = clazz;
        FuryUtil.FURY.register(clazz);
    }

    @Override
    public boolean contains(int id) {
        return mvMap.containsKey(id);
    }

    @Override
    public T get(int id) {
        byte[] objectData = mvMap.get(id);
        return objectData == null ? null : FuryUtil.deserialize(objectData, clazz);
    }


    @Override
    public void append(DbcEntity object) {
        mvMap.append(object.getId(), FuryUtil.serializeIntKey(object));
    }

    @Override
    public void remove(DbcEntity object) {
        mvMap.remove(object.getId());
    }

    @Override
    @NonNull
    public Iterator<T> iterator() {
        Integer firstKey = mvMap.firstKey();
        Integer lastKey = mvMap.lastKey();
        cursor = mvMap.cursor(firstKey, lastKey, true);
        return this;
    }

    @Override
    public boolean hasNext() {
        return cursor.hasNext();
    }

    @Override
    public T next() {
        return FuryUtil.deserialize(cursor.getValue(), clazz);
    }

    @Override
    public void remove() {
        cursor.remove();
    }

    @Override
    public int size() {
        return mvMap.size();
    }

    @Override
    public boolean isEmpty() {
        return mvMap.isEmpty();
    }

}
