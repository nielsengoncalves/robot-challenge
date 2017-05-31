package com.nasa.robots.model;

public class Coordinate {

    private Integer x;

    private Integer y;

    public Coordinate(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate incrementX(Integer increment) {
        x += increment;
        return this;
    }

    public Coordinate incrementY(Integer increment) {
        y += increment;
        return this;
    }

    public Coordinate decrementX(Integer decrement) {
        x -= decrement;
        return this;
    }

    public Coordinate decrementY(Integer decrement) {
        y -= decrement;
        return this;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
