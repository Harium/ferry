package com.harium.ferry.iterator;

/**
 * Infinity iterator that goes to 0 when reaches the final element
 */
public class CircularIterator extends ForwardIterator {

    public CircularIterator(int length) {
        super(length);
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
