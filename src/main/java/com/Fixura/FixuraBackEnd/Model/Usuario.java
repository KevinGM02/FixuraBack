package com.Fixura.FixuraBackEnd.Model;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class Usuario {
  String nombre;
  String dni;
  String correo;
  String contrasenia;
  String fotoPerfil;
  Timestamp tiempo_ban;
  int id_rol;
  int idDist;
}
