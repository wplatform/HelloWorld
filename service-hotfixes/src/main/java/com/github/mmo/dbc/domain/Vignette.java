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


@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)


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
    
    @Column("ID")
    private int id;

    @Id
    
    @Column("VerifiedBuild")
    private Integer verifiedBuild;


    @Column("Name")
    private LocalizedString name;

    
    @Column("PlayerConditionID")
    private Long playerConditionID;

    
    @Column("VisibleTrackingQuestID")
    private Long visibleTrackingQuestID;

    
    @Column("QuestFeedbackEffectID")
    private Long questFeedbackEffectID;

    
    @Column("Flags")
    private Integer flags;

    
    @Column("MaxHeight")
    private Float maxHeight;

    
    @Column("MinHeight")
    private Float minHeight;

    
    @Column("VignetteType")
    private Byte vignetteType;

    
    @Column("RewardQuestID")
    private Integer rewardQuestID;

}