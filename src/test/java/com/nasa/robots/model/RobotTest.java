package com.nasa.robots.model;

import com.nasa.robots.enums.Orientation;
import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {

    private final Integer surfaceSize = 5;

    @Test
    public void shouldMoveAcrossSurface() throws Exception {
        Robot robot = createRobotOnBottomEdge(Orientation.NORTH);
        assertEquals("(0, 0, N)", robot.getPosition());
        robot.move("MMRMMRMM");
        assertEquals("(2, 0, S)", robot.getPosition());
    }

    @Test
    public void shouldMoveAcrossSurface2() throws Exception {
        Robot robot = createRobotOnBottomEdge(Orientation.NORTH);
        assertEquals("(0, 0, N)", robot.getPosition());
        robot.move("MML");
        assertEquals("(0, 2, W)", robot.getPosition());
    }

    @Test
    public void shouldWalkToNorthWhenOnCenter() throws Exception {
        Robot robot = createRobotOnCenter(Orientation.NORTH);
        robot.walkToNorth();
        assertEquals("(2, 3, N)", robot.getPosition());
    }

    @Test(expected=Robot.InvalidMovementException.class)
    public void shouldNotWalkToNorthWhenOnSurfaceLimit() throws Exception {
        Robot robot = createRobotOnTopEdge(Orientation.NORTH);
        robot.walkToNorth();
    }

    @Test
    public void shouldWalkToSouthWhenOnCenter() throws Exception {
        Robot robot = createRobotOnCenter(Orientation.NORTH);
        robot.walkToSouth();
        assertEquals("(2, 1, S)", robot.getPosition());
    }

    @Test(expected=Robot.InvalidMovementException.class)
    public void shouldNotWalkToSouthWhenOnSurfaceLimit() throws Exception {
        Robot robot = createRobotOnBottomEdge(Orientation.NORTH);
        robot.walkToSouth();
    }

    @Test
    public void shouldWalkToEastWhenOnCenter() throws Exception {
        Robot robot = createRobotOnCenter(Orientation.NORTH);
        robot.walkToEast();
        assertEquals("(3, 2, E)", robot.getPosition());
    }

    @Test(expected=Robot.InvalidMovementException.class)
    public void shouldNotWalkToEastWhenOnSurfaceLimit() throws Exception {
        Robot robot = createRobotOnTopEdge(Orientation.NORTH);
        robot.walkToEast();
    }

    @Test
    public void shouldWalkToWestWhenOnCenter() throws Exception {
        Robot robot = createRobotOnCenter(Orientation.NORTH);
        robot.walkToWest();
        assertEquals("(1, 2, W)", robot.getPosition());
    }

    @Test(expected=Robot.InvalidMovementException.class)
    public void shouldNotWalkToWestWhenOnSurfaceLimit() throws Exception {
        Robot robot = createRobotOnBottomEdge(Orientation.NORTH);
        robot.walkToWest();
    }

    @Test
    public void shouldBeWestOrientedAfterRotatingLeftFromNorth() throws Exception {
        Robot robot = createRobotOnCenter(Orientation.NORTH);
        assertEquals("(2, 2, N)", robot.getPosition());
        robot.rotateLeft();
        assertEquals("(2, 2, W)", robot.getPosition());
    }

    @Test
    public void shouldBeSouthOrientedAfterRotatingLeftFromWest() throws Exception {
        Robot robot = createRobotOnCenter(Orientation.WEST);
        assertEquals("(2, 2, W)", robot.getPosition());
        robot.rotateLeft();
        assertEquals("(2, 2, S)", robot.getPosition());
    }

    @Test
    public void shouldBeEastOrientedAfterRotatingLeftFromSouth() throws Exception {
        Robot robot = createRobotOnCenter(Orientation.SOUTH);
        assertEquals("(2, 2, S)", robot.getPosition());
        robot.rotateLeft();
        assertEquals("(2, 2, E)", robot.getPosition());
    }

    @Test
    public void shouldBeNorthOrientedAfterRotatingLeftFromEast() throws Exception {
        Robot robot = createRobotOnCenter(Orientation.EAST);
        assertEquals("(2, 2, E)", robot.getPosition());
        robot.rotateLeft();
        assertEquals("(2, 2, N)", robot.getPosition());
    }

    @Test
    public void rotateRight() throws Exception {
    }

    private Robot createRobotOnCenter(Orientation orientation) {
        Integer center = surfaceSize / 2;
        return new Robot(center, center, orientation, new Surface(surfaceSize, surfaceSize));
    }

    private Robot createRobotOnBottomEdge(Orientation orientation) {
        return new Robot(0, 0, orientation, new Surface(surfaceSize, surfaceSize));
    }

    private Robot createRobotOnTopEdge(Orientation orientation) {
        return new Robot(surfaceSize, surfaceSize, orientation, new Surface(surfaceSize, surfaceSize));
    }

}