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
@Table(name = "char_titles")
@Db2DataBind(name = "CharTitles.db2", layoutHash = 0x7A58AA5F, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "name1", type = Db2Type.STRING),
        @Db2Field(name = "maskID", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.BYTE, signed = true)
})
public class CharTitle implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Name")
    private LocalizedString name;

    @Column(name = "Name1")
    private LocalizedString name1;

    @Column(name = "MaskID")
    private Short maskID;

    @Column(name = "Flags")
    private Byte flags;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
