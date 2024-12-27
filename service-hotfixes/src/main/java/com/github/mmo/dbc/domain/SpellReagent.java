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
@Table(name = "spell_reagents")
@Db2DataBind(name = "SpellReagents.db2", layoutHash = 0x0463C688, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"reagent1", "reagent2", "reagent3", "reagent4", "reagent5", "reagent6", "reagent7", "reagent8"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"reagentCount1", "reagentCount2", "reagentCount3", "reagentCount4", "reagentCount5", "reagentCount6", "reagentCount7", "reagentCount8"}, type = Db2Type.SHORT, signed = true)
})
public class SpellReagent implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SpellID")
    private Integer spellID;

    @Column(name = "Reagent1")
    private Integer reagent1;

    @Column(name = "Reagent2")
    private Integer reagent2;

    @Column(name = "Reagent3")
    private Integer reagent3;

    @Column(name = "Reagent4")
    private Integer reagent4;

    @Column(name = "Reagent5")
    private Integer reagent5;

    @Column(name = "Reagent6")
    private Integer reagent6;

    @Column(name = "Reagent7")
    private Integer reagent7;

    @Column(name = "Reagent8")
    private Integer reagent8;

    @Column(name = "ReagentCount1")
    private Short reagentCount1;

    @Column(name = "ReagentCount2")
    private Short reagentCount2;

    @Column(name = "ReagentCount3")
    private Short reagentCount3;

    @Column(name = "ReagentCount4")
    private Short reagentCount4;

    @Column(name = "ReagentCount5")
    private Short reagentCount5;

    @Column(name = "ReagentCount6")
    private Short reagentCount6;

    @Column(name = "ReagentCount7")
    private Short reagentCount7;

    @Column(name = "ReagentCount8")
    private Short reagentCount8;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
