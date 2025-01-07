package com.github.azeroth.game.entity;

public class UpdateFieldString implements IUpdateField<String> {
    public String value;
    public int blockBit;
    public int bit;

    public updateFieldString(int blockBit, int bit) {
        blockBit = blockBit;
        bit = bit;
        value = "";
    }

    public final String getValue() {
        return value;
    }

    public final void setValue(String value) {
        value = value;
    }

// C# TO JAVA CONVERTER TASK: The following operator overload is not converted by C# to Java Converter:
//	public static implicit operator string(UpdateFieldString updateField)
//		{
//			return updateField.value;
//		}
}
