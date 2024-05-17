package com.example.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Alien;

@Repository
public class AlienRepo {
    @Autowired
    private JdbcTemplate template;

    public void save(Alien alien) {
        System.out.println("Added");
        String sql = "insert into alien (id,name,tech) values (?,?,?)";
        int rows=template.update(sql, alien.getId(), alien.getName(), alien.getTech());
        System.out.println("Rows Affected "+rows);
    }

    public List<Alien> findAll() {
        String sql="select * from alien";

        // converting data that we get from firing a query from resultset to objects of alien class using RowMapper
        RowMapper<Alien> rowMapper=new RowMapper<Alien>() {
            @Override
            public Alien mapRow(ResultSet rs,int rowNum) throws SQLException{
                Alien a =new Alien();
                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));
                return a;
            }
        };

        List<Alien> aliens=template.query(sql,rowMapper);
        return aliens;
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}
