package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Table(name = "quest_xp")
@Db2DataBind(name = "QuestXP.db2", layoutHash = 0xCB76B4C0, fields = {
        @Db2Field(name = {"difficulty1", "difficulty2", "difficulty3", "difficulty4", "difficulty5", "difficulty6", "difficulty7", "difficulty8", "difficulty9", "difficulty10"}, type = Db2Type.SHORT)
})
public class QuestXp implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Difficulty1")
    private Integer difficulty1;

    @Column("Difficulty2")
    private Integer difficulty2;

    @Column("Difficulty3")
    private Integer difficulty3;

    @Column("Difficulty4")
    private Integer difficulty4;

    @Column("Difficulty5")
    private Integer difficulty5;

    @Column("Difficulty6")
    private Integer difficulty6;

    @Column("Difficulty7")
    private Integer difficulty7;

    @Column("Difficulty8")
    private Integer difficulty8;

    @Column("Difficulty9")
    private Integer difficulty9;

    @Column("Difficulty10")
    private Integer difficulty10;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
