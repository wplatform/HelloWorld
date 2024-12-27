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
@Table(name = "garr_follower_x_ability")
@Db2DataBind(name = "GarrFollowerXAbility.db2", layoutHash = 0x996447F1, parentIndexField = 2, fields = {
        @Db2Field(name = "garrAbilityID", type = Db2Type.SHORT),
        @Db2Field(name = "factionIndex", type = Db2Type.BYTE),
        @Db2Field(name = "garrFollowerID", type = Db2Type.SHORT)
})
public class GarrFollowerXAbility implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "GarrAbilityID")
    private Short garrAbilityID;

    @Column(name = "FactionIndex")
    private Byte factionIndex;

    @Column(name = "GarrFollowerID")
    private Short garrFollowerID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
