package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(CharacterAccountDatumId.class)
@Entity
@Table(name = "character_account_data")
public class CharacterAccountDatum {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "guid", nullable = false)
    private Integer guid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "type", columnDefinition = "tinyint UNSIGNED not null")
    private Short type;

    @ColumnDefault("0")
    @Column(name = "time", nullable = false)
    private Long time;

    @Column(name = "data", nullable = false)
    private byte[] data;

}