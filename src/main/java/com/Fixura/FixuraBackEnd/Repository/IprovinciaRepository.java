package com.Fixura.FixuraBackEnd.Repository;

import java.util.List;

import com.Fixura.FixuraBackEnd.Model.Provincia;

public interface IprovinciaRepository {
  public List<Provincia> Listar_provincia(Integer id_depart);

}
