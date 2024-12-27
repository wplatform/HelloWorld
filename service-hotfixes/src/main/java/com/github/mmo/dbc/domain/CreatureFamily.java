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
@ToString
@IdClass(DB2Id.class)
@Entity
@Table(name = "creature_family")
@Db2DataBind(name = "CreatureFamily.db2", layoutHash = 0xE2DC5126, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "minScale", type = Db2Type.FLOAT),
        @Db2Field(name = "maxScale", type = Db2Type.FLOAT),
        @Db2Field(name = "iconFileID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"skillLine1", "skillLine2"}, type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "petFoodMask", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "minScaleLevel", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "maxScaleLevel", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "petTalentType", type = Db2Type.BYTE, signed = true)
})
public class CreatureFamily implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "MinScale")
    private Float minScale;

    @Column(name = "MaxScale")
    private Float maxScale;

    @Column(name = "IconFileID")
    private Integer iconFileID;

    @Column(name = "SkillLine1")
    private Short skillLine1;

    @Column(name = "SkillLine2")
    private Short skillLine2;

    @Column(name = "PetFoodMask")
    private Short petFoodMask;

    @Column(name = "MinScaleLevel")
    private Byte minScaleLevel;

    @Column(name = "MaxScaleLevel")
    private Byte maxScaleLevel;

    @Column(name = "PetTalentType")
    private Byte petTalentType;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
