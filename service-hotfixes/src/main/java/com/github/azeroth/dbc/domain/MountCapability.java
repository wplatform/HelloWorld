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


@Table(name = "mount_capability")
@Db2DataBind(name = "MountCapability.db2", layoutHash = 0xB0D11D52, indexField = 6, fields = {
        @Db2Field(name = "reqSpellKnownID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "modSpellAuraID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "reqRidingSkill", type = Db2Type.SHORT),
        @Db2Field(name = "reqAreaID", type = Db2Type.SHORT),
        @Db2Field(name = "reqMapID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "reqSpellAuraID", type = Db2Type.INT)
})
public class MountCapability implements DbcEntity {
    @Column("ReqSpellKnownID")
    private Integer reqSpellKnownID;

    @Column("ModSpellAuraID")
    private Integer modSpellAuraID;

    @Column("ReqRidingSkill")
    private Short reqRidingSkill;

    @Column("ReqAreaID")
    private Short reqAreaID;

    @Column("ReqMapID")
    private Short reqMapID;

    @Column("Flags")
    private Byte flags;

    @Id

    @Column("ID")
    private int id;

    @Column("ReqSpellAuraID")
    private Integer reqSpellAuraID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
