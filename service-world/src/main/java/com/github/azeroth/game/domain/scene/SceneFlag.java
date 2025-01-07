package com.github.azeroth.game.domain.scene;

import com.github.azeroth.common.EnumFlag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SceneFlag implements EnumFlag.FlagValue {
    None                        (0x00),
    PlayerNonInteractablePhased (0x01), // Sets UNIT_FLAG_IMMUNE_TO_PC + UNIT_FLAG_IMMUNE_TO_NPC + UNIT_FLAG_PACIFIED
    FadeToBlackscreenOnComplete (0x02),
    NotCancelable               (0x04),
    FadeToBlackscreenOnCancel   (0x08),

    IgnoreTransport             (0x20);

    public final int value;
}
