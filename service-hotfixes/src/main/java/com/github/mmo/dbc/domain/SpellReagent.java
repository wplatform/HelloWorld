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


@Table(name = "spell_reagents")
@Db2DataBind(name = "SpellReagents.db2", layoutHash = 0x0463C688, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"reagent1", "reagent2", "reagent3", "reagent4", "reagent5", "reagent6", "reagent7", "reagent8"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"reagentCount1", "reagentCount2", "reagentCount3", "reagentCount4", "reagentCount5", "reagentCount6", "reagentCount7", "reagentCount8"}, type = Db2Type.SHORT, signed = true)
})
public class SpellReagent implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("SpellID")
    private Integer spellID;

    @Column("Reagent1")
    private Integer reagent1;

    @Column("Reagent2")
    private Integer reagent2;

    @Column("Reagent3")
    private Integer reagent3;

    @Column("Reagent4")
    private Integer reagent4;

    @Column("Reagent5")
    private Integer reagent5;

    @Column("Reagent6")
    private Integer reagent6;

    @Column("Reagent7")
    private Integer reagent7;

    @Column("Reagent8")
    private Integer reagent8;

    @Column("ReagentCount1")
    private Short reagentCount1;

    @Column("ReagentCount2")
    private Short reagentCount2;

    @Column("ReagentCount3")
    private Short reagentCount3;

    @Column("ReagentCount4")
    private Short reagentCount4;

    @Column("ReagentCount5")
    private Short reagentCount5;

    @Column("ReagentCount6")
    private Short reagentCount6;

    @Column("ReagentCount7")
    private Short reagentCount7;

    @Column("ReagentCount8")
    private Short reagentCount8;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
