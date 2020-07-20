package com.harium.ferry.matrix.iterator;

public abstract class MatrixIndexIterator implements IndexIterator {

    protected int x = 0;
    protected int y = 0;
    protected int step = 1;
    protected int border = 0;
    protected int width = 0;
    protected int height = 0;
    protected int currentX;
    protected int currentY;

    public MatrixIndexIterator() {
        super();
        currentX = x - step;
        currentY = y;
    }

    public void reset() {
        this.currentX = x - step;
        this.currentY = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        reset();
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
        // Force update x, y
        if (x < border) {
            x = border;
        }
        if (y < border) {
            y = border;
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
