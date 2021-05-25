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
@Table("holidays")
public class Holidays {

    @Column("ID")
    private Integer id;
    @Column("Region")
    private Integer region;
    @Column("Looping")
    private Integer looping;
    @Column("HolidayNameID")
    private Integer holidayNameId;
    @Column("HolidayDescriptionID")
    private Integer holidayDescriptionId;
    @Column("Priority")
    private Integer priority;
    @Column("CalendarFilterType")
    private Integer calendarFilterType;
    @Column("Flags")
    private Integer flags;
    @Column("Duration1")
    private Integer duration1;
    @Column("Duration2")
    private Integer duration2;
    @Column("Duration3")
    private Integer duration3;
    @Column("Duration4")
    private Integer duration4;
    @Column("Duration5")
    private Integer duration5;
    @Column("Duration6")
    private Integer duration6;
    @Column("Duration7")
    private Integer duration7;
    @Column("Duration8")
    private Integer duration8;
    @Column("Duration9")
    private Integer duration9;
    @Column("Duration10")
    private Integer duration10;
    @Column("Date1")
    private Integer date1;
    @Column("Date2")
    private Integer date2;
    @Column("Date3")
    private Integer date3;
    @Column("Date4")
    private Integer date4;
    @Column("Date5")
    private Integer date5;
    @Column("Date6")
    private Integer date6;
    @Column("Date7")
    private Integer date7;
    @Column("Date8")
    private Integer date8;
    @Column("Date9")
    private Integer date9;
    @Column("Date10")
    private Integer date10;
    @Column("Date11")
    private Integer date11;
    @Column("Date12")
    private Integer date12;
    @Column("Date13")
    private Integer date13;
    @Column("Date14")
    private Integer date14;
    @Column("Date15")
    private Integer date15;
    @Column("Date16")
    private Integer date16;
    @Column("Date17")
    private Integer date17;
    @Column("Date18")
    private Integer date18;
    @Column("Date19")
    private Integer date19;
    @Column("Date20")
    private Integer date20;
    @Column("Date21")
    private Integer date21;
    @Column("Date22")
    private Integer date22;
    @Column("Date23")
    private Integer date23;
    @Column("Date24")
    private Integer date24;
    @Column("Date25")
    private Integer date25;
    @Column("Date26")
    private Integer date26;
    @Column("CalendarFlags1")
    private Integer calendarFlags1;
    @Column("CalendarFlags2")
    private Integer calendarFlags2;
    @Column("CalendarFlags3")
    private Integer calendarFlags3;
    @Column("CalendarFlags4")
    private Integer calendarFlags4;
    @Column("CalendarFlags5")
    private Integer calendarFlags5;
    @Column("CalendarFlags6")
    private Integer calendarFlags6;
    @Column("CalendarFlags7")
    private Integer calendarFlags7;
    @Column("CalendarFlags8")
    private Integer calendarFlags8;
    @Column("CalendarFlags9")
    private Integer calendarFlags9;
    @Column("CalendarFlags10")
    private Integer calendarFlags10;
    @Column("TextureFileDataID1")
    private Integer textureFileDataId1;
    @Column("TextureFileDataID2")
    private Integer textureFileDataId2;
    @Column("TextureFileDataID3")
    private Integer textureFileDataId3;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Holidays> {

        public Holidays convert(Row row) {
            Holidays domain = new Holidays();
            domain.setId(row.get("ID", Integer.class));
            domain.setRegion(row.get("Region", Integer.class));
            domain.setLooping(row.get("Looping", Integer.class));
            domain.setHolidayNameId(row.get("HolidayNameID", Integer.class));
            domain.setHolidayDescriptionId(row.get("HolidayDescriptionID", Integer.class));
            domain.setPriority(row.get("Priority", Integer.class));
            domain.setCalendarFilterType(row.get("CalendarFilterType", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setDuration1(row.get("Duration1", Integer.class));
            domain.setDuration2(row.get("Duration2", Integer.class));
            domain.setDuration3(row.get("Duration3", Integer.class));
            domain.setDuration4(row.get("Duration4", Integer.class));
            domain.setDuration5(row.get("Duration5", Integer.class));
            domain.setDuration6(row.get("Duration6", Integer.class));
            domain.setDuration7(row.get("Duration7", Integer.class));
            domain.setDuration8(row.get("Duration8", Integer.class));
            domain.setDuration9(row.get("Duration9", Integer.class));
            domain.setDuration10(row.get("Duration10", Integer.class));
            domain.setDate1(row.get("Date1", Integer.class));
            domain.setDate2(row.get("Date2", Integer.class));
            domain.setDate3(row.get("Date3", Integer.class));
            domain.setDate4(row.get("Date4", Integer.class));
            domain.setDate5(row.get("Date5", Integer.class));
            domain.setDate6(row.get("Date6", Integer.class));
            domain.setDate7(row.get("Date7", Integer.class));
            domain.setDate8(row.get("Date8", Integer.class));
            domain.setDate9(row.get("Date9", Integer.class));
            domain.setDate10(row.get("Date10", Integer.class));
            domain.setDate11(row.get("Date11", Integer.class));
            domain.setDate12(row.get("Date12", Integer.class));
            domain.setDate13(row.get("Date13", Integer.class));
            domain.setDate14(row.get("Date14", Integer.class));
            domain.setDate15(row.get("Date15", Integer.class));
            domain.setDate16(row.get("Date16", Integer.class));
            domain.setDate17(row.get("Date17", Integer.class));
            domain.setDate18(row.get("Date18", Integer.class));
            domain.setDate19(row.get("Date19", Integer.class));
            domain.setDate20(row.get("Date20", Integer.class));
            domain.setDate21(row.get("Date21", Integer.class));
            domain.setDate22(row.get("Date22", Integer.class));
            domain.setDate23(row.get("Date23", Integer.class));
            domain.setDate24(row.get("Date24", Integer.class));
            domain.setDate25(row.get("Date25", Integer.class));
            domain.setDate26(row.get("Date26", Integer.class));
            domain.setCalendarFlags1(row.get("CalendarFlags1", Integer.class));
            domain.setCalendarFlags2(row.get("CalendarFlags2", Integer.class));
            domain.setCalendarFlags3(row.get("CalendarFlags3", Integer.class));
            domain.setCalendarFlags4(row.get("CalendarFlags4", Integer.class));
            domain.setCalendarFlags5(row.get("CalendarFlags5", Integer.class));
            domain.setCalendarFlags6(row.get("CalendarFlags6", Integer.class));
            domain.setCalendarFlags7(row.get("CalendarFlags7", Integer.class));
            domain.setCalendarFlags8(row.get("CalendarFlags8", Integer.class));
            domain.setCalendarFlags9(row.get("CalendarFlags9", Integer.class));
            domain.setCalendarFlags10(row.get("CalendarFlags10", Integer.class));
            domain.setTextureFileDataId1(row.get("TextureFileDataID1", Integer.class));
            domain.setTextureFileDataId2(row.get("TextureFileDataID2", Integer.class));
            domain.setTextureFileDataId3(row.get("TextureFileDataID3", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Holidays, OutboundRow> {

        public OutboundRow convert(Holidays source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getRegion()).ifPresent(e -> row.put("Region", Parameter.from(e)));
            Optional.ofNullable(source.getLooping()).ifPresent(e -> row.put("Looping", Parameter.from(e)));
            Optional.ofNullable(source.getHolidayNameId()).ifPresent(e -> row.put("HolidayNameID", Parameter.from(e)));
            Optional.ofNullable(source.getHolidayDescriptionId()).ifPresent(e -> row.put("HolidayDescriptionID", Parameter.from(e)));
            Optional.ofNullable(source.getPriority()).ifPresent(e -> row.put("Priority", Parameter.from(e)));
            Optional.ofNullable(source.getCalendarFilterType()).ifPresent(e -> row.put("CalendarFilterType", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getDuration1()).ifPresent(e -> row.put("Duration1", Parameter.from(e)));
            Optional.ofNullable(source.getDuration2()).ifPresent(e -> row.put("Duration2", Parameter.from(e)));
            Optional.ofNullable(source.getDuration3()).ifPresent(e -> row.put("Duration3", Parameter.from(e)));
            Optional.ofNullable(source.getDuration4()).ifPresent(e -> row.put("Duration4", Parameter.from(e)));
            Optional.ofNullable(source.getDuration5()).ifPresent(e -> row.put("Duration5", Parameter.from(e)));
            Optional.ofNullable(source.getDuration6()).ifPresent(e -> row.put("Duration6", Parameter.from(e)));
            Optional.ofNullable(source.getDuration7()).ifPresent(e -> row.put("Duration7", Parameter.from(e)));
            Optional.ofNullable(source.getDuration8()).ifPresent(e -> row.put("Duration8", Parameter.from(e)));
            Optional.ofNullable(source.getDuration9()).ifPresent(e -> row.put("Duration9", Parameter.from(e)));
            Optional.ofNullable(source.getDuration10()).ifPresent(e -> row.put("Duration10", Parameter.from(e)));
            Optional.ofNullable(source.getDate1()).ifPresent(e -> row.put("Date1", Parameter.from(e)));
            Optional.ofNullable(source.getDate2()).ifPresent(e -> row.put("Date2", Parameter.from(e)));
            Optional.ofNullable(source.getDate3()).ifPresent(e -> row.put("Date3", Parameter.from(e)));
            Optional.ofNullable(source.getDate4()).ifPresent(e -> row.put("Date4", Parameter.from(e)));
            Optional.ofNullable(source.getDate5()).ifPresent(e -> row.put("Date5", Parameter.from(e)));
            Optional.ofNullable(source.getDate6()).ifPresent(e -> row.put("Date6", Parameter.from(e)));
            Optional.ofNullable(source.getDate7()).ifPresent(e -> row.put("Date7", Parameter.from(e)));
            Optional.ofNullable(source.getDate8()).ifPresent(e -> row.put("Date8", Parameter.from(e)));
            Optional.ofNullable(source.getDate9()).ifPresent(e -> row.put("Date9", Parameter.from(e)));
            Optional.ofNullable(source.getDate10()).ifPresent(e -> row.put("Date10", Parameter.from(e)));
            Optional.ofNullable(source.getDate11()).ifPresent(e -> row.put("Date11", Parameter.from(e)));
            Optional.ofNullable(source.getDate12()).ifPresent(e -> row.put("Date12", Parameter.from(e)));
            Optional.ofNullable(source.getDate13()).ifPresent(e -> row.put("Date13", Parameter.from(e)));
            Optional.ofNullable(source.getDate14()).ifPresent(e -> row.put("Date14", Parameter.from(e)));
            Optional.ofNullable(source.getDate15()).ifPresent(e -> row.put("Date15", Parameter.from(e)));
            Optional.ofNullable(source.getDate16()).ifPresent(e -> row.put("Date16", Parameter.from(e)));
            Optional.ofNullable(source.getDate17()).ifPresent(e -> row.put("Date17", Parameter.from(e)));
            Optional.ofNullable(source.getDate18()).ifPresent(e -> row.put("Date18", Parameter.from(e)));
            Optional.ofNullable(source.getDate19()).ifPresent(e -> row.put("Date19", Parameter.from(e)));
            Optional.ofNullable(source.getDate20()).ifPresent(e -> row.put("Date20", Parameter.from(e)));
            Optional.ofNullable(source.getDate21()).ifPresent(e -> row.put("Date21", Parameter.from(e)));
            Optional.ofNullable(source.getDate22()).ifPresent(e -> row.put("Date22", Parameter.from(e)));
            Optional.ofNullable(source.getDate23()).ifPresent(e -> row.put("Date23", Parameter.from(e)));
            Optional.ofNullable(source.getDate24()).ifPresent(e -> row.put("Date24", Parameter.from(e)));
            Optional.ofNullable(source.getDate25()).ifPresent(e -> row.put("Date25", Parameter.from(e)));
            Optional.ofNullable(source.getDate26()).ifPresent(e -> row.put("Date26", Parameter.from(e)));
            Optional.ofNullable(source.getCalendarFlags1()).ifPresent(e -> row.put("CalendarFlags1", Parameter.from(e)));
            Optional.ofNullable(source.getCalendarFlags2()).ifPresent(e -> row.put("CalendarFlags2", Parameter.from(e)));
            Optional.ofNullable(source.getCalendarFlags3()).ifPresent(e -> row.put("CalendarFlags3", Parameter.from(e)));
            Optional.ofNullable(source.getCalendarFlags4()).ifPresent(e -> row.put("CalendarFlags4", Parameter.from(e)));
            Optional.ofNullable(source.getCalendarFlags5()).ifPresent(e -> row.put("CalendarFlags5", Parameter.from(e)));
            Optional.ofNullable(source.getCalendarFlags6()).ifPresent(e -> row.put("CalendarFlags6", Parameter.from(e)));
            Optional.ofNullable(source.getCalendarFlags7()).ifPresent(e -> row.put("CalendarFlags7", Parameter.from(e)));
            Optional.ofNullable(source.getCalendarFlags8()).ifPresent(e -> row.put("CalendarFlags8", Parameter.from(e)));
            Optional.ofNullable(source.getCalendarFlags9()).ifPresent(e -> row.put("CalendarFlags9", Parameter.from(e)));
            Optional.ofNullable(source.getCalendarFlags10()).ifPresent(e -> row.put("CalendarFlags10", Parameter.from(e)));
            Optional.ofNullable(source.getTextureFileDataId1()).ifPresent(e -> row.put("TextureFileDataID1", Parameter.from(e)));
            Optional.ofNullable(source.getTextureFileDataId2()).ifPresent(e -> row.put("TextureFileDataID2", Parameter.from(e)));
            Optional.ofNullable(source.getTextureFileDataId3()).ifPresent(e -> row.put("TextureFileDataID3", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
