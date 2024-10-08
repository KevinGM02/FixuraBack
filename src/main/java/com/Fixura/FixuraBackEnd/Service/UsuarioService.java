package com.Fixura.FixuraBackEnd.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fixura.FixuraBackEnd.Model.Usuario;
import com.Fixura.FixuraBackEnd.Repository.UsuarioRepository;

@Service
public class UsuarioService implements IusuarioService{

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public int save(Usuario usuario) {
    int row;
    try {
      row = usuarioRepository.save(usuario);
    } catch (Exception e) {
      throw e;
    }
    return row;
  }

  @Override
  public Usuario login(Usuario usuario) {
    Usuario usuario2;
    try {
      usuario2 = usuarioRepository.login(usuario);
      System.err.println(usuario2);
    } catch (Exception e) {
      throw e;
    }
    return usuario2;
  }
  
}
