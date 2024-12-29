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


@Table(name = "gameobject_art_kit")
@Db2DataBind(name = "GameObjectArtKit.db2", layoutHash = 0x6F65BC41, fields = {
        @Db2Field(name = "attachModelFileID", type = Db2Type.INT, signed = true),
        @Db2Field(name = {"textureVariationFileID1", "textureVariationFileID2", "textureVariationFileID3"}, type = Db2Type.INT, signed = true)
})
public class GameObjectArtKit implements DbcEntity {
    @Id

    @Column("ID")
    private int id;

    @Column("AttachModelFileID")
    private Integer attachModelFileID;

    @Column("TextureVariationFileID1")
    private Integer textureVariationFileID1;

    @Column("TextureVariationFileID2")
    private Integer textureVariationFileID2;

    @Column("TextureVariationFileID3")
    private Integer textureVariationFileID3;

    @Id

    @Column("VerifiedBuild")
    private Integer verifiedBuild;

}
