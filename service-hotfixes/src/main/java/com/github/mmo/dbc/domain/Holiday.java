package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Date1")
    private Integer date1;

    @Column(name = "Date2")
    private Integer date2;

    @Column(name = "Date3")
    private Integer date3;

    @Column(name = "Date4")
    private Integer date4;

    @Column(name = "Date5")
    private Integer date5;

    @Column(name = "Date6")
    private Integer date6;

    @Column(name = "Date7")
    private Integer date7;

    @Column(name = "Date8")
    private Integer date8;

    @Column(name = "Date9")
    private Integer date9;

    @Column(name = "Date10")
    private Integer date10;

    @Column(name = "Date11")
    private Integer date11;

    @Column(name = "Date12")
    private Integer date12;

    @Column(name = "Date13")
    private Integer date13;

    @Column(name = "Date14")
    private Integer date14;

    @Column(name = "Date15")
    private Integer date15;

    @Column(name = "Date16")
    private Integer date16;

    @Column(name = "Duration1")
    private Short duration1;

    @Column(name = "Duration2")
    private Short duration2;

    @Column(name = "Duration3")
    private Short duration3;

    @Column(name = "Duration4")
    private Short duration4;

    @Column(name = "Duration5")
    private Short duration5;

    @Column(name = "Duration6")
    private Short duration6;

    @Column(name = "Duration7")
    private Short duration7;

    @Column(name = "Duration8")
    private Short duration8;

    @Column(name = "Duration9")
    private Short duration9;

    @Column(name = "Duration10")
    private Short duration10;

    @Column(name = "Region")
    private Short region;

    @Column(name = "Looping")
    private Byte looping;

    @Column(name = "CalendarFlags1")
    private Byte calendarFlags1;

    @Column(name = "CalendarFlags2")
    private Byte calendarFlags2;

    @Column(name = "CalendarFlags3")
    private Byte calendarFlags3;

    @Column(name = "CalendarFlags4")
    private Byte calendarFlags4;

    @Column(name = "CalendarFlags5")
    private Byte calendarFlags5;

    @Column(name = "CalendarFlags6")
    private Byte calendarFlags6;

    @Column(name = "CalendarFlags7")
    private Byte calendarFlags7;

    @Column(name = "CalendarFlags8")
    private Byte calendarFlags8;

    @Column(name = "CalendarFlags9")
    private Byte calendarFlags9;

    @Column(name = "CalendarFlags10")
    private Byte calendarFlags10;

    @Column(name = "Priority")
    private Byte priority;

    @Column(name = "CalendarFilterType")
    private Byte calendarFilterType;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "HolidayNameID")
    private Integer holidayNameID;

    @Column(name = "HolidayDescriptionID")
    private Integer holidayDescriptionID;

    @Column(name = "TextureFileDataID1")
    private Integer textureFileDataID1;

    @Column(name = "TextureFileDataID2")
    private Integer textureFileDataID2;

    @Column(name = "TextureFileDataID3")
    private Integer textureFileDataID3;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
