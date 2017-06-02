package com.nasa.robots.model;

import com.nasa.robots.enums.Orientation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    Position position;

    @Before
    public void setUp() {
        position = new Position(new Coordinate(10, 10), Orientation.NORTH);
    }

    @Test
    public void shouldGetFormattedPosition() throws Exception {
        assertEquals("(10, 10, N)", position.getFormattedPosition());
    }

    @Test
    public void shouldSetCoordinate() throws Exception {
        assertEquals("(10, 10, N)", position.getFormattedPosition());
        position.setCoordinate(new Coordinate(10, 12));
        assertEquals("(10, 12, N)", position.getFormattedPosition());
    }

    @Test
    public void shouldSetOrientation() throws Exception {
        assertEquals("(10, 10, N)", position.getFormattedPosition());
        position.setOrientation(Orientation.SOUTH);
        assertEquals("(10, 10, S)", position.getFormattedPosition());
    }

}