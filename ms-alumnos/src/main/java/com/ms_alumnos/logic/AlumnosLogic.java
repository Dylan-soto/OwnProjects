package com.ms_alumnos.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms_alumnos.entity.Alumnos;
import com.ms_alumnos.exception.NoSePuedeEditarException;
import com.ms_alumnos.repository.AlumnosRepository;
import com.ms_alumnos.request.AlumnosRequest;
import com.ms_alumnos.service.AlumnoService;

@Service
public class AlumnosLogic implements AlumnoService {
	
	@Autowired
	AlumnosRepository dao;

	@Override
	public Alumnos guardar(AlumnosRequest request) {
		Alumnos alumno= new Alumnos();
		alumno.setNombre(request.getNombre());
		alumno.setFechaNac(request.getFechaNac());
		alumno.setGenero(request.getGenero());
		alumno.setGrado(request.getGrado());
		alumno.setStatus(1); 
		dao.save(alumno);
		return alumno;
	}

	@Override
	public Alumnos editar(AlumnosRequest request) throws NoSePuedeEditarException {
		Alumnos alumno=dao.findById(request.getAlumnoId()).get();
		if(alumno.getStatus()==1) {
		
		alumno.setNombre(request.getNombre());
		alumno.setFechaNac(request.getFechaNac());
		alumno.setGenero(request.getGenero());
		alumno.setGrado(request.getGrado());
		alumno.setStatus(1); 
		dao.save(alumno);
		}else {
			throw new NoSePuedeEditarException ("No se pudo editar al alumno. Esta dado de baja.");
		}
		return alumno;
	}

	@Override
	public Alumnos buscar(int id) {
		return dao.findById(id).get();
	}

	@Override
	public String eliminar(int id) {
		dao.deleteById(id);
		return "Registro eliminado correctamente";
	}

	@Override
	public List<Alumnos> mostrar() {
		
		return dao.findAll();
	}
	
	public String inactivar (int id) {
		Alumnos alumno = dao.findById(id).get();
		alumno.setStatus(0);
		dao.save(alumno);
		return "Alumno dado de baja correctamente";
	}

}
