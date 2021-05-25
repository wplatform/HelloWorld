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
@Table("durability_costs")
public class DurabilityCosts {

    @Column("ID")
    private Integer id;
    @Column("WeaponSubClassCost1")
    private Integer weaponSubClassCost1;
    @Column("WeaponSubClassCost2")
    private Integer weaponSubClassCost2;
    @Column("WeaponSubClassCost3")
    private Integer weaponSubClassCost3;
    @Column("WeaponSubClassCost4")
    private Integer weaponSubClassCost4;
    @Column("WeaponSubClassCost5")
    private Integer weaponSubClassCost5;
    @Column("WeaponSubClassCost6")
    private Integer weaponSubClassCost6;
    @Column("WeaponSubClassCost7")
    private Integer weaponSubClassCost7;
    @Column("WeaponSubClassCost8")
    private Integer weaponSubClassCost8;
    @Column("WeaponSubClassCost9")
    private Integer weaponSubClassCost9;
    @Column("WeaponSubClassCost10")
    private Integer weaponSubClassCost10;
    @Column("WeaponSubClassCost11")
    private Integer weaponSubClassCost11;
    @Column("WeaponSubClassCost12")
    private Integer weaponSubClassCost12;
    @Column("WeaponSubClassCost13")
    private Integer weaponSubClassCost13;
    @Column("WeaponSubClassCost14")
    private Integer weaponSubClassCost14;
    @Column("WeaponSubClassCost15")
    private Integer weaponSubClassCost15;
    @Column("WeaponSubClassCost16")
    private Integer weaponSubClassCost16;
    @Column("WeaponSubClassCost17")
    private Integer weaponSubClassCost17;
    @Column("WeaponSubClassCost18")
    private Integer weaponSubClassCost18;
    @Column("WeaponSubClassCost19")
    private Integer weaponSubClassCost19;
    @Column("WeaponSubClassCost20")
    private Integer weaponSubClassCost20;
    @Column("WeaponSubClassCost21")
    private Integer weaponSubClassCost21;
    @Column("ArmorSubClassCost1")
    private Integer armorSubClassCost1;
    @Column("ArmorSubClassCost2")
    private Integer armorSubClassCost2;
    @Column("ArmorSubClassCost3")
    private Integer armorSubClassCost3;
    @Column("ArmorSubClassCost4")
    private Integer armorSubClassCost4;
    @Column("ArmorSubClassCost5")
    private Integer armorSubClassCost5;
    @Column("ArmorSubClassCost6")
    private Integer armorSubClassCost6;
    @Column("ArmorSubClassCost7")
    private Integer armorSubClassCost7;
    @Column("ArmorSubClassCost8")
    private Integer armorSubClassCost8;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, DurabilityCosts> {

        public DurabilityCosts convert(Row row) {
            DurabilityCosts domain = new DurabilityCosts();
            domain.setId(row.get("ID", Integer.class));
            domain.setWeaponSubClassCost1(row.get("WeaponSubClassCost1", Integer.class));
            domain.setWeaponSubClassCost2(row.get("WeaponSubClassCost2", Integer.class));
            domain.setWeaponSubClassCost3(row.get("WeaponSubClassCost3", Integer.class));
            domain.setWeaponSubClassCost4(row.get("WeaponSubClassCost4", Integer.class));
            domain.setWeaponSubClassCost5(row.get("WeaponSubClassCost5", Integer.class));
            domain.setWeaponSubClassCost6(row.get("WeaponSubClassCost6", Integer.class));
            domain.setWeaponSubClassCost7(row.get("WeaponSubClassCost7", Integer.class));
            domain.setWeaponSubClassCost8(row.get("WeaponSubClassCost8", Integer.class));
            domain.setWeaponSubClassCost9(row.get("WeaponSubClassCost9", Integer.class));
            domain.setWeaponSubClassCost10(row.get("WeaponSubClassCost10", Integer.class));
            domain.setWeaponSubClassCost11(row.get("WeaponSubClassCost11", Integer.class));
            domain.setWeaponSubClassCost12(row.get("WeaponSubClassCost12", Integer.class));
            domain.setWeaponSubClassCost13(row.get("WeaponSubClassCost13", Integer.class));
            domain.setWeaponSubClassCost14(row.get("WeaponSubClassCost14", Integer.class));
            domain.setWeaponSubClassCost15(row.get("WeaponSubClassCost15", Integer.class));
            domain.setWeaponSubClassCost16(row.get("WeaponSubClassCost16", Integer.class));
            domain.setWeaponSubClassCost17(row.get("WeaponSubClassCost17", Integer.class));
            domain.setWeaponSubClassCost18(row.get("WeaponSubClassCost18", Integer.class));
            domain.setWeaponSubClassCost19(row.get("WeaponSubClassCost19", Integer.class));
            domain.setWeaponSubClassCost20(row.get("WeaponSubClassCost20", Integer.class));
            domain.setWeaponSubClassCost21(row.get("WeaponSubClassCost21", Integer.class));
            domain.setArmorSubClassCost1(row.get("ArmorSubClassCost1", Integer.class));
            domain.setArmorSubClassCost2(row.get("ArmorSubClassCost2", Integer.class));
            domain.setArmorSubClassCost3(row.get("ArmorSubClassCost3", Integer.class));
            domain.setArmorSubClassCost4(row.get("ArmorSubClassCost4", Integer.class));
            domain.setArmorSubClassCost5(row.get("ArmorSubClassCost5", Integer.class));
            domain.setArmorSubClassCost6(row.get("ArmorSubClassCost6", Integer.class));
            domain.setArmorSubClassCost7(row.get("ArmorSubClassCost7", Integer.class));
            domain.setArmorSubClassCost8(row.get("ArmorSubClassCost8", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<DurabilityCosts, OutboundRow> {

        public OutboundRow convert(DurabilityCosts source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost1()).ifPresent(e -> row.put("WeaponSubClassCost1", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost2()).ifPresent(e -> row.put("WeaponSubClassCost2", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost3()).ifPresent(e -> row.put("WeaponSubClassCost3", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost4()).ifPresent(e -> row.put("WeaponSubClassCost4", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost5()).ifPresent(e -> row.put("WeaponSubClassCost5", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost6()).ifPresent(e -> row.put("WeaponSubClassCost6", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost7()).ifPresent(e -> row.put("WeaponSubClassCost7", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost8()).ifPresent(e -> row.put("WeaponSubClassCost8", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost9()).ifPresent(e -> row.put("WeaponSubClassCost9", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost10()).ifPresent(e -> row.put("WeaponSubClassCost10", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost11()).ifPresent(e -> row.put("WeaponSubClassCost11", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost12()).ifPresent(e -> row.put("WeaponSubClassCost12", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost13()).ifPresent(e -> row.put("WeaponSubClassCost13", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost14()).ifPresent(e -> row.put("WeaponSubClassCost14", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost15()).ifPresent(e -> row.put("WeaponSubClassCost15", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost16()).ifPresent(e -> row.put("WeaponSubClassCost16", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost17()).ifPresent(e -> row.put("WeaponSubClassCost17", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost18()).ifPresent(e -> row.put("WeaponSubClassCost18", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost19()).ifPresent(e -> row.put("WeaponSubClassCost19", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost20()).ifPresent(e -> row.put("WeaponSubClassCost20", Parameter.from(e)));
            Optional.ofNullable(source.getWeaponSubClassCost21()).ifPresent(e -> row.put("WeaponSubClassCost21", Parameter.from(e)));
            Optional.ofNullable(source.getArmorSubClassCost1()).ifPresent(e -> row.put("ArmorSubClassCost1", Parameter.from(e)));
            Optional.ofNullable(source.getArmorSubClassCost2()).ifPresent(e -> row.put("ArmorSubClassCost2", Parameter.from(e)));
            Optional.ofNullable(source.getArmorSubClassCost3()).ifPresent(e -> row.put("ArmorSubClassCost3", Parameter.from(e)));
            Optional.ofNullable(source.getArmorSubClassCost4()).ifPresent(e -> row.put("ArmorSubClassCost4", Parameter.from(e)));
            Optional.ofNullable(source.getArmorSubClassCost5()).ifPresent(e -> row.put("ArmorSubClassCost5", Parameter.from(e)));
            Optional.ofNullable(source.getArmorSubClassCost6()).ifPresent(e -> row.put("ArmorSubClassCost6", Parameter.from(e)));
            Optional.ofNullable(source.getArmorSubClassCost7()).ifPresent(e -> row.put("ArmorSubClassCost7", Parameter.from(e)));
            Optional.ofNullable(source.getArmorSubClassCost8()).ifPresent(e -> row.put("ArmorSubClassCost8", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
