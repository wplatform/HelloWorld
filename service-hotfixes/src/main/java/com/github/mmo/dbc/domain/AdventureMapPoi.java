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


@Table(name = "adventure_map_poi")
@Db2DataBind(name = "AdventureMapPOI.db2", layoutHash = 0x0C288A82, fields = {
        @Db2Field(name = "title", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = {"worldPositionX", "worldPositionY"}, type = Db2Type.FLOAT),
        @Db2Field(name = "rewardItemID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "type", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "playerConditionID", type = Db2Type.INT),
        @Db2Field(name = "questID", type = Db2Type.INT),
        @Db2Field(name = "lfgDungeonID", type = Db2Type.INT),
        @Db2Field(name = "uiTextureAtlasMemberID", type = Db2Type.INT),
        @Db2Field(name = "uiTextureKitID", type = Db2Type.INT),
        @Db2Field(name = "worldMapAreaID", type = Db2Type.INT),
        @Db2Field(name = "mapID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "areaTableID", type = Db2Type.INT, signed = true)
})
public class AdventureMapPoi implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

    
    @Column("Title")
    private LocalizedString title;

    
    @Column("Description")
    private LocalizedString description;


    @Column("WorldPositionX")
    private Float worldPositionX;


    @Column("WorldPositionY")
    private Float worldPositionY;


    @Column("Type")
    private Byte type;


    @Column("PlayerConditionID")
    private Long playerConditionID;


    @Column("QuestID")
    private Long questID;


    @Column("LfgDungeonID")
    private Long lfgDungeonID;


    @Column("RewardItemID")
    private Integer rewardItemID;


    @Column("UiTextureAtlasMemberID")
    private Long uiTextureAtlasMemberID;


    @Column("UiTextureKitID")
    private Long uiTextureKitID;


    @Column("MapID")
    private Integer mapID;


    @Column("WorldMapAreaID")
    private Integer worldMapAreaID;


    @Column("AreaTableID")
    private Long areaTableID;

}