package com.harium.ferry.matrix.iterator.diagonal;

public class BottomRightDiagonalIndexIterator extends DiagonalIndexIterator {

    public BottomRightDiagonalIndexIterator() {
        super();
    }

    public BottomRightDiagonalIndexIterator(int width, int height) {
        super(width, height);
    }

    @Override
    public boolean hasNext() {
        return (i == 0) || currentX - step > border && currentY - step > border;
    }

    @Override
    protected void increment() {
        currentX = startX - xInc;
        currentY = startY - yInc;
        yInc -= step;
        xInc += step;
    }

}
