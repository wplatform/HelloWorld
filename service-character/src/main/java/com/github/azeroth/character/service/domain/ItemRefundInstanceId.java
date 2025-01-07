package com.github.azeroth.character.service.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemRefundInstanceId implements Serializable {
    public Long itemGuid;

    public Long playerGuid;


}