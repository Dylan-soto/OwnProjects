package com.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.entity.Clientes;
import com.general.IMetodos;

public class ClientesDAO implements IMetodos{
	
	//Carga objetos (definidos en el archivo persistence.xml)
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("Tables");
	
	//Carga CRUD
	EntityManager em= emf.createEntityManager();
	
	Clientes cliente=null;

	@Override
	public String guardar(Object ob) {
		cliente= (Clientes)ob;
		em.getTransaction().begin();
		
		String resultado=null;
		
		try {
			em.persist(cliente);
			em.getTransaction().commit();
			resultado="1";
			System.out.println("Registro completado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			resultado=e.getMessage();
			System.out.println("Hubo un error");
		}
		em.close();
		return resultado;
	}

	@Override
	public String editar(Object ob) {
		cliente=(Clientes)ob; //aqui se guarda la info insertada en el servidor web
		Clientes clientedb=em.find(Clientes.class, cliente.getClienteId()); //aqui se busca por primary key el objeto en la BD
		
		em.getTransaction().begin();
		
		String resultado=null;
		
		try {
			clientedb.setNombre(cliente.getNombre());
			clientedb.setDireccion(cliente.getDireccion());
			clientedb.setIne(cliente.getIne());
			clientedb.setTelefono(cliente.getTelefono());
			em.getTransaction().commit();
			resultado="1";
			System.out.println("Se actualizó correctamente al cliente");
			
		} catch (Exception e) {
			em.getTransaction().rollback();
			resultado=e.getMessage();
			System.out.println("Hubo un error");
		}
		em.close();
		return resultado;
	}

	@Override
	public String eliminar(long id) {
		String resultado=null;
		cliente = em.find(Clientes.class, id);
		
		em.getTransaction().begin();
		try {
			em.remove(cliente);
			em.getTransaction().commit();
			resultado="1";
			System.out.println("Cliente eliminado");
		} catch (Exception e) {
			em.getTransaction().rollback();
			resultado=e.getMessage();
			System.out.println("Hubo un error");
		}
		em.close();
		return resultado;
	}

	@Override
	public Object buscar(long id) {
		cliente=em.find(Clientes.class, id);
		//Al ser una operacion "lazy" se tiene que mantener abierta la operacion para que se ejecute correctamente
		return cliente;
	}

	@Override
	public List mostrar() {
		List<Clientes>lc=em.createQuery("from Clientes").getResultList();
		return lc;
	}}
