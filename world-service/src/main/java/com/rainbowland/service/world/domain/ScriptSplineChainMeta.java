package com.rainbowland.service.world.domain;

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
@Table("script_spline_chain_meta")
public class ScriptSplineChainMeta {

    @Column("entry")
    private Integer entry;
    @Column("chainId")
    private Integer chainId;
    @Column("splineId")
    private Integer splineId;
    @Column("expectedDuration")
    private Integer expectedDuration;
    @Column("msUntilNext")
    private Integer msUntilNext;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ScriptSplineChainMeta> {

        public ScriptSplineChainMeta convert(Row row) {
            ScriptSplineChainMeta domain = new ScriptSplineChainMeta();
            domain.setEntry(row.get("entry", Integer.class));
            domain.setChainId(row.get("chainId", Integer.class));
            domain.setSplineId(row.get("splineId", Integer.class));
            domain.setExpectedDuration(row.get("expectedDuration", Integer.class));
            domain.setMsUntilNext(row.get("msUntilNext", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ScriptSplineChainMeta, OutboundRow> {

        public OutboundRow convert(ScriptSplineChainMeta source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getEntry()).ifPresent(e -> row.put("entry", Parameter.from(e)));
            Optional.ofNullable(source.getChainId()).ifPresent(e -> row.put("chainId", Parameter.from(e)));
            Optional.ofNullable(source.getSplineId()).ifPresent(e -> row.put("splineId", Parameter.from(e)));
            Optional.ofNullable(source.getExpectedDuration()).ifPresent(e -> row.put("expectedDuration", Parameter.from(e)));
            Optional.ofNullable(source.getMsUntilNext()).ifPresent(e -> row.put("msUntilNext", Parameter.from(e)));
            return row;
        }
    }

}
