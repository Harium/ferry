package com.harium.ferry.matrix.iterable;

import com.harium.ferry.matrix.iterator.ForwardIterator;

import java.util.Iterator;

public class TopRightToBottomLeftIterable<T> extends MatrixIterable<T> {

    public TopRightToBottomLeftIterable(T[][] data) {
        super(data);
        width = data[0].length;
        int size = width * data.length;
        indexIterator = new ForwardIterator(size);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return indexIterator.hasNext();
            }

            @Override
            public T next() {
                int index = indexIterator.next();
                int i = width - 1 - (index % width);
                int j = index / width;
                return data[j][i];
            }
        };
    }
}
