package com.github.azeroth.game.entity.player;


public class PlayerSpell {
    public PlayerSpellstate state = PlayerSpellState.values()[0];
    public boolean active;
    public boolean dependent;
    public boolean disabled;
    public boolean favorite;
    public Integer traitDefinitionId = null;
}
