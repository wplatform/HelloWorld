package com.github.mmo.dbc.domain;

import com.github.mmo.common.LocalizedString;
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
@Table(name = "scenario_step")
@Db2DataBind(name = "ScenarioStep.db2", layoutHash = 0x201B0EFC, parentIndexField = 2, fields = {
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "title", type = Db2Type.STRING),
        @Db2Field(name = "scenarioID", type = Db2Type.SHORT),
        @Db2Field(name = "supersedes", type = Db2Type.SHORT),
        @Db2Field(name = "rewardQuestID", type = Db2Type.SHORT),
        @Db2Field(name = "orderIndex", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "criteriatreeid", type = Db2Type.INT),
        @Db2Field(name = "relatedStep", type = Db2Type.INT, signed = true)
})
public class ScenarioStep implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "Title")
    private LocalizedString title;

    @Column(name = "ScenarioID")
    private Short scenarioID;

    @Column(name = "Supersedes")
    private Short supersedes;

    @Column(name = "RewardQuestID")
    private Integer rewardQuestID;

    @Column(name = "OrderIndex")
    private Byte orderIndex;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "Criteriatreeid")
    private Integer criteriatreeid;

    @Column(name = "RelatedStep")
    private Integer relatedStep;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
