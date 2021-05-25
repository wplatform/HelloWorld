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
@Table("expected_stat_mod")
public class ExpectedStatMod {

    @Column("ID")
    private Integer id;
    @Column("CreatureHealthMod")
    private Double creatureHealthMod;
    @Column("PlayerHealthMod")
    private Double playerHealthMod;
    @Column("CreatureAutoAttackDPSMod")
    private Double creatureAutoAttackDpsMod;
    @Column("CreatureArmorMod")
    private Double creatureArmorMod;
    @Column("PlayerManaMod")
    private Double playerManaMod;
    @Column("PlayerPrimaryStatMod")
    private Double playerPrimaryStatMod;
    @Column("PlayerSecondaryStatMod")
    private Double playerSecondaryStatMod;
    @Column("ArmorConstantMod")
    private Double armorConstantMod;
    @Column("CreatureSpellDamageMod")
    private Double creatureSpellDamageMod;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ExpectedStatMod> {

        public ExpectedStatMod convert(Row row) {
            ExpectedStatMod domain = new ExpectedStatMod();
            domain.setId(row.get("ID", Integer.class));
            domain.setCreatureHealthMod(row.get("CreatureHealthMod", Double.class));
            domain.setPlayerHealthMod(row.get("PlayerHealthMod", Double.class));
            domain.setCreatureAutoAttackDpsMod(row.get("CreatureAutoAttackDPSMod", Double.class));
            domain.setCreatureArmorMod(row.get("CreatureArmorMod", Double.class));
            domain.setPlayerManaMod(row.get("PlayerManaMod", Double.class));
            domain.setPlayerPrimaryStatMod(row.get("PlayerPrimaryStatMod", Double.class));
            domain.setPlayerSecondaryStatMod(row.get("PlayerSecondaryStatMod", Double.class));
            domain.setArmorConstantMod(row.get("ArmorConstantMod", Double.class));
            domain.setCreatureSpellDamageMod(row.get("CreatureSpellDamageMod", Double.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ExpectedStatMod, OutboundRow> {

        public OutboundRow convert(ExpectedStatMod source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureHealthMod()).ifPresent(e -> row.put("CreatureHealthMod", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerHealthMod()).ifPresent(e -> row.put("PlayerHealthMod", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureAutoAttackDpsMod()).ifPresent(e -> row.put("CreatureAutoAttackDPSMod", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureArmorMod()).ifPresent(e -> row.put("CreatureArmorMod", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerManaMod()).ifPresent(e -> row.put("PlayerManaMod", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerPrimaryStatMod()).ifPresent(e -> row.put("PlayerPrimaryStatMod", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerSecondaryStatMod()).ifPresent(e -> row.put("PlayerSecondaryStatMod", Parameter.from(e)));
            Optional.ofNullable(source.getArmorConstantMod()).ifPresent(e -> row.put("ArmorConstantMod", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureSpellDamageMod()).ifPresent(e -> row.put("CreatureSpellDamageMod", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
