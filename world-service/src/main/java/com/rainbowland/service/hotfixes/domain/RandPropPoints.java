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
@Table("rand_prop_points")
public class RandPropPoints {

    @Column("ID")
    private Integer id;
    @Column("DamageReplaceStatF")
    private Double damageReplaceStatF;
    @Column("DamageSecondaryF")
    private Double damageSecondaryF;
    @Column("DamageReplaceStat")
    private Integer damageReplaceStat;
    @Column("DamageSecondary")
    private Integer damageSecondary;
    @Column("EpicF1")
    private Double epicF1;
    @Column("EpicF2")
    private Double epicF2;
    @Column("EpicF3")
    private Double epicF3;
    @Column("EpicF4")
    private Double epicF4;
    @Column("EpicF5")
    private Double epicF5;
    @Column("Epic1")
    private Integer epic1;
    @Column("Epic2")
    private Integer epic2;
    @Column("Epic3")
    private Integer epic3;
    @Column("Epic4")
    private Integer epic4;
    @Column("Epic5")
    private Integer epic5;
    @Column("SuperiorF1")
    private Double superiorF1;
    @Column("SuperiorF2")
    private Double superiorF2;
    @Column("SuperiorF3")
    private Double superiorF3;
    @Column("SuperiorF4")
    private Double superiorF4;
    @Column("SuperiorF5")
    private Double superiorF5;
    @Column("GoodF1")
    private Double goodF1;
    @Column("GoodF2")
    private Double goodF2;
    @Column("GoodF3")
    private Double goodF3;
    @Column("GoodF4")
    private Double goodF4;
    @Column("GoodF5")
    private Double goodF5;
    @Column("Superior1")
    private Integer superior1;
    @Column("Superior2")
    private Integer superior2;
    @Column("Superior3")
    private Integer superior3;
    @Column("Superior4")
    private Integer superior4;
    @Column("Superior5")
    private Integer superior5;
    @Column("Good1")
    private Integer good1;
    @Column("Good2")
    private Integer good2;
    @Column("Good3")
    private Integer good3;
    @Column("Good4")
    private Integer good4;
    @Column("Good5")
    private Integer good5;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, RandPropPoints> {

        public RandPropPoints convert(Row row) {
            RandPropPoints domain = new RandPropPoints();
            domain.setId(row.get("ID", Integer.class));
            domain.setDamageReplaceStatF(row.get("DamageReplaceStatF", Double.class));
            domain.setDamageSecondaryF(row.get("DamageSecondaryF", Double.class));
            domain.setDamageReplaceStat(row.get("DamageReplaceStat", Integer.class));
            domain.setDamageSecondary(row.get("DamageSecondary", Integer.class));
            domain.setEpicF1(row.get("EpicF1", Double.class));
            domain.setEpicF2(row.get("EpicF2", Double.class));
            domain.setEpicF3(row.get("EpicF3", Double.class));
            domain.setEpicF4(row.get("EpicF4", Double.class));
            domain.setEpicF5(row.get("EpicF5", Double.class));
            domain.setEpic1(row.get("Epic1", Integer.class));
            domain.setEpic2(row.get("Epic2", Integer.class));
            domain.setEpic3(row.get("Epic3", Integer.class));
            domain.setEpic4(row.get("Epic4", Integer.class));
            domain.setEpic5(row.get("Epic5", Integer.class));
            domain.setSuperiorF1(row.get("SuperiorF1", Double.class));
            domain.setSuperiorF2(row.get("SuperiorF2", Double.class));
            domain.setSuperiorF3(row.get("SuperiorF3", Double.class));
            domain.setSuperiorF4(row.get("SuperiorF4", Double.class));
            domain.setSuperiorF5(row.get("SuperiorF5", Double.class));
            domain.setGoodF1(row.get("GoodF1", Double.class));
            domain.setGoodF2(row.get("GoodF2", Double.class));
            domain.setGoodF3(row.get("GoodF3", Double.class));
            domain.setGoodF4(row.get("GoodF4", Double.class));
            domain.setGoodF5(row.get("GoodF5", Double.class));
            domain.setSuperior1(row.get("Superior1", Integer.class));
            domain.setSuperior2(row.get("Superior2", Integer.class));
            domain.setSuperior3(row.get("Superior3", Integer.class));
            domain.setSuperior4(row.get("Superior4", Integer.class));
            domain.setSuperior5(row.get("Superior5", Integer.class));
            domain.setGood1(row.get("Good1", Integer.class));
            domain.setGood2(row.get("Good2", Integer.class));
            domain.setGood3(row.get("Good3", Integer.class));
            domain.setGood4(row.get("Good4", Integer.class));
            domain.setGood5(row.get("Good5", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<RandPropPoints, OutboundRow> {

        public OutboundRow convert(RandPropPoints source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getDamageReplaceStatF()).ifPresent(e -> row.put("DamageReplaceStatF", Parameter.from(e)));
            Optional.ofNullable(source.getDamageSecondaryF()).ifPresent(e -> row.put("DamageSecondaryF", Parameter.from(e)));
            Optional.ofNullable(source.getDamageReplaceStat()).ifPresent(e -> row.put("DamageReplaceStat", Parameter.from(e)));
            Optional.ofNullable(source.getDamageSecondary()).ifPresent(e -> row.put("DamageSecondary", Parameter.from(e)));
            Optional.ofNullable(source.getEpicF1()).ifPresent(e -> row.put("EpicF1", Parameter.from(e)));
            Optional.ofNullable(source.getEpicF2()).ifPresent(e -> row.put("EpicF2", Parameter.from(e)));
            Optional.ofNullable(source.getEpicF3()).ifPresent(e -> row.put("EpicF3", Parameter.from(e)));
            Optional.ofNullable(source.getEpicF4()).ifPresent(e -> row.put("EpicF4", Parameter.from(e)));
            Optional.ofNullable(source.getEpicF5()).ifPresent(e -> row.put("EpicF5", Parameter.from(e)));
            Optional.ofNullable(source.getEpic1()).ifPresent(e -> row.put("Epic1", Parameter.from(e)));
            Optional.ofNullable(source.getEpic2()).ifPresent(e -> row.put("Epic2", Parameter.from(e)));
            Optional.ofNullable(source.getEpic3()).ifPresent(e -> row.put("Epic3", Parameter.from(e)));
            Optional.ofNullable(source.getEpic4()).ifPresent(e -> row.put("Epic4", Parameter.from(e)));
            Optional.ofNullable(source.getEpic5()).ifPresent(e -> row.put("Epic5", Parameter.from(e)));
            Optional.ofNullable(source.getSuperiorF1()).ifPresent(e -> row.put("SuperiorF1", Parameter.from(e)));
            Optional.ofNullable(source.getSuperiorF2()).ifPresent(e -> row.put("SuperiorF2", Parameter.from(e)));
            Optional.ofNullable(source.getSuperiorF3()).ifPresent(e -> row.put("SuperiorF3", Parameter.from(e)));
            Optional.ofNullable(source.getSuperiorF4()).ifPresent(e -> row.put("SuperiorF4", Parameter.from(e)));
            Optional.ofNullable(source.getSuperiorF5()).ifPresent(e -> row.put("SuperiorF5", Parameter.from(e)));
            Optional.ofNullable(source.getGoodF1()).ifPresent(e -> row.put("GoodF1", Parameter.from(e)));
            Optional.ofNullable(source.getGoodF2()).ifPresent(e -> row.put("GoodF2", Parameter.from(e)));
            Optional.ofNullable(source.getGoodF3()).ifPresent(e -> row.put("GoodF3", Parameter.from(e)));
            Optional.ofNullable(source.getGoodF4()).ifPresent(e -> row.put("GoodF4", Parameter.from(e)));
            Optional.ofNullable(source.getGoodF5()).ifPresent(e -> row.put("GoodF5", Parameter.from(e)));
            Optional.ofNullable(source.getSuperior1()).ifPresent(e -> row.put("Superior1", Parameter.from(e)));
            Optional.ofNullable(source.getSuperior2()).ifPresent(e -> row.put("Superior2", Parameter.from(e)));
            Optional.ofNullable(source.getSuperior3()).ifPresent(e -> row.put("Superior3", Parameter.from(e)));
            Optional.ofNullable(source.getSuperior4()).ifPresent(e -> row.put("Superior4", Parameter.from(e)));
            Optional.ofNullable(source.getSuperior5()).ifPresent(e -> row.put("Superior5", Parameter.from(e)));
            Optional.ofNullable(source.getGood1()).ifPresent(e -> row.put("Good1", Parameter.from(e)));
            Optional.ofNullable(source.getGood2()).ifPresent(e -> row.put("Good2", Parameter.from(e)));
            Optional.ofNullable(source.getGood3()).ifPresent(e -> row.put("Good3", Parameter.from(e)));
            Optional.ofNullable(source.getGood4()).ifPresent(e -> row.put("Good4", Parameter.from(e)));
            Optional.ofNullable(source.getGood5()).ifPresent(e -> row.put("Good5", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
