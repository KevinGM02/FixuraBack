package com.Fixura.FixuraBackEnd.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Fixura.FixuraBackEnd.Model.Distrito;

@Repository
public class DistritoRepository implements IdistritoRepository{

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<Distrito> Listar_distrito(Integer id_depart, Integer id_prov) {
    String SQL = "SELECT * FROM Distrito WHERE id_depart = '" + id_depart +"' AND id_prov = '"+ id_prov +"' ";
    return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Distrito.class));
  }
  
}
