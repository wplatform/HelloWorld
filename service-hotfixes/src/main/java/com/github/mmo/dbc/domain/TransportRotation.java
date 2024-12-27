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
@Table(name = "transport_rotation")
@Db2DataBind(name = "TransportRotation.db2", layoutHash = 0x72035AA9, parentIndexField = 2, fields = {
        @Db2Field(name = "timeIndex", type = Db2Type.INT),
        @Db2Field(name = {"rot1", "rot2", "rot3", "rot4"}, type = Db2Type.FLOAT),
        @Db2Field(name = "gameObjectsID", type = Db2Type.INT, signed = true)
})
public class TransportRotation implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "TimeIndex")
    private Integer timeIndex;

    @Column(name = "Rot1")
    private Float rot1;

    @Column(name = "Rot2")
    private Float rot2;

    @Column(name = "Rot3")
    private Float rot3;

    @Column(name = "Rot4")
    private Float rot4;

    @Column(name = "GameObjectsID")
    private Integer gameObjectsID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
