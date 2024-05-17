package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Alien;

@Repository
public class AlienRepo {

    public void add(Alien alien) {
        System.out.println("Added");
    }

    public List<Alien> findAll(){
        return new ArrayList<Alien>();
    }
}
