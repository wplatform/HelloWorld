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
@Table("calendar_invites")
public class CalendarInvites {

    @Column("InviteID")
    private Long inviteId;
    @Column("EventID")
    private Long eventId;
    @Column("Invitee")
    private Long invitee;
    @Column("Sender")
    private Long sender;
    @Column("Status")
    private Integer status;
    @Column("ResponseTime")
    private Long responseTime;
    @Column("ModerationRank")
    private Integer moderationRank;
    @Column("Note")
    private String note;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CalendarInvites> {

        public CalendarInvites convert(Row row) {
            CalendarInvites domain = new CalendarInvites();
            domain.setInviteId(row.get("InviteID", Long.class));
            domain.setEventId(row.get("EventID", Long.class));
            domain.setInvitee(row.get("Invitee", Long.class));
            domain.setSender(row.get("Sender", Long.class));
            domain.setStatus(row.get("Status", Integer.class));
            domain.setResponseTime(row.get("ResponseTime", Long.class));
            domain.setModerationRank(row.get("ModerationRank", Integer.class));
            domain.setNote(row.get("Note", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CalendarInvites, OutboundRow> {

        public OutboundRow convert(CalendarInvites source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getInviteId()).ifPresent(e -> row.put("InviteID", Parameter.from(e)));
            Optional.ofNullable(source.getEventId()).ifPresent(e -> row.put("EventID", Parameter.from(e)));
            Optional.ofNullable(source.getInvitee()).ifPresent(e -> row.put("Invitee", Parameter.from(e)));
            Optional.ofNullable(source.getSender()).ifPresent(e -> row.put("Sender", Parameter.from(e)));
            Optional.ofNullable(source.getStatus()).ifPresent(e -> row.put("Status", Parameter.from(e)));
            Optional.ofNullable(source.getResponseTime()).ifPresent(e -> row.put("ResponseTime", Parameter.from(e)));
            Optional.ofNullable(source.getModerationRank()).ifPresent(e -> row.put("ModerationRank", Parameter.from(e)));
            Optional.ofNullable(source.getNote()).ifPresent(e -> row.put("Note", Parameter.from(e)));
            return row;
        }
    }

}
