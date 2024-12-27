package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "item_soulbound_trade_data")
public class ItemSoulboundTradeDatum {
    @Id
    @Column(name = "itemGuid", nullable = false)
    private Long id;

    @Lob
    @Column(name = "allowedPlayers", nullable = false)
    private String allowedPlayers;

}