package com.harium.ferry.iterator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BackAndForthIteratorTest {

    private BackAndForthIterator iterator;

    @Before
    public void setUp() {
        iterator = new BackAndForthIterator();
    }

    @Test
    public void testHappyPath() {
        iterator.setLength(2);

        assertTrue(iterator.hasNext());
        int next = iterator.next();
        assertEquals(0, next);

        next = iterator.next();
        assertEquals(1, next);
    }

    @Test
    public void testStartingFromMiddle() {
        iterator.setLength(3);
        iterator.setStart(1);

        assertTrue(iterator.hasNext());
        int next = iterator.next();
        assertEquals(1, next);

        next = iterator.next();
        assertEquals(2, next);
    }

    @Test
    public void testBackToStart() {
        iterator.setLength(2);
        iterator.setStart(1);
        iterator.setStep(1);

        assertTrue(iterator.hasNext());
        int next = iterator.next();
        assertEquals(1, next);

        // Back to Start
        next = iterator.next();
        assertEquals(0, next);
    }

    @Test
    public void testBackToStartWithStep() {
        iterator.setLength(5);
        iterator.setStep(2);
        iterator.setStart(2);

        assertTrue(iterator.hasNext());
        int next = iterator.next();
        assertEquals(2, next);

        assertTrue(iterator.hasNext());
        next = iterator.next();
        assertEquals(4, next);

        // Back to Start
        assertTrue(iterator.hasNext());
        next = iterator.next();
        assertEquals(0, next);

        // Should it be circular?
        //assertFalse(iterator.hasNext());
    }

}
