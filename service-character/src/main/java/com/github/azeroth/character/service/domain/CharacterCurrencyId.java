package com.github.azeroth.character.service.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CharacterCurrencyId implements Serializable {
    public Long characterGuid;

    public Integer currency;


}