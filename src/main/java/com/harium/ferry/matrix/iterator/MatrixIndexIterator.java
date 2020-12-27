package com.harium.ferry.matrix.iterator;

import com.harium.ferry.iterator.IndexIterator;

public abstract class MatrixIndexIterator implements IndexIterator {

    protected int startX = 0;
    protected int startY = 0;
    protected int step = 1;
    protected int border = 0;
    protected int width = 0;
    protected int height = 0;
    protected int currentX;
    protected int currentY;

    public MatrixIndexIterator() {
        super();
        reset();
    }

    public MatrixIndexIterator(int width, int height) {
        this();
        this.width = width;
        this.height = height;
    }

    public void reset() {
        this.currentX = startX - step;
        this.currentY = startY;
    }

    public int getStartX() {
        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
        reset();
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
        reset();
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
        reset();
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;

        final int minX = border;
        final int maxX = width - 1 - border;
        final int minY = border;
        final int maxY = height - 1 - border;

        // Force update x, y
        if (startX < minX) {
            startX = minX;
        } else if (startX > maxX) {
            startX = maxX;
        }
        if (startY < minY) {
            startY = minY;
        } else if (startY > maxY) {
            startY = maxY;
        }
        reset();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        reset();
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        reset();
    }
}
