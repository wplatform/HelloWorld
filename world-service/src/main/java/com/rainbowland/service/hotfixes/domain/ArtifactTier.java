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
@Table("artifact_tier")
public class ArtifactTier {

    @Column("ID")
    private Integer id;
    @Column("ArtifactTier")
    private Integer artifactTier;
    @Column("MaxNumTraits")
    private Integer maxNumTraits;
    @Column("MaxArtifactKnowledge")
    private Integer maxArtifactKnowledge;
    @Column("KnowledgePlayerCondition")
    private Integer knowledgePlayerCondition;
    @Column("MinimumEmpowerKnowledge")
    private Integer minimumEmpowerKnowledge;
    @Column("VerifiedBuild")
    private Integer verifiedBuild;



    @ReadingConverter
    public static class RowMapper implements Converter<Row, ArtifactTier> {

        public ArtifactTier convert(Row row) {
            ArtifactTier domain = new ArtifactTier();
            domain.setId(row.get("ID", Integer.class));
            domain.setArtifactTier(row.get("ArtifactTier", Integer.class));
            domain.setMaxNumTraits(row.get("MaxNumTraits", Integer.class));
            domain.setMaxArtifactKnowledge(row.get("MaxArtifactKnowledge", Integer.class));
            domain.setKnowledgePlayerCondition(row.get("KnowledgePlayerCondition", Integer.class));
            domain.setMinimumEmpowerKnowledge(row.get("MinimumEmpowerKnowledge", Integer.class));
            domain.setVerifiedBuild(row.get("VerifiedBuild", Integer.class));
            return domain;
        }
    }



    @WritingConverter
    public static class ParamMapper implements Converter<ArtifactTier, OutboundRow> {

        public OutboundRow convert(ArtifactTier source) {
            OutboundRow row = new OutboundRow();
            Optional.ofNullable(source.getId()).ifPresent(e -> row.put("ID", Parameter.from(e)));
            Optional.ofNullable(source.getArtifactTier()).ifPresent(e -> row.put("ArtifactTier", Parameter.from(e)));
            Optional.ofNullable(source.getMaxNumTraits()).ifPresent(e -> row.put("MaxNumTraits", Parameter.from(e)));
            Optional.ofNullable(source.getMaxArtifactKnowledge()).ifPresent(e -> row.put("MaxArtifactKnowledge", Parameter.from(e)));
            Optional.ofNullable(source.getKnowledgePlayerCondition()).ifPresent(e -> row.put("KnowledgePlayerCondition", Parameter.from(e)));
            Optional.ofNullable(source.getMinimumEmpowerKnowledge()).ifPresent(e -> row.put("MinimumEmpowerKnowledge", Parameter.from(e)));
            Optional.ofNullable(source.getVerifiedBuild()).ifPresent(e -> row.put("VerifiedBuild", Parameter.from(e)));
            return row;
        }
    }

}
