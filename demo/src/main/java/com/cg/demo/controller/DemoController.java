package com.cg.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cg.demo.model.Demo;
import com.cg.demo.service.DemoService;

import java.util.List;

// import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/test")
    public String getMethodName() {
        return "Hello World";
    }

    @PostMapping("/add")
    public ResponseEntity<Demo> addMethodName(@RequestBody Demo demo) {
        return new ResponseEntity<>(demoService.addDemo(demo), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Demo> getMethodName(@PathVariable int id) {
        return new ResponseEntity<>(demoService.getDemoById(id), HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Demo>> getAllMethodName() {
        return new ResponseEntity<>(demoService.getAllDemos(), HttpStatus.OK);
    }
    

}
