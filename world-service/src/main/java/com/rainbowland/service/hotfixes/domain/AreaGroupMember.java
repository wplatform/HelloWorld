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
@Table("area_group_member")
public class AreaGroupMember {

    @Column("ID")
    private Integer id;
    @Column("AreaID")
    private Integer areaId;
    @Column("AreaGroupID")
    private Integer areaGroupId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AreaGroupMember> {

        public AreaGroupMember convert(Row row) {
            AreaGroupMember domain = new AreaGroupMember();
            domain.setId(row.get("ID", Integer.class));
            domain.setAreaId(row.get("AreaID", Integer.class));
            domain.setAreaGroupId(row.get("AreaGroupID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AreaGroupMember, OutboundRow> {

        public OutboundRow convert(AreaGroupMember source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getAreaId()).ifPresent(e -> row.put("AreaID", Parameter.from(e)));
            Optional.ofNullable(source.getAreaGroupId()).ifPresent(e -> row.put("AreaGroupID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
