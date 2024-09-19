package com.general;

import java.util.List;

public interface IMetodos {

	public String guardar(Object ob);

	public String editar(Object ob);

	public String eliminar(long id);

	public Object buscar(long id);

	public List mostrar();

}
