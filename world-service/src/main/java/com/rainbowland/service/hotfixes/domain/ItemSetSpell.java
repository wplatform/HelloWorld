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
@Table("item_set_spell")
public class ItemSetSpell {

    @Column("ID")
    private Integer id;
    @Column("ChrSpecID")
    private Integer chrSpecId;
    @Column("SpellID")
    private Integer spellId;
    @Column("Threshold")
    private Integer threshold;
    @Column("ItemSetID")
    private Integer itemSetId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemSetSpell> {

        public ItemSetSpell convert(Row row) {
            ItemSetSpell domain = new ItemSetSpell();
            domain.setId(row.get("ID", Integer.class));
            domain.setChrSpecId(row.get("ChrSpecID", Integer.class));
            domain.setSpellId(row.get("SpellID", Integer.class));
            domain.setThreshold(row.get("Threshold", Integer.class));
            domain.setItemSetId(row.get("ItemSetID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemSetSpell, OutboundRow> {

        public OutboundRow convert(ItemSetSpell source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getChrSpecId()).ifPresent(e -> row.put("ChrSpecID", Parameter.from(e)));
            Optional.ofNullable(source.getSpellId()).ifPresent(e -> row.put("SpellID", Parameter.from(e)));
            Optional.ofNullable(source.getThreshold()).ifPresent(e -> row.put("Threshold", Parameter.from(e)));
            Optional.ofNullable(source.getItemSetId()).ifPresent(e -> row.put("ItemSetID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
