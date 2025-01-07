package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


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

    @Column("ID")
    private int id;

    @Column("Asset")
    private Integer asset;

    @Column("StartAsset")
    private Integer startAsset;

    @Column("FailAsset")
    private Integer failAsset;

    @Column("ModifierTreeId")
    private Integer ModifierTreeId;

    @Column("StartTimer")
    private Short startTimer;

    @Column("EligibilityWorldStateID")
    private Short eligibilityWorldStateID;

    @Column("Type")
    private Short type;

    @Column("StartEvent")
    private Byte startEvent;

    @Column("FailEvent")
    private Byte failEvent;

    @Column("Flags")
    private Byte flags;

    @Column("EligibilityWorldStateValue")
    private Byte eligibilityWorldStateValue;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
