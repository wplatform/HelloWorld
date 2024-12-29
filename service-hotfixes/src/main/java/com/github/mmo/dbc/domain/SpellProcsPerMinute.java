package com.github.mmo.dbc.domain;

import com.github.mmo.cache.DbcEntity;
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


@Table(name = "spell_procs_per_minute")
@Db2DataBind(name = "SpellProcsPerMinute.db2", layoutHash = 0x4BC1931B, fields = {
        @Db2Field(name = "baseProcRate", type = Db2Type.FLOAT),
        @Db2Field(name = "flags", type = Db2Type.BYTE)
})
public class SpellProcsPerMinute implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("BaseProcRate")
    private Float baseProcRate;

    @Column("Flags")
    private Byte flags;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
