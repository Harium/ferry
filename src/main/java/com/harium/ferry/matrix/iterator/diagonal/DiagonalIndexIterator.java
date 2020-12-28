package com.harium.ferry.matrix.iterator.diagonal;

import com.harium.ferry.iterator.IndexIterator;
import com.harium.ferry.matrix.iterator.MatrixIndexIterator;

public abstract class DiagonalIndexIterator extends MatrixIndexIterator implements IndexIterator {

    protected int i = 0;
    protected int xInc = 0;
    protected int yInc = 0;

    public DiagonalIndexIterator() {
        super();
    }

    public DiagonalIndexIterator(int width, int height) {
        super(width, height);
    }

    public void reset() {
        this.currentX = startX;
        this.currentY = startY;
    }

    @Override
    public Integer next() {
        // First Run
        if (i == 0) {
            i += step;
            xInc = 0;
            yInc = i;
            return currentY * width + currentX;
        } else if (yInc < 0) {
            i += step;
            xInc = 0;
            yInc = i;
        }

        increment();

        return currentY * width + currentX;
    }

    protected abstract void increment();

}
