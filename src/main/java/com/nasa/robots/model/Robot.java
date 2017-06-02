package com.nasa.robots.model;

import com.nasa.robots.enums.Movement;
import com.nasa.robots.enums.Orientation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;

public class Robot {

    private Coordinate coordinate;

    private Orientation orientation;

    private Surface surface;

    public Robot(Integer coordX, Integer coordY, Orientation orientation, Surface surface) {
        if (hasInvalidCoordinates(coordX, coordY, surface)) {
            throw new InvalidCoordinatesException();
        }

        this.coordinate = new Coordinate(coordX, coordY);
        this.orientation = orientation;
        this.surface = surface;
    }

    private boolean hasInvalidCoordinates(Integer coordX, Integer coordY, Surface surface) {
        return coordX < 0 || coordX > surface.getSizeX() || coordY < 0 || coordY > surface.getSizeY();
    }

    public void move(String movements) {
        String[] listOfMoviments = movements.split("");
        Arrays.stream(listOfMoviments).forEach((movement) -> move(movement.charAt(0)));
    }

    public void move(char movement) {
        String mov = String.valueOf(movement);
        if (hasToWalkToNorth(mov)) {
            walkToNorth();
        } else if (hasToWalkToSouth(mov)) {
            walkToSouth();
        } else if (hasToWalkToEast(mov)) {
            walkToEast();
        } else if (hasToWalkToWest(mov)) {
            walkToWest();
        } else if (hasToRotateLeft(mov)) {
            rotateLeft();
        } else if (hasToRotateRight(mov)) {
            rotateRight();
        } else {
            throw new InvalidMovementException("Movement '" + movement + "' is not a valid movement.");
        }
    }

    private boolean canWalkToNorth() {
        if (coordinate.getY() + 1 > surface.getSizeY()) {
            throw new InvalidMovementException("Cannot walk to North, surface limit reached.");
        }
        return true;
    }

    private boolean canWalkToSouth() {
        if (coordinate.getY() - 1 < 0) {
            throw new InvalidMovementException("Cannot walk to South, surface limit reached.");
        }
        return true;
    }

    private boolean canWalkToEast() {
        if (coordinate.getX() + 1 > surface.getSizeX()) {
            throw new InvalidMovementException("Cannot walk to East, surface limit reached.");
        }
        return true;
    }

    private boolean canWalkToWest() {
        if (coordinate.getX() - 1 < 0) {
            throw new InvalidMovementException("Cannot walk to West, surface limit reached.");
        }
        return true;
    }

    public void walkToNorth() {
        if (canWalkToNorth()) {
            this.coordinate.incrementY(1);
            this.orientation = Orientation.NORTH;
        }
    }

    public void walkToSouth() {
        if (canWalkToSouth()) {
            this.coordinate.decrementY(1);
            this.orientation = Orientation.SOUTH;
        }
    }

    public void walkToEast() {
        if (canWalkToEast()) {
            this.coordinate.incrementX(1);
            this.orientation = Orientation.EAST;
        }
    }

    public void walkToWest() {
        if (canWalkToWest()) {
            this.coordinate.decrementX(1);
            this.orientation = Orientation.WEST;
        }
    }

    public void rotateLeft() {
        if (orientation == Orientation.NORTH) {
            orientation = Orientation.WEST;
        } else if (orientation == Orientation.WEST) {
            orientation = Orientation.SOUTH;
        } else if (orientation == Orientation.SOUTH) {
            orientation = Orientation.EAST;
        } else {
            orientation = Orientation.NORTH;
        }
    }

    public void rotateRight() {
        if (orientation == Orientation.NORTH) {
            orientation = Orientation.EAST;
        } else if (orientation == Orientation.EAST) {
            orientation = Orientation.SOUTH;
        } else if (orientation == Orientation.SOUTH) {
            orientation = Orientation.WEST;
        } else {
            orientation = Orientation.NORTH;
        }
    }

    private boolean hasToRotateRight(String movement) {
        return movement.equals(Movement.ROTATE_RIGHT.toString());
    }

    private boolean hasToRotateLeft(String movement) {
        return movement.equals(Movement.ROTATE_LEFT.toString());
    }


    private boolean hasToWalkToWest(String movement) {
        return movement.equals(Movement.MOVE_FORWARD.toString()) && orientation == Orientation.WEST;
    }

    private boolean hasToWalkToEast(String movement) {
        return movement.equals(Movement.MOVE_FORWARD.toString()) && orientation == Orientation.EAST;
    }

    private boolean hasToWalkToSouth(String movement) {
        return movement.equals(Movement.MOVE_FORWARD.toString()) && orientation == Orientation.SOUTH;
    }

    private boolean hasToWalkToNorth(String movement) {
        return movement.equals(Movement.MOVE_FORWARD.toString()) && orientation == Orientation.NORTH;
    }

    public String getPosition() {
        Position position = new Position(coordinate, orientation);
        position.setCoordinate(coordinate);
        position.setOrientation(orientation);
        return position.getFormattedPosition();
    }

    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Invalid Movement")
    public final class InvalidMovementException extends RuntimeException {
        InvalidMovementException(String s) {
            super(s);
        }
    }


    public final class InvalidCoordinatesException extends RuntimeException {}
}
