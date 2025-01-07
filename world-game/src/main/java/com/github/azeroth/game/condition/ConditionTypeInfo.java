package com.github.azeroth.game.condition;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class ConditionTypeInfo {
    public String name;
    public boolean hasConditionValue1;
    public boolean hasConditionValue2;
    public boolean hasConditionValue3;
    public boolean hasConditionStringValue1;

}
