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
@ToString(onlyExplicitlyIncluded = true)


@Table(name = "cfg_categories")
@Db2DataBind(name = "Cfg_Categories.db2", layoutHash = 0x705B82C8, fields = {
        @Db2Field(name = "localeMask", type = Db2Type.SHORT),
        @Db2Field(name = "createCharsetMask", type = Db2Type.BYTE),
        @Db2Field(name = "existingCharsetMask", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "order", type = Db2Type.BYTE),
})
public class CfgCategory implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

    
    @Column("Name")
    private LocalizedString name;


    @Column("LocaleMask")
    private Integer localeMask;


    @Column("CreateCharsetMask")
    private Short createCharsetMask;


    @Column("ExistingCharsetMask")
    private Short existingCharsetMask;


    @Column("Flags")
    private Short flags;


    @Column("`Order`")
    private Byte order;

}