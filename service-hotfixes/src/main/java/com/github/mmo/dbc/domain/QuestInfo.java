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


@Table(name = "quest_info")
@Db2DataBind(name = "QuestInfo.db2", layoutHash = 0x4F45F445, fields = {
        @Db2Field(name = "infoName", type = Db2Type.STRING),
        @Db2Field(name = "profession", type = Db2Type.SHORT),
        @Db2Field(name = "type", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "Modifiers", type = Db2Type.BYTE)
})
public class QuestInfo implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("InfoName")
    private LocalizedString infoName;

    @Column("Profession")
    private Short profession;

    @Column("Type")
    private Byte type;

    @Column("Modifiers")
    private Byte Modifiers;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
