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
@Table("anim_kit")
public class AnimKit {

    @Column("ID")
    private Integer id;
    @Column("OneShotDuration")
    private Integer oneShotDuration;
    @Column("OneShotStopAnimKitID")
    private Integer oneShotStopAnimKitId;
    @Column("LowDefAnimKitID")
    private Integer lowDefAnimKitId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AnimKit> {

        public AnimKit convert(Row row) {
            AnimKit domain = new AnimKit();
            domain.setId(row.get("ID", Integer.class));
            domain.setOneShotDuration(row.get("OneShotDuration", Integer.class));
            domain.setOneShotStopAnimKitId(row.get("OneShotStopAnimKitID", Integer.class));
            domain.setLowDefAnimKitId(row.get("LowDefAnimKitID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AnimKit, OutboundRow> {

        public OutboundRow convert(AnimKit source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getOneShotDuration()).ifPresent(e -> row.put("OneShotDuration", Parameter.from(e)));
            Optional.ofNullable(source.getOneShotStopAnimKitId()).ifPresent(e -> row.put("OneShotStopAnimKitID", Parameter.from(e)));
            Optional.ofNullable(source.getLowDefAnimKitId()).ifPresent(e -> row.put("LowDefAnimKitID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
