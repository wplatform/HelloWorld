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
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@ToString
@IdClass(DB2Id.class)
@Entity
@Table(name = "spell_interrupts")
@Db2DataBind(name = "SpellInterrupts.db2", layoutHash = 0x2FA8EA94, parentIndexField = 4, fields = {
        @Db2Field(name = "difficultyID", type = Db2Type.BYTE),
        @Db2Field(name = "interruptFlags", type = Db2Type.SHORT, signed = true),
        @Db2Field(name = {"auraInterruptFlags1", "auraInterruptFlags2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = {"channelInterruptFlags1", "channelInterruptFlags2"}, type = Db2Type.INT, signed = true),
        @Db2Field(name = "spellID", type = Db2Type.INT, signed = true)
})
public class SpellInterrupt implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "DifficultyID")
    private Byte difficultyID;

    @Column(name = "InterruptFlags")
    private Short interruptFlags;

    @Column(name = "AuraInterruptFlags1")
    private Integer auraInterruptFlags1;

    @Column(name = "AuraInterruptFlags2")
    private Integer auraInterruptFlags2;

    @Column(name = "ChannelInterruptFlags1")
    private Integer channelInterruptFlags1;

    @Column(name = "ChannelInterruptFlags2")
    private Integer channelInterruptFlags2;

    @Column(name = "SpellID")
    private Integer spellID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
