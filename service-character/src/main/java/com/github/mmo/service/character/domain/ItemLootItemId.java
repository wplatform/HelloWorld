package com.github.mmo.service.character.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemLootItemId implements Serializable {
    public Long containerId;

    public Byte itemType;

    public Long itemId;


}