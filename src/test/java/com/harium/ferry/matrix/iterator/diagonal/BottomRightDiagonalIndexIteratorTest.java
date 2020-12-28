package com.harium.ferry.matrix.iterator.diagonal;

import org.junit.Before;
import org.junit.Test;

import static com.harium.ferry.TestUtils.assertIndex;
import static com.harium.ferry.TestUtils.next;
import static org.junit.Assert.assertTrue;

public class BottomRightDiagonalIndexIteratorTest {

    private DiagonalIndexIterator iterator;

    @Before
    public void setUp() {
        iterator = new BottomRightDiagonalIndexIterator();
    }

    @Test
    public void testHappyPath() {
        iterator.setStartX(9);
        iterator.setStartY(9);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());

        assertIndex(9, 9, next(iterator));
        assertIndex(9, 8, next(iterator));
        assertIndex(8, 9, next(iterator));
        assertIndex(9, 7, next(iterator));
        assertIndex(8, 8, next(iterator));
        assertIndex(7, 9, next(iterator));
    }

    @Test
    public void testStep() {
        iterator.setStartX(9);
        iterator.setStartY(9);
        iterator.setWidth(10);
        iterator.setHeight(10);
        iterator.setStep(3);

        assertTrue(iterator.hasNext());

        assertIndex(9, 9, next(iterator));
        assertIndex(9, 6, next(iterator));
        assertIndex(6, 9, next(iterator));
        assertIndex(9, 3, next(iterator));
        assertIndex(6, 6, next(iterator));
        assertIndex(3, 9, next(iterator));
    }

    @Test
    public void testBorder() {
        iterator.setStartX(9);
        iterator.setStartY(9);
        iterator.setWidth(10);
        iterator.setHeight(10);
        iterator.setBorder(1);

        assertTrue(iterator.hasNext());

        assertIndex(8, 8, next(iterator));
        assertIndex(8, 7, next(iterator));
        assertIndex(7, 8, next(iterator));
        assertIndex(8, 6, next(iterator));
        assertIndex(7, 7, next(iterator));
        assertIndex(6, 8, next(iterator));
    }

}
