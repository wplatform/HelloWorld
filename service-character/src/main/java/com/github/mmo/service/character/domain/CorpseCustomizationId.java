package com.github.mmo.service.character.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CorpseCustomizationId implements Serializable {
    public Long ownerGuid;

    public Long chrCustomizationOptionID;


}