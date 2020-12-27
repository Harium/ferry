package com.harium.ferry.matrix.iterator;

public class TopRightToBottomLeftIndexIterator extends MatrixIndexIterator {

    public TopRightToBottomLeftIndexIterator() {
        super();
        currentX = startX + step;
        currentY = startY;
    }

    public TopRightToBottomLeftIndexIterator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void reset() {
        this.currentX = startX + step;
        this.currentY = startY;
    }

    @Override
    public boolean hasNext() {
        return (currentY + step < height - border) ||
                (currentX - step >= border);
    }

    @Override
    public Integer next() {
        currentX -= step;

        if (currentX < border) {
            // Next Line
            currentX = width - 1 - border;
            currentY += step;
        }

        return currentY * width + currentX;
    }

}
