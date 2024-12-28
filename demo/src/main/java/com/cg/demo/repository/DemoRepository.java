package com.cg.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.demo.model.Demo;

@Repository
public interface DemoRepository extends MongoRepository<Demo, Integer> {

}
