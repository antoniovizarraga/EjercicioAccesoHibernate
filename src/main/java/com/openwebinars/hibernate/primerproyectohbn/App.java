package com.openwebinars.hibernate.primerproyectohbn;

import java.util.Scanner;

import org.hibernate.SessionFactory;

/**
 * Hello world!
 */
public class App {

	// private static Accesobd

	public static void main(String[] args) {

		String nombre = "";
		String apellidos = "";
		int edad;
		int userInput = 0;
		int id;

		EntidadPersona persona = new EntidadPersona("Paco", "ElBelludo", 31);

		Scanner sc = new Scanner(System.in);

		System.out.println(ConsoleColors.YELLOW + "¡Bienvenido al CRUD de Personas en Java!" + ConsoleColors.RESET);
		System.out.println(ConsoleColors.GREEN + "⢀⡴⠑⡄⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \r\n" + "⠸⡇⠀⠿⡀⠀⠀⠀⣀⡴⢿⣿⣿⣿⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀ \r\n"
				+ "⠀⠀⠀⠀⠑⢄⣠⠾⠁⣀⣄⡈⠙⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀ \r\n" + "⠀⠀⠀⠀⢀⡀⠁⠀⠀⠈⠙⠛⠂⠈⣿⣿⣿⣿⣿⠿⡿⢿⣆⠀⠀⠀⠀⠀⠀⠀ \r\n"
				+ "⠀⠀⠀⢀⡾⣁⣀⠀⠴⠂⠙⣗⡀⠀⢻⣿⣿⠭⢤⣴⣦⣤⣹⠀⠀⠀⢀⢴⣶⣆ \r\n" + "⠀⠀⢀⣾⣿⣿⣿⣷⣮⣽⣾⣿⣥⣴⣿⣿⡿⢂⠔⢚⡿⢿⣿⣦⣴⣾⠁⠸⣼⡿ \r\n"
				+ "⠀⢀⡞⠁⠙⠻⠿⠟⠉⠀⠛⢹⣿⣿⣿⣿⣿⣌⢤⣼⣿⣾⣿⡟⠉⠀⠀⠀⠀⠀ \r\n" + "⠀⣾⣷⣶⠇⠀⠀⣤⣄⣀⡀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ \r\n"
				+ "⠀⠉⠈⠉⠀⠀⢦⡈⢻⣿⣿⣿⣶⣶⣶⣶⣤⣽⡹⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ \r\n" + "⠀⠀⠀⠀⠀⠀⠀⠉⠲⣽⡻⢿⣿⣿⣿⣿⣿⣿⣷⣜⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀ \r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣷⣶⣮⣭⣽⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀ \r\n" + "⠀⠀⠀⠀⠀⠀⣀⣀⣈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀ \r\n"
				+ "⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀ \r\n" + "⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀ \r\n" + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠻⠿⠿⠿⠿⠛⠉" + ConsoleColors.RESET);

		while (userInput != 5) {
			Menu();

			userInput = sc.nextInt();

			sc.nextLine();

			switch (userInput) {

			case 1:

				System.out.println("¿Quieres leer la tabla entera o quieres"
						+ "sólo leer los datos de una persona en específico?");
				System.out.println(
						"Escribe: \"0\" en el teclado si quieres leer todos los datos,"
						+ "o: \"1\" si quieres leer los datos de una persona en específico.");
				userInput = sc.nextInt();
				
				sc.nextLine();
				
				if(userInput == 0) {
					try {
						Accesobd.leerTodo();
					} catch (Exception e) {
						System.out.println(ConsoleColors.RED + "Error: No se pudo leer los datos de la tabla Persona." + ConsoleColors.RESET);
					}
				} else if(userInput == 1) {
					System.out.println("Escribe la ID de la persona de la cuál quieres recibir sus datos.");
					userInput = sc.nextInt();
					
					sc.nextLine();
					
					try {
						Accesobd.leer(userInput);
					} catch (Exception e) {
						System.out.println(ConsoleColors.RED + "Error: No se pudo leer los datos de la persona especificada en la tabla Persona." + ConsoleColors.RESET);
					}
				}
				
				break;
				
			case 2:
				
				System.out.println("Introduzca el nombre: ");
				nombre = sc.nextLine();

				System.out.println("Introduzca los apellidos: ");
				apellidos = sc.nextLine();

				System.out.println("Introduzca una edad: ");

				edad = sc.nextInt();

				sc.nextLine();

				persona.setNombre(nombre);
				persona.setApellidos(apellidos);
				persona.setEdad(edad);

				try {

					Accesobd.abrir();

					Accesobd.guardar(persona);
					
					System.out.println(ConsoleColors.GREEN + "Persona guardada correctamente." + ConsoleColors.RESET);

					// Accesobd.cerrar();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case 3:
				
				System.out.println("Introduzca la ID de la persona que quiera modificar.");
				
				id = sc.nextInt();
				
				sc.nextLine();
				
				System.out.println("Datos a editar:");
				System.out.println("Introduzca el nombre: ");
				nombre = sc.nextLine();

				System.out.println("Introduzca los apellidos: ");
				apellidos = sc.nextLine();

				System.out.println("Introduzca una edad: ");

				edad = sc.nextInt();

				sc.nextLine();

				try {
					Accesobd.actualizar(id, nombre, apellidos, edad);
				} catch (Exception e) {
					System.out.println(ConsoleColors.RED + "Error: No se pudo modificar la Persona." + ConsoleColors.RESET);
				}
				
				break;
			
			

			}
		}

		System.out.println(ConsoleColors.CYAN + "Saliendo del programa..." + ConsoleColors.RESET);
		

		sc.close();

	}

	private static void Menu() {
		System.out.println("1. Leer Personas.");
		System.out.println("2. Crear Personas.");
		System.out.println("3. Editar Persona.");
		System.out.println("4. Borrar Persona.");
		System.out.println("5. Salir.");
	}

}
