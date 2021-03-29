package com.rainbowland.core.utils;

import java.util.NoSuchElementException;

/**
 * Base iterator for {@link IntArray}
 * <p>
 * example use
 * <p>
 * IntBag ids;
 * ....
 * final IntBagIterator it = new IntBagIterator(ids);
 * while (it.hasNext())
 * doSomething(it.next());
 * <p>
 * or
 * <p>
 * for (final IntBagIterator it = new IntBagIterator(ids); it.hasNext();)
 * doSomething(it.next());
 *
 * @author nicolaichuk
 */
public class IntBagIterator {

    protected static enum State {
        INIT,
        NEXT_CALLED,
        REMOVE_CALLED,
    }

    protected final IntArray intArray;
    protected int index;
    protected int indexEnd;
    protected State state;

    /**
     * Create iterator for IntBag
     *
     * @return true if the iteration has more elements
     */
    public IntBagIterator(final IntArray intArray) {
        this.intArray = intArray;
        index = -1;
        indexEnd = intArray != null ? intArray.size() : 0;
        assert indexEnd >= 0;
        state = State.INIT;
    }

    /**
     * Create iterator for IntBag
     *
     * @return true if the iteration has more elements
     */
    public IntBagIterator(final IntArray intArray, final int indexBegin) {
        this.intArray = intArray;
        assert indexBegin >= 0;
        this.index = indexBegin - 1;
        indexEnd = intArray != null ? intArray.size() : 0;
        assert indexEnd >= 0;
        state = State.INIT;
    }

    /**
     * Create iterator for IntBag
     *
     * @return true if the iteration has more elements
     */
    public IntBagIterator(final IntArray intArray, final int indexBegin, final int size) {
        this.intArray = intArray;
        assert indexBegin >= 0;
        this.index = indexBegin - 1;
        indexEnd = indexBegin + size;
        final int allSize = intArray.size();
        indexEnd = intArray != null ? (indexEnd < allSize ? indexEnd : allSize) : 0;
        assert indexEnd >= 0;
        state = State.INIT;
    }

    /**
     * return current index
     * This method can be called only per call to next().
     * This method can not be called after call remove().
     *
     * @throws IllegalStateException - if the next() method has not yet been called
     */
    public int getCurrentIndex() {
        if (state == State.NEXT_CALLED && index < indexEnd && indexEnd <= intArray.size()) {
            return index;
        }
        throw new IllegalStateException(getErrorMessage(index));
    }

    /**
     * Returns true if the iteration has more elements. (In other words, returns true if next() would return an element rather than throwing an exception.)
     *
     * @return true if the iteration has more elements
     */
    public boolean hasNext() {
        return index + 1 < indexEnd && indexEnd <= intArray.size();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException - if the iteration has no more elements
     */
    public int next() {
        final int newIndex = index + 1;

        if (newIndex < indexEnd && indexEnd <= intArray.size()) {
            index = newIndex;
            state = State.NEXT_CALLED;
            return intArray.getData()[index];
        }

        throw new NoSuchElementException(getErrorMessage(newIndex));
    }

    /**
     * Removes from the underlying collection the last element returned by this iterator (optional operation).
     * This method can be called only once per call to next().
     * The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method.
     *
     * @throws IllegalStateException - if the next() method has not yet been called, or the remove() method has already been called after the last call to the next() method
     */
    public void remove() {
        if (state == State.NEXT_CALLED && index < indexEnd && indexEnd <= intArray.size()) {
            state = State.REMOVE_CALLED;
            intArray.removeIndex(index);
            index--;
            indexEnd--;
            assert index < indexEnd;
        } else {
            throw new IllegalStateException(getErrorMessage(index));
        }
    }

    /**
     * generate error message
     */
    private String getErrorMessage(final int indexVal) {
        final String message = "Tried accessing element: " + indexVal + "/" + indexEnd + "/" + intArray.size() + "/" + state.name();
        return message;
    }

}
