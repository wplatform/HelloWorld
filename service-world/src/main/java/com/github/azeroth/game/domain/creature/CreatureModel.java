package com.github.azeroth.game.domain.creature;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CreatureModel {
    public static CreatureModel DEFAULT_INVISIBLE_MODEL = new CreatureModel(11686, 1.0f, 1.0f);
    public static CreatureModel DEFAULT_VISIBLE_MODEL = new CreatureModel(17519, 1.0f, 1.0f);

    public int creatureDisplayId;
    public float displayScale;
    public float probability;

}
