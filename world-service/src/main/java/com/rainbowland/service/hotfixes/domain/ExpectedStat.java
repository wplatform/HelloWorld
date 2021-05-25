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
@Table("expected_stat")
public class ExpectedStat {

    @Column("ID")
    private Integer id;
    @Column("ExpansionID")
    private Integer expansionId;
    @Column("CreatureHealth")
    private Double creatureHealth;
    @Column("PlayerHealth")
    private Double playerHealth;
    @Column("CreatureAutoAttackDps")
    private Double creatureAutoAttackDps;
    @Column("CreatureArmor")
    private Double creatureArmor;
    @Column("PlayerMana")
    private Double playerMana;
    @Column("PlayerPrimaryStat")
    private Double playerPrimaryStat;
    @Column("PlayerSecondaryStat")
    private Double playerSecondaryStat;
    @Column("ArmorConstant")
    private Double armorConstant;
    @Column("CreatureSpellDamage")
    private Double creatureSpellDamage;
    @Column("Lvl")
    private Integer lvl;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ExpectedStat> {

        public ExpectedStat convert(Row row) {
            ExpectedStat domain = new ExpectedStat();
            domain.setId(row.get("ID", Integer.class));
            domain.setExpansionId(row.get("ExpansionID", Integer.class));
            domain.setCreatureHealth(row.get("CreatureHealth", Double.class));
            domain.setPlayerHealth(row.get("PlayerHealth", Double.class));
            domain.setCreatureAutoAttackDps(row.get("CreatureAutoAttackDps", Double.class));
            domain.setCreatureArmor(row.get("CreatureArmor", Double.class));
            domain.setPlayerMana(row.get("PlayerMana", Double.class));
            domain.setPlayerPrimaryStat(row.get("PlayerPrimaryStat", Double.class));
            domain.setPlayerSecondaryStat(row.get("PlayerSecondaryStat", Double.class));
            domain.setArmorConstant(row.get("ArmorConstant", Double.class));
            domain.setCreatureSpellDamage(row.get("CreatureSpellDamage", Double.class));
            domain.setLvl(row.get("Lvl", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ExpectedStat, OutboundRow> {

        public OutboundRow convert(ExpectedStat source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getExpansionId()).ifPresent(e -> row.put("ExpansionID", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureHealth()).ifPresent(e -> row.put("CreatureHealth", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerHealth()).ifPresent(e -> row.put("PlayerHealth", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureAutoAttackDps()).ifPresent(e -> row.put("CreatureAutoAttackDps", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureArmor()).ifPresent(e -> row.put("CreatureArmor", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerMana()).ifPresent(e -> row.put("PlayerMana", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerPrimaryStat()).ifPresent(e -> row.put("PlayerPrimaryStat", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerSecondaryStat()).ifPresent(e -> row.put("PlayerSecondaryStat", Parameter.from(e)));
            Optional.ofNullable(source.getArmorConstant()).ifPresent(e -> row.put("ArmorConstant", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureSpellDamage()).ifPresent(e -> row.put("CreatureSpellDamage", Parameter.from(e)));
            Optional.ofNullable(source.getLvl()).ifPresent(e -> row.put("Lvl", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
