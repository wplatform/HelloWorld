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
@ToString(onlyExplicitlyIncluded = true)


@Table(name = "animation_data")
@Db2DataBind(name = "AnimationData.db2", layoutHash = 0x03182786, fields = {
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "fallback", type = Db2Type.SHORT),
        @Db2Field(name = "behaviorID", type = Db2Type.SHORT),
        @Db2Field(name = "behaviorTier", type = Db2Type.BYTE)
})
public class AnimationData implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;


    @Column("Fallback")
    private Integer fallback;


    @Column("BehaviorTier")
    private Short behaviorTier;


    @Column("BehaviorID")
    private Integer behaviorID;


    @Column("Flags")
    private Integer flags;

}