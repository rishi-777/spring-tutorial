package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Alien;

@Repository
public class AlienRepo {
    @Autowired
    private JdbcTemplate template;

    public void add(Alien alien) {
        System.out.println("Added");
        String sql = "insert into alien (id,name,tech) values (?,?,?)";
        template.update(sql, alien.getId(), alien.getName(), alien.getTech());
    }

    public List<Alien> findAll() {
        return new ArrayList<Alien>();
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}
