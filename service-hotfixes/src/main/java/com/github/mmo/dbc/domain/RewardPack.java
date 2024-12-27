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
@Table(name = "reward_pack")
@Db2DataBind(name = "RewardPack.db2", layoutHash = 0xDB6CC0AB, fields = {
        @Db2Field(name = "money", type = Db2Type.INT),
        @Db2Field(name = "artifactXPMultiplier", type = Db2Type.FLOAT),
        @Db2Field(name = "artifactXPDifficulty", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "artifactXPCategoryID", type = Db2Type.BYTE),
        @Db2Field(name = "charTitleID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "treasurePickerID", type = Db2Type.INT)
})
public class RewardPack implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Money")
    private Integer money;

    @Column(name = "ArtifactXPMultiplier")
    private Float artifactXPMultiplier;

    @Column(name = "ArtifactXPDifficulty")
    private Byte artifactXPDifficulty;

    @Column(name = "ArtifactXPCategoryID")
    private Byte artifactXPCategoryID;

    @Column(name = "CharTitleID")
    private Integer charTitleID;

    @Column(name = "TreasurePickerID")
    private Integer treasurePickerID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
