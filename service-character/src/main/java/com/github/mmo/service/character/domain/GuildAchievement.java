package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(GuildAchievementId.class)
@Entity
@Table(name = "guild_achievement")
public class GuildAchievement {
    @Id
    @Column(name = "guildId", nullable = false)
    private Long guildId;

    @Id
    @Column(name = "achievement", columnDefinition = "int UNSIGNED not null")
    private Long achievement;

    @ColumnDefault("0")
    @Column(name = "date", nullable = false)
    private Long date;

    @Lob
    @Column(name = "guids", nullable = false)
    private String guids;

}