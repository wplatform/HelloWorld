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
@Table(name = "guild_member_withdraw")
public class GuildMemberWithdraw {
    @Id
    @Column(name = "guid", nullable = false)
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "tab0", columnDefinition = "int UNSIGNED not null")
    private Long tab0;

    @ColumnDefault("'0'")
    @Column(name = "tab1", columnDefinition = "int UNSIGNED not null")
    private Long tab1;

    @ColumnDefault("'0'")
    @Column(name = "tab2", columnDefinition = "int UNSIGNED not null")
    private Long tab2;

    @ColumnDefault("'0'")
    @Column(name = "tab3", columnDefinition = "int UNSIGNED not null")
    private Long tab3;

    @ColumnDefault("'0'")
    @Column(name = "tab4", columnDefinition = "int UNSIGNED not null")
    private Long tab4;

    @ColumnDefault("'0'")
    @Column(name = "tab5", columnDefinition = "int UNSIGNED not null")
    private Long tab5;

    @ColumnDefault("'0'")
    @Column(name = "tab6", columnDefinition = "int UNSIGNED not null")
    private Long tab6;

    @ColumnDefault("'0'")
    @Column(name = "tab7", columnDefinition = "int UNSIGNED not null")
    private Long tab7;

    @ColumnDefault("'0'")
    @Column(name = "money", nullable = false)
    private Long money;

}