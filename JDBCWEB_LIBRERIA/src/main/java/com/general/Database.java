package com.general;

public class Database {
	
	//Se encapsulará la información de acceso a base de datos
	private String driver= "oracle.jdbc.OracleDriver";
	private String url= "jdbc:oracle:thin:@localhost:1521:xe";
	private String usuario= "DylanISA";
	private String password= "admin";
	
	// AQUÍ NO HAY CONSTRUCTOR VACIO 
	//se eliminan los atributos o argumentos en esta linea para ya no volver a escribir
			//la informacion posteriormente. FUNCIONA COMO CONSTRUCTOR MIXTO: que permite iniciar un objeto Database vacio, pero del cual puedo recuperar
			//la info guardada en esta clase.
	public Database() {
		super();
		this.driver = driver;
		this.url = url;
		this.usuario = usuario;
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Database [driver=" + driver + ", url=" + url + ", usuario=" + usuario + ", password=" + password + "]";
	}
	
	
	
	

}
