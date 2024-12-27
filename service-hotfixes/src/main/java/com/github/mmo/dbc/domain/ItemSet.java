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
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "ItemID1")
    private Integer itemID1;

    @Column(name = "ItemID2")
    private Integer itemID2;

    @Column(name = "ItemID3")
    private Integer itemID3;

    @Column(name = "ItemID4")
    private Integer itemID4;

    @Column(name = "ItemID5")
    private Integer itemID5;

    @Column(name = "ItemID6")
    private Integer itemID6;

    @Column(name = "ItemID7")
    private Integer itemID7;

    @Column(name = "ItemID8")
    private Integer itemID8;

    @Column(name = "ItemID9")
    private Integer itemID9;

    @Column(name = "ItemID10")
    private Integer itemID10;

    @Column(name = "ItemID11")
    private Integer itemID11;

    @Column(name = "ItemID12")
    private Integer itemID12;

    @Column(name = "ItemID13")
    private Integer itemID13;

    @Column(name = "ItemID14")
    private Integer itemID14;

    @Column(name = "ItemID15")
    private Integer itemID15;

    @Column(name = "ItemID16")
    private Integer itemID16;

    @Column(name = "ItemID17")
    private Integer itemID17;

    @Column(name = "RequiredSkillRank")
    private Short requiredSkillRank;

    @Column(name = "RequiredSkill")
    private Integer requiredSkill;

    @Column(name = "SetFlags")
    private Integer setFlags;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
