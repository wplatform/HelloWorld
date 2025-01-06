package com.github.mmo.dbc.model;

import java.util.ArrayList;

public class TaxiMask {


    public final byte get(int i)
    {
        return data[i];
    }
    public final void set(int i, byte value)
    {
        data[i] = value;
    }


    public final int size()
    {
        return data.size();
    }

    public final byte[] data()
    {
        return data;
    }

    private byte[] data = new byte[16];
}
