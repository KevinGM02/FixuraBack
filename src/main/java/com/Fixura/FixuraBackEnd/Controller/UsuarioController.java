package com.Fixura.FixuraBackEnd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fixura.FixuraBackEnd.Model.ServiceResponse;
import com.Fixura.FixuraBackEnd.Model.Usuario;
import com.Fixura.FixuraBackEnd.Repository.IusuarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {
  
  @Autowired
  private IusuarioRepository iusuarioRepository;

  @PostMapping(value="/save")
  public ResponseEntity<ServiceResponse> save(
    @RequestBody Usuario usuario
    ){

      ServiceResponse serviceResponse = new ServiceResponse();
      
      int result = iusuarioRepository.save(usuario);
      if(result == 1){
        serviceResponse.setMenssage("Usuario registrado correctamente");
      }

      return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
  }
  

}
