package com.crud.crud.service;

import java.util.List;

import com.crud.crud.model.Crud;

public interface CrudService {
    String create(Crud crud);
    Crud read(int id);
    Crud updateAddress(int id, String address);
    String delete(int id);
    List<Crud> readAll();
}
