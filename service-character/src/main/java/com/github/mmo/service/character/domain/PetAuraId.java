package com.github.mmo.service.character.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PetAuraId implements Serializable {
    public Long guid;

    public Long spell;

    public Long effectMask;


}