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
@Table(name = "item_disenchant_loot")
@Db2DataBind(name = "ItemDisenchantLoot.db2", layoutHash = 0xC0D926CC, parentIndexField = 6, fields = {
        @Db2Field(name = "minLevel", type = Db2Type.SHORT),
        @Db2Field(name = "maxLevel", type = Db2Type.SHORT),
        @Db2Field(name = "skillRequired", type = Db2Type.SHORT),
        @Db2Field(name = "subclass", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "quality", type = Db2Type.BYTE),
        @Db2Field(name = "expansionID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "klass", type = Db2Type.BYTE)
})
public class ItemDisenchantLoot implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "MinLevel")
    private Short minLevel;

    @Column(name = "MaxLevel")
    private Short maxLevel;

    @Column(name = "SkillRequired")
    private Short skillRequired;

    @Column(name = "Subclass")
    private Byte subclass;

    @Column(name = "Quality")
    private Byte quality;

    @Column(name = "ExpansionID")
    private Byte expansionID;

    @Column(name = "Class")
    private Byte klass;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
