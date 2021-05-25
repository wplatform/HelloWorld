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
@Table("azerite_power")
public class AzeritePower {

    @Column("ID")
    private Integer id;
    @Column("SpellID")
    private Integer spellId;
    @Column("ItemBonusListID")
    private Integer itemBonusListId;
    @Column("SpecSetID")
    private Integer specSetId;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AzeritePower> {

        public AzeritePower convert(Row row) {
            AzeritePower domain = new AzeritePower();
            domain.setId(row.get("ID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setItemBonusListId(row.get("ItemBonusListID", Integer.class));
            domain.setSpecSetId(row.get("SpecSetID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AzeritePower, OutboundRow> {

        public OutboundRow convert(AzeritePower source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getItemBonusListId()).ifPresent(e -> row.put("ItemBonusListID", Parameter.from(e)));
            Optional.ofNullable(source.getSpecSetId()).ifPresent(e -> row.put("SpecSetID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
