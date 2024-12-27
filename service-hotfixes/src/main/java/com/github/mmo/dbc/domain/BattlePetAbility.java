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
@ToString(onlyExplicitlyIncluded = true)
@IdClass(DB2Id.class)
@Entity
@Table(name = "battle_pet_ability")
@Db2DataBind(name = "BattlePetAbility.db2", layoutHash = 0x0F29944D, fields = {
        @Db2Field(name = "name", type = Db2Type.STRING),
        @Db2Field(name = "description", type = Db2Type.STRING),
        @Db2Field(name = "iconFileDataID", type = Db2Type.INT, signed = true),
        @Db2Field(name = "petTypeEnum", type = Db2Type.BYTE, signed = true),
        @Db2Field(name = "cooldown", type = Db2Type.INT),
        @Db2Field(name = "battlePetVisualID", type = Db2Type.SHORT),
        @Db2Field(name = "flags", type = Db2Type.BYTE),
})
public class BattlePetAbility implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

    @Lob
    @Column(name = "Name")
    private LocalizedString name;

    @Lob
    @Column(name = "Description")
    private LocalizedString description;

    @ColumnDefault("0")
    @Column(name = "IconFileDataID", nullable = false)
    private Integer iconFileDataID;

    @ColumnDefault("0")
    @Column(name = "PetTypeEnum", nullable = false)
    private Byte petTypeEnum;

    @ColumnDefault("'0'")
    @Column(name = "Cooldown", columnDefinition = "int UNSIGNED not null")
    private Long cooldown;

    @ColumnDefault("'0'")
    @Column(name = "BattlePetVisualID", columnDefinition = "smallint UNSIGNED not null")
    private Integer battlePetVisualID;

    @ColumnDefault("'0'")
    @Column(name = "Flags", columnDefinition = "tinyint UNSIGNED not null")
    private Short flags;

}