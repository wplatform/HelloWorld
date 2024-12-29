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


@Table(name = "cinematic_camera")
@Db2DataBind(name = "CinematicCamera.db2", layoutHash = 0x0062B0F4, fields = {
        @Db2Field(name = "soundID", type = Db2Type.INT),
        @Db2Field(name = {"originX", "originY", "originZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = "originFacing", type = Db2Type.FLOAT),
        @Db2Field(name = "fileDataID", type = Db2Type.INT)
})
public class CinematicCamera implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("SoundID")
    private Integer soundID;

    @Column("OriginX")
    private Float originX;

    @Column("OriginY")
    private Float originY;

    @Column("OriginZ")
    private Float originZ;

    @Column("OriginFacing")
    private Float originFacing;

    @Column("FileDataID")
    private Integer fileDataID;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
