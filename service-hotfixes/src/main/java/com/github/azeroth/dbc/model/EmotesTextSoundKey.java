package com.github.azeroth.dbc.model;

public record EmotesTextSoundKey(int emotesTextId, byte raceId, byte SexId, byte classId) {

    public static EmotesTextSoundKey of(int emotesTextId, byte raceId, byte sexId, byte classId) {
        return new EmotesTextSoundKey(emotesTextId, raceId, sexId, classId);
    }
}
