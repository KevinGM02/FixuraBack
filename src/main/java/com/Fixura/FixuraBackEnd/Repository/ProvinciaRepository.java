package com.Fixura.FixuraBackEnd.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.Fixura.FixuraBackEnd.Model.Provincia;

@Repository
public class ProvinciaRepository implements IprovinciaRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Provincia> Listar_provincia(Integer id_depart) {
        String SQL = "SELECT * FROM Provincia WHERE id_depart = '" + id_depart +"'";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Provincia.class));
    }
}
