package com.entity;

public class Libro {
	
	private int libroId;
	private String titulo;
	private int autorId;
	private int copias;
	
	public Libro () {}

	public Libro(int libroId, String titulo, int autorId, int copias) {
		super();
		this.libroId = libroId;
		this.titulo = titulo;
		this.autorId = autorId;
		this.copias = copias;
	}

	public int getLibroId() {
		return libroId;
	}

	public void setLibroId(int libroId) {
		this.libroId = libroId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAutorId() {
		return autorId;
	}

	public void setAutorId(int autorId) {
		this.autorId = autorId;
	}

	public int getCopias() {
		return copias;
	}

	public void setCopias(int copias) {
		this.copias = copias;
	}

	@Override
	public String toString() {
		return "Libro [libroId=" + libroId + ", titulo=" + titulo + ", autorId=" + autorId + ", copias=" + copias + "]";
	}
	
	

}
