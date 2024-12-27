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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SpecializationID")
    private Short specializationID;

    @Column(name = "MinLevel")
    private Byte minLevel;

    @Column(name = "MaxLevel")
    private Byte maxLevel;

    @Column(name = "ItemType")
    private Byte itemType;

    @Column(name = "PrimaryStat")
    private Byte primaryStat;

    @Column(name = "SecondaryStat")
    private Byte secondaryStat;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
