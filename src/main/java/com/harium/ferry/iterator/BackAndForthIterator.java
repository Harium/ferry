package com.harium.ferry.iterator;

public class BackAndForthIterator extends ForwardIterator {

    private static final boolean RIGHT = false;
    private boolean direction = RIGHT;

    @Override
    public void reset() {
        cursor = start;
        prev = cursor;
        firstRun = true;

        direction = RIGHT;
    }

    @Override
    public boolean hasNext() {
        if (firstRun) {
            return true;
        }

        int next = cursor;

        // Can be optimized (for sure)
        // Happy Path
        // cursor < start && next > start
        // Modulus
        // cursor < start && next < cursor
        if (next == start) {
            return false;
        }

        if (direction == RIGHT) {
            return prev >= start;
        } else {
            return prev <= start;
        }
    }

    @Override
    public Integer next() {
        if (firstRun) {
            firstRun = false;
        }

        prev = cursor;
        int diff;
        if (direction == RIGHT) {
            diff = cursor - start;
            cursor = start - diff;
            cursor += step;
        } else {
            diff = start - cursor;
            cursor = start + diff;
            cursor += length;
        }

        cursor %= length;
        direction = !direction;
        return prev;
    }
    
}
