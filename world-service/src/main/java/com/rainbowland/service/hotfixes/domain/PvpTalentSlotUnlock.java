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
@Table("pvp_talent_slot_unlock")
public class PvpTalentSlotUnlock {

    @Column("ID")
    private Integer id;
    @Column("Slot")
    private Integer slot;
    @Column("LevelRequired")
    private Integer levelRequired;
    @Column("DeathKnightLevelRequired")
    private Integer deathKnightLevelRequired;
    @Column("DemonHunterLevelRequired")
    private Integer demonHunterLevelRequired;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, PvpTalentSlotUnlock> {

        public PvpTalentSlotUnlock convert(Row row) {
            PvpTalentSlotUnlock domain = new PvpTalentSlotUnlock();
            domain.setId(row.get("ID", Integer.class));
            domain.setSlot(row.get("Slot", Integer.class));
            domain.setLevelRequired(row.get("LevelRequired", Integer.class));
            domain.setDeathKnightLevelRequired(row.get("DeathKnightLevelRequired", Integer.class));
            domain.setDemonHunterLevelRequired(row.get("DemonHunterLevelRequired", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<PvpTalentSlotUnlock, OutboundRow> {

        public OutboundRow convert(PvpTalentSlotUnlock source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getSlot()).ifPresent(e -> row.put("Slot", Parameter.from(e)));
            Optional.ofNullable(source.getLevelRequired()).ifPresent(e -> row.put("LevelRequired", Parameter.from(e)));
            Optional.ofNullable(source.getDeathKnightLevelRequired()).ifPresent(e -> row.put("DeathKnightLevelRequired", Parameter.from(e)));
            Optional.ofNullable(source.getDemonHunterLevelRequired()).ifPresent(e -> row.put("DemonHunterLevelRequired", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
