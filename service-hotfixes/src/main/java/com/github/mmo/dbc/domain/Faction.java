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
@Table(name = "faction")
@Db2DataBind(name = "Faction.db2", layoutHash = 0x6BFE8737, indexField = 3, fields = {
        @Db2Field(name = {"reputationRaceMask1", "reputationRaceMask2", "reputationRaceMask3", "reputationRaceMask4"}, type = Db2Type.LONG, signed = true),
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = {"reputationBase1", "reputationBase2", "reputationBase3", "reputationBase4"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"parentFactionMod1", "parentFactionMod2"}, type = Db2Type.FLOAT),
        @Db2Field(name = {"reputationMax1", "reputationMax2", "reputationMax3", "reputationMax4"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "reputationIndex", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = {"reputationClassMask1", "reputationClassMask2", "reputationClassMask3", "reputationClassMask4"}, type = Db2Type.SHORT, signed = true),
        @Db2Field(name = {"reputationFlags1", "reputationFlags2", "reputationFlags3", "reputationFlags4"}, type = Db2Type.SHORT),
        @Db2Field(name = "parentFactionID", type = Db2Type.SHORT),
        @Db2Field(name = "paragonFactionID", type = Db2Type.SHORT),
        @Db2Field(name = {"parentFactionCap1", "parentFactionCap2"}, type = Db2Type.BYTE),
        @Db2Field(name = "expansion", type = Db2Type.BYTE),
        @Db2Field(name = "friendshipRepID", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE)
})
public class Faction implements DbcEntity {
    @Column(name = "ReputationRaceMask1")
    private Long reputationRaceMask1;

    @Column(name = "ReputationRaceMask2")
    private Long reputationRaceMask2;

    @Column(name = "ReputationRaceMask3")
    private Long reputationRaceMask3;

    @Column(name = "ReputationRaceMask4")
    private Long reputationRaceMask4;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "Description")
    private LocalizedString description;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "ReputationBase1")
    private Integer reputationBase1;

    @Column(name = "ReputationBase2")
    private Integer reputationBase2;

    @Column(name = "ReputationBase3")
    private Integer reputationBase3;

    @Column(name = "ReputationBase4")
    private Integer reputationBase4;

    @Column(name = "ParentFactionMod1")
    private Float parentFactionMod1;

    @Column(name = "ParentFactionMod2")
    private Float parentFactionMod2;

    @Column(name = "ReputationMax1")
    private Integer reputationMax1;

    @Column(name = "ReputationMax2")
    private Integer reputationMax2;

    @Column(name = "ReputationMax3")
    private Integer reputationMax3;

    @Column(name = "ReputationMax4")
    private Integer reputationMax4;

    @Column(name = "ReputationIndex")
    private Short reputationIndex;

    @Column(name = "ReputationClassMask1")
    private Short reputationClassMask1;

    @Column(name = "ReputationClassMask2")
    private Short reputationClassMask2;

    @Column(name = "ReputationClassMask3")
    private Short reputationClassMask3;

    @Column(name = "ReputationClassMask4")
    private Short reputationClassMask4;

    @Column(name = "ReputationFlags1")
    private Short reputationFlags1;

    @Column(name = "ReputationFlags2")
    private Short reputationFlags2;

    @Column(name = "ReputationFlags3")
    private Short reputationFlags3;

    @Column(name = "ReputationFlags4")
    private Short reputationFlags4;

    @Column(name = "ParentFactionID")
    private Short parentFactionID;

    @Column(name = "ParagonFactionID")
    private Short paragonFactionID;

    @Column(name = "ParentFactionCap1")
    private Byte parentFactionCap1;

    @Column(name = "ParentFactionCap2")
    private Byte parentFactionCap2;

    @Column(name = "Expansion")
    private Byte expansion;

    @Column(name = "FriendshipRepID")
    private Byte friendshipRepID;

    @Column(name = "Flags")
    private Short flags;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;


    public boolean canHaveReputation() {
        return reputationIndex >= 0;
    }

}
