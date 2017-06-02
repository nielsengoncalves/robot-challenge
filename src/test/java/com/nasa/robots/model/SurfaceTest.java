package com.nasa.robots.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SurfaceTest {

    private Surface surface = new Surface(10, 11);

    @Test(expected = Surface.InvalidSurfaceSizeException.class)
    public void shouldNotCreateSurfaceWithNoSizeX() {
        new Surface(0, 11);
    }

    @Test(expected = Surface.InvalidSurfaceSizeException.class)
    public void shouldNotCreateSurfaceWithNoSizeY() {
        new Surface(11, 0);
    }

    @Test
    public void shouldGetSizeX() {
        assertTrue(11 == surface.getSizeX());
    }

    @Test
    public void shouldGetSizeY() {
        assertTrue(11 == surface.getSizeY());
    }

}