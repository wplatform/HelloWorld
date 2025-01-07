package com.github.azeroth.character.service.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GameEventConditionSaveId implements Serializable {
    public Short eventEntry;

    public Long conditionId;


}