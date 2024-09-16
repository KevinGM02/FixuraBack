package com.Fixura.FixuraBackEnd.Repository;


import com.Fixura.FixuraBackEnd.Model.Usuario;

public interface IusuarioRepository {
  public int save(Usuario usuario);
  public Usuario login(Usuario usuario);
}
