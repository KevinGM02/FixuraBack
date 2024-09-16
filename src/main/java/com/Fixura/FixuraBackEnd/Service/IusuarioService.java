package com.Fixura.FixuraBackEnd.Service;

import com.Fixura.FixuraBackEnd.Model.Usuario;


public interface IusuarioService {
  public int save(Usuario usuario);
  public Usuario login(Usuario usuario);
}
