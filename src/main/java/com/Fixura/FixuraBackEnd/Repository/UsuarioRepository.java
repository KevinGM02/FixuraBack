package com.Fixura.FixuraBackEnd.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.Fixura.FixuraBackEnd.Model.Usuario;

@Repository
public class UsuarioRepository implements IusuarioRepository{
  
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public int save(Usuario usuario) {
    String SQL = "INSERT INTO Usuario(nombre,dni,correo,contrasenia,fotoPerfil,tiempo_ban,id_rol,idDist) VALUES(?,?,?,?,?,?,?,?)";
    return jdbcTemplate.update(SQL, new Object[]{
      usuario.getNombre(), 
      usuario.getDni(), 
      usuario.getCorreo(), 
      usuario.getContrasenia(), 
      usuario.getFotoPerfil(), 
      usuario.getTiempo_ban(), 
      usuario.getId_rol(), 
      usuario.getIdDist()
    });
  }

  @Override
  public Usuario login(Usuario usuario) {
    String SQL = "SELECT * FROM Usuario WHERE correo = '" + usuario.getCorreo() + "' AND contrasenia = '" + usuario.getContrasenia() + "'";
    List<Usuario> users = jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Usuario.class));
    return users.isEmpty() ? null : users.get(0);
  }
}
