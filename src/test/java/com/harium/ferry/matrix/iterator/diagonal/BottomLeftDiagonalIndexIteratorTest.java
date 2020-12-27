package com.harium.ferry.matrix.iterator.diagonal;

import org.junit.Before;
import org.junit.Test;

import static com.harium.ferry.TestUtils.assertIndex;
import static com.harium.ferry.TestUtils.next;
import static org.junit.Assert.assertTrue;

public class BottomLeftDiagonalIndexIteratorTest {

    private DiagonalIndexIterator iterator;

    @Before
    public void setUp() {
        iterator = new BottomLeftDiagonalIndexIterator();
    }

    @Test
    public void testHappyPath() {
        iterator.setStartX(0);
        iterator.setStartY(9);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());

        assertIndex(0, 9, next(iterator));
        assertIndex(0, 8, next(iterator));
        assertIndex(1, 9, next(iterator));
        assertIndex(0, 7, next(iterator));
        assertIndex(1, 8, next(iterator));
        assertIndex(2, 9, next(iterator));
    }

    @Test
    public void testStep() {
        iterator.setStartX(0);
        iterator.setStartY(9);
        iterator.setWidth(10);
        iterator.setHeight(10);
        iterator.setStep(3);

        assertTrue(iterator.hasNext());

        assertIndex(0, 9, next(iterator));
        assertIndex(0, 6, next(iterator));
        assertIndex(3, 9, next(iterator));
        assertIndex(0, 3, next(iterator));
        assertIndex(3, 6, next(iterator));
        assertIndex(6, 9, next(iterator));
    }

    @Test
    public void testBorder() {
        iterator.setStartX(0);
        iterator.setStartY(9);
        iterator.setWidth(10);
        iterator.setHeight(10);
        iterator.setBorder(1);

        assertTrue(iterator.hasNext());

        assertIndex(1, 8, next(iterator));
        assertIndex(1, 7, next(iterator));
        assertIndex(2, 8, next(iterator));
        assertIndex(1, 6, next(iterator));
        assertIndex(2, 7, next(iterator));
        assertIndex(3, 8, next(iterator));
    }

}
