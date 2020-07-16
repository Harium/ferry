package com.harium.ferry.matrix.iterable;

import com.harium.ferry.matrix.iterator.TopLeftToBottomRightIndexIterator;

public class TopLeftToBottomRightIterable<T> extends MatrixIterable<T> {

    public TopLeftToBottomRightIterable(T[][] data) {
        super(data);
        indexIterator = new TopLeftToBottomRightIndexIterator();
        indexIterator.setWidth(data[0].length);
        indexIterator.setHeight(data.length);
    }
}
