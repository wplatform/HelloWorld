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
@Table("azerite_level_info")
public class AzeriteLevelInfo {

    @Column("ID")
    private Integer id;
    @Column("BaseExperienceToNextLevel")
    private Long baseExperienceToNextLevel;
    @Column("MinimumExperienceToNextLevel")
    private Long minimumExperienceToNextLevel;
    @Column("ItemLevel")
    private Integer itemLevel;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, AzeriteLevelInfo> {

        public AzeriteLevelInfo convert(Row row) {
            AzeriteLevelInfo domain = new AzeriteLevelInfo();
            domain.setId(row.get("ID", Integer.class));
            domain.setBaseExperienceToNextLevel(row.get("BaseExperienceToNextLevel", Long.class));
            domain.setMinimumExperienceToNextLevel(row.get("MinimumExperienceToNextLevel", Long.class));
            domain.setItemLevel(row.get("ItemLevel", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<AzeriteLevelInfo, OutboundRow> {

        public OutboundRow convert(AzeriteLevelInfo source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getBaseExperienceToNextLevel()).ifPresent(e -> row.put("BaseExperienceToNextLevel", Parameter.from(e)));
            Optional.ofNullable(source.getMinimumExperienceToNextLevel()).ifPresent(e -> row.put("MinimumExperienceToNextLevel", Parameter.from(e)));
            Optional.ofNullable(source.getItemLevel()).ifPresent(e -> row.put("ItemLevel", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
