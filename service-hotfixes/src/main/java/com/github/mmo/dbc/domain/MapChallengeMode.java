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
@Table(name = "map_challenge_mode")
@Db2DataBind(name = "MapChallengeMode.db2", layoutHash = 0xC5261662, indexField = 1, parentIndexField = 2, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "id", type = Db2Type.INT, signed = true),
        @Db2Field(name = "mapID", type = Db2Type.SHORT),
        @Db2Field(name = {"criteriaCount1", "criteriaCount2", "criteriaCount3"}, type = Db2Type.SHORT),
        @Db2Field(name = "flags", type = Db2Type.BYTE)
})
public class MapChallengeMode implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Lob
    @Column(name = "Name")
    private LocalizedString name;

    @ColumnDefault("'0'")
    @Column(name = "MapID", columnDefinition = "smallint UNSIGNED not null")
    private Integer mapID;

    @ColumnDefault("'0'")
    @Column(name = "Flags", columnDefinition = "tinyint UNSIGNED not null")
    private Short flags;

    @ColumnDefault("0")
    @Column(name = "CriteriaCount1", nullable = false)
    private Short criteriaCount1;

    @ColumnDefault("0")
    @Column(name = "CriteriaCount2", nullable = false)
    private Short criteriaCount2;

    @ColumnDefault("0")
    @Column(name = "CriteriaCount3", nullable = false)
    private Short criteriaCount3;

}