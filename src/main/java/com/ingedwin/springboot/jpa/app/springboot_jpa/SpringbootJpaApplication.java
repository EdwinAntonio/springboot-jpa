package com.ingedwin.springboot.jpa.app.springboot_jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ingedwin.springboot.jpa.app.springboot_jpa.entities.Person;
import com.ingedwin.springboot.jpa.app.springboot_jpa.repositories.PersonRepository;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonRepository personRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//listas();
		findOne(2L);
	}

	public void findOne(Long id){
		/*
		 * En caso de retornar un Obtional<T> una forma alternativa sería con un operador ternario
		 * ejemplo:
		 * 
		 * person = personRepository.findById(id).isPresent() ? personRepository.findById(id).get() : null; 
		 * 
		 * o
		 * 
		 * Person person = personRepository.findById(id).orElseThrow();
		 * System.out.println(person.toString());
		 * 
		 */

		 personRepository.findById(id).ifPresent(System.out::println);

		 /*
		  * El metodo ifPresent(...) ejecuta la acción dentro de los paréntesis si el valor existe.
		  * en lugar de escribir un lambda como
		  *
		  * ifPresent(person -> System.out.println(person));
		  *
		  * usas la referencia directa al método println de esta manera
		  * 
		  * ifPresent(System.out::println);
		  */
	}

	public void listas(){
		//List<Person> personList = (List<Person>) personRepository.findAll();
		//List<Person> personList = (List<Person>) personRepository.buscarByProggramingAndName("Java","Andres");
		List<Person> personList = (List<Person>) personRepository
								.buscarByProggramingAndName("Java","Andres");

		// personList.stream().forEach(person -> {
		// 	System.out.println(person.toString());
		// });

		/*
		 * O sea que lo que va antes de :: es una referencia para la llamada a una clase, 
		 * hace el recorrido buscando el metodo que le estoy solicitando y hace el proceso
		 * 
		 * Si el metodo se encuentra en mi propia clase, uso el nombre de mi clase, pero si 
		 * se encuentra en otra, debo de usar la referencia a esa clase y despues pasarle el 
		 * metodo que quiero que ejecute, dependiendo si es static o no
		 * 
		 * Ejemplo:
		 * 
		 * public static void imprimirNombre(String nombre){...}
		 * 
		 * nombres.forEach(MainApp::imprimirNombre);  <----- Nombre de la clase directamente
		 * 
		 * o
		 * 
		 *  public void imprimirNombre(String nombre) {...}
		 * 
		 *  Printer app = new Printer();
		 *  nombres.forEach(app::imprimirNombre); <----- necesitas una instancia de la clase para referenciarlo.
		 * 
		 */

		personList.forEach(SpringbootJpaApplication::mensajeEnConsola);

		// List<Object[]> listObjects = personRepository.obtenerPersonData();
		// listObjects.stream().forEach(person ->{
		// 	System.out.println("Nombre de la persona:"+person[0]+"\nLenguaje: "+person[1]+"\n");
		// });

		// List<Object[]> listObjectsByName = personRepository.obtenerPersonDataByName("Andres");
		// listObjectsByName.stream().forEach(personName ->{
		// 	System.out.println("Nombre de la persona buscada: "+personName[0]);
		// });

		// List<Object[]> listObjectsByProgramming = personRepository.obtenerPersonDataByProgrammingLanguage("Java");
		// listObjectsByProgramming.stream().forEach(personProgram ->{
		// 	System.out.println("Nombre de la persona buscada: "+personProgram[0]);
		// });
	}

	public static void mensajeEnConsola(Person person){
		System.out.println("Nombre de la persona: "+person.getName());
	}

}
