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
@Table(name = "cinematic_camera")
@Db2DataBind(name = "CinematicCamera.db2", layoutHash = 0x0062B0F4, fields = {
        @Db2Field(name = "soundID", type = Db2Type.INT),
        @Db2Field(name = {"originX", "originY", "originZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = "originFacing", type = Db2Type.FLOAT),
        @Db2Field(name = "fileDataID", type = Db2Type.INT)
})
public class CinematicCamera implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "SoundID")
    private Integer soundID;

    @Column(name = "OriginX")
    private Float originX;

    @Column(name = "OriginY")
    private Float originY;

    @Column(name = "OriginZ")
    private Float originZ;

    @Column(name = "OriginFacing")
    private Float originFacing;

    @Column(name = "FileDataID")
    private Integer fileDataID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
