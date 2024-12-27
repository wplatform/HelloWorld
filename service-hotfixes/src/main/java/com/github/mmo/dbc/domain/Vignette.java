package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
import com.github.mmo.common.LocalizedString;
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
@ToString(onlyExplicitlyIncluded = true)
@IdClass(DB2Id.class)
@Entity
@Table(name = "vignette")
@Db2DataBind(name = "Vignette.db2", layoutHash = 0x52E3B381, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "maxHeight", type = Db2Type.FLOAT),
        @Db2Field(name = "minHeight", type = Db2Type.FLOAT),
        @Db2Field(name = "questFeedbackEffectID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "playerConditionID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "visibleTrackingQuestID", type = Db2Type.INT, signed = true),
})
public class Vignette implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private  Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Lob
    @Column(name = "Name")
    private LocalizedString name;

    @ColumnDefault("'0'")
    @Column(name = "PlayerConditionID", columnDefinition = "int UNSIGNED not null")
    private Long playerConditionID;

    @ColumnDefault("'0'")
    @Column(name = "VisibleTrackingQuestID", columnDefinition = "int UNSIGNED not null")
    private Long visibleTrackingQuestID;

    @ColumnDefault("'0'")
    @Column(name = "QuestFeedbackEffectID", columnDefinition = "int UNSIGNED not null")
    private Long questFeedbackEffectID;

    @ColumnDefault("0")
    @Column(name = "Flags", nullable = false)
    private Integer flags;

    @ColumnDefault("0")
    @Column(name = "MaxHeight", nullable = false)
    private Float maxHeight;

    @ColumnDefault("0")
    @Column(name = "MinHeight", nullable = false)
    private Float minHeight;

    @ColumnDefault("0")
    @Column(name = "VignetteType", nullable = false)
    private Byte vignetteType;

    @ColumnDefault("0")
    @Column(name = "RewardQuestID", nullable = false)
    private Integer rewardQuestID;

}