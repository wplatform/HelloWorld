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
@Table("spell_shapeshift_form")
public class SpellShapeshiftForm {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("CreatureType")
    private Integer creatureType;
    @Column("Flags")
    private Integer flags;
    @Column("AttackIconFileID")
    private Integer attackIconFileId;
    @Column("BonusActionBar")
    private Integer bonusActionBar;
    @Column("CombatRoundTime")
    private Integer combatRoundTime;
    @Column("DamageVariance")
    private Double damageVariance;
    @Column("MountTypeID")
    private Integer mountTypeId;
    @Column("CreatureDisplayID1")
    private Integer creatureDisplayId1;
    @Column("CreatureDisplayID2")
    private Integer creatureDisplayId2;
    @Column("CreatureDisplayID3")
    private Integer creatureDisplayId3;
    @Column("CreatureDisplayID4")
    private Integer creatureDisplayId4;
    @Column("PresetSpellID1")
    private Integer presetSpellId1;
    @Column("PresetSpellID2")
    private Integer presetSpellId2;
    @Column("PresetSpellID3")
    private Integer presetSpellId3;
    @Column("PresetSpellID4")
    private Integer presetSpellId4;
    @Column("PresetSpellID5")
    private Integer presetSpellId5;
    @Column("PresetSpellID6")
    private Integer presetSpellId6;
    @Column("PresetSpellID7")
    private Integer presetSpellId7;
    @Column("PresetSpellID8")
    private Integer presetSpellId8;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SpellShapeshiftForm> {

        public SpellShapeshiftForm convert(Row row) {
            SpellShapeshiftForm domain = new SpellShapeshiftForm();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setCreatureType(row.get("CreatureType", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setAttackIconFileId(row.get("AttackIconFileID", Integer.class));
            domain.setBonusActionBar(row.get("BonusActionBar", Integer.class));
            domain.setCombatRoundTime(row.get("CombatRoundTime", Integer.class));
            domain.setDamageVariance(row.get("DamageVariance", Double.class));
            domain.setMountTypeId(row.get("MountTypeID", Integer.class));
            domain.setCreatureDisplayId1(row.get("CreatureDisplayID1", Integer.class));
            domain.setCreatureDisplayId2(row.get("CreatureDisplayID2", Integer.class));
            domain.setCreatureDisplayId3(row.get("CreatureDisplayID3", Integer.class));
            domain.setCreatureDisplayId4(row.get("CreatureDisplayID4", Integer.class));
            domain.setPresetSpellId1(row.get("PresetSpellID1", Integer.class));
            domain.setPresetSpellId2(row.get("PresetSpellID2", Integer.class));
            domain.setPresetSpellId3(row.get("PresetSpellID3", Integer.class));
            domain.setPresetSpellId4(row.get("PresetSpellID4", Integer.class));
            domain.setPresetSpellId5(row.get("PresetSpellID5", Integer.class));
            domain.setPresetSpellId6(row.get("PresetSpellID6", Integer.class));
            domain.setPresetSpellId7(row.get("PresetSpellID7", Integer.class));
            domain.setPresetSpellId8(row.get("PresetSpellID8", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SpellShapeshiftForm, OutboundRow> {

        public OutboundRow convert(SpellShapeshiftForm source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureType()).ifPresent(e -> row.put("CreatureType", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getAttackIconFileId()).ifPresent(e -> row.put("AttackIconFileID", Parameter.from(e)));
            Optional.ofNullable(source.getBonusActionBar()).ifPresent(e -> row.put("BonusActionBar", Parameter.from(e)));
            Optional.ofNullable(source.getCombatRoundTime()).ifPresent(e -> row.put("CombatRoundTime", Parameter.from(e)));
            Optional.ofNullable(source.getDamageVariance()).ifPresent(e -> row.put("DamageVariance", Parameter.from(e)));
            Optional.ofNullable(source.getMountTypeId()).ifPresent(e -> row.put("MountTypeID", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureDisplayId1()).ifPresent(e -> row.put("CreatureDisplayID1", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureDisplayId2()).ifPresent(e -> row.put("CreatureDisplayID2", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureDisplayId3()).ifPresent(e -> row.put("CreatureDisplayID3", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureDisplayId4()).ifPresent(e -> row.put("CreatureDisplayID4", Parameter.from(e)));
            Optional.ofNullable(source.getPresetSpellId1()).ifPresent(e -> row.put("PresetSpellID1", Parameter.from(e)));
            Optional.ofNullable(source.getPresetSpellId2()).ifPresent(e -> row.put("PresetSpellID2", Parameter.from(e)));
            Optional.ofNullable(source.getPresetSpellId3()).ifPresent(e -> row.put("PresetSpellID3", Parameter.from(e)));
            Optional.ofNullable(source.getPresetSpellId4()).ifPresent(e -> row.put("PresetSpellID4", Parameter.from(e)));
            Optional.ofNullable(source.getPresetSpellId5()).ifPresent(e -> row.put("PresetSpellID5", Parameter.from(e)));
            Optional.ofNullable(source.getPresetSpellId6()).ifPresent(e -> row.put("PresetSpellID6", Parameter.from(e)));
            Optional.ofNullable(source.getPresetSpellId7()).ifPresent(e -> row.put("PresetSpellID7", Parameter.from(e)));
            Optional.ofNullable(source.getPresetSpellId8()).ifPresent(e -> row.put("PresetSpellID8", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
