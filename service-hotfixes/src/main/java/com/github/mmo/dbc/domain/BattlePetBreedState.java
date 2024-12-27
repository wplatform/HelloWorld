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
@Table(name = "battle_pet_breed_state")
@Db2DataBind(name = "BattlePetBreedState.db2", layoutHash = 0x68D5C999, parentIndexField = 2, fields = {
        @Db2Field(name = "value", type = Db2Type.SHORT),
        @Db2Field(name = "battlePetStateID", type = Db2Type.BYTE),
        @Db2Field(name = "battlePetBreedID", type = Db2Type.BYTE)
})
public class BattlePetBreedState implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Value")
    private Short value;

    @Column(name = "BattlePetStateID")
    private Byte battlePetStateID;

    @Column(name = "BattlePetBreedID")
    private Byte battlePetBreedID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
