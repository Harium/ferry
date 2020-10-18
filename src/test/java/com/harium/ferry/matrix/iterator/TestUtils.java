package com.harium.ferry.matrix.iterator;

public class TestUtils {

    public static int[] next(MatrixIndexIterator iterator) {
        int index = iterator.next();
        int i = index % iterator.getWidth();
        int j = index / iterator.getWidth();
        return new int[] {i, j};
    }

}
