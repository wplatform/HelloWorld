package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@IdClass(AccountInstanceTimeId.class)
@Entity
@Table(name = "account_instance_times")
public class AccountInstanceTime {
    @Id
    @Column(name = "accountId", columnDefinition = "int UNSIGNED not null")
    private Integer accountId;

    @Id
    @ColumnDefault("'0'")
    @Column(name = "instanceId", columnDefinition = "int UNSIGNED not null")
    private Integer instanceId;

    @ColumnDefault("'0'")
    @Column(name = "releaseTime", nullable = false)
    private Instant releaseTime;

}