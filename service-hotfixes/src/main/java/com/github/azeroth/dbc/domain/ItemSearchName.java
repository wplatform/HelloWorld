package com.github.azeroth.dbc.domain;

import com.github.azeroth.cache.DbcEntity;
import com.github.azeroth.common.LocalizedString;
import com.github.azeroth.dbc.db2.Db2Field;
import com.github.azeroth.dbc.db2.Db2DataBind;
import com.github.azeroth.dbc.db2.Db2Type;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString


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
    @Column("AllowableRace")
    private Long allowableRace;

    @Column("Display")
    private LocalizedString display;

    @Id

    @Column("ID")
    private int id;

    @Column("Flags1")
    private Integer flags1;

    @Column("Flags2")
    private Integer flags2;

    @Column("Flags3")
    private Integer flags3;

    @Column("ItemLevel")
    private Short itemLevel;

    @Column("OverallQualityID")
    private Byte overallQualityID;

    @Column("ExpansionID")
    private Byte expansionID;

    @Column("RequiredLevel")
    private Byte requiredLevel;

    @Column("MinFactionID")
    private Short minFactionID;

    @Column("MinReputation")
    private Byte minReputation;

    @Column("AllowableClass")
    private Integer allowableClass;

    @Column("RequiredSkill")
    private Short requiredSkill;

    @Column("RequiredSkillRank")
    private Short requiredSkillRank;

    @Column("RequiredAbility")
    private Integer requiredAbility;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
