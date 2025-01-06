package com.github.mmo.game.domain.misc;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.PersistenceCreator;

@Data
@AllArgsConstructor(onConstructor_ = {@PersistenceCreator})
public class SystemText {
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