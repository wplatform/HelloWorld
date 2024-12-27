package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
@Table(name = "artifact_tier")
@Db2DataBind(name = "ArtifactTier.db2", layoutHash = 0x1A5A50B9, fields = {
        @Db2Field(name = "artifactTier", type = Db2Type.INT),
        @Db2Field(name = "maxNumTraits", type = Db2Type.INT),
        @Db2Field(name = "maxArtifactKnowledge", type = Db2Type.INT),
        @Db2Field(name = "knowledgePlayerCondition", type = Db2Type.INT),
        @Db2Field(name = "minimumEmpowerKnowledge", type = Db2Type.INT)
})
public class ArtifactTier implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ArtifactTier")
    private Integer artifactTier;

    @Column(name = "MaxNumTraits")
    private Integer maxNumTraits;

    @Column(name = "MaxArtifactKnowledge")
    private Integer maxArtifactKnowledge;

    @Column(name = "KnowledgePlayerCondition")
    private Integer knowledgePlayerCondition;

    @Column(name = "MinimumEmpowerKnowledge")
    private Integer minimumEmpowerKnowledge;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
