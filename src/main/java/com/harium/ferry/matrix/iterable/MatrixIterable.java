package com.harium.ferry.matrix.iterable;

import com.harium.ferry.matrix.iterator.MatrixIndexIterator;

import java.util.Iterator;

public abstract class MatrixIterable<T> implements Iterable<T> {

    private T[][] data;
    protected MatrixIndexIterator indexIterator;

    public MatrixIterable(T[][] data) {
        this.data = data;
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
                int i = index % indexIterator.getWidth();
                int j = index / indexIterator.getWidth();
                return data[j][i];
            }
        };
    }
}
