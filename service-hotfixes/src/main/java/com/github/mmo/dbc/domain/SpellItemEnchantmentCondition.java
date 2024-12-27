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
@Table(name = "spell_item_enchantment_condition")
@Db2DataBind(name = "SpellItemEnchantmentCondition.db2", layoutHash = 0xB9C16961, fields = {
        @Db2Field(name = {"ltOperand1", "ltOperand2", "ltOperand3", "ltOperand4", "ltOperand5"}, type = Db2Type.INT),
        @Db2Field(name = {"ltOperandType1", "ltOperandType2", "ltOperandType3", "ltOperandType4", "ltOperandType5"}, type = Db2Type.BYTE),
        @Db2Field(name = {"operator1", "operator2", "operator3", "operator4", "operator5"}, type = Db2Type.BYTE),
        @Db2Field(name = {"rtOperandType1", "rtOperandType2", "rtOperandType3", "rtOperandType4", "rtOperandType5"}, type = Db2Type.BYTE),
        @Db2Field(name = {"rtOperand1", "rtOperand2", "rtOperand3", "rtOperand4", "rtOperand5"}, type = Db2Type.BYTE),
        @Db2Field(name = {"logic1", "logic2", "logic3", "logic4", "logic5"}, type = Db2Type.BYTE)
})
public class SpellItemEnchantmentCondition implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "LtOperand1")
    private Integer ltOperand1;

    @Column(name = "LtOperand2")
    private Integer ltOperand2;

    @Column(name = "LtOperand3")
    private Integer ltOperand3;

    @Column(name = "LtOperand4")
    private Integer ltOperand4;

    @Column(name = "LtOperand5")
    private Integer ltOperand5;

    @Column(name = "LtOperandType1")
    private Byte ltOperandType1;

    @Column(name = "LtOperandType2")
    private Byte ltOperandType2;

    @Column(name = "LtOperandType3")
    private Byte ltOperandType3;

    @Column(name = "LtOperandType4")
    private Byte ltOperandType4;

    @Column(name = "LtOperandType5")
    private Byte ltOperandType5;

    @Column(name = "Operator1")
    private Byte operator1;

    @Column(name = "Operator2")
    private Byte operator2;

    @Column(name = "Operator3")
    private Byte operator3;

    @Column(name = "Operator4")
    private Byte operator4;

    @Column(name = "Operator5")
    private Byte operator5;

    @Column(name = "RtOperandType1")
    private Byte rtOperandType1;

    @Column(name = "RtOperandType2")
    private Byte rtOperandType2;

    @Column(name = "RtOperandType3")
    private Byte rtOperandType3;

    @Column(name = "RtOperandType4")
    private Byte rtOperandType4;

    @Column(name = "RtOperandType5")
    private Byte rtOperandType5;

    @Column(name = "RtOperand1")
    private Byte rtOperand1;

    @Column(name = "RtOperand2")
    private Byte rtOperand2;

    @Column(name = "RtOperand3")
    private Byte rtOperand3;

    @Column(name = "RtOperand4")
    private Byte rtOperand4;

    @Column(name = "RtOperand5")
    private Byte rtOperand5;

    @Column(name = "Logic1")
    private Byte logic1;

    @Column(name = "Logic2")
    private Byte logic2;

    @Column(name = "Logic3")
    private Byte logic3;

    @Column(name = "Logic4")
    private Byte logic4;

    @Column(name = "Logic5")
    private Byte logic5;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
