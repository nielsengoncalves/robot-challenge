package com.nasa.robots.model;

public class Surface {

    private Integer sizeX;

    private Integer sizeY;

    public Surface(Integer sizeX, Integer sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public Surface(Integer size) {
        this.sizeX = size;
        this.sizeY = size;
    }

    public Integer getSizeX() {
        return sizeX;
    }

    public Integer getSizeY() {
        return sizeY;
    }
}
