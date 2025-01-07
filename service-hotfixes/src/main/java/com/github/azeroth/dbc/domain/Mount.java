package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.common.LocalizedString;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


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
    @Column("Name")
    private LocalizedString name;

    @Column("Description")
    private LocalizedString description;

    @Column("SourceText")
    private LocalizedString sourceText;

    @Column("SourceSpellID")
    private Integer sourceSpellID;

    @Column("MountFlyRideHeight")
    private Float mountFlyRideHeight;

    @Column("MountTypeID")
    private Short mountTypeID;

    @Column("Flags")
    private Short flags;

    @Column("SourceTypeEnum")
    private Byte sourceTypeEnum;

    @Id

    @Column("ID")
    private int id;

    @Column("PlayerConditionID")
    private Integer playerConditionID;

    @Column("UiModelSceneID")
    private Integer uiModelSceneID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
