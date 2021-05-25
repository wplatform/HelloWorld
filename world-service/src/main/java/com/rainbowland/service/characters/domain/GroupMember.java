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
@Table("group_member")
public class GroupMember {

    @Column("guid")
    private Integer guid;
    @Column("memberGuid")
    private Long memberGuid;
    @Column("memberFlags")
    private Integer memberFlags;
    @Column("subgroup")
    private Integer subgroup;
    @Column("roles")
    private Integer roles;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GroupMember> {

        public GroupMember convert(Row row) {
            GroupMember domain = new GroupMember();
            domain.setGuid(row.get("guid", Integer.class));
            domain.setMemberGuid(row.get("memberGuid", Long.class));
            domain.setMemberFlags(row.get("memberFlags", Integer.class));
            domain.setSubgroup(row.get("subgroup", Integer.class));
            domain.setRoles(row.get("roles", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GroupMember, OutboundRow> {

        public OutboundRow convert(GroupMember source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getMemberGuid()).ifPresent(e -> row.put("memberGuid", Parameter.from(e)));
            Optional.ofNullable(source.getMemberFlags()).ifPresent(e -> row.put("memberFlags", Parameter.from(e)));
            Optional.ofNullable(source.getSubgroup()).ifPresent(e -> row.put("subgroup", Parameter.from(e)));
            Optional.ofNullable(source.getRoles()).ifPresent(e -> row.put("roles", Parameter.from(e)));
            return row;
        }
    }

}
