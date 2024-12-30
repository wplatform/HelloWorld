package com.github.mmo.game.group;


public class GroupReference extends REFERENCE<PlayerGroup, player> {
    private byte iSubGroup;

    public groupReference() {
        iSubGroup = 0;
    }

    public final byte getSubGroup() {
        return iSubGroup;
    }

    public final void setSubGroup(byte value) {
        iSubGroup = value;
    }

    @Override
    public void targetObjectBuildLink() {
        getTarget().linkMember(this);
    }

    public final GroupReference next() {
        return (GroupReference) super.next();
    }

    protected void finalize() throws Throwable {
        Unlink();
    }
}
