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
@Table("talent")
public class Talent {

    @Column("ID")
    private Integer id;
    @Column("Description")
    private String description;
    @Column("TierID")
    private Integer tierId;
    @Column("Flags")
    private Integer flags;
    @Column("ColumnIndex")
    private Integer columnIndex;
    @Column("ClassID")
    private Integer classId;
    @Column("SpecID")
    private Integer specId;
    @Column("SpellID")
    private Integer spellId;
    @Column("OverridesSpellID")
    private Integer overridesSpellId;
    @Column("CategoryMask1")
    private Integer categoryMask1;
    @Column("CategoryMask2")
    private Integer categoryMask2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Talent> {

        public Talent convert(Row row) {
            Talent domain = new Talent();
            domain.setId(row.get("ID", Integer.class));
            domain.setDescription(row.get("Description", String.class));
            domain.setTierId(row.get("TierID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setColumnIndex(row.get("ColumnIndex", Integer.class));
            domain.setClassId(row.get("ClassID", Integer.class));
            domain.setSpecId(row.get("SpecID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setOverridesSpellId(row.get("OverridesSpellID", Integer.class));
            domain.setCategoryMask1(row.get("CategoryMask1", Integer.class));
            domain.setCategoryMask2(row.get("CategoryMask2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Talent, OutboundRow> {

        public OutboundRow convert(Talent source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getTierId()).ifPresent(e -> row.put("TierID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getColumnIndex()).ifPresent(e -> row.put("ColumnIndex", Parameter.from(e)));
            Optional.ofNullable(source.getClassId()).ifPresent(e -> row.put("ClassID", Parameter.from(e)));
            Optional.ofNullable(source.getSpecId()).ifPresent(e -> row.put("SpecID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getOverridesSpellId()).ifPresent(e -> row.put("OverridesSpellID", Parameter.from(e)));
            Optional.ofNullable(source.getCategoryMask1()).ifPresent(e -> row.put("CategoryMask1", Parameter.from(e)));
            Optional.ofNullable(source.getCategoryMask2()).ifPresent(e -> row.put("CategoryMask2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
