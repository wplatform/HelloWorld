package com.rainbowland.service.hotfixes.domain;

import io.r2dbc.spi.Row;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.r2dbc.core.Parameter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.r2dbc.mapping.OutboundRow;
import lombok.Data;

import java.util.Optional;

@Data
@Table("spell_item_enchantment_condition")
public class SpellItemEnchantmentCondition {

    @Column("ID")
    private Integer id;
    @Column("LtOperandType1")
    private Integer ltOperandType1;
    @Column("LtOperandType2")
    private Integer ltOperandType2;
    @Column("LtOperandType3")
    private Integer ltOperandType3;
    @Column("LtOperandType4")
    private Integer ltOperandType4;
    @Column("LtOperandType5")
    private Integer ltOperandType5;
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
    @Column("Operator1")
    private Integer operator1;
    @Column("Operator2")
    private Integer operator2;
    @Column("Operator3")
    private Integer operator3;
    @Column("Operator4")
    private Integer operator4;
    @Column("Operator5")
    private Integer operator5;
    @Column("RtOperandType1")
    private Integer rtOperandType1;
    @Column("RtOperandType2")
    private Integer rtOperandType2;
    @Column("RtOperandType3")
    private Integer rtOperandType3;
    @Column("RtOperandType4")
    private Integer rtOperandType4;
    @Column("RtOperandType5")
    private Integer rtOperandType5;
    @Column("RtOperand1")
    private Integer rtOperand1;
    @Column("RtOperand2")
    private Integer rtOperand2;
    @Column("RtOperand3")
    private Integer rtOperand3;
    @Column("RtOperand4")
    private Integer rtOperand4;
    @Column("RtOperand5")
    private Integer rtOperand5;
    @Column("Logic1")
    private Integer logic1;
    @Column("Logic2")
    private Integer logic2;
    @Column("Logic3")
    private Integer logic3;
    @Column("Logic4")
    private Integer logic4;
    @Column("Logic5")
    private Integer logic5;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellItemEnchantmentCondition> {

        public SpellItemEnchantmentCondition convert(Row row) {
            SpellItemEnchantmentCondition domain = new SpellItemEnchantmentCondition();
            domain.setId(row.get("ID", Integer.class));
            domain.setLtOperandType1(row.get("LtOperandType1", Integer.class));
            domain.setLtOperandType2(row.get("LtOperandType2", Integer.class));
            domain.setLtOperandType3(row.get("LtOperandType3", Integer.class));
            domain.setLtOperandType4(row.get("LtOperandType4", Integer.class));
            domain.setLtOperandType5(row.get("LtOperandType5", Integer.class));
            domain.setLtOperand1(row.get("LtOperand1", Integer.class));
            domain.setLtOperand2(row.get("LtOperand2", Integer.class));
            domain.setLtOperand3(row.get("LtOperand3", Integer.class));
            domain.setLtOperand4(row.get("LtOperand4", Integer.class));
            domain.setLtOperand5(row.get("LtOperand5", Integer.class));
            domain.setOperator1(row.get("Operator1", Integer.class));
            domain.setOperator2(row.get("Operator2", Integer.class));
            domain.setOperator3(row.get("Operator3", Integer.class));
            domain.setOperator4(row.get("Operator4", Integer.class));
            domain.setOperator5(row.get("Operator5", Integer.class));
            domain.setRtOperandType1(row.get("RtOperandType1", Integer.class));
            domain.setRtOperandType2(row.get("RtOperandType2", Integer.class));
            domain.setRtOperandType3(row.get("RtOperandType3", Integer.class));
            domain.setRtOperandType4(row.get("RtOperandType4", Integer.class));
            domain.setRtOperandType5(row.get("RtOperandType5", Integer.class));
            domain.setRtOperand1(row.get("RtOperand1", Integer.class));
            domain.setRtOperand2(row.get("RtOperand2", Integer.class));
            domain.setRtOperand3(row.get("RtOperand3", Integer.class));
            domain.setRtOperand4(row.get("RtOperand4", Integer.class));
            domain.setRtOperand5(row.get("RtOperand5", Integer.class));
            domain.setLogic1(row.get("Logic1", Integer.class));
            domain.setLogic2(row.get("Logic2", Integer.class));
            domain.setLogic3(row.get("Logic3", Integer.class));
            domain.setLogic4(row.get("Logic4", Integer.class));
            domain.setLogic5(row.get("Logic5", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellItemEnchantmentCondition, OutboundRow> {

        public OutboundRow convert(SpellItemEnchantmentCondition source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getLtOperandType1()).ifPresent(e -> row.put("LtOperandType1", Parameter.from(e)));
            Optional.ofNullable(source.getLtOperandType2()).ifPresent(e -> row.put("LtOperandType2", Parameter.from(e)));
            Optional.ofNullable(source.getLtOperandType3()).ifPresent(e -> row.put("LtOperandType3", Parameter.from(e)));
            Optional.ofNullable(source.getLtOperandType4()).ifPresent(e -> row.put("LtOperandType4", Parameter.from(e)));
            Optional.ofNullable(source.getLtOperandType5()).ifPresent(e -> row.put("LtOperandType5", Parameter.from(e)));
            Optional.ofNullable(source.getLtOperand1()).ifPresent(e -> row.put("LtOperand1", Parameter.from(e)));
            Optional.ofNullable(source.getLtOperand2()).ifPresent(e -> row.put("LtOperand2", Parameter.from(e)));
            Optional.ofNullable(source.getLtOperand3()).ifPresent(e -> row.put("LtOperand3", Parameter.from(e)));
            Optional.ofNullable(source.getLtOperand4()).ifPresent(e -> row.put("LtOperand4", Parameter.from(e)));
            Optional.ofNullable(source.getLtOperand5()).ifPresent(e -> row.put("LtOperand5", Parameter.from(e)));
            Optional.ofNullable(source.getOperator1()).ifPresent(e -> row.put("Operator1", Parameter.from(e)));
            Optional.ofNullable(source.getOperator2()).ifPresent(e -> row.put("Operator2", Parameter.from(e)));
            Optional.ofNullable(source.getOperator3()).ifPresent(e -> row.put("Operator3", Parameter.from(e)));
            Optional.ofNullable(source.getOperator4()).ifPresent(e -> row.put("Operator4", Parameter.from(e)));
            Optional.ofNullable(source.getOperator5()).ifPresent(e -> row.put("Operator5", Parameter.from(e)));
            Optional.ofNullable(source.getRtOperandType1()).ifPresent(e -> row.put("RtOperandType1", Parameter.from(e)));
            Optional.ofNullable(source.getRtOperandType2()).ifPresent(e -> row.put("RtOperandType2", Parameter.from(e)));
            Optional.ofNullable(source.getRtOperandType3()).ifPresent(e -> row.put("RtOperandType3", Parameter.from(e)));
            Optional.ofNullable(source.getRtOperandType4()).ifPresent(e -> row.put("RtOperandType4", Parameter.from(e)));
            Optional.ofNullable(source.getRtOperandType5()).ifPresent(e -> row.put("RtOperandType5", Parameter.from(e)));
            Optional.ofNullable(source.getRtOperand1()).ifPresent(e -> row.put("RtOperand1", Parameter.from(e)));
            Optional.ofNullable(source.getRtOperand2()).ifPresent(e -> row.put("RtOperand2", Parameter.from(e)));
            Optional.ofNullable(source.getRtOperand3()).ifPresent(e -> row.put("RtOperand3", Parameter.from(e)));
            Optional.ofNullable(source.getRtOperand4()).ifPresent(e -> row.put("RtOperand4", Parameter.from(e)));
            Optional.ofNullable(source.getRtOperand5()).ifPresent(e -> row.put("RtOperand5", Parameter.from(e)));
            Optional.ofNullable(source.getLogic1()).ifPresent(e -> row.put("Logic1", Parameter.from(e)));
            Optional.ofNullable(source.getLogic2()).ifPresent(e -> row.put("Logic2", Parameter.from(e)));
            Optional.ofNullable(source.getLogic3()).ifPresent(e -> row.put("Logic3", Parameter.from(e)));
            Optional.ofNullable(source.getLogic4()).ifPresent(e -> row.put("Logic4", Parameter.from(e)));
            Optional.ofNullable(source.getLogic5()).ifPresent(e -> row.put("Logic5", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
