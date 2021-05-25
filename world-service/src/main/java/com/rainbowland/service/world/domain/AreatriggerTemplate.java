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
@Table("areatrigger_template")
public class AreatriggerTemplate {

    @Column("Id")
    private Integer id;
    @Column("IsServerSide")
    private Integer isServerSide;
    @Column("Type")
    private Integer type;
    @Column("Flags")
    private Integer flags;
    @Column("Data0")
    private Double data0;
    @Column("Data1")
    private Double data1;
    @Column("Data2")
    private Double data2;
    @Column("Data3")
    private Double data3;
    @Column("Data4")
    private Double data4;
    @Column("Data5")
    private Double data5;
    @Column("ScriptName")
    private String scriptName;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AreatriggerTemplate> {

        public AreatriggerTemplate convert(Row row) {
            AreatriggerTemplate domain = new AreatriggerTemplate();
            domain.setId(row.get("Id", Integer.class));
            domain.setIsServerSide(row.get("IsServerSide", Integer.class));
            domain.setType(row.get("Type", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setData0(row.get("Data0", Double.class));
            domain.setData1(row.get("Data1", Double.class));
            domain.setData2(row.get("Data2", Double.class));
            domain.setData3(row.get("Data3", Double.class));
            domain.setData4(row.get("Data4", Double.class));
            domain.setData5(row.get("Data5", Double.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AreatriggerTemplate, OutboundRow> {

        public OutboundRow convert(AreatriggerTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("Id", Parameter.from(e)));
            Optional.ofNullable(source.getIsServerSide()).ifPresent(e -> row.put("IsServerSide", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("Type", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getData0()).ifPresent(e -> row.put("Data0", Parameter.from(e)));
            Optional.ofNullable(source.getData1()).ifPresent(e -> row.put("Data1", Parameter.from(e)));
            Optional.ofNullable(source.getData2()).ifPresent(e -> row.put("Data2", Parameter.from(e)));
            Optional.ofNullable(source.getData3()).ifPresent(e -> row.put("Data3", Parameter.from(e)));
            Optional.ofNullable(source.getData4()).ifPresent(e -> row.put("Data4", Parameter.from(e)));
            Optional.ofNullable(source.getData5()).ifPresent(e -> row.put("Data5", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
