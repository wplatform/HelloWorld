package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.common.LocalizedString;
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
    @Column("ReputationRaceMask1")
    private Long reputationRaceMask1;

    @Column("ReputationRaceMask2")
    private Long reputationRaceMask2;

    @Column("ReputationRaceMask3")
    private Long reputationRaceMask3;

    @Column("ReputationRaceMask4")
    private Long reputationRaceMask4;

    @Column("Name")
    private LocalizedString name;

    @Column("Description")
    private LocalizedString description;

    @Id

    @Column("ID")
    private int id;

    @Column("ReputationBase1")
    private Integer reputationBase1;

    @Column("ReputationBase2")
    private Integer reputationBase2;

    @Column("ReputationBase3")
    private Integer reputationBase3;

    @Column("ReputationBase4")
    private Integer reputationBase4;

    @Column("ParentFactionMod1")
    private Float parentFactionMod1;

    @Column("ParentFactionMod2")
    private Float parentFactionMod2;

    @Column("ReputationMax1")
    private Integer reputationMax1;

    @Column("ReputationMax2")
    private Integer reputationMax2;

    @Column("ReputationMax3")
    private Integer reputationMax3;

    @Column("ReputationMax4")
    private Integer reputationMax4;

    @Column("ReputationIndex")
    private Short reputationIndex;

    @Column("ReputationClassMask1")
    private Short reputationClassMask1;

    @Column("ReputationClassMask2")
    private Short reputationClassMask2;

    @Column("ReputationClassMask3")
    private Short reputationClassMask3;

    @Column("ReputationClassMask4")
    private Short reputationClassMask4;

    @Column("ReputationFlags1")
    private Short reputationFlags1;

    @Column("ReputationFlags2")
    private Short reputationFlags2;

    @Column("ReputationFlags3")
    private Short reputationFlags3;

    @Column("ReputationFlags4")
    private Short reputationFlags4;

    @Column("ParentFactionID")
    private Short parentFactionID;

    @Column("ParagonFactionID")
    private Short paragonFactionID;

    @Column("ParentFactionCap1")
    private Byte parentFactionCap1;

    @Column("ParentFactionCap2")
    private Byte parentFactionCap2;

    @Column("Expansion")
    private Byte expansion;

    @Column("FriendshipRepID")
    private Byte friendshipRepID;

    @Column("Flags")
    private Short flags;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;


    public boolean canHaveReputation() {
        return reputationIndex >= 0;
    }

}
