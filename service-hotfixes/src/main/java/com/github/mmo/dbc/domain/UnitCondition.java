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


@Table(name = "unit_condition")
@Db2DataBind(name = "UnitCondition.db2", layoutHash = 0x62802D9C, fields = {
        @Db2Field(name = {"value1", "value2", "value3", "value4", "value5", "value6", "value7", "value8"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = {"variable1", "variable2", "variable3", "variable4", "variable5", "variable6", "variable7", "variable8"}, type = Db2Type.BYTE),
        @Db2Field(name = {"op1", "op2", "op3", "op4", "op5", "op6", "op7", "op8"}, type = Db2Type.BYTE, signed = true)
})
public class UnitCondition implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Value1")
    private Integer value1;

    @Column("Value2")
    private Integer value2;

    @Column("Value3")
    private Integer value3;

    @Column("Value4")
    private Integer value4;

    @Column("Value5")
    private Integer value5;

    @Column("Value6")
    private Integer value6;

    @Column("Value7")
    private Integer value7;

    @Column("Value8")
    private Integer value8;

    @Column("Flags")
    private Byte flags;

    @Column("Variable1")
    private Byte variable1;

    @Column("Variable2")
    private Byte variable2;

    @Column("Variable3")
    private Byte variable3;

    @Column("Variable4")
    private Byte variable4;

    @Column("Variable5")
    private Byte variable5;

    @Column("Variable6")
    private Byte variable6;

    @Column("Variable7")
    private Byte variable7;

    @Column("Variable8")
    private Byte variable8;

    @Column("Op1")
    private Byte op1;

    @Column("Op2")
    private Byte op2;

    @Column("Op3")
    private Byte op3;

    @Column("Op4")
    private Byte op4;

    @Column("Op5")
    private Byte op5;

    @Column("Op6")
    private Byte op6;

    @Column("Op7")
    private Byte op7;

    @Column("Op8")
    private Byte op8;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
