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

    @Column("ID")
    private int id;

    @Column("LtOperand1")
    private Integer ltOperand1;

    @Column("LtOperand2")
    private Integer ltOperand2;

    @Column("LtOperand3")
    private Integer ltOperand3;

    @Column("LtOperand4")
    private Integer ltOperand4;

    @Column("LtOperand5")
    private Integer ltOperand5;

    @Column("LtOperandType1")
    private Byte ltOperandType1;

    @Column("LtOperandType2")
    private Byte ltOperandType2;

    @Column("LtOperandType3")
    private Byte ltOperandType3;

    @Column("LtOperandType4")
    private Byte ltOperandType4;

    @Column("LtOperandType5")
    private Byte ltOperandType5;

    @Column("Operator1")
    private Byte operator1;

    @Column("Operator2")
    private Byte operator2;

    @Column("Operator3")
    private Byte operator3;

    @Column("Operator4")
    private Byte operator4;

    @Column("Operator5")
    private Byte operator5;

    @Column("RtOperandType1")
    private Byte rtOperandType1;

    @Column("RtOperandType2")
    private Byte rtOperandType2;

    @Column("RtOperandType3")
    private Byte rtOperandType3;

    @Column("RtOperandType4")
    private Byte rtOperandType4;

    @Column("RtOperandType5")
    private Byte rtOperandType5;

    @Column("RtOperand1")
    private Byte rtOperand1;

    @Column("RtOperand2")
    private Byte rtOperand2;

    @Column("RtOperand3")
    private Byte rtOperand3;

    @Column("RtOperand4")
    private Byte rtOperand4;

    @Column("RtOperand5")
    private Byte rtOperand5;

    @Column("Logic1")
    private Byte logic1;

    @Column("Logic2")
    private Byte logic2;

    @Column("Logic3")
    private Byte logic3;

    @Column("Logic4")
    private Byte logic4;

    @Column("Logic5")
    private Byte logic5;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
