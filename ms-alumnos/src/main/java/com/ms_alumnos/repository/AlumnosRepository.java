package com.ms_alumnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms_alumnos.entity.Alumnos;

@Repository //anotacion que indica que esta es una clase "repositorio". Pertenece a los
//estereotipos de spring: @Component, @Repository, @Service, @Controller.
//@Repository funciona como un DAO. 
//En sí, los esteriotipos spring le indican a este framework que el se va a encargar de realizar el proceso de persistencia. Esto se llama Invercion de controlo (LoC).
public interface AlumnosRepository extends JpaRepository<Alumnos, Integer>{
	
	//Esta interface hereda de  JPARepository los métodos necesarios para persistir informacion en la BD
	
	//Si necesitaramos un query específica que no estuviera en JpaRepository la podemos declarar aquí.
	
	//Si se necesitan consultas específicas se deben declarar aqui a traves del pseudolenguaje JPQL. Se declara con @Query. Si no se necesita esto es todo lo que se determina en la caoa repository.
	

}
