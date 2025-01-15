package com.openwebinars.hibernate.primerproyectohbn;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Persona")
public class EntidadPersona implements Serializable {
@Id
@GeneratedValue(strategy= GenerationType.IDENTITY) //La opción más usada con MySQL
@Column(name="ID")
private int idPersona;

@Column(name = "Nombre")
    private String nombre;
@Column(name = "Apellidos")
private String apellidos;
@Column(name = "Edad")
private int edad;
@Column(name = "Laboral")
private String laboral;

    public EntidadPersona(String nombre, String apellidos, int edad, String laboral) {
        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setLaboral(laboral);
    }

    public EntidadPersona() {

    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public String getLaboral() {
        return laboral;
    }

    public void setLaboral(String laboral) {
        this.laboral = laboral;
    }
}

