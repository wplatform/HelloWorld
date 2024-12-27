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
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
@Table(name = "artifact_quest_xp")
@Db2DataBind(name = "ArtifactQuestXP.db2", layoutHash = 0x86397302, fields = {
        @Db2Field(name = {"difficulty1", "difficulty2", "difficulty3", "difficulty4", "difficulty5", "difficulty6", "difficulty7", "difficulty8", "difficulty9", "difficulty10"}, type = Db2Type.INT)
})
public class ArtifactQuestXp implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Difficulty1")
    private Integer difficulty1;

    @Column(name = "Difficulty2")
    private Integer difficulty2;

    @Column(name = "Difficulty3")
    private Integer difficulty3;

    @Column(name = "Difficulty4")
    private Integer difficulty4;

    @Column(name = "Difficulty5")
    private Integer difficulty5;

    @Column(name = "Difficulty6")
    private Integer difficulty6;

    @Column(name = "Difficulty7")
    private Integer difficulty7;

    @Column(name = "Difficulty8")
    private Integer difficulty8;

    @Column(name = "Difficulty9")
    private Integer difficulty9;

    @Column(name = "Difficulty10")
    private Integer difficulty10;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
