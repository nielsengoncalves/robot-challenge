package com.nasa.robots.enums;

public enum Orientation {
    NORTH ('N'),
    SOUTH ('S'),
    WEST ('W'),
    EAST ('E');

    private char orientation;

    Orientation(char orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return Character.toString(this.orientation);
    }
}

