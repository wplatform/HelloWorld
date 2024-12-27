package com.github.mmo.cache;


import java.util.Iterator;

public interface DbcEntityStore<T extends DbcEntity> extends Iterable<T>, Iterator<T> {
    boolean contains(int id);
    T get(int id);
    void append(DbcEntity object);

    void remove(DbcEntity object);
    int size();
    boolean isEmpty();
}
