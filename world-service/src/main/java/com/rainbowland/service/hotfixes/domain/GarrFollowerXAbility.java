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
@Table("garr_follower_x_ability")
public class GarrFollowerXAbility {

    @Column("ID")
    private Integer id;
    @Column("OrderIndex")
    private Integer orderIndex;
    @Column("FactionIndex")
    private Integer factionIndex;
    @Column("GarrAbilityID")
    private Integer garrAbilityId;
    @Column("GarrFollowerID")
    private Integer garrFollowerId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, GarrFollowerXAbility> {

        public GarrFollowerXAbility convert(Row row) {
            GarrFollowerXAbility domain = new GarrFollowerXAbility();
            domain.setId(row.get("ID", Integer.class));
            domain.setOrderIndex(row.get("OrderIndex", Integer.class));
            domain.setFactionIndex(row.get("FactionIndex", Integer.class));
            domain.setGarrAbilityId(row.get("GarrAbilityID", Integer.class));
            domain.setGarrFollowerId(row.get("GarrFollowerID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<GarrFollowerXAbility, OutboundRow> {

        public OutboundRow convert(GarrFollowerXAbility source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getOrderIndex()).ifPresent(e -> row.put("OrderIndex", Parameter.from(e)));
            Optional.ofNullable(source.getFactionIndex()).ifPresent(e -> row.put("FactionIndex", Parameter.from(e)));
            Optional.ofNullable(source.getGarrAbilityId()).ifPresent(e -> row.put("GarrAbilityID", Parameter.from(e)));
            Optional.ofNullable(source.getGarrFollowerId()).ifPresent(e -> row.put("GarrFollowerID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
