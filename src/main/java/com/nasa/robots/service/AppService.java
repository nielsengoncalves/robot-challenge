package com.nasa.robots.service;

import com.nasa.robots.enums.Orientation;
import com.nasa.robots.model.Robot;
import com.nasa.robots.model.Surface;

public interface AppService {

    Robot createRobotOnSurface(Integer coordX, Integer coordY, Orientation orientation, Surface surface);

    Surface createSurface(Integer sizeX, Integer sizeY);

    String moveRobot(Robot robot, String movements);
}
