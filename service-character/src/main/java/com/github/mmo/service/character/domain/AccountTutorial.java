package com.github.mmo.service.character.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "account_tutorial")
public class AccountTutorial {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "accountId", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @ColumnDefault("'0'")
    @Column(name = "tut0", columnDefinition = "int UNSIGNED not null")
    private Integer tut0;

    @ColumnDefault("'0'")
    @Column(name = "tut1", columnDefinition = "int UNSIGNED not null")
    private Integer tut1;

    @ColumnDefault("'0'")
    @Column(name = "tut2", columnDefinition = "int UNSIGNED not null")
    private Integer tut2;

    @ColumnDefault("'0'")
    @Column(name = "tut3", columnDefinition = "int UNSIGNED not null")
    private Integer tut3;

    @ColumnDefault("'0'")
    @Column(name = "tut4", columnDefinition = "int UNSIGNED not null")
    private Integer tut4;

    @ColumnDefault("'0'")
    @Column(name = "tut5", columnDefinition = "int UNSIGNED not null")
    private Integer tut5;

    @ColumnDefault("'0'")
    @Column(name = "tut6", columnDefinition = "int UNSIGNED not null")
    private Integer tut6;

    @ColumnDefault("'0'")
    @Column(name = "tut7", columnDefinition = "int UNSIGNED not null")
    private Integer tut7;

}