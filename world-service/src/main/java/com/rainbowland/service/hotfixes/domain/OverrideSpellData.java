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
@Table("override_spell_data")
public class OverrideSpellData {

    @Column("ID")
    private Integer id;
    @Column("Spells1")
    private Integer spells1;
    @Column("Spells2")
    private Integer spells2;
    @Column("Spells3")
    private Integer spells3;
    @Column("Spells4")
    private Integer spells4;
    @Column("Spells5")
    private Integer spells5;
    @Column("Spells6")
    private Integer spells6;
    @Column("Spells7")
    private Integer spells7;
    @Column("Spells8")
    private Integer spells8;
    @Column("Spells9")
    private Integer spells9;
    @Column("Spells10")
    private Integer spells10;
    @Column("PlayerActionBarFileDataID")
    private Integer playerActionBarFileDataId;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, OverrideSpellData> {

        public OverrideSpellData convert(Row row) {
            OverrideSpellData domain = new OverrideSpellData();
            domain.setId(row.get("ID", Integer.class));
            domain.setSpells1(row.get("Spells1", Integer.class));
            domain.setSpells2(row.get("Spells2", Integer.class));
            domain.setSpells3(row.get("Spells3", Integer.class));
            domain.setSpells4(row.get("Spells4", Integer.class));
            domain.setSpells5(row.get("Spells5", Integer.class));
            domain.setSpells6(row.get("Spells6", Integer.class));
            domain.setSpells7(row.get("Spells7", Integer.class));
            domain.setSpells8(row.get("Spells8", Integer.class));
            domain.setSpells9(row.get("Spells9", Integer.class));
            domain.setSpells10(row.get("Spells10", Integer.class));
            domain.setPlayerActionBarFileDataId(row.get("PlayerActionBarFileDataID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<OverrideSpellData, OutboundRow> {

        public OutboundRow convert(OverrideSpellData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpells1()).ifPresent(e -> row.put("Spells1", Parameter.from(e)));
            Optional.ofNullable(source.getSpells2()).ifPresent(e -> row.put("Spells2", Parameter.from(e)));
            Optional.ofNullable(source.getSpells3()).ifPresent(e -> row.put("Spells3", Parameter.from(e)));
            Optional.ofNullable(source.getSpells4()).ifPresent(e -> row.put("Spells4", Parameter.from(e)));
            Optional.ofNullable(source.getSpells5()).ifPresent(e -> row.put("Spells5", Parameter.from(e)));
            Optional.ofNullable(source.getSpells6()).ifPresent(e -> row.put("Spells6", Parameter.from(e)));
            Optional.ofNullable(source.getSpells7()).ifPresent(e -> row.put("Spells7", Parameter.from(e)));
            Optional.ofNullable(source.getSpells8()).ifPresent(e -> row.put("Spells8", Parameter.from(e)));
            Optional.ofNullable(source.getSpells9()).ifPresent(e -> row.put("Spells9", Parameter.from(e)));
            Optional.ofNullable(source.getSpells10()).ifPresent(e -> row.put("Spells10", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerActionBarFileDataId()).ifPresent(e -> row.put("PlayerActionBarFileDataID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
