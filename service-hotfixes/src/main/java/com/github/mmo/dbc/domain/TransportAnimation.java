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
@Table(name = "transport_animation")
@Db2DataBind(name = "TransportAnimation.db2", layoutHash = 0x099987ED, parentIndexField = 3, fields = {
        @Db2Field(name = "timeIndex", type = Db2Type.INT),
        @Db2Field(name = {"posX", "posY", "posZ"}, type = Db2Type.FLOAT),
        @Db2Field(name = "sequenceID", type = Db2Type.BYTE),
        @Db2Field(name = "transportID", type = Db2Type.INT, signed = true)
})
public class TransportAnimation implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "TimeIndex")
    private Integer timeIndex;

    @Column(name = "PosX")
    private Float posX;

    @Column(name = "PosY")
    private Float posY;

    @Column(name = "PosZ")
    private Float posZ;

    @Column(name = "SequenceID")
    private Short sequenceID;

    @Column(name = "TransportID")
    private Integer transportID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
