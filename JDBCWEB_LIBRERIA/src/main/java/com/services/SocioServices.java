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

import com.dao.SocioDAO;
import com.dto.ObjetoDTO;
import com.entity.Socio;
import com.general.Status;

@Path("socios")
public class SocioServices {
	
	SocioDAO dao=null;
	
	@GET
	@Path("mostrar")
	@Produces({MediaType.APPLICATION_JSON})
	//http://localhost:8090/JDBCWEB_LIBRERIA/JDBCWEB_LIBRERIA/socios/mostrar
	public List<Socio>mostrar (){
		
		dao=new SocioDAO();
		
		return dao.mostrar();	
	}
	
	@GET
	@Path ("buscar/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	//http://localhost:8090/JDBCWEB_LIBRERIA/JDBCWEB_LIBRERIA/socios/buscar/id
	public Socio buscar (@PathParam ("id") int id) {
	dao= new SocioDAO();
	return (Socio) dao.buscar(id);
	}
	
	@PUT
	@Path("editar")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	//http://localhost:8090/JDBCWEB_LIBRERIA/JDBCWEB_LIBRERIA/socios/editar
	public Status editar (Socio s){
		
		//Uso de Objeto Status para responder entre servicio y backend
		Status st= new Status();
		st.setOb(s);
		
		//Iniciación del DAO
		dao=new SocioDAO();
		
		String response = dao.editar(s);//Recordar, si el socio se guarda nos devuelve "1"
		
		//Con esa respuesta procedemos a hacer una validación:
		
		
		if (response.equals("1")) {
			st.setMensaje("Socio editado exitosamente");
			st.setRespuesta(response);
		}else {
			st.setMensaje("Hubo un error");
			st.setRespuesta(response);
		}
		return st;
	}
	
	@POST //verbo http utilizado para la creación de recursos
	@Path("guardar")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	//http://localhost:8090/JDBCWEB_LIBRERIA/JDBCWEB_LIBRERIA/socios/guardar
	public Status guardar (Socio s){
		
		//Uso de Objeto Status para responder entre servicio y backend
		Status st= new Status();
		st.setOb(s);
		
		//Iniciación del DAO
		dao=new SocioDAO();
		
		String response = dao.guardar(s);//Recordar, si el socio se guarda nos devuelve "1"
		
		//Con esa respuesta procedemos a hacer una validación:
		
		
		if (response.equals("1")) {
			st.setMensaje("Socio guardado exitosamente");
			st.setRespuesta(response);
		}else {
			st.setMensaje("Hubo un error");
			st.setRespuesta(response);
		}
		return st;
	}
	
	@DELETE //verbo http utilizado para la creación de recursos
	@Path ("eliminar/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	//http://localhost:8090/JDBCWEB_LIBRERIA/JDBCWEB_LIBRERIA/socios/eliminar/id
	public Status eliminar (@PathParam ("id") int id) {
		
		Status st= new Status();
		
		dao= new SocioDAO();
		
		String response = dao.eliminar(id); //SOLO se elimina usando el ID del socio
		
		if (response.equals("1")) {
			st.setMensaje("Socio eliminado exitosamente");
			st.setRespuesta(response);
		}else {
			st.setMensaje("Hubo un error");
			st.setRespuesta(response);
		}
		return st;
	}
	
	@GET
	@Path("prestamos")
	@Produces({MediaType.APPLICATION_JSON})
	//http://localhost:8090/JDBCWEB_LIBRERIA/JDBCWEB_LIBRERIA/socios/prestamos
	public List<ObjetoDTO>prestamos (){
		
		dao=new SocioDAO();
		
		return dao.prestamos();
	}


}
