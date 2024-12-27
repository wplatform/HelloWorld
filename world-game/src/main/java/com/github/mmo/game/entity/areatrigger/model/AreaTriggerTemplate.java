package com.github.mmo.game.entity.areatrigger.model;


import com.github.mmo.common.EnumFlag;
import com.github.mmo.game.entity.areatrigger.AreaTriggerAction;

import java.util.ArrayList;

/**
 * Scale array definition
 * 0 - time offset from creation for starting of scaling
 * 1+2,3+4 are values for curve points Vector2[2]
 */
//  5 is packed curve information (has_no_data & 1) | ((interpolation_mode & 0x7) << 1) | ((first_point_offset & 0x7FFFFF) << 4) | ((point_count & 0x1F) << 27)
public class AreaTriggerTemplate {
    public AreaTriggerId id = new AreaTriggerId();
    public EnumFlag<AreaTriggerCreatePropertiesFlag> flags = EnumFlag.of(AreaTriggerCreatePropertiesFlag.class);

    public ArrayList<AreaTriggerAction> actions = new ArrayList<>();

    public final boolean hasFlag(AreaTriggerCreatePropertiesFlag flag) {
        return flags.hasFlag(flag);
    }
}
