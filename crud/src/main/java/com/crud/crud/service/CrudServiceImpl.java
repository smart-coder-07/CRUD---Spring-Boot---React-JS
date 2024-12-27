package com.crud.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.crud.exception.CrudException;
import com.crud.crud.model.Crud;
import com.crud.crud.repository.CrudRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CrudServiceImpl implements CrudService {

    @Autowired
    private CrudRepo crudRepository;

    @Override
    public String create(Crud crud) {
        if (crud != null) {
            crudRepository.save(crud);
            return "create";
        }
        else {
            throw new CrudException("Crud object is null");
        }
       
    }

    @Override
    public Crud read(int id) throws CrudException {
        return crudRepository.findById(id).orElseThrow(() -> new CrudException("Crud object not found"));

    }

    @Override
    public Crud updateAddress(int id, String address) throws CrudException {
        Crud crud = crudRepository.findById(id).orElseThrow(() -> new CrudException("Crud object not found"));
        crud.setAddress(address);
        return crudRepository.save(crud);
        
    }

    @Override
    public String delete(int id) {
        crudRepository.findById(id).orElseThrow(() -> new CrudException("Crud object not found"));
        crudRepository.deleteById(id);
        return "Object deleted successfully";
        
    }

    @Override
    public List<Crud> readAll() {
        return crudRepository.findAll();
    }

}
