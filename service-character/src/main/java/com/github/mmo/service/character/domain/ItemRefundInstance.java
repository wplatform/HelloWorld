package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(ItemRefundInstanceId.class)
@Entity
@Table(name = "item_refund_instance")
public class ItemRefundInstance {
    @Id
    @Column(name = "item_guid", nullable = false)
    private Long itemGuid;

    @Id
    @Column(name = "player_guid", nullable = false)
    private Long playerGuid;

    @ColumnDefault("'0'")
    @Column(name = "paidMoney", nullable = false)
    private Long paidMoney;

    @ColumnDefault("'0'")
    @Column(name = "paidExtendedCost", columnDefinition = "smallint UNSIGNED not null")
    private Integer paidExtendedCost;

}