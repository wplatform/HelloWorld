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
@Table("gm_complaint_chatlog")
public class GmComplaintChatlog {

    @Column("complaintId")
    private Integer complaintId;
    @Column("lineId")
    private Integer lineId;
    @Column("timestamp")
    private Long timestamp;
    @Column("text")
    private String text;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GmComplaintChatlog> {

        public GmComplaintChatlog convert(Row row) {
            GmComplaintChatlog domain = new GmComplaintChatlog();
            domain.setComplaintId(row.get("complaintId", Integer.class));
            domain.setLineId(row.get("lineId", Integer.class));
            domain.setTimestamp(row.get("timestamp", Long.class));
            domain.setText(row.get("text", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GmComplaintChatlog, OutboundRow> {

        public OutboundRow convert(GmComplaintChatlog source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getComplaintId()).ifPresent(e -> row.put("complaintId", Parameter.from(e)));
            Optional.ofNullable(source.getLineId()).ifPresent(e -> row.put("lineId", Parameter.from(e)));
            Optional.ofNullable(source.getTimestamp()).ifPresent(e -> row.put("timestamp", Parameter.from(e)));
            Optional.ofNullable(source.getText()).ifPresent(e -> row.put("text", Parameter.from(e)));
            return row;
        }
    }

}
