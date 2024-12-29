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


@Getter
@Setter
@ToString


@Table(name = "mount_x_display")
@Db2DataBind(name = "MountXDisplay.db2", layoutHash = 0xD59B9FE4, parentIndexField = 2, fields = {
        @Db2Field(name = "creatureDisplayInfoID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "playerConditionID", type = Db2Type.INT),
        @Db2Field(name = "mountID", type = Db2Type.INT, signed = true)
})
public class MountXDisplay implements DbcEntity {
    @Id
    
    @Column("ID")
    private int id;

    @Column("CreatureDisplayInfoID")
    private Integer creatureDisplayInfoID;

    @Column("PlayerConditionID")
    private Integer playerConditionID;

    @Column("MountID")
    private Integer mountID;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
