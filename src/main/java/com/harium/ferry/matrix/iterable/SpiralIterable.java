package com.harium.ferry.matrix.iterable;

import com.harium.ferry.matrix.iterator.SpiralIndexIterator;

public class SpiralIterable<T> extends MatrixIterable<T> {

    public SpiralIterable(T[][] data) {
        super(data);
        indexIterator = new SpiralIndexIterator();
        indexIterator.setWidth(data[0].length);
        indexIterator.setHeight(data.length);
        indexIterator.setX(indexIterator.getWidth() / 2);
        indexIterator.setY(indexIterator.getHeight() / 2);
    }
}
