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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Lob
    @Column(name = "Title")
    private LocalizedString title;

    @Lob
    @Column(name = "Description")
    private LocalizedString description;

    @ColumnDefault("0")
    @Column(name = "WorldPositionX", nullable = false)
    private Float worldPositionX;

    @ColumnDefault("0")
    @Column(name = "WorldPositionY", nullable = false)
    private Float worldPositionY;

    @ColumnDefault("0")
    @Column(name = "Type", nullable = false)
    private Byte type;

    @ColumnDefault("'0'")
    @Column(name = "PlayerConditionID", columnDefinition = "int UNSIGNED not null")
    private Long playerConditionID;

    @ColumnDefault("'0'")
    @Column(name = "QuestID", columnDefinition = "int UNSIGNED not null")
    private Long questID;

    @ColumnDefault("'0'")
    @Column(name = "LfgDungeonID", columnDefinition = "int UNSIGNED not null")
    private Long lfgDungeonID;

    @ColumnDefault("0")
    @Column(name = "RewardItemID", nullable = false)
    private Integer rewardItemID;

    @ColumnDefault("'0'")
    @Column(name = "UiTextureAtlasMemberID", columnDefinition = "int UNSIGNED not null")
    private Long uiTextureAtlasMemberID;

    @ColumnDefault("'0'")
    @Column(name = "UiTextureKitID", columnDefinition = "int UNSIGNED not null")
    private Long uiTextureKitID;

    @ColumnDefault("0")
    @Column(name = "MapID", nullable = false)
    private Integer mapID;

    @ColumnDefault("0")
    @Column(name = "WorldMapAreaID", nullable = false)
    private Integer worldMapAreaID;

    @ColumnDefault("'0'")
    @Column(name = "AreaTableID", columnDefinition = "int UNSIGNED not null")
    private Long areaTableID;

}