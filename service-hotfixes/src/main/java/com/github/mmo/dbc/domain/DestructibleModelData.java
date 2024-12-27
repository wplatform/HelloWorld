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
@Table(name = "destructible_model_data")
@Db2DataBind(name = "DestructibleModelData.db2", layoutHash = 0x1092C9AF, fields = {
        @Db2Field(name = "state0Wmo", type = Db2Type.SHORT),
        @Db2Field(name = "state1Wmo", type = Db2Type.SHORT),
        @Db2Field(name = "state2Wmo", type = Db2Type.SHORT),
        @Db2Field(name = "state3Wmo", type = Db2Type.SHORT),
        @Db2Field(name = "healEffectSpeed", type = Db2Type.SHORT),
        @Db2Field(name = "state0ImpactEffectDoodadSet", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "state0AmbientDoodadSet", type = Db2Type.BYTE),
        @Db2Field(name = "state0NameSet", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "state1DestructionDoodadSet", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "state1ImpactEffectDoodadSet", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "state1AmbientDoodadSet", type = Db2Type.BYTE),
        @Db2Field(name = "state1NameSet", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "state2DestructionDoodadSet", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "state2ImpactEffectDoodadSet", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "state2AmbientDoodadSet", type = Db2Type.BYTE),
        @Db2Field(name = "state2NameSet", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "state3InitDoodadSet", type = Db2Type.BYTE),
        @Db2Field(name = "state3AmbientDoodadSet", type = Db2Type.BYTE),
        @Db2Field(name = "state3NameSet", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "ejectDirection", type = Db2Type.BYTE),
        @Db2Field(name = "doNotHighlight", type = Db2Type.BYTE),
        @Db2Field(name = "healEffect", type = Db2Type.BYTE)
})
public class DestructibleModelData implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "State0Wmo")
    private Integer state0Wmo;

    @Column(name = "State1Wmo")
    private Integer state1Wmo;

    @Column(name = "State2Wmo")
    private Integer state2Wmo;

    @Column(name = "State3Wmo")
    private Integer state3Wmo;

    @Column(name = "HealEffectSpeed")
    private Short healEffectSpeed;

    @Column(name = "State0ImpactEffectDoodadSet")
    private Byte state0ImpactEffectDoodadSet;

    @Column(name = "State0AmbientDoodadSet")
    private Byte state0AmbientDoodadSet;

    @Column(name = "State0NameSet")
    private Byte state0NameSet;

    @Column(name = "State1DestructionDoodadSet")
    private Byte state1DestructionDoodadSet;

    @Column(name = "State1ImpactEffectDoodadSet")
    private Byte state1ImpactEffectDoodadSet;

    @Column(name = "State1AmbientDoodadSet")
    private Byte state1AmbientDoodadSet;

    @Column(name = "State1NameSet")
    private Byte state1NameSet;

    @Column(name = "State2DestructionDoodadSet")
    private Byte state2DestructionDoodadSet;

    @Column(name = "State2ImpactEffectDoodadSet")
    private Byte state2ImpactEffectDoodadSet;

    @Column(name = "State2AmbientDoodadSet")
    private Byte state2AmbientDoodadSet;

    @Column(name = "State2NameSet")
    private Byte state2NameSet;

    @Column(name = "State3InitDoodadSet")
    private Byte state3InitDoodadSet;

    @Column(name = "State3AmbientDoodadSet")
    private Byte state3AmbientDoodadSet;

    @Column(name = "State3NameSet")
    private Byte state3NameSet;

    @Column(name = "EjectDirection")
    private Byte ejectDirection;

    @Column(name = "DoNotHighlight")
    private Byte doNotHighlight;

    @Column(name = "HealEffect")
    private Byte healEffect;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
