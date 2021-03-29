package com.rainbowland.service.auth.domain;

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
@Table("logs_ip_actions")
public class LogsIpAction {

    @Column("id")
    private Long id;
    @Column("account_id")
    private Long accountId;
    @Column("character_guid")
    private Long characterGuid;
    @Column("type")
    private Integer type;
    @Column("ip")
    private String ip;
    @Column("systemnote")
    private String systemnote;
    @Column("unixtime")
    private Long unixtime;
    @Column("time")
    private java.time.LocalDateTime time;
    @Column("comment")
    private String comment;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, LogsIpAction> {

        public LogsIpAction convert(Row row) {
            LogsIpAction domain = new LogsIpAction();
            domain.setId(row.get("id", Long.class));
            domain.setAccountId(row.get("account_id", Long.class));
            domain.setCharacterGuid(row.get("character_guid", Long.class));
            domain.setType(row.get("type", Integer.class));
            domain.setIp(row.get("ip", String.class));
            domain.setSystemnote(row.get("systemnote", String.class));
            domain.setUnixtime(row.get("unixtime", Long.class));
            domain.setTime(row.get("time", java.time.LocalDateTime.class));
            domain.setComment(row.get("comment", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<LogsIpAction, OutboundRow> {

        public OutboundRow convert(LogsIpAction source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getAccountId()).ifPresent(e -> row.put("account_id", Parameter.from(e)));
            Optional.ofNullable(source.getCharacterGuid()).ifPresent(e -> row.put("character_guid", Parameter.from(e)));
            Optional.ofNullable(source.getType()).ifPresent(e -> row.put("type", Parameter.from(e)));
            Optional.ofNullable(source.getIp()).ifPresent(e -> row.put("ip", Parameter.from(e)));
            Optional.ofNullable(source.getSystemnote()).ifPresent(e -> row.put("systemnote", Parameter.from(e)));
            Optional.ofNullable(source.getUnixtime()).ifPresent(e -> row.put("unixtime", Parameter.from(e)));
            Optional.ofNullable(source.getTime()).ifPresent(e -> row.put("time", Parameter.from(e)));
            Optional.ofNullable(source.getComment()).ifPresent(e -> row.put("comment", Parameter.from(e)));
            return row;
        }
    }

}
