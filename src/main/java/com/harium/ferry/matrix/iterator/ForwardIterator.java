package com.harium.ferry.matrix.iterator;

public class ForwardIterator implements IndexIterator {

    private int prev;
    private int start = 0;
    private int cursor = 0;
    private int step = 1;
    private int length = 1;
    private boolean firstRun = true;

    public ForwardIterator() {
        super();
    }

    public ForwardIterator(int length) {
        this.length = length;
    }

    public void reset() {
        cursor = start;
        prev = cursor;
        firstRun = true;
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

        if (prev >= start) {
            return true;
        } else {
            return next < start /* || (next < cursor)*/;
        }
    }

    @Override
    public Integer next() {
        if (firstRun) {
            firstRun = false;
        }

        prev = cursor;
        cursor += step;
        cursor %= length;

        return prev;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
        reset();
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
        reset();
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
        reset();
    }
}
