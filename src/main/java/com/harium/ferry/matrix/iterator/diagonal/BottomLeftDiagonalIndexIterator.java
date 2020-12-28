package com.harium.ferry.matrix.iterator.diagonal;

public class BottomLeftDiagonalIndexIterator extends DiagonalIndexIterator {

    public BottomLeftDiagonalIndexIterator() {
        super();
    }

    public BottomLeftDiagonalIndexIterator(int width, int height) {
        super(width, height);
    }

    @Override
    public boolean hasNext() {
        return (i == 0) || currentX + step < width - border && currentY - step > border;
    }

    @Override
    protected void increment() {
        currentX = startX + xInc;
        currentY = startY - yInc;
        yInc -= step;
        xInc += step;
    }

}
