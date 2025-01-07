package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Table(name = "holidays")
@Db2DataBind(name = "Holidays.db2", layoutHash = 0x7C3E60FC, indexField = 0, fields = {
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = {"date1", "date2", "date3", "date4", "date5", "date6", "date7", "date8", "date9", "date10", "date11", "date12", "date13", "date14", "date15", "date16"}, type = Db2Type.INT),
        @Db2Field(name = {"duration1", "duration2", "duration3", "duration4", "duration5", "duration6", "duration7", "duration8", "duration9", "duration10"}, type = Db2Type.SHORT),
        @Db2Field(name = "region", type = Db2Type.SHORT),
        @Db2Field(name = "looping", type = Db2Type.BYTE),
        @Db2Field(name = {"calendarFlags1", "calendarFlags2", "calendarFlags3", "calendarFlags4", "calendarFlags5", "calendarFlags6", "calendarFlags7", "calendarFlags8", "calendarFlags9", "calendarFlags10"}, type = Db2Type.BYTE),
        @Db2Field(name = "priority", type = Db2Type.BYTE),
        @Db2Field(name = "calendarFilterType", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "holidayNameID", type = Db2Type.INT),
        @Db2Field(name = "holidayDescriptionID", type = Db2Type.INT),
        @Db2Field(name = {"textureFileDataID1", "textureFileDataID2", "textureFileDataID3"}, type = Db2Type.INT, signed = true)
})
public class Holiday implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

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

    @Column("Duration1")
    private Short duration1;

    @Column("Duration2")
    private Short duration2;

    @Column("Duration3")
    private Short duration3;

    @Column("Duration4")
    private Short duration4;

    @Column("Duration5")
    private Short duration5;

    @Column("Duration6")
    private Short duration6;

    @Column("Duration7")
    private Short duration7;

    @Column("Duration8")
    private Short duration8;

    @Column("Duration9")
    private Short duration9;

    @Column("Duration10")
    private Short duration10;

    @Column("Region")
    private Short region;

    @Column("Looping")
    private Byte looping;

    @Column("CalendarFlags1")
    private Byte calendarFlags1;

    @Column("CalendarFlags2")
    private Byte calendarFlags2;

    @Column("CalendarFlags3")
    private Byte calendarFlags3;

    @Column("CalendarFlags4")
    private Byte calendarFlags4;

    @Column("CalendarFlags5")
    private Byte calendarFlags5;

    @Column("CalendarFlags6")
    private Byte calendarFlags6;

    @Column("CalendarFlags7")
    private Byte calendarFlags7;

    @Column("CalendarFlags8")
    private Byte calendarFlags8;

    @Column("CalendarFlags9")
    private Byte calendarFlags9;

    @Column("CalendarFlags10")
    private Byte calendarFlags10;

    @Column("Priority")
    private Byte priority;

    @Column("CalendarFilterType")
    private Byte calendarFilterType;

    @Column("Flags")
    private Byte flags;

    @Column("HolidayNameID")
    private Integer holidayNameID;

    @Column("HolidayDescriptionID")
    private Integer holidayDescriptionID;

    @Column("TextureFileDataID1")
    private Integer textureFileDataID1;

    @Column("TextureFileDataID2")
    private Integer textureFileDataID2;

    @Column("TextureFileDataID3")
    private Integer textureFileDataID3;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
