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
@Table("azerite_power_set_member")
public class AzeritePowerSetMember {

    @Column("ID")
    private Integer id;
    @Column("AzeritePowerSetID")
    private Integer azeritePowerSetId;
    @Column("AzeritePowerID")
    private Integer azeritePowerId;
    @Column("Class")
    private Integer klass;
    @Column("Tier")
    private Integer tier;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AzeritePowerSetMember> {

        public AzeritePowerSetMember convert(Row row) {
            AzeritePowerSetMember domain = new AzeritePowerSetMember();
            domain.setId(row.get("ID", Integer.class));
            domain.setAzeritePowerSetId(row.get("AzeritePowerSetID", Integer.class));
            domain.setAzeritePowerId(row.get("AzeritePowerID", Integer.class));
            domain.setKlass(row.get("Class", Integer.class));
            domain.setTier(row.get("Tier", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AzeritePowerSetMember, OutboundRow> {

        public OutboundRow convert(AzeritePowerSetMember source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getAzeritePowerSetId()).ifPresent(e -> row.put("AzeritePowerSetID", Parameter.from(e)));
            Optional.ofNullable(source.getAzeritePowerId()).ifPresent(e -> row.put("AzeritePowerID", Parameter.from(e)));
            Optional.ofNullable(source.getClass()).ifPresent(e -> row.put("Class", Parameter.from(e)));
            Optional.ofNullable(source.getTier()).ifPresent(e -> row.put("Tier", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
