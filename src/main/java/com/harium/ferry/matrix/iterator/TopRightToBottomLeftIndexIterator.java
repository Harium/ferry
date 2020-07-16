package com.harium.ferry.matrix.iterator;

public class TopRightToBottomLeftIndexIterator extends MatrixIndexIterator {

    public TopRightToBottomLeftIndexIterator() {
        super();
        currentX = x + step;
        currentY = y;
    }

    public TopRightToBottomLeftIndexIterator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void reset() {
        this.currentX = x + step;
        this.currentY = y;
    }

    @Override
    public boolean hasNext() {
        return (currentY + step < height - border) ||
                (currentX - step >= border);
    }

    @Override
    public int[] next() {
        currentX -= step;

        if (currentX < border) {
            // Next Line
            currentX = width - 1 - border;
            currentY += step;
        }

        return new int[]{currentX, currentY};
    }

}
