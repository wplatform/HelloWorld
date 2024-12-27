package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "mail")
public class Mail {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "id", nullable = false)
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "messageType", columnDefinition = "tinyint UNSIGNED not null")
    private Short messageType;

    @ColumnDefault("41")
    @Column(name = "stationery", nullable = false)
    private Byte stationery;

    @ColumnDefault("'0'")
    @Column(name = "mailTemplateId", columnDefinition = "smallint UNSIGNED not null")
    private Integer mailTemplateId;

    @ColumnDefault("'0'")
    @Column(name = "sender", nullable = false)
    private Long sender;

    @ColumnDefault("'0'")
    @Column(name = "receiver", nullable = false)
    private Long receiver;

    @Lob
    @Column(name = "subject")
    private String subject;

    @Lob
    @Column(name = "body")
    private String body;

    @ColumnDefault("'0'")
    @Column(name = "has_items", columnDefinition = "tinyint UNSIGNED not null")
    private Short hasItems;

    @ColumnDefault("0")
    @Column(name = "expire_time", nullable = false)
    private Long expireTime;

    @ColumnDefault("0")
    @Column(name = "deliver_time", nullable = false)
    private Long deliverTime;

    @ColumnDefault("'0'")
    @Column(name = "money", nullable = false)
    private Long money;

    @ColumnDefault("'0'")
    @Column(name = "cod", nullable = false)
    private Long cod;

    @ColumnDefault("'0'")
    @Column(name = "checked", columnDefinition = "tinyint UNSIGNED not null")
    private Short checked;

}