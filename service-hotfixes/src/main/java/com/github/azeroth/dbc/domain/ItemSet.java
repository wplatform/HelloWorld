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


@Table(name = "item_set")
@Db2DataBind(name = "ItemSet.db2", layoutHash = 0x847FF58A, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = {"itemID1", "itemID2", "itemID3", "itemID4", "itemID5", "itemID6", "itemID7", "itemID8", "itemID9", "itemID10", "itemID11", "itemID12", "itemID13", "itemID14", "itemID15", "itemID16", "itemID17"}, type = Db2Type.INT),
        @Db2Field(name = "requiredSkillRank", type = Db2Type.SHORT),
        @Db2Field(name = "requiredSkill", type = Db2Type.INT),
        @Db2Field(name = "setFlags", type = Db2Type.INT)
})
public class ItemSet implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Name")
    private LocalizedString name;

    @Column("ItemID1")
    private Integer itemID1;

    @Column("ItemID2")
    private Integer itemID2;

    @Column("ItemID3")
    private Integer itemID3;

    @Column("ItemID4")
    private Integer itemID4;

    @Column("ItemID5")
    private Integer itemID5;

    @Column("ItemID6")
    private Integer itemID6;

    @Column("ItemID7")
    private Integer itemID7;

    @Column("ItemID8")
    private Integer itemID8;

    @Column("ItemID9")
    private Integer itemID9;

    @Column("ItemID10")
    private Integer itemID10;

    @Column("ItemID11")
    private Integer itemID11;

    @Column("ItemID12")
    private Integer itemID12;

    @Column("ItemID13")
    private Integer itemID13;

    @Column("ItemID14")
    private Integer itemID14;

    @Column("ItemID15")
    private Integer itemID15;

    @Column("ItemID16")
    private Integer itemID16;

    @Column("ItemID17")
    private Integer itemID17;

    @Column("RequiredSkillRank")
    private Short requiredSkillRank;

    @Column("RequiredSkill")
    private Integer requiredSkill;

    @Column("SetFlags")
    private Integer setFlags;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
