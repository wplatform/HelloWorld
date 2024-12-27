package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@IdClass(AuctionBidderId.class)
@Entity
@Table(name = "auction_bidders")
public class AuctionBidder {
    @Id
    @Column(name = "auctionId", columnDefinition = "int UNSIGNED not null")
    private Integer auctionId;

    @Id
    @Column(name = "playerGuid", nullable = false)
    private Integer playerGuid;

}