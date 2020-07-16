package com.harium.ferry.matrix.iterable;

import com.harium.ferry.matrix.iterator.TopRightToBottomLeftIndexIterator;

public class TopRightToBottomLeftIterable<T> extends MatrixIterable<T> {

    public TopRightToBottomLeftIterable(T[][] data) {
        super(data);
        indexIterator = new TopRightToBottomLeftIndexIterator();
        indexIterator.setWidth(data[0].length);
        indexIterator.setHeight(data.length);
        indexIterator.setX(data[0].length - 1);
    }
}
