package com.github.mmo.service.character.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "blackmarket_auctions")
public class BlackmarketAuction {
    @Id
    @ColumnDefault("0")
    @Column(name = "marketId", nullable = false)
    private Integer id;

    @ColumnDefault("'0'")
    @Column(name = "currentBid", nullable = false)
    private Integer currentBid;

    @ColumnDefault("0")
    @Column(name = "time", nullable = false)
    private Instant time;

    @ColumnDefault("0")
    @Column(name = "numBids", nullable = false)
    private Integer numBids;

    @ColumnDefault("'0'")
    @Column(name = "bidder", nullable = false)
    private Integer bidder;

}