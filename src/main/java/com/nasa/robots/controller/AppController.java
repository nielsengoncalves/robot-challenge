package com.nasa.robots.controller;

import com.nasa.robots.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class AppController {

    @Autowired
    private RobotService robotService;

    @RequestMapping(value = "/{movements}", method = RequestMethod.POST)
    public String move(@PathVariable String movements) {
        return robotService.walk(movements);
    }
}
