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
@Table("scene_template")
public class SceneTemplate {

    @Column("SceneId")
    private Integer sceneId;
    @Column("Flags")
    private Integer flags;
    @Column("ScriptPackageID")
    private Integer scriptPackageId;
    @Column("Encrypted")
    private Integer encrypted;
    @Column("ScriptName")
    private String scriptName;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, SceneTemplate> {

        public SceneTemplate convert(Row row) {
            SceneTemplate domain = new SceneTemplate();
            domain.setSceneId(row.get("SceneId", Integer.class));
            domain.setFlags(row.get("Flags", Integer.class));
            domain.setScriptPackageId(row.get("ScriptPackageID", Integer.class));
            domain.setEncrypted(row.get("Encrypted", Integer.class));
            domain.setScriptName(row.get("ScriptName", String.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<SceneTemplate, OutboundRow> {

        public OutboundRow convert(SceneTemplate source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getSceneId()).ifPresent(e -> row.put("SceneId", Parameter.from(e)));
            Optional.ofNullable(source.getFlags()).ifPresent(e -> row.put("Flags", Parameter.from(e)));
            Optional.ofNullable(source.getScriptPackageId()).ifPresent(e -> row.put("ScriptPackageID", Parameter.from(e)));
            Optional.ofNullable(source.getEncrypted()).ifPresent(e -> row.put("Encrypted", Parameter.from(e)));
            Optional.ofNullable(source.getScriptName()).ifPresent(e -> row.put("ScriptName", Parameter.from(e)));
            return row;
        }
    }

}
