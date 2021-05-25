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
@Table("unit_power_bar")
public class UnitPowerBar {

    @Column("ID")
    private Integer id;
    @Column("Name")
    private String name;
    @Column("Cost")
    private String cost;
    @Column("OutOfError")
    private String outOfError;
    @Column("ToolTip")
    private String toolTip;
    @Column("MinPower")
    private Integer minPower;
    @Column("MaxPower")
    private Integer maxPower;
    @Column("StartPower")
    private Integer startPower;
    @Column("CenterPower")
    private Integer centerPower;
    @Column("RegenerationPeace")
    private Double regenerationPeace;
    @Column("RegenerationCombat")
    private Double regenerationCombat;
    @Column("BarType")
    private Integer barType;
    @Column("Flags")
    private Integer flags;
    @Column("StartInset")
    private Double startInset;
    @Column("EndInset")
    private Double endInset;
    @Column("FileDataID1")
    private Integer fileDataId1;
    @Column("FileDataID2")
    private Integer fileDataId2;
    @Column("FileDataID3")
    private Integer fileDataId3;
    @Column("FileDataID4")
    private Integer fileDataId4;
    @Column("FileDataID5")
    private Integer fileDataId5;
    @Column("FileDataID6")
    private Integer fileDataId6;
    @Column("Color1")
    private Integer color1;
    @Column("Color2")
    private Integer color2;
    @Column("Color3")
    private Integer color3;
    @Column("Color4")
    private Integer color4;
    @Column("Color5")
    private Integer color5;
    @Column("Color6")
    private Integer color6;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, UnitPowerBar> {

        public UnitPowerBar convert(Row row) {
            UnitPowerBar domain = new UnitPowerBar();
            domain.setId(row.get("ID", Integer.class));
            domain.setName(row.get("Name", String.class));
            domain.setCost(row.get("Cost", String.class));
            domain.setOutOfError(row.get("OutOfError", String.class));
            domain.setToolTip(row.get("ToolTip", String.class));
            domain.setMinPower(row.get("MinPower", Integer.class));
            domain.setMaxPower(row.get("MaxPower", Integer.class));
            domain.setStartPower(row.get("StartPower", Integer.class));
            domain.setCenterPower(row.get("CenterPower", Integer.class));
            domain.setRegenerationPeace(row.get("RegenerationPeace", Double.class));
            domain.setRegenerationCombat(row.get("RegenerationCombat", Double.class));
            domain.setBarType(row.get("BarType", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setStartInset(row.get("StartInset", Double.class));
            domain.setEndInset(row.get("EndInset", Double.class));
            domain.setFileDataId1(row.get("FileDataID1", Integer.class));
            domain.setFileDataId2(row.get("FileDataID2", Integer.class));
            domain.setFileDataId3(row.get("FileDataID3", Integer.class));
            domain.setFileDataId4(row.get("FileDataID4", Integer.class));
            domain.setFileDataId5(row.get("FileDataID5", Integer.class));
            domain.setFileDataId6(row.get("FileDataID6", Integer.class));
            domain.setColor1(row.get("Color1", Integer.class));
            domain.setColor2(row.get("Color2", Integer.class));
            domain.setColor3(row.get("Color3", Integer.class));
            domain.setColor4(row.get("Color4", Integer.class));
            domain.setColor5(row.get("Color5", Integer.class));
            domain.setColor6(row.get("Color6", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<UnitPowerBar, OutboundRow> {

        public OutboundRow convert(UnitPowerBar source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("Name", Parameter.from(e)));
            Optional.ofNullable(source.getCost()).ifPresent(e -> row.put("Cost", Parameter.from(e)));
            Optional.ofNullable(source.getOutOfError()).ifPresent(e -> row.put("OutOfError", Parameter.from(e)));
            Optional.ofNullable(source.getToolTip()).ifPresent(e -> row.put("ToolTip", Parameter.from(e)));
            Optional.ofNullable(source.getMinPower()).ifPresent(e -> row.put("MinPower", Parameter.from(e)));
            Optional.ofNullable(source.getMaxPower()).ifPresent(e -> row.put("MaxPower", Parameter.from(e)));
            Optional.ofNullable(source.getStartPower()).ifPresent(e -> row.put("StartPower", Parameter.from(e)));
            Optional.ofNullable(source.getCenterPower()).ifPresent(e -> row.put("CenterPower", Parameter.from(e)));
            Optional.ofNullable(source.getRegenerationPeace()).ifPresent(e -> row.put("RegenerationPeace", Parameter.from(e)));
            Optional.ofNullable(source.getRegenerationCombat()).ifPresent(e -> row.put("RegenerationCombat", Parameter.from(e)));
            Optional.ofNullable(source.getBarType()).ifPresent(e -> row.put("BarType", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getStartInset()).ifPresent(e -> row.put("StartInset", Parameter.from(e)));
            Optional.ofNullable(source.getEndInset()).ifPresent(e -> row.put("EndInset", Parameter.from(e)));
            Optional.ofNullable(source.getFileDataId1()).ifPresent(e -> row.put("FileDataID1", Parameter.from(e)));
            Optional.ofNullable(source.getFileDataId2()).ifPresent(e -> row.put("FileDataID2", Parameter.from(e)));
            Optional.ofNullable(source.getFileDataId3()).ifPresent(e -> row.put("FileDataID3", Parameter.from(e)));
            Optional.ofNullable(source.getFileDataId4()).ifPresent(e -> row.put("FileDataID4", Parameter.from(e)));
            Optional.ofNullable(source.getFileDataId5()).ifPresent(e -> row.put("FileDataID5", Parameter.from(e)));
            Optional.ofNullable(source.getFileDataId6()).ifPresent(e -> row.put("FileDataID6", Parameter.from(e)));
            Optional.ofNullable(source.getColor1()).ifPresent(e -> row.put("Color1", Parameter.from(e)));
            Optional.ofNullable(source.getColor2()).ifPresent(e -> row.put("Color2", Parameter.from(e)));
            Optional.ofNullable(source.getColor3()).ifPresent(e -> row.put("Color3", Parameter.from(e)));
            Optional.ofNullable(source.getColor4()).ifPresent(e -> row.put("Color4", Parameter.from(e)));
            Optional.ofNullable(source.getColor5()).ifPresent(e -> row.put("Color5", Parameter.from(e)));
            Optional.ofNullable(source.getColor6()).ifPresent(e -> row.put("Color6", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
