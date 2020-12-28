package com.harium.ferry.matrix.iterator.diagonal;

public class TopRightDiagonalIndexIterator extends DiagonalIndexIterator {

    public TopRightDiagonalIndexIterator() {
        super();
    }

    public TopRightDiagonalIndexIterator(int width, int height) {
        super(width, height);
    }

    @Override
    public boolean hasNext() {
        return (i == 0) || currentX - step > border && currentY + step <= height - border;
    }

    @Override
    protected void increment() {
        currentX = startX - xInc;
        currentY = startY + yInc;
        yInc -= step;
        xInc += step;
    }

}
