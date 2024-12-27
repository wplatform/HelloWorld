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
@Table(name = "summon_properties")
@Db2DataBind(name = "SummonProperties.db2", layoutHash = 0xFB8338FC, fields = {
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "control", type = Db2Type.INT, signed = true),
        @Db2Field(name = "faction", type = Db2Type.INT, signed = true),
        @Db2Field(name = "title", type = Db2Type.INT, signed = true),
        @Db2Field(name = "slot", type = Db2Type.INT, signed = true)
})
public class SummonProperty implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "Control")
    private Integer control;

    @Column(name = "Faction")
    private Integer faction;

    @Column(name = "Title")
    private Integer title;

    @Column(name = "Slot")
    private Integer slot;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
