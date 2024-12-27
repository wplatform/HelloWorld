package com.github.mmo.reference;

import java.util.Objects;

public abstract class Reference<M extends RefManager<M, S, R>, S, R extends Reference<M, S, R>> {


    R prev;
    M refMgr;
    S source;
    R next;


    protected abstract R self();

    // Create new link
    public void link(M toObject, S fromObject) {
        Objects.requireNonNull(fromObject);
        R thisNode = self();
        if (this.refMgr != null)
            this.refMgr.unlink(thisNode);
        if (toObject != null) {
            this.refMgr = toObject;
            this.source = fromObject;
            this.refMgr.linkFirst(thisNode);
            this.refMgr.onElementAdded(thisNode);
        }
    }

    // We don't need the reference anymore. Call comes from the refFrom object
    // Tell our refTo object, that the link is cut
    public void unlink() {
        if(refMgr != null) {
            R thisNode = self();
            refMgr.unlink(thisNode);
            refMgr.onElementRemoved(thisNode);
        }
    }

    public boolean isValid() {
        return refMgr != null;
    }


    public R next() {
        return next;
    }

    public R prev() {
         return prev;
    }

    public M refManager() {
        return this.refMgr;
    }

    public S source() {
        return this.source;
    }


    public void insertAfter(R node) {
        node.prev = self();
        node.next = next;
        next.prev = node;
        next = node;
    }


}

