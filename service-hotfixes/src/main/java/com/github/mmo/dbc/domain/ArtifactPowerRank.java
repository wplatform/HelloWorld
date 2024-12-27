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
@Table(name = "artifact_power_rank")
@Db2DataBind(name = "ArtifactPowerRank.db2", layoutHash = 0xA87EACC4, parentIndexField = 4, fields = {
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "auraPointsOverride", type = Db2Type.FLOAT),
        @Db2Field(name = "itemBonusListID", type = Db2Type.SHORT),
        @Db2Field(name = "rankIndex", type = Db2Type.BYTE),
        @Db2Field(name = "artifactPowerID", type = Db2Type.SHORT)
})
public class ArtifactPowerRank implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SpellID")
    private Integer spellID;

    @Column(name = "AuraPointsOverride")
    private Float auraPointsOverride;

    @Column(name = "ItemBonusListID")
    private Short itemBonusListID;

    @Column(name = "RankIndex")
    private Byte rankIndex;

    @Column(name = "ArtifactPowerID")
    private Short artifactPowerID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
