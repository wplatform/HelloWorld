package com.github.mmo.dbc.model;

public record TalentPosKey(int classId, int tierId, int columnIndex) {

    public static TalentPosKey of(int classId, int tierId, int columnIndex) {
        return new TalentPosKey(classId, tierId, columnIndex);
    }

}
