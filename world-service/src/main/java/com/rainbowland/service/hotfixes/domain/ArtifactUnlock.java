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
@Table("artifact_unlock")
public class ArtifactUnlock {

    @Column("ID")
    private Integer id;
    @Column("PowerID")
    private Integer powerId;
    @Column("PowerRank")
    private Integer powerRank;
    @Column("ItemBonusListID")
    private Integer itemBonusListId;
    @Column("PlayerConditionID")
    private Integer playerConditionId;
    @Column("ArtifactID")
    private Integer artifactId;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ArtifactUnlock> {

        public ArtifactUnlock convert(Row row) {
            ArtifactUnlock domain = new ArtifactUnlock();
            domain.setId(row.get("ID", Integer.class));
            domain.setPowerId(row.get("PowerID", Integer.class));
            domain.setPowerRank(row.get("PowerRank", Integer.class));
            domain.setItemBonusListId(row.get("ItemBonusListID", Integer.class));
            domain.setPlayerConditionId(row.get("PlayerConditionID", Integer.class));
            domain.setArtifactId(row.get("ArtifactID", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ArtifactUnlock, OutboundRow> {

        public OutboundRow convert(ArtifactUnlock source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getPowerId()).ifPresent(e -> row.put("PowerID", Parameter.from(e)));
            Optional.ofNullable(source.getPowerRank()).ifPresent(e -> row.put("PowerRank", Parameter.from(e)));
            Optional.ofNullable(source.getItemBonusListId()).ifPresent(e -> row.put("ItemBonusListID", Parameter.from(e)));
            Optional.ofNullable(source.getPlayerConditionId()).ifPresent(e -> row.put("PlayerConditionID", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactId()).ifPresent(e -> row.put("ArtifactID", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
