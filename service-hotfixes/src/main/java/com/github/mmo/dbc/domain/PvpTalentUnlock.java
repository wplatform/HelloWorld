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
@Table(name = "pvp_talent_unlock")
@Db2DataBind(name = "PvpTalentUnlock.db2", layoutHash = 0x465C83BC, fields = {
        @Db2Field(name = "tierID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "columnIndex", type = Db2Type.INT, signed = true),
        @Db2Field(name = "honorLevel", type = Db2Type.INT, signed = true)
})
public class PvpTalentUnlock implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "TierID")
    private Integer tierID;

    @Column(name = "ColumnIndex")
    private Integer columnIndex;

    @Column(name = "HonorLevel")
    private Integer honorLevel;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
