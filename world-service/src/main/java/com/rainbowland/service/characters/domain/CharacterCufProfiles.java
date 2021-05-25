package com.rainbowland.service.characters.domain;

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
@Table("character_cuf_profiles")
public class CharacterCufProfiles {

    @Column("guid")
    private Long guid;
    @Column("id")
    private Integer id;
    @Column("name")
    private String name;
    @Column("frameHeight")
    private Integer frameHeight;
    @Column("frameWidth")
    private Integer frameWidth;
    @Column("sortBy")
    private Integer sortBy;
    @Column("healthText")
    private Integer healthText;
    @Column("boolOptions")
    private Integer boolOptions;
    @Column("topPoint")
    private Integer topPoint;
    @Column("bottomPoint")
    private Integer bottomPoint;
    @Column("leftPoint")
    private Integer leftPoint;
    @Column("topOffset")
    private Integer topOffset;
    @Column("bottomOffset")
    private Integer bottomOffset;
    @Column("leftOffset")
    private Integer leftOffset;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, CharacterCufProfiles> {

        public CharacterCufProfiles convert(Row row) {
            CharacterCufProfiles domain = new CharacterCufProfiles();
            domain.setGuid(row.get("guid", Long.class));
            domain.setId(row.get("id", Integer.class));
            domain.setName(row.get("name", String.class));
            domain.setFrameHeight(row.get("frameHeight", Integer.class));
            domain.setFrameWidth(row.get("frameWidth", Integer.class));
            domain.setSortBy(row.get("sortBy", Integer.class));
            domain.setHealthText(row.get("healthText", Integer.class));
            domain.setBoolOptions(row.get("boolOptions", Integer.class));
            domain.setTopPoint(row.get("topPoint", Integer.class));
            domain.setBottomPoint(row.get("bottomPoint", Integer.class));
            domain.setLeftPoint(row.get("leftPoint", Integer.class));
            domain.setTopOffset(row.get("topOffset", Integer.class));
            domain.setBottomOffset(row.get("bottomOffset", Integer.class));
            domain.setLeftOffset(row.get("leftOffset", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<CharacterCufProfiles, OutboundRow> {

        public OutboundRow convert(CharacterCufProfiles source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getGuid()).ifPresent(e -> row.put("guid", Parameter.from(e)));
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("id", Parameter.from(e)));
            Optional.ofNullable(source.getName()).ifPresent(e -> row.put("name", Parameter.from(e)));
            Optional.ofNullable(source.getFrameHeight()).ifPresent(e -> row.put("frameHeight", Parameter.from(e)));
            Optional.ofNullable(source.getFrameWidth()).ifPresent(e -> row.put("frameWidth", Parameter.from(e)));
            Optional.ofNullable(source.getSortBy()).ifPresent(e -> row.put("sortBy", Parameter.from(e)));
            Optional.ofNullable(source.getHealthText()).ifPresent(e -> row.put("healthText", Parameter.from(e)));
            Optional.ofNullable(source.getBoolOptions()).ifPresent(e -> row.put("boolOptions", Parameter.from(e)));
            Optional.ofNullable(source.getTopPoint()).ifPresent(e -> row.put("topPoint", Parameter.from(e)));
            Optional.ofNullable(source.getBottomPoint()).ifPresent(e -> row.put("bottomPoint", Parameter.from(e)));
            Optional.ofNullable(source.getLeftPoint()).ifPresent(e -> row.put("leftPoint", Parameter.from(e)));
            Optional.ofNullable(source.getTopOffset()).ifPresent(e -> row.put("topOffset", Parameter.from(e)));
            Optional.ofNullable(source.getBottomOffset()).ifPresent(e -> row.put("bottomOffset", Parameter.from(e)));
            Optional.ofNullable(source.getLeftOffset()).ifPresent(e -> row.put("leftOffset", Parameter.from(e)));
            return row;
        }
    }

}
