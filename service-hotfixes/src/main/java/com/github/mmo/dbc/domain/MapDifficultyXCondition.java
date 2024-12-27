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
@Table(name = "map_difficulty_x_condition")
@Db2DataBind(name = "MapDifficultyXCondition.db2", layoutHash = 0x5F5D7102, parentIndexField = 3, fields = {
        @Db2Field(name = "failureDescription", type = Db2Type.STRING),
        @Db2Field(name = "playerConditionID", type = Db2Type.INT),
        @Db2Field(name = "orderIndex", type = Db2Type.INT, signed = true),
        @Db2Field(name = "mapDifficultyId", type = Db2Type.INT),
})
public class MapDifficultyXCondition implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Lob
    @Column(name = "FailureDescription")
    private LocalizedString failureDescription;

    @ColumnDefault("'0'")
    @Column(name = "PlayerConditionID", columnDefinition = "int UNSIGNED not null")
    private Integer playerConditionID;

    @ColumnDefault("0")
    @Column(name = "OrderIndex", nullable = false)
    private Integer orderIndex;

    @ColumnDefault("'0'")
    @Column(name = "MapDifficultyID", columnDefinition = "int UNSIGNED not null")
    private Long mapDifficultyId;

}