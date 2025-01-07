package com.github.azeroth.game.map.collision.model;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.collision.BoundingBox;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class ModelSpawn extends ModelMinimalData {
    public Vector3 iRot;

    public ModelSpawn() {
    }

    public ModelSpawn(ModelSpawn spawn) {
        flags = spawn.flags;
        adtId = spawn.adtId;
        id = spawn.id;
        iPos = spawn.iPos;
        iRot = spawn.iRot;
        iScale = spawn.iScale;
        iBound = spawn.iBound;
        name = spawn.name;
    }

    public static boolean readFromFile(ByteBuffer buffer, ModelSpawn spawn) throws IOException {


        spawn.flags = buffer.get();
        spawn.adtId = buffer.get();
        spawn.id = buffer.getInt();
        spawn.iPos = new Vector3(buffer.getFloat(), buffer.getFloat(), buffer.getFloat());
        spawn.iRot = new Vector3(buffer.getFloat(), buffer.getFloat(), buffer.getFloat());
        spawn.iScale = buffer.getFloat();

        var has_bound = (spawn.flags & ModelFlags.HasBound.value) != 0;

        if (has_bound) // only WMOs have bound in MPQ, only available after computation
        {

            var bLow = new Vector3(buffer.getFloat(), buffer.getFloat(), buffer.getFloat());
            var bHigh = new Vector3(buffer.getFloat(), buffer.getFloat(), buffer.getFloat());
            spawn.iBound = new BoundingBox(bLow, bHigh);
        }
        byte[] stringBytes = new byte[buffer.get()];
        buffer.get(stringBytes);
        spawn.name = new String(buffer.array(), StandardCharsets.UTF_8);

        return true;
    }
}
