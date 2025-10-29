package com.ingedwin.springboot.jpa.app.springboot_jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ingedwin.springboot.jpa.app.springboot_jpa.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

    /*
     * Al momento implementar la clase de CrudRepository o JpaRepository, los parametros que debemos 
     * de enviarle como constructors son <Clase_Entity>,<Tipo_De_Dato_De_La_PrimaryKey> con la cual 
     * haremos el mapeo de los datos, y el tipo de dato de la primary key
     */

}
