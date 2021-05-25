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
@Table("spell_totems")
public class SpellTotems {

    @Column("ID")
    private Integer id;
    @Column("SpellID")
    private Integer spellId;
    @Column("RequiredTotemCategoryID1")
    private Integer requiredTotemCategoryId1;
    @Column("RequiredTotemCategoryID2")
    private Integer requiredTotemCategoryId2;
    @Column("Totem1")
    private Integer totem1;
    @Column("Totem2")
    private Integer totem2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellTotems> {

        public SpellTotems convert(Row row) {
            SpellTotems domain = new SpellTotems();
            domain.setId(row.get("ID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setRequiredTotemCategoryId1(row.get("RequiredTotemCategoryID1", Integer.class));
            domain.setRequiredTotemCategoryId2(row.get("RequiredTotemCategoryID2", Integer.class));
            domain.setTotem1(row.get("Totem1", Integer.class));
            domain.setTotem2(row.get("Totem2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellTotems, OutboundRow> {

        public OutboundRow convert(SpellTotems source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredTotemCategoryId1()).ifPresent(e -> row.put("RequiredTotemCategoryID1", Parameter.from(e)));
            Optional.ofNullable(source.getRequiredTotemCategoryId2()).ifPresent(e -> row.put("RequiredTotemCategoryID2", Parameter.from(e)));
            Optional.ofNullable(source.getTotem1()).ifPresent(e -> row.put("Totem1", Parameter.from(e)));
            Optional.ofNullable(source.getTotem2()).ifPresent(e -> row.put("Totem2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
