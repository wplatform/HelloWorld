package com.github.mmo.game.service.domain.misc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor(onConstructor_ = {@PersistenceCreator})
public class TrinityString {
    public Integer id;
    public String contentDefault;
    public String contentLoc1;
    public String contentLoc2;
    public String contentLoc3;
    public String contentLoc4;
    public String contentLoc5;
    public String contentLoc6;
    public String contentLoc7;
    public String contentLoc8;

}