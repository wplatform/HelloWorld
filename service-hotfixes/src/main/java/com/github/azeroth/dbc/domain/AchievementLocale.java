package com.github.azeroth.dbc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)


@Table(name = "achievement_locale")
public class AchievementLocale {
    @Id

    @Column("ID")
    private int id;

    @Id
    @Column("locale")
    private String locale;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

    
    @Column("Description_lang")
    private String descriptionLang;

    
    @Column("Title_lang")
    private String titleLang;

    
    @Column("Reward_lang")
    private String rewardLang;

}