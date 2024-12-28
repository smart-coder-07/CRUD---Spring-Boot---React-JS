package com.cg.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.demo.model.Demo;
import com.cg.demo.repository.DemoRepository;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public Demo addDemo(Demo demo) {
        demo.setId((int) demoRepository.count() + 1);
        return demoRepository.save(demo);
    }

    @Override
    public Demo getDemoById(int id) {
        return demoRepository.findById(id).get();
    }

    @Override
    public List<Demo> getAllDemos() {
        return demoRepository.findAll();
    }


}
