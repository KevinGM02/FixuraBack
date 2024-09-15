package com.Fixura.FixuraBackEnd.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Fixura.FixuraBackEnd.Model.Departamento;
import com.Fixura.FixuraBackEnd.Model.Distrito;
import com.Fixura.FixuraBackEnd.Model.Provincia;
import com.Fixura.FixuraBackEnd.Repository.IdepartamentoRepository;
import com.Fixura.FixuraBackEnd.Repository.IdistritoRepository;
import com.Fixura.FixuraBackEnd.Repository.IprovinciaRepository;

@Service
public class DepartamentoService implements IdepartamentoService{

  @Autowired
  private IdepartamentoRepository idepartamentoRepository;

  @Autowired
  private IprovinciaRepository iprovinciaRepository;
  
  @Autowired
  private IdistritoRepository idistritoRepository;

  @Override
  public List<Departamento> Listar_departamento() {
    List<Departamento> list;
    try {
      list = idepartamentoRepository.Listar_departamento();
    } catch (Exception e) {
      throw e;
    }
    return list;
  }

  @Override
  public List<Provincia> Listar_provinvia(Integer id_depart) {
    List<Provincia> list;
    try {
      list = iprovinciaRepository.Listar_provincia(id_depart);
    } catch (Exception e) {
      throw e;
    }
    return list;
  }

  @Override
  public List<Distrito> Listar_distrito(Integer id_depart, Integer id_prov) {
    List<Distrito> list;
    try{
      list = idistritoRepository.Listar_distrito(id_depart, id_prov);
    }catch (Exception e) {
      throw e;
    }
    return list;
  }
  
}
