package com.nasa.robots.service.impl;

import com.nasa.robots.enums.Orientation;
import com.nasa.robots.model.Robot;
import com.nasa.robots.model.Surface;
import com.nasa.robots.service.AppService;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {

    @Override
    public Robot createRobotOnSurface(Integer coordX, Integer coordY, Orientation orientation, Surface surface) {
        return new Robot(coordX, coordY, orientation, surface);
    }

    @Override
    public Surface createSurface(Integer sizeX, Integer sizeY) {
        return new Surface(sizeX, sizeY);
    }

    @Override
    public String moveRobot(Robot robot, String movements) {
        robot.move(movements);
        return robot.getPosition();
    }
}
