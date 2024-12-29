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


@Getter
@Setter
@ToString


@Table(name = "journal_instance")
@Db2DataBind(name = "JournalInstance.db2", layoutHash = 0x1691CC3D, indexField = 10, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "buttonFileDataID", type = Db2Type.INT),
        @Db2Field(name = "buttonSmallFileDataID", type = Db2Type.INT),
        @Db2Field(name = "backgroundFileDataID", type = Db2Type.INT),
        @Db2Field(name = "loreFileDataID", type = Db2Type.INT),
        @Db2Field(name = "mapID", type = Db2Type.SHORT),
        @Db2Field(name = "areaID", type = Db2Type.SHORT),
        @Db2Field(name = "orderIndex", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT)
})
public class JournalInstance implements DbcEntity {
    @Column("Name")
    private LocalizedString name;

    @Column("Description")
    private LocalizedString description;

    @Column("ButtonFileDataID")
    private Integer buttonFileDataID;

    @Column("ButtonSmallFileDataID")
    private Integer buttonSmallFileDataID;

    @Column("BackgroundFileDataID")
    private Integer backgroundFileDataID;

    @Column("LoreFileDataID")
    private Integer loreFileDataID;

    @Column("MapID")
    private Short mapID;

    @Column("AreaID")
    private Short areaID;

    @Column("OrderIndex")
    private Byte orderIndex;

    @Column("Flags")
    private Byte flags;

    @Id

    @Column("ID")
    private int id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
