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
@Table(name = "battle_pet_species")
@Db2DataBind(name = "BattlePetSpecies.db2", layoutHash = 0x8A3D97A4, indexField = 8, fields = {
        @Db2Field(name = "sourceText", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "creatureID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "iconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "summonSpellID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "flags", type = Db2Type.SHORT),
        @Db2Field(name = "petTypeEnum", type = Db2Type.BYTE),
        @Db2Field(name = "sourceTypeEnum", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "id", type = Db2Type.INT),
        @Db2Field(name = "cardUIModelSceneID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "loadoutUIModelSceneID", type = Db2Type.INT, signed = true)
})
public class BattlePetSpecie implements DbcEntity {
    @Column(name = "SourceText")
    private LocalizedString sourceText;

    @Column(name = "Description")
    private LocalizedString description;

    @Column(name = "CreatureID")
    private Integer creatureID;

    @Column(name = "IconFileDataID")
    private Integer iconFileDataID;

    @Column(name = "SummonSpellID")
    private Integer summonSpellID;

    @Column(name = "Flags")
    private Short flags;

    @Column(name = "PetTypeEnum")
    private Byte petTypeEnum;

    @Column(name = "SourceTypeEnum")
    private Byte sourceTypeEnum;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "CardUIModelSceneID")
    private Integer cardUIModelSceneID;

    @Column(name = "LoadoutUIModelSceneID")
    private Integer loadoutUIModelSceneID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
