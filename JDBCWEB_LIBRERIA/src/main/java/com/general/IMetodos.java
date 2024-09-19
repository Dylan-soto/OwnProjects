package com.general;

import java.util.List;

public interface IMetodos {
	
	//Aqui declararemos las operaciones o metodos que la capa o clase de la implementacion (DAO) tendrá que resolver.

	public String guardar (Object ob);
	public String editar (Object ob);
	public String eliminar (int id); //dato tipo entero porque se utiliza el id (que es un numeri entero) para eliminar al cliente
	public Object buscar (int id); //por ser un objeto entero el que se va buscar se utiliza Object
	public List mostrar (); //Se utiliza una lista porque seran todos los clientes que se van a mostrar en pantalla

}
