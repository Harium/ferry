package com.harium.ferry.iterator;

public class BackAndForthIterator extends ForwardIterator {

    private static final boolean RIGHT = false;
    private boolean direction = RIGHT;
    private boolean hitRight = false;
    private boolean hitLeft = false;

    @Override
    public void reset() {
        cursor = start;
        prev = cursor;
        firstRun = true;
        hitLeft = false;
        hitRight = false;

        direction = RIGHT;
    }

    @Override
    public boolean hasNext() {
        if (firstRun) {
            return true;
        }

        if (hitRight && cursor < 0) {
            return false;
        }
        if (hitLeft && cursor >= length) {
            return false;
        }

        return !hitLeft || !hitRight;
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
            direction = !direction;

            if (prev < 0) {
                hitLeft = true;
                if (!hitRight) {
                    prev = next();
                }
            }
        } else {
            diff = start - cursor;
            cursor = start + diff;

            direction = !direction;

            if (prev > length - 1) {
                hitRight = true;
                if (!hitLeft) {
                    prev = next();
                }
            }
        }

        if (!hitLeft && prev == 0) {
            hitLeft = true;
        }

        if (!hitRight && prev == length-step) {
            hitRight = true;
        }

        return prev;
    }
    
}
