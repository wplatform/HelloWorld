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


@Table(name = "item_spec")
@Db2DataBind(name = "ItemSpec.db2", layoutHash = 0xB17B7986, parentIndexField = 3, fields = {
        @Db2Field(name = "specializationID", type = Db2Type.SHORT),
        @Db2Field(name = "minLevel", type = Db2Type.BYTE),
        @Db2Field(name = "maxLevel", type = Db2Type.BYTE),
        @Db2Field(name = "itemType", type = Db2Type.BYTE),
        @Db2Field(name = "primaryStat", type = Db2Type.BYTE),
        @Db2Field(name = "secondaryStat", type = Db2Type.BYTE)
})
public class ItemSpec implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("SpecializationID")
    private Short specializationID;

    @Column("MinLevel")
    private Byte minLevel;

    @Column("MaxLevel")
    private Byte maxLevel;

    @Column("ItemType")
    private Byte itemType;

    @Column("PrimaryStat")
    private Byte primaryStat;

    @Column("SecondaryStat")
    private Byte secondaryStat;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
