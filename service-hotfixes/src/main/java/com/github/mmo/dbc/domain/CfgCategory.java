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
@ToString(onlyExplicitlyIncluded = true)
@IdClass(DB2Id.class)
@Entity
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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Lob
    @Column(name = "Name")
    private LocalizedString name;

    @ColumnDefault("'0'")
    @Column(name = "LocaleMask", columnDefinition = "smallint UNSIGNED not null")
    private Integer localeMask;

    @ColumnDefault("'0'")
    @Column(name = "CreateCharsetMask", columnDefinition = "tinyint UNSIGNED not null")
    private Short createCharsetMask;

    @ColumnDefault("'0'")
    @Column(name = "ExistingCharsetMask", columnDefinition = "tinyint UNSIGNED not null")
    private Short existingCharsetMask;

    @ColumnDefault("'0'")
    @Column(name = "Flags", columnDefinition = "tinyint UNSIGNED not null")
    private Short flags;

    @ColumnDefault("0")
    @Column(name = "`Order`", nullable = false)
    private Byte order;

}