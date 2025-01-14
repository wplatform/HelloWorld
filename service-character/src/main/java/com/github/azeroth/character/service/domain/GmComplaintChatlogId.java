package com.github.azeroth.character.service.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GmComplaintChatlogId implements Serializable {
    public Long complaintId;

    public Long lineId;


}