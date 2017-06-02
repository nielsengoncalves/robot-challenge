package com.nasa.robots.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
            .build();
    }

    @Test
    public void shouldMoveRobotAcrossSurface() throws Exception {
        mockMvc.perform(post("/rest/mars/{movements}", "MMRMMRMM"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("(2, 0, S)"));
    }

    @Test
    public void shouldBeStateless() throws Exception {
        mockMvc.perform(post("/rest/mars/{movements}", "MML"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("(0, 2, W)"));

        mockMvc.perform(post("/rest/mars/{movements}", "MML"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("(0, 2, W)"));
    }

    @Test
    public void shouldHandleInvalidMovementsWithBadRequest() throws Exception {
        mockMvc.perform(post("/rest/mars/{movements}", "AAA"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldHandleMovementsOutOfSurfaceLimitsWithBadRequest() throws Exception {
        mockMvc.perform(post("/rest/mars/{movements}", "MMMMMMMMMMMMMMMMMMMMMMMM"))
                .andExpect(status().isBadRequest());
    }

}