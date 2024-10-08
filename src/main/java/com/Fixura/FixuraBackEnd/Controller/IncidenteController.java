package com.Fixura.FixuraBackEnd.Controller;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import com.Fixura.FixuraBackEnd.Model.Incidente;
import com.Fixura.FixuraBackEnd.Model.ServiceResponse;
import com.Fixura.FixuraBackEnd.Service.IincidenteService;
import java.sql.Timestamp;
import java.text.ParseException;
@RestController
@RequestMapping("/api/incidente")
@CrossOrigin("*")
public class IncidenteController {
    @Autowired
	private IincidenteService iincidenteService;
    
    @GetMapping("/list/usuario/{id}")
	public ResponseEntity<List<Incidente>> list(@PathVariable String id){
        
		var result  = iincidenteService.Listar_incidente_usuario(id);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
    @GetMapping("/list/municipalidad/{id}")
	public ResponseEntity<List<Incidente>> list2(@PathVariable String id){
        
		var result  = iincidenteService.Listar_incidente_Municipalidad(id);
		return new ResponseEntity<>(result,HttpStatus.OK);
	}
    
    @PostMapping(value="/save")
	public ResponseEntity<ServiceResponse> save(@RequestParam("fecha_publicacion") String fecha_publicacion,
			@RequestParam("descripcion") String descripcion,
			@RequestParam("ubicacion") String ubicacion,
            @RequestParam("imagen") String  imagen,
			@RequestParam("total_votos") int total_votos,
            @RequestParam("id_estado") int id_estado,
            @RequestParam("DNI") String DNI,
            @RequestParam("id_categoria") int id_categoria
            ) throws IOException, ParseException{
			Incidente incidente= new Incidente();
		ServiceResponse serviceResponse = new ServiceResponse();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Timestamp timestamp = new Timestamp(dateFormat.parse(fecha_publicacion).getTime());
        incidente.setFecha_publicacion(timestamp);
		incidente.setDescripcion(descripcion);
		incidente.setUbicacion(ubicacion);
        incidente.setImagen(imagen);
		incidente.setTotal_votos(total_votos);
        incidente.setId_estado(id_estado);
        incidente.setDNI(DNI);
        incidente.setId_categoria(id_categoria);
		int result= iincidenteService.save(incidente);
		if(result==1) {
			serviceResponse.setMenssage("El producto se registro correctamente.");
			
		}
		return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
	}
    @PostMapping(value="/update_estado",consumes=MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> update(
			@RequestParam("id_incidencia") int id_incidencia,
			@RequestParam("id_estado") int id_estado)throws IOException{
            Incidente incidente= new Incidente();
		ServiceResponse serviceResponse = new ServiceResponse();
		incidente.setId_incidencia(id_incidencia);
        incidente.setId_estado(id_estado);
		int result= iincidenteService.update_estado(incidente);
		if(result==1) {
			serviceResponse.setMenssage("El incidente se modifico correctamente.");
		}
		return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
	}
    @PostMapping(value="/update_categoria",consumes=MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ServiceResponse> update2(
			@RequestParam("id_incidencia") int id_incidencia,
			@RequestParam("id_categoria") int id_categoria)throws IOException{
            Incidente incidente= new Incidente();
		ServiceResponse serviceResponse = new ServiceResponse();
		incidente.setId_incidencia(id_incidencia);
        incidente.setId_categoria(id_categoria);
		int result= iincidenteService.update_categoria(incidente);
		if(result==1) {
			serviceResponse.setMenssage("El incidente se modifico correctamente.");
		}
		return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
	}
    @DeleteMapping("/delete/{id}")
	public ResponseEntity<ServiceResponse> update(@PathVariable int id){
		ServiceResponse serviceResponse = new ServiceResponse();
		int result= iincidenteService.delete(id);
		if(result==1) {
			serviceResponse.setMenssage("El incidente se elimino correctamente.");
		}
		return new ResponseEntity<>(serviceResponse,HttpStatus.OK);
	}

}
