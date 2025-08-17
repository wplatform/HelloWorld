package com.github.azeroth.game.domain.areatrigger;


import com.github.azeroth.common.EnumFlag;
import com.github.azeroth.game.domain.areatrigger.AreaTriggerAction;
import com.github.azeroth.game.domain.areatrigger.AreaTriggerId;

import java.util.ArrayList;

/**
 * Scale array definition
 * 0 - time offset from creation for starting of scaling
 * 1+2,3+4 are values for curve points Vector2[2]
 */
//  5 is packed curve information (has_no_data & 1) | ((interpolation_mode & 0x7) << 1) | ((first_point_offset & 0x7FFFFF) << 4) | ((point_count & 0x1F) << 27)
public class AreaTriggerTemplate {
    public AreaTriggerId id;
    public EnumFlag<AreaTriggerCreatePropertiesFlag> flags = EnumFlag.of(AreaTriggerCreatePropertiesFlag.class);

    public int actionSetId;
    public int actionSetFlags;

    public ArrayList<AreaTriggerAction> actions = new ArrayList<>();

    public final boolean hasFlag(AreaTriggerCreatePropertiesFlag flag) {
        return flags.hasFlag(flag);
    }
}
