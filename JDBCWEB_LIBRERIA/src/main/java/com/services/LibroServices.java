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

import com.dao.LibroDAO;
import com.entity.Libro;
import com.general.Status;

@Path("libros")
public class LibroServices {
	
	
	LibroDAO dao= null;
	
	
	
	@GET
	@Path("mostrar")
	@Produces({MediaType.APPLICATION_JSON})
	//http://localhost:8090/JDBCWEB_LIBRERIA/JDBCWEB_LIBRERIA/libros/mostrar
	public List<Libro> mostrar (){
		dao=new LibroDAO();
		return dao.mostrar();
	}
	@GET
	@Path("buscar/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	//http://localhost:8090/JDBCWEB_LIBRERIA/JDBCWEB_LIBRERIA/libros/buscar/id
	public Libro buscar (@PathParam ("id") int id) {
		dao=new LibroDAO();
		return (Libro) dao.buscar(id);
	}
	@DELETE
	@Path("eliminar/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	//http://localhost:8090/JDBCWEB_LIBRERIA/JDBCWEB_LIBRERIA/libros/eliminar/id
	public Status eliminar (@PathParam ("id") int id) {
		Status st= new Status();
		
		dao=new LibroDAO ();
		
		String response=dao.eliminar(id);
		if (response.equals("1")) {
			st.setMensaje("Socio eliminado exitosamente");
			st.setRespuesta(response);
		}else {
			st.setMensaje("Hubo un error");
			st.setRespuesta(response);
		}
		return st;
	}
	
	@PUT
	@Path("editar")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	//http://localhost:8090/JDBCWEB_LIBRERIA/JDBCWEB_LIBRERIA/libros/editar
	public Status editar (Libro lb) {
		
		Status st= new Status ();
		
		st.setOb(lb);
		
		dao=new LibroDAO();
		
		String response= dao.editar(lb);
		
		if (response.equals("1")) {
			st.setMensaje("Socio editado exitosamente");
			st.setRespuesta(response);
		}else {
			st.setMensaje("Hubo un error");
			st.setRespuesta(response);
		}
		
		return st;
		
	}
	@POST
	@Path("guardar")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	//http://localhost:8090/JDBCWEB_LIBRERIA/JDBCWEB_LIBRERIA/libros/editar
	public Status guardar (Libro lb) {
		
		Status st= new Status ();
		
		st.setOb(lb);
		
		dao=new LibroDAO();
		
		String response= dao.guardar(lb);
		
		if (response.equals("1")) {
			st.setMensaje("Socio guardado exitosamente");
			st.setRespuesta(response);
		}else {
			st.setMensaje("Hubo un error");
			st.setRespuesta(response);
		}
		
		return st;
		
	}
}
