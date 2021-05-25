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
@Table("animation_data")
public class AnimationData {

    @Column("ID")
    private Integer id;
    @Column("BehaviorID")
    private Integer behaviorId;
    @Column("BehaviorTier")
    private Integer behaviorTier;
    @Column("Fallback")
    private Integer fallback;
    @Column("Flags1")
    private Integer flags1;
    @Column("Flags2")
    private Integer flags2;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AnimationData> {

        public AnimationData convert(Row row) {
            AnimationData domain = new AnimationData();
            domain.setId(row.get("ID", Integer.class));
            domain.setBehaviorId(row.get("BehaviorID", Integer.class));
            domain.setBehaviorTier(row.get("BehaviorTier", Integer.class));
            domain.setFallback(row.get("Fallback", Integer.class));
            domain.setFlags1(row.get("Flags1", Integer.class));
            domain.setFlags2(row.get("Flags2", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AnimationData, OutboundRow> {

        public OutboundRow convert(AnimationData source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getBehaviorId()).ifPresent(e -> row.put("BehaviorID", Parameter.from(e)));
            Optional.ofNullable(source.getBehaviorTier()).ifPresent(e -> row.put("BehaviorTier", Parameter.from(e)));
            Optional.ofNullable(source.getFallback()).ifPresent(e -> row.put("Fallback", Parameter.from(e)));
            Optional.ofNullable(source.getFlags1()).ifPresent(e -> row.put("Flags1", Parameter.from(e)));
            Optional.ofNullable(source.getFlags2()).ifPresent(e -> row.put("Flags2", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
