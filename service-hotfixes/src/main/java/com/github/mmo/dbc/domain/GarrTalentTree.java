package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Field;
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
@ToString(onlyExplicitlyIncluded = true)
@IdClass(DB2Id.class)
@Entity
@Table(name = "garr_talent_tree")
@Db2DataBind(name = "GarrTalentTree.db2", layoutHash = 0x676CBC04, parentIndexField = 1, fields = {
        @Db2Field(name = "uiTextureKitID", type = Db2Type.SHORT),
        @Db2Field(name = "maxTiers", type = Db2Type.BYTE),
        @Db2Field(name = "uiOrder", type = Db2Type.BYTE),
        @Db2Field(name = "classID", type = Db2Type.INT),
        @Db2Field(name = "garrTypeID", type = Db2Type.INT)
})
public class GarrTalentTree implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Lob
    @Column(name = "Name")
    private String name;

    @ColumnDefault("0")
    @Column(name = "GarrTypeID", nullable = false)
    private Integer garrTypeID;

    @ColumnDefault("0")
    @Column(name = "ClassID", nullable = false)
    private Integer classID;

    @ColumnDefault("0")
    @Column(name = "MaxTiers", nullable = false)
    private Byte maxTiers;

    @ColumnDefault("0")
    @Column(name = "UiOrder", nullable = false)
    private Byte uiOrder;

    @ColumnDefault("0")
    @Column(name = "Flags", nullable = false)
    private Byte flags;

    @ColumnDefault("'0'")
    @Column(name = "UiTextureKitID", columnDefinition = "smallint UNSIGNED not null")
    private Integer uiTextureKitID;

}