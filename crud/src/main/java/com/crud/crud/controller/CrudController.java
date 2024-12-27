
package com.crud.crud.controller;

import org.springframework.web.bind.annotation.RestController;

import com.crud.crud.model.Crud;
import com.crud.crud.service.CrudService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    private CrudService crudService;

    @GetMapping("/test")
    public ResponseEntity<String> getMethodName() {
        return new ResponseEntity<>("Testing", HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<String> addData(@RequestBody @Valid Crud crud) {
        return new ResponseEntity<>(crudService.create(crud), HttpStatus.OK);
    }
    
    @GetMapping("/read/{id}")
    public ResponseEntity<Crud> getData(@PathVariable int id) {
        return new ResponseEntity<>(crudService.read(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}/{address}")
    public ResponseEntity<Crud> updateData(@PathVariable @Valid int id, @PathVariable @Valid String address) {
        return new ResponseEntity<>(crudService.updateAddress(id, address), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteData(@PathVariable int id) {
        return new ResponseEntity<>(crudService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<Crud>> readAllData() {
        return new ResponseEntity<>(crudService.readAll(), HttpStatus.OK);
    }


}
