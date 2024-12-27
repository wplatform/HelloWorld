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
    @Column(name = "ReqSpellKnownID")
    private Integer reqSpellKnownID;

    @Column(name = "ModSpellAuraID")
    private Integer modSpellAuraID;

    @Column(name = "ReqRidingSkill")
    private Short reqRidingSkill;

    @Column(name = "ReqAreaID")
    private Short reqAreaID;

    @Column(name = "ReqMapID")
    private Short reqMapID;

    @Column(name = "Flags")
    private Byte flags;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ReqSpellAuraID")
    private Integer reqSpellAuraID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
