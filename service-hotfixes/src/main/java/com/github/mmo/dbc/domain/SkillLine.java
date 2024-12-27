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
@Table(name = "skill_line")
@Db2DataBind(name = "SkillLine.db2", layoutHash = 0x3F7E88AF, fields = {
        @Db2Field(name = "displayName", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "alternateVerb", type = Db2Type.STRING),
        @Db2Field(name = "flags", type = Db2Type.SHORT),
        @Db2Field(name = "categoryID", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "canLink", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "spellIconFileID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "parentSkillLineID", type = Db2Type.INT)
})
public class SkillLine implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "DisplayName")
    private LocalizedString displayName;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "AlternateVerb")
    private LocalizedString alternateVerb;

    @Column(name = "Flags")
    private Integer flags;

    @Column(name = "CategoryID")
    private Byte categoryID;

    @Column(name = "CanLink")
    private Byte canLink;

    @Column(name = "SpellIconFileID")
    private Integer spellIconFileID;

    @Column(name = "ParentSkillLineID")
    private Integer parentSkillLineID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
