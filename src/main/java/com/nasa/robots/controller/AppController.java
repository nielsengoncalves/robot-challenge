package com.nasa.robots.controller;

import com.nasa.robots.enums.Orientation;
import com.nasa.robots.model.Robot;
import com.nasa.robots.model.Surface;
import com.nasa.robots.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/rest/mars")
public class AppController {

    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @RequestMapping(value = "/{movements}", method = POST)
    public String move(@PathVariable String movements) {
        Surface surface = appService.createSurface(5, 5);
        Robot robot = appService.createRobotOnSurface(0, 0, Orientation.NORTH, surface);
        return appService.moveRobot(robot, movements);
    }
}
