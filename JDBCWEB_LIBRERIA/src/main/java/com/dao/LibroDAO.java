package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Libro;
import com.general.Database;
import com.general.IMetodos;

public class LibroDAO implements IMetodos{
	
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	
	Libro lb=null;
	
	Database db=new Database ();
	
	String resultado=null;
	

	@Override
	public String guardar(Object ob) {
		
		lb = (Libro) ob;
		
		String query="INSERT INTO LIBROS VALUES (?,?,?,?)";
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			
			ps.setInt(1, 1);
			ps.setString(2, lb.getTitulo());
			ps.setInt(3, lb.getAutorId());
			ps.setInt(4, lb.getCopias());
			
			int flag=ps.executeUpdate();
			if (flag==1) {
				resultado="1";
				System.out.println("Libro guardado exitosamente");
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
	public String editar(Object ob) {
		lb= (Libro) ob;
		
		String query= "UPDATE LIBROS SET TITULO=?, AUTOR_ID=?, NUM_COPIAS=? WHERE LIBRO_ID=?";
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			
			ps.setString(1, lb.getTitulo());
			ps.setInt(2, lb.getAutorId());
			ps.setInt(3, lb.getCopias());
			ps.setInt(4, lb.getLibroId());
			
			int flag=ps.executeUpdate();
			if(flag==1) {
				resultado="1";
				System.out.println("Libro editado exitosamente");
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
		
		String query="DELETE * FROM LIBROS WHERE LIBRO_ID="+ id;
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			
			int flag=ps.executeUpdate();
			if(flag==1) {
				resultado="1";
				System.out.println("Libro eliminado");
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
		
		String query="SELECT * FROM LIBROS WHERE LIBRO_ID="+ id;
		
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			
			while (rs.next()){
				lb=new Libro (rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lb;
	}

	@Override
	public List mostrar() {
		String query="SELECT * FROM LIBROS";
		List<Libro>libros= new ArrayList <Libro> ();
		try {
			Class.forName(db.getDriver());
			con=DriverManager.getConnection(db.getUrl(), db.getUsuario(), db.getPassword());
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			
			
			while (rs.next()){
				lb=new Libro (rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
				
				libros.add(lb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return libros;
		
	}
	

}
