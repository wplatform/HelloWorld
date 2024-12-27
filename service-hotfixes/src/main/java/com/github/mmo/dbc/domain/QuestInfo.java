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
@Table(name = "quest_info")
@Db2DataBind(name = "QuestInfo.db2", layoutHash = 0x4F45F445, fields = {
        @Db2Field(name = "infoName", type = Db2Type.STRING),
        @Db2Field(name = "profession", type = Db2Type.SHORT),
        @Db2Field(name = "type", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "Modifiers", type = Db2Type.BYTE)
})
public class QuestInfo implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "InfoName")
    private LocalizedString infoName;

    @Column(name = "Profession")
    private Short profession;

    @Column(name = "Type")
    private Byte type;

    @Column(name = "Modifiers")
    private Byte Modifiers;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
