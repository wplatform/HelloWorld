package com.github.azeroth.game.domain.player;

import com.github.azeroth.defines.PlayerClassMask;
import com.github.azeroth.defines.RaceMask;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerCreateInfoSpell {

    public long raceMask;
    public int classMask;
    public int spell;

    public RaceMask raceMask() {
        return RaceMask.of(raceMask);
    }

    public PlayerClassMask classMask() {
        return PlayerClassMask.of(classMask);
    }
}
