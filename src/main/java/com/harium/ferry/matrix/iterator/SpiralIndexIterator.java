package com.harium.ferry.matrix.iterator;

public class SpiralIndexIterator extends MatrixIndexIterator {

    static final short DIRECTION_UP = 0;
    static final short DIRECTION_RIGHT = 1;
    static final short DIRECTION_DOWN = 2;
    static final short DIRECTION_LEFT = 3;

    short dir = DIRECTION_RIGHT;
    // Horizontal
    boolean orientationHorizontal = true;

    private int targetX;
    private int targetY;
    private int size = 0;
    private int dx = step;
    private int dy = 0;

    public SpiralIndexIterator() {
        this.currentX = x - dx;
        this.currentY = y;
    }

    public SpiralIndexIterator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void reset() {
        this.currentX = x - step;
        this.currentY = y;
        this.dx = step;
        this.dy = 0;

        this.targetX = x;
        this.targetY = y;
        this.dir = DIRECTION_UP;
    }

    @Override
    public boolean hasNext() {
        return ((currentY + dy >= border) && (currentY + dy < height - border) &&
                (currentX + dx >= border) && (currentX + dx < width - border));
    }

    @Override
    public Integer next() {
        if (currentX != targetX || currentY != targetY) {
            currentX += dx;
            currentY += dy;
        }
        if (currentX == targetX && currentY == targetY) {
            if (dir == DIRECTION_RIGHT) {
                turnDown();
            } else if (dir == DIRECTION_DOWN) {
                turnLeft();
            } else if (dir == DIRECTION_LEFT) {
                turnUp();
            } else if (dir == DIRECTION_UP) {
                turnRight();
            }
        }

        return currentY * width + currentX;
    }

    private void turnRight() {
        dir = DIRECTION_RIGHT;
        if (orientationHorizontal) {
            size++;
        }

        dx = step;
        dy = 0;
        targetX = currentX + size * step;
    }

    private void turnLeft() {
        dir = DIRECTION_LEFT;
        if (orientationHorizontal) {
            size++;
        }
        dx = -step;
        dy = 0;
        targetX = currentX - size * step;
    }

    private void turnDown() {
        dir = DIRECTION_DOWN;
        if (!orientationHorizontal) {
            size++;
        }
        dx = 0;
        dy = step;
        targetY = currentY + size * step;
    }

    private void turnUp() {
        dir = DIRECTION_UP;
        if (!orientationHorizontal) {
            size++;
        }
        dx = 0;
        dy = -step;
        targetY = currentY - size * step;
    }

}
