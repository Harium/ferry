package com.harium.ferry.matrix.iterator.diagonal;

import org.junit.Before;
import org.junit.Test;

import static com.harium.ferry.TestUtils.assertIndex;
import static com.harium.ferry.TestUtils.next;
import static org.junit.Assert.assertTrue;

public class TopLeftDiagonalIndexIteratorTest {

    private DiagonalIndexIterator iterator;

    @Before
    public void setUp() {
        iterator = new TopLeftDiagonalIndexIterator();
    }

    @Test
    public void testHappyPath() {
        iterator.setStartX(0);
        iterator.setStartY(0);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());

        assertIndex(0, 0, next(iterator));
        assertIndex(0, 1, next(iterator));
        assertIndex(1, 0, next(iterator));
        assertIndex(0, 2, next(iterator));
        assertIndex(1, 1, next(iterator));
        assertIndex(2, 0, next(iterator));
    }

    @Test
    public void testStep() {
        iterator.setStartX(0);
        iterator.setStartY(0);
        iterator.setWidth(10);
        iterator.setHeight(10);
        iterator.setStep(3);

        assertTrue(iterator.hasNext());

        assertIndex(0, 0, next(iterator));
        assertIndex(0, 3, next(iterator));
        assertIndex(3, 0, next(iterator));
        assertIndex(0, 6, next(iterator));
        assertIndex(3, 3, next(iterator));
        assertIndex(6, 0, next(iterator));
    }

    @Test
    public void testBorder() {
        iterator.setStartX(0);
        iterator.setStartY(0);
        iterator.setWidth(10);
        iterator.setHeight(10);
        iterator.setBorder(1);

        assertTrue(iterator.hasNext());

        assertIndex(1, 1, next(iterator));
        assertIndex(1, 2, next(iterator));
        assertIndex(2, 1, next(iterator));
        assertIndex(1, 3, next(iterator));
        assertIndex(2, 2, next(iterator));
        assertIndex(3, 1, next(iterator));
    }

}
