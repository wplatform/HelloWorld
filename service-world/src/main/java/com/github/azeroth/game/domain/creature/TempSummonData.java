package com.github.azeroth.game.domain.creature;

import com.github.azeroth.game.domain.object.enums.SummonerType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TempSummonData {
    public int summonerId;

    public SummonerType summonerType;

    public short groupId;

    public int entry;

    public float positionX;

    public float positionY;

    public float positionZ;

    public float orientation;

    public short summonType;

    public int summonTime;


}