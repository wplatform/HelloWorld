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
@Table(name = "friendship_rep_reaction")
@Db2DataBind(name = "FriendshipRepReaction.db2", layoutHash = 0x9C412E5B, parentIndexField = 2, fields = {
        @Db2Field(name = "reaction", type = Db2Type.STRING),
        @Db2Field(name = "reactionThreshold", type = Db2Type.SHORT),
        @Db2Field(name = "friendshipRepID", type = Db2Type.BYTE)
})
public class FriendshipRepReaction implements DbcEntity {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Integer id;

    @Column(name = "Reaction")
    private LocalizedString reaction;

    @Column(name = "ReactionThreshold")
    private Integer reactionThreshold;

    @Column(name = "FriendshipRepID")
    private Short friendshipRepID;

    @Id
    @ColumnDefault("0")
    @Column(name = "VerifiedBuild", nullable = false)
    private Integer verifiedBuild;

}
