package com.github.mmo.dbc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "hotfix_data")
public class HotfixDatum {
    @EmbeddedId
    private HotfixDatumId id;

    @ColumnDefault("'0'")
    @Column(name = "UniqueId", columnDefinition = "int UNSIGNED not null")
    private Long uniqueId;

    @ColumnDefault("'3'")
    @Column(name = "Status", columnDefinition = "tinyint UNSIGNED not null")
    private Short status;

    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}