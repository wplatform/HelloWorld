package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterFavoriteAuctionId.class)
@Entity
@Table(name = "character_favorite_auctions")
public class CharacterFavoriteAuction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guid", nullable = false)
    private Integer guid;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("'0'")
    @Column(name = "`order`", columnDefinition = "int UNSIGNED not null")
    private Integer order;

    @ColumnDefault("'0'")
    @Column(name = "itemId", columnDefinition = "int UNSIGNED not null")
    private Integer itemId;

    @ColumnDefault("'0'")
    @Column(name = "itemLevel", columnDefinition = "int UNSIGNED not null")
    private Integer itemLevel;

    @ColumnDefault("'0'")
    @Column(name = "battlePetSpeciesId", columnDefinition = "int UNSIGNED not null")
    private Long battlePetSpeciesId;

    @ColumnDefault("'0'")
    @Column(name = "suffixItemNameDescriptionId", columnDefinition = "int UNSIGNED not null")
    private Long suffixItemNameDescriptionId;

}