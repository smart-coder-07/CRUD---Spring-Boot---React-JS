package com.cg.demo.service;

import java.util.List;

import com.cg.demo.model.Demo;

public interface DemoService {
    Demo addDemo(Demo demo);
    Demo getDemoById(int id);
    List<Demo> getAllDemos();
}
