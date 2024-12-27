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
@Table(name = "world_effect")
@Db2DataBind(name = "WorldEffect.db2", layoutHash = 0x2E9B9BFD, fields = {
        @Db2Field(name = "targetAsset", type = Db2Type.INT, signed = true),
        @Db2Field(name = "combatConditionID", type = Db2Type.SHORT),
        @Db2Field(name = "targetType", type = Db2Type.BYTE),
        @Db2Field(name = "whenToDisplay", type = Db2Type.BYTE),
        @Db2Field(name = "questFeedbackEffectID", type = Db2Type.INT),
        @Db2Field(name = "playerConditionID", type = Db2Type.INT)
})
public class WorldEffect implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "TargetAsset")
    private Integer targetAsset;

    @Column(name = "CombatConditionID")
    private Short combatConditionID;

    @Column(name = "TargetType")
    private Byte targetType;

    @Column(name = "WhenToDisplay")
    private Byte whenToDisplay;

    @Column(name = "QuestFeedbackEffectID")
    private Integer questFeedbackEffectID;

    @Column(name = "PlayerConditionID")
    private Integer playerConditionID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
