package com.crud.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.crud.model.Crud;

@Repository
public interface CrudRepo extends JpaRepository<Crud, Integer> {


}
