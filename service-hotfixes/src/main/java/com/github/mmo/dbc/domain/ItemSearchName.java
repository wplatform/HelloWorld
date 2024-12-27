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
@Table(name = "item_search_name")
@Db2DataBind(name = "ItemSearchName.db2", layoutHash = 0x2D4B72FA, indexField = 2, fields = {
        @Db2Field(name = "allowableRace", type = Db2Type.LONG, signed = true),
        @Db2Field(name = "display", type = Db2Type.STRING),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = {"flags1", "flags2", "flags3"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "itemLevel", type = Db2Type.SHORT),
        @Db2Field(name = "overallQualityID", type = Db2Type.BYTE),
        @Db2Field(name = "expansionID", type = Db2Type.BYTE),
        @Db2Field(name = "requiredLevel", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "minFactionID", type = Db2Type.SHORT),
        @Db2Field(name = "minReputation", type = Db2Type.BYTE),
        @Db2Field(name = "allowableClass", type = Db2Type.INT, signed = true),
        @Db2Field(name = "requiredSkill", type = Db2Type.SHORT),
        @Db2Field(name = "requiredSkillRank", type = Db2Type.SHORT),
        @Db2Field(name = "requiredAbility", type = Db2Type.INT)
})
public class ItemSearchName implements DbcEntity {
    @Column(name = "AllowableRace")
    private Long allowableRace;

    @Column(name = "Display")
    private LocalizedString display;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Flags1")
    private Integer flags1;

    @Column(name = "Flags2")
    private Integer flags2;

    @Column(name = "Flags3")
    private Integer flags3;

    @Column(name = "ItemLevel")
    private Short itemLevel;

    @Column(name = "OverallQualityID")
    private Byte overallQualityID;

    @Column(name = "ExpansionID")
    private Byte expansionID;

    @Column(name = "RequiredLevel")
    private Byte requiredLevel;

    @Column(name = "MinFactionID")
    private Short minFactionID;

    @Column(name = "MinReputation")
    private Byte minReputation;

    @Column(name = "AllowableClass")
    private Integer allowableClass;

    @Column(name = "RequiredSkill")
    private Short requiredSkill;

    @Column(name = "RequiredSkillRank")
    private Short requiredSkillRank;

    @Column(name = "RequiredAbility")
    private Integer requiredAbility;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
