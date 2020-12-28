package com.harium.ferry.matrix.iterator.diagonal;

import org.junit.Before;
import org.junit.Test;

import static com.harium.ferry.TestUtils.assertIndex;
import static com.harium.ferry.TestUtils.next;
import static org.junit.Assert.assertTrue;

public class TopRightDiagonalIndexIteratorTest {

    private DiagonalIndexIterator iterator;

    @Before
    public void setUp() {
        iterator = new TopRightDiagonalIndexIterator();
    }

    @Test
    public void testHappyPath() {
        iterator.setStartX(9);
        iterator.setStartY(0);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());

        assertIndex(9, 0, next(iterator));
        assertIndex(9, 1, next(iterator));
        assertIndex(8, 0, next(iterator));
        assertIndex(9, 2, next(iterator));
        assertIndex(8, 1, next(iterator));
        assertIndex(7, 0, next(iterator));
    }

    @Test
    public void testStep() {
        iterator.setStartX(9);
        iterator.setStartY(0);
        iterator.setWidth(10);
        iterator.setHeight(10);
        iterator.setStep(3);

        assertTrue(iterator.hasNext());

        assertIndex(9, 0, next(iterator));
        assertIndex(9, 3, next(iterator));
        assertIndex(6, 0, next(iterator));
        assertIndex(9, 6, next(iterator));
        assertIndex(6, 3, next(iterator));
        assertIndex(3, 0, next(iterator));
    }

    @Test
    public void testBorder() {
        iterator.setStartX(9);
        iterator.setStartY(0);
        iterator.setWidth(10);
        iterator.setHeight(10);
        iterator.setBorder(1);

        assertTrue(iterator.hasNext());

        assertIndex(8, 1, next(iterator));
        assertIndex(8, 2, next(iterator));
        assertIndex(7, 1, next(iterator));
        assertIndex(8, 3, next(iterator));
        assertIndex(7, 2, next(iterator));
        assertIndex(6, 1, next(iterator));
    }

}
