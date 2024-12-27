package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
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
@Table(name = "garr_class_spec")
@Db2DataBind(name = "GarrClassSpec.db2", layoutHash = 0x194CD478, indexField = 7, fields = {
        @Db2Field(name = "classSpec", type = Db2Type.STRING),
        @Db2Field(name = "classSpecMale", type = Db2Type.STRING),
        @Db2Field(name = "classSpecFemale", type = Db2Type.STRING),
        @Db2Field(name = "uiTextureAtlasMemberID", type = Db2Type.SHORT),
        @Db2Field(name = "garrFollItemSetID", type = Db2Type.SHORT),
        @Db2Field(name = "followerClassLimit", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class GarrClassSpec implements DbcEntity {
    @Column(name = "ClassSpec")
    private LocalizedString classSpec;

    @Column(name = "ClassSpecMale")
    private LocalizedString classSpecMale;

    @Column(name = "ClassSpecFemale")
    private LocalizedString classSpecFemale;

    @Column(name = "UiTextureAtlasMemberID")
    private Short uiTextureAtlasMemberID;

    @Column(name = "GarrFollItemSetID")
    private Short garrFollItemSetID;

    @Column(name = "FollowerClassLimit")
    private Byte followerClassLimit;

    @Column(name = "Flags")
    private Byte flags;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
