package com.services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dao.ClientesDAO;
import com.entity.Clientes;
import com.general.Status;

@Path ("clientes")
public class ClientesServices {
	
	Clientes cliente= null;
	ClientesDAO dao= null;
	
	@Path("mostrar")
	@GET
	@Produces ({MediaType.APPLICATION_JSON})
	//http://localhost:8090/CRUDHibernate_CLIENTES/CRUDHibernate_CLIENTES/clientes/mostrar
	public List<Clientes> mostrar (){
		dao=new ClientesDAO ();
		return dao.mostrar();
	}
	
	@Path("guardar")
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	//http://localhost:8090/CRUDHibernate_CLIENTES/CRUDHibernate_CLIENTES/clientes/guardar
	public Status guardar (Clientes c) {
		Status s= new Status();
		s.setOb(c);
		dao=new ClientesDAO();
		String resultado =dao.guardar(c);
		
		if (resultado.equals("1")) { 
		s.setMensaje("Se guardó un nuevo cliente");
		s.setRespuesta(resultado);
		}else {
			s.setMensaje("Hubo un error");
			s.setRespuesta(resultado);
		}
		return s;
		
	}
	@Path("eliminar/{id}")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	//http://localhost:8090/CRUDHibernate_CLIENTES/CRUDHibernate_CLIENTES/clientes/eliminar/id
	public Status eliminar (@PathParam("id") long id) {
		Status s= new Status();
		s.setOb(id);
		
		dao=new ClientesDAO();
		String resultado=dao.eliminar(id);
		
		if(resultado.equals("1")) {
			s.setMensaje("Se elmino el registro");
			s.setRespuesta(resultado);
		}else {
			s.setMensaje("Hubo un error");
			s.setRespuesta(resultado);
		}
		return s;
	}
	@Path ("editar")
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	//http:localhost:8090/CRUDHibernate_CLIENTES/CRUDHibernate_CLIENTES/clientes/editar
	public Status editar (Clientes c) {
		Status s=new Status ();
		s.setOb(c);
		
		dao=new ClientesDAO();
		String resultado=dao.editar(c);
		if(resultado.equals("1")) {
			s.setMensaje("Se actualizó el cliente correctamente");
			s.setRespuesta(resultado);
		}else {
			s.setMensaje("Hubo un error");
			s.setRespuesta(resultado);
		}
		return s;
	}
	
	@Path("buscar/{id}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	//http:localhost:8090/CRUDHibernate_CLIENTES/CRUDHibernate_CLIENTES/clientes/buscar/id
	public Clientes buscar(@PathParam ("id") long id) {

		dao=new ClientesDAO();
		return (Clientes)dao.buscar(id);
	}

}
