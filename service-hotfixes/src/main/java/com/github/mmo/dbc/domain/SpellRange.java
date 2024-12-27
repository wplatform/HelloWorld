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
@Table(name = "spell_range")
@Db2DataBind(name = "SpellRange.db2", layoutHash = 0xDE2E3F8E, fields = {
        @Db2Field(name = "displayName", type = Db2Type.STRING),
        @Db2Field(name = "displayNameShort", type = Db2Type.STRING),
        @Db2Field(name = {"rangeMin1", "rangeMin2"}, type = Db2Type.FLOAT),
        @Db2Field(name = {"rangeMax1", "rangeMax2"}, type = Db2Type.FLOAT),
        @Db2Field(name = "flags", type = Db2Type.BYTE)
})
public class SpellRange implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "DisplayName")
    private LocalizedString displayName;

    @Column(name = "DisplayNameShort")
    private LocalizedString displayNameShort;

    @Column(name = "RangeMin1")
    private Float rangeMin1;

    @Column(name = "RangeMin2")
    private Float rangeMin2;

    @Column(name = "RangeMax1")
    private Float rangeMax1;

    @Column(name = "RangeMax2")
    private Float rangeMax2;

    @Column(name = "Flags")
    private Byte flags;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
