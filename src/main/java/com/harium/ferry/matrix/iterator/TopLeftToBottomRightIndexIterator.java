package com.harium.ferry.matrix.iterator;

public class TopLeftToBottomRightIndexIterator extends MatrixIndexIterator {

    public TopLeftToBottomRightIndexIterator() {
        currentX = x - step;
        currentY = y;
    }

    public TopLeftToBottomRightIndexIterator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean hasNext() {
        return (currentY + step < height - border) ||
                (currentX + step < width - border);
    }

    @Override
    public Integer next() {
        currentX += step;

        if (currentX >= width - border) {
            // Next Line
            currentX = border;
            currentY += step;
        }

        return currentY * width + currentX;
    }

}
