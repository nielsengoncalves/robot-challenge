package com.nasa.robots.model;

public class Surface {

    private Integer sizeX;

    private Integer sizeY;

    public Surface(Integer sizeX, Integer sizeY) {
        if (hasInvalidSize(sizeX, sizeY)) {
            throw new InvalidSurfaceSizeException();
        }

        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    private boolean hasInvalidSize(Integer sizeX, Integer sizeY) {
        return sizeX <= 0 || sizeY <= 0;
    }

    public Integer getSizeX() {
        return sizeX;
    }

    public Integer getSizeY() {
        return sizeY;
    }

    public class InvalidSurfaceSizeException extends RuntimeException {}
}
