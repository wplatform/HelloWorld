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
@Table("mount_x_display")
public class MountXDisplay {

    @Column("ID")
    private Integer id;
    @Column("CreatureDisplayInfoID")
    private Integer creatureDisplayInfoId;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("MountID")
    private Integer mountId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, MountXDisplay> {

        public MountXDisplay convert(Row row) {
            MountXDisplay domain = new MountXDisplay();
            domain.setId(row.get("ID", Integer.class));
            domain.setCreatureDisplayInfoId(row.get("CreatureDisplayInfoID", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setMountId(row.get("MountID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<MountXDisplay, OutboundRow> {

        public OutboundRow convert(MountXDisplay source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getCreatureDisplayInfoId()).ifPresent(e -> row.put("CreatureDisplayInfoID", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getMountId()).ifPresent(e -> row.put("MountID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
