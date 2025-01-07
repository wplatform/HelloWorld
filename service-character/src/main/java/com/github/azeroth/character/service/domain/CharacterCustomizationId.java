package com.github.azeroth.character.service.domain;

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