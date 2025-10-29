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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastname;

    /*
     * Cuando tenemos una composicion de palabras como en el caso de programmingLanguage, sql
     * crea la instancia con "_" o sea "programming_language" por tal motivo no va a reconover
     * la columna ya que se estructuran por defecto diferentes, así que usamos el Column para
     * especificar el nombre de la columna y evitar errores
     */

    @Column(name = "programming_languaje") 
    private String programmingLanguage;
}
