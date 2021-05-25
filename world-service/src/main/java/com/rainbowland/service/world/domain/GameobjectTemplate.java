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
@Table("gameobject_template")
public class GameobjectTemplate {

    @Column("entry")
    private Integer entry;
    @Column("type")
    private Integer type;
    @Column("displayId")
    private Integer displayId;
    @Column("name")
    private String name;
    @Column("IconName")
    private String iconName;
    @Column("castBarCaption")
    private String castBarCaption;
    @Column("unk1")
    private String unk1;
    @Column("size")
    private Double size;
    @Column("Data0")
    private Integer data0;
    @Column("Data1")
    private Integer data1;
    @Column("Data2")
    private Integer data2;
    @Column("Data3")
    private Integer data3;
    @Column("Data4")
    private Integer data4;
    @Column("Data5")
    private Integer data5;
    @Column("Data6")
    private Integer data6;
    @Column("Data7")
    private Integer data7;
    @Column("Data8")
    private Integer data8;
    @Column("Data9")
    private Integer data9;
    @Column("Data10")
    private Integer data10;
    @Column("Data11")
    private Integer data11;
    @Column("Data12")
    private Integer data12;
    @Column("Data13")
    private Integer data13;
    @Column("Data14")
    private Integer data14;
    @Column("Data15")
    private Integer data15;
    @Column("Data16")
    private Integer data16;
    @Column("Data17")
    private Integer data17;
    @Column("Data18")
    private Integer data18;
    @Column("Data19")
    private Integer data19;
    @Column("Data20")
    private Integer data20;
    @Column("Data21")
    private Integer data21;
    @Column("Data22")
    private Integer data22;
    @Column("Data23")
    private Integer data23;
    @Column("Data24")
    private Integer data24;
    @Column("Data25")
    private Integer data25;
    @Column("Data26")
    private Integer data26;
    @Column("Data27")
    private Integer data27;
    @Column("Data28")
    private Integer data28;
    @Column("Data29")
    private Integer data29;
    @Column("Data30")
    private Integer data30;
    @Column("Data31")
    private Integer data31;
    @Column("Data32")
    private Integer data32;
    @Column("Data33")
    private Integer data33;
    @Column("ContentTuningId")
    private Integer contentTuningId;
    @Column("AIName")
    private String aiName;
    @Column("ScriptName")
    private String scriptName;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GameobjectTemplate> {

        public GameobjectTemplate convert(Row row) {
            GameobjectTemplate domain = new GameobjectTemplate();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setType(row.get("type", Integer.class));
            domain.setDisplayId(row.get("displayId", Integer.class));
            domain.setName(row.get("name", String.class));
            domain.setIconName(row.get("IconName", String.class));
            domain.setCastBarCaption(row.get("castBarCaption", String.class));
            domain.setUnk1(row.get("unk1", String.class));
            domain.setSize(row.get("size", Double.class));
            domain.setData0(row.get("Data0", Integer.class));
            domain.setData1(row.get("Data1", Integer.class));
            domain.setData2(row.get("Data2", Integer.class));
            domain.setData3(row.get("Data3", Integer.class));
            domain.setData4(row.get("Data4", Integer.class));
            domain.setData5(row.get("Data5", Integer.class));
            domain.setData6(row.get("Data6", Integer.class));
            domain.setData7(row.get("Data7", Integer.class));
            domain.setData8(row.get("Data8", Integer.class));
            domain.setData9(row.get("Data9", Integer.class));
            domain.setData10(row.get("Data10", Integer.class));
            domain.setData11(row.get("Data11", Integer.class));
            domain.setData12(row.get("Data12", Integer.class));
            domain.setData13(row.get("Data13", Integer.class));
            domain.setData14(row.get("Data14", Integer.class));
            domain.setData15(row.get("Data15", Integer.class));
            domain.setData16(row.get("Data16", Integer.class));
            domain.setData17(row.get("Data17", Integer.class));
            domain.setData18(row.get("Data18", Integer.class));
            domain.setData19(row.get("Data19", Integer.class));
            domain.setData20(row.get("Data20", Integer.class));
            domain.setData21(row.get("Data21", Integer.class));
            domain.setData22(row.get("Data22", Integer.class));
            domain.setData23(row.get("Data23", Integer.class));
            domain.setData24(row.get("Data24", Integer.class));
            domain.setData25(row.get("Data25", Integer.class));
            domain.setData26(row.get("Data26", Integer.class));
            domain.setData27(row.get("Data27", Integer.class));
            domain.setData28(row.get("Data28", Integer.class));
            domain.setData29(row.get("Data29", Integer.class));
            domain.setData30(row.get("Data30", Integer.class));
            domain.setData31(row.get("Data31", Integer.class));
            domain.setData32(row.get("Data32", Integer.class));
            domain.setData33(row.get("Data33", Integer.class));
            domain.setContentTuningId(row.get("ContentTuningId", Integer.class));
            domain.setAiName(row.get("AIName", String.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GameobjectTemplate, OutboundRow> {

        public OutboundRow convert(GameobjectTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getDisplayId()).ifPresent(e -> row.put("displayId", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getIconName()).ifPresent(e -> row.put("IconName", Parameter.from(e)));
            Optional.ofNullable(source.getCastBarCaption()).ifPresent(e -> row.put("castBarCaption", Parameter.from(e)));
            Optional.ofNullable(source.getUnk1()).ifPresent(e -> row.put("unk1", Parameter.from(e)));
            Optional.ofNullable(source.getSize()).ifPresent(e -> row.put("size", Parameter.from(e)));
            Optional.ofNullable(source.getData0()).ifPresent(e -> row.put("Data0", Parameter.from(e)));
            Optional.ofNullable(source.getData1()).ifPresent(e -> row.put("Data1", Parameter.from(e)));
            Optional.ofNullable(source.getData2()).ifPresent(e -> row.put("Data2", Parameter.from(e)));
            Optional.ofNullable(source.getData3()).ifPresent(e -> row.put("Data3", Parameter.from(e)));
            Optional.ofNullable(source.getData4()).ifPresent(e -> row.put("Data4", Parameter.from(e)));
            Optional.ofNullable(source.getData5()).ifPresent(e -> row.put("Data5", Parameter.from(e)));
            Optional.ofNullable(source.getData6()).ifPresent(e -> row.put("Data6", Parameter.from(e)));
            Optional.ofNullable(source.getData7()).ifPresent(e -> row.put("Data7", Parameter.from(e)));
            Optional.ofNullable(source.getData8()).ifPresent(e -> row.put("Data8", Parameter.from(e)));
            Optional.ofNullable(source.getData9()).ifPresent(e -> row.put("Data9", Parameter.from(e)));
            Optional.ofNullable(source.getData10()).ifPresent(e -> row.put("Data10", Parameter.from(e)));
            Optional.ofNullable(source.getData11()).ifPresent(e -> row.put("Data11", Parameter.from(e)));
            Optional.ofNullable(source.getData12()).ifPresent(e -> row.put("Data12", Parameter.from(e)));
            Optional.ofNullable(source.getData13()).ifPresent(e -> row.put("Data13", Parameter.from(e)));
            Optional.ofNullable(source.getData14()).ifPresent(e -> row.put("Data14", Parameter.from(e)));
            Optional.ofNullable(source.getData15()).ifPresent(e -> row.put("Data15", Parameter.from(e)));
            Optional.ofNullable(source.getData16()).ifPresent(e -> row.put("Data16", Parameter.from(e)));
            Optional.ofNullable(source.getData17()).ifPresent(e -> row.put("Data17", Parameter.from(e)));
            Optional.ofNullable(source.getData18()).ifPresent(e -> row.put("Data18", Parameter.from(e)));
            Optional.ofNullable(source.getData19()).ifPresent(e -> row.put("Data19", Parameter.from(e)));
            Optional.ofNullable(source.getData20()).ifPresent(e -> row.put("Data20", Parameter.from(e)));
            Optional.ofNullable(source.getData21()).ifPresent(e -> row.put("Data21", Parameter.from(e)));
            Optional.ofNullable(source.getData22()).ifPresent(e -> row.put("Data22", Parameter.from(e)));
            Optional.ofNullable(source.getData23()).ifPresent(e -> row.put("Data23", Parameter.from(e)));
            Optional.ofNullable(source.getData24()).ifPresent(e -> row.put("Data24", Parameter.from(e)));
            Optional.ofNullable(source.getData25()).ifPresent(e -> row.put("Data25", Parameter.from(e)));
            Optional.ofNullable(source.getData26()).ifPresent(e -> row.put("Data26", Parameter.from(e)));
            Optional.ofNullable(source.getData27()).ifPresent(e -> row.put("Data27", Parameter.from(e)));
            Optional.ofNullable(source.getData28()).ifPresent(e -> row.put("Data28", Parameter.from(e)));
            Optional.ofNullable(source.getData29()).ifPresent(e -> row.put("Data29", Parameter.from(e)));
            Optional.ofNullable(source.getData30()).ifPresent(e -> row.put("Data30", Parameter.from(e)));
            Optional.ofNullable(source.getData31()).ifPresent(e -> row.put("Data31", Parameter.from(e)));
            Optional.ofNullable(source.getData32()).ifPresent(e -> row.put("Data32", Parameter.from(e)));
            Optional.ofNullable(source.getData33()).ifPresent(e -> row.put("Data33", Parameter.from(e)));
            Optional.ofNullable(source.getContentTuningId()).ifPresent(e -> row.put("ContentTuningId", Parameter.from(e)));
            Optional.ofNullable(source.getAiName()).ifPresent(e -> row.put("AIName", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
