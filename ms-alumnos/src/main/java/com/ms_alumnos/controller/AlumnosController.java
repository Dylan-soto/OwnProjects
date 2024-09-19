package com.ms_alumnos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms_alumnos.entity.Alumnos;
import com.ms_alumnos.logic.AlumnosLogic;
import com.ms_alumnos.request.AlumnosRequest;

@RestController
@RequestMapping ("alumnos")
public class AlumnosController {
	
	@Autowired
	AlumnosLogic service;
	
	@GetMapping("mostrar")
	public ResponseEntity <List<Alumnos>> mostrar (){
		List<Alumnos> lista = service.mostrar();
		return new ResponseEntity<List<Alumnos>> (lista, HttpStatus.OK);
	}
	@PostMapping("guardar")
	public ResponseEntity <Alumnos> guardar (@RequestBody AlumnosRequest request){
		Alumnos alumno = service.guardar(request);
		return new ResponseEntity<Alumnos>(alumno, HttpStatus.OK);
	}
	
	@PutMapping("editar")
	public ResponseEntity <Alumnos> editar (@RequestBody AlumnosRequest request){
		Alumnos alumno = service.editar(request);
		return new ResponseEntity<Alumnos>(alumno, HttpStatus.OK);
	}
	
	@GetMapping("buscar/{id}")
	public ResponseEntity <Alumnos> buscar (@PathVariable int id){
		Alumnos alumno = service.buscar(id);
		return new ResponseEntity<Alumnos>(alumno, HttpStatus.OK);
	}
	
	@DeleteMapping("eliminar/{id}")
	public ResponseEntity <String> eliminar (@PathVariable int id){
		String alumno = service.eliminar(id);
		return new ResponseEntity<String>(alumno, HttpStatus.OK);
	}
	@PatchMapping("inactivar/{id}")
	public ResponseEntity<String>inactivar(@PathVariable int id){
		String alumno=service.inactivar(id);
		return new ResponseEntity<String>(alumno, HttpStatus.OK);
	}

}
