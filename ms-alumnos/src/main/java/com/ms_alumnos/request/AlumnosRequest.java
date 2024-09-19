package com.ms_alumnos.request;

import java.time.LocalDateTime;

public class AlumnosRequest {
	
	//Esta capa o clase es un objeto POJO (Plain Old Java Object). Es para validacion de datos del exterior.
	
	private int alumnoId;
	private String nombre;
	private LocalDateTime fechaNac;
	private String genero;
	private String grado;
	private int status;
	
	public AlumnosRequest () {}

	public AlumnosRequest(int alumnoId, String nombre, LocalDateTime fechaNac, String genero, String grado,
			int status) {
		super();
		this.alumnoId = alumnoId;
		this.nombre = nombre;
		this.fechaNac = fechaNac;
		this.genero = genero;
		this.grado = grado;
		this.status = status;
	}

	public int getAlumnoId() {
		return alumnoId;
	}

	public void setAlumnoId(int alumnoId) {
		this.alumnoId = alumnoId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDateTime fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AlumnosRequest [alumnoId=" + alumnoId + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", genero="
				+ genero + ", grado=" + grado + ", status=" + status + "]";
	}
	
	
	

}
