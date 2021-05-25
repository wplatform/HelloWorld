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
@Table("spell_reagents")
public class SpellReagents {

    @Column("ID")
    private Integer id;
    @Column("SpellID")
    private Integer spellId;
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
    private Integer reagentCount1;
    @Column("ReagentCount2")
    private Integer reagentCount2;
    @Column("ReagentCount3")
    private Integer reagentCount3;
    @Column("ReagentCount4")
    private Integer reagentCount4;
    @Column("ReagentCount5")
    private Integer reagentCount5;
    @Column("ReagentCount6")
    private Integer reagentCount6;
    @Column("ReagentCount7")
    private Integer reagentCount7;
    @Column("ReagentCount8")
    private Integer reagentCount8;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellReagents> {

        public SpellReagents convert(Row row) {
            SpellReagents domain = new SpellReagents();
            domain.setId(row.get("ID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setReagent1(row.get("Reagent1", Integer.class));
            domain.setReagent2(row.get("Reagent2", Integer.class));
            domain.setReagent3(row.get("Reagent3", Integer.class));
            domain.setReagent4(row.get("Reagent4", Integer.class));
            domain.setReagent5(row.get("Reagent5", Integer.class));
            domain.setReagent6(row.get("Reagent6", Integer.class));
            domain.setReagent7(row.get("Reagent7", Integer.class));
            domain.setReagent8(row.get("Reagent8", Integer.class));
            domain.setReagentCount1(row.get("ReagentCount1", Integer.class));
            domain.setReagentCount2(row.get("ReagentCount2", Integer.class));
            domain.setReagentCount3(row.get("ReagentCount3", Integer.class));
            domain.setReagentCount4(row.get("ReagentCount4", Integer.class));
            domain.setReagentCount5(row.get("ReagentCount5", Integer.class));
            domain.setReagentCount6(row.get("ReagentCount6", Integer.class));
            domain.setReagentCount7(row.get("ReagentCount7", Integer.class));
            domain.setReagentCount8(row.get("ReagentCount8", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellReagents, OutboundRow> {

        public OutboundRow convert(SpellReagents source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getReagent1()).ifPresent(e -> row.put("Reagent1", Parameter.from(e)));
            Optional.ofNullable(source.getReagent2()).ifPresent(e -> row.put("Reagent2", Parameter.from(e)));
            Optional.ofNullable(source.getReagent3()).ifPresent(e -> row.put("Reagent3", Parameter.from(e)));
            Optional.ofNullable(source.getReagent4()).ifPresent(e -> row.put("Reagent4", Parameter.from(e)));
            Optional.ofNullable(source.getReagent5()).ifPresent(e -> row.put("Reagent5", Parameter.from(e)));
            Optional.ofNullable(source.getReagent6()).ifPresent(e -> row.put("Reagent6", Parameter.from(e)));
            Optional.ofNullable(source.getReagent7()).ifPresent(e -> row.put("Reagent7", Parameter.from(e)));
            Optional.ofNullable(source.getReagent8()).ifPresent(e -> row.put("Reagent8", Parameter.from(e)));
            Optional.ofNullable(source.getReagentCount1()).ifPresent(e -> row.put("ReagentCount1", Parameter.from(e)));
            Optional.ofNullable(source.getReagentCount2()).ifPresent(e -> row.put("ReagentCount2", Parameter.from(e)));
            Optional.ofNullable(source.getReagentCount3()).ifPresent(e -> row.put("ReagentCount3", Parameter.from(e)));
            Optional.ofNullable(source.getReagentCount4()).ifPresent(e -> row.put("ReagentCount4", Parameter.from(e)));
            Optional.ofNullable(source.getReagentCount5()).ifPresent(e -> row.put("ReagentCount5", Parameter.from(e)));
            Optional.ofNullable(source.getReagentCount6()).ifPresent(e -> row.put("ReagentCount6", Parameter.from(e)));
            Optional.ofNullable(source.getReagentCount7()).ifPresent(e -> row.put("ReagentCount7", Parameter.from(e)));
            Optional.ofNullable(source.getReagentCount8()).ifPresent(e -> row.put("ReagentCount8", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
