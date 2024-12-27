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
@Table(name = "scaling_stat_distribution")
@Db2DataBind(name = "ScalingStatDistribution.db2", layoutHash = 0xDED48286, fields = {
        @Db2Field(name = "playerLevelToItemLevelCurveID", type = Db2Type.SHORT),
        @Db2Field(name = "minLevel", type = Db2Type.INT, signed = true),
        @Db2Field(name = "maxLevel", type = Db2Type.INT, signed = true)
})
public class ScalingStatDistribution implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "PlayerLevelToItemLevelCurveID")
    private Short playerLevelToItemLevelCurveID;

    @Column(name = "MinLevel")
    private Integer minLevel;

    @Column(name = "MaxLevel")
    private Integer maxLevel;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
