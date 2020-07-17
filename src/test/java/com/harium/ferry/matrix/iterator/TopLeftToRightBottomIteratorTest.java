package com.harium.ferry.matrix.iterator;

import org.junit.Before;
import org.junit.Test;

import static com.harium.ferry.matrix.iterator.IteratorTestUtil.next;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TopLeftToRightBottomIteratorTest {

    private TopLeftToBottomRightIndexIterator iterator;

    @Before
    public void setUp() {
        iterator = new TopLeftToBottomRightIndexIterator();
    }

    @Test
    public void testHappyPath() {
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());
        int[] next = next(iterator);
        assertEquals(0, next[0]);
        assertEquals(0, next[1]);

        next = next(iterator);
        assertEquals(1, next[0]);
        assertEquals(0, next[1]);
    }

    @Test
    public void testStartingFromMiddle() {
        iterator.setX(5);
        iterator.setY(5);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());
        int[] next = next(iterator);
        assertEquals(5, next[0]);
        assertEquals(5, next[1]);

        next = next(iterator);
        assertEquals(6, next[0]);
        assertEquals(5, next[1]);
    }

    @Test
    public void testStartingFromMiddleWithStep() {
        iterator.setX(5);
        iterator.setY(5);
        iterator.setStep(3);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());
        int[] next = next(iterator);
        assertEquals(5, next[0]);
        assertEquals(5, next[1]);

        next = next(iterator);
        assertEquals(8, next[0]);
        assertEquals(5, next[1]);

        next = next(iterator);
        assertEquals(0, next[0]);
        assertEquals(5 + iterator.getStep(), next[1]);
    }

    @Test
    public void testBorder() {
        iterator.setBorder(2);
        iterator.setWidth(6);
        iterator.setHeight(6);

        assertTrue(iterator.hasNext());
        int[] next = next(iterator);
        assertEquals(2, next[0]);
        assertEquals(2, next[1]);

        assertTrue(iterator.hasNext());
        next = next(iterator);
        assertEquals(3, next[0]);
        assertEquals(2, next[1]);

        assertTrue(iterator.hasNext());
        next = next(iterator);
        assertEquals(2, next[0]);
        assertEquals(3, next[1]);

        assertTrue(iterator.hasNext());
        next = next(iterator);
        assertEquals(3, next[0]);
        assertEquals(3, next[1]);

        assertFalse(iterator.hasNext());
    }

}
