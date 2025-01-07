package com.github.azeroth.character.service.domain;

import org.springframework.data.relational.core.mapping.Column;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Table(name = "mail_items")
public class MailItem {
    @Id

    @Column("item_guid")
    private Long id;


    @Column("mail_id")
    private Long mailId;


    @Column("receiver")
    private Long receiver;

}