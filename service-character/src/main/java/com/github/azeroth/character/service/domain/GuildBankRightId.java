package com.github.azeroth.character.service.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GuildBankRightId implements Serializable {
    public Long guildid;

    public Short tabId;

    public Short rid;


}