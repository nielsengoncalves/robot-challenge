package com.nasa.robots.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {

    Coordinate coordinate;

    @Before
    public void setUp() {
        this.coordinate = new Coordinate(5, 5);
    }

    @Test
    public void shouldIncrementXByTwo() throws Exception {
        assertTrue(5 == coordinate.getX());
        coordinate.incrementX(2);
        assertTrue(7 == coordinate.getX());
    }

    @Test
    public void shouldIncrementYByTwo() throws Exception {
        assertTrue(5 == coordinate.getY());
        coordinate.incrementY(2);
        assertTrue(7 == coordinate.getY());
    }

    @Test
    public void shouldDecrementXByTwo() throws Exception {
        assertTrue(5 == coordinate.getX());
        coordinate.decrementX(2);
        assertTrue(3 == coordinate.getX());
    }

    @Test
    public void shouldDecrementYByTwo() throws Exception {
        assertTrue(5 == coordinate.getY());
        coordinate.decrementY(2);
        assertTrue(3 == coordinate.getY());
    }
}