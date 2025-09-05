package com.github.azeroth.game.domain.creature;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GroupAIFlag implements EnumFlag.FlagValue {
    AGGRO_NONE            (0),                                                         // No creature group behavior
    MEMBERS_ASSIST_LEADER (0x00000001),                                                // The member aggroes if the leader aggroes
    LEADER_ASSISTS_MEMBER (0x00000002),                                                // The leader aggroes if the member aggroes
    MEMBERS_ASSIST_MEMBER (MEMBERS_ASSIST_LEADER.value | LEADER_ASSISTS_MEMBER.value), // every member will assist if any member is attacked
    IDLE_IN_FORMATION     (0x00000200);                                                // The member will follow the leader when pathing idly
    
    public final int value;

}
