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


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)


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

    @Column("ID")
    private int id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

    
    @Column("Name")
    private String name;


    @Column("GarrTypeID")
    private Integer garrTypeID;


    @Column("ClassID")
    private Integer classID;


    @Column("MaxTiers")
    private Byte maxTiers;


    @Column("UiOrder")
    private Byte uiOrder;


    @Column("Flags")
    private Byte flags;


    @Column("UiTextureKitID")
    private Integer uiTextureKitID;

}