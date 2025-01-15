package com.openwebinars.hibernate.primerproyectohbn;

import java.util.Scanner;

import org.hibernate.SessionFactory;

/**
 * Hello world!
 */
public class App {
	
	//private static Accesobd 
	
    public static void main(String[] args) {
    	
    	String nombre = "";
    	String apellidos = "";
    	int edad;
    	String laboral = "";
    	
    	EntidadPersona persona = new EntidadPersona("Paco", "ElBelludo", 31, "Desempleado");
    	
    	Scanner sc = new Scanner(System.in);
    	
    	
        System.out.println("Introduzca el nombre: ");
        nombre = sc.nextLine();
        
        System.out.println("Introduzca los apellidos: ");
        apellidos = sc.nextLine();
        
        
        
        System.out.println("Introduzca una edad: ");
        
        
        
        edad = sc.nextInt();
        
        sc.nextLine();
        
        System.out.println("Introduzca el laboral: ");
        laboral = sc.nextLine();
        
        
        persona.setNombre(nombre);
        persona.setApellidos(apellidos);
        persona.setEdad(edad);
        persona.setLaboral(laboral);
        
        Accesobd.guardar(persona);
        
        sc.close();
        
    }
    
    
    
}
