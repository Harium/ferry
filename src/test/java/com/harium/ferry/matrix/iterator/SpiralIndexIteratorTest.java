package com.harium.ferry.matrix.iterator;

import org.junit.Before;
import org.junit.Test;

import static com.harium.ferry.TestUtils.assertIndex;
import static com.harium.ferry.TestUtils.next;
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
        iterator.setStartX(0);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());

        assertIndex(0, 0, next(iterator));
        assertIndex(1, 0, next(iterator));
    }

    @Test
    public void testStartingFromMiddle() {
        iterator.setStartX(5);
        iterator.setStartY(5);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());
        int[] next = next(iterator);
        assertEquals(5, next[0]);
        assertEquals(5, next[1]);

        assertEquals(SpiralIndexIterator.DIRECTION_RIGHT, iterator.dir);
        next = next(iterator);
        assertEquals(6, next[0]);
        assertEquals(5, next[1]);

        assertEquals(SpiralIndexIterator.DIRECTION_DOWN, iterator.dir);
        next = next(iterator);
        assertEquals(6, next[0]);
        assertEquals(6, next[1]);

        assertEquals(SpiralIndexIterator.DIRECTION_LEFT, iterator.dir);
        next = next(iterator);
        assertEquals(5, next[0]);
        assertEquals(6, next[1]);

        next = next(iterator);
        assertEquals(4, next[0]);
        assertEquals(6, next[1]);

        assertEquals(SpiralIndexIterator.DIRECTION_UP, iterator.dir);
        next = next(iterator);
        assertEquals(4, next[0]);
        assertEquals(5, next[1]);

        next = next(iterator);
        assertEquals(4, next[0]);
        assertEquals(4, next[1]);

        assertEquals(SpiralIndexIterator.DIRECTION_RIGHT, iterator.dir);
        next = next(iterator);
        assertEquals(5, next[0]);
        assertEquals(4, next[1]);

        next = next(iterator);
        assertEquals(6, next[0]);
        assertEquals(4, next[1]);

        next = next(iterator);
        assertEquals(7, next[0]);
        assertEquals(4, next[1]);
    }

    @Test
    public void testStartingFromMiddleWithStep() {
        iterator.setStartX(5);
        iterator.setStartY(5);
        iterator.setStep(2);
        iterator.setWidth(10);
        iterator.setHeight(10);

        assertTrue(iterator.hasNext());
        int[] next = next(iterator);
        assertEquals(5, next[0]);
        assertEquals(5, next[1]);

        next = next(iterator);
        assertEquals(7, next[0]);
        assertEquals(5, next[1]);

        next = next(iterator);
        assertEquals(7, next[0]);
        assertEquals(7, next[1]);

        next = next(iterator);
        assertEquals(5, next[0]);
        assertEquals(7, next[1]);

        next = next(iterator);
        assertEquals(3, next[0]);
        assertEquals(7, next[1]);
    }

    @Test
    public void testBorder() {
        iterator.setBorder(2);
        iterator.setWidth(7);
        iterator.setHeight(7);
        iterator.setStartX(3);
        iterator.setStartY(2);

        assertTrue(iterator.hasNext());
        int[] next = next(iterator);
        assertEquals(3, next[0]);
        assertEquals(2, next[1]);

        assertTrue(iterator.hasNext());
        next = next(iterator);
        assertEquals(4, next[0]);
        assertEquals(2, next[1]);

        assertTrue(iterator.hasNext());
        next = next(iterator);
        assertEquals(4, next[0]);
        assertEquals(3, next[1]);

        assertTrue(iterator.hasNext());
        next = next(iterator);
        assertEquals(3, next[0]);
        assertEquals(3, next[1]);

        assertTrue(iterator.hasNext());
        next = next(iterator);
        assertEquals(2, next[0]);
        assertEquals(3, next[1]);

        assertTrue(iterator.hasNext());
        next = next(iterator);
        assertEquals(2, next[0]);
        assertEquals(2, next[1]);

        assertFalse(iterator.hasNext());
    }

}
