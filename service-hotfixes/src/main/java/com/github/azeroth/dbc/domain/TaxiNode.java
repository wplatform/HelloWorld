package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.common.EnumFlag;
import com.github.azeroth.common.LocalizedString;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import com.github.azeroth.dbc.defines.TaxiNodeFlag;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


@Table(name = "taxi_nodes")
@Db2DataBind(name = "TaxiNodes.db2", layoutHash = 0xB46C6A8B, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = {"posX", "posY","posZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = {"mountCreatureID1", "mountCreatureID2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"mapOffsetX", "mapOffsetY"}, type = Db2Type.FLOAT),
        @Db2Field(name = "facing", type = Db2Type.FLOAT),
        @Db2Field(name = {"flightMapOffsetX", "flightMapOffsetY"}, type = Db2Type.FLOAT),
        @Db2Field(name = "continentID", type = Db2Type.SHORT),
        @Db2Field(name = "conditionID", type = Db2Type.SHORT),
        @Db2Field(name = "characterBitNumber", type = Db2Type.SHORT),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "uiTextureKitID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "specialIconConditionID", type = Db2Type.INT)
})
public class TaxiNode implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Column("PosX")
    private Float posX;

    @Column("PosY")
    private Float posY;

    @Column("PosZ")
    private Float posZ;

    @Column("MountCreatureID1")
    private Integer mountCreatureID1;

    @Column("MountCreatureID2")
    private Integer mountCreatureID2;

    @Column("MapOffsetX")
    private Float mapOffsetX;

    @Column("MapOffsetY")
    private Float mapOffsetY;

    @Column("Facing")
    private Float facing;

    @Column("FlightMapOffsetX")
    private Float flightMapOffsetX;

    @Column("FlightMapOffsetY")
    private Float flightMapOffsetY;

    @Column("ContinentID")
    private Short continentID;

    @Column("ConditionID")
    private Integer conditionID;

    @Column("CharacterBitNumber")
    private Short characterBitNumber;

    @Column("Flags")
    private Byte flags;

    @Column("UiTextureKitID")
    private Integer uiTextureKitID;

    @Column("SpecialIconConditionID")
    private Integer specialIconConditionID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;


    public EnumFlag<TaxiNodeFlag> flags() { return EnumFlag.of(TaxiNodeFlag.class, flags); }

    public boolean isPartOfTaxiNetwork() {
        return flags().hasAnyFlag(TaxiNodeFlag.ShowOnAllianceMap, TaxiNodeFlag.ShowOnHordeMap)
                // manually whitelisted nodes
                || id == 1985   // [Hidden] Argus Ground Points Hub (Ground TP out to here, TP to Vindicaar from here)
                || id == 1986   // [Hidden] Argus Vindicaar Ground Hub (Vindicaar TP out to here, TP to ground from here)
                || id == 1987   // [Hidden] Argus Vindicaar No Load Hub (Vindicaar No Load transition goes through here)
                || id == 2627   // [Hidden] 9.0 Bastion Ground Points Hub (Ground TP out to here, TP to Sanctum from here)
                || id == 2628   // [Hidden] 9.0 Bastion Ground Hub (Sanctum TP out to here, TP to ground from here)
                || id == 2732   // [HIDDEN] 9.2 Resonant Peaks - Teleport Network - Hidden Hub (Connects all Nodes to each other without unique paths)
                || id == 2835   // [Hidden] 10.0 Travel Network - Destination Input
                || id == 2843   // [Hidden] 10.0 Travel Network - Destination Output
                ;
    }

}
