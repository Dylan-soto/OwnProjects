package com.ms_alumnos.service;

import java.util.List;

import com.ms_alumnos.entity.Alumnos;
import com.ms_alumnos.exception.NoSePuedeEditarException;
import com.ms_alumnos.request.AlumnosRequest;

public interface AlumnoService {
	
	//Aquí van los métodos que la clase implementacion tendrá que resolver.
	
	public Alumnos guardar (AlumnosRequest request);
	
	public Alumnos editar (AlumnosRequest request) throws NoSePuedeEditarException;
	
	public Alumnos buscar (int id);
	
	public String eliminar (int id);
	
	public List<Alumnos> mostrar();

}
