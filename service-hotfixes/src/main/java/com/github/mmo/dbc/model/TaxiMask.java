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
        return _data.size();
    }
    // C++ TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
// ORIGINAL LINE: uint8 const* data() const
// C++ TO JAVA CONVERTER WARNING: 'const' methods are not available in Java:
// ORIGINAL LINE: byte const* data() const
// C++ TO JAVA CONVERTER WARNING: Java has no equivalent to methods returning pointers to value types:
    public final byte data()
    {
        return data.data();
    }



    // C++ TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
// ORIGINAL LINE: std::vector<uint8> _data;
    private byte[] data = new byte[16];
}
