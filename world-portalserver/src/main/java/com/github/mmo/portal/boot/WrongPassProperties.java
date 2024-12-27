package com.github.mmo.portal.boot;

import lombok.Data;

@Data
public class WrongPassProperties {

    private int maxCount;
    private int banTime;
    private int banType;
    private int logging;

}
