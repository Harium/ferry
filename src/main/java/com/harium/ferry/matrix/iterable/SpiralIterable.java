package com.harium.ferry.matrix.iterable;

import com.harium.ferry.matrix.iterator.SpiralIndexIterator;

public class SpiralIterable<T> extends MatrixIterable<T> {

    public SpiralIterable(T[][] data) {
        super(data);
        indexIterator = new SpiralIndexIterator();
        width = data[0].length;
        int height = data.length;
        ((SpiralIndexIterator) indexIterator).setWidth(width);
        ((SpiralIndexIterator) indexIterator).setHeight(height);
        ((SpiralIndexIterator) indexIterator).setX(width / 2);
        ((SpiralIndexIterator) indexIterator).setY(height / 2);
    }
}
