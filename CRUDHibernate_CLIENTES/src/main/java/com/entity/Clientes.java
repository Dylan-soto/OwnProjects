package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class Clientes {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cid_auto")
	@SequenceGenerator(name="cid_auto", sequenceName="CLIENTES_SEQ", allocationSize =1) //allocationSize = 1 es importante para asegurarse de que Hibernate pida el próximo valor de la secuencia en cada inserción. 
	//Esto evitará que Hibernate reserve varios IDs en memoria antes de insertarlos.
	@Column(name="CLIENTE_ID", columnDefinition="NUMBER")
	private long clienteId;
	
	@Column(name="NOMBRE", columnDefinition="NVARCHAR2 (15)")
	private String nombre;
	
	@Column(name="DIRECCION", columnDefinition="NVARCHAR2 (40)")
	private String direccion;
	
	@Column(name="INE", columnDefinition="NVARCHAR2 (10)")
	private String ine;
	
	@Column(name="TELEFONO", columnDefinition="NVARCHAR2 (10)")
	private String telefono;
	
	public Clientes() {}

	public Clientes(long clienteId) {
		super();
		this.clienteId = clienteId;
	}

	public long getClienteId() {
		return clienteId;
	}

	public void setClienteId(long clienteId) {
		this.clienteId = clienteId;
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

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getIne() {
		return ine;
	}

	public void setIne(String ine) {
		this.ine = ine;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Clientes [clienteId=" + clienteId + ", nombre=" + nombre + ", direccion=" + direccion + ", ine=" + ine
				+ ", telefono=" + telefono + "]";
	}
	
	

}
