package com.nasa.robots.service.impl;

import com.nasa.robots.model.Coordinate;
import com.nasa.robots.service.RobotService;
import org.springframework.stereotype.Service;

@Service
public class RobotServiceImpl implements RobotService {


    private Integer sizeX;

    private Integer sizeY;

    private Coordinate position = new Coordinate(0,0);

    @Override
    public String walk(String movements) {
        return "(0,0,W)";
    }
}
