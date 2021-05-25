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
@Table("creature_equip_template")
public class CreatureEquipTemplate {

    @Column("CreatureID")
    private Integer creatureId;
    @Column("ID")
    private Integer id;
    @Column("ItemID1")
    private Integer itemId1;
    @Column("AppearanceModID1")
    private Integer appearanceModId1;
    @Column("ItemVisual1")
    private Integer itemVisual1;
    @Column("ItemID2")
    private Integer itemId2;
    @Column("AppearanceModID2")
    private Integer appearanceModId2;
    @Column("ItemVisual2")
    private Integer itemVisual2;
    @Column("ItemID3")
    private Integer itemId3;
    @Column("AppearanceModID3")
    private Integer appearanceModId3;
    @Column("ItemVisual3")
    private Integer itemVisual3;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CreatureEquipTemplate> {

        public CreatureEquipTemplate convert(Row row) {
            CreatureEquipTemplate domain = new CreatureEquipTemplate();
            domain.setCreatureId(row.get("CreatureID", Integer.class));
            domain.setId(row.get("ID", Integer.class));
            domain.setItemId1(row.get("ItemID1", Integer.class));
            domain.setAppearanceModId1(row.get("AppearanceModID1", Integer.class));
            domain.setItemVisual1(row.get("ItemVisual1", Integer.class));
            domain.setItemId2(row.get("ItemID2", Integer.class));
            domain.setAppearanceModId2(row.get("AppearanceModID2", Integer.class));
            domain.setItemVisual2(row.get("ItemVisual2", Integer.class));
            domain.setItemId3(row.get("ItemID3", Integer.class));
            domain.setAppearanceModId3(row.get("AppearanceModID3", Integer.class));
            domain.setItemVisual3(row.get("ItemVisual3", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CreatureEquipTemplate, OutboundRow> {

        public OutboundRow convert(CreatureEquipTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getCreatureId()).ifPresent(e -> row.put("CreatureID", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getItemId1()).ifPresent(e -> row.put("ItemID1", Parameter.from(e)));
            Optional.ofNullable(source.getAppearanceModId1()).ifPresent(e -> row.put("AppearanceModID1", Parameter.from(e)));
            Optional.ofNullable(source.getItemVisual1()).ifPresent(e -> row.put("ItemVisual1", Parameter.from(e)));
            Optional.ofNullable(source.getItemId2()).ifPresent(e -> row.put("ItemID2", Parameter.from(e)));
            Optional.ofNullable(source.getAppearanceModId2()).ifPresent(e -> row.put("AppearanceModID2", Parameter.from(e)));
            Optional.ofNullable(source.getItemVisual2()).ifPresent(e -> row.put("ItemVisual2", Parameter.from(e)));
            Optional.ofNullable(source.getItemId3()).ifPresent(e -> row.put("ItemID3", Parameter.from(e)));
            Optional.ofNullable(source.getAppearanceModId3()).ifPresent(e -> row.put("AppearanceModID3", Parameter.from(e)));
            Optional.ofNullable(source.getItemVisual3()).ifPresent(e -> row.put("ItemVisual3", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
