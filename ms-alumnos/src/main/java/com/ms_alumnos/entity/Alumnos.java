package com.ms_alumnos.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ALUMNOS")
public class Alumnos implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//La interfase serializable nos ayuda a descomponer y recomponer la info de un objeto en bits (en 1s y 0s).

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator= "aid_auto")
	@SequenceGenerator(name="aid_auto", sequenceName="ALUMNOS_SEQ", allocationSize=1)
	@Column(name="ALUMNO_ID", columnDefinition="NUMBER")
	private int alumnoId;
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2 (30)")
	private String nombre;
	@Column(name="FECHANAC", columnDefinition="DATE")
	private LocalDateTime fechaNac;
	@Column(name="GENERO", columnDefinition="NVARCHAR2 (20)")
	private String genero;
	@Column(name="GRADO", columnDefinition="NVARCHAR2 (30)")
	private String grado;
	@Column(name="STATUS", columnDefinition="NUMBER")
	private int status;
	
	public Alumnos () {}

	public Alumnos(int alumnoId) {
		super();
		this.alumnoId = alumnoId;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Alumnos [alumnoId=" + alumnoId + ", nombre=" + nombre + ", fechaNac=" + fechaNac + ", genero=" + genero
				+ ", grado=" + grado + ", status=" + status + "]";
	}
	
	

	}
	
	
	
