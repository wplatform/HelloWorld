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
@Table(name = "spell_cooldowns")
@Db2DataBind(name = "SpellCooldowns.db2", layoutHash = 0xCA8D8B3C, parentIndexField = 4, fields = {
        @Db2Field(name = "categoryRecoveryTime", type = Db2Type.INT, signed = true),
        @Db2Field(name = "recoveryTime", type = Db2Type.INT, signed = true),
        @Db2Field(name = "startRecoveryTime", type = Db2Type.INT, signed = true),
        @Db2Field(name = "difficultyID", type = Db2Type.BYTE),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true)
})
public class SpellCooldown implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "CategoryRecoveryTime")
    private Integer categoryRecoveryTime;

    @Column(name = "RecoveryTime")
    private Integer recoveryTime;

    @Column(name = "StartRecoveryTime")
    private Integer startRecoveryTime;

    @Column(name = "DifficultyID")
    private Byte difficultyID;

    @Column(name = "SpellID")
    private Integer spellID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
