package com.github.mmo.service.character.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@IdClass(GmComplaintChatlogId.class)
@Entity
@Table(name = "gm_complaint_chatlog")
public class GmComplaintChatlog {
    @Id
    @Column(name = "complaintId", columnDefinition = "int UNSIGNED not null")
    private Long complaintId;

    @Id
    @Column(name = "lineId", columnDefinition = "int UNSIGNED not null")
    private Long lineId;

    @Column(name = "timestamp", nullable = false)
    private Long timestamp;

    @Lob
    @Column(name = "text", nullable = false)
    private String text;

}