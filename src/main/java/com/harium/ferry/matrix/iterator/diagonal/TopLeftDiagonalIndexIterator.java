package com.harium.ferry.matrix.iterator.diagonal;

public class TopLeftDiagonalIndexIterator extends DiagonalIndexIterator {

    public TopLeftDiagonalIndexIterator() {
        super();
    }

    public TopLeftDiagonalIndexIterator(int width, int height) {
        super(width, height);
    }

    @Override
    public boolean hasNext() {
        return (i == 0) || currentX + step < width - border && currentY + step <= height - border;
    }

    protected void increment() {
        currentX = startX + xInc;
        currentY = startY + yInc;
        yInc -= step;
        xInc += step;
    }
}
