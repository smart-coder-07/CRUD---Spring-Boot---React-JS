package com.cg.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "demo")
@Data
public class Demo {
    @Id
    private int id;
    private String name;
    private String description;

}
