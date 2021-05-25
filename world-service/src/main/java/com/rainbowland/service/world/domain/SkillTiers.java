package com.rainbowland.service.world.domain;

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
@Table("skill_tiers")
public class SkillTiers {

    @Column("ID")
    private Integer id;
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
    @Column("Value9")
    private Integer value9;
    @Column("Value10")
    private Integer value10;
    @Column("Value11")
    private Integer value11;
    @Column("Value12")
    private Integer value12;
    @Column("Value13")
    private Integer value13;
    @Column("Value14")
    private Integer value14;
    @Column("Value15")
    private Integer value15;
    @Column("Value16")
    private Integer value16;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SkillTiers> {

        public SkillTiers convert(Row row) {
            SkillTiers domain = new SkillTiers();
            domain.setId(row.get("ID", Integer.class));
            domain.setValue1(row.get("Value1", Integer.class));
            domain.setValue2(row.get("Value2", Integer.class));
            domain.setValue3(row.get("Value3", Integer.class));
            domain.setValue4(row.get("Value4", Integer.class));
            domain.setValue5(row.get("Value5", Integer.class));
            domain.setValue6(row.get("Value6", Integer.class));
            domain.setValue7(row.get("Value7", Integer.class));
            domain.setValue8(row.get("Value8", Integer.class));
            domain.setValue9(row.get("Value9", Integer.class));
            domain.setValue10(row.get("Value10", Integer.class));
            domain.setValue11(row.get("Value11", Integer.class));
            domain.setValue12(row.get("Value12", Integer.class));
            domain.setValue13(row.get("Value13", Integer.class));
            domain.setValue14(row.get("Value14", Integer.class));
            domain.setValue15(row.get("Value15", Integer.class));
            domain.setValue16(row.get("Value16", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SkillTiers, OutboundRow> {

        public OutboundRow convert(SkillTiers source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getValue1()).ifPresent(e -> row.put("Value1", Parameter.from(e)));
            Optional.ofNullable(source.getValue2()).ifPresent(e -> row.put("Value2", Parameter.from(e)));
            Optional.ofNullable(source.getValue3()).ifPresent(e -> row.put("Value3", Parameter.from(e)));
            Optional.ofNullable(source.getValue4()).ifPresent(e -> row.put("Value4", Parameter.from(e)));
            Optional.ofNullable(source.getValue5()).ifPresent(e -> row.put("Value5", Parameter.from(e)));
            Optional.ofNullable(source.getValue6()).ifPresent(e -> row.put("Value6", Parameter.from(e)));
            Optional.ofNullable(source.getValue7()).ifPresent(e -> row.put("Value7", Parameter.from(e)));
            Optional.ofNullable(source.getValue8()).ifPresent(e -> row.put("Value8", Parameter.from(e)));
            Optional.ofNullable(source.getValue9()).ifPresent(e -> row.put("Value9", Parameter.from(e)));
            Optional.ofNullable(source.getValue10()).ifPresent(e -> row.put("Value10", Parameter.from(e)));
            Optional.ofNullable(source.getValue11()).ifPresent(e -> row.put("Value11", Parameter.from(e)));
            Optional.ofNullable(source.getValue12()).ifPresent(e -> row.put("Value12", Parameter.from(e)));
            Optional.ofNullable(source.getValue13()).ifPresent(e -> row.put("Value13", Parameter.from(e)));
            Optional.ofNullable(source.getValue14()).ifPresent(e -> row.put("Value14", Parameter.from(e)));
            Optional.ofNullable(source.getValue15()).ifPresent(e -> row.put("Value15", Parameter.from(e)));
            Optional.ofNullable(source.getValue16()).ifPresent(e -> row.put("Value16", Parameter.from(e)));
            return row;
        }
    }

}
