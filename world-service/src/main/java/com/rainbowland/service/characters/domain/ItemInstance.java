package com.rainbowland.service.characters.domain;

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
@Table("item_instance")
public class ItemInstance {

    @Column("guid")
    private Long guid;
    @Column("itemEntry")
    private Integer itemEntry;
    @Column("owner_guid")
    private Long ownerGuid;
    @Column("creatorGuid")
    private Long creatorGuid;
    @Column("giftCreatorGuid")
    private Long giftCreatorGuid;
    @Column("count")
    private Integer count;
    @Column("duration")
    private Integer duration;
    @Column("charges")
    private String charges;
    @Column("flags")
    private Integer flags;
    @Column("enchantments")
    private String enchantments;
    @Column("randomBonusListId")
    private Integer randomBonusListId;
    @Column("durability")
    private Integer durability;
    @Column("playedTime")
    private Integer playedTime;
    @Column("text")
    private String text;
    @Column("transmogrification")
    private Integer transmogrification;
    @Column("enchantIllusion")
    private Integer enchantIllusion;
    @Column("battlePetSpeciesId")
    private Integer battlePetSpeciesId;
    @Column("battlePetBreedData")
    private Integer battlePetBreedData;
    @Column("battlePetLevel")
    private Integer battlePetLevel;
    @Column("battlePetDisplayId")
    private Integer battlePetDisplayId;
    @Column("context")
    private Integer context;
    @Column("bonusListIDs")
    private String bonusListIDs;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ItemInstance> {

        public ItemInstance convert(Row row) {
            ItemInstance domain = new ItemInstance();
            domain.setGuid(row.get("guid", Long.class));
            domain.setItemEntry(row.get("itemEntry", Integer.class));
            domain.setOwnerGuid(row.get("owner_guid", Long.class));
            domain.setCreatorGuid(row.get("creatorGuid", Long.class));
            domain.setGiftCreatorGuid(row.get("giftCreatorGuid", Long.class));
            domain.setCount(row.get("count", Integer.class));
            domain.setDuration(row.get("duration", Integer.class));
            domain.setCharges(row.get("charges", String.class));
            domain.setFlags(row.get("flags", Integer.class));
            domain.setEnchantments(row.get("enchantments", String.class));
            domain.setRandomBonusListId(row.get("randomBonusListId", Integer.class));
            domain.setDurability(row.get("durability", Integer.class));
            domain.setPlayedTime(row.get("playedTime", Integer.class));
            domain.setText(row.get("text", String.class));
            domain.setTransmogrification(row.get("transmogrification", Integer.class));
            domain.setEnchantIllusion(row.get("enchantIllusion", Integer.class));
            domain.setBattlePetSpeciesId(row.get("battlePetSpeciesId", Integer.class));
            domain.setBattlePetBreedData(row.get("battlePetBreedData", Integer.class));
            domain.setBattlePetLevel(row.get("battlePetLevel", Integer.class));
            domain.setBattlePetDisplayId(row.get("battlePetDisplayId", Integer.class));
            domain.setContext(row.get("context", Integer.class));
            domain.setBonusListIDs(row.get("bonusListIDs", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ItemInstance, OutboundRow> {

        public OutboundRow convert(ItemInstance source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getItemEntry()).ifPresent(e -> row.put("itemEntry", Parameter.from(e)));
            Optional.ofNullable(source.getOwnerGuid()).ifPresent(e -> row.put("owner_guid", Parameter.from(e)));
            Optional.ofNullable(source.getCreatorGuid()).ifPresent(e -> row.put("creatorGuid", Parameter.from(e)));
            Optional.ofNullable(source.getGiftCreatorGuid()).ifPresent(e -> row.put("giftCreatorGuid", Parameter.from(e)));
            Optional.ofNullable(source.getCount()).ifPresent(e -> row.put("count", Parameter.from(e)));
            Optional.ofNullable(source.getDuration()).ifPresent(e -> row.put("duration", Parameter.from(e)));
            Optional.ofNullable(source.getCharges()).ifPresent(e -> row.put("charges", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("flags", Parameter.from(e)));
            Optional.ofNullable(source.getEnchantments()).ifPresent(e -> row.put("enchantments", Parameter.from(e)));
            Optional.ofNullable(source.getRandomBonusListId()).ifPresent(e -> row.put("randomBonusListId", Parameter.from(e)));
            Optional.ofNullable(source.getDurability()).ifPresent(e -> row.put("durability", Parameter.from(e)));
            Optional.ofNullable(source.getPlayedTime()).ifPresent(e -> row.put("playedTime", Parameter.from(e)));
            Optional.ofNullable(source.getText()).ifPresent(e -> row.put("text", Parameter.from(e)));
            Optional.ofNullable(source.getTransmogrification()).ifPresent(e -> row.put("transmogrification", Parameter.from(e)));
            Optional.ofNullable(source.getEnchantIllusion()).ifPresent(e -> row.put("enchantIllusion", Parameter.from(e)));
            Optional.ofNullable(source.getBattlePetSpeciesId()).ifPresent(e -> row.put("battlePetSpeciesId", Parameter.from(e)));
            Optional.ofNullable(source.getBattlePetBreedData()).ifPresent(e -> row.put("battlePetBreedData", Parameter.from(e)));
            Optional.ofNullable(source.getBattlePetLevel()).ifPresent(e -> row.put("battlePetLevel", Parameter.from(e)));
            Optional.ofNullable(source.getBattlePetDisplayId()).ifPresent(e -> row.put("battlePetDisplayId", Parameter.from(e)));
            Optional.ofNullable(source.getContext()).ifPresent(e -> row.put("context", Parameter.from(e)));
            Optional.ofNullable(source.getBonusListIDs()).ifPresent(e -> row.put("bonusListIDs", Parameter.from(e)));
            return row;
        }
    }

}
