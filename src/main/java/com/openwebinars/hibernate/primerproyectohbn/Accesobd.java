package com.openwebinars.hibernate.primerproyectohbn;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Accesobd {
	private static SessionFactory sf;
	private static Session sesion;
	private static Transaction transaction;

	protected static void setUp() {
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure() // por defecto: hibernate.cfg.xml
				.build();
		try {
			sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		
		

	}

	public static Session abrir() throws Exception {
		setUp();
		sesion = sf.openSession();
		transaction = sesion.beginTransaction();

		return sesion;
	}

	public static void cerrar() {
		try {
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
		sf.close();
	}



	public static void guardar(EntidadPersona persona) throws Exception {
		
		sesion = abrir();
		int id = (int) sesion.save(persona);
		transaction.commit();
		System.out.println(id);
		sf.close();
	}

	// Leer Persona
	public static void leer(int id) throws Exception {
		sesion = abrir();
		EntidadPersona persona = sesion.load(EntidadPersona.class, id);// PersonasEntity persona =
																		// session.get(PersonasEntity.class, id); //
																		// Esta línea también funcionaría como la
																		// anterior
		System.out.println(persona.getNombre());
		transaction.commit();
		cerrar();
	}
	
	// Leer Persona con todos sus datos
		public static void leerTodo() throws Exception {
			sesion = abrir();
			
			CriteriaBuilder cb = sesion.getCriteriaBuilder();
		    CriteriaQuery<EntidadPersona> cq = cb.createQuery(EntidadPersona.class);
		    Root<EntidadPersona> rootEntry = cq.from(EntidadPersona.class);
		    CriteriaQuery<EntidadPersona> all = cq.select(rootEntry);

		    TypedQuery<EntidadPersona> allQuery = sesion.createQuery(all);
			
		    
		    List<EntidadPersona> listado = allQuery.getResultList();
		    
			//List<EntidadPersona> listado = sesion.createQuery("SELECT * FROM Persona", EntidadPersona.class).getResultList();
			
			listado.forEach( (personaListado) -> {
				
				if(personaListado != null) {
					System.out.println("ID: " + Integer.toString(personaListado.getIdPersona()));
					System.out.println("Nombre: " + personaListado.getNombre());
					System.out.println("Apellidos: " + personaListado.getApellidos());
					System.out.println("Edad: " + Integer.toString(personaListado.getEdad()));
					System.out.println(ConsoleColors.BLACK + "-----------------------" + ConsoleColors.RESET);
				}
				

			} );
			
			

			cerrar();
		}
	
	

	// Actualizar Persona
	public static void actualizar(int id, String nombre, String apellidos, int Edad) throws Exception {
		sesion = abrir();
		EntidadPersona persona = sesion.get(EntidadPersona.class, id);
		persona.setNombre(nombre);
		persona.setApellidos(apellidos);
		persona.setEdad(Edad);
		// session.saveOrUpdate(persona); // session.merge(persona);
		sesion.update(persona);
		cerrar();
	}

	// Borrar persona
	public static void borrar(int id) throws Exception {
		sesion = abrir();	
		EntidadPersona persona = sesion.get(EntidadPersona.class, id);
		sesion.delete(persona);
		
		cerrar();
	}

}
