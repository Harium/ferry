package com.harium.ferry.matrix.iterable;

import com.harium.ferry.iterator.ForwardIterator;

public class TopLeftToBottomRightIterable<T> extends MatrixIterable<T> {

    public TopLeftToBottomRightIterable(T[][] data) {
        super(data);
        width = data[0].length;
        int size = width * data.length;
        indexIterator = new ForwardIterator(size);
    }
}
