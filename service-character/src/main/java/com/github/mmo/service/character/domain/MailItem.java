package com.github.mmo.service.character.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "mail_items")
public class MailItem {
    @Id
    @ColumnDefault("'0'")
    @Column(name = "item_guid", nullable = false)
    private Long id;

    @ColumnDefault("'0'")
    @Column(name = "mail_id", nullable = false)
    private Long mailId;

    @ColumnDefault("'0'")
    @Column(name = "receiver", nullable = false)
    private Long receiver;

}