package com.ingedwin.springboot.jpa.app.springboot_jpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
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

     List<Person> findByProgrammingLanguage(String programmingLanguage);

    /*
     * En caso de no quere usar los metodos ya definidos por nuestra clase abstracta padre que
     * configuramos al darle los parametros con el extends CrudRepository, entonces podemos crear
     * nuestros propios request con la notacion @Query, seguida de la peticion que haremos a la
     * DB
     * 
     * OJO, toda la peticion se tiene que hacer con las caracteristicas definidasde nuestra clase 
     * Entity, no sobre las tablas o estructura que estan en la DB
     * 
     * Siempre que queramos usar las clases de nuestra clase padre, podemos usar la palabra
     * findBy[Nombre_del_Campo_Entity]and/or[Nombre_del_Campo_Entity] y funcionaria igual que el
     * siguiente ejemplo del buscarByProggramingAndName, o sea
     * 
     * findByprogrammingLanguageAndName(...) <------ Este metodo sería lo mismo al siguiente 
     *                                               ejemplo si comenzamos con findBy[...]
     * 
     */

     /*
      * Los signos de interrogacion junto con los numeros ["=?1","=?2",...] dan a entenderle al
      * query que ahí es donde se asiganaran los valores que entran como atributos en el metodo
      * donde los numeros colocan el orden con el que vamos ingresando los parametros al metodo
      */

     @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2")
     List<Person> buscarByProggramingAndName(String programmingLanguage, String name);

     @Query("select p.name, p.programmingLanguage from Person p")
     List<Object[]> obtenerPersonData();

     @Query("select p.name from Person p where p.name=?1")
     List<Object[]> obtenerPersonDataByName(String name);

     @Query("select p.programmingLanguage from Person p where p.programmingLanguage=?1")
     List<Object[]> obtenerPersonDataByProgrammingLanguage(String programmingLanguage);

     /*
      * A diferencia de los metodos de arriba sirve cuando queremos recibir una lista de Objetos
      * mientras que los siguientes retornan solamente 1 elemento
      * 
      * En caso de usar la palabra reservada "like %?1%" hace una busqueda del campo de izq a der
      * para ver si algo conicide con esa entrada con los comodines de %
      */

     @Query("select p from Person p where p.id=?1")
     Optional<Person> findOne(Long id);

     @Query("select p from Person p where p.name=?1")
     Optional<Person> findOneName(String name);

     @Query("select p from Person p where p.name like %?1%")
     Optional<Person> findOneLikeName(String name);

     @Query("select concat(p.name, ' ' ,p.lastname) as fullName from Person p where p.id=?1")
     String getFullNameById(Long id);

}
