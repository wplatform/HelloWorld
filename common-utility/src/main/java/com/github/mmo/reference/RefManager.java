package com.github.mmo.reference;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.*;
import java.util.function.Consumer;

public class RefManager<M extends RefManager<M, S, R>, S, R extends Reference<M, S, R>> implements Iterable<S> {


    private static final VarHandle FIRST;
    private static final VarHandle LAST;


    static {
        try {
            MethodHandles.Lookup l = MethodHandles.lookup();
            FIRST = l.findVarHandle(RefManager.class, "first", Reference.class);
            LAST = l.findVarHandle(RefManager.class, "last", Reference.class);

        } catch (ReflectiveOperationException e) {
            throw new ExceptionInInitializerError(e);
        }
    }


    private volatile R first;
    private volatile R last;
    private int size;
    private int modCount;


    /**
     * Links e as first node.
     */
    void linkFirst(R newNode) {
        final R f = first;
        newNode.next = f;
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
        modCount++;
    }

    /**
     * Links e as last node.
     */
    void linkLast(R newNode) {
        final R l = last;
        newNode.prev = l;
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
        modCount++;
    }

    /**
     * Inserts node e before non-null Node succ.
     */
    void linkBefore(R newNode, R succ) {
        // assert succ != null;
        final R pred = succ.prev;
        newNode.prev = pred;
        newNode.next = succ;
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
        modCount++;
    }

    /**
     * Unlinks non-null first node f.
     */
    void unlinkFirst(R f) {
        // assert f == first && f != null;
        final R next = f.next;
        f.refMgr = null;
        f.source = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        modCount++;
    }

    /**
     * Unlinks non-null last node l.
     */
    void unlinkLast(R l) {
        // assert l == last && l != null;
        final R prev = l.prev;
        l.refMgr = null;
        l.source = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        modCount++;
    }

    /**
     * Unlinks non-null node x.
     */
    void unlink(R x) {
        // assert x != null;
        final R next = x.next;
        final R prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.refMgr = null;
        x.source = null;
        size--;
        modCount++;
    }

    /**
     * Returns the first node in this list.
     *
     * @return the first node in this list
     * @throws NoSuchElementException if this list is empty
     */
    public R getFirst() {
        final R f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f;
    }

    /**
     * Returns the last node in this list.
     *
     * @return the last node in this list
     * @throws NoSuchElementException if this list is empty
     */
    public R getLast() {
        final R l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l;
    }


    /**
     * Removes all of the nodes from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (R x = first; x != null; ) {
            R next = x.next;
            x.refMgr = null;
            x.source = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
        modCount++;
    }

    /**
     * Returns the number of nodes in this list.
     *
     * @return the number of nodes in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this list contains no nodes.
     *
     * @return {@code true} if this list contains no nodes
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<S> iterator() {
        return new ListItr(false);
    }


    public Iterator<S> lastIterator() {
        return new ListItr(true);
    }



    // Tell our refTo (target) object that we have a link
    protected void onElementAdded(R node) {};

    // Tell our refTo (taget) object, that the link is cut
    protected void onElementRemoved(R element) {};


    private class ListItr implements Iterator<S> {
        private R lastReturned;
        private R next;
        private int nextIndex;
        private int expectedModCount = modCount;

        ListItr(boolean descending) {
            // assert isPositionIndex(index);
            next = descending ? last: first;
            nextIndex = 0;
        }
        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }
        @Override
        public S next() {
            checkForComodification();
            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.source;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public S previous() {
            checkForComodification();
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null) ? last : next.prev;
            nextIndex--;
            return lastReturned.source;
        }

        @Override
        public void remove() {
            checkForComodification();
            if (lastReturned == null)
                throw new IllegalStateException();

            R lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
            expectedModCount++;
        }

        @Override
        public void forEachRemaining(Consumer<? super S> action) {
            Objects.requireNonNull(action);
            while (modCount == expectedModCount && nextIndex < size) {
                action.accept(next.source);
                lastReturned = next;
                next = next.next;
                nextIndex++;
            }
            checkForComodification();
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    private class DescendingIterator implements Iterator<S> {
        private final ListItr itr = new ListItr(true);
        public boolean hasNext() {
            return itr.hasPrevious();
        }
        public S next() {
            return itr.previous();
        }
        public void remove() {
            itr.remove();
        }
    }


}
