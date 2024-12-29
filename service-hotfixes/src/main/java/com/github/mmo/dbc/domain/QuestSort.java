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


@Getter
@Setter
@ToString


@Table(name = "quest_sort")
@Db2DataBind(name = "QuestSort.db2", layoutHash = 0xAD7072C6, fields = {
        @Db2Field(name = "sortName", type = Db2Type.STRING),
        @Db2Field(name = "uiOrderIndex", type = Db2Type.BYTE, signed = true)
})
public class QuestSort implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("SortName")
    private LocalizedString sortName;

    @Column("UiOrderIndex")
    private Byte uiOrderIndex;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
