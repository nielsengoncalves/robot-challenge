package com.nasa.robots.enums;

public enum Movement {
    MOVE_FORWARD ('M'),
    ROTATE_LEFT ('L'),
    ROTATE_RIGHT ('R');

    private char movement;

    Movement(char movement) {
        this.movement = movement;
    }

    @Override
    public String toString() {
        return Character.toString(this.movement);
    }
}

