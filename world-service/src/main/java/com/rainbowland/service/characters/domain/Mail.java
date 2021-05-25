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
@Table("mail")
public class Mail {

    @Column("id")
    private Integer id;
    @Column("messageType")
    private Integer messageType;
    @Column("stationery")
    private Integer stationery;
    @Column("mailTemplateId")
    private Integer mailTemplateId;
    @Column("sender")
    private Long sender;
    @Column("receiver")
    private Long receiver;
    @Column("subject")
    private String subject;
    @Column("body")
    private String body;
    @Column("has_items")
    private Integer hasItems;
    @Column("expire_time")
    private Long expireTime;
    @Column("deliver_time")
    private Long deliverTime;
    @Column("money")
    private Long money;
    @Column("cod")
    private Long cod;
    @Column("checked")
    private Integer checked;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, Mail> {

        public Mail convert(Row row) {
            Mail domain = new Mail();
            domain.setId(row.get("id", Integer.class));
            domain.setMessageType(row.get("messageType", Integer.class));
            domain.setStationery(row.get("stationery", Integer.class));
            domain.setMailTemplateId(row.get("mailTemplateId", Integer.class));
            domain.setSender(row.get("sender", Long.class));
            domain.setReceiver(row.get("receiver", Long.class));
            domain.setSubject(row.get("subject", String.class));
            domain.setBody(row.get("body", String.class));
            domain.setHasItems(row.get("has_items", Integer.class));
            domain.setExpireTime(row.get("expire_time", Long.class));
            domain.setDeliverTime(row.get("deliver_time", Long.class));
            domain.setMoney(row.get("money", Long.class));
            domain.setCod(row.get("cod", Long.class));
            domain.setChecked(row.get("checked", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<Mail, OutboundRow> {

        public OutboundRow convert(Mail source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getMessageType()).ifPresent(e -> row.put("messageType", Parameter.from(e)));
            Optional.ofNullable(source.getStationery()).ifPresent(e -> row.put("stationery", Parameter.from(e)));
            Optional.ofNullable(source.getMailTemplateId()).ifPresent(e -> row.put("mailTemplateId", Parameter.from(e)));
            Optional.ofNullable(source.getSender()).ifPresent(e -> row.put("sender", Parameter.from(e)));
            Optional.ofNullable(source.getReceiver()).ifPresent(e -> row.put("receiver", Parameter.from(e)));
            Optional.ofNullable(source.getSubject()).ifPresent(e -> row.put("subject", Parameter.from(e)));
            Optional.ofNullable(source.getBody()).ifPresent(e -> row.put("body", Parameter.from(e)));
            Optional.ofNullable(source.getHasItems()).ifPresent(e -> row.put("has_items", Parameter.from(e)));
            Optional.ofNullable(source.getExpireTime()).ifPresent(e -> row.put("expire_time", Parameter.from(e)));
            Optional.ofNullable(source.getDeliverTime()).ifPresent(e -> row.put("deliver_time", Parameter.from(e)));
            Optional.ofNullable(source.getMoney()).ifPresent(e -> row.put("money", Parameter.from(e)));
            Optional.ofNullable(source.getCod()).ifPresent(e -> row.put("cod", Parameter.from(e)));
            Optional.ofNullable(source.getChecked()).ifPresent(e -> row.put("checked", Parameter.from(e)));
            return row;
        }
    }

}
