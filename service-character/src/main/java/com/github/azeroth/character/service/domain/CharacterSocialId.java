package com.github.azeroth.character.service.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CharacterSocialId implements Serializable {
    public Long guid;

    public Long friend;

    public Short flags;


}