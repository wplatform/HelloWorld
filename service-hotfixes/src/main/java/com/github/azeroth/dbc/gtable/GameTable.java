package com.github.azeroth.dbc.gtable;

public interface GameTable<T> {

    T getRow(int row);
    int rowCount();

}
