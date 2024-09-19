package com.dto;

public class ObjetoDTO {
	
	//Aqui se mapea la info de tres tablas dsitintas de la BD
	
	private int clave;
	private String socio;
	private String libro;
	
	public ObjetoDTO () {}

	public ObjetoDTO(int clave, String socio, String libro) {
		super();
		this.clave = clave;
		this.socio = socio;
		this.libro = libro;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}

	public String getSocio() {
		return socio;
	}

	public void setSocio(String socio) {
		this.socio = socio;
	}

	public String getLibro() {
		return libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "ObjetoDTO [clave=" + clave + ", socio=" + socio + ", libro=" + libro + "]";
	}
	
	

}
