package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(AccountDatumId.class)
@Entity
@Table(name = "account_data")
public class AccountDatum {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "accountId", columnDefinition = "int UNSIGNED not null")
    private Integer accountId;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "type", columnDefinition = "tinyint UNSIGNED not null")
    private Short type;

    @ColumnDefault("0")
    @Column(name = "time", nullable = false)
    private Integer time;

    @Column(name = "data", nullable = false)
    private byte[] data;

}