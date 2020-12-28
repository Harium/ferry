package com.harium.ferry;

import com.harium.ferry.matrix.iterator.MatrixIndexIterator;

import static org.junit.Assert.assertEquals;

public class TestUtils {

    public static int[] next(MatrixIndexIterator iterator) {
        int index = iterator.next();
        int i = index % iterator.getWidth();
        int j = index / iterator.getWidth();
        return new int[] {i, j};
    }

    public static void assertIndex(int x, int y, int[] next) {
        assertEquals(x, next[0]);
        assertEquals(y, next[1]);
    }

}
