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
@Table(name = "gameobject_art_kit")
@Db2DataBind(name = "GameObjectArtKit.db2", layoutHash = 0x6F65BC41, fields = {
        @Db2Field(name = "attachModelFileID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"textureVariationFileID1", "textureVariationFileID2", "textureVariationFileID3"}, type = Db2Type.INT, signed = true)
})
public class GameObjectArtKit implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "AttachModelFileID")
    private Integer attachModelFileID;

    @Column(name = "TextureVariationFileID1")
    private Integer textureVariationFileID1;

    @Column(name = "TextureVariationFileID2")
    private Integer textureVariationFileID2;

    @Column(name = "TextureVariationFileID3")
    private Integer textureVariationFileID3;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
