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
@Table(name = "auctionhouse")
public class Auctionhouse {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @ColumnDefault("'0'")
    @Column(name = "auctionHouseId", columnDefinition = "int UNSIGNED not null")
    private Integer auctionHouseId;

    @ColumnDefault("'0'")
    @Column(name = "owner", nullable = false)
    private Integer owner;

    @ColumnDefault("'0'")
    @Column(name = "bidder", nullable = false)
    private Integer bidder;

    @ColumnDefault("'0'")
    @Column(name = "minBid", nullable = false)
    private Integer minBid;

    @ColumnDefault("'0'")
    @Column(name = "buyoutOrUnitPrice", nullable = false)
    private Integer buyoutOrUnitPrice;

    @ColumnDefault("'0'")
    @Column(name = "deposit", nullable = false)
    private Integer deposit;

    @ColumnDefault("'0'")
    @Column(name = "bidAmount", nullable = false)
    private Integer bidAmount;

    @ColumnDefault("0")
    @Column(name = "startTime", nullable = false)
    private Instant startTime;

    @ColumnDefault("0")
    @Column(name = "endTime", nullable = false)
    private Instant endTime;

    @ColumnDefault("'0'")
    @Column(name = "serverFlags", columnDefinition = "tinyint UNSIGNED not null")
    private Short serverFlags;

}