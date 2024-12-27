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
@Table(name = "unit_condition")
@Db2DataBind(name = "UnitCondition.db2", layoutHash = 0x62802D9C, fields = {
        @Db2Field(name = {"value1", "value2", "value3", "value4", "value5", "value6", "value7", "value8"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = {"variable1", "variable2", "variable3", "variable4", "variable5", "variable6", "variable7", "variable8"}, type = Db2Type.BYTE),
        @Db2Field(name = {"op1", "op2", "op3", "op4", "op5", "op6", "op7", "op8"}, type = Db2Type.BYTE, signed = true)
})
public class UnitCondition implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Value1")
    private Integer value1;

    @Column(name = "Value2")
    private Integer value2;

    @Column(name = "Value3")
    private Integer value3;

    @Column(name = "Value4")
    private Integer value4;

    @Column(name = "Value5")
    private Integer value5;

    @Column(name = "Value6")
    private Integer value6;

    @Column(name = "Value7")
    private Integer value7;

    @Column(name = "Value8")
    private Integer value8;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "Variable1")
    private Byte variable1;

    @Column(name = "Variable2")
    private Byte variable2;

    @Column(name = "Variable3")
    private Byte variable3;

    @Column(name = "Variable4")
    private Byte variable4;

    @Column(name = "Variable5")
    private Byte variable5;

    @Column(name = "Variable6")
    private Byte variable6;

    @Column(name = "Variable7")
    private Byte variable7;

    @Column(name = "Variable8")
    private Byte variable8;

    @Column(name = "Op1")
    private Byte op1;

    @Column(name = "Op2")
    private Byte op2;

    @Column(name = "Op3")
    private Byte op3;

    @Column(name = "Op4")
    private Byte op4;

    @Column(name = "Op5")
    private Byte op5;

    @Column(name = "Op6")
    private Byte op6;

    @Column(name = "Op7")
    private Byte op7;

    @Column(name = "Op8")
    private Byte op8;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
