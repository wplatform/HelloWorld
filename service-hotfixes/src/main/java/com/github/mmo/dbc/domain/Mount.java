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
@Table(name = "mount")
@Db2DataBind(name = "Mount.db2", layoutHash = 0x4D812F19, indexField = 8, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "sourceText", type = Db2Type.STRING),
        @Db2Field(name = "sourceSpellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "mountFlyRideHeight", type = Db2Type.FLOAT),
        @Db2Field(name = "mountTypeID", type = Db2Type.SHORT),
        @Db2Field(name = "flags", type = Db2Type.SHORT),
        @Db2Field(name = "sourceTypeEnum", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "playerConditionID", type = Db2Type.INT),
        @Db2Field(name = "uiModelSceneID", type = Db2Type.INT, signed = true)
})
public class Mount implements DbcEntity {
    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "SourceText")
    private LocalizedString sourceText;

    @Column(name = "SourceSpellID")
    private Integer sourceSpellID;

    @Column(name = "MountFlyRideHeight")
    private Float mountFlyRideHeight;

    @Column(name = "MountTypeID")
    private Short mountTypeID;

    @Column(name = "Flags")
    private Short flags;

    @Column(name = "SourceTypeEnum")
    private Byte sourceTypeEnum;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "PlayerConditionID")
    private Integer playerConditionID;

    @Column(name = "UiModelSceneID")
    private Integer uiModelSceneID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
