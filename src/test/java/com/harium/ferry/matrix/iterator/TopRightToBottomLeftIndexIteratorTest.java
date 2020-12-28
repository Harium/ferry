package com.harium.ferry.matrix.iterator;

import org.junit.Before;
import org.junit.Test;

import static com.harium.ferry.TestUtils.assertIndex;
import static com.harium.ferry.TestUtils.next;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TopRightToBottomLeftIndexIteratorTest {

    private TopRightToBottomLeftIndexIterator iterator;

    @Before
    public void setUp() {
        iterator = new TopRightToBottomLeftIndexIterator();
    }

    @Test
    public void testHappyPath() {
        iterator.setStartX(9);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());

        assertIndex(9, 0, next(iterator));
        assertIndex(8, 0, next(iterator));
    }

    @Test
    public void testStartingFromMiddle() {
        iterator.setStartX(5);
        iterator.setStartY(5);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());

        assertIndex(5, 5, next(iterator));
        assertIndex(4, 5, next(iterator));
    }

    @Test
    public void testStartingFromMiddleWithStep() {
        iterator.setStartX(5);
        iterator.setStartY(5);
        iterator.setStep(3);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());
        assertIndex(5, 5, next(iterator));
        assertIndex(2, 5, next(iterator));
        assertIndex(9, 5 + iterator.getStep(), next(iterator));
    }

    @Test
    public void testBorder() {
        iterator.setBorder(2);
        iterator.setWidth(6);
        iterator.setHeight(6);
        iterator.setStartX(3);
        iterator.setStartY(2);

        assertTrue(iterator.hasNext());
        assertIndex(3, 2, next(iterator));

        assertTrue(iterator.hasNext());
        assertIndex(2, 2, next(iterator));

        assertTrue(iterator.hasNext());
        assertIndex(3, 3, next(iterator));

        assertTrue(iterator.hasNext());
        assertIndex(2, 3, next(iterator));

        assertFalse(iterator.hasNext());
    }

}
