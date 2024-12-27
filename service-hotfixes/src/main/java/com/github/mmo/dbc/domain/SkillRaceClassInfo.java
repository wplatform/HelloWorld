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
@Table(name = "skill_race_class_info")
@Db2DataBind(name = "SkillRaceClassInfo.db2", layoutHash = 0x9752C2CE, parentIndexField = 1, fields = {
        @Db2Field(name = "raceMask", type = Db2Type.LONG, signed = true),
        @Db2Field(name = "skillID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.SHORT),
        @Db2Field(name = "skillTierID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "availability", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "minLevel", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "classMask", type = Db2Type.INT, signed = true)
})
public class SkillRaceClassInfo implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "RaceMask")
    private Long raceMask;

    @Column(name = "SkillID")
    private Short skillID;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "SkillTierID")
    private Short skillTierID;

    @Column(name = "Availability")
    private Byte availability;

    @Column(name = "MinLevel")
    private Byte minLevel;

    @Column(name = "ClassMask")
    private Integer classMask;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
