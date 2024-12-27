package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@IdClass(PetitionSignId.class)
@Entity
@Table(name = "petition_sign")
public class PetitionSign {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "petitionguid", nullable = false)
    private Long petitionguid;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "playerguid", nullable = false)
    private Long playerguid;

    @Column(name = "ownerguid", nullable = false)
    private Long ownerguid;

    @ColumnDefault("'0'")
    @Column(name = "player_account", columnDefinition = "int UNSIGNED not null")
    private Long playerAccount;

}