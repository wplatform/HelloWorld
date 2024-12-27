package com.github.mmo.dbc.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "hotfix_optional_data")
public class HotfixOptionalDatum {
    @Column(name = "TableHash", columnDefinition = "int UNSIGNED not null")
    private Long tableHash;

    @Column(name = "RecordId", columnDefinition = "int UNSIGNED not null")
    private Long recordId;

    @Column(name = "locale", nullable = false, length = 4)
    private String locale;

    @Id
    @Column(name = "`Key`", columnDefinition = "int UNSIGNED not null")
    private Long key;

    @Column(name = "Data", nullable = false)
    private byte[] data;

    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}