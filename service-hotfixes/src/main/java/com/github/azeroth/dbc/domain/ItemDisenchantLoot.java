package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
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

    @Column("ID")
    private int id;

    @Column("MinLevel")
    private Short minLevel;

    @Column("MaxLevel")
    private Short maxLevel;

    @Column("SkillRequired")
    private Short skillRequired;

    @Column("Subclass")
    private Byte subclass;

    @Column("Quality")
    private Byte quality;

    @Column("ExpansionID")
    private Byte expansionID;

    @Column("Class")
    private Byte klass;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
