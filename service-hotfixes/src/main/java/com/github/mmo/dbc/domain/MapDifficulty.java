package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.EnumFlag;
import com.github.mmo.common.LocalizedString;
import com.github.mmo.dbc.db2.Db2Field;
import com.github.mmo.dbc.db2.Db2DataBind;
import com.github.mmo.dbc.db2.Db2Type;
import com.github.mmo.dbc.defines.MapDifficultyFlag;
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
@Table(name = "map_difficulty")
@Db2DataBind(name = "MapDifficulty.db2", layoutHash = 0x2B3B759E, parentIndexField = 8, fields = {
        @Db2Field(name = "message", type = Db2Type.STRING),
        @Db2Field(name = "difficultyID", type = Db2Type.BYTE),
        @Db2Field(name = "resetInterval", type = Db2Type.BYTE),
        @Db2Field(name = "maxPlayers", type = Db2Type.BYTE),
        @Db2Field(name = "lockID", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "itemContext", type = Db2Type.BYTE),
        @Db2Field(name = "itemContextPickerID", type = Db2Type.INT),
        @Db2Field(name = "mapID", type = Db2Type.SHORT)
})
public class MapDifficulty implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Message")
    private LocalizedString message;

    @Column(name = "DifficultyID")
    private Byte difficultyID;

    @Column(name = "ResetInterval")
    private Byte resetInterval;

    @Column(name = "MaxPlayers")
    private Byte maxPlayers;

    @Column(name = "LockID")
    private Short lockID;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "ItemContext")
    private Byte itemContext;

    @Column(name = "ItemContextPickerID")
    private Integer itemContextPickerID;

    @Column(name = "MapID")
    private Short mapID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;


    public boolean hasResetSchedule() {
        return resetInterval != 0;
    }

    public boolean isUsingEncounterLocks() {
        return flags().hasFlag(MapDifficultyFlag.UseLootBasedLockInsteadOfInstanceLock);
    }

    public boolean isRestoringDungeonState() {
        return flags().hasFlag(MapDifficultyFlag.ResumeDungeonProgressBasedOnLockout);
    }

    public boolean isExtendable() {
        return !flags().hasFlag(MapDifficultyFlag.DisableLockExtension);
    }


    public int GetRaidDuration() {
        if (resetInterval == 1)
            return 86400;
        if (resetInterval == 2)
            return 604800;
        return 0;
    }

    public EnumFlag<MapDifficultyFlag> flags() {
        return EnumFlag.of(MapDifficultyFlag.class, flags);
    }

}
