package com.harium.ferry.matrix.iterable;

import com.harium.ferry.iterator.IndexIterator;

import java.util.Iterator;

public abstract class MatrixIterable<T> implements Iterable<T> {

    protected int width;
    protected T[][] data;
    protected IndexIterator indexIterator;

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
                int i = index % width;
                int j = index / width;
                return data[j][i];
            }
        };
    }
}
