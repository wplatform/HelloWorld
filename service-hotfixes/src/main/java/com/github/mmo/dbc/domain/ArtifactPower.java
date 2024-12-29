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


@Getter
@Setter
@ToString


@Table(name = "artifact_power")
@Db2DataBind(name = "ArtifactPower.db2", layoutHash = 0x45240818, indexField = 5, parentIndexField = 1, fields = {
        @Db2Field(name = {"posX", "posY"}, type = Db2Type.FLOAT),
        @Db2Field(name = "artifactID", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "maxPurchasableRank", type = Db2Type.BYTE),
        @Db2Field(name = "tier", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "label", type = Db2Type.INT, signed = true)
})
public class ArtifactPower implements DbcEntity {
    @Column("PosX")
    private Float posX;

    @Column("PosY")
    private Float posY;

    @Column("ArtifactID")
    private Short artifactID;

    @Column("Flags")
    private Byte flags;

    @Column("MaxPurchasableRank")
    private Byte maxPurchasableRank;

    @Column("Tier")
    private Byte tier;

    @Id

    @Column("ID")
    private int id;

    @Column("Label")
    private Integer label;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
