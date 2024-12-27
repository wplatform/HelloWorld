package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(GuildAchievementProgressId.class)
@Entity
@Table(name = "guild_achievement_progress")
public class GuildAchievementProgress {
    @Id
    @Column(name = "guildId", nullable = false)
    private Long guildId;

    @Id
    @Column(name = "criteria", columnDefinition = "int UNSIGNED not null")
    private Long criteria;

    @Column(name = "counter", nullable = false)
    private Long counter;

    @ColumnDefault("0")
    @Column(name = "date", nullable = false)
    private Long date;

    @ColumnDefault("'0'")
    @Column(name = "completedGuid", nullable = false)
    private Long completedGuid;

}