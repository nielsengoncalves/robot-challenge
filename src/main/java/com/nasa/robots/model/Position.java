package com.nasa.robots.model;

import com.nasa.robots.enums.Orientation;

public class Position {

    private Coordinate coordinate;

    private Orientation orientation;

    public Position(Coordinate coordinate, Orientation orientation) {
        this.coordinate = coordinate;
        this.orientation = orientation;
    }

    public String getFormattedPosition() {
        return "(" + coordinate.getX() + ", " + coordinate.getY() + ", " + orientation.toString() + ")";
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
}
