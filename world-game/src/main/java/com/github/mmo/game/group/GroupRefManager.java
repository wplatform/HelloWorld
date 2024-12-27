package com.github.mmo.game.group;


public class GroupRefManager extends RefManager<PlayerGroup, player> {

    public final GroupReference getFirst() {
        return (GroupReference) super.getFirst();
    }
}
