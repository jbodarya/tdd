package com.example.demo.repo;

import com.example.demo.pojo.Data;
import org.springframework.stereotype.Repository;

@Repository
public class Crud{

    public static Data getData(){
        Data data = new Data();
        data.setValue("21");
        return data;
    }

}
