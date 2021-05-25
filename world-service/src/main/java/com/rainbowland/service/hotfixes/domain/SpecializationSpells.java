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
@Table("specialization_spells")
public class SpecializationSpells {

    @Column("Description")
    private String description;
    @Column("ID")
    private Integer id;
    @Column("SpecID")
    private Integer specId;
    @Column("SpellID")
    private Integer spellId;
    @Column("OverridesSpellID")
    private Integer overridesSpellId;
    @Column("DisplayOrder")
    private Integer displayOrder;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpecializationSpells> {

        public SpecializationSpells convert(Row row) {
            SpecializationSpells domain = new SpecializationSpells();
            domain.setDescription(row.get("Description", String.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setSpecId(row.get("SpecID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setOverridesSpellId(row.get("OverridesSpellID", Integer.class));
            domain.setDisplayOrder(row.get("DisplayOrder", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpecializationSpells, OutboundRow> {

        public OutboundRow convert(SpecializationSpells source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getDescription()).ifPresent(e -> row.put("Description", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSpecId()).ifPresent(e -> row.put("SpecID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getOverridesSpellId()).ifPresent(e -> row.put("OverridesSpellID", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayOrder()).ifPresent(e -> row.put("DisplayOrder", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
