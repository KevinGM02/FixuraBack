package com.Fixura.FixuraBackEnd.Service;

import java.util.List;

import com.Fixura.FixuraBackEnd.Model.Departamento;
import com.Fixura.FixuraBackEnd.Model.Distrito;
import com.Fixura.FixuraBackEnd.Model.Provincia;

public interface IdepartamentoService {
  public List<Departamento> Listar_departamento();
  public List<Provincia> Listar_provinvia(Integer id_depart);
  public List<Distrito> Listar_distrito(Integer id_depart, Integer id_prov);
} 
