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
@Table("scene_script")
public class SceneScript {

    @Column("ID")
    private Integer id;
    @Column("FirstSceneScriptID")
    private Integer firstSceneScriptId;
    @Column("NextSceneScriptID")
    private Integer nextSceneScriptId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SceneScript> {

        public SceneScript convert(Row row) {
            SceneScript domain = new SceneScript();
            domain.setId(row.get("ID", Integer.class));
            domain.setFirstSceneScriptId(row.get("FirstSceneScriptID", Integer.class));
            domain.setNextSceneScriptId(row.get("NextSceneScriptID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SceneScript, OutboundRow> {

        public OutboundRow convert(SceneScript source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getFirstSceneScriptId()).ifPresent(e -> row.put("FirstSceneScriptID", Parameter.from(e)));
            Optional.ofNullable(source.getNextSceneScriptId()).ifPresent(e -> row.put("NextSceneScriptID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
