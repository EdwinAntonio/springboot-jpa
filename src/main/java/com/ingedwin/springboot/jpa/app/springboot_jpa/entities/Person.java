package com.ingedwin.springboot.jpa.app.springboot_jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "persons")
public class Person {

    /*
     * Cuando tenemos una composicion de palabras como en el caso de programmingLanguage, sql
     * crea la instancia con "_" o sea "programming_language" por tal motivo no va a reconover
     * la columna ya que se estructuran por defecto diferentes, así que usamos el Column para
     * especificar el nombre de la columna y evitar errores
     * 
     * Mucho cuidado de usar @ToString en entidades con relaciones tipo ManyToOne o OneToMany, etc
     * ya que podría causar recursiones infinitas, enese caso ponemos ToString(exclude="Notaciones") 
     * para evitar problemas
     * 
     * El Fetch ayuda a evitar cargar todas las direcciones automáticamente cada vez que consultas 
     * una persona. (Esto mejora mucho el rendimiento.)
     * @ManyToOne(fetch = FetchType.LAZY)
     * 
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;

    @Column(name = "programming_language") 
    private String programmingLanguage;
}
