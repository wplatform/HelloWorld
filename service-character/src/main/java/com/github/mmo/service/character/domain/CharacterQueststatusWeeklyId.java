package com.github.mmo.service.character.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CharacterQueststatusWeeklyId implements Serializable {
    public Long guid;

    public Long quest;


}