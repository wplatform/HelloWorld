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


@Table(name = "spell_keybound_override")
@Db2DataBind(name = "SpellKeyboundOverride.db2", layoutHash = 0x6ECA16FC, fields = {
        @Db2Field(name = "function", type = Db2Type.STRING),
        @Db2Field(name = "data", type = Db2Type.INT, signed = true),
        @Db2Field(name = "type", type = Db2Type.BYTE)
})
public class SpellKeyboundOverride implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Function")
    private LocalizedString function;

    @Column("Data")
    private Integer data;

    @Column("Type")
    private Byte type;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
