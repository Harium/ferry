package com.harium.ferry.matrix.iterator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SpiralIndexIteratorTest {

    private SpiralIndexIterator iterator;

    @Before
    public void setUp() {
        iterator = new SpiralIndexIterator();
    }

    @Test
    public void testHappyPath() {
        iterator.setX(0);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());
        int[] next = iterator.next();
        assertEquals(0, next[0]);
        assertEquals(0, next[1]);

        next = iterator.next();
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
        int[] next = iterator.next();
        assertEquals(5, next[0]);
        assertEquals(5, next[1]);

        assertEquals(SpiralIndexIterator.DIRECTION_RIGHT, iterator.dir);
        next = iterator.next();
        assertEquals(6, next[0]);
        assertEquals(5, next[1]);

        assertEquals(SpiralIndexIterator.DIRECTION_DOWN, iterator.dir);
        next = iterator.next();
        assertEquals(6, next[0]);
        assertEquals(6, next[1]);

        assertEquals(SpiralIndexIterator.DIRECTION_LEFT, iterator.dir);
        next = iterator.next();
        assertEquals(5, next[0]);
        assertEquals(6, next[1]);

        next = iterator.next();
        assertEquals(4, next[0]);
        assertEquals(6, next[1]);

        assertEquals(SpiralIndexIterator.DIRECTION_UP, iterator.dir);
        next = iterator.next();
        assertEquals(4, next[0]);
        assertEquals(5, next[1]);

        next = iterator.next();
        assertEquals(4, next[0]);
        assertEquals(4, next[1]);

        assertEquals(SpiralIndexIterator.DIRECTION_RIGHT, iterator.dir);
        next = iterator.next();
        assertEquals(5, next[0]);
        assertEquals(4, next[1]);

        next = iterator.next();
        assertEquals(6, next[0]);
        assertEquals(4, next[1]);

        next = iterator.next();
        assertEquals(7, next[0]);
        assertEquals(4, next[1]);
    }

    @Test
    public void testStartingFromMiddleWithStep() {
        iterator.setX(5);
        iterator.setY(5);
        iterator.setStep(2);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());
        int[] next = iterator.next();
        assertEquals(5, next[0]);
        assertEquals(5, next[1]);

        next = iterator.next();
        assertEquals(7, next[0]);
        assertEquals(5, next[1]);

        next = iterator.next();
        assertEquals(7, next[0]);
        assertEquals(7, next[1]);

        next = iterator.next();
        assertEquals(5, next[0]);
        assertEquals(7, next[1]);

        next = iterator.next();
        assertEquals(3, next[0]);
        assertEquals(7, next[1]);
    }

    @Test
    public void testBorder() {
        iterator.setBorder(2);
        iterator.setWidth(7);
        iterator.setHeight(7);
        iterator.setX(3);
        iterator.setY(2);

        assertTrue(iterator.hasNext());
        int[] next = iterator.next();
        assertEquals(3, next[0]);
        assertEquals(2, next[1]);

        assertTrue(iterator.hasNext());
        next = iterator.next();
        assertEquals(4, next[0]);
        assertEquals(2, next[1]);

        assertTrue(iterator.hasNext());
        next = iterator.next();
        assertEquals(4, next[0]);
        assertEquals(3, next[1]);

        assertTrue(iterator.hasNext());
        next = iterator.next();
        assertEquals(3, next[0]);
        assertEquals(3, next[1]);

        assertTrue(iterator.hasNext());
        next = iterator.next();
        assertEquals(2, next[0]);
        assertEquals(3, next[1]);

        assertTrue(iterator.hasNext());
        next = iterator.next();
        assertEquals(2, next[0]);
        assertEquals(2, next[1]);

        assertFalse(iterator.hasNext());
    }

}
