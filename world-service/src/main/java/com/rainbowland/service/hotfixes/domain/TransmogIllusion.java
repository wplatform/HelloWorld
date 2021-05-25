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
@Table("transmog_illusion")
public class TransmogIllusion {

    @Column("ID")
    private Integer id;
    @Column("UnlockConditionID")
    private Integer unlockConditionId;
    @Column("TransmogCost")
    private Integer transmogCost;
    @Column("SpellItemEnchantmentID")
    private Integer spellItemEnchantmentId;
    @Column("Flags")
    private Integer flags;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, TransmogIllusion> {

        public TransmogIllusion convert(Row row) {
            TransmogIllusion domain = new TransmogIllusion();
            domain.setId(row.get("ID", Integer.class));
            domain.setUnlockConditionId(row.get("UnlockConditionID", Integer.class));
            domain.setTransmogCost(row.get("TransmogCost", Integer.class));
            domain.setSpellItemEnchantmentId(row.get("SpellItemEnchantmentID", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<TransmogIllusion, OutboundRow> {

        public OutboundRow convert(TransmogIllusion source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getUnlockConditionId()).ifPresent(e -> row.put("UnlockConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getTransmogCost()).ifPresent(e -> row.put("TransmogCost", Parameter.from(e)));
            Optional.ofNullable(source.getSpellItemEnchantmentId()).ifPresent(e -> row.put("SpellItemEnchantmentID", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
