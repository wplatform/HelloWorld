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


@Table(name = "prestige_level_info")
@Db2DataBind(name = "PrestigeLevelInfo.db2", layoutHash = 0xA7B2D559, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "badgeTextureFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "prestigeLevel", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE)
})
public class PrestigeLevelInfo implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Column("BadgeTextureFileDataID")
    private Integer badgeTextureFileDataID;

    @Column("PrestigeLevel")
    private Byte prestigeLevel;

    @Column("Flags")
    private Byte flags;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
