package com.nasa.robots.controller;

import com.nasa.robots.enums.Orientation;
import com.nasa.robots.model.Robot;
import com.nasa.robots.model.Surface;
import com.nasa.robots.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/rest/mars")
public class AppController {

    @Autowired
    private AppService appService;

    @Autowired
    @Value("${nasa.robot.start-x}")
    private Integer robotOriginX;

    @Autowired
    @Value("${nasa.robot.start-x}")
    private Integer robotOriginY;

    @Autowired
    @Value("${nasa.surface.size}")
    private Integer surfaceSize;

    @RequestMapping(value = "/{movements}", method = POST)
    public String move(@PathVariable String movements) {
        Surface surface = appService.createSurface(surfaceSize, surfaceSize);
        Robot robot = appService.createRobotOnSurface(robotOriginX, robotOriginY, Orientation.NORTH, surface);
        return appService.moveRobot(robot, movements);
    }
}
