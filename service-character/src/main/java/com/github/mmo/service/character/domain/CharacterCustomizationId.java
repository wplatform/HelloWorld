package com.github.mmo.service.character.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CharacterCustomizationId implements Serializable {
    public Long guid;

    public Long chrCustomizationOptionID;


}