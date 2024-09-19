package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dto.ObjetoDTO;
import com.entity.Socio;
import com.general.Database;
import com.general.IMetodos;

public class SocioDAO implements IMetodos{
	
	//En esta clase se establece la lógica de acceso a datos (se dicta como se hace el CRUD)

		//Interfaces necesarias de java.sql:
	
	Connection con= null;
	PreparedStatement ps= null;
	ResultSet rs= null;
	
	//Creación de objeto Socio para manipularlo en la BD
	Socio s=null; 
	
	//Creación del objeto de la clase Database (importado de paquete general) para utilizar la info ahí contenida que nos permitirá
		//establecer la conexión con la BD:
	Database db=new Database ();
	
	//Declaración de String como respuesta de cada método.
	String resultado=null;
	
	
	@Override
	public String guardar(Object ob) {
		//Objeto a guardar= Socio
		s= (Socio) ob;
		
		//Petición SQL:
		String query= "INSERT INTO SOCIOS VALUES (?,?,?,?)";
		
		//Preparación del método para acceder a la BD:
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			ps= con.prepareStatement(query);
			
			//Establecimiento de valores para guardar un nuevo registro
			ps.setInt(1, 1);
			ps.setString(2, s.getNombre());
			ps.setString(3, s.getDireccion());
			ps.setLong(4, s.getTelefono());
			
			int flag = ps.executeUpdate(); //ps.executeUpdate devuelve un valor de 1. Se ejecuta la sentencia.
			if (flag == 1) {
				resultado= "1";
				System.out.println("Se ha guardado exitosamente al nuevo socio");
			}else {
				resultado = "0";
				System.out.println("Hubo un error");
		}
			
		} catch (Exception e) {
			resultado = e.getMessage();
		}
		
		return resultado;
	}

	@Override
	public String editar(Object ob) {
		
		s= (Socio) ob;
		
		String query= "UPDATE SOCIOS SET NOMBRE=?, DIRECCION=?, TELEFONO=? WHERE SOCIO_ID=?";
		
		try {
			Class.forName(db.getDriver());
			con= DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			
			ps.setString(1, s.getNombre());
			ps.setString(2, s.getDireccion());
			ps.setLong(3, s.getTelefono());
			ps.setInt(4, s.getSocioId());
			
			int flag=ps.executeUpdate();
			if (flag==1) {
				resultado="1";
				System.out.println("Socio actualizado exitosamente");
			}else {
				resultado="0";
				System.out.println("Hubo un error");
			}
		} catch (Exception e) {
			resultado=e.getMessage();
		}
	
		return resultado;
	}

	@Override
	public String eliminar(int id) {
		
		String query= "DELETE * FROM SOCIOS WHERE SOCIO_ID=" + id;
		
		try {
			Class.forName(db.getDriver());
			con= DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			
			int flag= ps.executeUpdate();
			if (flag==1) {
				resultado="1";
				System.out.println("Se eliminó al socio exitosamente");
				}else {
					resultado="0";
					System.out.println("Hubo un error");
					}
		} catch (Exception e) {
			resultado=e.getMessage();
		}
		return resultado;
	}

	@Override
	public Object buscar(int id) {
		
		String query="SELECT * FROM SOCIOS WHERE SOCIO_ID="+ id;
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while (rs.next()) { //Esto sognifica literalmente "mientras rs tenga un mensaje guardado:"
				s=new Socio (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public List mostrar() {
		
		
		String query= "SELECT * FROM SOCIOS";
		
		List <Socio>socios =new ArrayList<Socio>();

		try { 
			Class.forName(db.getDriver());
			con= DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			ps= con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while (rs.next()) {
				s= new Socio (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4));
				
				socios.add(s);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return socios;
	}
	
	//Para obtener info. de "SOCIOS" asociada con otras tablas dentro de la BD se utiliza el patron DTO para gestionar las sentencias JOINS para poder hacerlos.
	
	public List prestamos () {
		
		String query= "SELECT S.SOCIO_ID AS CLAVE, S.NOMBRE AS SOCIO,  " + //es importante dejar espacios antes del cierre de comillas
				"L. TITULO AS LIBRO FROM SOCIOS  S " + 
				"INNER JOIN PRESTAMOS P " + 
				"ON S.SOCIO_ID=P.SOCIO_ID " + 
				"INNER JOIN LIBROS L " + 
				"ON L.LIBRO_ID=P.LIBRO_ID"; //se quita ";" dentro de las comillas
		//se agrefa objetoDTO para recupera la info con una consulta y agregarlos a una lista
		
		ObjetoDTO fila=new ObjetoDTO();
		List <ObjetoDTO>prestamos= new ArrayList<ObjetoDTO>();
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			while (rs.next()) {
				fila=new ObjetoDTO(rs.getInt("CLAVE"), rs.getString("SOCIO"), rs.getString("LIBRO"));
				
				prestamos.add(fila);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return prestamos;
	}

}
