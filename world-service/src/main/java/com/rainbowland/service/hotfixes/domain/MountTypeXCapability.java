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
@Table("mount_type_x_capability")
public class MountTypeXCapability {

    @Column("ID")
    private Integer id;
    @Column("MountTypeID")
    private Integer mountTypeId;
    @Column("MountCapabilityID")
    private Integer mountCapabilityId;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, MountTypeXCapability> {

        public MountTypeXCapability convert(Row row) {
            MountTypeXCapability domain = new MountTypeXCapability();
            domain.setId(row.get("ID", Integer.class));
            domain.setMountTypeId(row.get("MountTypeID", Integer.class));
            domain.setMountCapabilityId(row.get("MountCapabilityID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<MountTypeXCapability, OutboundRow> {

        public OutboundRow convert(MountTypeXCapability source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getMountTypeId()).ifPresent(e -> row.put("MountTypeID", Parameter.from(e)));
            Optional.ofNullable(source.getMountCapabilityId()).ifPresent(e -> row.put("MountCapabilityID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
