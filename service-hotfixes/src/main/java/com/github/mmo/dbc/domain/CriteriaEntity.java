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
@Table(name = "criteria")
@Db2DataBind(name = "Criteria.db2", layoutHash = 0xA87A5BB9, fields = {
        @Db2Field(name = "asset", type = Db2Type.INT),
        @Db2Field(name = "startAsset", type = Db2Type.INT, signed = true),
        @Db2Field(name = "failAsset", type = Db2Type.INT, signed = true),
        @Db2Field(name = "ModifierTreeId", type = Db2Type.INT),
        @Db2Field(name = "startTimer", type = Db2Type.SHORT),
        @Db2Field(name = "eligibilityWorldStateID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "type", type = Db2Type.BYTE),
        @Db2Field(name = "startEvent", type = Db2Type.BYTE),
        @Db2Field(name = "failEvent", type = Db2Type.BYTE),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
        @Db2Field(name = "eligibilityWorldStateValue", type = Db2Type.BYTE, signed = true)
})
public class CriteriaEntity implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Asset")
    private Integer asset;

    @Column(name = "StartAsset")
    private Integer startAsset;

    @Column(name = "FailAsset")
    private Integer failAsset;

    @Column(name = "ModifierTreeId")
    private Integer ModifierTreeId;

    @Column(name = "StartTimer")
    private Short startTimer;

    @Column(name = "EligibilityWorldStateID")
    private Short eligibilityWorldStateID;

    @Column(name = "Type")
    private Short type;

    @Column(name = "StartEvent")
    private Byte startEvent;

    @Column(name = "FailEvent")
    private Byte failEvent;

    @Column(name = "Flags")
    private Byte flags;

    @Column(name = "EligibilityWorldStateValue")
    private Byte eligibilityWorldStateValue;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
