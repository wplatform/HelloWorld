package com.github.mmo.game.battleground;


public class BattlegroundPlayer {
    public long offlineRemoveTime; // for tracking and removing offline players from queue after 5 time.Minutes
    public teamFaction team = TeamFaction.values()[0]; // Player's team
    public int activeSpec; // Player's active spec
    public boolean mercenary;
}
