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


@Table(name = "spell_visual_kit")
@Db2DataBind(name = "SpellVisualKit.db2", layoutHash = 0xDC04F488, fields = {
        @Db2Field(name = "flags", type = Db2Type.INT, signed = true),
        @Db2Field(name = "fallbackPriority", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "fallbackSpellVisualKitId", type = Db2Type.INT),
        @Db2Field(name = "delayMin", type = Db2Type.SHORT),
        @Db2Field(name = "delayMax", type = Db2Type.SHORT)
})
public class SpellVisualKit implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("Flags")
    private Integer flags;

    @Column("FallbackPriority")
    private Byte fallbackPriority;

    @Column("FallbackSpellVisualKitId")
    private Integer fallbackSpellVisualKitId;

    @Column("DelayMin")
    private Short delayMin;

    @Column("DelayMax")
    private Short delayMax;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
