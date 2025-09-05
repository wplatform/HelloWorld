package com.github.azeroth.game.entity.object.update;

public class UpdateFieldString implements UpdateFieldRef<String> {
    public String value;
    public int blockBit;
    public int bit;

    public updateFieldString(int blockBit, int bit) {
        blockBit = blockBit;
        bit = bit;
        value = "";
    }

    public final String get() {
        return value;
    }

    public final void set(String value) {
        value = value;
    }


//	public static implicit operator string(UpdateFieldString updateField)
//		{
//			return updateField.value;
//		}
}
