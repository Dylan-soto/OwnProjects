package com.entity;

public class Socio {
	
	private int socioId;
	private String nombre;
	private String direccion;
	private long telefono;
	
	public Socio ()
	{}

	public Socio(int socioId, String nombre, String direccion, long telefono) {
		super();
		this.socioId = socioId;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getSocioId() {
		return socioId;
	}

	public void setSocioId(int socioId) {
		this.socioId = socioId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String domicilio) {
		this.direccion = domicilio;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Socio [socioId=" + socioId + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + "]";
	}

	
	
	
}
