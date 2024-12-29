package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Table(name = "quest_faction_reward")
@Db2DataBind(name = "QuestFactionReward.db2", layoutHash = 0xB0E02541, fields = {
        @Db2Field(name = {"difficulty1", "difficulty2", "difficulty3", "difficulty4", "difficulty5", "difficulty6", "difficulty7", "difficulty8", "difficulty9", "difficulty10"}, type = Db2Type.SHORT, signed = true)
})
public class QuestFactionReward implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Difficulty1")
    private Short difficulty1;

    @Column("Difficulty2")
    private Short difficulty2;

    @Column("Difficulty3")
    private Short difficulty3;

    @Column("Difficulty4")
    private Short difficulty4;

    @Column("Difficulty5")
    private Short difficulty5;

    @Column("Difficulty6")
    private Short difficulty6;

    @Column("Difficulty7")
    private Short difficulty7;

    @Column("Difficulty8")
    private Short difficulty8;

    @Column("Difficulty9")
    private Short difficulty9;

    @Column("Difficulty10")
    private Short difficulty10;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
