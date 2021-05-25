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
@Table("battle_pet_breed_quality")
public class BattlePetBreedQuality {

    @Column("ID")
    private Integer id;
    @Column("StateMultiplier")
    private Double stateMultiplier;
    @Column("QualityEnum")
    private Integer qualityEnum;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, BattlePetBreedQuality> {

        public BattlePetBreedQuality convert(Row row) {
            BattlePetBreedQuality domain = new BattlePetBreedQuality();
            domain.setId(row.get("ID", Integer.class));
            domain.setStateMultiplier(row.get("StateMultiplier", Double.class));
            domain.setQualityEnum(row.get("QualityEnum", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<BattlePetBreedQuality, OutboundRow> {

        public OutboundRow convert(BattlePetBreedQuality source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getStateMultiplier()).ifPresent(e -> row.put("StateMultiplier", Parameter.from(e)));
            Optional.ofNullable(source.getQualityEnum()).ifPresent(e -> row.put("QualityEnum", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
