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
@Table("mail_items")
public class MailItems {

    @Column("mail_id")
    private Integer mailId;
    @Column("item_guid")
    private Long itemGuid;
    @Column("receiver")
    private Long receiver;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, MailItems> {

        public MailItems convert(Row row) {
            MailItems domain = new MailItems();
            domain.setMailId(row.get("mail_id", Integer.class));
            domain.setItemGuid(row.get("item_guid", Long.class));
            domain.setReceiver(row.get("receiver", Long.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<MailItems, OutboundRow> {

        public OutboundRow convert(MailItems source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getMailId()).ifPresent(e -> row.put("mail_id", Parameter.from(e)));
            Optional.ofNullable(source.getItemGuid()).ifPresent(e -> row.put("item_guid", Parameter.from(e)));
            Optional.ofNullable(source.getReceiver()).ifPresent(e -> row.put("receiver", Parameter.from(e)));
            return row;
        }
    }

}
