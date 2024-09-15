package com.Fixura.FixuraBackEnd.Repository;

import java.util.List;

import com.Fixura.FixuraBackEnd.Model.Distrito;

public interface IdistritoRepository {
  public List<Distrito> Listar_distrito(Integer id_prov, Integer id_depart);
} 
