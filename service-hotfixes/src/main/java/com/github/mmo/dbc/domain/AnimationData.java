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
@ToString(onlyExplicitlyIncluded = true)
@IdClass(DB2Id.class)
@Entity
@Table(name = "animation_data")
@Db2DataBind(name = "AnimationData.db2", layoutHash = 0x03182786, fields = {
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "fallback", type = Db2Type.SHORT),
        @Db2Field(name = "behaviorID", type = Db2Type.SHORT),
        @Db2Field(name = "behaviorTier", type = Db2Type.BYTE)
})
public class AnimationData implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @ColumnDefault("'0'")
    @Column(name = "Fallback", columnDefinition = "smallint UNSIGNED not null")
    private Integer fallback;

    @ColumnDefault("'0'")
    @Column(name = "BehaviorTier", columnDefinition = "tinyint UNSIGNED not null")
    private Short behaviorTier;

    @ColumnDefault("0")
    @Column(name = "BehaviorID", nullable = false)
    private Integer behaviorID;

    @ColumnDefault("0")
    @Column(name = "Flags", nullable = false)
    private Integer flags;

}