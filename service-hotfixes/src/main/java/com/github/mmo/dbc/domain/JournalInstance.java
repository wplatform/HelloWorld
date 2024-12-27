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
    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "ButtonFileDataID")
    private Integer buttonFileDataID;

    @Column(name = "ButtonSmallFileDataID")
    private Integer buttonSmallFileDataID;

    @Column(name = "BackgroundFileDataID")
    private Integer backgroundFileDataID;

    @Column(name = "LoreFileDataID")
    private Integer loreFileDataID;

    @Column(name = "MapID")
    private Short mapID;

    @Column(name = "AreaID")
    private Short areaID;

    @Column(name = "OrderIndex")
    private Byte orderIndex;

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
